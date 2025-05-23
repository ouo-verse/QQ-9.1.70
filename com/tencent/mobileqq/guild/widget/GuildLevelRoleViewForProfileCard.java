package com.tencent.mobileqq.guild.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.guild.widget.GuildLevelRoleView;
import com.tencent.mobileqq.guild.widget.GuildLevelRoleViewForProfileCard;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.cq;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 J2\u00020\u0001:\u0002KLB'\b\u0007\u0012\u0006\u0010D\u001a\u00020C\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010E\u0012\b\b\u0002\u0010G\u001a\u00020\u0006\u00a2\u0006\u0004\bH\u0010IJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0014J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0014J\b\u0010\r\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u001e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0013H\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001aR\u0014\u0010!\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u001aR\u0014\u0010#\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001aR\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010*R\u0016\u0010.\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010*R\u0016\u00100\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010*R\u0016\u00102\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010*R\u0016\u00104\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010*R\u0016\u00106\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010*R\u0014\u0010:\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010A\u00a8\u0006M"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/GuildLevelRoleViewForProfileCard;", "Landroid/view/View;", "Lcom/tencent/mobileqq/guild/widget/GuildLevelRoleViewForProfileCard$a;", "uiData", "", "y", "", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", HippyTKDListViewAdapter.X, "v", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", ReportConstant.COSTREPORT_PREFIX, "t", "Lkotlin/Function0;", "function", "w", "d", "Lcom/tencent/mobileqq/guild/widget/GuildLevelRoleViewForProfileCard$a;", "Landroid/graphics/Paint;", "e", "Landroid/graphics/Paint;", "bgPaint", "f", "bgOuterStokePaint", tl.h.F, "bgOuterLinePaint", "i", "textPaint", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "textSeparateLinePaint", "Landroid/graphics/PaintFlagsDrawFilter;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/graphics/PaintFlagsDrawFilter;", "drawFilter", "", "D", UserInfo.SEX_FEMALE, "levelTextWidth", "E", "levelExtraTextWidth", "totalTextWidth", "G", "levelTextBaseX", "H", "levelTextBaseY", "I", "viewWidth", "J", "bgWidth", "Landroid/graphics/Path;", "K", "Landroid/graphics/Path;", "bgRectPath", "Landroid/graphics/RectF;", "L", "Landroid/graphics/RectF;", "bgRectPosition", "Landroid/graphics/Bitmap;", "M", "Landroid/graphics/Bitmap;", "levelImgBitmap", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "N", "Companion", "a", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildLevelRoleViewForProfileCard extends View {

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static float P = bi.a(23.0f);
    private static float Q = bi.a(18.0f);
    private static float R = bi.a(7.0f);
    private static float S = bi.a(2.3f);
    private static float T = bi.a(4.0f);
    private static float U = bi.a(7.0f);
    private static float V = bi.a(13.0f);
    private static float W = bi.a(0.3f);

    /* renamed from: a0, reason: collision with root package name */
    private static float f235895a0 = bi.a(9.16f);

    /* renamed from: b0, reason: collision with root package name */
    private static float f235896b0 = bi.a(5.3f);

    /* renamed from: c0, reason: collision with root package name */
    private static float f235897c0;

    /* renamed from: d0, reason: collision with root package name */
    private static float f235898d0;

    /* renamed from: e0, reason: collision with root package name */
    private static float f235899e0;

    /* renamed from: f0, reason: collision with root package name */
    private static float f235900f0;

    /* renamed from: g0, reason: collision with root package name */
    private static final float f235901g0;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final PaintFlagsDrawFilter drawFilter;

    /* renamed from: D, reason: from kotlin metadata */
    private float levelTextWidth;

    /* renamed from: E, reason: from kotlin metadata */
    private float levelExtraTextWidth;

    /* renamed from: F, reason: from kotlin metadata */
    private float totalTextWidth;

    /* renamed from: G, reason: from kotlin metadata */
    private float levelTextBaseX;

    /* renamed from: H, reason: from kotlin metadata */
    private float levelTextBaseY;

    /* renamed from: I, reason: from kotlin metadata */
    private float viewWidth;

    /* renamed from: J, reason: from kotlin metadata */
    private float bgWidth;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Path bgRectPath;

    /* renamed from: L, reason: from kotlin metadata */
    private RectF bgRectPosition;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private Bitmap levelImgBitmap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a uiData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint bgPaint;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint bgOuterStokePaint;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint bgOuterLinePaint;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint textPaint;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint textSeparateLinePaint;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0015\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ&\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0007\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0002J&\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0007\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0007R\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u0016\u0010\u000e\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0016\u0010\u000f\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\fR\u0016\u0010\u0010\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\fR\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\fR\u0016\u0010\u0014\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\fR\u0016\u0010\u0015\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\fR\u0016\u0010\u0016\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\fR\u0016\u0010\u0017\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\fR\u0016\u0010\u0018\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\fR\u0016\u0010\u0019\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\fR\u0016\u0010\u001a\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\fR\u0016\u0010\u001b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\fR\u0014\u0010\u001c\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\f\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/GuildLevelRoleViewForProfileCard$Companion;", "", "", "url", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "", "block", "a", "b", "", "BG_CORNER_RADIUS", UserInfo.SEX_FEMALE, "BG_HEIGHT", "IMG_MARGIN_LEFT", "IMG_MARGIN_TOP", "IMG_SIZE", "TAG", "Ljava/lang/String;", "TEXT_BETWEEN_MARGIN", "TEXT_MARGIN_LEFT", "TEXT_MARGIN_RIGHT", "TEXT_SEPARATE_LINE_HEIGHT", "TEXT_SEPARATE_LINE_MARGIN_LEFT", "TEXT_SEPARATE_LINE_MARGIN_RIGHT", "TEXT_SEPARATE_LINE_WIDTH", "TEXT_SIZE", "VIEW_HEIGHT", "VIEW_MIN_WIDTH", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class Companion {

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/widget/GuildLevelRoleViewForProfileCard$Companion$a", "Lcom/tencent/mobileqq/guild/widget/GuildLevelRoleView$a;", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "a", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes14.dex */
        public static final class a implements GuildLevelRoleView.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Function1<Bitmap, Unit> f235908a;

            /* JADX WARN: Multi-variable type inference failed */
            a(Function1<? super Bitmap, Unit> function1) {
                this.f235908a = function1;
            }

            @Override // com.tencent.mobileqq.guild.widget.GuildLevelRoleView.a
            public void a(@Nullable Bitmap bitmap) {
                this.f235908a.invoke(bitmap);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void a(String url, Function1<? super Bitmap, Unit> block) {
            ((IQQGuildAvatarApi) ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).runtimeService(IQQGuildAvatarApi.class)).loadCommonPic(url, (int) GuildLevelRoleViewForProfileCard.Q, (int) GuildLevelRoleViewForProfileCard.Q, new a(block));
        }

        @JvmStatic
        @SuppressLint({"UseCompatLoadingForDrawables"})
        public final void b(@NotNull final String url, @NotNull final Function1<? super Bitmap, Unit> block) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(block, "block");
            a(url, new Function1<Bitmap, Unit>() { // from class: com.tencent.mobileqq.guild.widget.GuildLevelRoleViewForProfileCard$Companion$fetchLevelImg$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap) {
                    invoke2(bitmap);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Bitmap bitmap) {
                    GuildLevelRoleViewForProfileCard.Companion companion = GuildLevelRoleViewForProfileCard.INSTANCE;
                    Function1<Bitmap, Unit> function1 = block;
                    String str = url;
                    if (bitmap == null) {
                        Logger logger = Logger.f235387a;
                        Logger.b bVar = new Logger.b();
                        String str2 = "fetchLevelImg loadIconUrl failed: " + str;
                        if (str2 instanceof String) {
                            bVar.a().add(str2);
                        }
                        Iterator<T> it = bVar.a().iterator();
                        while (it.hasNext()) {
                            Logger.f235387a.d().e("GuildLevelRoleViewForProfileCard", 1, (String) it.next(), null);
                        }
                        function1.invoke(null);
                        return;
                    }
                    function1.invoke(bitmap);
                }
            });
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0004\u0012\u0006\u0010\u001e\u001a\u00020\u0004\u0012\u0006\u0010\u001f\u001a\u00020\u0004\u0012\u0006\u0010 \u001a\u00020\u0004\u0012\u0006\u0010\"\u001a\u00020\u0004\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012R\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012R\u0017\u0010\u001c\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0014\u0010\u001bR\u0017\u0010\u001e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001a\u001a\u0004\b\n\u0010\u001bR\u0017\u0010\u001f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u001a\u001a\u0004\b\u001d\u0010\u001bR\u0017\u0010 \u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u0019\u0010\u001bR\u0017\u0010\"\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u001a\u001a\u0004\b\u000f\u0010\u001b\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/GuildLevelRoleViewForProfileCard$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/graphics/Bitmap;", "a", "Landroid/graphics/Bitmap;", tl.h.F, "()Landroid/graphics/Bitmap;", "levelImg", "b", "Ljava/lang/String;", "getLevelIconUrl", "()Ljava/lang/String;", "levelIconUrl", "c", "d", "levelDesc", "g", "levelExtraNameDesc", "e", "I", "()I", "bgStartColor", "f", "bgEndColor", "levelDescTextColor", "levelDescSplitLineColor", "i", "bgOutlineColor", "<init>", "(Landroid/graphics/Bitmap;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIII)V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final /* data */ class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Bitmap levelImg;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String levelIconUrl;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String levelDesc;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String levelExtraNameDesc;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int bgStartColor;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final int bgEndColor;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private final int levelDescTextColor;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private final int levelDescSplitLineColor;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private final int bgOutlineColor;

        public a(@NotNull Bitmap levelImg, @NotNull String levelIconUrl, @NotNull String levelDesc, @NotNull String levelExtraNameDesc, int i3, int i16, int i17, int i18, int i19) {
            Intrinsics.checkNotNullParameter(levelImg, "levelImg");
            Intrinsics.checkNotNullParameter(levelIconUrl, "levelIconUrl");
            Intrinsics.checkNotNullParameter(levelDesc, "levelDesc");
            Intrinsics.checkNotNullParameter(levelExtraNameDesc, "levelExtraNameDesc");
            this.levelImg = levelImg;
            this.levelIconUrl = levelIconUrl;
            this.levelDesc = levelDesc;
            this.levelExtraNameDesc = levelExtraNameDesc;
            this.bgStartColor = i3;
            this.bgEndColor = i16;
            this.levelDescTextColor = i17;
            this.levelDescSplitLineColor = i18;
            this.bgOutlineColor = i19;
        }

        /* renamed from: a, reason: from getter */
        public final int getBgEndColor() {
            return this.bgEndColor;
        }

        /* renamed from: b, reason: from getter */
        public final int getBgOutlineColor() {
            return this.bgOutlineColor;
        }

        /* renamed from: c, reason: from getter */
        public final int getBgStartColor() {
            return this.bgStartColor;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final String getLevelDesc() {
            return this.levelDesc;
        }

        /* renamed from: e, reason: from getter */
        public final int getLevelDescSplitLineColor() {
            return this.levelDescSplitLineColor;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof a)) {
                return false;
            }
            a aVar = (a) other;
            if (Intrinsics.areEqual(this.levelImg, aVar.levelImg) && Intrinsics.areEqual(this.levelIconUrl, aVar.levelIconUrl) && Intrinsics.areEqual(this.levelDesc, aVar.levelDesc) && Intrinsics.areEqual(this.levelExtraNameDesc, aVar.levelExtraNameDesc) && this.bgStartColor == aVar.bgStartColor && this.bgEndColor == aVar.bgEndColor && this.levelDescTextColor == aVar.levelDescTextColor && this.levelDescSplitLineColor == aVar.levelDescSplitLineColor && this.bgOutlineColor == aVar.bgOutlineColor) {
                return true;
            }
            return false;
        }

        /* renamed from: f, reason: from getter */
        public final int getLevelDescTextColor() {
            return this.levelDescTextColor;
        }

        @NotNull
        /* renamed from: g, reason: from getter */
        public final String getLevelExtraNameDesc() {
            return this.levelExtraNameDesc;
        }

        @NotNull
        /* renamed from: h, reason: from getter */
        public final Bitmap getLevelImg() {
            return this.levelImg;
        }

        public int hashCode() {
            return (((((((((((((((this.levelImg.hashCode() * 31) + this.levelIconUrl.hashCode()) * 31) + this.levelDesc.hashCode()) * 31) + this.levelExtraNameDesc.hashCode()) * 31) + this.bgStartColor) * 31) + this.bgEndColor) * 31) + this.levelDescTextColor) * 31) + this.levelDescSplitLineColor) * 31) + this.bgOutlineColor;
        }

        @NotNull
        public String toString() {
            return "levelIconUrl " + this.levelIconUrl + ",levelDesc " + this.levelDesc + ", levelExtraNameDesc " + cq.w(this.levelExtraNameDesc, 2);
        }
    }

    static {
        float a16 = bi.a(5.4f);
        f235897c0 = a16;
        f235898d0 = W + f235896b0 + a16;
        f235899e0 = bi.a(23.0f);
        f235900f0 = bi.a(3.0f);
        f235901g0 = R + Q + T + U;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildLevelRoleViewForProfileCard(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void q(final Canvas canvas) {
        w(canvas, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.widget.GuildLevelRoleViewForProfileCard$drawBg$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Path path;
                Path path2;
                RectF rectF;
                float f16;
                float f17;
                Path path3;
                Path path4;
                Paint paint;
                canvas.translate(0.0f, 0.0f);
                path = this.bgRectPath;
                path.reset();
                path2 = this.bgRectPath;
                rectF = this.bgRectPosition;
                if (rectF == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bgRectPosition");
                    rectF = null;
                }
                f16 = GuildLevelRoleViewForProfileCard.f235900f0;
                f17 = GuildLevelRoleViewForProfileCard.f235900f0;
                path2.addRoundRect(rectF, f16, f17, Path.Direction.CCW);
                Canvas canvas2 = canvas;
                path3 = this.bgRectPath;
                canvas2.clipPath(path3);
                Canvas canvas3 = canvas;
                path4 = this.bgRectPath;
                paint = this.bgPaint;
                canvas3.drawPath(path4, paint);
            }
        });
    }

    private final void r(Canvas canvas) {
        Bitmap bitmap = this.levelImgBitmap;
        boolean z16 = false;
        if (bitmap != null && bitmap.isRecycled()) {
            z16 = true;
        }
        if (z16) {
            return;
        }
        Bitmap bitmap2 = this.levelImgBitmap;
        Intrinsics.checkNotNull(bitmap2);
        canvas.drawBitmap(bitmap2, R, S, (Paint) null);
    }

    private final void s(final Canvas canvas) {
        w(canvas, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.widget.GuildLevelRoleViewForProfileCard$drawLevelText$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                float f16;
                float f17;
                GuildLevelRoleViewForProfileCard.a aVar;
                Paint paint;
                GuildLevelRoleViewForProfileCard.a aVar2;
                float f18;
                float f19;
                Paint paint2;
                Canvas canvas2 = canvas;
                f16 = this.levelTextBaseX;
                f17 = this.levelTextBaseY;
                canvas2.translate(f16, f17);
                Canvas canvas3 = canvas;
                aVar = this.uiData;
                Intrinsics.checkNotNull(aVar);
                String levelDesc = aVar.getLevelDesc();
                paint = this.textPaint;
                canvas3.drawText(levelDesc, 0.0f, 0.0f, paint);
                Canvas canvas4 = canvas;
                aVar2 = this.uiData;
                Intrinsics.checkNotNull(aVar2);
                String levelExtraNameDesc = aVar2.getLevelExtraNameDesc();
                f18 = this.levelTextWidth;
                f19 = GuildLevelRoleViewForProfileCard.f235898d0;
                float f26 = f18 + f19;
                paint2 = this.textPaint;
                canvas4.drawText(levelExtraNameDesc, f26, 0.0f, paint2);
            }
        });
    }

    private final void t(final Canvas canvas) {
        w(canvas, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.widget.GuildLevelRoleViewForProfileCard$drawLevelTextSeparateLine$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                float f16;
                float f17;
                float f18;
                float f19;
                Paint paint;
                GuildLevelRoleViewForProfileCard.a aVar;
                float f26;
                float f27;
                Paint paint2;
                f16 = GuildLevelRoleViewForProfileCard.this.levelTextBaseX;
                f17 = GuildLevelRoleViewForProfileCard.this.levelTextWidth;
                float f28 = f16 + f17;
                f18 = GuildLevelRoleViewForProfileCard.f235896b0;
                float f29 = f28 + f18;
                float f36 = GuildLevelRoleViewForProfileCard.P;
                f19 = GuildLevelRoleViewForProfileCard.f235895a0;
                float f37 = (f36 - f19) / 2;
                paint = GuildLevelRoleViewForProfileCard.this.textSeparateLinePaint;
                aVar = GuildLevelRoleViewForProfileCard.this.uiData;
                Intrinsics.checkNotNull(aVar);
                paint.setColor(aVar.getLevelDescSplitLineColor());
                Canvas canvas2 = canvas;
                f26 = GuildLevelRoleViewForProfileCard.W;
                float f38 = f29 + f26;
                f27 = GuildLevelRoleViewForProfileCard.f235895a0;
                paint2 = GuildLevelRoleViewForProfileCard.this.textSeparateLinePaint;
                canvas2.drawRect(f29, f37, f38, f37 + f27, paint2);
            }
        });
    }

    @JvmStatic
    @SuppressLint({"UseCompatLoadingForDrawables"})
    public static final void u(@NotNull String str, @NotNull Function1<? super Bitmap, Unit> function1) {
        INSTANCE.b(str, function1);
    }

    private final void v() {
        String levelExtraNameDesc;
        boolean z16;
        Paint paint = this.textPaint;
        a aVar = this.uiData;
        Intrinsics.checkNotNull(aVar);
        this.levelTextWidth = paint.measureText(aVar.getLevelDesc());
        Paint paint2 = this.textPaint;
        a aVar2 = this.uiData;
        Intrinsics.checkNotNull(aVar2);
        this.levelExtraTextWidth = paint2.measureText(aVar2.getLevelExtraNameDesc());
        this.totalTextWidth = this.levelTextWidth;
        a aVar3 = this.uiData;
        boolean z17 = false;
        if (aVar3 != null && (levelExtraNameDesc = aVar3.getLevelExtraNameDesc()) != null) {
            if (levelExtraNameDesc.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                z17 = true;
            }
        }
        if (z17) {
            this.totalTextWidth += this.levelExtraTextWidth + f235898d0;
        }
        float f16 = f235901g0;
        float f17 = this.totalTextWidth;
        this.viewWidth = f16 + f17;
        this.bgWidth = R + Q + T + U + f17;
        this.bgRectPosition = new RectF(0.0f, 0.0f, this.bgWidth, f235899e0);
        a aVar4 = this.uiData;
        Intrinsics.checkNotNull(aVar4);
        this.levelImgBitmap = aVar4.getLevelImg();
        this.levelTextBaseX = (this.viewWidth - U) - this.totalTextWidth;
        Paint.FontMetrics fontMetrics = this.textPaint.getFontMetrics();
        float f18 = 2;
        this.levelTextBaseY = ((P / f18) - (fontMetrics.ascent / f18)) - (fontMetrics.descent / f18);
    }

    private final void w(Canvas canvas, Function0<Unit> function) {
        canvas.save();
        function.invoke();
        canvas.restore();
    }

    private final void x() {
        Paint paint = this.bgOuterStokePaint;
        a aVar = this.uiData;
        Intrinsics.checkNotNull(aVar);
        paint.setColor(aVar.getBgOutlineColor());
        Paint paint2 = this.textPaint;
        a aVar2 = this.uiData;
        Intrinsics.checkNotNull(aVar2);
        paint2.setColor(aVar2.getLevelDescTextColor());
        Paint paint3 = this.textSeparateLinePaint;
        a aVar3 = this.uiData;
        Intrinsics.checkNotNull(aVar3);
        paint3.setColor(aVar3.getLevelDescSplitLineColor());
        Paint paint4 = this.bgPaint;
        float f16 = this.viewWidth;
        float f17 = f235899e0;
        a aVar4 = this.uiData;
        Intrinsics.checkNotNull(aVar4);
        int bgStartColor = aVar4.getBgStartColor();
        a aVar5 = this.uiData;
        Intrinsics.checkNotNull(aVar5);
        paint4.setShader(new LinearGradient(0.0f, 0.0f, f16, f17, bgStartColor, aVar5.getBgEndColor(), Shader.TileMode.CLAMP));
    }

    @Override // android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        boolean z16;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (this.uiData == null) {
            return;
        }
        canvas.setDrawFilter(this.drawFilter);
        q(canvas);
        s(canvas);
        a aVar = this.uiData;
        Intrinsics.checkNotNull(aVar);
        if (aVar.getLevelExtraNameDesc().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            t(canvas);
        }
        r(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int mode = View.MeasureSpec.getMode(heightMeasureSpec);
        int size = View.MeasureSpec.getSize(heightMeasureSpec);
        float f16 = P;
        int i3 = (int) f16;
        if (mode != 1073741824 || size < f16) {
            size = i3;
        }
        Logger logger = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            Logger.a d16 = logger.d();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onMeasure heightMode:");
            sb5.append(mode);
            sb5.append(" VIEW_HEIGHT: ");
            sb5.append(P);
            sb5.append(" , height: ");
            sb5.append(size);
            sb5.append(" ,h: ");
            sb5.append(getMeasuredHeight());
            sb5.append(" ,pH:");
            Object parent = getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
            sb5.append(((View) parent).getMeasuredHeight());
            d16.d("GuildLevelRoleViewForProfileCard", 1, sb5.toString());
        }
        setMeasuredDimension((int) this.viewWidth, size);
    }

    public final void y(@NotNull a uiData) {
        Intrinsics.checkNotNullParameter(uiData, "uiData");
        Logger.f235387a.d().d("GuildLevelRoleViewForProfileCard", 1, "updateUIData: " + uiData);
        this.uiData = uiData;
        setVisibility(0);
        x();
        v();
        requestLayout();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildLevelRoleViewForProfileCard(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildLevelRoleViewForProfileCard(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildLevelRoleViewForProfileCard(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Paint paint = new Paint(1);
        this.bgPaint = paint;
        Paint paint2 = new Paint(1);
        this.bgOuterStokePaint = paint2;
        Paint paint3 = new Paint(1);
        this.bgOuterLinePaint = paint3;
        Paint paint4 = new Paint(1);
        this.textPaint = paint4;
        Paint paint5 = new Paint(1);
        this.textSeparateLinePaint = paint5;
        this.drawFilter = new PaintFlagsDrawFilter(0, 3);
        this.viewWidth = f235901g0;
        this.bgRectPath = new Path();
        paint.setStyle(Paint.Style.FILL);
        paint2.setStyle(Paint.Style.FILL);
        paint3.setStyle(Paint.Style.STROKE);
        paint4.setStyle(Paint.Style.FILL);
        paint4.setFakeBoldText(true);
        paint4.setTextSize(V);
        paint5.setStyle(Paint.Style.FILL);
    }
}
