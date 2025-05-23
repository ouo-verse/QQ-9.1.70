package com.tencent.mobileqq.icgame.widget.chat.itemview;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqlive.data.announce.AnnouncePushMessage;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qqlive.widget.chat.message.m;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import wi2.d;
import z42.a;
import z42.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0016\u0018\u0000 #2\u00020\u0001:\u0001$B'\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010 \u001a\u00020\u001f\u00a2\u0006\u0004\b!\u0010\"J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bJ\b\u0010\r\u001a\u00020\fH\u0016R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/icgame/widget/chat/itemview/ChatAnnounceMsgItemView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mobileqq/qqlive/data/announce/AnnouncePushMessage;", "announce", "", "roomId", "Lz42/a;", "dataSupport", "Lz42/c;", "playFunc", "", "c", "", "b", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "announceTv", "e", "noticeTitleText", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "announceSettingIv", h.F, "Landroid/widget/LinearLayout;", "announceSettingLl", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "i", "a", "ic-game-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public class ChatAnnounceMsgItemView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView announceTv;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView noticeTitleText;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView announceSettingIv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinearLayout announceSettingLl;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ChatAnnounceMsgItemView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(c cVar, AnnouncePushMessage announce, View it) {
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

    public boolean b() {
        return false;
    }

    public final void c(@NotNull final AnnouncePushMessage announce, long roomId, @Nullable z42.a dataSupport, @Nullable final c playFunc) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        LiveUserInfo selfUserInfo;
        String str;
        LiveUserInfo selfUserInfo2;
        LiveUserInfo selfUserInfo3;
        Intrinsics.checkNotNullParameter(announce, "announce");
        rt0.a.INSTANCE.j("ICGameChat_Message|ICGameChatAnnounceMsgItemView", "render...");
        this.announceTv.setText(announce.announce);
        boolean z26 = true;
        d.e(this.announceTv, !TextUtils.isEmpty(announce.announce));
        if (announce instanceof m) {
            z16 = ((m) announce).a();
        } else {
            z16 = true;
        }
        if (b()) {
            z16 = false;
        }
        LinearLayout linearLayout = this.announceSettingLl;
        if (dataSupport != null && (selfUserInfo3 = dataSupport.getSelfUserInfo()) != null && selfUserInfo3.uid == announce.uid) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17 && z16) {
            z18 = true;
        } else {
            z18 = false;
        }
        d.e(linearLayout, z18);
        this.announceSettingLl.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.icgame.widget.chat.itemview.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChatAnnounceMsgItemView.d(c.this, announce, view);
            }
        });
        if (dataSupport != null && (selfUserInfo2 = dataSupport.getSelfUserInfo()) != null && selfUserInfo2.uid == announce.uid) {
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
        if (dataSupport == null || (selfUserInfo = dataSupport.getSelfUserInfo()) == null || selfUserInfo.uid != announce.uid) {
            z26 = false;
        }
        if (z26 && dataSupport != null) {
            a.C11651a.a(dataSupport, this.announceSettingLl, true, null, "em_qqlive_set_announce", null, 16, null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ChatAnnounceMsgItemView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ChatAnnounceMsgItemView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ChatAnnounceMsgItemView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        setOrientation(1);
        View.inflate(context, R.layout.fav, this);
        View findViewById = findViewById(R.id.spx);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.announceSettingIv)");
        ImageView imageView = (ImageView) findViewById;
        this.announceSettingIv = imageView;
        View findViewById2 = findViewById(R.id.zsr);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.noticeTitleText)");
        TextView textView = (TextView) findViewById2;
        this.noticeTitleText = textView;
        View findViewById3 = findViewById(R.id.f164335sq0);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.announceTv)");
        this.announceTv = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.spy);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.announceSettingLl)");
        this.announceSettingLl = (LinearLayout) findViewById4;
        setPadding(wi2.c.b(10), wi2.c.b(8), wi2.c.b(10), wi2.c.b(8));
        d.d(this, wi2.c.b(15), c52.a.a(R.color.f156804bs));
        imageView.setImageResource(R.drawable.oaa);
        imageView.setColorFilter(Color.parseColor("#8A8AFF"));
        textView.setText("\u516c\u544a");
    }
}
