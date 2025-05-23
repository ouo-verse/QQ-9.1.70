package com.tencent.mobileqq.aio.msg;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msglist.payload.AIOMsgItemPayloadType;
import com.tencent.mobileqq.aio.msglist.payload.a;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.font.IFontManager;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.aio.adapter.a;
import com.tencent.qqnt.aio.adapter.api.IAIOJumpAction;
import com.tencent.qqnt.aio.adapter.api.IDialogApi;
import com.tencent.qqnt.aio.adapter.api.IQQTextApi;
import com.tencent.qqnt.aio.widget.AIOMsgTextView;
import com.tencent.qqnt.emotion.text.style.api.IEmojiSpanService;
import com.tencent.qqnt.kernel.nativeinterface.FaceElement;
import com.tencent.qqnt.kernel.nativeinterface.LinkInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgAttributeInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.TextElement;
import com.tencent.qqnt.kernel.nativeinterface.VASMsgElement;
import com.tencent.qqnt.kernel.nativeinterface.VASMsgIceBreak;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b/\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0016\u0018\u0000 \u0087\u00012\u00020\u00012\u00020\u0002:\u0002+.B\u0012\u0012\u0007\u0010\u0084\u0001\u001a\u00020\u001d\u00a2\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0002J\u001c\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0014J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0012\u0010\u0016\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016J\b\u0010\u0018\u001a\u00020\u0012H\u0016J\u0006\u0010\u0019\u001a\u00020\u0003J\b\u0010\u001a\u001a\u00020\u0007H\u0016J\b\u0010\u001b\u001a\u00020\u0007H\u0016J\u0006\u0010\u001c\u001a\u00020\u0007J\u0010\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0010\u0010!\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0001H\u0016J\b\u0010#\u001a\u00020\"H\u0016J\b\u0010$\u001a\u00020\u0003H\u0004J\u000e\u0010&\u001a\b\u0012\u0004\u0012\u00020\t0%H\u0016J\b\u0010'\u001a\u00020\u0012H\u0016J\b\u0010(\u001a\u00020\u0003H\u0016J\b\u0010)\u001a\u00020\u0003H\u0016J\u0010\u0010+\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0003H\u0016J\b\u0010,\u001a\u00020\u0003H\u0016J\u0010\u0010.\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u0003H\u0016J\b\u0010/\u001a\u00020\u0003H\u0016J\u0010\u00101\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u0003H\u0016J\u0010\u00103\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u0003H\u0016J\b\u00104\u001a\u00020\u0003H\u0016J\b\u00105\u001a\u00020\"H\u0016R(\u0010:\u001a\u0004\u0018\u00010\t2\b\u00106\u001a\u0004\u0018\u00010\t8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0017\u00107\u001a\u0004\b8\u00109R\"\u0010@\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R$\u0010D\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u00107\u001a\u0004\bA\u00109\"\u0004\bB\u0010CR\u0016\u0010F\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010;R\u0016\u0010H\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010;R\u0016\u00102\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010;R\u0017\u0010N\u001a\u00020\"8\u0006\u00a2\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR(\u0010Q\u001a\u0004\u0018\u00010\t2\b\u00106\u001a\u0004\u0018\u00010\t8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bO\u00107\u001a\u0004\bP\u00109R$\u0010T\u001a\u00020\u00032\u0006\u00106\u001a\u00020\u00038\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bR\u0010;\u001a\u0004\bS\u0010=R$\u0010Y\u001a\u00020U2\u0006\u00106\u001a\u00020U8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b'\u0010V\u001a\u0004\bW\u0010XR\u0016\u0010[\u001a\u00020U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010VR\u0016\u0010]\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010;R(\u0010c\u001a\u0004\u0018\u00010^2\b\u00106\u001a\u0004\u0018\u00010^8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b_\u0010`\u001a\u0004\ba\u0010bR$\u0010k\u001a\u0004\u0018\u00010d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\be\u0010f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\u0018\u0010o\u001a\u0004\u0018\u00010l8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010nR'\u0010w\u001a\u0012\u0012\u0004\u0012\u00020q0pj\b\u0012\u0004\u0012\u00020q`r8\u0006\u00a2\u0006\f\n\u0004\bs\u0010t\u001a\u0004\bu\u0010vR(\u0010\u007f\u001a\b\u0018\u00010xR\u00020\u00008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\by\u0010z\u001a\u0004\b{\u0010|\"\u0004\b}\u0010~R\u0015\u0010\u0081\u0001\u001a\u0004\u0018\u00010\t8F\u00a2\u0006\u0007\u001a\u0005\b\u0080\u0001\u00109R\u0015\u0010\u0083\u0001\u001a\u0004\u0018\u00010\t8F\u00a2\u0006\u0007\u001a\u0005\b\u0082\u0001\u00109\u00a8\u0006\u0088\u0001"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/ae;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "Lcom/tencent/mobileqq/aio/msg/l;", "", "l2", "Landroid/content/Context;", "context", "", "F2", "", "k2", Constants.MMCCID, "Landroid/text/style/ClickableSpan;", ICustomDataEditor.NUMBER_PARAM_2, ICustomDataEditor.STRING_PARAM_2, "Lcom/tencent/aio/data/msglist/a;", "target", "Lkotlin/Pair;", "", "o", "", "getChangePayload", "Y0", "W0", SemanticAttributes.DbSystemValues.H2, NowProxyConstants.AccountInfoKey.A2, "X0", "J2", "m2", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "targetMsgRecord", "b0", "newMsgItem", "l", "", "getViewType", "C2", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "f1", "g2", "d", "isRunning", "a", Constants.BASE_IN_PLUGIN_VERSION, "isNeed", "b", "B2", "msgStatusUpdated", tl.h.F, "isRegenerate", "e", "E2", "i", "<set-?>", "Ljava/lang/CharSequence;", "u2", "()Ljava/lang/CharSequence;", "qqText", "Z", "o2", "()Z", "H2", "(Z)V", "disableAutoReplySpan", "y2", "I2", "(Ljava/lang/CharSequence;)V", "streamText", "Z0", "needPlayStreamAnim", ICustomDataEditor.STRING_ARRAY_PARAM_1, "hasMsgStatusUpdated", "b1", "c1", "I", "t2", "()I", "maxGroupId", "d1", "getQqTextWithoutMagic", "qqTextWithoutMagic", "e1", "z2", "isAllEmo", "", UserInfo.SEX_FEMALE, "v2", "()F", "qqTextSize", "g1", "originTextSize", "h1", "streamRunning", "Landroid/graphics/drawable/Drawable;", "i1", "Landroid/graphics/drawable/Drawable;", "q2", "()Landroid/graphics/drawable/Drawable;", "fontDrawable", "Lcom/tencent/qqnt/kernel/nativeinterface/LinkInfo;", "j1", "Lcom/tencent/qqnt/kernel/nativeinterface/LinkInfo;", "r2", "()Lcom/tencent/qqnt/kernel/nativeinterface/LinkInfo;", "setLinkInfo", "(Lcom/tencent/qqnt/kernel/nativeinterface/LinkInfo;)V", "linkInfo", "Landroid/graphics/Typeface;", "k1", "Landroid/graphics/Typeface;", "fontTypeface", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "Lkotlin/collections/ArrayList;", "l1", "Ljava/util/ArrayList;", "p2", "()Ljava/util/ArrayList;", "filteredElements", "Lcom/tencent/mobileqq/aio/msg/ae$a;", "m1", "Lcom/tencent/mobileqq/aio/msg/ae$a;", "getAutoReplySpan", "()Lcom/tencent/mobileqq/aio/msg/ae$a;", "setAutoReplySpan", "(Lcom/tencent/mobileqq/aio/msg/ae$a;)V", "autoReplySpan", "w2", "showText", "x2", "showTextWithoutAutoReply", "msgRecord", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", ICustomDataEditor.NUMBER_PARAM_1, "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public class ae extends AIOMsgItem implements l {
    static IPatchRedirector $redirector_;

    /* renamed from: n1, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: o1, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    @NotNull
    private static final ae f190114o1;

    /* renamed from: p1, reason: collision with root package name */
    private static final float f190115p1;

    /* renamed from: W0, reason: from kotlin metadata */
    @Nullable
    private CharSequence qqText;

    /* renamed from: X0, reason: from kotlin metadata */
    private boolean disableAutoReplySpan;

    /* renamed from: Y0, reason: from kotlin metadata */
    @Nullable
    private CharSequence streamText;

    /* renamed from: Z0, reason: from kotlin metadata */
    private volatile boolean needPlayStreamAnim;

    /* renamed from: a1, reason: collision with root package name and from kotlin metadata */
    private volatile boolean hasMsgStatusUpdated;

    /* renamed from: b1, reason: collision with root package name and from kotlin metadata */
    private boolean isRegenerate;

    /* renamed from: c1, reason: collision with root package name and from kotlin metadata */
    private final int maxGroupId;

    /* renamed from: d1, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CharSequence qqTextWithoutMagic;

    /* renamed from: e1, reason: collision with root package name and from kotlin metadata */
    private boolean isAllEmo;

    /* renamed from: f1, reason: collision with root package name and from kotlin metadata */
    private float qqTextSize;

    /* renamed from: g1, reason: collision with root package name and from kotlin metadata */
    private float originTextSize;

    /* renamed from: h1, reason: collision with root package name and from kotlin metadata */
    private boolean streamRunning;

    /* renamed from: i1, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Drawable fontDrawable;

    /* renamed from: j1, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinkInfo linkInfo;

    /* renamed from: k1, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Typeface fontTypeface;

    /* renamed from: l1, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<MsgElement> filteredElements;

    /* renamed from: m1, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a autoReplySpan;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/ae$a;", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", "view", "", NodeProps.ON_CLICK, "Landroid/text/TextPaint;", "ds", "updateDrawState", "<init>", "(Lcom/tencent/mobileqq/aio/msg/ae;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public final class a extends ClickableSpan {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/aio/msg/ae$a$a", "Lcom/tencent/qqnt/aio/adapter/api/IDialogApi$a;", "", "onConfirm", "onCancel", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.aio.msg.ae$a$a, reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public static final class C7291a implements IDialogApi.a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Context f190130a;

            C7291a(Context context) {
                this.f190130a = context;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
                }
            }

            @Override // com.tencent.qqnt.aio.adapter.api.IDialogApi.a
            public void onCancel() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this);
                }
            }

            @Override // com.tencent.qqnt.aio.adapter.api.IDialogApi.a
            public void onConfirm() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                IAIOJumpAction iAIOJumpAction = (IAIOJumpAction) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOJumpAction.class);
                Context context = this.f190130a;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                iAIOJumpAction.jumpAccountOnlineStateActivity(context);
            }
        }

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ae.this);
            }
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View view) {
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            Map mapOf;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                return;
            }
            Intrinsics.checkNotNullParameter(view, "view");
            Context context = view.getContext();
            if (ae.this.isSelf()) {
                IAIOJumpAction iAIOJumpAction = (IAIOJumpAction) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOJumpAction.class);
                Intrinsics.checkNotNullExpressionValue(context, "context");
                iAIOJumpAction.jumpAccountOnlineStateActivity(context);
            } else {
                IDialogApi iDialogApi = (IDialogApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IDialogApi.class);
                Intrinsics.checkNotNullExpressionValue(context, "context");
                String qqStr = HardCodeUtil.qqStr(R.string.z_h);
                if (qqStr == null) {
                    str = "";
                } else {
                    str = qqStr;
                }
                String qqStr2 = HardCodeUtil.qqStr(R.string.z_g);
                if (qqStr2 == null) {
                    str2 = "";
                } else {
                    str2 = qqStr2;
                }
                String qqStr3 = HardCodeUtil.qqStr(R.string.yut);
                if (qqStr3 == null) {
                    str3 = "";
                } else {
                    str3 = qqStr3;
                }
                String qqStr4 = HardCodeUtil.qqStr(R.string.irl);
                if (qqStr4 == null) {
                    str4 = "";
                } else {
                    str4 = qqStr4;
                }
                iDialogApi.showAlert(context, str, str2, str3, str4, new C7291a(context));
            }
            if (com.tencent.mobileqq.aio.msglist.holder.component.text.util.a.f192006a.e()) {
                str5 = "1";
            } else {
                str5 = "2";
            }
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("op_result", str5));
            com.tencent.mobileqq.aio.utils.b.l("em_bas_link_class_content", mapOf);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NotNull TextPaint ds5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) ds5);
                return;
            }
            Intrinsics.checkNotNullParameter(ds5, "ds");
            ds5.setUnderlineText(ae.this.isSelf());
            ds5.setColor(ds5.linkColor);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/ae$b;", "", "Lcom/tencent/mobileqq/aio/msg/ae;", "EmptyMsgItem", "Lcom/tencent/mobileqq/aio/msg/ae;", "b", "()Lcom/tencent/mobileqq/aio/msg/ae;", "", "DEFAULT_TEXT_SIZE", UserInfo.SEX_FEMALE, "a", "()F", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msg.ae$b, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        public final float a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return ae.f190115p1;
            }
            return ((Float) iPatchRedirector.redirect((short) 3, (Object) this)).floatValue();
        }

        @NotNull
        public final ae b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return ae.f190114o1;
            }
            return (ae) iPatchRedirector.redirect((short) 2, (Object) this);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57517);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 44)) {
            redirector.redirect((short) 44);
            return;
        }
        INSTANCE = new Companion(null);
        f190114o1 = new ae(AIOMsgItem.INSTANCE.a());
        f190115p1 = BaseApplication.context.getResources().getDimension(R.dimen.ayp);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ae(@NotNull MsgRecord msgRecord) {
        super(msgRecord);
        Integer num;
        int i3;
        List filterNotNull;
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) msgRecord);
            return;
        }
        ArrayList<MsgElement> arrayList = msgRecord.elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msgRecord.elements");
        Iterator<T> it = arrayList.iterator();
        if (!it.hasNext()) {
            num = null;
        } else {
            Integer valueOf = Integer.valueOf(((MsgElement) it.next()).elementGroupId);
            while (it.hasNext()) {
                Integer valueOf2 = Integer.valueOf(((MsgElement) it.next()).elementGroupId);
                if (valueOf.compareTo(valueOf2) < 0) {
                    valueOf = valueOf2;
                }
            }
            num = valueOf;
        }
        Integer num2 = num;
        if (num2 != null) {
            i3 = num2.intValue();
        } else {
            i3 = 0;
        }
        this.maxGroupId = i3;
        float f16 = f190115p1;
        this.qqTextSize = f16;
        this.originTextSize = f16;
        this.linkInfo = com.tencent.mobileqq.aio.utils.d.d(msgRecord);
        ArrayList<MsgElement> arrayList2 = new ArrayList<>();
        ArrayList<MsgElement> elements = msgRecord.elements;
        if (elements != null) {
            Intrinsics.checkNotNullExpressionValue(elements, "elements");
            filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(elements);
            if (filterNotNull != null) {
                Iterator it5 = filterNotNull.iterator();
                while (it5.hasNext()) {
                    arrayList2.add((MsgElement) it5.next());
                }
            }
        }
        this.filteredElements = arrayList2;
    }

    private final void F2(Context context) {
        this.qqText = k2();
        G2();
        Y1(com.tencent.mobileqq.aio.utils.n.f194168a.f(context, this));
        float dimensionPixelSize = BaseApplication.context.getResources().getDimensionPixelSize(R.dimen.ayp);
        this.originTextSize = dimensionPixelSize;
        this.qqTextSize = dimensionPixelSize;
        this.qqTextWithoutMagic = this.qqText;
    }

    private final void G2() {
        boolean startsWith$default;
        if (!A2()) {
            return;
        }
        String str = "[" + BaseApplication.getContext().getString(R.string.t_) + "]";
        CharSequence charSequence = this.qqText;
        Intrinsics.checkNotNull(charSequence);
        startsWith$default = StringsKt__StringsKt.startsWith$default(charSequence, (CharSequence) str, false, 2, (Object) null);
        if (!startsWith$default) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.qqText);
        spannableStringBuilder.setSpan(n2(), 0, str.length(), 33);
        this.qqText = spannableStringBuilder;
    }

    private final CharSequence k2() {
        int b16;
        if (this.filteredElements.isEmpty()) {
            return "";
        }
        boolean l26 = l2();
        this.isAllEmo = l26;
        if (l26) {
            b16 = 24;
        } else {
            b16 = com.tencent.qqnt.emotion.constant.b.b();
        }
        int i3 = b16;
        a.Companion companion = com.tencent.qqnt.aio.adapter.a.INSTANCE;
        CharSequence qQText = ((IQQTextApi) companion.a(IQQTextApi.class)).getQQText(com.tencent.mobileqq.aio.msglist.holder.component.text.c.f191997a.a(this.filteredElements).toString(), com.tencent.mobileqq.aio.msglist.holder.component.text.util.a.f192006a.d(), i3, null, this);
        ((IQQTextApi) companion.a(IQQTextApi.class)).setBizSrc(qQText, "biz_src_jc_aio");
        return qQText;
    }

    private final boolean l2() {
        int size = this.filteredElements.size();
        if (size == 0) {
            return false;
        }
        Iterator<MsgElement> it = this.filteredElements.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            MsgElement next = it.next();
            int i16 = next.elementType;
            if (i16 == 6 || (i16 == 1 && com.tencent.mobileqq.aio.utils.y.f194180a.i(next.textElement.content))) {
                i3++;
            }
        }
        if (size != i3) {
            return false;
        }
        return true;
    }

    private final ClickableSpan n2() {
        a aVar = new a();
        this.autoReplySpan = aVar;
        return aVar;
    }

    private final void s2() {
        int c16 = com.tencent.qqnt.aio.utils.n.f352308a.c(this);
        boolean z16 = true;
        if (c16 != 1) {
            if (c16 == 2000) {
                IFontManager.Companion companion = IFontManager.INSTANCE;
                float e16 = companion.e();
                if (FontSettingManager.getFontLevel() != 18.0f) {
                    z16 = false;
                }
                if (z16) {
                    e16 = companion.c();
                }
                this.qqTextSize = this.originTextSize * e16;
                return;
            }
            return;
        }
        if (this.qqTextWithoutMagic != null) {
            IFontManager iFontManager = (IFontManager) QRoute.api(IFontManager.class);
            CharSequence charSequence = this.qqTextWithoutMagic;
            Intrinsics.checkNotNull(charSequence);
            this.qqText = iFontManager.parseMagicFont(charSequence, getMsgRecord().peerUin, getMsgId());
        }
    }

    public final boolean A2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        if (!TextUtils.isEmpty(this.qqText) && getMsgRecord().msgType == 2 && (getMsgRecord().subMsgType & 1024) == 1024) {
            return true;
        }
        return false;
    }

    public boolean B2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Boolean) iPatchRedirector.redirect((short) 39, (Object) this)).booleanValue();
        }
        return this.hasMsgStatusUpdated;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean C2() {
        VASMsgIceBreak vASMsgIceBreak;
        int intValue;
        int intValue2;
        VASMsgElement vASMsgElement;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Boolean) iPatchRedirector.redirect((short) 31, (Object) this)).booleanValue();
        }
        MsgAttributeInfo msgAttributeInfo = getMsgRecord().msgAttrs.get(0);
        if (msgAttributeInfo != null && (vASMsgElement = msgAttributeInfo.vasMsgInfo) != null) {
            vASMsgIceBreak = vASMsgElement.iceBreakInfo;
        } else {
            vASMsgIceBreak = null;
        }
        if (vASMsgIceBreak == null) {
            return false;
        }
        Integer num = vASMsgIceBreak.isIceBreakMsg;
        if (num == null) {
            intValue = 0;
        } else {
            intValue = num.intValue();
        }
        Integer num2 = vASMsgIceBreak.templateID;
        if (num2 == null) {
            intValue2 = 0;
        } else {
            intValue2 = num2.intValue();
        }
        if (intValue == 0 || intValue2 == 0) {
            return false;
        }
        return true;
    }

    public boolean D2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Boolean) iPatchRedirector.redirect((short) 37, (Object) this)).booleanValue();
        }
        return this.needPlayStreamAnim;
    }

    public boolean E2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return ((Boolean) iPatchRedirector.redirect((short) 42, (Object) this)).booleanValue();
        }
        return this.isRegenerate;
    }

    public final void H2(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            this.disableAutoReplySpan = z16;
        }
    }

    public final void I2(@Nullable CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) charSequence);
        } else {
            this.streamText = charSequence;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void J2() {
        y03.c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        CharSequence charSequence = this.qqText;
        if (charSequence != null) {
            Intrinsics.checkNotNull(charSequence);
            Drawable b16 = com.tencent.mobileqq.aio.msg.a.b(this, charSequence, (int) this.qqTextSize);
            this.fontDrawable = b16;
            AIOMsgTextView.Companion companion = AIOMsgTextView.INSTANCE;
            String str = null;
            if (b16 instanceof y03.c) {
                cVar = (y03.c) b16;
            } else {
                cVar = null;
            }
            if (cVar != null) {
                str = cVar.n();
            }
            this.fontTypeface = companion.e(str);
        }
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public List<CharSequence> Q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (List) iPatchRedirector.redirect((short) 32, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        for (MsgElement msgElement : this.filteredElements) {
            FaceElement faceElement = msgElement.faceElement;
            if (faceElement != null) {
                arrayList.add(faceElement.faceText);
            }
            TextElement textElement = msgElement.textElement;
            if (textElement != null) {
                arrayList.add(textElement.content);
            }
        }
        return arrayList;
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
        if (h2().length() > 0) {
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        super.X0();
        s2();
        Y1(com.tencent.mobileqq.aio.msg.a.a(this));
        J2();
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public void Y0(@Nullable Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) context);
        } else {
            super.Y0(context);
            F2(context);
        }
    }

    @Override // com.tencent.mobileqq.aio.msg.l
    public void a(boolean isRunning) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, isRunning);
        } else {
            this.streamRunning = isRunning;
        }
    }

    @Override // com.tencent.mobileqq.aio.msg.l
    public void b(boolean isNeed) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, isNeed);
        } else {
            this.needPlayStreamAnim = isNeed;
        }
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public AIOMsgItem b0(@NotNull MsgRecord targetMsgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (AIOMsgItem) iPatchRedirector.redirect((short) 28, (Object) this, (Object) targetMsgRecord);
        }
        Intrinsics.checkNotNullParameter(targetMsgRecord, "targetMsgRecord");
        return new ae(targetMsgRecord);
    }

    @Override // com.tencent.mobileqq.aio.msg.l
    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Boolean) iPatchRedirector.redirect((short) 35, (Object) this)).booleanValue();
        }
        return this.streamRunning;
    }

    @Override // com.tencent.mobileqq.aio.msg.l
    public void e(boolean isRegenerate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this, isRegenerate);
        } else {
            this.isRegenerate = isRegenerate;
        }
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public String f1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return (String) iPatchRedirector.redirect((short) 33, (Object) this);
        }
        Iterator<MsgElement> it = getMsgRecord().elements.iterator();
        String str = "";
        while (it.hasNext()) {
            MsgElement element = it.next();
            int i3 = element.elementType;
            if (i3 != 1 && i3 != 9) {
                if (i3 == 6) {
                    String faceDescription = ((IEmojiSpanService) QRoute.api(IEmojiSpanService.class)).getFaceDescription(element.faceElement.faceIndex, 1);
                    str = str + HardCodeUtil.qqStr(R.string.f170197yp0) + faceDescription;
                }
            } else {
                com.tencent.qqnt.aio.utils.s sVar = com.tencent.qqnt.aio.utils.s.f352317a;
                Intrinsics.checkNotNullExpressionValue(element, "element");
                str = str + com.tencent.qqnt.emotion.utils.s.b(sVar.b(element));
            }
        }
        if (isSelf()) {
            return HardCodeUtil.qqStr(R.string.ypb) + HardCodeUtil.qqStr(R.string.ype) + str;
        }
        if (com.tencent.mobileqq.aio.utils.d.s(this)) {
            return getMsgRecord().anonymousExtInfo.anonymousNick + HardCodeUtil.qqStr(R.string.ype) + str;
        }
        CharSequence x16 = x();
        return ((Object) x16) + HardCodeUtil.qqStr(R.string.ype) + str;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public boolean g2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Boolean) iPatchRedirector.redirect((short) 34, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem, com.tencent.aio.data.msglist.a
    @Nullable
    public Object getChangePayload(@NotNull com.tencent.aio.data.msglist.a target) {
        HashMap hashMap;
        ae aeVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return iPatchRedirector.redirect((short) 17, (Object) this, (Object) target);
        }
        Intrinsics.checkNotNullParameter(target, "target");
        Object changePayload = super.getChangePayload(target);
        if (changePayload instanceof HashMap) {
            hashMap = (HashMap) changePayload;
        } else {
            hashMap = null;
        }
        if (hashMap == null) {
            hashMap = new HashMap();
        }
        if (target instanceof ae) {
            aeVar = (ae) target;
        } else {
            aeVar = null;
        }
        if (aeVar != null) {
            if (this.fontDrawable != aeVar.fontDrawable) {
                hashMap.put(AIOMsgItemPayloadType.VAS_FONT_PAYLOAD, a.bi.f192652a);
            }
            if (this.isAllEmo != aeVar.isAllEmo) {
                hashMap.put(AIOMsgItemPayloadType.AIO_TEXT_UPDATE_EMOTICON_PAYLOAD, a.c.f192656a);
            }
            if (!af.a(this, (ae) target)) {
                hashMap.put(AIOMsgItemPayloadType.AIO_TEXT_RICH_MSG_PAYLOAD, a.b.f192643a);
            }
            if (!com.tencent.qqnt.aio.msg.d.q(this, (AIOMsgItem) target)) {
                return null;
            }
            if (aeVar.streamRunning != this.streamRunning) {
                hashMap.put(AIOMsgItemPayloadType.MARKDOWN_STREAM_RUNNING_PAYLOAD, a.y.f192678a);
            }
        }
        if (hashMap.isEmpty()) {
            return null;
        }
        return hashMap;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem, com.tencent.aio.data.msglist.a
    public int getViewType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Integer) iPatchRedirector.redirect((short) 30, (Object) this)).intValue();
        }
        if (C2()) {
            if (isSelf()) {
                return 79;
            }
            return 80;
        }
        if (isSelf()) {
            return 7;
        }
        return 6;
    }

    @Override // com.tencent.mobileqq.aio.msg.l
    public void h(boolean msgStatusUpdated) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, msgStatusUpdated);
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
        return String.valueOf(this.qqText);
    }

    @Override // com.tencent.mobileqq.aio.msg.l
    public int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return ((Integer) iPatchRedirector.redirect((short) 43, (Object) this)).intValue();
        }
        return this.maxGroupId;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public void l(@NotNull AIOMsgItem newMsgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) newMsgItem);
            return;
        }
        Intrinsics.checkNotNullParameter(newMsgItem, "newMsgItem");
        super.l(newMsgItem);
        ae aeVar = (ae) newMsgItem;
        aeVar.qqText = this.qqText;
        aeVar.qqTextWithoutMagic = this.qqTextWithoutMagic;
        aeVar.streamText = this.streamText;
        aeVar.hasMsgStatusUpdated = this.hasMsgStatusUpdated;
        aeVar.needPlayStreamAnim = this.needPlayStreamAnim;
        aeVar.streamRunning = this.streamRunning;
        aeVar.isRegenerate = this.isRegenerate;
        aeVar.Y1(x0());
        aeVar.fontDrawable = this.fontDrawable;
        aeVar.fontTypeface = this.fontTypeface;
        aeVar.originTextSize = this.originTextSize;
        aeVar.qqTextSize = this.qqTextSize;
        aeVar.isAllEmo = this.isAllEmo;
        aeVar.linkInfo = this.linkInfo;
    }

    public final void m2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
            return;
        }
        this.fontDrawable = null;
        this.fontTypeface = null;
        this.qqTextSize = this.originTextSize;
        CharSequence charSequence = this.qqTextWithoutMagic;
        if (charSequence != null) {
            this.qqText = charSequence;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public Pair<Boolean, String> o(@NotNull com.tencent.aio.data.msglist.a target) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (Pair) iPatchRedirector.redirect((short) 16, (Object) this, (Object) target);
        }
        Intrinsics.checkNotNullParameter(target, "target");
        ae aeVar = (ae) target;
        if (this.fontDrawable != aeVar.fontDrawable) {
            return new Pair<>(Boolean.FALSE, "fontDrawable");
        }
        if (this.isAllEmo != aeVar.isAllEmo) {
            return new Pair<>(Boolean.FALSE, "isAllEmoChange");
        }
        if (!af.a(this, aeVar)) {
            return new Pair<>(Boolean.FALSE, "linkInfo");
        }
        if (this.streamRunning != aeVar.streamRunning) {
            return new Pair<>(Boolean.FALSE, "streamRunning");
        }
        return super.o(target);
    }

    public final boolean o2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.disableAutoReplySpan;
    }

    @NotNull
    public final ArrayList<MsgElement> p2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (ArrayList) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this.filteredElements;
    }

    @Nullable
    public final Drawable q2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Drawable) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.fontDrawable;
    }

    @Nullable
    public final LinkInfo r2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (LinkInfo) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.linkInfo;
    }

    public final int t2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.maxGroupId;
    }

    @Nullable
    public final CharSequence u2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (CharSequence) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.qqText;
    }

    public final float v2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Float) iPatchRedirector.redirect((short) 12, (Object) this)).floatValue();
        }
        return this.qqTextSize;
    }

    @Nullable
    public final CharSequence w2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (CharSequence) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (com.tencent.qqnt.aio.msg.d.M(this)) {
            return this.streamText;
        }
        return this.qqText;
    }

    @Nullable
    public final CharSequence x2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (CharSequence) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(w2());
        if (spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), a.class) != null) {
            spannableStringBuilder.removeSpan(this.autoReplySpan);
            return spannableStringBuilder;
        }
        return w2();
    }

    @Nullable
    public final CharSequence y2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (CharSequence) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.streamText;
    }

    public final boolean z2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return this.isAllEmo;
    }
}
