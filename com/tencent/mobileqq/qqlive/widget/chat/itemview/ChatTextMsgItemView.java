package com.tencent.mobileqq.qqlive.widget.chat.itemview;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.data.heart.QLBroadCastFreeLove;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qqlive.widget.chat.message.LiveLocalMsg;
import com.tencent.mobileqq.qqlive.widget.chat.message.f;
import com.tencent.mobileqq.qqlive.widget.chat.message.g;
import com.tencent.mobileqq.qqlive.widget.chat.message.i;
import com.tencent.mobileqq.qqlive.widget.chat.message.j;
import com.tencent.mobileqq.qqlive.widget.chat.message.n;
import com.tencent.mobileqq.qqlive.widget.util.e;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.common.api.AegisLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.MessageOuterClass$AnchorRoomBulletScreenMsg;
import trpc.yes.common.MessageOuterClass$AtUser;
import trpc.yes.common.MessageOuterClass$AtUserMsg;
import trpc.yes.common.MessageOuterClass$MsgContent;
import trpc.yes.common.MessageOuterClass$TimMsgBody;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 52\u00020\u0001:\u0001VB'\b\u0007\u0012\u0006\u0010P\u001a\u00020O\u0012\n\b\u0002\u0010R\u001a\u0004\u0018\u00010Q\u0012\b\b\u0002\u0010S\u001a\u00020\b\u00a2\u0006\u0004\bT\u0010UJ\"\u0010\u0007\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J*\u0010\n\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u001a\u0010\f\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\bH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u001e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\rH\u0002J,\u0010\u001c\u001a\u0004\u0018\u00010\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00192\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0018\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0018\u0010!\u001a\u00020 2\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\bH\u0002J\u0016\u0010\"\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u0004J$\u0010&\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020#2\u0006\u0010\u0006\u001a\u00020\u00042\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000f0$J\u0016\u0010(\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020'2\u0006\u0010\u0006\u001a\u00020\u0004J\u0016\u0010*\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020)2\u0006\u0010\u0006\u001a\u00020\u0004J\u0016\u0010,\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020+2\u0006\u0010\u0006\u001a\u00020\u0004J\u0016\u0010.\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020-2\u0006\u0010\u0006\u001a\u00020\u0004J\u0016\u00100\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020/2\u0006\u0010\u0006\u001a\u00020\u0004J\u0016\u00102\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u0002012\u0006\u0010\u0006\u001a\u00020\u0004J\u0016\u00104\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u0002032\u0006\u0010\u0006\u001a\u00020\u0004J\u001e\u00105\u001a\u00020\u000f2\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00192\u0006\u0010\u0006\u001a\u00020\u0004J\b\u00106\u001a\u00020\u000fH\u0016J\b\u00107\u001a\u00020\u000fH\u0016J\b\u00108\u001a\u00020\u000fH\u0016J\u0010\u00109\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010:\u001a\u00020\bH\u0016J\b\u0010;\u001a\u00020\bH\u0016J\u0010\u0010>\u001a\u00020 2\u0006\u0010=\u001a\u00020<H\u0016J\u0010\u0010?\u001a\u00020\u00152\u0006\u0010=\u001a\u00020<H\u0016J\b\u0010@\u001a\u00020 H\u0016R\"\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020B0A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010CR\"\u0010E\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001a0A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010CR\u0018\u0010H\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010GR\u0014\u0010I\u001a\u00020F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u0010GR\u001b\u0010N\u001a\u00020J8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b.\u0010K\u001a\u0004\bL\u0010M\u00a8\u0006W"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/chat/itemview/ChatTextMsgItemView;", "Lcom/tencent/mobileqq/qqlive/widget/chat/itemview/ChatBaseText;", "", "nick", "", "speakId", "anchorId", DomainData.DOMAIN_NAME, "", "maxLen", "o", "maxLength", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/qqlive/widget/chat/message/f;", "msg", "", "I", "M", "Lcom/tencent/mobileqq/qqlive/data/heart/QLBroadCastFreeLove;", "likeInfo", "", "", "r", "v", "content", "", "Ltrpc/yes/common/MessageOuterClass$AtUser;", "data", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/mobileqq/qqlive/widget/chat/message/e;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "color", "Landroid/text/SpannableString;", ReportConstant.COSTREPORT_PREFIX, "G", "Lcom/tencent/mobileqq/qqlive/widget/chat/message/c;", "Lkotlin/Function0;", "followChangedSuccess", "E", "Lcom/tencent/mobileqq/qqlive/widget/chat/message/g;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/qqlive/widget/chat/message/a;", "B", "Lcom/tencent/mobileqq/qqlive/widget/chat/message/b;", "D", "Lcom/tencent/mobileqq/qqlive/widget/chat/message/n;", "K", "Lcom/tencent/mobileqq/qqlive/widget/chat/message/j;", "J", "Lcom/tencent/mobileqq/qqlive/widget/chat/message/LiveLocalMsg;", "H", "Ltrpc/yes/common/MessageOuterClass$AnchorRoomBulletScreenMsg;", BdhLogUtil.LogTag.Tag_Conn, "L", "setNormalBackground", "setAtMsgBackground", "setSysMsgBackground", "y", "w", "u", "", "isSelfMsg", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "t", "p", "", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "Ljava/util/Map;", "atUserInfoMap", "uidAtInfoMap", "Landroid/text/SpannableStringBuilder;", "Landroid/text/SpannableStringBuilder;", "followStateSpan", "spannable", "Lcom/tencent/mobileqq/qqlive/widget/chat/span/e;", "Lkotlin/Lazy;", HippyTKDListViewAdapter.X, "()Lcom/tencent/mobileqq/qqlive/widget/chat/span/e;", "nickClickSpan", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public class ChatTextMsgItemView extends ChatBaseText {
    static IPatchRedirector $redirector_;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private Map<String, CommonOuterClass$QQUserId> atUserInfoMap;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private Map<Long, MessageOuterClass$AtUser> uidAtInfoMap;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private SpannableStringBuilder followStateSpan;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final SpannableStringBuilder spannable;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy nickClickSpan;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/chat/itemview/ChatTextMsgItemView$a;", "", "", "MAX_NICK_LENGTH", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatTextMsgItemView$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
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
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/qqlive/widget/chat/itemview/ChatTextMsgItemView$b", "Landroid/text/style/ClickableSpan;", "Landroid/text/TextPaint;", "ds", "", "updateDrawState", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, NodeProps.ON_CLICK, "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b extends ClickableSpan {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatTextMsgItemView.this);
            }
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) widget);
                return;
            }
            Intrinsics.checkNotNullParameter(widget, "widget");
            vi2.c h16 = ChatTextMsgItemView.this.h();
            if (h16 != null) {
                h16.l();
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NotNull TextPaint ds5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) ds5);
                return;
            }
            Intrinsics.checkNotNullParameter(ds5, "ds");
            super.updateDrawState(ds5);
            ds5.setUnderlineText(false);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30222);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 24)) {
            redirector.redirect((short) 24);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ChatTextMsgItemView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 23)) {
            return;
        }
        iPatchRedirector.redirect((short) 23, (Object) this, (Object) context);
    }

    private final String A(String content, List<MessageOuterClass$AtUser> data, long anchorId) {
        if (data != null) {
            Iterator<T> it = data.iterator();
            while (true) {
                String str = content;
                if (it.hasNext()) {
                    MessageOuterClass$AtUser messageOuterClass$AtUser = (MessageOuterClass$AtUser) it.next();
                    String str2 = '@' + messageOuterClass$AtUser.nick_name.get();
                    String str3 = '@' + n(messageOuterClass$AtUser.nick_name.get(), messageOuterClass$AtUser.user_id.uid.get(), anchorId);
                    if (str != null) {
                        content = StringsKt__StringsJVMKt.replace$default(str, str2, str3, false, 4, (Object) null);
                    } else {
                        content = null;
                    }
                } else {
                    return str;
                }
            }
        } else {
            return content;
        }
    }

    private final void I(f msg2) {
        x().c(y(msg2));
    }

    private final void M(long anchorId) {
        boolean z16;
        boolean j3;
        SpannableStringBuilder spannableStringBuilder;
        vi2.a f16 = f();
        boolean z17 = true;
        if (f16 != null && f16.c() == anchorId) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        vi2.a f17 = f();
        if (f17 == null || f17.R(i()) != 2) {
            z17 = false;
        }
        if (z17) {
            vi2.c h16 = h();
            if (h16 != null) {
                j3 = h16.B(i());
            }
            j3 = false;
        } else {
            vi2.c h17 = h();
            if (h17 != null) {
                j3 = h17.j(anchorId);
            }
            j3 = false;
        }
        if (j3 && this.followStateSpan == null) {
            return;
        }
        if (j3) {
            spannableStringBuilder = new SpannableStringBuilder("\u5df2\u5173\u6ce8");
            spannableStringBuilder.setSpan(new com.tencent.mobileqq.qqlive.widget.chat.span.f(e.a(R.color.cjm), e.a(R.color.cli), wi2.c.b(12), false, wi2.c.d(10), wi2.c.b(4), 8, null), 0, 3, 33);
        } else {
            spannableStringBuilder = new SpannableStringBuilder("\u6211\u4e5f\u5173\u6ce8");
            spannableStringBuilder.setSpan(new com.tencent.mobileqq.qqlive.widget.chat.span.f(e.a(R.color.cjm), e.a(R.color.cla), wi2.c.b(12), false, wi2.c.d(10), wi2.c.b(4), 8, null), 0, 4, 33);
        }
        this.followStateSpan = spannableStringBuilder;
        invalidate();
    }

    private final String m(String nick, int maxLength) {
        int i3;
        if (nick != null) {
            i3 = nick.length();
        } else {
            i3 = 0;
        }
        if (nick != null && i3 != 0) {
            if (i3 > maxLength) {
                return ((Object) nick.subSequence(0, maxLength - 1)) + "..";
            }
            return nick;
        }
        return "";
    }

    private final String n(String nick, long speakId, long anchorId) {
        String f16;
        vi2.c h16 = h();
        if (h16 == null || (f16 = h16.f(i(), nick, speakId, anchorId)) == null) {
            return "";
        }
        return f16;
    }

    private final String o(String nick, long speakId, long anchorId, int maxLen) {
        String str;
        vi2.c h16 = h();
        if (h16 == null || (str = h16.f(i(), nick, speakId, anchorId)) == null) {
            str = "";
        }
        return m(str, maxLen);
    }

    private final List<CharSequence> r(QLBroadCastFreeLove likeInfo, long anchorId) {
        List split$default;
        boolean z16;
        ArrayList arrayList = new ArrayList();
        String str = likeInfo.roomMsg;
        Intrinsics.checkNotNullExpressionValue(str, "likeInfo.roomMsg");
        String str2 = likeInfo.userNick;
        Intrinsics.checkNotNullExpressionValue(str2, "likeInfo.userNick");
        int i3 = 0;
        split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{str2}, false, 0, 6, (Object) null);
        List list = split$default;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            for (Object obj : split$default) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                arrayList.add(s((String) obj, w()));
                if (i3 < split$default.size() - 1) {
                    String str3 = o(likeInfo.userNick, likeInfo.uid, anchorId, u()) + TokenParser.SP;
                    com.tencent.mobileqq.qqlive.widget.chat.span.e x16 = x();
                    LiveUserInfo liveUserInfo = new LiveUserInfo();
                    liveUserInfo.nick = likeInfo.userNick;
                    liveUserInfo.uid = likeInfo.uid;
                    liveUserInfo.headUrl = likeInfo.headImg;
                    x16.e(liveUserInfo, i(), anchorId);
                    Unit unit = Unit.INSTANCE;
                    arrayList.add(d(str3, x16));
                }
                i3 = i16;
            }
        }
        return arrayList;
    }

    private final SpannableString s(String content, int color) {
        SpannableString spannableString = new SpannableString(content);
        spannableString.setSpan(new ForegroundColorSpan(color), 0, content.length(), 17);
        return spannableString;
    }

    private final CharSequence v(f msg2) {
        CharSequence charSequence;
        com.tencent.mobileqq.qqlive.widget.chat.data.a a16;
        i header = msg2.getHeader();
        if (header != null && (a16 = header.a()) != null) {
            charSequence = a16.f273755b;
        } else {
            charSequence = null;
        }
        if (charSequence == null) {
            return "";
        }
        return charSequence;
    }

    private final com.tencent.mobileqq.qqlive.widget.chat.span.e x() {
        return (com.tencent.mobileqq.qqlive.widget.chat.span.e) this.nickClickSpan.getValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0046, code lost:
    
        if (r1 != null) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void z(com.tencent.mobileqq.qqlive.widget.chat.message.e msg2, long anchorId) {
        MessageOuterClass$AtUserMsg messageOuterClass$AtUserMsg;
        List<MessageOuterClass$AtUser> list;
        String str;
        List<MessageOuterClass$AtUser> list2;
        List<? extends CharSequence> listOf;
        PBRepeatMessageField<MessageOuterClass$AtUser> pBRepeatMessageField;
        PBStringField pBStringField;
        PBRepeatMessageField<MessageOuterClass$AtUser> pBRepeatMessageField2;
        MessageOuterClass$MsgContent messageOuterClass$MsgContent;
        MessageOuterClass$TimMsgBody a16 = msg2.a();
        String str2 = null;
        if (a16 != null && (messageOuterClass$MsgContent = a16.content) != null) {
            messageOuterClass$AtUserMsg = messageOuterClass$MsgContent.at_user_msg;
        } else {
            messageOuterClass$AtUserMsg = null;
        }
        if (messageOuterClass$AtUserMsg != null && (pBRepeatMessageField2 = messageOuterClass$AtUserMsg.user_list) != null) {
            list = pBRepeatMessageField2.get();
        } else {
            list = null;
        }
        L(list, anchorId);
        if (messageOuterClass$AtUserMsg != null && (pBStringField = messageOuterClass$AtUserMsg.text) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        if (messageOuterClass$AtUserMsg != null && (pBRepeatMessageField = messageOuterClass$AtUserMsg.user_list) != null) {
            list2 = pBRepeatMessageField.get();
        } else {
            list2 = null;
        }
        String A = A(str, list2, anchorId);
        if (A != null) {
            vi2.a f16 = f();
            if (f16 != null) {
                str2 = f16.decodeQQEmotion(A);
            }
        }
        str2 = "";
        String str3 = str2;
        this.spannable.clear();
        this.spannable.clearSpans();
        this.spannable.append((CharSequence) str3);
        vi2.a f17 = f();
        if (f17 != null) {
            f17.C(this, 0, str3, this.atUserInfoMap, this.spannable, this.uidAtInfoMap);
        }
        String str4 = n(msg2.c().mSpeakerName, msg2.c().mSpeakId, anchorId) + '\uff1a';
        com.tencent.mobileqq.qqlive.widget.chat.span.e x16 = x();
        LiveUserInfo liveUserInfo = new LiveUserInfo();
        liveUserInfo.nick = msg2.c().mSpeakerName;
        liveUserInfo.uid = msg2.c().mSpeakId;
        liveUserInfo.headUrl = msg2.c().mLogo;
        x16.b(msg2.message());
        x16.e(liveUserInfo, i(), anchorId);
        Unit unit = Unit.INSTANCE;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new CharSequence[]{d(str4, x16), new QQText(this.spannable, 3, 16)});
        setSpanText(listOf);
    }

    public final void B(@NotNull com.tencent.mobileqq.qqlive.widget.chat.message.a msg2, long anchorId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, msg2, Long.valueOf(anchorId));
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        setNormalBackground();
        ArrayList arrayList = new ArrayList();
        String str = n(msg2.f273849d.nickname.get(), msg2.f273849d.uid.get(), anchorId) + '\uff1a';
        com.tencent.mobileqq.qqlive.widget.chat.span.e x16 = x();
        LiveUserInfo liveUserInfo = new LiveUserInfo();
        liveUserInfo.nick = msg2.f273849d.nickname.get();
        liveUserInfo.uid = msg2.f273849d.uid.get();
        liveUserInfo.headUrl = msg2.f273849d.avatar.get();
        x16.e(liveUserInfo, i(), anchorId);
        Unit unit = Unit.INSTANCE;
        arrayList.add(d(str, x16));
        arrayList.add("\u4e3a\u4e3b\u64ad\u5145\u7535" + msg2.f273849d.charge_times.get() + "\u6b21,\u4e3b\u64ad\u8fd8\u5dee" + msg2.f273849d.upgrade_power.get() + "\u7535\u91cf\u5347\u7ea7 ");
        vi2.c h16 = h();
        if (h16 == null || !h16.r()) {
            z16 = false;
        }
        if (z16) {
            SpannableString spannableString = new SpannableString("\u6211\u4e5f\u5145\u7535");
            spannableString.setSpan(new b(), 0, spannableString.length(), 17);
            spannableString.setSpan(new com.tencent.mobileqq.qqlive.widget.chat.span.f(-1, -16777216, wi2.c.b(10), false, 0.0f, 0, 56, null), 0, spannableString.length(), 17);
            arrayList.add(spannableString);
        }
        setSpanText(arrayList);
        l(msg2);
    }

    public final void C(@NotNull MessageOuterClass$AnchorRoomBulletScreenMsg msg2, long anchorId) {
        List<? extends CharSequence> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, msg2, Long.valueOf(anchorId));
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        String str = n(msg2.nickname.get(), msg2.uid.get(), anchorId) + '\uff1a';
        com.tencent.mobileqq.qqlive.widget.chat.span.e x16 = x();
        LiveUserInfo liveUserInfo = new LiveUserInfo();
        liveUserInfo.nick = msg2.nickname.get();
        liveUserInfo.uid = msg2.uid.get();
        liveUserInfo.headUrl = msg2.avator.get();
        x16.e(liveUserInfo, i(), anchorId);
        Unit unit = Unit.INSTANCE;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new CharSequence[]{d(str, x16), new QQText(msg2.text.get(), 3, 16)});
        setSpanText(listOf);
    }

    public final void D(@NotNull com.tencent.mobileqq.qqlive.widget.chat.message.b msg2, long anchorId) {
        List<? extends CharSequence> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, msg2, Long.valueOf(anchorId));
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        setNormalBackground();
        StringBuilder sb5 = new StringBuilder();
        LiveMessageData.SpeakerInfo speakerInfo = msg2.f273851d;
        sb5.append(o(speakerInfo.mSpeakerName, speakerInfo.mSpeakId, anchorId, u()));
        sb5.append(TokenParser.SP);
        String sb6 = sb5.toString();
        com.tencent.mobileqq.qqlive.widget.chat.span.e x16 = x();
        LiveUserInfo liveUserInfo = new LiveUserInfo();
        LiveMessageData.SpeakerInfo speakerInfo2 = msg2.f273851d;
        liveUserInfo.nick = speakerInfo2.mSpeakerName;
        liveUserInfo.uid = speakerInfo2.mSpeakId;
        liveUserInfo.headUrl = speakerInfo2.mLogo;
        x16.e(liveUserInfo, i(), anchorId);
        Unit unit = Unit.INSTANCE;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new CharSequence[]{v(msg2), d(sb6, x16), p()});
        setSpanText(listOf);
        I(msg2);
        l(msg2);
    }

    public final void E(@NotNull com.tencent.mobileqq.qqlive.widget.chat.message.c msg2, long anchorId, @NotNull final Function0<Unit> followChangedSuccess) {
        boolean z16;
        String str;
        List<? extends CharSequence> listOf;
        SpannableStringBuilder spannableStringBuilder;
        ClickableSpan clickableSpan;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, msg2, Long.valueOf(anchorId), followChangedSuccess);
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(followChangedSuccess, "followChangedSuccess");
        if (msg2.b().toUid != anchorId) {
            return;
        }
        M(anchorId);
        SpannableStringBuilder spannableStringBuilder2 = this.followStateSpan;
        if (spannableStringBuilder2 != null) {
            vi2.c h16 = h();
            if (h16 != null) {
                spannableStringBuilder = spannableStringBuilder2;
                clickableSpan = h16.y(msg2, anchorId, i(), new Function1<com.tencent.mobileqq.qqlive.widget.chat.message.c, Unit>(followChangedSuccess) { // from class: com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatTextMsgItemView$renderFollow$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ Function0<Unit> $followChangedSuccess;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        this.$followChangedSuccess = followChangedSuccess;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) followChangedSuccess);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.qqlive.widget.chat.message.c cVar) {
                        invoke2(cVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull com.tencent.mobileqq.qqlive.widget.chat.message.c it) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                        } else {
                            Intrinsics.checkNotNullParameter(it, "it");
                            this.$followChangedSuccess.invoke();
                        }
                    }
                });
            } else {
                spannableStringBuilder = spannableStringBuilder2;
                clickableSpan = null;
            }
            spannableStringBuilder.setSpan(clickableSpan, 0, 1, 33);
        }
        setNormalBackground();
        vi2.a f16 = f();
        if (f16 != null && msg2.b().uid == f16.c()) {
            z16 = true;
        } else {
            z16 = false;
        }
        CharSequence[] charSequenceArr = new CharSequence[4];
        String str2 = o(msg2.b().nick, msg2.b().uid, anchorId, u()) + TokenParser.SP;
        com.tencent.mobileqq.qqlive.widget.chat.span.e x16 = x();
        LiveUserInfo liveUserInfo = new LiveUserInfo();
        liveUserInfo.nick = msg2.b().nick;
        liveUserInfo.uid = msg2.b().uid;
        liveUserInfo.headUrl = msg2.b().icon;
        x16.e(liveUserInfo, i(), anchorId);
        Unit unit = Unit.INSTANCE;
        charSequenceArr[0] = d(str2, x16);
        charSequenceArr[1] = q(z16);
        if (!z16 && this.followStateSpan != null) {
            str = " ";
        } else {
            str = "";
        }
        charSequenceArr[2] = str;
        charSequenceArr[3] = t(z16);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) charSequenceArr);
        setSpanText(listOf);
        l(msg2);
    }

    public final void F(@NotNull g msg2, long anchorId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, msg2, Long.valueOf(anchorId));
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        setNormalBackground();
        QLBroadCastFreeLove qLBroadCastFreeLove = msg2.f273857d;
        Intrinsics.checkNotNullExpressionValue(qLBroadCastFreeLove, "msg.broadCastFreeLove");
        setSpanText(r(qLBroadCastFreeLove, anchorId));
        l(msg2);
    }

    public final void G(@NotNull com.tencent.mobileqq.qqlive.widget.chat.message.e msg2, long anchorId) {
        boolean z16;
        String str;
        List<? extends CharSequence> listOf;
        PBInt32Field pBInt32Field;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, msg2, Long.valueOf(anchorId));
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        I(msg2);
        MessageOuterClass$TimMsgBody a16 = msg2.a();
        if (a16 != null && (pBInt32Field = a16.msg_type) != null && pBInt32Field.get() == 70) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            setAtMsgBackground();
            z(msg2, anchorId);
        } else {
            setNormalBackground();
            vi2.a f16 = f();
            if (f16 != null) {
                str = f16.decodeQQEmotion(msg2.message());
            } else {
                str = null;
            }
            String str2 = str;
            String str3 = n(msg2.c().mSpeakerName, msg2.c().mSpeakId, anchorId) + '\uff1a';
            com.tencent.mobileqq.qqlive.widget.chat.span.e x16 = x();
            LiveUserInfo liveUserInfo = new LiveUserInfo();
            liveUserInfo.nick = msg2.c().mSpeakerName;
            liveUserInfo.uid = msg2.c().mSpeakId;
            liveUserInfo.headUrl = msg2.c().mLogo;
            x16.e(liveUserInfo, i(), anchorId);
            x16.b(str2);
            Unit unit = Unit.INSTANCE;
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new CharSequence[]{d(str3, x16), new QQText(str2, 3, 16)});
            setSpanText(listOf);
        }
        l(msg2);
    }

    public final void H(@NotNull LiveLocalMsg msg2, long anchorId) {
        List<? extends CharSequence> listOf;
        List<? extends CharSequence> listOf2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, msg2, Long.valueOf(anchorId));
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (msg2.isSendMsgAlienation()) {
            listOf2 = CollectionsKt__CollectionsJVMKt.listOf(new QQText(msg2.getText(), 3, 16));
            setSpanText(listOf2);
            return;
        }
        String str = n(msg2.getSender().m(), msg2.getSender().q(), anchorId) + '\uff1a';
        com.tencent.mobileqq.qqlive.widget.chat.span.e x16 = x();
        LiveUserInfo liveUserInfo = new LiveUserInfo();
        liveUserInfo.nick = msg2.getSender().m();
        liveUserInfo.uid = msg2.getSender().q();
        liveUserInfo.headUrl = msg2.getSender().j();
        x16.b(msg2.getText());
        x16.e(liveUserInfo, i(), anchorId);
        Unit unit = Unit.INSTANCE;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new CharSequence[]{d(str, x16), new QQText(msg2.getText(), 3, 16)});
        setSpanText(listOf);
        l(msg2);
    }

    public final void J(@NotNull j msg2, long anchorId) {
        List<? extends CharSequence> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, msg2, Long.valueOf(anchorId));
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (msg2.e() != 0) {
            setTextColor(msg2.e());
        }
        setSysMsgBackground();
        listOf = CollectionsKt__CollectionsJVMKt.listOf(msg2.d());
        setSpanText(listOf);
    }

    public final void K(@NotNull n msg2, long anchorId) {
        List<? extends CharSequence> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, msg2, Long.valueOf(anchorId));
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        setNormalBackground();
        String str = n(msg2.b().mSpeakerName, msg2.b().mSpeakId, anchorId) + TokenParser.SP;
        com.tencent.mobileqq.qqlive.widget.chat.span.e x16 = x();
        LiveUserInfo liveUserInfo = new LiveUserInfo();
        liveUserInfo.nick = msg2.b().mSpeakerName;
        liveUserInfo.uid = msg2.b().mSpeakId;
        liveUserInfo.headUrl = msg2.b().mLogo;
        x16.e(liveUserInfo, i(), anchorId);
        Unit unit = Unit.INSTANCE;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new CharSequence[]{"\u606d\u559c", d(str, x16), "\u5347\u7ea7\u523011\u7ea7"});
        setSpanText(listOf);
        l(msg2);
    }

    public final void L(@Nullable List<MessageOuterClass$AtUser> data, long anchorId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, data, Long.valueOf(anchorId));
            return;
        }
        this.atUserInfoMap.clear();
        if (data != null) {
            for (MessageOuterClass$AtUser messageOuterClass$AtUser : data) {
                if (messageOuterClass$AtUser.user_id.uid.get() != 0) {
                    CommonOuterClass$QQUserId atUserId = messageOuterClass$AtUser.user_id.get();
                    String n3 = n(messageOuterClass$AtUser.nick_name.get(), messageOuterClass$AtUser.user_id.get().uid.get(), anchorId);
                    if (!TextUtils.isEmpty(n3)) {
                        Map<String, CommonOuterClass$QQUserId> map = this.atUserInfoMap;
                        Intrinsics.checkNotNullExpressionValue(atUserId, "atUserId");
                        map.put(n3, atUserId);
                    }
                    this.uidAtInfoMap.put(Long.valueOf(atUserId.uid.get()), messageOuterClass$AtUser);
                }
            }
        }
        AegisLogger.INSTANCE.i("Chat_Message|AnchorTextMsgItemView", "atUserInfoMap =" + this.atUserInfoMap);
    }

    @NotNull
    public SpannableString p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (SpannableString) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return s("\u6765\u4e86", w());
    }

    @NotNull
    public SpannableString q(boolean isSelfMsg) {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (SpannableString) iPatchRedirector.redirect((short) 19, (Object) this, isSelfMsg);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("\u5173\u6ce8\u4e86");
        vi2.a f16 = f();
        boolean z16 = false;
        if (f16 != null && f16.R(i()) == 2) {
            z16 = true;
        }
        if (z16) {
            str = "\u623f\u95f4";
        } else {
            str = "\u4e3b\u64ad";
        }
        sb5.append(str);
        if (!isSelfMsg && this.followStateSpan != null) {
            str2 = " ";
        } else {
            str2 = "";
        }
        sb5.append(str2);
        return s(sb5.toString(), w());
    }

    public void setAtMsgBackground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            setBackgroundDrawable(e());
        }
    }

    public void setNormalBackground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            setBackgroundDrawable(e());
        }
    }

    public void setSysMsgBackground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            setBackgroundDrawable(e());
        }
    }

    @NotNull
    public CharSequence t(boolean isSelfMsg) {
        SpannableStringBuilder spannableStringBuilder;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (CharSequence) iPatchRedirector.redirect((short) 20, (Object) this, isSelfMsg);
        }
        if (isSelfMsg || (spannableStringBuilder = this.followStateSpan) == null || spannableStringBuilder == null) {
            return "";
        }
        return spannableStringBuilder;
    }

    public int u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        return 20;
    }

    public int w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        return e.a(R.color.cli);
    }

    public int y(@NotNull f msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this, (Object) msg2)).intValue();
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        return super.g(msg2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ChatTextMsgItemView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 22)) {
            return;
        }
        iPatchRedirector.redirect((short) 22, (Object) this, (Object) context, (Object) attributeSet);
    }

    public /* synthetic */ ChatTextMsgItemView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ChatTextMsgItemView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.atUserInfoMap = new LinkedHashMap();
        this.uidAtInfoMap = new LinkedHashMap();
        this.spannable = new SpannableStringBuilder();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.qqlive.widget.chat.span.e>() { // from class: com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatTextMsgItemView$nickClickSpan$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatTextMsgItemView.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.qqlive.widget.chat.span.e invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (com.tencent.mobileqq.qqlive.widget.chat.span.e) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                com.tencent.mobileqq.qqlive.widget.chat.span.e eVar = new com.tencent.mobileqq.qqlive.widget.chat.span.e();
                ChatTextMsgItemView chatTextMsgItemView = ChatTextMsgItemView.this;
                eVar.d(chatTextMsgItemView.f(), chatTextMsgItemView.h());
                return eVar;
            }
        });
        this.nickClickSpan = lazy;
    }
}
