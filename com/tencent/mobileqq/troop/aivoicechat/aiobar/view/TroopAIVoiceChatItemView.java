package com.tencent.mobileqq.troop.aivoicechat.aiobar.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqnt.kernel.nativeinterface.AIVoiceChatType;
import com.tencent.qqnt.kernel.nativeinterface.VoiceItem;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;
import vr2.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0006\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\bJ\u0010\u0010\r\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0002J\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004R\u0016\u0010\u0013\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0015R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/troop/aivoicechat/aiobar/view/TroopAIVoiceChatItemView;", "Landroid/widget/LinearLayout;", "", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/VoiceItem;", "voiceItem", "", "aiChatType", "", "b", "a", "Landroid/graphics/drawable/Drawable;", "waveDrawable", "setSelect", "isSelect", "e", "c", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "imageView", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "voiceNameTv", "f", "Lcom/tencent/qqnt/kernel/nativeinterface/VoiceItem;", h.F, "I", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "i", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class TroopAIVoiceChatItemView extends LinearLayout {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ImageView imageView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView voiceNameTv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private VoiceItem voiceItem;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int aiChatType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\bR\u0014\u0010\f\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/troop/aivoicechat/aiobar/view/TroopAIVoiceChatItemView$a;", "", "Landroid/content/Context;", "context", "Landroid/view/View;", "a", "", "ITEM_HEIGHT", UserInfo.SEX_FEMALE, "ITEM_ICON_SIZE", "ITEM_MARGIN", "ITEM_PADDING_HORIZONTAL", "NAME_LEFT_MARGIN", "NAME_TEXT_SIZE", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.aivoicechat.aiobar.view.TroopAIVoiceChatItemView$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final View a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            View view = new View(context);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewUtils.dpToPx(8.0f), ViewUtils.dpToPx(8.0f)));
            return view;
        }

        Companion() {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TroopAIVoiceChatItemView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final boolean d() {
        return this.voiceItem == null;
    }

    public final void a() {
        this.imageView.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.qui_add));
        this.voiceNameTv.setText(getContext().getString(R.string.f131081));
    }

    public final void b(VoiceItem voiceItem, int aiChatType) {
        Intrinsics.checkNotNullParameter(voiceItem, "voiceItem");
        this.voiceItem = voiceItem;
        this.aiChatType = aiChatType;
        ImageView imageView = this.imageView;
        b bVar = b.f443198a;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        imageView.setImageDrawable(bVar.a(context, aiChatType, false));
        this.voiceNameTv.setText(voiceItem.displayName);
    }

    /* renamed from: c, reason: from getter */
    public final VoiceItem getVoiceItem() {
        return this.voiceItem;
    }

    public final void e(boolean isSelect) {
        int color;
        if (d()) {
            return;
        }
        ImageView imageView = this.imageView;
        b bVar = b.f443198a;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        imageView.setImageDrawable(bVar.a(context, this.aiChatType, isSelect));
        if (isSelect) {
            color = getContext().getColor(R.color.qui_common_brand_standard);
        } else {
            color = getContext().getColor(R.color.qui_common_text_primary);
        }
        this.voiceNameTv.setTextColor(color);
    }

    public final void setSelect(Drawable waveDrawable) {
        if (d()) {
            return;
        }
        this.voiceNameTv.setTextColor(getContext().getColor(R.color.qui_common_brand_standard));
        this.imageView.setImageDrawable(waveDrawable);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TroopAIVoiceChatItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ TroopAIVoiceChatItemView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopAIVoiceChatItemView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.aiChatType = AIVoiceChatType.KAIVOICECHATTYPESOUND.ordinal();
        setLayoutParams(new ViewGroup.LayoutParams(-2, ViewUtils.dpToPx(30.0f)));
        setOrientation(0);
        setGravity(17);
        setBackground(ContextCompat.getDrawable(context, R.drawable.a9n));
        setPadding(ViewUtils.dpToPx(10.0f), 0, ViewUtils.dpToPx(10.0f), 0);
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(ViewUtils.dpToPx(14.0f), ViewUtils.dpToPx(14.0f)));
        addView(imageView);
        this.imageView = imageView;
        TextView textView = new TextView(context);
        int dpToPx = ViewUtils.dpToPx(4.0f);
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams == null) {
            ViewGroup.LayoutParams layoutParams2 = textView.getLayoutParams();
            int i16 = layoutParams2 != null ? layoutParams2.width : -2;
            ViewGroup.LayoutParams layoutParams3 = textView.getLayoutParams();
            marginLayoutParams = new ViewGroup.MarginLayoutParams(i16, layoutParams3 != null ? layoutParams3.height : -2);
        }
        if (dpToPx != marginLayoutParams.leftMargin) {
            marginLayoutParams.leftMargin = dpToPx;
            textView.setLayoutParams(marginLayoutParams);
        }
        textView.setTextSize(13.0f);
        textView.setTextColor(context.getColor(R.color.qui_common_text_primary));
        addView(textView);
        this.voiceNameTv = textView;
    }
}
