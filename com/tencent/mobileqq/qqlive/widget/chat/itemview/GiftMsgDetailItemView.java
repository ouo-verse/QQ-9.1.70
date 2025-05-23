package com.tencent.mobileqq.qqlive.widget.chat.itemview;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.ams.mosaic.jsengine.component.text.TextComponent;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.widget.chat.font.FontSize;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 02\u00020\u0001:\u00011B'\b\u0007\u0012\u0006\u0010)\u001a\u00020(\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*\u0012\b\b\u0002\u0010-\u001a\u00020,\u00a2\u0006\u0004\b.\u0010/J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u0010\u001a\u00020\u000eJ\u001a\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\u000e\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u0007J\u0016\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\fR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010%\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\u001eR\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/chat/itemview/GiftMsgDetailItemView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/tencent/mobileqq/qqlive/widget/chat/message/d;", "msg", "", "B0", "A0", "Lcom/tencent/mobileqq/qqlive/widget/chat/font/FontSize;", "fontSize", "", "C0", "z0", "", "roomId", "", "setRoomId", "D0", "Lvi2/a;", "dataSupport", "Lvi2/c;", "playFunc", "setSupportFunc", "Landroid/graphics/Typeface;", TextComponent.SpanStyle.TYPEFACE, "setTypeface", CanvasView.ACTION_SET_FONT_SIZE, "anchorId", "E0", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "msgTimeTv", "Lcom/tencent/mobileqq/qqlive/widget/chat/itemview/ChatGiftMsgItemView;", "e", "Lcom/tencent/mobileqq/qqlive/widget/chat/itemview/ChatGiftMsgItemView;", "giftMsgItemView", "f", "msgGiftCoinValueTv", h.F, "Landroid/graphics/Typeface;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "i", "a", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class GiftMsgDetailItemView extends ConstraintLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView msgTimeTv;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ChatGiftMsgItemView giftMsgItemView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView msgGiftCoinValueTv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Typeface typeface;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/chat/itemview/GiftMsgDetailItemView$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.widget.chat.itemview.GiftMsgDetailItemView$a, reason: from kotlin metadata */
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
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public /* synthetic */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f273832a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30445);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[FontSize.values().length];
            try {
                iArr[FontSize.SMALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FontSize.STANDARD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FontSize.LARGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f273832a = iArr;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30447);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GiftMsgDetailItemView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            return;
        }
        iPatchRedirector.redirect((short) 10, (Object) this, (Object) context);
    }

    private final String A0(com.tencent.mobileqq.qqlive.widget.chat.message.d msg2) {
        long j3;
        long j16;
        int i3 = msg2.b().allComboCnt;
        if (i3 <= 0) {
            AegisLogger.INSTANCE.e("Chat_Message|GiftMsgDetailItemView", "allComboCnt invalid", "original value:" + i3);
            i3 = 1;
        }
        if (msg2.b().batchSendCnt > 0) {
            j3 = msg2.b().giftPrice * i3 * msg2.b().giftNum;
            j16 = msg2.b().batchSendCnt;
        } else {
            j3 = msg2.b().giftPrice * i3;
            j16 = msg2.b().giftNum;
        }
        long j17 = j3 * j16;
        if (j17 <= JsonGrayBusiId.UI_RESERVE_100000_110000) {
            return String.valueOf(j17);
        }
        float floor = ((float) Math.floor((((float) j17) / 10000) * r0)) / 10;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%.1f\u4e07", Arrays.copyOf(new Object[]{Float.valueOf(floor)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }

    private final String B0(com.tencent.mobileqq.qqlive.widget.chat.message.d msg2) {
        String format = new SimpleDateFormat(DateUtil.DATE_FORMAT_HOUR, Locale.getDefault()).format(new Date(msg2.b().comboSeq));
        Intrinsics.checkNotNullExpressionValue(format, "sdf.format(Date(msg.giftMessage.comboSeq))");
        return format;
    }

    private final float C0(FontSize fontSize) {
        int i3 = b.f273832a[fontSize.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    return 14.0f;
                }
                throw new NoWhenBranchMatchedException();
            }
            return 12.0f;
        }
        return 10.0f;
    }

    private final float z0(FontSize fontSize) {
        int i3 = b.f273832a[fontSize.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    return 16.0f;
                }
                throw new NoWhenBranchMatchedException();
            }
            return 14.0f;
        }
        return 12.0f;
    }

    public final void D0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        ChatGiftMsgItemView chatGiftMsgItemView = this.giftMsgItemView;
        if (chatGiftMsgItemView != null) {
            chatGiftMsgItemView.k();
        }
    }

    public final void E0(@NotNull com.tencent.mobileqq.qqlive.widget.chat.message.d msg2, long anchorId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, msg2, Long.valueOf(anchorId));
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        ChatGiftMsgItemView chatGiftMsgItemView = this.giftMsgItemView;
        if (chatGiftMsgItemView != null) {
            chatGiftMsgItemView.y(msg2, anchorId);
        }
        TextView textView = this.msgTimeTv;
        if (textView != null) {
            textView.setText(B0(msg2));
        }
        TextView textView2 = this.msgGiftCoinValueTv;
        if (textView2 != null) {
            textView2.setText(A0(msg2));
        }
        TextView textView3 = this.msgGiftCoinValueTv;
        if (textView3 != null) {
            textView3.setTypeface(this.typeface);
        }
    }

    public final void setFontSize(@NotNull FontSize fontSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) fontSize);
            return;
        }
        Intrinsics.checkNotNullParameter(fontSize, "fontSize");
        TextView textView = this.msgTimeTv;
        if (textView != null) {
            textView.setTextSize(1, C0(fontSize));
        }
        ChatGiftMsgItemView chatGiftMsgItemView = this.giftMsgItemView;
        if (chatGiftMsgItemView != null) {
            chatGiftMsgItemView.setFontSize(fontSize);
        }
        TextView textView2 = this.msgGiftCoinValueTv;
        if (textView2 != null) {
            textView2.setTextSize(1, z0(fontSize));
        }
    }

    public final void setRoomId(long roomId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, roomId);
            return;
        }
        ChatGiftMsgItemView chatGiftMsgItemView = this.giftMsgItemView;
        if (chatGiftMsgItemView != null) {
            chatGiftMsgItemView.setRoomId(roomId);
        }
    }

    public final void setSupportFunc(@Nullable vi2.a dataSupport, @Nullable vi2.c playFunc) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) dataSupport, (Object) playFunc);
            return;
        }
        ChatGiftMsgItemView chatGiftMsgItemView = this.giftMsgItemView;
        if (chatGiftMsgItemView != null) {
            chatGiftMsgItemView.setSupportFunc(dataSupport, playFunc);
        }
    }

    public final void setTypeface(@NotNull Typeface typeface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) typeface);
        } else {
            Intrinsics.checkNotNullParameter(typeface, "typeface");
            this.typeface = typeface;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GiftMsgDetailItemView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            return;
        }
        iPatchRedirector.redirect((short) 9, (Object) this, (Object) context, (Object) attributeSet);
    }

    public /* synthetic */ GiftMsgDetailItemView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GiftMsgDetailItemView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        Typeface DEFAULT = Typeface.DEFAULT;
        Intrinsics.checkNotNullExpressionValue(DEFAULT, "DEFAULT");
        this.typeface = DEFAULT;
        View.inflate(context, R.layout.h_p, this);
        this.msgTimeTv = (TextView) findViewById(R.id.f166336f24);
        this.giftMsgItemView = (ChatGiftMsgItemView) findViewById(R.id.f166330zg2);
        this.msgGiftCoinValueTv = (TextView) findViewById(R.id.f166329zg1);
    }
}
