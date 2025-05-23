package com.tencent.mobileqq.icgame.widget.chat.itemview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.icgame.data.gift.GiftMessage;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqgift.updatasystem.QQGiftPanelResource;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qh2.f;
import rt0.a;
import w42.GiftScreenMsg;
import z42.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 02\u00020\u00012\u00020\u0002:\u00011B'\b\u0007\u0012\u0006\u0010*\u001a\u00020)\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+\u0012\b\b\u0002\u0010-\u001a\u00020\u0010\u00a2\u0006\u0004\b.\u0010/J\u001a\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0016\u0010\u000f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0005J*\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u0016J\u001a\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\u000e\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010\"R\u001b\u0010(\u001a\u00020#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/icgame/widget/chat/itemview/ChatGiftMsgItemView;", "Lcom/tencent/mobileqq/icgame/widget/chat/itemview/ChatBaseText;", "Lqh2/f;", "", "nick", "", "speakId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "p", "Lw42/d;", "msg", "anchorId", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "id", "errorCode", "httpCode", "errorMessage", "onLoadFail", "Lcom/tencent/mobileqq/qqgift/updatasystem/QQGiftPanelResource;", "panelResource", "c", "Lcom/tencent/mobileqq/icgame/data/gift/GiftMessage;", "G", "Lcom/tencent/mobileqq/icgame/data/gift/GiftMessage;", "H", "Lw42/d;", "screenMsg", "I", "Landroid/graphics/Bitmap;", "defaultIcon", "J", "Ly42/c;", "K", "Lkotlin/Lazy;", DomainData.DOMAIN_NAME, "()Ly42/c;", "senderSpan", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "L", "a", "ic-game-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public class ChatGiftMsgItemView extends ChatBaseText implements f {

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private GiftMessage msg;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private GiftScreenMsg screenMsg;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private Bitmap defaultIcon;

    /* renamed from: J, reason: from kotlin metadata */
    private long anchorId;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy senderSpan;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ChatGiftMsgItemView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final String m(String nick, long speakId) {
        String f16;
        c playFunc = getPlayFunc();
        if (playFunc == null || (f16 = playFunc.f(getRoomId(), nick, speakId, this.anchorId)) == null) {
            return "";
        }
        return f16;
    }

    private final y42.c n() {
        return (y42.c) this.senderSpan.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(ChatGiftMsgItemView this$0, Bitmap it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.p(it);
    }

    private final void p(Bitmap bitmap) {
        int i3;
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
            String m3 = m(giftMessage.senderNick, giftMessage.sender);
            if (TextUtils.isEmpty(m3)) {
                m3 = m(String.valueOf(giftMessage.sender), giftMessage.sender);
            }
            if (giftMessage.batchSendCnt > 0) {
                String valueOf = String.valueOf(m3);
                y42.c n3 = n();
                LiveUserInfo liveUserInfo = new LiveUserInfo();
                liveUserInfo.nick = giftMessage.senderNick;
                liveUserInfo.uid = giftMessage.sender;
                liveUserInfo.headUrl = giftMessage.senderHead;
                n3.d(liveUserInfo, getRoomId(), this.anchorId);
                Unit unit = Unit.INSTANCE;
                StringBuilder sb5 = new StringBuilder();
                sb5.append(" \u9001\u51fa");
                sb5.append(giftMessage.giftName);
                SpannableString d16 = d(" (" + giftMessage.batchSendCnt + "\u4e2a)x" + i3 + '\u7ec4', new ForegroundColorSpan(ContextCompat.getColor(getContext(), R.color.chn)));
                d16.setSpan(new StyleSpan(1), 0, d16.length(), 33);
                listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new CharSequence[]{d(valueOf, n3), d(sb5.toString(), new ForegroundColorSpan(ContextCompat.getColor(getContext(), R.color.chn))), ChatBaseText.b(this, bitmap, (int) ((((float) bitmap.getWidth()) * ((float) wi2.c.b(20))) / ((float) bitmap.getHeight())), wi2.c.b(20), 0, 0, 24, null), d16});
                setSpanText(listOf2);
            } else {
                String valueOf2 = String.valueOf(m3);
                y42.c n16 = n();
                LiveUserInfo liveUserInfo2 = new LiveUserInfo();
                liveUserInfo2.nick = giftMessage.senderNick;
                liveUserInfo2.uid = giftMessage.sender;
                liveUserInfo2.headUrl = giftMessage.senderHead;
                n16.d(liveUserInfo2, getRoomId(), this.anchorId);
                Unit unit2 = Unit.INSTANCE;
                StringBuilder sb6 = new StringBuilder();
                sb6.append(" \u9001\u51fa");
                sb6.append(giftMessage.giftName);
                SpannableString d17 = d(" x" + i3, new ForegroundColorSpan(ContextCompat.getColor(getContext(), R.color.chn)));
                d17.setSpan(new StyleSpan(1), 0, d17.length(), 33);
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new CharSequence[]{d(valueOf2, n16), d(sb6.toString(), new ForegroundColorSpan(ContextCompat.getColor(getContext(), R.color.chn))), ChatBaseText.b(this, bitmap, (int) ((((float) bitmap.getWidth()) * ((float) wi2.c.b(20))) / ((float) bitmap.getHeight())), wi2.c.b(20), 0, 0, 24, null), d17});
                setSpanText(listOf);
            }
        }
        GiftScreenMsg giftScreenMsg = this.screenMsg;
        if (giftScreenMsg != null) {
            k(giftScreenMsg);
        }
    }

    @Override // qh2.f
    public void c(int id5, @Nullable QQGiftPanelResource panelResource) {
        Integer num;
        final Bitmap decodeFile;
        a.Companion companion = rt0.a.INSTANCE;
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
        companion.k("ICGameChat_Message|ICGameChatGiftMsgItemView", "onLoadSuccess", sb5.toString());
        GiftMessage giftMessage2 = this.msg;
        if (giftMessage2 != null && giftMessage2.materialID == id5 && panelResource != null) {
            try {
                String str2 = panelResource.f265002b;
                if (str2 != null && (decodeFile = BitmapFactory.decodeFile(str2)) != null) {
                    post(new Runnable() { // from class: com.tencent.mobileqq.icgame.widget.chat.itemview.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            ChatGiftMsgItemView.o(ChatGiftMsgItemView.this, decodeFile);
                        }
                    });
                }
            } catch (Exception e16) {
                QLog.i("ICGameChat_Message|ICGameChatGiftMsgItemView", 1, "onLoadSuccess:throw Exception!", e16);
            }
        }
    }

    @Override // qh2.g
    public void onLoadFail(int id5, int errorCode, int httpCode, @Nullable String errorMessage) {
        rt0.a.INSTANCE.h("ICGameChat_Message|ICGameChatGiftMsgItemView", "onLoadFail", "id:" + id5 + ",errorCode:" + errorCode + ",httpCode:" + httpCode + ",errorMessage:" + errorMessage);
        Bitmap bitmap = this.defaultIcon;
        if (bitmap != null) {
            p(bitmap);
        }
    }

    public final void q(@NotNull GiftScreenMsg msg2, long anchorId) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        this.msg = msg2.getGiftMessage();
        this.screenMsg = msg2;
        this.anchorId = anchorId;
        c playFunc = getPlayFunc();
        if (playFunc != null) {
            playFunc.e(msg2.getGiftMessage().materialID, this);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ChatGiftMsgItemView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ChatGiftMsgItemView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ChatGiftMsgItemView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<y42.c>() { // from class: com.tencent.mobileqq.icgame.widget.chat.itemview.ChatGiftMsgItemView$senderSpan$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final y42.c invoke() {
                y42.c cVar = new y42.c();
                ChatGiftMsgItemView chatGiftMsgItemView = ChatGiftMsgItemView.this;
                cVar.c(chatGiftMsgItemView.getDataSupport(), chatGiftMsgItemView.getPlayFunc());
                return cVar;
            }
        });
        this.senderSpan = lazy;
        j();
        try {
            this.defaultIcon = BitmapFactory.decodeResource(BaseApplication.context.getResources(), R.drawable.o4z);
        } catch (Throwable th5) {
            rt0.a.INSTANCE.i("ICGameChat_Message|ICGameChatGiftMsgItemView", "init", "defaultIcon init error ", th5);
        }
        setHighlightColor(0);
        setMovementMethod(LinkMovementMethod.getInstance());
    }
}
