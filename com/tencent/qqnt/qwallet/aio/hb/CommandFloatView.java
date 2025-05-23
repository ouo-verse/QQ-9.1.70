package com.tencent.qqnt.qwallet.aio.hb;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewGroupKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.QQTheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 &2\u00020\u0001:\u0001\u001aB\u000f\u0012\u0006\u0010#\u001a\u00020\"\u00a2\u0006\u0004\b$\u0010%J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\t\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0007R\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\fR\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013R$\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR$\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001d\u0010\u001bR$\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00058\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\u00a8\u0006'"}, d2 = {"Lcom/tencent/qqnt/qwallet/aio/hb/CommandFloatView;", "Landroid/widget/LinearLayout;", "", "cmd", "listId", "", "expireTime", "", "setArgs", "e", "d", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", "containterView", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "iconView", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "titleView", tl.h.F, "contentView", "<set-?>", "i", "Ljava/lang/String;", "a", "()Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "c", BdhLogUtil.LogTag.Tag_Conn, "J", "b", "()J", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "D", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class CommandFloatView extends LinearLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private long expireTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewGroup containterView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView iconView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView titleView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView contentView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String cmd;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String listId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommandFloatView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, R.layout.hhq, this);
        View findViewById = findViewById(R.id.awh);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.chat_password_tips_container)");
        this.containterView = (ViewGroup) findViewById;
        View findViewById2 = findViewById(R.id.x_r);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.hint_icon)");
        this.iconView = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.awi);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.chat_password_tips_title)");
        this.titleView = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.awg);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.chat_password_text)");
        this.contentView = (TextView) findViewById4;
        this.cmd = "";
        this.listId = "";
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getCmd() {
        return this.cmd;
    }

    /* renamed from: b, reason: from getter */
    public final long getExpireTime() {
        return this.expireTime;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getListId() {
        return this.listId;
    }

    public final void d() {
        ViewGroup viewGroup;
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
        } else {
            viewGroup = null;
        }
        if (viewGroup == null || viewGroup.getChildCount() <= 0) {
            return;
        }
        for (View view : ViewGroupKt.getChildren(viewGroup)) {
            if ((view instanceof CommandFloatView) && view != this) {
                viewGroup.removeView(view);
            }
        }
    }

    public final void e() {
        ViewGroup viewGroup;
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
    }

    public final void setArgs(@NotNull String cmd, @NotNull String listId, long expireTime) {
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        Intrinsics.checkNotNullParameter(listId, "listId");
        this.cmd = cmd;
        this.listId = listId;
        this.expireTime = expireTime;
        this.contentView.setText(cmd);
        if (QQTheme.isNowThemeIsNight()) {
            this.containterView.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.otk));
            int parseColor = Color.parseColor("#FF5D5E61");
            this.iconView.setColorFilter(parseColor);
            this.titleView.setTextColor(parseColor);
            return;
        }
        this.containterView.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.otl));
        int parseColor2 = Color.parseColor("#FFA6A6A6");
        this.iconView.setColorFilter(parseColor2);
        this.titleView.setTextColor(parseColor2);
    }
}
