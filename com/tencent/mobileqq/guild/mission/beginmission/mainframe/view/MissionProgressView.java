package com.tencent.mobileqq.guild.mission.beginmission.mainframe.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.base.extension.s;
import com.tencent.mobileqq.guild.util.TypefaceProvider;
import com.tencent.mobileqq.guild.widget.GuildProgressView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import up1.a;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u00a2\u0006\u0004\b\u001f\u0010 J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\u0004R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/mission/beginmission/mainframe/view/MissionProgressView;", "Landroid/widget/LinearLayout;", "", "title", "", "setTitle", "", "total", "setTotal", "progress", HippyQQPagView.FunctionName.SET_PROGRESS, "a", "d", "I", "e", "f", "Ljava/lang/String;", "Landroid/widget/TextView;", h.F, "Landroid/widget/TextView;", "progressTitle", "i", "progressText", "Lcom/tencent/mobileqq/guild/widget/GuildProgressView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/widget/GuildProgressView;", "progressView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class MissionProgressView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int total;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int progress;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String title;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView progressTitle;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView progressText;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildProgressView progressView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MissionProgressView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void a() {
        this.progressTitle.setText(this.title);
        s.c(this.progressText, R.string.f143330ls, Integer.valueOf(this.progress), Integer.valueOf(this.total));
        this.progressView.setTotal(this.total);
        this.progressView.setProgress(this.progress);
    }

    public final void setProgress(int progress) {
        this.progress = progress;
        a();
    }

    public final void setTitle(@NotNull String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        this.title = title;
        a();
    }

    public final void setTotal(int total) {
        this.total = total;
        a();
    }

    public /* synthetic */ MissionProgressView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MissionProgressView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.title = "";
        View.inflate(context, R.layout.egs, this);
        setOrientation(0);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setGravity(16);
        View findViewById = findViewById(R.id.f28620jf);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.progress_title)");
        TextView textView = (TextView) findViewById;
        this.progressTitle = textView;
        textView.getPaint().setFakeBoldText(true);
        View findViewById2 = findViewById(R.id.g27);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.progress_text)");
        TextView textView2 = (TextView) findViewById2;
        this.progressText = textView2;
        textView2.setTypeface(TypefaceProvider.c(context, "fonts/DIN-NextLT-Pro-QQ.ttf"));
        View findViewById3 = findViewById(R.id.g1o);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.progress_bar)");
        this.progressView = (GuildProgressView) findViewById3;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.J4);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026leable.GuildProgressView)");
        this.total = obtainStyledAttributes.getInt(a.O4, 0);
        this.progress = obtainStyledAttributes.getInt(a.L4, 0);
        String string = obtainStyledAttributes.getString(a.N4);
        this.title = string != null ? string : "";
        a();
        obtainStyledAttributes.recycle();
    }
}
