package com.tencent.qqnt.chats.main.vm;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.CallSuper;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IPublicAccountPluginApi;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.core.mvi.a;
import com.tencent.qqnt.chats.core.uievent.a;
import com.tencent.qqnt.chats.core.uistate.a;
import com.tencent.qqnt.chats.core.userintent.a;
import com.tencent.qqnt.chats.core.userintent.b;
import com.tencent.qqnt.chats.data.c;
import com.tencent.qqnt.chats.main.helper.ChatsUpdateFreControlHelper;
import com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo;
import com.tencent.qqnt.chats.main.vm.usecase.BusEventUseCase;
import com.tencent.qqnt.chats.main.vm.usecase.ItemClickUseCase;
import com.tencent.qqnt.chats.main.vm.usecase.click.b;
import com.tencent.qqnt.chats.utils.b;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.CustomWithdrawConfig;
import com.tencent.qqnt.kernel.nativeinterface.DownloadRelateEmojiResultInfo;
import com.tencent.qqnt.kernel.nativeinterface.EmojiNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.EmojiResourceInfo;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupFileListResult;
import com.tencent.qqnt.kernel.nativeinterface.GroupItem;
import com.tencent.qqnt.kernel.nativeinterface.HitRelatedEmojiWordsResult;
import com.tencent.qqnt.kernel.nativeinterface.IGetMiscDataCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.ImportOldDbMsgNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.InputStatusInfo;
import com.tencent.qqnt.kernel.nativeinterface.KickedInfo;
import com.tencent.qqnt.kernel.nativeinterface.MiscData;
import com.tencent.qqnt.kernel.nativeinterface.MiscKeyInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.MsgSetting;
import com.tencent.qqnt.kernel.nativeinterface.PopUpInfo;
import com.tencent.qqnt.kernel.nativeinterface.QueryUserSecQualityRsp;
import com.tencent.qqnt.kernel.nativeinterface.RecvdOrder;
import com.tencent.qqnt.kernel.nativeinterface.RelatedWordEmojiInfo;
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupFileResult;
import com.tencent.qqnt.kernel.nativeinterface.TempChatInfo;
import com.tencent.qqnt.kernel.nativeinterface.ax;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00d6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \u009d\u00012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u0005:\u0001\u001fB#\u0012\b\u0010\u009a\u0001\u001a\u00030\u0099\u0001\u0012\u0006\u00103\u001a\u00020/\u0012\u0006\u00109\u001a\u000204\u00a2\u0006\u0006\b\u009b\u0001\u0010\u009c\u0001J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u0006H\u0002J\u0019\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0003H\u0016J\b\u0010\u0018\u001a\u00020\u0006H\u0017J\b\u0010\u0019\u001a\u00020\u0006H\u0017J\b\u0010\u001a\u001a\u00020\u0006H\u0017J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0013H\u0017J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0013H\u0016J\b\u0010\u001e\u001a\u00020\u0013H\u0016J\b\u0010\u001f\u001a\u00020\u0006H\u0016J\b\u0010 \u001a\u00020\u0006H\u0017J\u0010\u0010!\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0013H\u0017J\b\u0010\"\u001a\u00020\u000bH\u0016J\u0010\u0010%\u001a\u00020\u00062\u0006\u0010$\u001a\u00020#H\u0016J\b\u0010&\u001a\u00020\u0006H\u0016J\b\u0010'\u001a\u00020\u0006H\u0016J \u0010.\u001a\u00020\u00062\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,H\u0016R\u001a\u00103\u001a\u00020/8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b&\u00100\u001a\u0004\b1\u00102R\u001a\u00109\u001a\u0002048\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u001d\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00020:8\u0006\u00a2\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\"\u0010G\u001a\u00020@8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\"\u0010N\u001a\u00020H8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR$\u0010V\u001a\u0004\u0018\u00010O8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\"\u0010^\u001a\u00020W8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\"\u0010f\u001a\u00020_8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\"\u0010n\u001a\u00020g8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bh\u0010i\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\"\u0010v\u001a\u00020o8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bp\u0010q\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR$\u0010~\u001a\u0004\u0018\u00010w8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bx\u0010y\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R*\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u007f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b'\u0010\u0080\u0001\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R)\u0010\u008c\u0001\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0086\u0001\u0010\u0087\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u0006\b\u008a\u0001\u0010\u008b\u0001R \u0010\u0092\u0001\u001a\u00030\u008d\u00018\u0004X\u0084\u0004\u00a2\u0006\u0010\n\u0006\b\u008e\u0001\u0010\u008f\u0001\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001R \u0010\u0098\u0001\u001a\u00030\u0093\u00018\u0004X\u0084\u0004\u00a2\u0006\u0010\n\u0006\b\u0094\u0001\u0010\u0095\u0001\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001\u00a8\u0006\u009e\u0001"}, d2 = {"Lcom/tencent/qqnt/chats/main/vm/ChatsListVM;", "Lcom/tencent/qqnt/chats/core/mvi/a;", "Lcom/tencent/qqnt/chats/core/uistate/b;", "Lcom/tencent/qqnt/chats/core/userintent/b;", "Lmw3/a;", "Lcom/tencent/qqnt/chats/utils/b$a;", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Y", "Lcom/tencent/qqnt/chats/data/b;", "data", "Lcom/tencent/qqnt/chats/core/uistate/a$b;", "y", "Landroidx/lifecycle/Lifecycle$State;", "state", "O", "N", "", "busiId", "", "f0", "(Ljava/lang/Integer;)Z", "userIntent", "M", "W", "V", "X", "isAccountChange", BdhLogUtil.LogTag.Tag_Req, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "b", "U", "T", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqnt/chats/core/uievent/b;", "event", "sendEventToChat", "g", "r", "", WadlProxyConsts.KEY_JUMP_URL, "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "Landroid/content/Context;", "context", "k", "Lcom/tencent/qqnt/chats/core/a;", "Lcom/tencent/qqnt/chats/core/a;", "B", "()Lcom/tencent/qqnt/chats/core/a;", "chatContext", "Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;", h.F, "Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;", "H", "()Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;", "recentContactRepo", "Landroidx/lifecycle/MutableLiveData;", "i", "Landroidx/lifecycle/MutableLiveData;", "L", "()Landroidx/lifecycle/MutableLiveData;", "_newLiveData", "Lcom/tencent/qqnt/chats/main/vm/usecase/e;", "j", "Lcom/tencent/qqnt/chats/main/vm/usecase/e;", "E", "()Lcom/tencent/qqnt/chats/main/vm/usecase/e;", "setMenuOperateUseCase", "(Lcom/tencent/qqnt/chats/main/vm/usecase/e;)V", "menuOperateUseCase", "Lcom/tencent/qqnt/chats/main/vm/usecase/ItemClickUseCase;", "Lcom/tencent/qqnt/chats/main/vm/usecase/ItemClickUseCase;", "getItemClickUseCase", "()Lcom/tencent/qqnt/chats/main/vm/usecase/ItemClickUseCase;", "b0", "(Lcom/tencent/qqnt/chats/main/vm/usecase/ItemClickUseCase;)V", "itemClickUseCase", "Lcom/tencent/qqnt/chats/main/vm/usecase/click/b;", "l", "Lcom/tencent/qqnt/chats/main/vm/usecase/click/b;", "getIClickUseCase", "()Lcom/tencent/qqnt/chats/main/vm/usecase/click/b;", "a0", "(Lcom/tencent/qqnt/chats/main/vm/usecase/click/b;)V", "iClickUseCase", "Lcom/tencent/qqnt/chats/main/vm/usecase/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/chats/main/vm/usecase/c;", "getRedDotDragUseCase", "()Lcom/tencent/qqnt/chats/main/vm/usecase/c;", "setRedDotDragUseCase", "(Lcom/tencent/qqnt/chats/main/vm/usecase/c;)V", "redDotDragUseCase", "Lcom/tencent/qqnt/chats/main/vm/usecase/b;", DomainData.DOMAIN_NAME, "Lcom/tencent/qqnt/chats/main/vm/usecase/b;", "getLongClickUseCase", "()Lcom/tencent/qqnt/chats/main/vm/usecase/b;", "setLongClickUseCase", "(Lcom/tencent/qqnt/chats/main/vm/usecase/b;)V", "longClickUseCase", "Lcom/tencent/qqnt/chats/main/vm/usecase/d;", "o", "Lcom/tencent/qqnt/chats/main/vm/usecase/d;", "getLifecycleUseCase", "()Lcom/tencent/qqnt/chats/main/vm/usecase/d;", "setLifecycleUseCase", "(Lcom/tencent/qqnt/chats/main/vm/usecase/d;)V", "lifecycleUseCase", "Lcom/tencent/qqnt/chats/main/vm/usecase/BusEventUseCase;", "p", "Lcom/tencent/qqnt/chats/main/vm/usecase/BusEventUseCase;", "getBusEventUseCase", "()Lcom/tencent/qqnt/chats/main/vm/usecase/BusEventUseCase;", "setBusEventUseCase", "(Lcom/tencent/qqnt/chats/main/vm/usecase/BusEventUseCase;)V", "busEventUseCase", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelMsgListener;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelMsgListener;", "D", "()Lcom/tencent/qqnt/kernel/nativeinterface/IKernelMsgListener;", "c0", "(Lcom/tencent/qqnt/kernel/nativeinterface/IKernelMsgListener;)V", "kernelListener", "", "Ljava/lang/Long;", "I", "()Ljava/lang/Long;", "e0", "(Ljava/lang/Long;)V", "seqId", ReportConstant.COSTREPORT_PREFIX, "Z", "P", "()Z", "d0", "(Z)V", "isNotifyChanged", "Landroid/os/Handler;", "t", "Landroid/os/Handler;", "J", "()Landroid/os/Handler;", "uiHandler", "Lcom/tencent/qqnt/chats/main/helper/ChatsUpdateFreControlHelper;", "u", "Lcom/tencent/qqnt/chats/main/helper/ChatsUpdateFreControlHelper;", "K", "()Lcom/tencent/qqnt/chats/main/helper/ChatsUpdateFreControlHelper;", "updateFreControlHelper", "Landroidx/lifecycle/LifecycleCoroutineScope;", "scope", "<init>", "(Landroidx/lifecycle/LifecycleCoroutineScope;Lcom/tencent/qqnt/chats/core/a;Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;)V", "v", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public class ChatsListVM extends com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> implements mw3.a, b.a {
    static IPatchRedirector $redirector_;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.chats.core.a chatContext;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IRecentContactRepo recentContactRepo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<com.tencent.qqnt.chats.core.uistate.b> _newLiveData;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.qqnt.chats.main.vm.usecase.e menuOperateUseCase;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ItemClickUseCase itemClickUseCase;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.chats.main.vm.usecase.click.b iClickUseCase;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.qqnt.chats.main.vm.usecase.c redDotDragUseCase;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.qqnt.chats.main.vm.usecase.b longClickUseCase;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.qqnt.chats.main.vm.usecase.d lifecycleUseCase;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private BusEventUseCase busEventUseCase;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IKernelMsgListener kernelListener;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Long seqId;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private boolean isNotifyChanged;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler uiHandler;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ChatsUpdateFreControlHelper updateFreControlHelper;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/qqnt/chats/main/vm/ChatsListVM$a", "Lcom/tencent/qqnt/chats/data/c$a;", "Lcom/tencent/qqnt/chats/data/b;", "data", "", "b", "", NotificationCompat.CATEGORY_ERROR, "", "msg", "onFail", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class a implements c.a<com.tencent.qqnt.chats.data.b> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatsListVM.this);
            }
        }

        @Override // com.tencent.qqnt.chats.data.c.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull com.tencent.qqnt.chats.data.b data) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) data);
            } else {
                Intrinsics.checkNotNullParameter(data, "data");
                ChatsListVM.this.K().o(ChatsListVM.this.y(data));
            }
        }

        @Override // com.tencent.qqnt.chats.data.c.a
        public void onFail(int err, @NotNull String msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, err, (Object) msg2);
            } else {
                Intrinsics.checkNotNullParameter(msg2, "msg");
                ChatsListVM.this.L().postValue(new a.C9591a(err, msg2));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chats/main/vm/ChatsListVM$b;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.main.vm.ChatsListVM$b, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/chats/main/vm/ChatsListVM$c", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "", "result", "", "errMsg", "", "onResult", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class c implements IOperateCallback {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
        public void onResult(int result, @Nullable String errMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, result, (Object) errMsg);
                return;
            }
            QLog.d("ChatsListVM", 1, "topChat, result->" + result + ", errMsg->" + errMsg);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\u0007\u001a\u00020\u00062\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/chats/main/vm/ChatsListVM$d", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelMsgListener;", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MiscData;", "Lkotlin/collections/ArrayList;", "dataList", "", "onMiscDataChanged", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class d implements IKernelMsgListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatsListVM.this);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onAddSendMsg(MsgRecord msgRecord) {
            ax.a(this, msgRecord);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onContactUnreadCntUpdate(HashMap hashMap) {
            ax.b(this, hashMap);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onCustomWithdrawConfigUpdate(CustomWithdrawConfig customWithdrawConfig) {
            ax.c(this, customWithdrawConfig);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onDraftUpdate(Contact contact, ArrayList arrayList, long j3) {
            ax.d(this, contact, arrayList, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onEmojiDownloadComplete(EmojiNotifyInfo emojiNotifyInfo) {
            ax.e(this, emojiNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onEmojiResourceUpdate(EmojiResourceInfo emojiResourceInfo) {
            ax.f(this, emojiResourceInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onFileMsgCome(ArrayList arrayList) {
            ax.g(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGrabPasswordRedBag(int i3, String str, int i16, RecvdOrder recvdOrder, MsgRecord msgRecord) {
            ax.h(this, i3, str, i16, recvdOrder, msgRecord);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGroupFileInfoAdd(GroupItem groupItem) {
            ax.i(this, groupItem);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGroupFileInfoUpdate(GroupFileListResult groupFileListResult) {
            ax.j(this, groupFileListResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGroupTransferInfoAdd(GroupItem groupItem) {
            ax.k(this, groupItem);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGroupTransferInfoUpdate(GroupFileListResult groupFileListResult) {
            ax.l(this, groupFileListResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onHitCsRelatedEmojiResult(DownloadRelateEmojiResultInfo downloadRelateEmojiResultInfo) {
            ax.m(this, downloadRelateEmojiResultInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onHitEmojiKeywordResult(HitRelatedEmojiWordsResult hitRelatedEmojiWordsResult) {
            ax.n(this, hitRelatedEmojiWordsResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onHitRelatedEmojiResult(RelatedWordEmojiInfo relatedWordEmojiInfo) {
            ax.o(this, relatedWordEmojiInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onImportOldDbProgressUpdate(ImportOldDbMsgNotifyInfo importOldDbMsgNotifyInfo) {
            ax.p(this, importOldDbMsgNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onInputStatusPush(InputStatusInfo inputStatusInfo) {
            ax.q(this, inputStatusInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onKickedOffLine(KickedInfo kickedInfo) {
            ax.r(this, kickedInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onLineDev(ArrayList arrayList) {
            ax.s(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onLogLevelChanged(long j3) {
            ax.t(this, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onMiscDataChanged(@Nullable ArrayList<MiscData> dataList) {
            boolean z16;
            MiscData miscData;
            String str;
            a.InterfaceC9585a interfaceC9585a;
            PopUpInfo popUpInfo;
            Object first;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dataList);
                return;
            }
            ax.u(this, dataList);
            boolean z17 = false;
            if (dataList != null && dataList.size() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                QLog.i("ChatsListVM", 1, "onMiscDataChanged datalist is zero");
                return;
            }
            PopUpInfo popUpInfo2 = null;
            if (dataList != null) {
                first = CollectionsKt___CollectionsKt.first((List<? extends Object>) dataList);
                miscData = (MiscData) first;
            } else {
                miscData = null;
            }
            if (miscData != null && (popUpInfo = miscData.popUpInfo) != null) {
                str = popUpInfo.content;
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            if (str.length() == 0) {
                z17 = true;
            }
            if (!z17) {
                if (miscData != null) {
                    popUpInfo2 = miscData.popUpInfo;
                }
                if (popUpInfo2 != null) {
                    if (Intrinsics.areEqual(ChatsListVM.this.I(), miscData.popUpInfo.seqId)) {
                        QLog.i("ChatsListVM", 1, "onMiscDataChanged popUpInfo seqId is " + ChatsListVM.this.I());
                        return;
                    }
                    if (!ChatsListVM.this.f0(Integer.valueOf((int) miscData.popUpInfo.busId))) {
                        QLog.i("ChatsListVM", 1, "onMiscDataChanged popUpInfo busId is " + miscData.popUpInfo.busId);
                        return;
                    }
                    ChatsListVM.this.d0(true);
                    ChatsListVM.this.e0(miscData.popUpInfo.seqId);
                    com.tencent.qqnt.aio.adapter.api.d parseXMLContent = ((IPublicAccountPluginApi) QRoute.api(IPublicAccountPluginApi.class)).parseXMLContent(str);
                    QLog.i("ChatsListVM", 1, "onMiscDataChanged xmlModel is " + parseXMLContent + ", isNotifyChanged: " + ChatsListVM.this.P());
                    if (parseXMLContent != null && (interfaceC9585a = ChatsListVM.this.f().get()) != null) {
                        interfaceC9585a.a(parseXMLContent.f(), parseXMLContent.a(), parseXMLContent.b(), parseXMLContent.c(), parseXMLContent.d(), parseXMLContent.e());
                        return;
                    }
                    return;
                }
            }
            QLog.i("ChatsListVM", 1, "onMiscDataChanged content isempty");
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgBoxChanged(ArrayList arrayList) {
            ax.v(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgDelete(Contact contact, ArrayList arrayList) {
            ax.w(this, contact, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgInfoListAdd(ArrayList arrayList) {
            ax.x(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgInfoListUpdate(ArrayList arrayList) {
            ax.y(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgQRCodeStatusChanged(int i3) {
            ax.z(this, i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgRecall(int i3, String str, long j3) {
            ax.A(this, i3, str, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgSecurityNotify(MsgRecord msgRecord) {
            ax.B(this, msgRecord);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgSettingUpdate(MsgSetting msgSetting) {
            ax.C(this, msgSetting);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgWithRichLinkInfoUpdate(ArrayList arrayList) {
            ax.D(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onNtFirstViewMsgSyncEnd() {
            ax.E(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onNtMsgSyncContactUnread() {
            ax.F(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onNtMsgSyncEnd() {
            ax.G(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onNtMsgSyncStart() {
            ax.H(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRecvMsg(ArrayList arrayList) {
            ax.I(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRecvMsgSvrRspTransInfo(long j3, Contact contact, int i3, int i16, String str, byte[] bArr) {
            ax.J(this, j3, contact, i3, i16, str, bArr);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRecvOnlineFileMsg(ArrayList arrayList) {
            ax.K(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRecvSysMsg(ArrayList arrayList) {
            ax.L(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRedTouchChanged() {
            ax.M(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRichMediaDownloadComplete(FileTransNotifyInfo fileTransNotifyInfo) {
            ax.N(this, fileTransNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRichMediaProgerssUpdate(FileTransNotifyInfo fileTransNotifyInfo) {
            ax.O(this, fileTransNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRichMediaUploadComplete(FileTransNotifyInfo fileTransNotifyInfo) {
            ax.P(this, fileTransNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onSearchGroupFileInfoUpdate(SearchGroupFileResult searchGroupFileResult) {
            ax.Q(this, searchGroupFileResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onSendMsgError(long j3, Contact contact, int i3, String str) {
            ax.R(this, j3, contact, i3, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onSysMsgNotification(int i3, long j3, long j16, boolean z16, ArrayList arrayList) {
            ax.S(this, i3, j3, j16, z16, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onTempChatInfoUpdate(TempChatInfo tempChatInfo) {
            ax.T(this, tempChatInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onUserChannelTabStatusChanged(boolean z16) {
            ax.U(this, z16);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onUserOnlineStatusChanged(boolean z16) {
            ax.V(this, z16);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onUserSecQualityChanged(QueryUserSecQualityRsp queryUserSecQualityRsp) {
            ax.W(this, queryUserSecQualityRsp);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onUserTabStatusChanged(ArrayList arrayList) {
            ax.X(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onlineStatusBigIconDownloadPush(int i3, long j3, String str) {
            ax.Y(this, i3, j3, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onlineStatusSmallIconDownloadPush(int i3, long j3, String str) {
            ax.Z(this, i3, j3, str);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45144);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 44)) {
            redirector.redirect((short) 44);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatsListVM(@NotNull LifecycleCoroutineScope scope, @NotNull com.tencent.qqnt.chats.core.a chatContext, @NotNull IRecentContactRepo recentContactRepo) {
        super(scope);
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(chatContext, "chatContext");
        Intrinsics.checkNotNullParameter(recentContactRepo, "recentContactRepo");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, scope, chatContext, recentContactRepo);
            return;
        }
        this.chatContext = chatContext;
        this.recentContactRepo = recentContactRepo;
        MutableLiveData<com.tencent.qqnt.chats.core.uistate.b> mutableLiveData = new MutableLiveData<>(C());
        this._newLiveData = mutableLiveData;
        this.menuOperateUseCase = new com.tencent.qqnt.chats.main.vm.usecase.e(chatContext.a(), recentContactRepo);
        this.itemClickUseCase = new ItemClickUseCase();
        this.redDotDragUseCase = new com.tencent.qqnt.chats.main.vm.usecase.c(recentContactRepo);
        this.longClickUseCase = new com.tencent.qqnt.chats.main.vm.usecase.b();
        this.lifecycleUseCase = new com.tencent.qqnt.chats.main.vm.usecase.d(chatContext.a());
        this.busEventUseCase = new BusEventUseCase(chatContext.a(), recentContactRepo);
        Handler handler = new Handler(Looper.getMainLooper());
        this.uiHandler = handler;
        this.updateFreControlHelper = new ChatsUpdateFreControlHelper(handler, mutableLiveData, chatContext, new Function1<com.tencent.qqnt.chats.core.uievent.b, Unit>() { // from class: com.tencent.qqnt.chats.main.vm.ChatsListVM$updateFreControlHelper$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatsListVM.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.qqnt.chats.core.uievent.b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull com.tencent.qqnt.chats.core.uievent.b it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                } else {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ChatsListVM.this.n(it);
                }
            }
        });
        recentContactRepo.o().b(new a());
    }

    private final void A() {
        this.recentContactRepo.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(final ChatsListVM this$0, int i3, String str, MiscData miscData) {
        String str2;
        boolean z16;
        PopUpInfo popUpInfo;
        PopUpInfo popUpInfo2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("ChatsListVM", 1, "getMiscDataVer2 result:" + i3 + ", errMsg: " + str + ",  miscData: " + miscData);
        if (i3 != 0) {
            QLog.i("ChatsListVM", 1, "getMiscDataVer2 result is not zero: " + i3);
            return;
        }
        Integer num = null;
        if (miscData != null && (popUpInfo2 = miscData.popUpInfo) != null) {
            str2 = popUpInfo2.content;
        } else {
            str2 = null;
        }
        if (str2 == null) {
            str2 = "";
        }
        if (str2.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.i("ChatsListVM", 1, "getMiscDataVer2 result: content isempty ");
            return;
        }
        if (miscData != null && (popUpInfo = miscData.popUpInfo) != null) {
            num = Integer.valueOf((int) popUpInfo.busId);
        }
        if (!this$0.f0(num)) {
            QLog.i("ChatsListVM", 1, "getMiscDataVer2 result busId is " + miscData.popUpInfo.busId);
            return;
        }
        final com.tencent.qqnt.aio.adapter.api.d parseXMLContent = ((IPublicAccountPluginApi) QRoute.api(IPublicAccountPluginApi.class)).parseXMLContent(str2);
        QLog.i("ChatsListVM", 1, "getMiscDataVer2 xmlModel is " + parseXMLContent);
        if (parseXMLContent != null) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.qqnt.chats.main.vm.d
                @Override // java.lang.Runnable
                public final void run() {
                    ChatsListVM.G(ChatsListVM.this, parseXMLContent);
                }
            }, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(ChatsListVM this$0, com.tencent.qqnt.aio.adapter.api.d it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        a.InterfaceC9585a interfaceC9585a = this$0.f().get();
        if (interfaceC9585a != null) {
            interfaceC9585a.a(it.f(), it.a(), it.b(), it.c(), it.d(), it.e());
        }
    }

    private final void N() {
        QLog.d("ChatsListVM", 1, "initKernelListener");
        this.kernelListener = new d();
        w e16 = f.e();
        if (e16 != null) {
            IKernelMsgListener iKernelMsgListener = this.kernelListener;
            Intrinsics.checkNotNull(iKernelMsgListener);
            e16.addMsgListener(iKernelMsgListener);
        }
        QLog.i("ChatsListVM", 1, "startMigration importDataLineMsg");
    }

    private final void O(Lifecycle.State state) {
        List<com.tencent.qqnt.chats.core.uievent.b> a16;
        Object a17 = this.lifecycleUseCase.a(this.chatContext.a(), state);
        if (Result.m482isFailureimpl(a17)) {
            a17 = null;
        }
        com.tencent.qqnt.chats.main.vm.usecase.result.a aVar = (com.tencent.qqnt.chats.main.vm.usecase.result.a) a17;
        if (aVar != null && (a16 = aVar.a()) != null) {
            Iterator<T> it = a16.iterator();
            while (it.hasNext()) {
                n((com.tencent.qqnt.chats.core.uievent.b) it.next());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(ChatsListVM this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.n(new a.b(false));
    }

    private final void Y() {
        this.recentContactRepo.getRecentContactList(new IOperateCallback() { // from class: com.tencent.qqnt.chats.main.vm.a
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                ChatsListVM.Z(i3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(int i3, String str) {
        QLog.d("ChatsListVM", 2, "refresh: err -> " + i3 + ", msg -> " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0058, code lost:
    
        if (r3.length() > 0) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean f0(Integer busiId) {
        boolean z16;
        boolean z17;
        JSONArray jSONArray;
        if (busiId != null && busiId.intValue() == 19367) {
            z16 = true;
        } else {
            z16 = false;
        }
        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("106213", "");
        QLog.d("ChatsListVM", 1, "showCommonAlertView: " + loadAsString);
        if (loadAsString.length() == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            return z16;
        }
        try {
            jSONArray = new JSONObject(loadAsString).optJSONArray("BusiIdList");
            if (jSONArray != null) {
            }
        } catch (Exception unused) {
        }
        jSONArray = null;
        if (jSONArray != null && jSONArray.length() != 0) {
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                int optInt = jSONArray.optInt(i3, -1);
                if (busiId != null && optInt == busiId.intValue()) {
                    z16 = true;
                }
            }
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final a.b y(final com.tencent.qqnt.chats.data.b data) {
        return (a.b) com.tencent.qqnt.chats.utils.h.f(com.tencent.qqnt.chats.utils.h.f355549a, "convertToState", false, new Function0<a.b>() { // from class: com.tencent.qqnt.chats.main.vm.ChatsListVM$convertToState$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) com.tencent.qqnt.chats.data.b.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a.b invoke() {
                List emptyList;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (a.b) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                List<g> c16 = com.tencent.qqnt.chats.data.b.this.c();
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                a.b bVar = new a.b(c16, emptyList, com.tencent.qqnt.chats.data.b.this.d(), com.tencent.qqnt.chats.data.b.this.e(), com.tencent.qqnt.chats.data.b.this.b());
                com.tencent.qqnt.chats.data.b bVar2 = com.tencent.qqnt.chats.data.b.this;
                bVar.j(bVar2.f());
                com.tencent.qqnt.chats.data.a a16 = bVar2.a();
                if (a16 == null) {
                    a16 = new com.tencent.qqnt.chats.data.a(0, 0L, false, false, false, 31, null);
                }
                bVar.i(a16);
                return bVar;
            }
        }, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final com.tencent.qqnt.chats.core.a B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.qqnt.chats.core.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.chatContext;
    }

    @NotNull
    public a.b C() {
        a.b y16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return (a.b) iPatchRedirector.redirect((short) 38, (Object) this);
        }
        com.tencent.qqnt.chats.data.b a16 = this.recentContactRepo.o().a();
        if (a16 == null || (y16 = y(a16)) == null) {
            return new a.b(null, null, false, false, 0, 31, null);
        }
        return y16;
    }

    @Nullable
    public final IKernelMsgListener D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (IKernelMsgListener) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.kernelListener;
    }

    @NotNull
    public final com.tencent.qqnt.chats.main.vm.usecase.e E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.qqnt.chats.main.vm.usecase.e) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.menuOperateUseCase;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final IRecentContactRepo H() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (IRecentContactRepo) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.recentContactRepo;
    }

    @Nullable
    public final Long I() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (Long) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this.seqId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final Handler J() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (Handler) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        return this.uiHandler;
    }

    @NotNull
    protected final ChatsUpdateFreControlHelper K() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (ChatsUpdateFreControlHelper) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        return this.updateFreControlHelper;
    }

    @NotNull
    public final MutableLiveData<com.tencent.qqnt.chats.core.uistate.b> L() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this._newLiveData;
    }

    @Override // com.tencent.qqnt.chats.core.mvi.a
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public void l(@NotNull com.tencent.qqnt.chats.core.userintent.b userIntent) {
        List<com.tencent.qqnt.chats.core.uievent.b> a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) userIntent);
            return;
        }
        Intrinsics.checkNotNullParameter(userIntent, "userIntent");
        if (!Intrinsics.areEqual(userIntent, b.a.f355081a)) {
            if (Intrinsics.areEqual(userIntent, b.i.f355089a)) {
                W();
                return;
            }
            if (Intrinsics.areEqual(userIntent, b.h.f355088a)) {
                V();
                return;
            }
            if (Intrinsics.areEqual(userIntent, b.c.f355083a)) {
                R(false);
                return;
            }
            if (Intrinsics.areEqual(userIntent, b.e.f355085a)) {
                U();
                return;
            }
            if (Intrinsics.areEqual(userIntent, b.j.f355090a)) {
                X();
                return;
            }
            if (Intrinsics.areEqual(userIntent, b.d.f355084a)) {
                T(false);
                return;
            }
            if (!Intrinsics.areEqual(userIntent, b.C9593b.f355082a)) {
                if (Intrinsics.areEqual(userIntent, b.g.f355087a)) {
                    T(true);
                    return;
                }
                if (Intrinsics.areEqual(userIntent, b.f.f355086a)) {
                    R(true);
                    return;
                }
                if (userIntent instanceof a.n) {
                    Y();
                    return;
                }
                if (userIntent instanceof a.C9592a) {
                    A();
                    return;
                }
                if (userIntent instanceof a.f) {
                    if (this.iClickUseCase != null) {
                        a.f fVar = (a.f) userIntent;
                        QLog.d("ChatsListVM", 1, "onItemClick isHiddenChat: " + fVar.c());
                        com.tencent.qqnt.chats.main.vm.usecase.click.b bVar = this.iClickUseCase;
                        if (bVar != null) {
                            bVar.invoke(new b.a(fVar.b(), fVar.a(), this.chatContext));
                            return;
                        }
                        return;
                    }
                    a.f fVar2 = (a.f) userIntent;
                    this.itemClickUseCase.g(fVar2.b(), fVar2.a(), this.chatContext);
                    com.tencent.qqnt.chats.api.b e16 = e();
                    if (e16 != null) {
                        e16.s(fVar2.b());
                    }
                    QLog.d("ChatsListVM", 1, "onItemClick: " + fVar2.c());
                    return;
                }
                Object obj = null;
                if (userIntent instanceof a.g) {
                    a.g gVar = (a.g) userIntent;
                    Object a17 = this.longClickUseCase.a(gVar.b(), gVar.a());
                    if (!Result.m482isFailureimpl(a17)) {
                        obj = a17;
                    }
                    com.tencent.qqnt.chats.main.vm.usecase.result.a aVar = (com.tencent.qqnt.chats.main.vm.usecase.result.a) obj;
                    if (aVar != null && (a16 = aVar.a()) != null) {
                        Iterator<T> it = a16.iterator();
                        while (it.hasNext()) {
                            n((com.tencent.qqnt.chats.core.uievent.b) it.next());
                        }
                    }
                    QLog.d("ChatsListVM", 1, "onLongClick: " + gVar.c());
                    return;
                }
                if (userIntent instanceof a.i) {
                    BuildersKt__Builders_commonKt.launch$default(h(), null, null, new ChatsListVM$handleIntent$3(this, userIntent, null), 3, null);
                    com.tencent.qqnt.chats.api.b e17 = e();
                    if (e17 != null) {
                        a.i iVar = (a.i) userIntent;
                        e17.q(iVar.b(), iVar.a());
                    }
                    a.i iVar2 = (a.i) userIntent;
                    QLog.d("ChatsListVM", 1, "OnMenuClick: " + iVar2.c() + ", clickId: " + iVar2.a());
                    return;
                }
                if (userIntent instanceof a.k) {
                    com.tencent.qqnt.chats.api.b e18 = e();
                    if (e18 != null) {
                        e18.i(((a.k) userIntent).a());
                    }
                    QLog.d("ChatsListVM", 1, "OnMenuOpen: " + ((a.k) userIntent).b());
                    return;
                }
                if (userIntent instanceof a.j) {
                    com.tencent.qqnt.chats.api.b e19 = e();
                    if (e19 != null) {
                        e19.j(((a.j) userIntent).a());
                    }
                    QLog.d("ChatsListVM", 1, "OnMenuClose: " + ((a.j) userIntent).b());
                    return;
                }
                if (userIntent instanceof a.h) {
                    a.h hVar = (a.h) userIntent;
                    this.redDotDragUseCase.a(hVar.b());
                    QLog.d("ChatsListVM", 1, "OnItemRedDotDrag " + hVar.c() + " dragType: " + hVar.a());
                    com.tencent.qqnt.chats.api.b e26 = e();
                    if (e26 != null) {
                        e26.b(hVar.b());
                        return;
                    }
                    return;
                }
                if (userIntent instanceof a.o) {
                    a.o oVar = (a.o) userIntent;
                    this.recentContactRepo.k(oVar.a(), oVar.b(), oVar.d(), oVar.c(), new c());
                    return;
                }
                if (userIntent instanceof a.c) {
                    a.c cVar = (a.c) userIntent;
                    this.recentContactRepo.e(cVar.a(), cVar.c(), cVar.b());
                } else if (userIntent instanceof a.b) {
                    a.b bVar2 = (a.b) userIntent;
                    this.recentContactRepo.j(bVar2.a(), bVar2.b());
                } else if (userIntent instanceof a.d) {
                    this.updateFreControlHelper.n();
                } else if (userIntent instanceof a.p) {
                    this.updateFreControlHelper.t();
                }
            }
        }
    }

    public final boolean P() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        return this.isNotifyChanged;
    }

    public boolean Q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Boolean) iPatchRedirector.redirect((short) 34, (Object) this)).booleanValue();
        }
        return false;
    }

    @CallSuper
    public void R(boolean isAccountChange) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, isAccountChange);
            return;
        }
        if (!this.recentContactRepo.c()) {
            z(isAccountChange);
            com.tencent.qqnt.chats.utils.b bVar = com.tencent.qqnt.chats.utils.b.f355541a;
            if (!bVar.c()) {
                bVar.b(this);
            }
        }
        O(Lifecycle.State.CREATED);
        if (Q()) {
            n(new a.b(true));
            this.uiHandler.postDelayed(new Runnable() { // from class: com.tencent.qqnt.chats.main.vm.b
                @Override // java.lang.Runnable
                public final void run() {
                    ChatsListVM.S(ChatsListVM.this);
                }
            }, 5000L);
        }
        this.busEventUseCase.h();
        this.updateFreControlHelper.i();
        N();
    }

    @CallSuper
    public void T(boolean isAccountChange) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, isAccountChange);
            return;
        }
        com.tencent.qqnt.chats.utils.b bVar = com.tencent.qqnt.chats.utils.b.f355541a;
        if (!bVar.c()) {
            bVar.f(this);
        }
        QLog.d("ChatsListVM", 1, "onDestroy------++");
        this.busEventUseCase.i();
        this.recentContactRepo.destroy();
        this.updateFreControlHelper.h();
        O(Lifecycle.State.DESTROYED);
        IKernelMsgListener iKernelMsgListener = this.kernelListener;
        if (iKernelMsgListener != null) {
            w e16 = f.e();
            if (e16 != null) {
                e16.removeMsgListener(iKernelMsgListener);
            }
            this.kernelListener = null;
        }
    }

    @CallSuper
    public void U() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this);
            return;
        }
        QLog.d("ChatsListVM", 1, "onKernelInitComplete");
        this.recentContactRepo.p();
        this.recentContactRepo.a();
    }

    @CallSuper
    public void V() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
        } else {
            this.updateFreControlHelper.q();
        }
    }

    @CallSuper
    public void W() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
            return;
        }
        this.updateFreControlHelper.r();
        this.lifecycleUseCase.a(this.chatContext.a(), Lifecycle.State.RESUMED);
        QLog.i("ChatsListVM", 1, "chatsListVM onResume-- isNotifyChanged: " + this.isNotifyChanged);
        if (this.isNotifyChanged) {
            g();
        }
    }

    @CallSuper
    public void X() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
        }
    }

    public final void a0(@Nullable com.tencent.qqnt.chats.main.vm.usecase.click.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) bVar);
        } else {
            this.iClickUseCase = bVar;
        }
    }

    @Override // com.tencent.qqnt.chats.utils.b.a
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this);
        } else {
            QLog.d("ChatsListVM", 1, "onKernelSessionCreated");
            this.recentContactRepo.p();
        }
    }

    public final void b0(@NotNull ItemClickUseCase itemClickUseCase) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) itemClickUseCase);
        } else {
            Intrinsics.checkNotNullParameter(itemClickUseCase, "<set-?>");
            this.itemClickUseCase = itemClickUseCase;
        }
    }

    public final void c0(@Nullable IKernelMsgListener iKernelMsgListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) iKernelMsgListener);
        } else {
            this.kernelListener = iKernelMsgListener;
        }
    }

    public final void d0(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, z16);
        } else {
            this.isNotifyChanged = z16;
        }
    }

    public final void e0(@Nullable Long l3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) l3);
        } else {
            this.seqId = l3;
        }
    }

    @Override // com.tencent.qqnt.chats.core.mvi.a
    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this);
            return;
        }
        MiscKeyInfo miscKeyInfo = new MiscKeyInfo();
        miscKeyInfo.primaryKey = "popUp";
        miscKeyInfo.secKey = "msgListSec";
        QLog.i("ChatsListVM", 1, "getMiscDataVer2 action---");
        w e16 = f.e();
        if (e16 != null) {
            e16.getMiscDataVer2(miscKeyInfo, new IGetMiscDataCallback() { // from class: com.tencent.qqnt.chats.main.vm.c
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetMiscDataCallback
                public final void onResult(int i3, String str, MiscData miscData) {
                    ChatsListVM.F(ChatsListVM.this, i3, str, miscData);
                }
            });
        }
    }

    @Override // com.tencent.qqnt.chats.core.mvi.a
    public /* bridge */ /* synthetic */ LiveData<com.tencent.qqnt.chats.core.uistate.b> j() {
        return this._newLiveData;
    }

    @Override // com.tencent.qqnt.chats.core.mvi.a
    public void k(@NotNull String jumpUrl, @NotNull BaseQQAppInterface app, @NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, this, jumpUrl, app, context);
            return;
        }
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(context, "context");
        QLog.i("ChatsListVM", 1, "handleActionUrl jumpUrl is " + jumpUrl);
        ((IPublicAccountPluginApi) QRoute.api(IPublicAccountPluginApi.class)).httpMqqJump(jumpUrl, app, context);
    }

    @Override // com.tencent.qqnt.chats.core.mvi.a
    public void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this);
            return;
        }
        MiscData miscData = new MiscData();
        MiscKeyInfo miscKeyInfo = new MiscKeyInfo();
        miscKeyInfo.primaryKey = "popUp";
        miscKeyInfo.secKey = "msgListSec";
        miscData.popUpInfo = null;
        miscData.keyInfo = miscKeyInfo;
        this.isNotifyChanged = false;
        QLog.i("ChatsListVM", 1, "setMiscDataVer2 action--, , isNotifyChanged: false");
        w e16 = f.e();
        if (e16 != null) {
            e16.setMiscDataVer2(miscData, null);
        }
    }

    @Override // mw3.a
    public void sendEventToChat(@NotNull com.tencent.qqnt.chats.core.uievent.b event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, (Object) event);
        } else {
            Intrinsics.checkNotNullParameter(event, "event");
            n(event);
        }
    }

    public void z(boolean isAccountChange) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, isAccountChange);
            return;
        }
        this.recentContactRepo.create();
        if (!isAccountChange) {
            this.recentContactRepo.getRecentContactList(null);
        }
    }
}
