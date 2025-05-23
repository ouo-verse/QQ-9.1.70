package com.tencent.guild.aio.msglist.markdown;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.Patterns;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.constants.Constants;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.android.androidbypass.enhance.inlinekeyboard.view.InlineBtnView;
import com.tencent.android.androidbypass.span.ClickableUrlSpan;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.guild.aio.msglist.holder.component.s;
import com.tencent.guild.aio.msglist.markdown.GuildMarkDownContentComponent;
import com.tencent.guild.aio.msglist.markdown.GuildMarkdownMsgItemUIState;
import com.tencent.guild.aio.msglist.markdown.inlineboard.InlineBoardView;
import com.tencent.guild.aio.msglist.text.util.GuildCombineUtil;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.msglist.IGuildAIOLinkSpanApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.guild.nt.misc.api.IJumpApi;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.IGuildFastClickUtilApi;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.utils.SchemaUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.InlineKeyboardElement;
import com.tencent.qqnt.kernel.nativeinterface.MarkdownElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.markdown.api.IMarkdownCodeBlockConfigApi;
import com.tencent.qqnt.markdown.api.IMarkdownConfigApi;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.robot.action.api.IRobotActionApi;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qr1.HashTagJumpParams;
import rq0.GuildRobotSchemeActionContext;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0094\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b*\n\u0010w{\u007f\u0083\u0001\u0087\u0001\u008f\u0001\u0018\u0000 \u0099\u00012\u00020\u0001:\u0002\u009a\u0001B\u0011\u0012\u0006\u0010E\u001a\u00020 \u00a2\u0006\u0006\b\u0097\u0001\u0010\u0098\u0001J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0016\u0010\f\u001a\u00020\u000b2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\tH\u0002J\u000f\u0010\u0011\u001a\u00020\u0010H\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0013\u001a\u00020\tH\u0002J#\u0010\u0017\u001a\u00020\t2\u0012\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0014H\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\f\u0010\u001f\u001a\u00020\t*\u00020\u0019H\u0002J \u0010&\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$H\u0002J\u0018\u0010'\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020$2\u0006\u0010!\u001a\u00020 H\u0002J\u0010\u0010*\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020(H\u0002J\u0010\u0010+\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020(H\u0002J\u0010\u0010,\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020(H\u0002J&\u0010-\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u001c\u00101\u001a\u00020\t2\u0006\u0010.\u001a\u00020\u00042\f\u00100\u001a\b\u0012\u0004\u0012\u00020\t0/J\b\u00102\u001a\u00020 H\u0016J\u0010\u00105\u001a\u00020 2\u0006\u00104\u001a\u000203H\u0016J\b\u00106\u001a\u00020$H\u0016J\u0016\u0010:\u001a\u0010\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u000209\u0018\u000107H\u0016J\u0016\u0010=\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u0002090<0;H\u0016J\u0010\u0010?\u001a\u00020\t2\u0006\u0010>\u001a\u000209H\u0016J\b\u0010@\u001a\u00020\tH\u0016R\u0017\u0010E\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\u001b\u0010J\u001a\u00020\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010R\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0018\u0010V\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010Z\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0018\u0010_\u001a\u00060[j\u0002`\\8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b]\u0010^R\u001b\u0010c\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b`\u0010G\u001a\u0004\ba\u0010bR\u0018\u0010e\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010MR\u0018\u0010i\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010hR\u001b\u0010m\u001a\u00020\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bj\u0010G\u001a\u0004\bk\u0010lR\u0018\u0010q\u001a\u0004\u0018\u00010n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bo\u0010pR\u001b\u0010v\u001a\u00020r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bs\u0010G\u001a\u0004\bt\u0010uR\u0014\u0010z\u001a\u00020w8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bx\u0010yR\u0014\u0010~\u001a\u00020{8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b|\u0010}R\u0017\u0010\u0082\u0001\u001a\u00020\u007f8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0018\u0010\u0086\u0001\u001a\u00030\u0083\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R\u0018\u0010\u008a\u0001\u001a\u00030\u0087\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R\u0018\u0010\u008e\u0001\u001a\u00030\u008b\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R\u0018\u0010\u0092\u0001\u001a\u00030\u008f\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0090\u0001\u0010\u0091\u0001R\u0018\u0010\u0096\u0001\u001a\u00030\u0093\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0094\u0001\u0010\u0095\u0001\u00a8\u0006\u009b\u0001"}, d2 = {"Lcom/tencent/guild/aio/msglist/markdown/GuildMarkDownContentComponent;", "Lcom/tencent/guild/aio/msglist/holder/component/a;", "", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "", "payloads", "", "F1", "", "C1", "Lcom/tencent/guild/aio/msglist/markdown/innerkeyboard/e;", "u1", "E1", "com/tencent/guild/aio/msglist/markdown/GuildMarkDownContentComponent$b", ICustomDataEditor.STRING_PARAM_1, "()Lcom/tencent/guild/aio/msglist/markdown/GuildMarkDownContentComponent$b;", Constants.BASE_IN_PLUGIN_ID, "", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a;", "buttonRows", "M1", "([[Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a;)V", "Lcom/tencent/guild/aio/msglist/markdown/inlineboard/a;", "J1", "Landroid/content/Context;", "context", "Lcom/tencent/guild/aio/msglist/markdown/inlineboard/InlineBoardView;", "v1", "L1", "Landroid/view/View;", "view", "Lcom/tencent/android/androidbypass/span/a;", "imageSpan", "", Constants.KEYS.EXPOSED_CLICK_URL_KEY, "B1", "A1", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "elem", "H1", com.tencent.bugly.common.constants.Constants.APK_CERTIFICATE, "I1", "b1", "bindData", "Lkotlin/Function0;", "function", "K1", "d1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "getTag", "Lcom/tencent/aio/base/mvvm/b;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "e1", "", "Ljava/lang/Class;", "getObserverStates", "state", "handleUIState", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "f", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "root", tl.h.F, "Lkotlin/Lazy;", "w1", "()Lcom/tencent/guild/aio/msglist/markdown/inlineboard/InlineBoardView;", "contentView", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "i", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "currentMsgItem", "Lcom/tencent/android/androidbypass/parser/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/android/androidbypass/parser/a;", "mMarkdownParser", "Lcom/tencent/qqnt/kernel/nativeinterface/MarkdownElement;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqnt/kernel/nativeinterface/MarkdownElement;", "markdownElement", "Lcom/tencent/qqnt/kernel/nativeinterface/InlineKeyboardElement;", "D", "Lcom/tencent/qqnt/kernel/nativeinterface/InlineKeyboardElement;", "inlineKeyboardElement", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "E", "Ljava/lang/StringBuilder;", "result", UserInfo.SEX_FEMALE, "y1", "()Lcom/tencent/guild/aio/msglist/markdown/innerkeyboard/e;", "mBtnClickListener", "G", "mChatMessage", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "H", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "I", "x1", "()Lcom/tencent/guild/aio/msglist/markdown/inlineboard/a;", "dispatchContext", "Lcom/tencent/guild/aio/msglist/text/util/c;", "J", "Lcom/tencent/guild/aio/msglist/text/util/c;", "bubbleColorObserverDetachHandle", "Lcom/tencent/android/androidbypass/e;", "K", "z1", "()Lcom/tencent/android/androidbypass/e;", "mImageSpanClickListener", "com/tencent/guild/aio/msglist/markdown/GuildMarkDownContentComponent$f", "L", "Lcom/tencent/guild/aio/msglist/markdown/GuildMarkDownContentComponent$f;", "mCodeBlockHighlightCallback", "com/tencent/guild/aio/msglist/markdown/GuildMarkDownContentComponent$j", "M", "Lcom/tencent/guild/aio/msglist/markdown/GuildMarkDownContentComponent$j;", "sHttpUrlClickDispatcher", "com/tencent/guild/aio/msglist/markdown/GuildMarkDownContentComponent$e", "N", "Lcom/tencent/guild/aio/msglist/markdown/GuildMarkDownContentComponent$e;", "mChannelHashtagSchemeHandler", "com/tencent/guild/aio/msglist/markdown/GuildMarkDownContentComponent$d", "P", "Lcom/tencent/guild/aio/msglist/markdown/GuildMarkDownContentComponent$d;", "mAtUserSchemeClickHandler", "com/tencent/guild/aio/msglist/markdown/GuildMarkDownContentComponent$g", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/guild/aio/msglist/markdown/GuildMarkDownContentComponent$g;", "mInlineCmdSchemaClickHandler", "Lcom/tencent/android/androidbypass/parser/api/b;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/android/androidbypass/parser/api/b;", "mMqqSchemeClickHandler", "com/tencent/guild/aio/msglist/markdown/GuildMarkDownContentComponent$c", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/guild/aio/msglist/markdown/GuildMarkDownContentComponent$c;", "mAllLinkClickListener", "Ltt/a;", "T", "Ltt/a;", "mReservedHiddenLinkClickListener", "<init>", "(Landroid/view/View;)V", "U", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildMarkDownContentComponent extends com.tencent.guild.aio.msglist.holder.component.a {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private MarkdownElement markdownElement;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private InlineKeyboardElement inlineKeyboardElement;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final StringBuilder result;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy mBtnClickListener;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private GuildMsgItem mChatMessage;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private MsgRecord msgRecord;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy dispatchContext;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private com.tencent.guild.aio.msglist.text.util.c bubbleColorObserverDetachHandle;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy mImageSpanClickListener;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final f mCodeBlockHighlightCallback;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final j sHttpUrlClickDispatcher;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final e mChannelHashtagSchemeHandler;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final d mAtUserSchemeClickHandler;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final g mInlineCmdSchemaClickHandler;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.android.androidbypass.parser.api.b mMqqSchemeClickHandler;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final c mAllLinkClickListener;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final tt.a mReservedHiddenLinkClickListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View root;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy contentView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private GuildMsgItem currentMsgItem;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.android.androidbypass.parser.a mMarkdownParser;

    /* compiled from: P */
    @Metadata(d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u0002j\u0002`\u0006H\u0016J,\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\b2\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u0002j\u0002`\u0006H\u0016J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/guild/aio/msglist/markdown/GuildMarkDownContentComponent$b", "Lcom/tencent/guild/aio/msglist/markdown/inlineboard/b;", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/InlineBtnView;", "Lcom/tencent/guild/aio/msglist/markdown/inlineboard/a;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "Lcom/tencent/guild/aio/msglist/markdown/InlineBtnPayload;", "Lcom/tencent/guild/aio/msglist/markdown/InlineBtnView;", "btnView", "", "a", "btnKey", "", "b", "c", "", "d", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements com.tencent.guild.aio.msglist.markdown.inlineboard.b {
        b() {
        }

        @Override // com.tencent.guild.aio.msglist.markdown.inlineboard.b
        @NotNull
        public String a(@NotNull InlineBtnView<com.tencent.guild.aio.msglist.markdown.inlineboard.a, GuildMsgItem> btnView) {
            Intrinsics.checkNotNullParameter(btnView, "btnView");
            GuildMsgItem G0 = btnView.G0();
            if (G0 != null) {
                return com.tencent.guild.aio.msglist.markdown.inlineboard.e.f111771a.a(G0, btnView.F0());
            }
            return btnView.F0().c();
        }

        @Override // com.tencent.guild.aio.msglist.markdown.inlineboard.b
        public void b(@NotNull String btnKey, @NotNull InlineBtnView<com.tencent.guild.aio.msglist.markdown.inlineboard.a, GuildMsgItem> btnView) {
            Intrinsics.checkNotNullParameter(btnKey, "btnKey");
            Intrinsics.checkNotNullParameter(btnView, "btnView");
            com.tencent.guild.aio.msglist.markdown.innerkeyboard.e.INSTANCE.a().put(btnKey, new WeakReference<>(btnView));
            GuildMarkDownContentComponent guildMarkDownContentComponent = GuildMarkDownContentComponent.this;
            guildMarkDownContentComponent.M1(guildMarkDownContentComponent.w1().G0());
            GuildMarkDownContentComponent.this.w1().O0();
        }

        @Override // com.tencent.guild.aio.msglist.markdown.inlineboard.b
        public void c(@NotNull String btnKey) {
            Intrinsics.checkNotNullParameter(btnKey, "btnKey");
            WeakReference<InlineBtnView<com.tencent.guild.aio.msglist.markdown.inlineboard.a, GuildMsgItem>> remove = com.tencent.guild.aio.msglist.markdown.innerkeyboard.e.INSTANCE.a().remove(btnKey);
            if (remove != null && remove.get() != null) {
                GuildMarkDownContentComponent guildMarkDownContentComponent = GuildMarkDownContentComponent.this;
                guildMarkDownContentComponent.M1(guildMarkDownContentComponent.w1().G0());
                guildMarkDownContentComponent.w1().O0();
            }
        }

        @Override // com.tencent.guild.aio.msglist.markdown.inlineboard.b
        public boolean d(@NotNull String btnKey) {
            Intrinsics.checkNotNullParameter(btnKey, "btnKey");
            return com.tencent.guild.aio.msglist.markdown.innerkeyboard.e.INSTANCE.a().contains(btnKey);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/guild/aio/msglist/markdown/GuildMarkDownContentComponent$c", "Lcom/tencent/android/androidbypass/span/ClickableUrlSpan$a;", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "Landroid/text/style/ClickableSpan;", "clickableSpan", "", "clickedUrl", "text", "", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class c implements ClickableUrlSpan.a {
        c() {
        }

        @Override // com.tencent.android.androidbypass.span.ClickableUrlSpan.a
        public boolean a(@Nullable View widget, @Nullable ClickableSpan clickableSpan, @Nullable String clickedUrl, @Nullable String text) {
            String str;
            String str2;
            MsgRecord msgRecord;
            MsgRecord msgRecord2;
            GuildMsgItem guildMsgItem = GuildMarkDownContentComponent.this.mChatMessage;
            if (guildMsgItem != null && (msgRecord2 = guildMsgItem.getMsgRecord()) != null) {
                str = msgRecord2.guildId;
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            GuildMsgItem guildMsgItem2 = GuildMarkDownContentComponent.this.mChatMessage;
            if (guildMsgItem2 != null && (msgRecord = guildMsgItem2.getMsgRecord()) != null) {
                str2 = msgRecord.channelId;
            } else {
                str2 = null;
            }
            if (str2 == null) {
                str2 = "";
            }
            fq0.a aVar = fq0.a.f400309a;
            if (clickedUrl == null) {
                clickedUrl = "";
            }
            if (!aVar.j(str, clickedUrl)) {
                s.AioContextWrapper aioContextWrapper = new s.AioContextWrapper(null, 1, null);
                GuildMarkDownContentComponent.this.sendIntent(new s.GetAioContext(aioContextWrapper));
                com.tencent.aio.api.runtime.a context = aioContextWrapper.getContext();
                Intrinsics.checkNotNull(context);
                JumpGuildParam.JoinInfoParam joinInfoParam = (JumpGuildParam.JoinInfoParam) context.g().l().getParcelable(JumpGuildParam.KEY_JOIN_INFO_PARAM);
                com.tencent.aio.api.runtime.a context2 = aioContextWrapper.getContext();
                Intrinsics.checkNotNull(context2);
                aVar.l(str, str2, joinInfoParam, (GuildAppReportSourceInfo) context2.g().l().getParcelable("GuildAppReportSourceInfo"));
                return true;
            }
            fq0.b.f400314a.i(GuildMarkDownContentComponent.this.w1(), text);
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\u0007"}, d2 = {"com/tencent/guild/aio/msglist/markdown/GuildMarkDownContentComponent$e", "Lcom/tencent/android/androidbypass/enhance/scheme/handler/a;", "", "guildId", "channelId", "", "c", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class e extends com.tencent.android.androidbypass.enhance.scheme.handler.a {
        e() {
        }

        @Override // com.tencent.android.androidbypass.enhance.scheme.handler.a
        protected void c(@Nullable String guildId, @Nullable String channelId) {
            boolean z16;
            String str;
            MsgRecord msgRecord;
            if (guildId != null && channelId != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            Boolean valueOf = Boolean.valueOf(z16);
            String str2 = null;
            if (!valueOf.booleanValue()) {
                valueOf = null;
            }
            if (valueOf != null) {
                GuildMarkDownContentComponent guildMarkDownContentComponent = GuildMarkDownContentComponent.this;
                valueOf.booleanValue();
                if (GuildUIUtils.f235378a.C()) {
                    return;
                }
                s.AioContextWrapper aioContextWrapper = new s.AioContextWrapper(null, 1, null);
                guildMarkDownContentComponent.sendIntent(new s.GetAioContext(aioContextWrapper));
                com.tencent.aio.api.runtime.a context = aioContextWrapper.getContext();
                Intrinsics.checkNotNull(context);
                JumpGuildParam.JoinInfoParam joinInfoParam = (JumpGuildParam.JoinInfoParam) context.g().l().getParcelable(JumpGuildParam.KEY_JOIN_INFO_PARAM);
                com.tencent.aio.api.runtime.a context2 = aioContextWrapper.getContext();
                Intrinsics.checkNotNull(context2);
                GuildAppReportSourceInfo guildAppReportSourceInfo = (GuildAppReportSourceInfo) context2.g().l().getParcelable("GuildAppReportSourceInfo");
                IGuildMainFrameApi iGuildMainFrameApi = (IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class);
                Context mContext = guildMarkDownContentComponent.getMContext();
                Intrinsics.checkNotNull(guildId);
                Intrinsics.checkNotNull(channelId);
                GuildMsgItem guildMsgItem = guildMarkDownContentComponent.mChatMessage;
                if (guildMsgItem != null && (msgRecord = guildMsgItem.getMsgRecord()) != null) {
                    str2 = msgRecord.channelId;
                }
                if (str2 == null) {
                    str = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(str2, "mChatMessage?.msgRecord?.channelId ?: \"\"");
                    str = str2;
                }
                bq0.e eVar = bq0.e.f28951a;
                com.tencent.aio.api.runtime.a context3 = aioContextWrapper.getContext();
                Intrinsics.checkNotNull(context3);
                boolean g16 = eVar.g(true, context3.g().n());
                com.tencent.aio.api.runtime.a context4 = aioContextWrapper.getContext();
                Intrinsics.checkNotNull(context4);
                iGuildMainFrameApi.handleHashTagJump(new HashTagJumpParams(mContext, guildId, channelId, str, g16, context4.g().n(), false, joinInfoParam, guildAppReportSourceInfo));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/guild/aio/msglist/markdown/GuildMarkDownContentComponent$f", "Lst/a;", "", "c", "Landroid/content/Context;", "context", "", IjkMediaMeta.IJKM_KEY_LANGUAGE, "Lcom/tencent/android/androidbypass/codeblock/config/c;", "d", "", "a", "Landroidx/lifecycle/LifecycleOwner;", "b", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class f implements st.a {
        f() {
        }

        @Override // st.a
        public int a() {
            return ((IMarkdownCodeBlockConfigApi) QRoute.api(IMarkdownCodeBlockConfigApi.class)).getCodeBlockMaxLineCountInAIO();
        }

        @Override // st.a
        @Nullable
        public LifecycleOwner b() {
            Fragment c16;
            com.tencent.aio.api.runtime.a f16 = GuildMarkDownContentComponent.this.f1();
            if (f16 != null && (c16 = f16.c()) != null) {
                return c16.getViewLifecycleOwner();
            }
            return null;
        }

        @Override // st.a
        public boolean c() {
            return ((IMarkdownCodeBlockConfigApi) QRoute.api(IMarkdownCodeBlockConfigApi.class)).isEnableCodeBlockHighlight();
        }

        @Override // st.a
        @NotNull
        public com.tencent.android.androidbypass.codeblock.config.c d(@NotNull Context context, @NotNull String language) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(language, "language");
            return ((IMarkdownCodeBlockConfigApi) QRoute.api(IMarkdownCodeBlockConfigApi.class)).buildCodeBlockConfigForAIO(GuildMarkDownContentComponent.this.getMContext());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J%\u0010\t\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0096\u0001J&\u0010\u000f\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/guild/aio/msglist/markdown/GuildMarkDownContentComponent$g", "Lcom/tencent/android/androidbypass/parser/api/b;", "Lcom/tencent/android/androidbypass/parser/api/a;", "", "url", "Lcom/tencent/android/androidbypass/parser/api/d;", "parsedResult", "clickText", "", "a", "Landroid/view/View;", "view", "Landroid/text/style/ClickableSpan;", "clickableSpan", "", "b", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class g implements com.tencent.android.androidbypass.parser.api.b, com.tencent.android.androidbypass.parser.api.a {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ com.tencent.android.androidbypass.enhance.scheme.matcher.d f111719a = new com.tencent.android.androidbypass.enhance.scheme.matcher.d();

        g() {
        }

        @Override // com.tencent.android.androidbypass.parser.api.a
        public boolean a(@Nullable String url, @NotNull com.tencent.android.androidbypass.parser.api.d parsedResult, @Nullable String clickText) {
            Intrinsics.checkNotNullParameter(parsedResult, "parsedResult");
            return this.f111719a.a(url, parsedResult, clickText);
        }

        @Override // com.tencent.android.androidbypass.enhance.j
        public void b(@Nullable View view, @Nullable ClickableSpan clickableSpan, @Nullable String url) {
            com.tencent.aio.api.runtime.a f16;
            if (((IGuildFastClickUtilApi) QRoute.api(IGuildFastClickUtilApi.class)).isFastClick("GuildMarkDownContentComponent") || url == null || GuildMarkDownContentComponent.this.mChatMessage == null || (f16 = GuildMarkDownContentComponent.this.f1()) == null) {
                return;
            }
            ((IRobotActionApi) QRoute.api(IRobotActionApi.class)).doSchemeAction(new GuildRobotSchemeActionContext(f16, GuildMarkDownContentComponent.this.mChatMessage, null, 4, null), url);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J%\u0010\t\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0096\u0001J&\u0010\u000f\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/guild/aio/msglist/markdown/GuildMarkDownContentComponent$h", "Lcom/tencent/android/androidbypass/parser/api/b;", "Lcom/tencent/android/androidbypass/parser/api/a;", "", "url", "Lcom/tencent/android/androidbypass/parser/api/d;", "parsedResult", "clickText", "", "a", "Landroid/view/View;", "view", "Landroid/text/style/ClickableSpan;", "clickableSpan", "", "b", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class h implements com.tencent.android.androidbypass.parser.api.b, com.tencent.android.androidbypass.parser.api.a {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ com.tencent.android.androidbypass.enhance.scheme.matcher.f f111721a = new com.tencent.android.androidbypass.enhance.scheme.matcher.f();

        h() {
        }

        @Override // com.tencent.android.androidbypass.parser.api.a
        public boolean a(@Nullable String url, @NotNull com.tencent.android.androidbypass.parser.api.d parsedResult, @Nullable String clickText) {
            Intrinsics.checkNotNullParameter(parsedResult, "parsedResult");
            return this.f111721a.a(url, parsedResult, clickText);
        }

        @Override // com.tencent.android.androidbypass.enhance.j
        public void b(@Nullable View view, @Nullable ClickableSpan clickableSpan, @Nullable String url) {
            Context context;
            if (view != null) {
                context = view.getContext();
            } else {
                context = null;
            }
            if (context != null && !((IJumpApi) QRoute.api(IJumpApi.class)).doJumpAction(context, url)) {
                QQToast.makeText(context, "\u6682\u4e0d\u652f\u6301\u8be5\u7c7b\u578b\u6309\u94ae\uff0c\u8bf7\u5347\u7ea7\u5ba2\u6237\u7aef", 0).show();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J:\u0010\r\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/guild/aio/msglist/markdown/GuildMarkDownContentComponent$i", "Ltt/a;", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "", "originUrl", "innerUrl", "altText", "", "elementType", "Landroid/os/Bundle;", "args", "", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class i implements tt.a {
        i() {
        }

        @Override // tt.a
        public void a(@Nullable View widget, @NotNull String originUrl, @NotNull String innerUrl, @NotNull String altText, int elementType, @NotNull Bundle args) {
            Intrinsics.checkNotNullParameter(originUrl, "originUrl");
            Intrinsics.checkNotNullParameter(innerUrl, "innerUrl");
            Intrinsics.checkNotNullParameter(altText, "altText");
            Intrinsics.checkNotNullParameter(args, "args");
            if (widget != null && !GuildMarkDownContentComponent.this.A1(innerUrl, widget)) {
                QLog.d("GuildMarkDownContentComponent", 1, "[handleClickAction]: false, url=" + innerUrl);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J%\u0010\t\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0096\u0001J&\u0010\u000f\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/guild/aio/msglist/markdown/GuildMarkDownContentComponent$j", "Lcom/tencent/android/androidbypass/parser/api/b;", "Lcom/tencent/android/androidbypass/parser/api/a;", "", "url", "Lcom/tencent/android/androidbypass/parser/api/d;", "parsedResult", "clickText", "", "a", "Landroid/view/View;", "view", "Landroid/text/style/ClickableSpan;", "clickableSpan", "", "b", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class j implements com.tencent.android.androidbypass.parser.api.b, com.tencent.android.androidbypass.parser.api.a {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ com.tencent.android.androidbypass.enhance.scheme.matcher.c f111723a = new com.tencent.android.androidbypass.enhance.scheme.matcher.c();

        j() {
        }

        @Override // com.tencent.android.androidbypass.parser.api.a
        public boolean a(@Nullable String url, @NotNull com.tencent.android.androidbypass.parser.api.d parsedResult, @Nullable String clickText) {
            Intrinsics.checkNotNullParameter(parsedResult, "parsedResult");
            return this.f111723a.a(url, parsedResult, clickText);
        }

        @Override // com.tencent.android.androidbypass.enhance.j
        public void b(@Nullable View view, @Nullable ClickableSpan clickableSpan, @Nullable String url) {
            AppRuntime peekAppRuntime;
            if (url != null && (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) != null) {
                ((IGuildAIOLinkSpanApi) QRoute.api(IGuildAIOLinkSpanApi.class)).onInlineBtnClick(peekAppRuntime, GuildMarkDownContentComponent.this.getMContext(), url);
            }
        }
    }

    public GuildMarkDownContentComponent(@NotNull View root) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<InlineBoardView>() { // from class: com.tencent.guild.aio.msglist.markdown.GuildMarkDownContentComponent$contentView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final InlineBoardView invoke() {
                InlineBoardView v16;
                GuildMarkDownContentComponent guildMarkDownContentComponent = GuildMarkDownContentComponent.this;
                Context context = guildMarkDownContentComponent.getRoot().getContext();
                Intrinsics.checkNotNullExpressionValue(context, "root.context");
                v16 = guildMarkDownContentComponent.v1(context);
                return v16;
            }
        });
        this.contentView = lazy;
        this.result = new StringBuilder();
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<com.tencent.guild.aio.msglist.markdown.innerkeyboard.e>() { // from class: com.tencent.guild.aio.msglist.markdown.GuildMarkDownContentComponent$mBtnClickListener$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.guild.aio.msglist.markdown.innerkeyboard.e invoke() {
                com.tencent.guild.aio.msglist.markdown.innerkeyboard.e u16;
                u16 = GuildMarkDownContentComponent.this.u1();
                return u16;
            }
        });
        this.mBtnClickListener = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<com.tencent.guild.aio.msglist.markdown.inlineboard.a>() { // from class: com.tencent.guild.aio.msglist.markdown.GuildMarkDownContentComponent$dispatchContext$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.guild.aio.msglist.markdown.inlineboard.a invoke() {
                GuildMarkDownContentComponent.b s16;
                Context context = GuildMarkDownContentComponent.this.getRoot().getContext();
                Intrinsics.checkNotNullExpressionValue(context, "root.context");
                s16 = GuildMarkDownContentComponent.this.s1();
                return new com.tencent.guild.aio.msglist.markdown.inlineboard.a(context, null, s16, null, 8, null);
            }
        });
        this.dispatchContext = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new GuildMarkDownContentComponent$mImageSpanClickListener$2(this));
        this.mImageSpanClickListener = lazy4;
        this.mCodeBlockHighlightCallback = new f();
        this.sHttpUrlClickDispatcher = new j();
        this.mChannelHashtagSchemeHandler = new e();
        this.mAtUserSchemeClickHandler = new d();
        this.mInlineCmdSchemaClickHandler = new g();
        this.mMqqSchemeClickHandler = (com.tencent.android.androidbypass.parser.api.b) ((IMarkdownConfigApi) QRoute.api(IMarkdownConfigApi.class)).getWhitelistedSchemeClickListener(new h());
        this.mAllLinkClickListener = new c();
        this.mReservedHiddenLinkClickListener = (tt.a) ((IMarkdownConfigApi) QRoute.api(IMarkdownConfigApi.class)).getWhitelistedSchemeClickListener(new i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean A1(String clickUrl, View view) {
        boolean equals;
        boolean z16;
        boolean equals2;
        boolean z17;
        boolean equals3;
        boolean equals4;
        Uri parse = Uri.parse(clickUrl);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        boolean z18 = false;
        if (peekAppRuntime != null) {
            equals = StringsKt__StringsJVMKt.equals("http", parse.getScheme(), true);
            if (!equals) {
                equals4 = StringsKt__StringsJVMKt.equals("https", parse.getScheme(), true);
                if (!equals4) {
                    z16 = false;
                    boolean matches = Patterns.WEB_URL.matcher(clickUrl).matches();
                    if (z16 || !matches) {
                        equals2 = StringsKt__StringsJVMKt.equals(SchemaUtils.SCHEMA_MQQAPI, parse.getScheme(), true);
                        if (!equals2) {
                            equals3 = StringsKt__StringsJVMKt.equals("mqqguild", parse.getScheme(), true);
                            if (!equals3) {
                                z17 = false;
                                if (z17) {
                                    z18 = ((IJumpApi) QRoute.api(IJumpApi.class)).doJumpAction(view.getContext(), clickUrl);
                                }
                            }
                        }
                        z17 = true;
                        if (z17) {
                        }
                    } else {
                        ((IGuildAIOLinkSpanApi) QRoute.api(IGuildAIOLinkSpanApi.class)).onInlineBtnClick(peekAppRuntime, getMContext(), clickUrl);
                        z18 = true;
                    }
                    if (!z18) {
                        QLog.d("GuildMarkDownContentComponent", 1, "[handleGenericScheme]: not handled url: " + parse);
                    }
                    return z18;
                }
            }
            z16 = true;
            boolean matches2 = Patterns.WEB_URL.matcher(clickUrl).matches();
            if (z16) {
            }
            equals2 = StringsKt__StringsJVMKt.equals(SchemaUtils.SCHEMA_MQQAPI, parse.getScheme(), true);
            if (!equals2) {
            }
            z17 = true;
            if (z17) {
            }
            if (!z18) {
            }
            return z18;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean B1(View view, com.tencent.android.androidbypass.span.a imageSpan, String clickUrl) {
        return A1(clickUrl, view);
    }

    private final boolean C1(List<Object> payloads) {
        Iterator<Object> it = payloads.iterator();
        boolean z16 = true;
        while (it.hasNext()) {
            if (it.next() instanceof HashMap) {
                z16 = false;
            }
        }
        return z16;
    }

    private final void D1() {
        String str;
        String str2;
        boolean equals$default;
        long j3;
        long j16;
        if (((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).isEnableMarkdown()) {
            MarkdownElement markdownElement = this.markdownElement;
            Long l3 = null;
            if (markdownElement != null) {
                str = markdownElement.content;
            } else {
                str = null;
            }
            if (com.tencent.android.androidbypass.parser.c.b(str)) {
                if (!Intrinsics.areEqual(this.mChatMessage, w1().getTag(R.id.f165424vx4))) {
                    if (this.mMarkdownParser == null) {
                        E1();
                    }
                    w1().setTextViewAppearance(17.0f);
                    w1().setTag(R.id.f165424vx4, this.mChatMessage);
                    com.tencent.guild.aio.msglist.markdown.inlineboard.a J1 = J1();
                    L1(J1);
                    MarkdownElement markdownElement2 = this.markdownElement;
                    if (markdownElement2 != null) {
                        fq0.b bVar = fq0.b.f400314a;
                        InlineBoardView w16 = w1();
                        GuildMsgItem guildMsgItem = this.mChatMessage;
                        String str3 = markdownElement2.content;
                        Intrinsics.checkNotNullExpressionValue(str3, "it.content");
                        bVar.j(w16, guildMsgItem, str3, this.inlineKeyboardElement);
                        M1(w1().G0());
                        GuildMsgItem guildMsgItem2 = this.mChatMessage;
                        if (guildMsgItem2 != null) {
                            str2 = guildMsgItem2.getExtInfoFromExtStr("GUILD_MARK_DOWN_UPDATE", "");
                        } else {
                            str2 = null;
                        }
                        equals$default = StringsKt__StringsJVMKt.equals$default(str2, "1", false, 2, null);
                        if (equals$default) {
                            if (QLog.isColorLevel()) {
                                GuildMsgItem guildMsgItem3 = this.mChatMessage;
                                if (guildMsgItem3 != null) {
                                    l3 = Long.valueOf(guildMsgItem3.getMsgSeq());
                                }
                                QLog.i("GuildMarkDownContentComponent", 1, "[handlerMarkdownUI], from GUILD_MARK_DOWN_UPDATE. updateContent. msgSeq: " + l3);
                            }
                            GuildMsgItem guildMsgItem4 = this.mChatMessage;
                            if (guildMsgItem4 != null) {
                                guildMsgItem4.removeExtInfoToExtStr("GUILD_MARK_DOWN_UPDATE");
                            }
                            InlineBoardView w17 = w1();
                            GuildMsgItem guildMsgItem5 = this.mChatMessage;
                            if (guildMsgItem5 != null) {
                                j16 = guildMsgItem5.getMsgId();
                            } else {
                                j16 = 0;
                            }
                            w17.P0(j16, J1, markdownElement2, this.mChatMessage, this.inlineKeyboardElement, y1());
                            return;
                        }
                        if (QLog.isColorLevel()) {
                            GuildMsgItem guildMsgItem6 = this.mChatMessage;
                            if (guildMsgItem6 != null) {
                                l3 = Long.valueOf(guildMsgItem6.getMsgSeq());
                            }
                            QLog.i("GuildMarkDownContentComponent", 1, "[handlerMarkdownUI], setContent. msgSeq: " + l3);
                        }
                        InlineBoardView w18 = w1();
                        GuildMsgItem guildMsgItem7 = this.mChatMessage;
                        if (guildMsgItem7 != null) {
                            j3 = guildMsgItem7.getMsgId();
                        } else {
                            j3 = 0;
                        }
                        w18.K0(j3, J1, markdownElement2, this.mChatMessage, this.inlineKeyboardElement, y1());
                        return;
                    }
                    return;
                }
                return;
            }
            w1().L0(this.result.toString());
            return;
        }
        w1().L0("[\u8be5\u6d88\u606f\u6682\u4e0d\u652f\u6301\u5c55\u793a]");
    }

    private final void E1() {
        List<? extends com.tencent.android.androidbypass.parser.api.b> listOf;
        com.tencent.android.androidbypass.parser.d g16 = com.tencent.qqnt.markdown.g.f359430a.g();
        fq0.a aVar = fq0.a.f400309a;
        Context context = this.root.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "root.context");
        fq0.a.b(aVar, context, g16.i(), false, 4, null);
        com.tencent.android.androidbypass.parser.d j3 = g16.j(com.tencent.guild.aio.msglist.text.util.f.f(com.tencent.guild.aio.msglist.text.util.f.f111944a, false, 1, null));
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.android.androidbypass.parser.api.b[]{this.mAtUserSchemeClickHandler, this.mChannelHashtagSchemeHandler, this.sHttpUrlClickDispatcher, this.mInlineCmdSchemaClickHandler, this.mMqqSchemeClickHandler});
        this.mMarkdownParser = j3.e(listOf).a(this.mAllLinkClickListener).d(z1()).c(this.mCodeBlockHighlightCallback).k(new GuildUrlToDrawable()).f(this.mReservedHiddenLinkClickListener).b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F1(int position, com.tencent.aio.data.msglist.a msgItem, List<Object> payloads) {
        Fragment c16;
        LifecycleOwner viewLifecycleOwner;
        if (msgItem instanceof GuildMsgItem) {
            GuildMsgItem guildMsgItem = (GuildMsgItem) msgItem;
            this.currentMsgItem = guildMsgItem;
            this.msgRecord = guildMsgItem.getMsgRecord();
            this.mChatMessage = guildMsgItem;
            this.markdownElement = null;
            this.inlineKeyboardElement = null;
            ArrayList<MsgElement> arrayList = guildMsgItem.getMsgRecord().elements;
            Intrinsics.checkNotNullExpressionValue(arrayList, "msgItem.msgRecord.elements");
            for (MsgElement element : arrayList) {
                Intrinsics.checkNotNullExpressionValue(element, "element");
                if (H1(element)) {
                    this.markdownElement = element.markdownElement;
                } else if (G1(element)) {
                    this.inlineKeyboardElement = element.inlineKeyboardElement;
                } else if (I1(element)) {
                    this.result.append(element.textElement.content);
                }
            }
            D1();
        }
        View bubble = this.root.findViewById(R.id.f164907u83);
        com.tencent.aio.api.runtime.a f16 = f1();
        if (f16 != null && (c16 = f16.c()) != null && (viewLifecycleOwner = c16.getViewLifecycleOwner()) != null) {
            GuildCombineUtil guildCombineUtil = GuildCombineUtil.f111919a;
            Intrinsics.checkNotNullExpressionValue(bubble, "bubble");
            this.bubbleColorObserverDetachHandle = guildCombineUtil.v(bubble, viewLifecycleOwner);
        }
    }

    private final boolean G1(MsgElement elem) {
        if (elem.elementType == 17) {
            return true;
        }
        return false;
    }

    private final boolean H1(MsgElement elem) {
        if (elem.elementType == 14) {
            return true;
        }
        return false;
    }

    private final boolean I1(MsgElement elem) {
        if (elem.elementType == 1) {
            return true;
        }
        return false;
    }

    private final com.tencent.guild.aio.msglist.markdown.inlineboard.a J1() {
        com.tencent.guild.aio.msglist.markdown.inlineboard.a x16 = x1();
        x16.e(f1());
        return x16;
    }

    private final void L1(com.tencent.guild.aio.msglist.markdown.inlineboard.a aVar) {
        s.AioContextWrapper aioContextWrapper = new s.AioContextWrapper(null, 1, null);
        sendIntent(new s.GetAioContext(aioContextWrapper));
        com.tencent.aio.api.runtime.a context = aioContextWrapper.getContext();
        Intrinsics.checkNotNull(context);
        JumpGuildParam.JoinInfoParam joinInfoParam = (JumpGuildParam.JoinInfoParam) context.g().l().getParcelable(JumpGuildParam.KEY_JOIN_INFO_PARAM);
        com.tencent.aio.api.runtime.a context2 = aioContextWrapper.getContext();
        Intrinsics.checkNotNull(context2);
        GuildAppReportSourceInfo guildAppReportSourceInfo = (GuildAppReportSourceInfo) context2.g().l().getParcelable("GuildAppReportSourceInfo");
        if (joinInfoParam != null) {
            aVar.getExtras().putParcelable(JumpGuildParam.KEY_JOIN_INFO_PARAM, joinInfoParam);
        }
        if (guildAppReportSourceInfo != null) {
            aVar.getExtras().putParcelable("GuildAppReportSourceInfo", guildAppReportSourceInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M1(com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a[][] buttonRows) {
        boolean z16;
        ConcurrentHashMap<String, WeakReference<InlineBtnView<com.tencent.guild.aio.msglist.markdown.inlineboard.a, GuildMsgItem>>> a16 = com.tencent.guild.aio.msglist.markdown.innerkeyboard.e.INSTANCE.a();
        com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a aVar = null;
        for (com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a[] aVarArr : buttonRows) {
            int length = aVarArr.length;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a aVar2 = aVarArr[i3];
                    com.tencent.guild.aio.msglist.markdown.inlineboard.e eVar = com.tencent.guild.aio.msglist.markdown.inlineboard.e.f111771a;
                    GuildMsgItem guildMsgItem = this.currentMsgItem;
                    if (guildMsgItem == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                        guildMsgItem = null;
                    }
                    if (a16.get(eVar.a(guildMsgItem, aVar2)) != null) {
                        aVar = aVar2;
                        break;
                    }
                    i3++;
                }
            }
        }
        for (com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a[] aVarArr2 : buttonRows) {
            for (com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a aVar3 : aVarArr2) {
                aVar3.i(Intrinsics.areEqual(aVar3, aVar));
                if (!Intrinsics.areEqual(aVar3, aVar) && aVar != null) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                aVar3.h(z16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b s1() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.guild.aio.msglist.markdown.innerkeyboard.e u1() {
        com.tencent.guild.aio.msglist.markdown.innerkeyboard.e eVar = new com.tencent.guild.aio.msglist.markdown.innerkeyboard.e();
        eVar.f(new Function0<Unit>() { // from class: com.tencent.guild.aio.msglist.markdown.GuildMarkDownContentComponent$createInlineBtnManager$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                QQToast.makeText(GuildMarkDownContentComponent.this.getMContext(), 0, R.string.f146700uw, 0).show();
            }
        });
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InlineBoardView v1(Context context) {
        if (this.mMarkdownParser == null) {
            E1();
        }
        InlineBoardView a16 = InlineBoardView.INSTANCE.a(context, this.mMarkdownParser);
        a16.Q0();
        return a16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InlineBoardView w1() {
        return (InlineBoardView) this.contentView.getValue();
    }

    private final com.tencent.guild.aio.msglist.markdown.inlineboard.a x1() {
        return (com.tencent.guild.aio.msglist.markdown.inlineboard.a) this.dispatchContext.getValue();
    }

    private final com.tencent.guild.aio.msglist.markdown.innerkeyboard.e y1() {
        return (com.tencent.guild.aio.msglist.markdown.innerkeyboard.e) this.mBtnClickListener.getValue();
    }

    private final com.tencent.android.androidbypass.e z1() {
        return (com.tencent.android.androidbypass.e) this.mImageSpanClickListener.getValue();
    }

    public final void K1(@NotNull com.tencent.aio.data.msglist.a bindData, @NotNull Function0<Unit> function) {
        Intrinsics.checkNotNullParameter(bindData, "bindData");
        Intrinsics.checkNotNullParameter(function, "function");
        GuildMsgItem guildMsgItem = this.currentMsgItem;
        if (guildMsgItem == null) {
            function.invoke();
            return;
        }
        GuildMsgItem guildMsgItem2 = null;
        if (guildMsgItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            guildMsgItem = null;
        }
        if (guildMsgItem.isSameItem(bindData)) {
            GuildMsgItem guildMsgItem3 = this.currentMsgItem;
            if (guildMsgItem3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            } else {
                guildMsgItem2 = guildMsgItem3;
            }
            if (guildMsgItem2.isSameContent(bindData)) {
                QLog.d("GuildMarkDownContentComponent", 4, "[isSameContent] = true. bindData msgId: " + bindData.getMsgId() + ", seq: " + bindData.getMsgSeq());
                return;
            }
        }
        function.invoke();
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    public void b1(final int position, @NotNull final com.tencent.aio.data.msglist.a msgItem, @NotNull final List<Object> payloads) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (C1(payloads)) {
            K1(msgItem, new Function0<Unit>() { // from class: com.tencent.guild.aio.msglist.markdown.GuildMarkDownContentComponent$bind$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    GuildMarkDownContentComponent.this.F1(position, msgItem, payloads);
                }
            });
        }
        w1().N0();
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    public View d1() {
        return w1();
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a, com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    /* renamed from: e1 */
    public com.tencent.aio.base.mvvm.b<ol3.b, MviUIState> createVM() {
        return new com.tencent.guild.aio.msglist.markdown.b();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends MviUIState>> getObserverStates() {
        List<Class<? extends MviUIState>> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(GuildMarkdownMsgItemUIState.OnConfigurationChangedUIState.class);
        return listOf;
    }

    @NotNull
    public final View getRoot() {
        return this.root;
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    public String getTag() {
        return "GuildMarkDownContentComponent";
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    public void handleUIState(@NotNull MviUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof GuildMarkdownMsgItemUIState.OnConfigurationChangedUIState) {
            w1().N0();
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        View containerView = getContainerView();
        Intrinsics.checkNotNull(containerView);
        return containerView;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        super.onDestroy();
        w1().onDestroy();
        com.tencent.guild.aio.msglist.text.util.c cVar = this.bubbleColorObserverDetachHandle;
        if (cVar != null) {
            cVar.detach();
        }
        this.bubbleColorObserverDetachHandle = null;
        x1().e(null);
        this.currentMsgItem = new GuildMsgItem(new MsgRecord());
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J%\u0010\t\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0096\u0001J&\u0010\u000f\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/guild/aio/msglist/markdown/GuildMarkDownContentComponent$d", "Lcom/tencent/android/androidbypass/parser/api/b;", "Lcom/tencent/android/androidbypass/parser/api/a;", "", "url", "Lcom/tencent/android/androidbypass/parser/api/d;", "parsedResult", "clickText", "", "a", "Landroid/view/View;", "view", "Landroid/text/style/ClickableSpan;", "clickableSpan", "", "b", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class d implements com.tencent.android.androidbypass.parser.api.b, com.tencent.android.androidbypass.parser.api.a {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ com.tencent.android.androidbypass.enhance.scheme.matcher.a f111716a = new com.tencent.android.androidbypass.enhance.scheme.matcher.a();

        d() {
        }

        @Override // com.tencent.android.androidbypass.parser.api.a
        public boolean a(@Nullable String url, @NotNull com.tencent.android.androidbypass.parser.api.d parsedResult, @Nullable String clickText) {
            Intrinsics.checkNotNullParameter(parsedResult, "parsedResult");
            return this.f111716a.a(url, parsedResult, clickText);
        }

        @Override // com.tencent.android.androidbypass.enhance.j
        public void b(@Nullable View view, @Nullable ClickableSpan clickableSpan, @Nullable String url) {
        }
    }
}
