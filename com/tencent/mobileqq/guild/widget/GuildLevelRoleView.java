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
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.guild.widget.GuildLevelRoleView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
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

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 @2\u00020\u0001:\u0003ABCB'\b\u0007\u0012\u0006\u0010:\u001a\u000209\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010;\u0012\b\b\u0002\u0010=\u001a\u00020\u0010\u00a2\u0006\u0004\b>\u0010?J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001e\u0010\f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0002J\u000e\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rJ\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0014J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0014R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0019R\u0014\u0010 \u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0019R\u0014\u0010#\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010&R\u0016\u0010+\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010&R\u0016\u0010,\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010&R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107\u00a8\u0006D"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/GuildLevelRoleView;", "Landroid/view/View;", "", "p", "r", "Landroid/graphics/Canvas;", PM.CANVAS, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "o", "Lkotlin/Function0;", "function", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/guild/widget/GuildLevelRoleView$b;", "uiData", ReportConstant.COSTREPORT_PREFIX, "", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "onDraw", "d", "Lcom/tencent/mobileqq/guild/widget/GuildLevelRoleView$b;", "Landroid/graphics/Paint;", "e", "Landroid/graphics/Paint;", "bgPaint", "f", "bgOuterStokePaint", tl.h.F, "bgOuterLinePaint", "i", "textPaint", "Landroid/graphics/PaintFlagsDrawFilter;", "Landroid/graphics/PaintFlagsDrawFilter;", "drawFilter", "", BdhLogUtil.LogTag.Tag_Conn, UserInfo.SEX_FEMALE, "levelTextWidth", "D", "levelTextBaseX", "E", "levelTextBaseY", "viewWidth", "Landroid/graphics/Path;", "G", "Landroid/graphics/Path;", "bgRectPath", "Landroid/graphics/RectF;", "H", "Landroid/graphics/RectF;", "bgRectPosition", "Landroid/graphics/Bitmap;", "I", "Landroid/graphics/Bitmap;", "levelImgBitmap", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "J", "Companion", "a", "b", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildLevelRoleView extends View {

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static float K = bi.a(13.0f);
    private static float L = bi.a(11.0f);
    private static float M = bi.a(4.0f);
    private static float N = bi.a(1.0f);
    private static float P = bi.a(1.0f);
    private static float Q = bi.a(4.0f);
    private static float R = bi.a(9.0f);
    private static float S = bi.a(13.0f);
    private static float T = bi.a(2.0f);
    private static final float U = ((M + L) + P) + Q;
    private static final IQQGuildAvatarApi V = (IQQGuildAvatarApi) ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).runtimeService(IQQGuildAvatarApi.class);

    /* renamed from: C, reason: from kotlin metadata */
    private float levelTextWidth;

    /* renamed from: D, reason: from kotlin metadata */
    private float levelTextBaseX;

    /* renamed from: E, reason: from kotlin metadata */
    private float levelTextBaseY;

    /* renamed from: F, reason: from kotlin metadata */
    private float viewWidth;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Path bgRectPath;

    /* renamed from: H, reason: from kotlin metadata */
    private RectF bgRectPosition;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private Bitmap levelImgBitmap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private UIData uiData;

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
    private final PaintFlagsDrawFilter drawFilter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J&\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0014\u0010\u000e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\r0\fH\u0003J&\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0014\u0010\u000e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\r0\fH\u0002J,\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r0\fH\u0007R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0015R\u0016\u0010\u001e\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0015R\u0016\u0010\u001f\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0015R\u0016\u0010 \u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u0015R\u0014\u0010!\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010\u0015R\u0016\u0010$\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\u0015R\u0016\u0010%\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010\u0015R\u0014\u0010&\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010\u0015R\u001c\u0010)\u001a\n (*\u0004\u0018\u00010'0'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/GuildLevelRoleView$Companion;", "", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildRoleInfo;", "roleInfo", "", tl.h.F, "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Lcom/tencent/mobileqq/guild/widget/GuildLevelRoleView$b;", "e", "", "url", "Lkotlin/Function1;", "", "block", "d", "c", "from", "b", "", "VIEW_HEIGHT", UserInfo.SEX_FEMALE, "g", "()F", "setVIEW_HEIGHT", "(F)V", "IMG_SIZE", "f", "setIMG_SIZE", "BG_CORNER_RADIUS", "BG_HEIGHT", "IMG_MARGIN_LEFT", "IMG_MARGIN_TOP", "TAG", "Ljava/lang/String;", "TEXT_MARGIN_LEFT", "TEXT_MARGIN_RIGHT", "TEXT_SIZE", "VIEW_MIN_WIDTH", "Lcom/tencent/mobileqq/guild/api/IQQGuildAvatarApi;", "kotlin.jvm.PlatformType", "avatarApi", "Lcom/tencent/mobileqq/guild/api/IQQGuildAvatarApi;", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/widget/GuildLevelRoleView$Companion$a", "Lcom/tencent/mobileqq/guild/widget/GuildLevelRoleView$a;", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "a", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes14.dex */
        public static final class a implements a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Function1<Bitmap, Unit> f235885a;

            /* JADX WARN: Multi-variable type inference failed */
            a(Function1<? super Bitmap, Unit> function1) {
                this.f235885a = function1;
            }

            @Override // com.tencent.mobileqq.guild.widget.GuildLevelRoleView.a
            public void a(@Nullable Bitmap bitmap) {
                this.f235885a.invoke(bitmap);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void c(String url, Function1<? super Bitmap, Unit> block) {
            GuildLevelRoleView.V.loadCommonPic(url, (int) f(), (int) f(), new a(block));
        }

        @SuppressLint({"UseCompatLoadingForDrawables"})
        private final void d(final String url, final Function1<? super Bitmap, Unit> block) {
            c(url, new Function1<Bitmap, Unit>() { // from class: com.tencent.mobileqq.guild.widget.GuildLevelRoleView$Companion$fetchLevelImg$1
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
                    if (bitmap == null) {
                        Logger logger = Logger.f235387a;
                        String str = url;
                        Logger.b bVar = new Logger.b();
                        String str2 = "fetchLevelImg loadIconUrl failed: " + str;
                        if (str2 instanceof String) {
                            bVar.a().add(str2);
                        }
                        Iterator<T> it = bVar.a().iterator();
                        while (it.hasNext()) {
                            Logger.f235387a.d().e("GuildLevelRoleView", 1, (String) it.next(), null);
                        }
                        block.invoke(null);
                        return;
                    }
                    block.invoke(bitmap);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final UIData e(Bitmap bitmap, IGProGuildRoleInfo roleInfo) {
            String levelIconUrl = roleInfo.getLevelIconUrl();
            Intrinsics.checkNotNullExpressionValue(levelIconUrl, "roleInfo.levelIconUrl");
            String levelSimpleDsc = roleInfo.getLevelSimpleDsc();
            Intrinsics.checkNotNullExpressionValue(levelSimpleDsc, "roleInfo.levelSimpleDsc");
            String name = roleInfo.getName();
            Intrinsics.checkNotNullExpressionValue(name, "roleInfo.name");
            return new UIData(bitmap, levelIconUrl, levelSimpleDsc, name, roleInfo.getBackgroudColor1(), roleInfo.getBackgroudColor2(), roleInfo.getLevelSimpleDscColor(), roleInfo.getLevelSplitLineColor(), roleInfo.getOutlineColor());
        }

        private final boolean h(IGProGuildRoleInfo roleInfo) {
            boolean z16;
            boolean z17;
            boolean z18;
            boolean z19;
            String levelIconUrl = roleInfo.getLevelIconUrl();
            Intrinsics.checkNotNullExpressionValue(levelIconUrl, "roleInfo.levelIconUrl");
            boolean z26 = true;
            if (levelIconUrl.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            String levelSimpleDsc = roleInfo.getLevelSimpleDsc();
            Intrinsics.checkNotNullExpressionValue(levelSimpleDsc, "roleInfo.levelSimpleDsc");
            if (levelSimpleDsc.length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            boolean z27 = z16 & z17;
            if (roleInfo.getBackgroudColor1() != 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            boolean z28 = z27 & z18;
            if (roleInfo.getBackgroudColor2() != 0) {
                z19 = true;
            } else {
                z19 = false;
            }
            boolean z29 = z28 & z19;
            if (roleInfo.getLevelSimpleDscColor() == 0) {
                z26 = false;
            }
            return z29 & z26;
        }

        @JvmStatic
        public final void b(@NotNull final IGProGuildRoleInfo roleInfo, @NotNull String from, @NotNull final Function1<? super UIData, Unit> block) {
            Intrinsics.checkNotNullParameter(roleInfo, "roleInfo");
            Intrinsics.checkNotNullParameter(from, "from");
            Intrinsics.checkNotNullParameter(block, "block");
            if (!h(roleInfo)) {
                Logger.f235387a.d().d("GuildLevelRoleView", 1, "convertGuildRoleInfoToUIData roleInfo is Invalid from: " + from + " , roleInfo: " + roleInfo);
                return;
            }
            String levelIconUrl = roleInfo.getLevelIconUrl();
            Intrinsics.checkNotNullExpressionValue(levelIconUrl, "roleInfo.levelIconUrl");
            d(levelIconUrl, new Function1<Bitmap, Unit>() { // from class: com.tencent.mobileqq.guild.widget.GuildLevelRoleView$Companion$convertGuildRoleInfoToUIData$2
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
                    GuildLevelRoleView.UIData e16;
                    if (bitmap != null) {
                        e16 = GuildLevelRoleView.INSTANCE.e(bitmap, IGProGuildRoleInfo.this);
                        block.invoke(e16);
                        return;
                    }
                    Logger logger = Logger.f235387a;
                    IGProGuildRoleInfo iGProGuildRoleInfo = IGProGuildRoleInfo.this;
                    Logger.b bVar = new Logger.b();
                    String str = "convertGuildRoleInfoToUIData loadIconUrl failed: " + iGProGuildRoleInfo.getLevelIconUrl();
                    if (str instanceof String) {
                        bVar.a().add(str);
                    }
                    Iterator<T> it = bVar.a().iterator();
                    while (it.hasNext()) {
                        Logger.f235387a.d().e("GuildLevelRoleView", 1, (String) it.next(), null);
                    }
                }
            });
        }

        public final float f() {
            return GuildLevelRoleView.L;
        }

        public final float g() {
            return GuildLevelRoleView.K;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/GuildLevelRoleView$a;", "", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "a", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public interface a {
        void a(@Nullable Bitmap bitmap);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0004\u0012\u0006\u0010\u001d\u001a\u00020\u0004\u0012\u0006\u0010\u001e\u001a\u00020\u0004\u0012\u0006\u0010!\u001a\u00020\u0004\u0012\u0006\u0010#\u001a\u00020\u0004\u00a2\u0006\u0004\b$\u0010%J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012R\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012R\u0017\u0010\u001c\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0014\u0010\u001bR\u0017\u0010\u001d\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u001a\u001a\u0004\b\n\u0010\u001bR\u0017\u0010\u001e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u0019\u0010\u001bR\u0017\u0010!\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010\u001bR\u0017\u0010#\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u001a\u001a\u0004\b\u000f\u0010\u001b\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/GuildLevelRoleView$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/graphics/Bitmap;", "a", "Landroid/graphics/Bitmap;", "g", "()Landroid/graphics/Bitmap;", "levelImg", "b", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "levelIconUrl", "c", "d", "levelDesc", "getLevelExtraNameDesc", "levelExtraNameDesc", "e", "I", "()I", "bgStartColor", "bgEndColor", "levelDescTextColor", tl.h.F, "getLevelDescSplitLineColor", "levelDescSplitLineColor", "i", "bgOutlineColor", "<init>", "(Landroid/graphics/Bitmap;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIII)V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.widget.GuildLevelRoleView$b, reason: from toString */
    /* loaded from: classes14.dex */
    public static final /* data */ class UIData {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final Bitmap levelImg;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String levelIconUrl;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String levelDesc;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String levelExtraNameDesc;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final int bgStartColor;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final int bgEndColor;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        private final int levelDescTextColor;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        private final int levelDescSplitLineColor;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
        private final int bgOutlineColor;

        public UIData(@NotNull Bitmap levelImg, @NotNull String levelIconUrl, @NotNull String levelDesc, @NotNull String levelExtraNameDesc, int i3, int i16, int i17, int i18, int i19) {
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
        public final int getLevelDescTextColor() {
            return this.levelDescTextColor;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UIData)) {
                return false;
            }
            UIData uIData = (UIData) other;
            if (Intrinsics.areEqual(this.levelImg, uIData.levelImg) && Intrinsics.areEqual(this.levelIconUrl, uIData.levelIconUrl) && Intrinsics.areEqual(this.levelDesc, uIData.levelDesc) && Intrinsics.areEqual(this.levelExtraNameDesc, uIData.levelExtraNameDesc) && this.bgStartColor == uIData.bgStartColor && this.bgEndColor == uIData.bgEndColor && this.levelDescTextColor == uIData.levelDescTextColor && this.levelDescSplitLineColor == uIData.levelDescSplitLineColor && this.bgOutlineColor == uIData.bgOutlineColor) {
                return true;
            }
            return false;
        }

        @NotNull
        /* renamed from: f, reason: from getter */
        public final String getLevelIconUrl() {
            return this.levelIconUrl;
        }

        @NotNull
        /* renamed from: g, reason: from getter */
        public final Bitmap getLevelImg() {
            return this.levelImg;
        }

        public int hashCode() {
            return (((((((((((((((this.levelImg.hashCode() * 31) + this.levelIconUrl.hashCode()) * 31) + this.levelDesc.hashCode()) * 31) + this.levelExtraNameDesc.hashCode()) * 31) + this.bgStartColor) * 31) + this.bgEndColor) * 31) + this.levelDescTextColor) * 31) + this.levelDescSplitLineColor) * 31) + this.bgOutlineColor;
        }

        @NotNull
        public String toString() {
            return "UIData(levelImg=" + this.levelImg + ", levelIconUrl=" + this.levelIconUrl + ", levelDesc=" + this.levelDesc + ", levelExtraNameDesc=" + this.levelExtraNameDesc + ", bgStartColor=" + this.bgStartColor + ", bgEndColor=" + this.bgEndColor + ", levelDescTextColor=" + this.levelDescTextColor + ", levelDescSplitLineColor=" + this.levelDescSplitLineColor + ", bgOutlineColor=" + this.bgOutlineColor + ')';
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildLevelRoleView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @JvmStatic
    public static final void l(@NotNull IGProGuildRoleInfo iGProGuildRoleInfo, @NotNull String str, @NotNull Function1<? super UIData, Unit> function1) {
        INSTANCE.b(iGProGuildRoleInfo, str, function1);
    }

    private final void m(final Canvas canvas) {
        q(canvas, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.widget.GuildLevelRoleView$drawBg$1
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
                f16 = GuildLevelRoleView.T;
                f17 = GuildLevelRoleView.T;
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

    private final void n(Canvas canvas) {
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
        canvas.drawBitmap(bitmap2, M, N, (Paint) null);
    }

    private final void o(final Canvas canvas) {
        q(canvas, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.widget.GuildLevelRoleView$drawLevelText$1
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
                GuildLevelRoleView.UIData uIData;
                Paint paint;
                Canvas canvas2 = canvas;
                f16 = this.levelTextBaseX;
                f17 = this.levelTextBaseY;
                canvas2.translate(f16, f17);
                Canvas canvas3 = canvas;
                uIData = this.uiData;
                Intrinsics.checkNotNull(uIData);
                String levelDesc = uIData.getLevelDesc();
                paint = this.textPaint;
                canvas3.drawText(levelDesc, 0.0f, 0.0f, paint);
            }
        });
    }

    private final void p() {
        Paint paint = this.textPaint;
        UIData uIData = this.uiData;
        Intrinsics.checkNotNull(uIData);
        float measureText = paint.measureText(uIData.getLevelDesc());
        this.levelTextWidth = measureText;
        this.viewWidth = U + measureText;
        this.bgRectPosition = new RectF(0.0f, 0.0f, M + L + P + Q + this.levelTextWidth, S);
        UIData uIData2 = this.uiData;
        Intrinsics.checkNotNull(uIData2);
        this.levelImgBitmap = uIData2.getLevelImg();
    }

    private final void q(Canvas canvas, Function0<Unit> function) {
        canvas.save();
        function.invoke();
        canvas.restore();
    }

    private final void r() {
        Paint paint = this.bgOuterStokePaint;
        UIData uIData = this.uiData;
        Intrinsics.checkNotNull(uIData);
        paint.setColor(uIData.getBgOutlineColor());
        Paint paint2 = this.textPaint;
        UIData uIData2 = this.uiData;
        Intrinsics.checkNotNull(uIData2);
        paint2.setColor(uIData2.getLevelDescTextColor());
        this.levelTextBaseX = ((this.viewWidth - Q) - this.levelTextWidth) + P;
        Paint.FontMetrics fontMetrics = this.textPaint.getFontMetrics();
        float f16 = 2;
        this.levelTextBaseY = ((K / f16) - (fontMetrics.ascent / f16)) - (fontMetrics.descent / f16);
        Paint paint3 = this.bgPaint;
        float f17 = this.viewWidth;
        float f18 = S;
        UIData uIData3 = this.uiData;
        Intrinsics.checkNotNull(uIData3);
        int bgStartColor = uIData3.getBgStartColor();
        UIData uIData4 = this.uiData;
        Intrinsics.checkNotNull(uIData4);
        paint3.setShader(new LinearGradient(0.0f, 0.0f, f17, f18, bgStartColor, uIData4.getBgEndColor(), Shader.TileMode.CLAMP));
    }

    @Override // android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (this.uiData == null) {
            return;
        }
        canvas.setDrawFilter(this.drawFilter);
        m(canvas);
        o(canvas);
        n(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int mode = View.MeasureSpec.getMode(heightMeasureSpec);
        int size = View.MeasureSpec.getSize(heightMeasureSpec);
        float f16 = K;
        int i3 = (int) f16;
        if (mode != 1073741824 || size < f16) {
            size = i3;
        }
        setMeasuredDimension((int) this.viewWidth, size);
    }

    public final void s(@NotNull UIData uiData) {
        Intrinsics.checkNotNullParameter(uiData, "uiData");
        this.uiData = uiData;
        setVisibility(0);
        p();
        r();
        requestLayout();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildLevelRoleView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildLevelRoleView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildLevelRoleView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
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
        this.drawFilter = new PaintFlagsDrawFilter(0, 3);
        this.viewWidth = U;
        this.bgRectPath = new Path();
        paint.setStyle(Paint.Style.FILL);
        paint2.setStyle(Paint.Style.FILL);
        paint3.setStyle(Paint.Style.STROKE);
        paint4.setStyle(Paint.Style.FILL);
        paint4.setFakeBoldText(true);
        paint4.setTextSize(R);
    }
}
