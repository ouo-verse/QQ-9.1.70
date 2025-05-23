package com.tencent.mobileqq.vas.font.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.vas.font.IFontManager;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.updatesystem.business.FontBusiness;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import y03.AIOTextViewInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010-\u001a\u00020*\u00a2\u0006\u0004\b.\u0010/J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001a\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\b\u0010\u0013\u001a\u00020\u0007H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u001c\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0017H\u0016J!\u0010\u001b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\tH\u0016\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u001c\u0010\"\u001a\u00020\u00072\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070 H\u0016J\u0010\u0010$\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u000eH\u0016J\u0010\u0010%\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\tH\u0016J\u0012\u0010'\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010&H\u0016J\b\u0010(\u001a\u00020\tH\u0016J\b\u0010)\u001a\u00020\u0014H\u0016R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/vas/font/drawable/c;", "Landroid/graphics/drawable/Drawable;", "Ly03/c;", "", DomainData.DOMAIN_NAME, "Landroid/graphics/Rect;", "padding", "", "j", "", "widthMeasureSpec", "heightMeasureSpec", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/graphics/Canvas;", PM.CANVAS, "Lcom/tencent/mobileqq/vas/font/IFontManager$b;", "e", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "g", "", "o", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "a", HippyTKDListViewAdapter.X, "y", "b", "(II)Ljava/lang/Integer;", "Ly03/a;", "info", "f", "Lkotlin/Function1;", "block", "setLoadedListener", "p0", "draw", "setAlpha", "Landroid/graphics/ColorFilter;", "setColorFilter", "getOpacity", "t", "Lcom/tencent/mobileqq/vas/font/IFontManager$c;", "d", "Lcom/tencent/mobileqq/vas/font/IFontManager$c;", "fontDrawableInfo", "<init>", "(Lcom/tencent/mobileqq/vas/font/IFontManager$c;)V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class c extends Drawable implements y03.c {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IFontManager.FontDrawableInfo fontDrawableInfo;

    public c(@NotNull IFontManager.FontDrawableInfo fontDrawableInfo) {
        Intrinsics.checkNotNullParameter(fontDrawableInfo, "fontDrawableInfo");
        this.fontDrawableInfo = fontDrawableInfo;
    }

    @Override // y03.c
    @Nullable
    public ArrayList<Rect> a() {
        return null;
    }

    @Override // y03.c
    @Nullable
    public Integer b(int x16, int y16) {
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas p06) {
        Intrinsics.checkNotNullParameter(p06, "p0");
    }

    @Override // y03.c
    @NotNull
    public IFontManager.DrawableResultInfo e(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        return new IFontManager.DrawableResultInfo(false, false, 0);
    }

    @Override // y03.c
    public void f(@NotNull AIOTextViewInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // y03.c
    public void j(@NotNull Rect padding) {
        Intrinsics.checkNotNullParameter(padding, "padding");
    }

    @Override // y03.c
    @NotNull
    public String n() {
        String fontPath = ((FontBusiness) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(FontBusiness.class)).getFontPath(this.fontDrawableInfo.getFontId());
        Intrinsics.checkNotNullExpressionValue(fontPath, "fontBusiness.getFontPath(fontDrawableInfo.fontId)");
        return fontPath;
    }

    @Override // y03.c
    public boolean o() {
        return false;
    }

    @Override // y03.c
    @Nullable
    public int[] q(int widthMeasureSpec, int heightMeasureSpec) {
        return null;
    }

    @Override // y03.c
    public void setLoadedListener(@NotNull Function1<? super y03.c, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
    }

    @Override // y03.c
    public boolean t() {
        return false;
    }

    @Override // y03.c
    public void g() {
    }

    @Override // y03.c
    public void m() {
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int p06) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter p06) {
    }
}
