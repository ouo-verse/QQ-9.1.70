package com.tencent.mobileqq.wink.magicAvatar.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.wink.magicAvatar.widget.MagicAvatarNextButton;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001$B'\b\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010!\u001a\u00020 \u00a2\u0006\u0004\b\"\u0010#R*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR*\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\tR.\u0010\u001b\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/wink/magicAvatar/widget/MagicAvatarNextButton;", "Landroidx/appcompat/widget/AppCompatButton;", "Lkotlin/Function0;", "", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/jvm/functions/Function0;", "getNormalClickedListener", "()Lkotlin/jvm/functions/Function0;", "setNormalClickedListener", "(Lkotlin/jvm/functions/Function0;)V", "normalClickedListener", "D", "getVipClickedListener", "setVipClickedListener", "vipClickedListener", "E", "getErrorClickedListener", "setErrorClickedListener", "errorClickedListener", "Lcom/tencent/mobileqq/wink/magicAvatar/widget/MagicAvatarNextButton$a;", "value", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/wink/magicAvatar/widget/MagicAvatarNextButton$a;", "c", "()Lcom/tencent/mobileqq/wink/magicAvatar/widget/MagicAvatarNextButton$a;", "setStates", "(Lcom/tencent/mobileqq/wink/magicAvatar/widget/MagicAvatarNextButton$a;)V", "states", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class MagicAvatarNextButton extends AppCompatButton {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private Function0<Unit> normalClickedListener;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Function0<Unit> vipClickedListener;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Function0<Unit> errorClickedListener;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private a states;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/wink/magicAvatar/widget/MagicAvatarNextButton$a;", "", "<init>", "()V", "a", "b", "c", "Lcom/tencent/mobileqq/wink/magicAvatar/widget/MagicAvatarNextButton$a$a;", "Lcom/tencent/mobileqq/wink/magicAvatar/widget/MagicAvatarNextButton$a$b;", "Lcom/tencent/mobileqq/wink/magicAvatar/widget/MagicAvatarNextButton$a$c;", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static abstract class a {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/wink/magicAvatar/widget/MagicAvatarNextButton$a$a;", "Lcom/tencent/mobileqq/wink/magicAvatar/widget/MagicAvatarNextButton$a;", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "text", "<init>", "(Ljava/lang/String;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.wink.magicAvatar.widget.MagicAvatarNextButton$a$a, reason: collision with other inner class name */
        /* loaded from: classes21.dex */
        public static final class C9059a extends a {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final String text;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C9059a(@NotNull String text) {
                super(null);
                Intrinsics.checkNotNullParameter(text, "text");
                this.text = text;
            }

            @NotNull
            /* renamed from: a, reason: from getter */
            public final String getText() {
                return this.text;
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/wink/magicAvatar/widget/MagicAvatarNextButton$a$b;", "Lcom/tencent/mobileqq/wink/magicAvatar/widget/MagicAvatarNextButton$a;", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes21.dex */
        public static final class b extends a {

            /* renamed from: a, reason: collision with root package name */
            @NotNull
            public static final b f323604a = new b();

            b() {
                super(null);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/wink/magicAvatar/widget/MagicAvatarNextButton$a$c;", "Lcom/tencent/mobileqq/wink/magicAvatar/widget/MagicAvatarNextButton$a;", "", "a", "I", "()I", "vipTotalCount", "<init>", "(I)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes21.dex */
        public static final class c extends a {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            private final int vipTotalCount;

            public c(int i3) {
                super(null);
                this.vipTotalCount = i3;
            }

            /* renamed from: a, reason: from getter */
            public final int getVipTotalCount() {
                return this.vipTotalCount;
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MagicAvatarNextButton(@NotNull Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(MagicAvatarNextButton this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!NetworkUtil.isNetworkAvailable()) {
            Function0<Unit> function0 = this$0.errorClickedListener;
            if (function0 != null) {
                function0.invoke();
            }
        } else {
            a aVar = this$0.states;
            if (aVar instanceof a.C9059a) {
                Function0<Unit> function02 = this$0.normalClickedListener;
                if (function02 != null) {
                    function02.invoke();
                }
            } else if (aVar instanceof a.c) {
                Function0<Unit> function03 = this$0.vipClickedListener;
                if (function03 != null) {
                    function03.invoke();
                }
            } else {
                boolean z16 = aVar instanceof a.b;
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final a getStates() {
        return this.states;
    }

    public final void setErrorClickedListener(@Nullable Function0<Unit> function0) {
        this.errorClickedListener = function0;
    }

    public final void setNormalClickedListener(@Nullable Function0<Unit> function0) {
        this.normalClickedListener = function0;
    }

    public final void setStates(@Nullable a aVar) {
        this.states = aVar;
        if (aVar instanceof a.C9059a) {
            setBackground(ContextCompat.getDrawable(getContext(), R.drawable.qvideo_skin_bg_btn_primary_normal));
            setTextColor(-1);
            setText(((a.C9059a) aVar).getText());
            return;
        }
        if (aVar instanceof a.b) {
            setBackground(ContextCompat.getDrawable(getContext(), R.drawable.m5b));
            setTextColor(ContextCompat.getColor(getContext(), R.color.cli));
            setText("\u4eca\u65e5\u4f7f\u7528\u6b21\u6570\u5df2\u8fbe\u4e0a\u9650\uff0c\u660e\u65e5\u518d\u6765\u5427\uff01");
        } else if (aVar instanceof a.c) {
            setBackground(ContextCompat.getDrawable(getContext(), R.drawable.m5c));
            setTextColor(Color.parseColor("#9A5810"));
            setText("\u5f00\u901aSVIP\uff0c\u89e3\u9501\u6bcf\u65e5\u989d\u5916" + ((a.c) aVar).getVipTotalCount() + "\u6b21\u751f\u6210\u673a\u4f1a");
        }
    }

    public final void setVipClickedListener(@Nullable Function0<Unit> function0) {
        this.vipClickedListener = function0;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MagicAvatarNextButton(@NotNull Context ctx, @Nullable AttributeSet attributeSet) {
        this(ctx, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public /* synthetic */ MagicAvatarNextButton(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MagicAvatarNextButton(@NotNull Context ctx, @Nullable AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        setOnClickListener(new View.OnClickListener() { // from class: k83.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MagicAvatarNextButton.b(MagicAvatarNextButton.this, view);
            }
        });
    }
}
