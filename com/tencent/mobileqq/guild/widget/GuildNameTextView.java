package com.tencent.mobileqq.guild.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.SkinConstants;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u00103\u001a\u000202\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010/\u0012\b\b\u0002\u00105\u001a\u00020\u0007\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u000e\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0005J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0014J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0014J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\b\u0010\u0014\u001a\u00020\u0003H\u0014J\b\u0010\u0015\u001a\u00020\u0003H\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010&\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010(\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010\"R\u0016\u0010*\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010\"R\u0016\u0010,\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010%R\u0016\u0010.\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010\"R\u0018\u00101\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u00100\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/GuildNameTextView;", "Landroid/view/View;", "Lcom/tencent/mobileqq/guild/theme/d;", "", "a", "", "text", "", NodeProps.MAX_WIDTH, "", "b", "inputText", IECSearchBar.METHOD_SET_TEXT, "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "onThemeChanged", NodeProps.ON_DETACHED_FROM_WINDOW, NodeProps.ON_ATTACHED_TO_WINDOW, "Landroid/graphics/Paint;", "d", "Landroid/graphics/Paint;", "paint", "e", "Ljava/lang/String;", "", "f", "Ljava/util/List;", "lines", "", tl.h.F, UserInfo.SEX_FEMALE, NodeProps.LINE_HEIGHT, "i", "I", SkinConstants.TintConstant.KEY_DEFAULT_COLOR, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "defaultSize", BdhLogUtil.LogTag.Tag_Conn, NodeProps.LINE_SPACING_EXTRA, "D", "textColor", "E", "textSize", "Landroid/util/AttributeSet;", "Landroid/util/AttributeSet;", "attributeSet", "Landroid/content/Context;", "context", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildNameTextView extends View implements com.tencent.mobileqq.guild.theme.d {

    /* renamed from: C, reason: from kotlin metadata */
    private float lineSpacingExtra;

    /* renamed from: D, reason: from kotlin metadata */
    private int textColor;

    /* renamed from: E, reason: from kotlin metadata */
    private float textSize;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private AttributeSet attributeSet;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint paint;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String text;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> lines;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float lineHeight;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int defaultColor;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final float defaultSize;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildNameTextView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void a() {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(this.attributeSet, up1.a.f439683u4);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026leable.GuildNameTextView)");
        this.lineSpacingExtra = obtainStyledAttributes.getDimension(up1.a.f439695v4, 0.0f);
        this.textColor = obtainStyledAttributes.getColor(up1.a.f439707w4, this.defaultColor);
        this.textSize = obtainStyledAttributes.getDimension(up1.a.f439720x4, this.defaultSize);
        obtainStyledAttributes.recycle();
        this.paint.setTextSize(this.textSize);
        this.paint.setColor(this.textColor);
    }

    private final List<String> b(String text, int maxWidth) {
        boolean z16;
        List<String> emptyList;
        int i3 = 0;
        if (text.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 || maxWidth <= 0) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        ArrayList arrayList = new ArrayList();
        while (i3 < text.length()) {
            int breakText = this.paint.breakText(text, i3, text.length(), true, maxWidth, null) + i3;
            String substring = text.substring(i3, breakText);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            arrayList.add(substring);
            i3 = breakText;
        }
        return arrayList;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        GuildThemeManager.g(this);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        GuildThemeManager.j(this);
    }

    @Override // android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        float f16 = -this.paint.getFontMetrics().top;
        Iterator<String> it = this.lines.iterator();
        while (it.hasNext()) {
            canvas.drawText(it.next(), 0.0f, f16, this.paint);
            f16 += this.lineHeight;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        this.lines.clear();
        this.lines.addAll(b(this.text, size));
        this.lineHeight = (this.paint.getFontMetrics().bottom - this.paint.getFontMetrics().top) + this.lineSpacingExtra;
        setMeasuredDimension(size, (int) (this.lines.size() * this.lineHeight));
    }

    @Override // com.tencent.mobileqq.guild.theme.d
    public void onThemeChanged() {
        a();
        invalidate();
    }

    public final void setText(@NotNull String inputText) {
        Intrinsics.checkNotNullParameter(inputText, "inputText");
        this.text = inputText;
        requestLayout();
        invalidate();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildNameTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildNameTextView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildNameTextView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.paint = new Paint(1);
        this.text = "";
        this.lines = new ArrayList();
        int g16 = ie0.a.f().g(context, R.color.qui_common_text_primary, 1000);
        this.defaultColor = g16;
        float spToPx = ViewUtils.spToPx(18.0f);
        this.defaultSize = spToPx;
        this.textColor = g16;
        this.textSize = spToPx;
        this.attributeSet = attributeSet;
        a();
    }
}
