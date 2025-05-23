package com.tencent.mobileqq.aio.msglist.holder.component.markdown;

import android.app.Activity;
import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.MsgRecordParams;
import com.tencent.mobileqq.aio.msg.i;
import com.tencent.mobileqq.aio.msg.l;
import com.tencent.mobileqq.aio.msglist.holder.skin.AIOBubbleSkinInfo;
import com.tencent.mobileqq.aio.msglist.holder.skin.padding.a;
import com.tencent.mobileqq.aio.msglist.payload.AIOMsgItemPayloadType;
import com.tencent.mobileqq.aio.msglist.payload.a;
import com.tencent.mobileqq.aio.utils.StopWatch;
import com.tencent.mobileqq.aio.utils.n;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vas.avatar.NtFaceConstant;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.api.IAIOUniteConfigApi;
import com.tencent.qqnt.aio.utils.ViewUtils;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.InlineKeyboardElement;
import com.tencent.qqnt.kernel.nativeinterface.InlineKeyboardRow;
import com.tencent.qqnt.kernel.nativeinterface.MarkdownElement;
import com.tencent.qqnt.kernel.nativeinterface.MarkdownElementExtInfo;
import com.tencent.qqnt.kernel.nativeinterface.MarkdownStyle;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.rich.RichParser;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u0097\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002*-B\u0012\u0012\u0007\u0010\u0094\u0001\u001a\u00020\u0017\u00a2\u0006\u0006\b\u0095\u0001\u0010\u0096\u0001J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\n\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\u0012\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\rH\u0016J\u0010\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\u0010\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0001H\u0016J\u0010\u0010 \u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\b\u0010!\u001a\u00020\rH\u0016J\b\u0010\"\u001a\u00020\u001aH\u0016J\u0006\u0010#\u001a\u00020\rJ\u001c\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00040$2\u0006\u0010\u001f\u001a\u00020\u001eH\u0014J\u0012\u0010'\u001a\u0004\u0018\u00010&2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\b\u0010(\u001a\u00020\rH\u0016J\u0010\u0010*\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\rH\u0016J\b\u0010+\u001a\u00020\rH\u0016J\u0010\u0010-\u001a\u00020\u00132\u0006\u0010,\u001a\u00020\rH\u0016J\b\u0010.\u001a\u00020\rH\u0016J\u0010\u00100\u001a\u00020\u00132\u0006\u0010/\u001a\u00020\rH\u0016J\u0010\u00102\u001a\u00020\u00132\u0006\u00101\u001a\u00020\rH\u0016J\b\u00103\u001a\u00020\u001aH\u0016J\u0016\u00106\u001a\u00020\u00132\u0006\u00104\u001a\u00020\u00042\u0006\u00105\u001a\u00020\u0004J\u0006\u00107\u001a\u00020\rJ\u0006\u00108\u001a\u00020\u0013J\u0006\u00109\u001a\u00020\rJ\u0006\u0010:\u001a\u00020\rR\u0016\u0010<\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010;R\"\u0010A\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010;\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0016\u0010B\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010;R\u0016\u0010D\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010;R\u0016\u00101\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010;R\u0016\u0010H\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010J\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010;R\u001b\u0010N\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010>R\u001d\u0010S\u001a\u0004\u0018\u00010O8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bP\u0010L\u001a\u0004\bQ\u0010RR\u001b\u0010V\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bT\u0010L\u001a\u0004\bU\u0010>R\u0017\u0010[\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bY\u0010ZR\u0017\u0010a\u001a\u00020\\8\u0006\u00a2\u0006\f\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`R'\u0010i\u001a\u0012\u0012\u0004\u0012\u00020c0bj\b\u0012\u0004\u0012\u00020c`d8\u0006\u00a2\u0006\f\n\u0004\be\u0010f\u001a\u0004\bg\u0010hR3\u0010q\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020k0jj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020k`l8\u0006\u00a2\u0006\f\n\u0004\bm\u0010n\u001a\u0004\bo\u0010pR7\u0010u\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020r0jj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020r`l8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bs\u0010L\u001a\u0004\bt\u0010pR\"\u0010{\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bv\u0010G\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR\"\u0010\u007f\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b|\u0010;\u001a\u0004\b}\u0010>\"\u0004\b~\u0010@R\u001a\u0010\u0082\u0001\u001a\u00020\r8\u0006\u00a2\u0006\u000e\n\u0005\b\u0080\u0001\u0010;\u001a\u0005\b\u0081\u0001\u0010>R0\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u0083\u00012\n\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0083\u00018\u0006@BX\u0086\u000e\u00a2\u0006\u0010\n\u0006\b\u0085\u0001\u0010\u0086\u0001\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001R\u0015\u0010\u008d\u0001\u001a\u00030\u008a\u00018F\u00a2\u0006\b\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001R\u0013\u0010\u008f\u0001\u001a\u00020\u001a8F\u00a2\u0006\u0007\u001a\u0005\b\u008e\u0001\u0010ZR\u0017\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0090\u00018F\u00a2\u0006\b\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001\u00a8\u0006\u0098\u0001"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/MarkdownMsgItem;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "Lcom/tencent/mobileqq/aio/msg/i;", "Lcom/tencent/mobileqq/aio/msg/l;", "", NowProxyConstants.AccountInfoKey.A2, "content", "L2", "B2", "Lcom/tencent/android/androidbypass/richui/b;", "z2", "Lorg/json/JSONObject;", "l2", "", "g", "W0", SemanticAttributes.DbSystemValues.H2, "Landroid/content/Context;", "context", "", "Y0", "X0", "g2", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "targetMsgRecord", "b0", "", "getViewType", "newMsgItem", "l", "Lcom/tencent/aio/data/msglist/a;", "target", "isSameItem", "e2", "V0", "J2", "Lkotlin/Pair;", "o", "", "getChangePayload", "d", "isRunning", "a", "H2", "isNeed", "b", Constants.MMCCID, "msgStatusUpdated", h.F, "isRegenerate", "e", "i", "btnId", "groupId", "N2", Constants.BASE_IN_PLUGIN_VERSION, "K2", "F2", "P2", "Z", "hasMsgStatusUpdated", "E2", "()Z", "M2", "(Z)V", "isFakeLoading", "streamRunning", "Z0", "needPlayStreamAnim", ICustomDataEditor.STRING_ARRAY_PARAM_1, "b1", "Ljava/lang/String;", "ttsPlayText", "c1", "exported", "d1", "Lkotlin/Lazy;", "x2", "richForwardWhiteCanSupport", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/config/c;", "e1", "y2", "()Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/config/c;", "richSourceWhiteConfigData", "f1", ICustomDataEditor.NUMBER_PARAM_2, "hasSendEntrance", "g1", "I", ICustomDataEditor.STRING_PARAM_2, "()I", "maxGroupId", "Lcom/tencent/qqnt/kernel/nativeinterface/MarkdownElement;", "h1", "Lcom/tencent/qqnt/kernel/nativeinterface/MarkdownElement;", "r2", "()Lcom/tencent/qqnt/kernel/nativeinterface/MarkdownElement;", "markdownElement", "Ljava/util/ArrayList;", "Lcom/tencent/android/androidbypass/viewgroup/b;", "Lkotlin/collections/ArrayList;", "i1", "Ljava/util/ArrayList;", "t2", "()Ljava/util/ArrayList;", "mkElementGroupList", "Ljava/util/HashMap;", "Lcom/tencent/qqnt/markdown/data/b;", "Lkotlin/collections/HashMap;", "j1", "Ljava/util/HashMap;", "u2", "()Ljava/util/HashMap;", "mkExtDataMap", "Lcom/tencent/qqnt/markdown/data/a;", "k1", "v2", "mkExtParserMap", "l1", "w2", "()Ljava/lang/String;", "setProcessMsg", "(Ljava/lang/String;)V", "processMsg", "m1", "I2", "setProcessLoading", "isProcessLoading", ICustomDataEditor.NUMBER_PARAM_1, "C2", "isCenterTemplate", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/MarkdownMsgItem$b;", "<set-?>", "o1", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/MarkdownMsgItem$b;", "o2", "()Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/MarkdownMsgItem$b;", "inlineBtnExt", "", "q2", "()F", "mainFontSize", "m2", "bubbleType", "Lcom/tencent/qqnt/kernel/nativeinterface/InlineKeyboardElement;", "p2", "()Lcom/tencent/qqnt/kernel/nativeinterface/InlineKeyboardElement;", "inlineKeyboardElement", "mr", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "p1", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class MarkdownMsgItem extends AIOMsgItem implements i, l {
    static IPatchRedirector $redirector_;

    /* renamed from: p1, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: q1, reason: collision with root package name */
    @NotNull
    private static final MarkdownMsgItem f190965q1;

    /* renamed from: W0, reason: from kotlin metadata */
    private volatile boolean hasMsgStatusUpdated;

    /* renamed from: X0, reason: from kotlin metadata */
    private boolean isFakeLoading;

    /* renamed from: Y0, reason: from kotlin metadata */
    private boolean streamRunning;

    /* renamed from: Z0, reason: from kotlin metadata */
    private volatile boolean needPlayStreamAnim;

    /* renamed from: a1, reason: collision with root package name and from kotlin metadata */
    private boolean isRegenerate;

    /* renamed from: b1, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String ttsPlayText;

    /* renamed from: c1, reason: collision with root package name and from kotlin metadata */
    private boolean exported;

    /* renamed from: d1, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy richForwardWhiteCanSupport;

    /* renamed from: e1, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy richSourceWhiteConfigData;

    /* renamed from: f1, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy hasSendEntrance;

    /* renamed from: g1, reason: collision with root package name and from kotlin metadata */
    private final int maxGroupId;

    /* renamed from: h1, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MarkdownElement markdownElement;

    /* renamed from: i1, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<com.tencent.android.androidbypass.viewgroup.b> mkElementGroupList;

    /* renamed from: j1, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, com.tencent.qqnt.markdown.data.b> mkExtDataMap;

    /* renamed from: k1, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mkExtParserMap;

    /* renamed from: l1, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String processMsg;

    /* renamed from: m1, reason: collision with root package name and from kotlin metadata */
    private boolean isProcessLoading;

    /* renamed from: n1, reason: collision with root package name and from kotlin metadata */
    private final boolean isCenterTemplate;

    /* renamed from: o1, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b inlineBtnExt;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/MarkdownMsgItem$a;", "", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/MarkdownMsgItem;", "EmptyMsgItem", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/MarkdownMsgItem;", "a", "()Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/MarkdownMsgItem;", "", "BUBBLE_TYPE_DEFAULT", "I", "BUBBLE_TYPE_NO_BG", "", "CENTER_LAYOUT", "Ljava/lang/String;", "MAIN_FONT_SMALL", "TAG", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.markdown.MarkdownMsgItem$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final MarkdownMsgItem a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return MarkdownMsgItem.f190965q1;
            }
            return (MarkdownMsgItem) iPatchRedirector.redirect((short) 2, (Object) this);
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
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00032\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0006\u0010\u0003\u001a\u00020\u0002R>\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000bR2\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00050\rj\b\u0012\u0004\u0012\u00020\u0005`\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/MarkdownMsgItem$b;", "", "", "c", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "a", "Ljava/util/HashMap;", "()Ljava/util/HashMap;", "setSelectedButtons", "(Ljava/util/HashMap;)V", "selectedButtons", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "b", "Ljava/util/HashSet;", "()Ljava/util/HashSet;", "setVisitedButtons", "(Ljava/util/HashSet;)V", "visitedButtons", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private HashMap<String, String> selectedButtons;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private HashSet<String> visitedButtons;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/MarkdownMsgItem$b$a;", "", "", "bytes", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/MarkdownMsgItem$b;", "a", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.markdown.MarkdownMsgItem$b$a, reason: from kotlin metadata */
        /* loaded from: classes11.dex */
        public static final class Companion {
            static IPatchRedirector $redirector_;

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                    return;
                }
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
            }

            @NotNull
            public final b a(@Nullable byte[] bytes) {
                boolean z16;
                b result;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (b) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bytes);
                }
                if (bytes != null) {
                    if (bytes.length == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        String str = new String(bytes, Charsets.UTF_8);
                        try {
                            result = (b) new Gson().fromJson(str, b.class);
                        } catch (JsonSyntaxException unused) {
                            QLog.e("MarkdownMsgItem", 1, "[fromBytes] error. content=" + str);
                            result = new b();
                        }
                        Intrinsics.checkNotNullExpressionValue(result, "result");
                        return result;
                    }
                }
                return new b();
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
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61233);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 7)) {
                redirector.redirect((short) 7);
            } else {
                INSTANCE = new Companion(null);
            }
        }

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.selectedButtons = new HashMap<>();
                this.visitedButtons = new HashSet<>();
            }
        }

        @NotNull
        public final HashMap<String, String> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (HashMap) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.selectedButtons;
        }

        @NotNull
        public final HashSet<String> b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (HashSet) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.visitedButtons;
        }

        @NotNull
        public final byte[] c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (byte[]) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            String json = new Gson().toJson(this);
            Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(this)");
            byte[] bytes = json.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            return bytes;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/markdown/MarkdownMsgItem$c", "Lcom/tencent/android/androidbypass/richui/b;", "", "viewId", "key", "source", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class c implements com.tencent.android.androidbypass.richui.b {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MarkdownMsgItem.this);
            }
        }

        @Override // com.tencent.android.androidbypass.richui.b
        @NotNull
        public String a(@NotNull String viewId, @NotNull String key, @NotNull String source) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, this, viewId, key, source);
            }
            Intrinsics.checkNotNullParameter(viewId, "viewId");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(source, "source");
            com.tencent.mobileqq.aio.msglist.holder.component.markdown.config.c y26 = MarkdownMsgItem.this.y2();
            if (y26 != null && !y26.a(MarkdownMsgItem.this.r2().mdExtType, source)) {
                return "";
            }
            return source;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61257);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 48)) {
            redirector.redirect((short) 48);
        } else {
            INSTANCE = new Companion(null);
            f190965q1 = new MarkdownMsgItem(AIOMsgItem.INSTANCE.a());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Removed duplicated region for block: B:60:0x014d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MarkdownMsgItem(@NotNull MsgRecord mr5) {
        super(mr5);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Integer valueOf;
        int i3;
        Lazy lazy4;
        boolean z16;
        boolean z17;
        MarkdownStyle markdownStyle;
        boolean z18;
        MarkdownElementExtInfo mdExtInfo;
        MarkdownStyle style;
        String str;
        Intrinsics.checkNotNullParameter(mr5, "mr");
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z19 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mr5);
            return;
        }
        this.ttsPlayText = "";
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<Boolean>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.markdown.MarkdownMsgItem$richForwardWhiteCanSupport$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MarkdownMsgItem.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Boolean) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                com.tencent.mobileqq.aio.msglist.holder.component.markdown.config.a aVar = (com.tencent.mobileqq.aio.msglist.holder.component.markdown.config.a) ((IAIOUniteConfigApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOUniteConfigApi.class)).loadConfig("forward_rich_msg_white");
                boolean z26 = false;
                if (aVar != null && aVar.a(MarkdownMsgItem.this.r2().mdExtType)) {
                    z26 = true;
                }
                return Boolean.valueOf(z26);
            }
        });
        this.richForwardWhiteCanSupport = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) MarkdownMsgItem$richSourceWhiteConfigData$2.INSTANCE);
        this.richSourceWhiteConfigData = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) MarkdownMsgItem$hasSendEntrance$2.INSTANCE);
        this.hasSendEntrance = lazy3;
        ArrayList<MsgElement> arrayList = getMsgRecord().elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msgRecord.elements");
        Iterator<T> it = arrayList.iterator();
        if (!it.hasNext()) {
            valueOf = null;
        } else {
            valueOf = Integer.valueOf(((MsgElement) it.next()).elementGroupId);
            while (it.hasNext()) {
                Integer valueOf2 = Integer.valueOf(((MsgElement) it.next()).elementGroupId);
                if (valueOf.compareTo(valueOf2) < 0) {
                    valueOf = valueOf2;
                }
            }
        }
        Integer num = valueOf;
        if (num != null) {
            i3 = num.intValue();
        } else {
            i3 = 0;
        }
        this.maxGroupId = i3;
        MarkdownElement markdownElement = new MarkdownElement();
        StringBuilder sb5 = new StringBuilder();
        ArrayList<MsgElement> arrayList2 = getMsgRecord().elements;
        Intrinsics.checkNotNullExpressionValue(arrayList2, "msgRecord.elements");
        for (MsgElement msgElement : arrayList2) {
            if (msgElement.elementType == 14) {
                MarkdownElement markdownElement2 = msgElement.markdownElement;
                if (markdownElement2 != null) {
                    str = markdownElement2.getContent();
                } else {
                    str = null;
                }
                if (str == null) {
                    str = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(str, "it.markdownElement?.getContent() ?: \"\"");
                }
                sb5.append(str);
            }
            MarkdownElement markdownElement3 = msgElement.markdownElement;
            if (markdownElement3 != null && (style = markdownElement3.style) != null) {
                Intrinsics.checkNotNullExpressionValue(style, "style");
                markdownElement.style = style;
            }
            MarkdownElement markdownElement4 = msgElement.markdownElement;
            if (markdownElement4 != null) {
                markdownElement.mdExtType = markdownElement4.mdExtType;
            }
            if (markdownElement4 != null && (mdExtInfo = markdownElement4.mdExtInfo) != null) {
                Intrinsics.checkNotNullExpressionValue(mdExtInfo, "mdExtInfo");
                markdownElement.mdExtInfo = mdExtInfo;
            }
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "stringBuilder.toString()");
        markdownElement.content = com.tencent.qqnt.aio.msg.d.j(this) ? L2(sb6) : sb6;
        this.markdownElement = markdownElement;
        this.mkElementGroupList = new ArrayList<>();
        this.mkExtDataMap = new HashMap<>();
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<HashMap<String, com.tencent.qqnt.markdown.data.a>>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.markdown.MarkdownMsgItem$mkExtParserMap$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MarkdownMsgItem.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final HashMap<String, com.tencent.qqnt.markdown.data.a> invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (HashMap) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                HashMap<String, com.tencent.qqnt.markdown.data.a> hashMap = new HashMap<>();
                MarkdownMsgItem markdownMsgItem = MarkdownMsgItem.this;
                hashMap.put("quoteArea", new com.tencent.qqnt.markdown.data.quote.h(markdownMsgItem.u2()));
                hashMap.put("multiPic", new com.tencent.qqnt.markdown.data.multipic.d(markdownMsgItem.u2()));
                return hashMap;
            }
        });
        this.mkExtParserMap = lazy4;
        this.processMsg = B2();
        String str2 = markdownElement.content;
        Intrinsics.checkNotNullExpressionValue(str2, "markdownElement.content");
        if (str2.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (this.processMsg.length() > 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (z18) {
                z17 = true;
                this.isProcessLoading = z17;
                markdownStyle = markdownElement.style;
                if (!"hide_avatar_and_center".equals(markdownStyle != null ? markdownStyle.layOut : null) && !com.tencent.qqnt.aio.msg.d.j(this)) {
                    z19 = false;
                }
                this.isCenterTemplate = z19;
            }
        }
        z17 = false;
        this.isProcessLoading = z17;
        markdownStyle = markdownElement.style;
        if (!"hide_avatar_and_center".equals(markdownStyle != null ? markdownStyle.layOut : null)) {
            z19 = false;
        }
        this.isCenterTemplate = z19;
    }

    private final String A2() {
        String str = this.markdownElement.content;
        if (str != null) {
            new Regex("[*_-]").replace(str, "");
            new Regex("[`~]").replace(str, "");
            new Regex("\\[([^\\]]+)\\]\\([^)]+\\)").replace(str, "$1");
            new Regex("!\\[([^\\]]+)\\]\\([^)]+\\)").replace(str, "$1");
        } else {
            str = null;
        }
        return String.valueOf(str);
    }

    private final String B2() {
        String str;
        String str2;
        boolean z16;
        for (int size = getMsgRecord().elements.size() - 1; -1 < size; size--) {
            MsgElement msgElement = getMsgRecord().elements.get(size);
            if (msgElement.elementType == 14) {
                MarkdownElement markdownElement = msgElement.markdownElement;
                boolean z17 = false;
                if (markdownElement != null && (str2 = markdownElement.processMsg) != null) {
                    if (str2.length() > 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        z17 = true;
                    }
                }
                if (z17) {
                    MarkdownElement markdownElement2 = msgElement.markdownElement;
                    if (markdownElement2 != null) {
                        str = markdownElement2.processMsg;
                    } else {
                        str = null;
                    }
                    if (str == null) {
                        return "";
                    }
                    return str;
                }
            }
        }
        return "";
    }

    private final String L2(String content) {
        String removePrefix;
        String removeSuffix;
        String str = "";
        try {
            removePrefix = StringsKt__StringsKt.removePrefix(content, (CharSequence) "[Placeholder](mqqapi://markdown/template?id=3&");
            removeSuffix = StringsKt__StringsKt.removeSuffix(removePrefix, (CharSequence) ")");
            JSONObject jSONObject = new JSONObject(removeSuffix);
            String str2 = ((Object) "") + "title=" + URLEncoder.encode(jSONObject.optString("title"), "UTF-8");
            str = ((Object) str2) + "&desc=" + URLEncoder.encode(jSONObject.optString("desc"), "UTF-8");
            JSONArray optJSONArray = jSONObject.optJSONArray(ComicCancelRedPointPopItemData.JSON_KEY_TAGS);
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                int i3 = 0;
                while (i3 < length) {
                    String encode = URLEncoder.encode(optJSONArray.getString(i3), "UTF-8");
                    i3++;
                    str = ((Object) str) + "&tag" + i3 + ContainerUtils.KEY_VALUE_DELIMITER + encode;
                }
            }
        } catch (Exception e16) {
            QLog.d("MarkdownMsgItem", 1, "parseMiniProfileContent Exception=" + e16);
        }
        return "[Placeholder](mqqapi://markdown/template?id=3&" + ((Object) str) + ")";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O2(int i3, String str) {
        QLog.d("MarkdownMsgItem", 1, "setSelectedBtn result=" + i3 + ", msg=" + str);
    }

    private final JSONObject l2() {
        int min;
        com.tencent.mobileqq.aio.msglist.holder.skin.padding.a aVar;
        com.tencent.mobileqq.aio.msglist.holder.component.markdown.view.a aVar2;
        int i3;
        if (!com.tencent.mobileqq.aio.utils.d.R(this)) {
            return new JSONObject();
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("leftProgressVisible", isSelf());
        jSONObject.put("rightProgressVisible", !isSelf());
        if (FontSettingManager.isFontSizeLarge()) {
            AIOBubbleSkinInfo x06 = x0();
            if (x06 != null) {
                aVar = x06.b();
            } else {
                aVar = null;
            }
            if (aVar instanceof com.tencent.mobileqq.aio.msglist.holder.component.markdown.view.a) {
                aVar2 = (com.tencent.mobileqq.aio.msglist.holder.component.markdown.view.a) aVar;
            } else {
                aVar2 = null;
            }
            if (aVar2 != null) {
                if (isSelf()) {
                    i3 = aVar2.c();
                } else {
                    i3 = aVar2.d();
                }
            } else {
                i3 = 0;
            }
            ViewUtils viewUtils = ViewUtils.f352270a;
            min = Math.min(viewUtils.f((a.C7329a.g(a.C7329a.f192417a, false, 1, null) - viewUtils.b(36)) - i3), 227);
        } else {
            min = Math.min(ViewUtils.f352270a.f(a.C7329a.g(a.C7329a.f192417a, false, 1, null)), 263);
        }
        jSONObject.put("width", min);
        return jSONObject;
    }

    private final boolean n2() {
        return ((Boolean) this.hasSendEntrance.getValue()).booleanValue();
    }

    private final boolean x2() {
        return ((Boolean) this.richForwardWhiteCanSupport.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.aio.msglist.holder.component.markdown.config.c y2() {
        return (com.tencent.mobileqq.aio.msglist.holder.component.markdown.config.c) this.richSourceWhiteConfigData.getValue();
    }

    private final com.tencent.android.androidbypass.richui.b z2() {
        if (!com.tencent.mobileqq.aio.utils.d.R(this)) {
            return null;
        }
        return new c();
    }

    public final boolean C2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return this.isCenterTemplate;
    }

    public final boolean D2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return ((Boolean) iPatchRedirector.redirect((short) 44, (Object) this)).booleanValue();
        }
        return this.exported;
    }

    public final boolean E2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.isFakeLoading;
    }

    public final boolean F2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return ((Boolean) iPatchRedirector.redirect((short) 46, (Object) this)).booleanValue();
        }
        if (this.markdownElement.mdExtType == 1) {
            return true;
        }
        return false;
    }

    public boolean G2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Boolean) iPatchRedirector.redirect((short) 37, (Object) this)).booleanValue();
        }
        return this.hasMsgStatusUpdated;
    }

    public boolean H2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Boolean) iPatchRedirector.redirect((short) 35, (Object) this)).booleanValue();
        }
        return this.needPlayStreamAnim;
    }

    public final boolean I2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return this.isProcessLoading;
    }

    public final boolean J2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this)).booleanValue();
        }
        return !com.tencent.mobileqq.aio.utils.d.R(this);
    }

    public final void K2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this);
            return;
        }
        StopWatch i3 = new StopWatch("AIOMarkdown.parseMarkdown", true).i();
        this.mkElementGroupList.clear();
        this.mkExtDataMap.clear();
        RichParser richParser = new RichParser();
        String str = this.markdownElement.content;
        Intrinsics.checkNotNullExpressionValue(str, "markdownElement.content");
        com.tencent.qqnt.rich.c c16 = richParser.c(str, new com.tencent.qqnt.markdown.data.d(com.tencent.qqnt.aio.msg.d.g(this)), l2(), z2());
        this.mkElementGroupList.addAll(c16.a());
        this.mkExtDataMap.putAll(c16.b());
        StopWatch.c(i3, null, 1, null);
    }

    public final void M2(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            this.isFakeLoading = z16;
        }
    }

    public final void N2(@NotNull String btnId, @NotNull String groupId) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this, (Object) btnId, (Object) groupId);
            return;
        }
        Intrinsics.checkNotNullParameter(btnId, "btnId");
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        MsgElement firstTypeElement = getFirstTypeElement(17);
        if (firstTypeElement == null) {
            return;
        }
        if (this.inlineBtnExt == null) {
            this.inlineBtnExt = new b();
        }
        if (groupId.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            b bVar = this.inlineBtnExt;
            Intrinsics.checkNotNull(bVar);
            bVar.a().put(groupId, btnId);
        } else {
            b bVar2 = this.inlineBtnExt;
            Intrinsics.checkNotNull(bVar2);
            bVar2.b().add(btnId);
        }
        b bVar3 = this.inlineBtnExt;
        Intrinsics.checkNotNull(bVar3);
        firstTypeElement.extBufForUI = bVar3.c();
        QLog.d("MarkdownMsgItem", 1, "setSelectedBtn id=" + btnId + " groupId=" + groupId + " seq=" + getMsgSeq());
        w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null) {
            Contact contact = new Contact(getMsgRecord().chatType, getMsgRecord().peerUid, "");
            long q06 = q0();
            long j3 = firstTypeElement.elementId;
            byte[] bArr = firstTypeElement.extBufForUI;
            Intrinsics.checkNotNullExpressionValue(bArr, "element.extBufForUI");
            e16.updateElementExtBufForUI(contact, q06, j3, bArr, new IOperateCallback() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.markdown.g
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    MarkdownMsgItem.O2(i3, str);
                }
            });
        }
    }

    public final boolean P2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return ((Boolean) iPatchRedirector.redirect((short) 47, (Object) this)).booleanValue();
        }
        if (!x2()) {
            return false;
        }
        if (!F2()) {
            return true;
        }
        if (!isSelf() || !n2()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public int V0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Integer) iPatchRedirector.redirect((short) 29, (Object) this)).intValue();
        }
        if (e2()) {
            return 0;
        }
        return 8;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public boolean W0() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        if (!super.W0()) {
            return false;
        }
        String A2 = A2();
        this.ttsPlayText = A2;
        if (A2.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public void X0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
        } else {
            super.X0();
            Y1(com.tencent.mobileqq.aio.msg.a.a(this));
        }
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public void Y0(@Nullable Context context) {
        Activity activity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) context);
            return;
        }
        super.Y0(context);
        byte[] bArr = null;
        if (context != null) {
            Y1(n.f194168a.f(context, this));
            if (context instanceof Activity) {
                activity = (Activity) context;
            } else {
                activity = null;
            }
            if (activity != null) {
                O1((MsgRecordParams) activity.getIntent().getParcelableExtra("key_multiforward_root_msg_record"));
            }
        }
        MsgElement firstTypeElement = getFirstTypeElement(17);
        b.Companion companion = b.INSTANCE;
        if (firstTypeElement != null) {
            bArr = firstTypeElement.extBufForUI;
        }
        this.inlineBtnExt = companion.a(bArr);
        if (QLog.isColorLevel() && firstTypeElement != null) {
            b bVar = this.inlineBtnExt;
            Intrinsics.checkNotNull(bVar);
            int size = bVar.a().size();
            b bVar2 = this.inlineBtnExt;
            Intrinsics.checkNotNull(bVar2);
            QLog.d("MarkdownMsgItem", 2, "InlineBtnExt fromJson size=" + (size + bVar2.b().size()) + " seq=" + getMsgSeq());
        }
        K2();
    }

    @Override // com.tencent.mobileqq.aio.msg.l
    public void a(boolean isRunning) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, isRunning);
        } else {
            this.streamRunning = isRunning;
        }
    }

    @Override // com.tencent.mobileqq.aio.msg.l
    public void b(boolean isNeed) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, isNeed);
        } else {
            this.needPlayStreamAnim = isNeed;
        }
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public AIOMsgItem b0(@NotNull MsgRecord targetMsgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (AIOMsgItem) iPatchRedirector.redirect((short) 24, (Object) this, (Object) targetMsgRecord);
        }
        Intrinsics.checkNotNullParameter(targetMsgRecord, "targetMsgRecord");
        return new MarkdownMsgItem(targetMsgRecord);
    }

    @Override // com.tencent.mobileqq.aio.msg.l
    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Boolean) iPatchRedirector.redirect((short) 33, (Object) this)).booleanValue();
        }
        return this.streamRunning;
    }

    @Override // com.tencent.mobileqq.aio.msg.l
    public void e(boolean isRegenerate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, isRegenerate);
        } else {
            this.isRegenerate = isRegenerate;
        }
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public boolean e2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this)).booleanValue();
        }
        if (!com.tencent.qqnt.aio.msg.d.j(this) && !this.isCenterTemplate && !this.isProcessLoading && com.tencent.qqnt.aio.msg.d.g(this) != 1 && !F2()) {
            return super.e2();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.aio.msg.i
    public boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        return this.isProcessLoading;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public boolean g2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem, com.tencent.aio.data.msglist.a
    @Nullable
    public Object getChangePayload(@NotNull com.tencent.aio.data.msglist.a target) {
        MarkdownMsgItem markdownMsgItem;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return iPatchRedirector.redirect((short) 32, (Object) this, (Object) target);
        }
        Intrinsics.checkNotNullParameter(target, "target");
        HashMap hashMap = new HashMap();
        Object changePayload = super.getChangePayload(target);
        try {
            if (changePayload instanceof Map) {
                hashMap.putAll((Map) changePayload);
            }
        } catch (Exception e16) {
            QLog.e("MarkdownMsgItem", 1, e16, new Object[0]);
            if (!com.tencent.qqnt.util.b.f362976b.isPublicVersion()) {
                throw e16;
            }
        }
        if (target instanceof MarkdownMsgItem) {
            markdownMsgItem = (MarkdownMsgItem) target;
        } else {
            markdownMsgItem = null;
        }
        if (markdownMsgItem != null) {
            if (markdownMsgItem.streamRunning != this.streamRunning) {
                hashMap.put(AIOMsgItemPayloadType.MARKDOWN_STREAM_RUNNING_PAYLOAD, a.y.f192678a);
            }
            if (markdownMsgItem.isFakeLoading != this.isFakeLoading) {
                hashMap.put(AIOMsgItemPayloadType.LOADING_CHANGE_PAYLOAD, new com.tencent.mobileqq.aio.msglist.payload.a());
            }
        }
        return hashMap;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem, com.tencent.aio.data.msglist.a
    public int getViewType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this)).intValue();
        }
        if (this.isCenterTemplate) {
            return 99;
        }
        if (!isSelf()) {
            return 25;
        }
        return 26;
    }

    @Override // com.tencent.mobileqq.aio.msg.l
    public void h(boolean msgStatusUpdated) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, msgStatusUpdated);
        } else {
            this.hasMsgStatusUpdated = msgStatusUpdated;
        }
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public String h2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.ttsPlayText;
    }

    @Override // com.tencent.mobileqq.aio.msg.l
    public int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Integer) iPatchRedirector.redirect((short) 41, (Object) this)).intValue();
        }
        return this.maxGroupId;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem, com.tencent.aio.data.msglist.a
    public boolean isSameItem(@NotNull com.tencent.aio.data.msglist.a target) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this, (Object) target)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(target, "target");
        if ((target instanceof MarkdownMsgItem) && (this.isFakeLoading || ((MarkdownMsgItem) target).isFakeLoading)) {
            MarkdownMsgItem markdownMsgItem = (MarkdownMsgItem) target;
            if (Intrinsics.areEqual(getMsgRecord().peerUid, markdownMsgItem.getMsgRecord().peerUid) && Intrinsics.areEqual(getMsgRecord().senderUid, markdownMsgItem.getMsgRecord().senderUid) && getMsgRecord().msgSeq == markdownMsgItem.getMsgRecord().msgSeq && getMsgRecord().msgType == markdownMsgItem.getMsgRecord().msgType) {
                z16 = true;
            } else {
                z16 = false;
            }
            QLog.d("MarkdownMsgItem", 1, "fake loading isSame=" + z16);
            return z16;
        }
        return super.isSameItem(target);
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public void l(@NotNull AIOMsgItem newMsgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) newMsgItem);
            return;
        }
        Intrinsics.checkNotNullParameter(newMsgItem, "newMsgItem");
        super.l(newMsgItem);
        if (newMsgItem instanceof MarkdownMsgItem) {
            MarkdownMsgItem markdownMsgItem = (MarkdownMsgItem) newMsgItem;
            markdownMsgItem.hasMsgStatusUpdated = this.hasMsgStatusUpdated;
            markdownMsgItem.isFakeLoading = this.isFakeLoading;
            markdownMsgItem.streamRunning = this.streamRunning;
            markdownMsgItem.needPlayStreamAnim = this.needPlayStreamAnim;
            markdownMsgItem.isRegenerate = this.isRegenerate;
            markdownMsgItem.inlineBtnExt = this.inlineBtnExt;
            markdownMsgItem.isProcessLoading = this.isProcessLoading;
            markdownMsgItem.processMsg = this.processMsg;
            markdownMsgItem.mkElementGroupList.clear();
            markdownMsgItem.mkElementGroupList.addAll(this.mkElementGroupList);
            markdownMsgItem.mkExtDataMap.clear();
            markdownMsgItem.mkExtDataMap.putAll(this.mkExtDataMap);
            markdownMsgItem.v2().clear();
            markdownMsgItem.v2().putAll(v2());
        }
    }

    public final int m2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        MarkdownStyle markdownStyle = this.markdownElement.style;
        if (markdownStyle != null) {
            return markdownStyle.bubbleType;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public Pair<Boolean, String> o(@NotNull com.tencent.aio.data.msglist.a target) {
        MarkdownMsgItem markdownMsgItem;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (Pair) iPatchRedirector.redirect((short) 31, (Object) this, (Object) target);
        }
        Intrinsics.checkNotNullParameter(target, "target");
        if (target instanceof MarkdownMsgItem) {
            markdownMsgItem = (MarkdownMsgItem) target;
        } else {
            markdownMsgItem = null;
        }
        if (markdownMsgItem != null) {
            if (markdownMsgItem.streamRunning != this.streamRunning) {
                return new Pair<>(Boolean.FALSE, "streamRunning");
            }
            if (markdownMsgItem.isFakeLoading != this.isFakeLoading) {
                return new Pair<>(Boolean.FALSE, "fakeLoading");
            }
        }
        return super.o(target);
    }

    @Nullable
    public final b o2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (b) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return this.inlineBtnExt;
    }

    @Nullable
    public final InlineKeyboardElement p2() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (InlineKeyboardElement) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        ArrayList<MsgElement> arrayList = getMsgRecord().elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msgRecord.elements");
        for (MsgElement msgElement : arrayList) {
            if (msgElement.elementType == 17) {
                InlineKeyboardElement inlineKeyboardElement = msgElement.inlineKeyboardElement;
                ArrayList<InlineKeyboardRow> arrayList2 = inlineKeyboardElement.rows;
                if (arrayList2 != null && !arrayList2.isEmpty()) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16) {
                    return null;
                }
                return inlineKeyboardElement;
            }
        }
        return null;
    }

    public final float q2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Float) iPatchRedirector.redirect((short) 14, (Object) this)).floatValue();
        }
        MarkdownStyle markdownStyle = this.markdownElement.style;
        if (markdownStyle == null || !Intrinsics.areEqual(markdownStyle.mainFontSize, NtFaceConstant.SMALL)) {
            return 16.0f;
        }
        return 14.0f;
    }

    @NotNull
    public final MarkdownElement r2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (MarkdownElement) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.markdownElement;
    }

    public final int s2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.maxGroupId;
    }

    @NotNull
    public final ArrayList<com.tencent.android.androidbypass.viewgroup.b> t2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ArrayList) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mkElementGroupList;
    }

    @NotNull
    public final HashMap<String, com.tencent.qqnt.markdown.data.b> u2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (HashMap) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.mkExtDataMap;
    }

    @NotNull
    public final HashMap<String, com.tencent.qqnt.markdown.data.a> v2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (HashMap) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return (HashMap) this.mkExtParserMap.getValue();
    }

    @NotNull
    public final String w2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.processMsg;
    }
}
