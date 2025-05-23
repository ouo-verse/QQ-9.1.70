package com.tencent.mobileqq.qqlive.widget.chat.itemview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqgift.updatasystem.QQGiftPanelResource;
import com.tencent.mobileqq.qqlive.data.gift.GiftMessage;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qqlive.widget.util.e;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.SSODebugUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qh2.f;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 32\u00020\u0001:\u000245B'\b\u0007\u0012\u0006\u0010-\u001a\u00020,\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010.\u0012\b\b\u0002\u00100\u001a\u00020\r\u00a2\u0006\u0004\b1\u00102J\u001a\u0010\u0006\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J*\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010\u0015\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\u0016\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0004J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\rH\u0016R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010!\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010\u0018\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010%R\u001b\u0010+\u001a\u00020&8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/chat/itemview/ChatGiftMsgItemView;", "Lcom/tencent/mobileqq/qqlive/widget/chat/itemview/ChatBaseText;", "", "nick", "", "speakId", "r", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", HippyTKDListViewAdapter.X, "Landroid/graphics/drawable/GradientDrawable;", ReportConstant.COSTREPORT_PREFIX, "", "id", "errorCode", "httpCode", "errorMessage", "onLoadFail", "Lcom/tencent/mobileqq/qqgift/updatasystem/QQGiftPanelResource;", "panelResource", "c", "Lcom/tencent/mobileqq/qqlive/widget/chat/message/d;", "msg", "anchorId", "y", "realGiftNum", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/mobileqq/qqlive/data/gift/GiftMessage;", "G", "Lcom/tencent/mobileqq/qqlive/data/gift/GiftMessage;", "H", "Lcom/tencent/mobileqq/qqlive/widget/chat/message/d;", "screenMsg", "I", "Landroid/graphics/Bitmap;", "defaultIcon", "J", "Lcom/tencent/mobileqq/qqlive/widget/chat/span/e;", "K", "Lkotlin/Lazy;", "t", "()Lcom/tencent/mobileqq/qqlive/widget/chat/span/e;", "senderSpan", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "L", "a", "b", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public class ChatGiftMsgItemView extends ChatBaseText {
    static IPatchRedirector $redirector_;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private GiftMessage msg;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qqlive.widget.chat.message.d screenMsg;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private Bitmap defaultIcon;

    /* renamed from: J, reason: from kotlin metadata */
    private long anchorId;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy senderSpan;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/chat/itemview/ChatGiftMsgItemView$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatGiftMsgItemView$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0013\u0010\u0014J*\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/chat/itemview/ChatGiftMsgItemView$b;", "Lqh2/f;", "", "id", "errorCode", "httpCode", "", "errorMessage", "", "onLoadFail", "Lcom/tencent/mobileqq/qqgift/updatasystem/QQGiftPanelResource;", "panelResource", "c", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/qqlive/widget/chat/itemview/ChatGiftMsgItemView;", "d", "Lmqq/util/WeakReference;", "mView", "view", "<init>", "(Lcom/tencent/mobileqq/qqlive/widget/chat/itemview/ChatGiftMsgItemView;)V", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements f {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<ChatGiftMsgItemView> mView;

        public b(@NotNull ChatGiftMsgItemView view) {
            Intrinsics.checkNotNullParameter(view, "view");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
            } else {
                this.mView = new WeakReference<>(view);
            }
        }

        @Override // qh2.f
        public void c(int id5, @Nullable QQGiftPanelResource panelResource) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, id5, (Object) panelResource);
                return;
            }
            ChatGiftMsgItemView chatGiftMsgItemView = this.mView.get();
            if (chatGiftMsgItemView != null) {
                chatGiftMsgItemView.c(id5, panelResource);
            }
        }

        @Override // qh2.g
        public void onLoadFail(int id5, int errorCode, int httpCode, @Nullable String errorMessage) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(id5), Integer.valueOf(errorCode), Integer.valueOf(httpCode), errorMessage);
                return;
            }
            ChatGiftMsgItemView chatGiftMsgItemView = this.mView.get();
            if (chatGiftMsgItemView != null) {
                chatGiftMsgItemView.onLoadFail(id5, errorCode, httpCode, errorMessage);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28918);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ChatGiftMsgItemView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            return;
        }
        iPatchRedirector.redirect((short) 6, (Object) this, (Object) context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(int id5, QQGiftPanelResource panelResource) {
        Integer num;
        final Bitmap decodeFile;
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("id:");
        sb5.append(id5);
        sb5.append(" msg.materialID:");
        GiftMessage giftMessage = this.msg;
        String str = null;
        if (giftMessage != null) {
            num = Integer.valueOf(giftMessage.materialID);
        } else {
            num = null;
        }
        sb5.append(num);
        sb5.append(", panelResource:");
        if (panelResource != null) {
            str = panelResource.f265002b;
        }
        sb5.append(str);
        companion.i("Chat_Message|ChatGiftMsgItemView", "onLoadSuccess", sb5.toString());
        GiftMessage giftMessage2 = this.msg;
        if (giftMessage2 != null && giftMessage2.materialID == id5 && panelResource != null) {
            try {
                String str2 = panelResource.f265002b;
                if (str2 != null && (decodeFile = BitmapFactory.decodeFile(str2)) != null) {
                    post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.widget.chat.itemview.d
                        @Override // java.lang.Runnable
                        public final void run() {
                            ChatGiftMsgItemView.w(ChatGiftMsgItemView.this, decodeFile);
                        }
                    });
                }
            } catch (Exception e16) {
                QLog.i("Chat_Message|ChatGiftMsgItemView", 1, "onLoadSuccess:throw Exception!", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onLoadFail(int id5, int errorCode, int httpCode, String errorMessage) {
        AegisLogger.INSTANCE.e("Chat_Message|ChatGiftMsgItemView", "onLoadFail", "id:" + id5 + ",errorCode:" + errorCode + ",httpCode:" + httpCode + ",errorMessage:" + errorMessage);
        final Bitmap bitmap = this.defaultIcon;
        if (bitmap != null) {
            post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.widget.chat.itemview.c
                @Override // java.lang.Runnable
                public final void run() {
                    ChatGiftMsgItemView.v(ChatGiftMsgItemView.this, bitmap);
                }
            });
        }
    }

    private final String r(String nick, long speakId) {
        String f16;
        vi2.c h16 = h();
        if (h16 == null || (f16 = h16.f(i(), nick, speakId, this.anchorId)) == null) {
            return "";
        }
        return f16;
    }

    private final GradientDrawable s() {
        return wi2.d.c(wi2.d.a(this, e.a(R.color.cj5)), wi2.c.d(12), wi2.c.d(12), wi2.c.d(12), wi2.c.d(12));
    }

    private final com.tencent.mobileqq.qqlive.widget.chat.span.e t() {
        return (com.tencent.mobileqq.qqlive.widget.chat.span.e) this.senderSpan.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(ChatGiftMsgItemView this$0, Bitmap it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.x(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(ChatGiftMsgItemView this$0, Bitmap it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.x(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(ChatGiftMsgItemView this$0, Bitmap it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.x(it);
    }

    private final void x(Bitmap bitmap) {
        int i3;
        boolean z16;
        List<? extends CharSequence> listOf;
        List<? extends CharSequence> listOf2;
        GiftMessage giftMessage = this.msg;
        if (giftMessage != null) {
            int i16 = giftMessage.giftNum;
            int i17 = giftMessage.allComboCnt;
            int i18 = i16 * i17;
            if (i18 != 0) {
                i16 = i18;
            }
            if (i16 == 0) {
                i3 = i17;
            } else {
                i3 = i16;
            }
            String r16 = r(giftMessage.senderNick, giftMessage.sender);
            if (TextUtils.isEmpty(r16)) {
                r16 = r(String.valueOf(giftMessage.sender), giftMessage.sender);
            }
            vi2.a f16 = f();
            if (f16 != null && !f16.z()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                z(i3);
            }
            if (giftMessage.batchSendCnt > 0) {
                String valueOf = String.valueOf(r16);
                com.tencent.mobileqq.qqlive.widget.chat.span.e t16 = t();
                LiveUserInfo liveUserInfo = new LiveUserInfo();
                liveUserInfo.nick = giftMessage.senderNick;
                liveUserInfo.uid = giftMessage.sender;
                liveUserInfo.headUrl = giftMessage.senderHead;
                t16.e(liveUserInfo, i(), this.anchorId);
                t16.c(g(this.screenMsg));
                Unit unit = Unit.INSTANCE;
                StringBuilder sb5 = new StringBuilder();
                sb5.append(" \u9001\u51fa");
                sb5.append(giftMessage.giftName);
                SpannableString d16 = d(" (" + giftMessage.batchSendCnt + "\u4e2a)x" + i3 + '\u7ec4', new ForegroundColorSpan(ContextCompat.getColor(getContext(), R.color.clc)));
                d16.setSpan(new StyleSpan(1), 0, d16.length(), 33);
                listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new CharSequence[]{d(valueOf, t16), d(sb5.toString(), new ForegroundColorSpan(ContextCompat.getColor(getContext(), R.color.clc))), ChatBaseText.b(this, bitmap, (int) ((((float) bitmap.getWidth()) * ((float) wi2.c.b(20))) / ((float) bitmap.getHeight())), wi2.c.b(20), 0, 0, 24, null), d16});
                setSpanText(listOf2);
            } else {
                String valueOf2 = String.valueOf(r16);
                com.tencent.mobileqq.qqlive.widget.chat.span.e t17 = t();
                LiveUserInfo liveUserInfo2 = new LiveUserInfo();
                liveUserInfo2.nick = giftMessage.senderNick;
                liveUserInfo2.uid = giftMessage.sender;
                liveUserInfo2.headUrl = giftMessage.senderHead;
                t17.e(liveUserInfo2, i(), this.anchorId);
                t17.c(g(this.screenMsg));
                Unit unit2 = Unit.INSTANCE;
                StringBuilder sb6 = new StringBuilder();
                sb6.append(" \u9001\u51fa");
                sb6.append(giftMessage.giftName);
                SpannableString d17 = d(" x" + i3, new ForegroundColorSpan(ContextCompat.getColor(getContext(), R.color.clc)));
                d17.setSpan(new StyleSpan(1), 0, d17.length(), 33);
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new CharSequence[]{d(valueOf2, t17), d(sb6.toString(), new ForegroundColorSpan(ContextCompat.getColor(getContext(), R.color.clc))), ChatBaseText.b(this, bitmap, (int) ((((float) bitmap.getWidth()) * ((float) wi2.c.b(20))) / ((float) bitmap.getHeight())), wi2.c.b(20), 0, 0, 24, null), d17});
                setSpanText(listOf);
            }
        }
        com.tencent.mobileqq.qqlive.widget.chat.message.d dVar = this.screenMsg;
        if (dVar != null) {
            l(dVar);
        }
    }

    public final void y(@NotNull com.tencent.mobileqq.qqlive.widget.chat.message.d msg2, long anchorId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, msg2, Long.valueOf(anchorId));
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        this.msg = msg2.b();
        this.screenMsg = msg2;
        this.anchorId = anchorId;
        vi2.c h16 = h();
        if (h16 != null) {
            h16.e(msg2.b().materialID, new b(this));
        }
    }

    public void z(int realGiftNum) {
        Unit unit;
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, realGiftNum);
            return;
        }
        GiftMessage giftMessage = this.msg;
        if (giftMessage != null) {
            long j3 = giftMessage.giftPrice;
            AegisLogger.INSTANCE.i("Chat_Message|ChatGiftMsgItemView", "updateGiftMessageBackground", "update while giftNum:" + realGiftNum + ", giftPrice:" + j3);
            long j16 = ((long) realGiftNum) * j3;
            boolean z18 = true;
            if (0 <= j16 && j16 < 80) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                setBackgroundDrawable(s());
            } else {
                if (80 <= j16 && j16 < 400) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    setBackgroundResource(R.drawable.l2u);
                } else {
                    if (400 > j16 || j16 >= 1000) {
                        z18 = false;
                    }
                    if (z18) {
                        setBackgroundResource(R.drawable.l2v);
                    } else {
                        setBackgroundResource(R.drawable.l2w);
                    }
                }
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            setBackgroundDrawable(s());
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ChatGiftMsgItemView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return;
        }
        iPatchRedirector.redirect((short) 5, (Object) this, (Object) context, (Object) attributeSet);
    }

    public /* synthetic */ ChatGiftMsgItemView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ChatGiftMsgItemView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        final Bitmap bitmap;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.qqlive.widget.chat.span.e>() { // from class: com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatGiftMsgItemView$senderSpan$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatGiftMsgItemView.this);
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
                ChatGiftMsgItemView chatGiftMsgItemView = ChatGiftMsgItemView.this;
                eVar.d(chatGiftMsgItemView.f(), chatGiftMsgItemView.h());
                return eVar;
            }
        });
        this.senderSpan = lazy;
        k();
        try {
            this.defaultIcon = BitmapFactory.decodeResource(BaseApplication.context.getResources(), R.drawable.o4z);
        } catch (Throwable th5) {
            AegisLogger.INSTANCE.e("Chat_Message|ChatGiftMsgItemView", "init", "defaultIcon init error ", th5);
        }
        if (SSODebugUtil.isTestEnv() && (bitmap = this.defaultIcon) != null) {
            post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.widget.chat.itemview.b
                @Override // java.lang.Runnable
                public final void run() {
                    ChatGiftMsgItemView.u(ChatGiftMsgItemView.this, bitmap);
                }
            });
        }
        setHighlightColor(0);
        setMovementMethod(LinkMovementMethod.getInstance());
    }
}
