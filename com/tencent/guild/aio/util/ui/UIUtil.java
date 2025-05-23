package com.tencent.guild.aio.util.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableKt;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.common.config.AppSetting;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.guild.aio.msglist.checkbox.GuildMultiMsgManager;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.emoji.IGuildEmojiApi;
import com.tencent.guild.api.richmediabrowser.IGuildRichMediaBrowserApi;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.media.pic.api.IGuildPicAIO;
import com.tencent.mobileqq.guild.media.video.IGuildVideoAIO;
import com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener;
import com.tencent.mobileqq.guild.util.IQQGuildUIUtilApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.qqnt.kernel.nativeinterface.RichDownLoadReq;
import com.tencent.qqnt.msg.MsgExtKt;
import java.util.Arrays;
import java.util.List;
import jr0.GuildImageOptions;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00be\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bv\u0010wJ,\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0007J\u0018\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0007J}\u0010\"\u001a\u00020 2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142M\u0010!\u001aI\u0012\u0013\u0012\u00110\u0018\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0015\u0012\u0013\u0018\u00010\u001c\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u001e\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020 0\u0017J}\u0010#\u001a\u00020 2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142M\u0010!\u001aI\u0012\u0013\u0012\u00110\u0018\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0015\u0012\u0013\u0018\u00010\u001c\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u001e\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020 0\u0017J0\u0010'\u001a\u00020 2\u0006\u0010$\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010%J\u001e\u0010)\u001a\u00020(2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014J\u000e\u0010*\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J2\u0010/\u001a\u0004\u0018\u00010.2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010-\u001a\u00020\u0004J\u0016\u00102\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u0004J0\u0010:\u001a\u0002062\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u00020\u00042\u0006\u00107\u001a\u0002062\u0006\u00108\u001a\u0002062\b\b\u0002\u00109\u001a\u000206J\u000e\u0010<\u001a\u00020 2\u0006\u00104\u001a\u00020;J\u0016\u0010@\u001a\u00020 2\u0006\u0010>\u001a\u00020=2\u0006\u0010?\u001a\u00020\u0004J\u0016\u0010B\u001a\u00020A2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014J\u000e\u0010E\u001a\u00020\u00142\u0006\u0010D\u001a\u00020CJ\u0014\u0010H\u001a\u00020\u00142\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00010FJ\u0006\u0010I\u001a\u00020\u0014R\u0017\u0010N\u001a\u00020J8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010K\u001a\u0004\bL\u0010MR\u0017\u0010R\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b#\u0010O\u001a\u0004\bP\u0010QR\u0017\u0010U\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\bS\u0010O\u001a\u0004\bT\u0010QR\u0017\u0010W\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010O\u001a\u0004\bV\u0010QR\u0017\u0010Y\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010O\u001a\u0004\bX\u0010QR\u0017\u0010[\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b/\u0010O\u001a\u0004\bZ\u0010QR\u0017\u0010]\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b)\u0010O\u001a\u0004\b\\\u0010QR\u0017\u0010a\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b<\u0010^\u001a\u0004\b_\u0010`R\u0017\u0010c\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b2\u0010^\u001a\u0004\bb\u0010`R\u0017\u0010f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\bd\u0010^\u001a\u0004\be\u0010`R\u0017\u0010h\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\bZ\u0010^\u001a\u0004\bg\u0010`R\u0017\u0010j\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\bB\u0010^\u001a\u0004\bi\u0010`R\u0017\u0010l\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\bV\u0010O\u001a\u0004\bk\u0010QR\u001b\u0010q\u001a\u00020m8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bn\u0010o\u001a\u0004\bd\u0010pR\u001b\u0010s\u001a\u00020m8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b:\u0010o\u001a\u0004\br\u0010pR\u0015\u0010u\u001a\u00020\b*\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\bn\u0010t\u00a8\u0006x"}, d2 = {"Lcom/tencent/guild/aio/util/ui/UIUtil;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElement", "", "targetWidth", "targetHeight", "Lkotlin/Pair;", "", "e", "f", "thumbWidth", "thumbHigh", "Landroid/graphics/drawable/Drawable;", "t", "u", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "Lcom/tencent/guild/aio/util/ui/RoundBubbleImageView;", "ivPic", "", "isInBubble", "isMultiSelectMode", "Lkotlin/Function3;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "Lkotlin/ParameterName;", "name", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/PicElement;", "picElement", "Landroid/view/View;", "clickedView", "", "listener", "b", "c", "imageView", "", "rickMediaMsgList", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/RelativeLayout$LayoutParams;", h.F, "r", "downType", "thumbSize", "triggerType", "Lcom/tencent/qqnt/kernel/nativeinterface/RichDownLoadReq;", "g", "bubbleWidth", "bubbleHeight", "j", "Landroid/widget/TextView;", "input", NodeProps.MAX_WIDTH, "", "hintBaseStr", "hintFormatStr", "ellipsis", "p", "Landroid/widget/EditText;", "i", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "color", "B", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/aio/api/runtime/a;", "context", "y", "", "payloads", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/content/res/Resources;", "Landroid/content/res/Resources;", HippyTKDListViewAdapter.X, "()Landroid/content/res/Resources;", DKConfiguration.Directory.RESOURCES, "I", "getDEFAULT_SIZE_FOR_HEAD", "()I", "DEFAULT_SIZE_FOR_HEAD", "d", "getDEFAULT_MARGIN_LEFT", "DEFAULT_MARGIN_LEFT", DomainData.DOMAIN_NAME, "DEFAULT_MARGIN_RIGHT", "getNICKLAYOUT_LEFT_MARGIN", "NICKLAYOUT_LEFT_MARGIN", "l", "CONTENTVIEW_MAX_WIDTH_SIZE", "w", "MSG_CHECKBOX_SIZE", UserInfo.SEX_FEMALE, "getAIO_IMAGE_MAX_SIZE_W", "()F", "AIO_IMAGE_MAX_SIZE_W", "getAIO_IMAGE_MAX_SIZE_H", "AIO_IMAGE_MAX_SIZE_H", "k", "getAIO_IMAGE_MIN_SIZE_W", "AIO_IMAGE_MIN_SIZE_W", "getAIO_IMAGE_MIN_SIZE_H", "AIO_IMAGE_MIN_SIZE_H", "getAIO_BUBBLE_CONTENT_PADDING", "AIO_BUBBLE_CONTENT_PADDING", "v", "MIX_OUTMOST_PIC_TOP_MARGIN", "Landroid/graphics/Bitmap;", "o", "Lkotlin/Lazy;", "()Landroid/graphics/Bitmap;", "bgBitmap", ReportConstant.COSTREPORT_PREFIX, "imgFailBitmap", "(F)F", "dp", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class UIUtil {

    /* renamed from: a */
    @NotNull
    public static final UIUtil f112434a;

    /* renamed from: b, reason: from kotlin metadata */
    @NotNull
    private static final Resources com.tencent.ams.dsdk.core.DKConfiguration.Directory.RESOURCES java.lang.String;

    /* renamed from: c, reason: from kotlin metadata */
    private static final int DEFAULT_SIZE_FOR_HEAD;

    /* renamed from: d, reason: from kotlin metadata */
    private static final int DEFAULT_MARGIN_LEFT;

    /* renamed from: e, reason: from kotlin metadata */
    private static final int DEFAULT_MARGIN_RIGHT;

    /* renamed from: f, reason: from kotlin metadata */
    private static final int NICKLAYOUT_LEFT_MARGIN;

    /* renamed from: g, reason: from kotlin metadata */
    private static final int CONTENTVIEW_MAX_WIDTH_SIZE;

    /* renamed from: h */
    private static final int MSG_CHECKBOX_SIZE;

    /* renamed from: i */
    private static final float AIO_IMAGE_MAX_SIZE_W;

    /* renamed from: j */
    private static final float AIO_IMAGE_MAX_SIZE_H;

    /* renamed from: k */
    private static final float AIO_IMAGE_MIN_SIZE_W;

    /* renamed from: l */
    private static final float AIO_IMAGE_MIN_SIZE_H;

    /* renamed from: m */
    private static final float AIO_BUBBLE_CONTENT_PADDING;

    /* renamed from: n */
    private static final int MIX_OUTMOST_PIC_TOP_MARGIN;

    /* renamed from: o, reason: from kotlin metadata */
    @NotNull
    private static final Lazy bgBitmap;

    /* renamed from: p, reason: from kotlin metadata */
    @NotNull
    private static final Lazy imgFailBitmap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/guild/aio/util/ui/UIUtil$a", "Lcom/tencent/mobileqq/guild/picload/listener/GuildPicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "c", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a extends GuildPicStateListener {
        a() {
            super(true);
        }

        @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
        public void c(@NotNull LoadState state, @NotNull Option option) {
            Animatable animatable;
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(option, "option");
            if (state.isFinishSuccess() && (animatable = option.getAnimatable()) != null) {
                animatable.start();
            }
        }
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        UIUtil uIUtil = new UIUtil();
        f112434a = uIUtil;
        Resources resources = BaseApplication.context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        com.tencent.ams.dsdk.core.DKConfiguration.Directory.RESOURCES java.lang.String = resources;
        DEFAULT_SIZE_FOR_HEAD = resources.getDimensionPixelSize(R.dimen.f158959cc4);
        DEFAULT_MARGIN_LEFT = resources.getDimensionPixelSize(R.dimen.chb);
        DEFAULT_MARGIN_RIGHT = resources.getDimensionPixelSize(R.dimen.cco);
        NICKLAYOUT_LEFT_MARGIN = resources.getDimensionPixelSize(R.dimen.cwr);
        int f16 = uIUtil.f();
        CONTENTVIEW_MAX_WIDTH_SIZE = f16;
        MSG_CHECKBOX_SIZE = resources.getDimensionPixelSize(R.dimen.chh);
        AIO_IMAGE_MAX_SIZE_W = f16;
        AIO_IMAGE_MAX_SIZE_H = f16 * 1.52f;
        AIO_IMAGE_MIN_SIZE_W = f16 * 0.3f;
        AIO_IMAGE_MIN_SIZE_H = f16 * 0.3f;
        AIO_BUBBLE_CONTENT_PADDING = resources.getDimensionPixelSize(R.dimen.f158700mp);
        MIX_OUTMOST_PIC_TOP_MARGIN = resources.getDimensionPixelSize(R.dimen.ch9);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Bitmap>() { // from class: com.tencent.guild.aio.util.ui.UIUtil$bgBitmap$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Bitmap invoke() {
                Drawable drawable = ContextCompat.getDrawable(BaseApplication.context, R.drawable.guild_img_loading);
                Intrinsics.checkNotNull(drawable);
                return DrawableKt.toBitmap$default(drawable, 0, 0, null, 7, null);
            }
        });
        bgBitmap = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Bitmap>() { // from class: com.tencent.guild.aio.util.ui.UIUtil$imgFailBitmap$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Bitmap invoke() {
                Drawable drawable = ContextCompat.getDrawable(BaseApplication.context, R.drawable.guild_img_fail);
                Intrinsics.checkNotNull(drawable);
                return DrawableKt.toBitmap$default(drawable, 0, 0, null, 7, null);
            }
        });
        imgFailBitmap = lazy2;
    }

    UIUtil() {
    }

    public static final void d(Function3 listener, GuildMsgItem msgItem, MsgElement msgElement, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        Intrinsics.checkNotNullParameter(msgElement, "$msgElement");
        QLog.i("UIUtil", 4, "ImageView Click");
        MsgRecord msgRecord = msgItem.getMsgRecord();
        PicElement picElement = msgElement.picElement;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        listener.invoke(msgRecord, picElement, it);
        EventCollector.getInstance().onViewClicked(it);
    }

    private final Pair<Float, Float> e(MsgElement msgElement, int targetWidth, int targetHeight) {
        c cVar = c.f112458a;
        PicElement picElement = msgElement.picElement;
        Intrinsics.checkNotNullExpressionValue(picElement, "msgElement.picElement");
        return cVar.a(picElement, targetWidth, targetHeight);
    }

    private final int f() {
        float f16;
        BaseApplication baseApplication = BaseApplication.context;
        if (AppSetting.t(baseApplication) && PadUtil.a(baseApplication) == DeviceType.FOLD) {
            f16 = ((IQQGuildUIUtilApi) QRoute.api(IQQGuildUIUtilApi.class)).getSplitRatioOfFunction();
        } else {
            f16 = 1.0f;
        }
        return (((((int) (f16 * ViewUtils.getScreenWidth())) - DEFAULT_MARGIN_LEFT) - DEFAULT_MARGIN_RIGHT) - NICKLAYOUT_LEFT_MARGIN) - DEFAULT_SIZE_FOR_HEAD;
    }

    private final Bitmap k() {
        return (Bitmap) bgBitmap.getValue();
    }

    public static /* synthetic */ String q(UIUtil uIUtil, TextView textView, int i3, String str, String str2, String str3, int i16, Object obj) {
        if ((i16 & 16) != 0) {
            str3 = com.tencent.ams.dsdk.core.DKConfiguration.Directory.RESOURCES java.lang.String.getString(R.string.f143450m4);
            Intrinsics.checkNotNullExpressionValue(str3, "resources.getString(R.string.guild_ellipsis_end)");
        }
        return uIUtil.p(textView, i3, str, str2, str3);
    }

    private final Bitmap s() {
        return (Bitmap) imgFailBitmap.getValue();
    }

    @JvmStatic
    @NotNull
    public static final Drawable t(int thumbWidth, int thumbHigh) {
        Resources resources = BaseApplication.getContext().getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getContext().resources");
        return new com.tencent.guild.aio.util.ui.a(resources, f112434a.k(), thumbWidth, thumbHigh, BaseApplication.getContext().getResources().getColor(R.color.guild_aio_image_default_bg_color), 0.0f);
    }

    @JvmStatic
    @NotNull
    public static final Drawable u(int thumbWidth, int thumbHigh) {
        Resources resources = BaseApplication.getContext().getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getContext().resources");
        return new com.tencent.guild.aio.util.ui.a(resources, f112434a.s(), thumbWidth, thumbHigh, BaseApplication.getContext().getResources().getColor(R.color.guild_aio_image_default_bg_color), 0.0f);
    }

    public final boolean A() {
        return QQTheme.isVasTheme();
    }

    public final void B(@NotNull Activity r36, int color) {
        Intrinsics.checkNotNullParameter(r36, "activity");
        Window window = r36.getWindow();
        window.clearFlags(67108864);
        window.getDecorView().setSystemUiVisibility(1280);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(color);
        window.setNavigationBarColor(color);
    }

    public final void C(@NotNull View imageView, @NotNull MsgRecord msgRecord, @Nullable PicElement picElement, @Nullable List<MsgRecord> list) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        QLog.i("UIUtil", 4, "showPic");
        AppRuntime app = MobileQQ.sMobileQQ.peekAppRuntime();
        if (list != null && list.size() > 80) {
            list = list.subList(0, 80);
        }
        IGuildRichMediaBrowserApi iGuildRichMediaBrowserApi = (IGuildRichMediaBrowserApi) QRoute.api(IGuildRichMediaBrowserApi.class);
        Intrinsics.checkNotNullExpressionValue(app, "app");
        iGuildRichMediaBrowserApi.enterImagePreview(app, imageView.getContext(), imageView, msgRecord, picElement, false, null, list);
    }

    public final void b(@NotNull MsgElement msgElement, @NotNull GuildMsgItem msgItem, @NotNull RoundBubbleImageView ivPic, boolean isInBubble, boolean isMultiSelectMode, @NotNull Function3<? super MsgRecord, ? super PicElement, ? super View, Unit> listener) {
        Intrinsics.checkNotNullParameter(msgElement, "msgElement");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(ivPic, "ivPic");
        Intrinsics.checkNotNullParameter(listener, "listener");
        c(msgElement, msgItem, ivPic, isInBubble, isMultiSelectMode, listener);
    }

    public final void c(@NotNull final MsgElement msgElement, @NotNull final GuildMsgItem msgItem, @NotNull RoundBubbleImageView ivPic, boolean isInBubble, boolean isMultiSelectMode, @NotNull final Function3<? super MsgRecord, ? super PicElement, ? super View, Unit> listener) {
        Intrinsics.checkNotNullParameter(msgElement, "msgElement");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(ivPic, "ivPic");
        Intrinsics.checkNotNullParameter(listener, "listener");
        ivPic.setScaleType(ImageView.ScaleType.CENTER_CROP);
        UIUtil uIUtil = f112434a;
        ivPic.setLayoutParams(uIUtil.h(msgElement, isInBubble, isMultiSelectMode));
        GuildChatPicDownloader guildChatPicDownloader = GuildChatPicDownloader.f112420a;
        PicSize picSize = PicSize.PIC_DOWNLOAD_AIO;
        Option e16 = new GuildImageOptions(guildChatPicDownloader.q(msgElement, picSize), ivPic, false, ivPic.getLayoutParams().width, ivPic.getLayoutParams().height, t(ivPic.getLayoutParams().width, ivPic.getLayoutParams().height), u(ivPic.getLayoutParams().width, ivPic.getLayoutParams().height)).e();
        e16.setDecodeMode(uIUtil.r(msgElement));
        e16.setRegionScaleType(ivPic.getScaleType());
        e16.setRegionWidth(ivPic.getLayoutParams().width);
        e16.setRegionHeight(ivPic.getLayoutParams().height);
        GuildChatPicDownloader.v(guildChatPicDownloader, e16, picSize, msgElement, msgItem.getMsgRecord(), 0, new a(), 16, null);
        ivPic.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.util.ui.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UIUtil.d(Function3.this, msgItem, msgElement, view);
            }
        });
    }

    @Nullable
    public final RichDownLoadReq g(@NotNull GuildMsgItem msgItem, int downType, int thumbSize, @Nullable MsgElement msgElement, int triggerType) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (msgElement == null) {
            return null;
        }
        RichDownLoadReq richDownLoadReq = new RichDownLoadReq(downType, thumbSize, msgItem.getMsgId(), msgItem.getMsgRecord().msgRandom, msgItem.getMsgSeq(), msgItem.getMsgRecord().msgTime, msgItem.getMsgRecord().chatType, msgItem.getMsgRecord().senderUid, msgItem.getMsgRecord().peerUid, msgItem.getMsgRecord().guildId, msgElement, null);
        richDownLoadReq.triggerType = triggerType;
        return richDownLoadReq;
    }

    @NotNull
    public final RelativeLayout.LayoutParams h(@NotNull MsgElement msgElement, boolean z16, boolean z17) {
        Pair pair;
        Integer num;
        Integer num2;
        boolean z18;
        Integer num3;
        Integer num4;
        Integer num5;
        int i3;
        int i16;
        Intrinsics.checkNotNullParameter(msgElement, "msgElement");
        int i17 = 0;
        int[] iArr = null;
        Integer num6 = null;
        if (msgElement.elementType == 3) {
            String str = msgElement.fileElement.fileName;
            Intrinsics.checkNotNullExpressionValue(str, "msgElement.fileElement.fileName");
            if (2 == vp0.b.d(str)) {
                FileElement fileElement = msgElement.fileElement;
                if (fileElement != null) {
                    num5 = fileElement.picWidth;
                } else {
                    num5 = null;
                }
                if (fileElement != null) {
                    num6 = fileElement.picHeight;
                }
                if (num5 != null && num5.intValue() > 0) {
                    i3 = num5.intValue();
                } else {
                    i3 = 640;
                }
                if (num6 != null && num6.intValue() > 0) {
                    i16 = num6.intValue();
                } else {
                    i16 = 480;
                }
                int[] thumbSize = ((IGuildVideoAIO) QRoute.api(IGuildVideoAIO.class)).getThumbSize(i3, i16);
                return new RelativeLayout.LayoutParams(thumbSize[0], thumbSize[1]);
            }
            FileElement fileElement2 = msgElement.fileElement;
            if (fileElement2 != null) {
                num3 = fileElement2.picWidth;
            } else {
                num3 = null;
            }
            if (fileElement2 != null) {
                num4 = fileElement2.picHeight;
            } else {
                num4 = null;
            }
            pair = new Pair(num3, num4);
        } else {
            PicElement picElement = msgElement.picElement;
            if (picElement != null) {
                num = Integer.valueOf(picElement.picWidth);
            } else {
                num = null;
            }
            PicElement picElement2 = msgElement.picElement;
            if (picElement2 != null) {
                num2 = Integer.valueOf(picElement2.picHeight);
            } else {
                num2 = null;
            }
            pair = new Pair(num, num2);
        }
        Number number = (Integer) pair.component1();
        Number number2 = (Integer) pair.component2();
        PicElement picElement3 = msgElement.picElement;
        if (picElement3 != null) {
            z18 = MsgExtKt.x(picElement3);
        } else {
            z18 = false;
        }
        IGuildPicAIO iGuildPicAIO = (IGuildPicAIO) QRoute.api(IGuildPicAIO.class);
        if (number == null) {
            number = Float.valueOf(AIO_IMAGE_MIN_SIZE_W);
        }
        long longValue = number.longValue();
        if (number2 == null) {
            number2 = Float.valueOf(AIO_IMAGE_MIN_SIZE_H);
        }
        long longValue2 = number2.longValue();
        if (!z18) {
            iArr = m(z16, z17);
        }
        int[] thumbSize2 = iGuildPicAIO.getThumbSize(longValue, longValue2, z18, iArr);
        Intrinsics.checkNotNullExpressionValue(thumbSize2, "getThumbSize(\n          \u2026ultiSelectMode)\n        )");
        int i18 = thumbSize2[0];
        int i19 = thumbSize2[1];
        PicElement picElement4 = msgElement.picElement;
        if (picElement4 != null) {
            i17 = picElement4.picSubType;
        }
        if (MsgExtKt.v(i17)) {
            Pair<Float, Float> e16 = e(msgElement, i18, i19);
            return new RelativeLayout.LayoutParams((int) e16.component1().floatValue(), (int) e16.component2().floatValue());
        }
        return new RelativeLayout.LayoutParams(i18, i19);
    }

    public final void i(@NotNull EditText input) {
        Intrinsics.checkNotNullParameter(input, "input");
        KeyEvent keyEvent = new KeyEvent(0, 67);
        KeyEvent keyEvent2 = new KeyEvent(1, 67);
        input.onKeyDown(67, keyEvent);
        input.onKeyUp(67, keyEvent2);
    }

    public final int j(int bubbleWidth, int bubbleHeight) {
        if ((bubbleWidth * 1.0f) / bubbleHeight >= 1.7777778f) {
            return 2;
        }
        return 1;
    }

    public final int l() {
        return CONTENTVIEW_MAX_WIDTH_SIZE;
    }

    @NotNull
    public final int[] m(boolean z16, boolean z17) {
        float f16 = AIO_IMAGE_MAX_SIZE_W;
        if (z16) {
            f16 -= AIO_BUBBLE_CONTENT_PADDING;
        }
        if (z17) {
            f16 -= MSG_CHECKBOX_SIZE;
        }
        return new int[]{com.tencent.guild.aio.util.c.a((int) AIO_IMAGE_MIN_SIZE_W), com.tencent.guild.aio.util.c.a((int) AIO_IMAGE_MIN_SIZE_H), com.tencent.guild.aio.util.c.a((int) f16), com.tencent.guild.aio.util.c.a((int) AIO_IMAGE_MAX_SIZE_H)};
    }

    public final int n() {
        return DEFAULT_MARGIN_RIGHT;
    }

    public final float o(float f16) {
        return TypedValue.applyDimension(1, f16, Resources.getSystem().getDisplayMetrics());
    }

    @NotNull
    public final String p(@NotNull TextView input, int r18, @NotNull String hintBaseStr, @NotNull String hintFormatStr, @NotNull String ellipsis) {
        int i3;
        int i16;
        int i17;
        int i18;
        String hintFormatStr2 = hintFormatStr;
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(hintBaseStr, "hintBaseStr");
        Intrinsics.checkNotNullParameter(hintFormatStr2, "hintFormatStr");
        Intrinsics.checkNotNullParameter(ellipsis, "ellipsis");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(hintBaseStr, Arrays.copyOf(new Object[]{hintFormatStr2}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        float f16 = r18;
        if (input.getPaint().measureText(format) < f16) {
            return format;
        }
        float measureText = (f16 - input.getPaint().measureText(ellipsis)) - com.tencent.ams.dsdk.core.DKConfiguration.Directory.RESOURCES java.lang.String.getDimensionPixelSize(R.dimen.f158699mo);
        int length = hintFormatStr.length() - 1;
        int i19 = 0;
        while (true) {
            if (i19 <= length) {
                i16 = (i19 + length) / 2;
                TextPaint paint = input.getPaint();
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                int i26 = i16 + 1;
                String substring = hintFormatStr2.substring(0, i26);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                String format2 = String.format(hintBaseStr, Arrays.copyOf(new Object[]{substring}, 1));
                Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
                float measureText2 = paint.measureText(format2);
                if (measureText2 < measureText) {
                    i19 = i26;
                } else if (measureText2 > measureText) {
                    length = i16 - 1;
                } else {
                    i3 = -1;
                    break;
                }
            } else {
                i3 = -1;
                i16 = -1;
                break;
            }
        }
        if (i16 == i3) {
            i16 = i19;
        }
        if (i19 > length) {
            i17 = 0;
        } else {
            i17 = 1;
        }
        int i27 = i16 + i17;
        if (i27 < hintFormatStr.length()) {
            if (i27 % 2 == 0 && i27 > 0) {
                if (((IGuildEmojiApi) QRoute.api(IGuildEmojiApi.class)).getSingleEmoji(hintFormatStr2.codePointAt(i27 - 1)) < 0) {
                    i18 = 0;
                } else {
                    i18 = 1;
                }
                i27 -= i18;
            }
            String substring2 = hintFormatStr2.substring(0, i27);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            hintFormatStr2 = substring2 + ellipsis;
        }
        StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
        String format3 = String.format(hintBaseStr, Arrays.copyOf(new Object[]{hintFormatStr2}, 1));
        Intrinsics.checkNotNullExpressionValue(format3, "format(format, *args)");
        return format3;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x007a A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x007c A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int r(@NotNull MsgElement msgElement) {
        Pair pair;
        Pair pair2;
        Object component1;
        Object component2;
        float floatValue;
        float floatValue2;
        Intrinsics.checkNotNullParameter(msgElement, "msgElement");
        int i3 = msgElement.elementType;
        Integer num = null;
        if (i3 != 2) {
            if (i3 != 3) {
                pair2 = new Pair(Float.valueOf(AIO_IMAGE_MIN_SIZE_W), Float.valueOf(AIO_IMAGE_MIN_SIZE_H));
                component1 = pair2.component1();
                component2 = pair2.component2();
                if (component1 == null) {
                    component1 = Float.valueOf(AIO_IMAGE_MIN_SIZE_W);
                }
                floatValue = ((Number) component1).floatValue();
                if (component2 == null) {
                    component2 = Float.valueOf(AIO_IMAGE_MIN_SIZE_H);
                }
                floatValue2 = ((Number) component2).floatValue();
                if (Math.min(floatValue, floatValue2) * 3.0f >= Math.max(floatValue, floatValue2)) {
                    return 1;
                }
                return 0;
            }
            FileElement fileElement = msgElement.fileElement;
            if (fileElement != null) {
                num = fileElement.picWidth;
            }
            pair = new Pair(num, fileElement.picHeight);
        } else {
            PicElement picElement = msgElement.picElement;
            if (picElement != null) {
                num = Integer.valueOf(picElement.picWidth);
            }
            pair = new Pair(num, Integer.valueOf(msgElement.picElement.picHeight));
        }
        pair2 = pair;
        component1 = pair2.component1();
        component2 = pair2.component2();
        if (component1 == null) {
        }
        floatValue = ((Number) component1).floatValue();
        if (component2 == null) {
        }
        floatValue2 = ((Number) component2).floatValue();
        if (Math.min(floatValue, floatValue2) * 3.0f >= Math.max(floatValue, floatValue2)) {
        }
    }

    public final int v() {
        return MIX_OUTMOST_PIC_TOP_MARGIN;
    }

    public final int w() {
        return MSG_CHECKBOX_SIZE;
    }

    @NotNull
    public final Resources x() {
        return com.tencent.ams.dsdk.core.DKConfiguration.Directory.RESOURCES java.lang.String;
    }

    public final boolean y(@NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return GuildMultiMsgManager.INSTANCE.a().i(new GuildMultiMsgManager.d(context.g().r().c().j(), com.tencent.guild.aio.util.ex.a.d(context)));
    }

    public final boolean z(@NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (!payloads.isEmpty()) {
            for (Object obj : payloads) {
                if (obj instanceof GuildMultiMsgManager.MultiSelectMode) {
                    return ((GuildMultiMsgManager.MultiSelectMode) obj).getBMultiSelect();
                }
            }
            return false;
        }
        return false;
    }
}
