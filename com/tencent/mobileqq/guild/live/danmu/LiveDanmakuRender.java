package com.tencent.mobileqq.guild.live.danmu;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.BoringLayout;
import android.text.Html;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.guild.aio.component.combinestyle.ae;
import com.tencent.guild.aio.util.ui.UIUtil;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.msg.IGuildMsgElementApi;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.api.IGuildMediaChannelApi;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqnt.kernel.nativeinterface.FaceElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0093\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b*\u00011\u0018\u0000 E2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\bC\u0010DJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\"\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u001a\u0010\u001f\u001a\u00020\u001e2\u0010\u0010\u001d\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u001cH\u0016J\u0012\u0010!\u001a\u00020 2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002H\u0016J6\u0010'\u001a\u00020\u00062\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020$H\u0016R\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00100\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0017\u0010:\u001a\u0002058\u0006\u00a2\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u0017\u0010=\u001a\u0002058\u0006\u00a2\u0006\f\n\u0004\b;\u00107\u001a\u0004\b<\u00109R\u001c\u0010B\u001a\n ?*\u0004\u0018\u00010>0>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010A\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/guild/live/danmu/LiveDanmakuRender;", "Lcom/tencent/common/danmaku/render/a;", "Liq1/e;", "Landroid/graphics/Canvas;", PM.CANVAS, "liveDanmuku", "", "k", "Lcom/tencent/mobileqq/guild/live/danmu/item/b;", "giftDanmuItem", "Landroid/graphics/drawable/Drawable;", "drawable", "j", "Lcom/tencent/mobileqq/guild/live/danmu/item/a;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Landroid/text/TextPaint;", "textPaint", "Landroid/text/Layout;", "l", "", DomainData.DOMAIN_NAME, "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "Landroid/text/SpannableStringBuilder;", "o", "", "originalStr", "p", "Lcom/tencent/common/danmaku/data/a;", "p0", "", "a", "Lcom/tencent/common/danmaku/util/a;", "r", "Lcom/tencent/common/danmaku/inject/b;", "danmakuContext", "", "dx", "dy", ReportConstant.COSTREPORT_PREFIX, "b", "Landroid/text/TextPaint;", "Landroid/text/BoringLayout$Metrics;", "c", "Landroid/text/BoringLayout$Metrics;", "boringMetrics", "d", "Landroid/graphics/drawable/Drawable;", "selfDanmakuBgDrawable", "com/tencent/mobileqq/guild/live/danmu/LiveDanmakuRender$cache$1", "e", "Lcom/tencent/mobileqq/guild/live/danmu/LiveDanmakuRender$cache$1;", "cache", "", "f", "I", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()I", "right", "g", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "bottom", "Lcom/tencent/image/URLDrawable$URLDrawableOptions;", "kotlin.jvm.PlatformType", h.F, "Lcom/tencent/image/URLDrawable$URLDrawableOptions;", "options", "<init>", "()V", "i", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class LiveDanmakuRender extends com.tencent.common.danmaku.render.a<iq1.e> {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextPaint textPaint;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final BoringLayout.Metrics boringMetrics;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Drawable selfDanmakuBgDrawable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveDanmakuRender$cache$1 cache;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int right;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final int bottom;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final URLDrawable.URLDrawableOptions options;

    public LiveDanmakuRender() {
        TextPaint textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setDither(true);
        this.textPaint = textPaint;
        this.boringMetrics = new BoringLayout.Metrics();
        Drawable drawable = HardCodeUtil.sContex.getDrawable(R.drawable.guild_live_self_danmaku_bg);
        Intrinsics.checkNotNull(drawable);
        this.selfDanmakuBgDrawable = drawable;
        this.cache = new LiveDanmakuRender$cache$1();
        int f16 = ae.f();
        this.right = f16;
        int e16 = ae.e();
        this.bottom = e16;
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable2 = null;
        Drawable drawable3 = ResourcesCompat.getDrawable(UIUtil.f112434a.x(), R.color.ajr, null);
        if (drawable3 != null) {
            drawable3.setBounds(0, 0, f16, e16);
            drawable2 = drawable3;
        }
        obtain.mLoadingDrawable = drawable2;
        obtain.mRequestHeight = ae.e();
        obtain.mRequestWidth = ae.f();
        obtain.mFailedDrawable = obtain.mLoadingDrawable;
        this.options = obtain;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(com.tencent.mobileqq.guild.live.danmu.item.b giftDanmuItem, Drawable drawable, Canvas canvas) {
        View view = LayoutInflater.from(BaseApplication.getContext()).inflate(R.layout.ewt, (ViewGroup) null, false);
        ((TextView) view.findViewById(R.id.vqc)).setText(giftDanmuItem.a());
        ((ImageView) view.findViewById(R.id.vpf)).setImageDrawable(drawable);
        if (giftDanmuItem.n() > 1) {
            ((TextView) view.findViewById(R.id.vpj)).setText(" x" + giftDanmuItem.n());
        }
        Intrinsics.checkNotNullExpressionValue(view, "view");
        canvas.drawBitmap(vq1.b.b(view), 0.0f, 0.0f, (Paint) null);
    }

    private final void k(Canvas canvas, iq1.e liveDanmuku) {
        com.tencent.mobileqq.guild.live.danmu.item.a content = liveDanmuku.l().getContent();
        Intrinsics.checkNotNull(content, "null cannot be cast to non-null type com.tencent.mobileqq.guild.live.danmu.item.GuildLiveGiftDanmuItem");
        com.tencent.mobileqq.guild.live.danmu.item.b bVar = (com.tencent.mobileqq.guild.live.danmu.item.b) content;
        GLiveChannelCore.f226698a.i().a(bVar.l(), new b(bVar, canvas));
    }

    private final Layout l(com.tencent.mobileqq.guild.live.danmu.item.a item, TextPaint textPaint) {
        int roundToInt;
        Layout layout = (Layout) this.cache.get((Object) Long.valueOf(item.g().getMsgId()));
        if (layout != null) {
            return layout;
        }
        CharSequence n3 = n(item);
        QLog.d("QGL.LiveDanmakuRender", 4, "generateTextLayout: " + ((Object) n3));
        float desiredWidth = Layout.getDesiredWidth(n3, textPaint);
        BoringLayout.Metrics metrics = this.boringMetrics;
        roundToInt = MathKt__MathJVMKt.roundToInt(desiredWidth);
        metrics.width = roundToInt;
        this.boringMetrics.leading = textPaint.getFontMetricsInt().leading;
        this.boringMetrics.top = textPaint.getFontMetricsInt().top;
        this.boringMetrics.ascent = textPaint.getFontMetricsInt().ascent;
        this.boringMetrics.descent = textPaint.getFontMetricsInt().descent;
        this.boringMetrics.bottom = textPaint.getFontMetricsInt().bottom;
        BoringLayout boringLayout = BoringLayout.make(n3, textPaint, ((int) desiredWidth) + 1, Layout.Alignment.ALIGN_NORMAL, 0.0f, 0.0f, this.boringMetrics, false);
        LiveDanmakuRender$cache$1 liveDanmakuRender$cache$1 = this.cache;
        Long valueOf = Long.valueOf(item.g().getMsgId());
        Intrinsics.checkNotNullExpressionValue(boringLayout, "boringLayout");
        liveDanmakuRender$cache$1.put(valueOf, boringLayout);
        return boringLayout;
    }

    private final CharSequence n(com.tencent.mobileqq.guild.live.danmu.item.a item) {
        int b16 = item.b();
        if (b16 != 1) {
            if (b16 != 2) {
                if (b16 != 3) {
                    if (b16 != 4) {
                        return "";
                    }
                    String a16 = item.a();
                    Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.tencent.mobileqq.guild.live.danmu.item.GuildLiveGiftDanmuItem");
                    return a16 + ((com.tencent.mobileqq.guild.live.danmu.item.b) item).n();
                }
                return p(item.a());
            }
            return o(item.g());
        }
        return item.a();
    }

    private final SpannableStringBuilder o(GuildMsgItem msgItem) {
        String replace$default;
        List filterNotNull;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayList arrayList = new ArrayList();
        ArrayList<MsgElement> elements = msgItem.getMsgRecord().elements;
        if (elements != null) {
            Intrinsics.checkNotNullExpressionValue(elements, "elements");
            filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(elements);
            if (filterNotNull != null) {
                Iterator it = filterNotNull.iterator();
                while (it.hasNext()) {
                    arrayList.add((MsgElement) it.next());
                }
            }
        }
        if (arrayList.isEmpty()) {
            return spannableStringBuilder;
        }
        QRouteApi api = QRoute.api(IGuildMsgElementApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IGuildMsgElementApi::class.java)");
        IGuildMsgElementApi iGuildMsgElementApi = (IGuildMsgElementApi) api;
        Iterator it5 = arrayList.iterator();
        while (true) {
            if (!it5.hasNext()) {
                break;
            }
            MsgElement element = (MsgElement) it5.next();
            int i3 = element.elementType;
            if (i3 == 6) {
                com.tencent.guild.aio.msglist.text.util.d dVar = com.tencent.guild.aio.msglist.text.util.d.f111941a;
                FaceElement faceElement = element.faceElement;
                Intrinsics.checkNotNullExpressionValue(faceElement, "element.faceElement");
                CharSequence c16 = dVar.c(faceElement, 14, false, false);
                if (spannableStringBuilder.toString().length() + c16.length() < 30) {
                    spannableStringBuilder.append(c16);
                } else {
                    spannableStringBuilder.append((CharSequence) MiniBoxNoticeInfo.APPNAME_SUFFIX);
                    break;
                }
            } else if (i3 == 1) {
                Intrinsics.checkNotNullExpressionValue(element, "element");
                replace$default = StringsKt__StringsJVMKt.replace$default(iGuildMsgElementApi.getElementContent(element), "\n", "", false, 4, (Object) null);
                if (replace$default.length() + spannableStringBuilder.toString().length() > 30) {
                    int length = 30 - spannableStringBuilder.toString().length();
                    if (length > 0) {
                        spannableStringBuilder.append((CharSequence) new QQText(vq1.b.a(replace$default, length), 3, 14));
                    } else {
                        spannableStringBuilder.append((CharSequence) MiniBoxNoticeInfo.APPNAME_SUFFIX);
                        break;
                    }
                } else {
                    spannableStringBuilder.append((CharSequence) new QQText(replace$default, 3, 14));
                }
            } else {
                continue;
            }
        }
        return spannableStringBuilder;
    }

    private final CharSequence p(String originalStr) {
        Spanned fromHtml = Html.fromHtml(originalStr);
        Intrinsics.checkNotNullExpressionValue(fromHtml, "fromHtml(originalStr)");
        return fromHtml;
    }

    @Override // com.tencent.common.danmaku.render.a
    public boolean a(@Nullable com.tencent.common.danmaku.data.a<?, ?> p06) {
        return p06 instanceof iq1.e;
    }

    /* renamed from: m, reason: from getter */
    public final int getBottom() {
        return this.bottom;
    }

    /* renamed from: q, reason: from getter */
    public final int getRight() {
        return this.right;
    }

    @Override // com.tencent.common.danmaku.render.a
    @NotNull
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public com.tencent.common.danmaku.util.a e(@Nullable iq1.e p06) {
        if (p06 == null) {
            return new com.tencent.common.danmaku.util.a(0.0f, 0.0f);
        }
        this.textPaint.setTextSize(Utils.o(14.0f, BaseApplication.getContext().getResources()));
        Layout l3 = l(p06.l().getContent(), this.textPaint);
        float width = l3.getWidth();
        if (p06.A0()) {
            width += vq1.b.d(18);
        }
        if (p06.l().getContent().b() == 4) {
            width += vq1.b.d(34);
        }
        float height = l3.getHeight();
        if (p06.A0()) {
            height += vq1.b.d(4);
        }
        float ceil = (float) Math.ceil(width);
        float ceil2 = (float) Math.ceil(height);
        p06.h0(ceil);
        p06.g0(ceil2);
        return new com.tencent.common.danmaku.util.a(ceil, ceil2);
    }

    @Override // com.tencent.common.danmaku.render.a
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void f(@Nullable Canvas canvas, @Nullable iq1.e liveDanmuku, @Nullable com.tencent.common.danmaku.inject.b danmakuContext, float dx5, float dy5) {
        if (canvas != null && liveDanmuku != null) {
            this.textPaint.setTextSize(Utils.o(14.0f, BaseApplication.getContext().getResources()));
            if (liveDanmuku.A0()) {
                this.selfDanmakuBgDrawable.setBounds(vq1.b.c(3), vq1.b.c(3), (int) (liveDanmuku.y() - vq1.b.d(3)), (int) (liveDanmuku.x() - vq1.b.d(3)));
                this.selfDanmakuBgDrawable.draw(canvas);
            }
            this.textPaint.setStyle(Paint.Style.FILL);
            this.textPaint.setColor(-1);
            canvas.save();
            if (liveDanmuku.A0()) {
                canvas.translate(dx5 + vq1.b.d(9), dy5 + vq1.b.d(2));
            } else {
                canvas.translate(dx5, dy5);
            }
            if (liveDanmuku.l().getContent().b() == 4) {
                k(canvas, liveDanmuku);
            } else {
                l(liveDanmuku.l().getContent(), this.textPaint).draw(canvas);
            }
            canvas.restore();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/live/danmu/LiveDanmakuRender$b", "Lcom/tencent/mobileqq/guild/gift/module/d;", "", "success", "", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "", "pngFilePath", "apngFilePath", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements com.tencent.mobileqq.guild.gift.module.d {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.guild.live.danmu.item.b f226460b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Canvas f226461c;

        b(com.tencent.mobileqq.guild.live.danmu.item.b bVar, Canvas canvas) {
            this.f226460b = bVar;
            this.f226461c = canvas;
        }

        @Override // com.tencent.mobileqq.guild.gift.module.d
        public void a(boolean success, int materialId, @Nullable String pngFilePath, @Nullable String apngFilePath) {
            Drawable drawable;
            if (success && !TextUtils.isEmpty(pngFilePath)) {
                drawable = URLDrawable.getFileDrawable(pngFilePath, LiveDanmakuRender.this.options);
                LiveDanmakuRender liveDanmakuRender = LiveDanmakuRender.this;
                drawable.setBounds(0, 0, liveDanmakuRender.getRight(), liveDanmakuRender.getBottom());
            } else {
                drawable = ResourcesCompat.getDrawable(UIUtil.f112434a.x(), ((IGuildMediaChannelApi) QRoute.api(IGuildMediaChannelApi.class)).getDefaultGiftDrawableResId(), null);
            }
            if (drawable instanceof URLDrawable) {
                URLDrawable uRLDrawable = (URLDrawable) drawable;
                if (uRLDrawable.getStatus() != 1) {
                    uRLDrawable.setURLDrawableListener(new a(LiveDanmakuRender.this, this.f226460b, this.f226461c));
                    uRLDrawable.startDownload();
                    return;
                }
            }
            LiveDanmakuRender.this.j(this.f226460b, drawable, this.f226461c);
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/guild/live/danmu/LiveDanmakuRender$b$a", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "drawable", "", "onLoadSuccessed", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "onLoadFialed", "onLoadCanceled", "", "progress", "onLoadProgressed", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes14.dex */
        public static final class a implements URLDrawable.URLDrawableListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ LiveDanmakuRender f226462d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ com.tencent.mobileqq.guild.live.danmu.item.b f226463e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ Canvas f226464f;

            a(LiveDanmakuRender liveDanmakuRender, com.tencent.mobileqq.guild.live.danmu.item.b bVar, Canvas canvas) {
                this.f226462d = liveDanmakuRender;
                this.f226463e = bVar;
                this.f226464f = canvas;
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadSuccessed(@NotNull URLDrawable drawable) {
                Intrinsics.checkNotNullParameter(drawable, "drawable");
                this.f226462d.j(this.f226463e, drawable, this.f226464f);
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadCanceled(@Nullable URLDrawable drawable) {
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadFialed(@Nullable URLDrawable drawable, @Nullable Throwable cause) {
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadProgressed(@Nullable URLDrawable drawable, int progress) {
            }
        }
    }
}
