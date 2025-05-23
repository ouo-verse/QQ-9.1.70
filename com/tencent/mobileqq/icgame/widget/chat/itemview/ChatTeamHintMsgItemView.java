package com.tencent.mobileqq.icgame.widget.chat.itemview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.profilecard.vas.misc.VasProfileTemplatePreloadHelper;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import w42.m;
import wi2.d;
import z42.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0012\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\"\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR$\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0013\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/icgame/widget/chat/itemview/ChatTeamHintMsgItemView;", "Lcom/tencent/mobileqq/icgame/widget/chat/itemview/ChatBaseText;", "Lw42/m;", "msg", "Lkotlin/Function1;", "", "", "cb", DomainData.DOMAIN_NAME, "Landroid/graphics/drawable/GradientDrawable;", "G", "Landroid/graphics/drawable/GradientDrawable;", VasProfileTemplatePreloadHelper.BACKGROUND, "H", "J", "teamId", "I", "Lkotlin/jvm/functions/Function1;", "com/tencent/mobileqq/icgame/widget/chat/itemview/ChatTeamHintMsgItemView$a", "Lcom/tencent/mobileqq/icgame/widget/chat/itemview/ChatTeamHintMsgItemView$a;", "tryJoinTeamClickSpan", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ic-game-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class ChatTeamHintMsgItemView extends ChatBaseText {

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final GradientDrawable bg;

    /* renamed from: H, reason: from kotlin metadata */
    private long teamId;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private Function1<? super Long, Unit> cb;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final a tryJoinTeamClickSpan;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/icgame/widget/chat/itemview/ChatTeamHintMsgItemView$a", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "", NodeProps.ON_CLICK, "ic-game-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class a extends ClickableSpan {
        a() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            Function1 function1 = ChatTeamHintMsgItemView.this.cb;
            if (function1 != null) {
                function1.invoke(Long.valueOf(ChatTeamHintMsgItemView.this.teamId));
            }
            z42.a dataSupport = ChatTeamHintMsgItemView.this.getDataSupport();
            if (dataSupport != null) {
                ChatTeamHintMsgItemView chatTeamHintMsgItemView = ChatTeamHintMsgItemView.this;
                Intrinsics.checkNotNull(chatTeamHintMsgItemView, "null cannot be cast to non-null type java.lang.Object");
                dataSupport.reportEvent("clck", chatTeamHintMsgItemView, new LinkedHashMap());
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ChatTeamHintMsgItemView(@NotNull Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public final void n(@NotNull m msg2, @NotNull Function1<? super Long, Unit> cb5) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        this.teamId = msg2.getMsg().content.anchor_premades_team_msg.team_id.get();
        c playFunc = getPlayFunc();
        if (playFunc != null) {
            playFunc.y(msg2, this);
        }
        this.cb = cb5;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ChatTeamHintMsgItemView(@NotNull Context ctx, @Nullable AttributeSet attributeSet) {
        this(ctx, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public /* synthetic */ ChatTeamHintMsgItemView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ChatTeamHintMsgItemView(@NotNull Context ctx, @Nullable AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        List<? extends CharSequence> listOf;
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        GradientDrawable c16 = d.c(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{Color.parseColor("#336B6BC7"), Color.parseColor("#B36B6BC7")}), wi2.c.d(12), wi2.c.d(12), wi2.c.d(12), wi2.c.d(12));
        this.bg = c16;
        a aVar = new a();
        this.tryJoinTeamClickSpan = aVar;
        setBackgroundDrawable(c16);
        Bitmap decodeResource = BitmapFactory.decodeResource(BaseApplication.context.getResources(), R.drawable.ovr);
        Intrinsics.checkNotNullExpressionValue(decodeResource, "decodeResource(\n        \u2026                        )");
        SpannableString spannableString = new SpannableString("\u53bb\u770b\u770b");
        spannableString.setSpan(new y42.d(Color.parseColor("#FFFFFF"), Color.parseColor("#000000"), wi2.c.b(9), true, wi2.c.d(10)), 0, 3, 33);
        spannableString.setSpan(aVar, 0, 3, 33);
        Unit unit = Unit.INSTANCE;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new CharSequence[]{a(decodeResource, wi2.c.b(16), wi2.c.b(16), 0, wi2.c.b(4)), d("\u4e3b\u64ad\u5f00\u542f\u4e86\u6e38\u620f\u7ec4\u961f ", new com.tencent.mobileqq.qqlive.widget.chat.span.c(0.9f)), spannableString});
        setSpanText(listOf);
    }
}
