package com.tencent.mobileqq.qqlive.widget.chat.itemview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.data.announce.AnnouncePushMessage;
import com.tencent.mobileqq.qqlive.widget.chat.font.FontSize;
import com.tencent.mobileqq.qqlive.widget.chat.message.m;
import com.tencent.mobileqq.qqlive.widget.util.e;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import vi2.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0016\u0018\u0000 (2\u00020\u0001:\u0001)B'\b\u0007\u0012\u0006\u0010!\u001a\u00020 \u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010%\u001a\u00020$\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0002J*\u0010\f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\b\u0010\u000e\u001a\u00020\rH\u0016J\u000e\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fR\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0017R\u0014\u0010\u001f\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0017\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/chat/itemview/ChatAnnounceMsgItemView;", "Landroid/widget/LinearLayout;", "", "e", "Lcom/tencent/mobileqq/qqlive/data/announce/AnnouncePushMessage;", "announce", "", "roomId", "Lvi2/a;", "dataSupport", "Lvi2/c;", "playFunc", "c", "", "b", "Lcom/tencent/mobileqq/qqlive/widget/chat/font/FontSize;", "fontSize", CanvasView.ACTION_SET_FONT_SIZE, "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "announceSettingIv", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "announceTv", "f", "Landroid/widget/LinearLayout;", "announceSettingLl", h.F, "noticeTitleText", "i", "announceSettingTv", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public class ChatAnnounceMsgItemView extends LinearLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView announceSettingIv;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView announceTv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinearLayout announceSettingLl;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView noticeTitleText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView announceSettingTv;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/chat/itemview/ChatAnnounceMsgItemView$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatAnnounceMsgItemView$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28054);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ChatAnnounceMsgItemView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return;
        }
        iPatchRedirector.redirect((short) 7, (Object) this, (Object) context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(vi2.c cVar, AnnouncePushMessage announce, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(announce, "$announce");
        if (cVar != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            String str = announce.announce;
            Intrinsics.checkNotNullExpressionValue(str, "announce.announce");
            cVar.q(it, str);
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    private final void e() {
        setPadding(wi2.c.b(8), wi2.c.b(4), wi2.c.b(8), wi2.c.b(4));
    }

    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return false;
    }

    public final void c(@NotNull final AnnouncePushMessage announce, long roomId, @Nullable vi2.a dataSupport, @Nullable final vi2.c playFunc) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z26 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, announce, Long.valueOf(roomId), dataSupport, playFunc);
            return;
        }
        Intrinsics.checkNotNullParameter(announce, "announce");
        AegisLogger.INSTANCE.i("Chat_Message|ChatAnnounceMsgItemView", "render...");
        this.announceTv.setText(announce.announce);
        wi2.d.e(this.announceTv, !TextUtils.isEmpty(announce.announce));
        if (announce instanceof m) {
            z16 = ((m) announce).a();
        } else {
            z16 = true;
        }
        if (b()) {
            z16 = false;
        }
        LinearLayout linearLayout = this.announceSettingLl;
        if (dataSupport != null && dataSupport.c() == announce.uid) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17 && z16) {
            z18 = true;
        } else {
            z18 = false;
        }
        wi2.d.e(linearLayout, z18);
        this.announceSettingLl.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.widget.chat.itemview.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChatAnnounceMsgItemView.d(vi2.c.this, announce, view);
            }
        });
        if (dataSupport != null && dataSupport.c() == announce.uid) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z19) {
            if (playFunc != null) {
                str = playFunc.o(announce.announce);
            } else {
                str = null;
            }
            this.noticeTitleText.setText("\u516c\u544a" + str);
        } else {
            this.noticeTitleText.setText("\u516c\u544a");
        }
        if (dataSupport == null || dataSupport.c() != announce.uid) {
            z26 = false;
        }
        if (z26 && dataSupport != null) {
            a.C11420a.a(dataSupport, this.announceSettingLl, true, null, "em_qqlive_set_announce", null, 16, null);
        }
    }

    public final void setFontSize(@NotNull FontSize fontSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) fontSize);
            return;
        }
        Intrinsics.checkNotNullParameter(fontSize, "fontSize");
        float sp5 = fontSize.getSp();
        TextView textView = this.noticeTitleText;
        if (textView != null) {
            textView.setTextSize(1, sp5);
        }
        TextView textView2 = this.announceTv;
        if (textView2 != null) {
            textView2.setTextSize(1, sp5);
        }
        TextView textView3 = this.announceSettingTv;
        if (textView3 != null) {
            textView3.setTextSize(1, sp5);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ChatAnnounceMsgItemView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            return;
        }
        iPatchRedirector.redirect((short) 6, (Object) this, (Object) context, (Object) attributeSet);
    }

    public /* synthetic */ ChatAnnounceMsgItemView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ChatAnnounceMsgItemView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        setOrientation(1);
        View.inflate(context, R.layout.hsp, this);
        View findViewById = findViewById(R.id.spx);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.announceSettingIv)");
        ImageView imageView = (ImageView) findViewById;
        this.announceSettingIv = imageView;
        View findViewById2 = findViewById(R.id.f164335sq0);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.announceTv)");
        TextView textView = (TextView) findViewById2;
        this.announceTv = textView;
        View findViewById3 = findViewById(R.id.spy);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.announceSettingLl)");
        this.announceSettingLl = (LinearLayout) findViewById3;
        View findViewById4 = findViewById(R.id.zsr);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.noticeTitleText)");
        this.noticeTitleText = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.spz);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.announceSettingTv)");
        this.announceSettingTv = (TextView) findViewById5;
        e();
        wi2.d.d(this, wi2.c.b(12), e.a(R.color.cj5));
        imageView.setImageResource(R.drawable.oaa);
        imageView.setColorFilter(Color.parseColor("#8A8AFF"));
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setIncludeFontPadding(false);
        textView.setLineSpacing(0.0f, 1.3f);
    }
}
