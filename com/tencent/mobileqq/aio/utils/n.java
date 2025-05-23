package com.tencent.mobileqq.aio.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.FileMsgItem;
import com.tencent.mobileqq.aio.msg.FoldMsgItem;
import com.tencent.mobileqq.aio.msg.LocationShareMsgItem;
import com.tencent.mobileqq.aio.msg.OnlineFileMsgItem;
import com.tencent.mobileqq.aio.msg.PttMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.markdown.MarkdownMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.skin.AIOBubbleSkinInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOTokenUtilsApi;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import com.tencent.qqnt.kernel.api.IUixConvertAdapterApi;
import com.tencent.qqnt.robot.api.IRobotServiceApi;
import com.tencent.theme.BaseConstantState;
import com.tencent.theme.SkinData;
import com.tencent.theme.SkinEngine;
import com.tencent.theme.SkinnableColorStateList;
import com.tencent.theme.SkinnableNinePatchDrawable;
import cooperation.qzone.QZoneClickReport;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b*\u0010+J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u001a\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\nH\u0002J\"\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0018\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\fH\u0002J\u0018\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\fH\u0002J\u0018\u0010\u001c\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0005\u001a\u00020\u0004J&\u0010 \u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u0011R\"\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\f0!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\"R\"\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010$0!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\"R \u0010(\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020$0&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010'R \u0010)\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010'\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/aio/utils/n;", "", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "Lcom/tencent/mobileqq/aio/msglist/holder/skin/AIOBubbleSkinInfo;", "g", "Landroid/graphics/drawable/Drawable;", "drawable", "Landroid/content/res/ColorStateList;", tl.h.F, "", "id", NodeProps.COLORS, "", "a", "", "isSelf", "b", "Lcom/tencent/mobileqq/aio/msglist/holder/skin/AIOBubbleSkinInfo$c;", "textInfo", "tokenId", "d", "Lcom/tencent/mobileqq/aio/msglist/holder/skin/AIOBubbleSkinInfo$BackgroundImageInfo;", "drawableInfo", "bgId", "c", "f", "Lcom/tencent/mobileqq/aio/msglist/holder/skin/padding/a;", "i", "useToken", "e", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "colorMap", "", "drawablePathMap", "", "Ljava/util/Map;", "tokenMap", "bubbleTokenMap", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class n {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final n f194168a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<Integer, Integer> colorMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<Integer, String> drawablePathMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<Integer, String> tokenMap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<Integer, Integer> bubbleTokenMap;

    static {
        Map<Integer, String> mapOf;
        Map<Integer, Integer> mapOf2;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65287);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        f194168a = new n();
        colorMap = new ConcurrentHashMap<>();
        drawablePathMap = new ConcurrentHashMap<>();
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(Integer.valueOf(R.color.qui_common_bubble_host_text_primary), "bubble_host_text_primary"), TuplesKt.to(Integer.valueOf(R.color.qui_common_bubble_guest_text_primary), "bubble_guest_text_primary"), TuplesKt.to(Integer.valueOf(R.color.qui_common_bubble_host_top), "bubble_host_top"), TuplesKt.to(Integer.valueOf(R.color.qui_common_bubble_guest), "bubble_guest"));
        tokenMap = mapOf;
        mapOf2 = MapsKt__MapsKt.mapOf(TuplesKt.to(Integer.valueOf(R.drawable.j8t), Integer.valueOf(R.color.qui_common_bubble_host_top)), TuplesKt.to(Integer.valueOf(R.drawable.j6v), Integer.valueOf(R.color.qui_common_bubble_guest)));
        bubbleTokenMap = mapOf2;
    }

    n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void a(int id5, ColorStateList colors) {
        int defaultColor;
        SkinData skinData;
        Integer num;
        if (colors != null) {
            try {
                defaultColor = colors.getDefaultColor();
            } catch (Throwable unused) {
                return;
            }
        } else {
            defaultColor = 0;
        }
        ConcurrentHashMap<Integer, Integer> concurrentHashMap = colorMap;
        if (concurrentHashMap.containsKey(Integer.valueOf(id5)) && (num = concurrentHashMap.get(Integer.valueOf(id5))) != null && num.intValue() == defaultColor) {
            return;
        }
        String str = null;
        if ((colors instanceof SkinnableColorStateList) && (skinData = ((SkinnableColorStateList) colors).skinData) != null) {
            str = skinData.mFileName;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("#%06X", Arrays.copyOf(new Object[]{Integer.valueOf(16777215 & defaultColor)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        QLog.d("BubbleUtils", 1, "checkColorAndLog: " + id5 + " -> " + format + " -> " + str);
        concurrentHashMap.put(Integer.valueOf(id5), Integer.valueOf(defaultColor));
    }

    private final void b(boolean isSelf, int id5, Drawable drawable) {
        try {
            if (!(drawable instanceof SkinnableNinePatchDrawable)) {
                return;
            }
            Drawable.ConstantState constantState = ((SkinnableNinePatchDrawable) drawable).getConstantState();
            Intrinsics.checkNotNull(constantState, "null cannot be cast to non-null type com.tencent.theme.BaseConstantState");
            SkinData skinData = ((BaseConstantState) constantState).skinData;
            ConcurrentHashMap<Integer, String> concurrentHashMap = drawablePathMap;
            if (!concurrentHashMap.containsKey(Integer.valueOf(id5)) || !Intrinsics.areEqual(concurrentHashMap.get(Integer.valueOf(id5)), skinData.mFilePath)) {
                if (com.tencent.qqnt.util.b.f362976b.isDebugVersion() || QLog.isColorLevel()) {
                    QLog.d("BubbleUtils", 1, "checkDrawableAndLog: " + isSelf + " , " + skinData);
                }
                concurrentHashMap.put(Integer.valueOf(id5), skinData.mFilePath);
            }
        } catch (Throwable unused) {
        }
    }

    private final void c(AIOBubbleSkinInfo.BackgroundImageInfo drawableInfo, int bgId) {
        int defaultColor;
        GradientDrawable gradientDrawable;
        HashMap hashMapOf;
        IAIOTokenUtilsApi iAIOTokenUtilsApi = (IAIOTokenUtilsApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOTokenUtilsApi.class);
        Integer num = bubbleTokenMap.get(Integer.valueOf(bgId));
        if (num != null) {
            int intValue = num.intValue();
            String str = tokenMap.get(Integer.valueOf(intValue));
            if (str == null) {
                return;
            }
            int realTokenColor = iAIOTokenUtilsApi.getRealTokenColor(str, intValue);
            ColorStateList h16 = f194168a.h(drawableInfo.a());
            if (h16 == null || realTokenColor == (defaultColor = h16.getDefaultColor())) {
                return;
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("#%06X", Arrays.copyOf(new Object[]{Integer.valueOf(realTokenColor & 16777215)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            String format2 = String.format("#%06X", Arrays.copyOf(new Object[]{Integer.valueOf(defaultColor & 16777215)}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
            if (QLog.isColorLevel()) {
                QLog.d("BubbleUtils", 1, intValue + " -> " + intValue + ", color error, real: " + format + ", cur: " + format2);
            }
            if (iAIOTokenUtilsApi.enableReport()) {
                hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("token", str), TuplesKt.to("id", String.valueOf(intValue)), TuplesKt.to("real", format), TuplesKt.to("cur", format2));
                iAIOTokenUtilsApi.reportToBugly(hashMapOf);
            }
            if (iAIOTokenUtilsApi.enableFix()) {
                if (QLog.isColorLevel()) {
                    QLog.d("BubbleUtils", 1, "fix " + intValue + " " + str + " color from " + format2 + " to " + format);
                }
                Drawable a16 = drawableInfo.a();
                if (a16 != null && (a16 instanceof LayerDrawable)) {
                    LayerDrawable layerDrawable = (LayerDrawable) a16;
                    if (layerDrawable.getNumberOfLayers() >= 1) {
                        Drawable drawable = layerDrawable.getDrawable(0);
                        if (drawable instanceof GradientDrawable) {
                            gradientDrawable = (GradientDrawable) drawable;
                        } else {
                            gradientDrawable = null;
                        }
                        if (gradientDrawable != null) {
                            gradientDrawable.setColor(ColorStateList.valueOf(realTokenColor));
                        }
                    }
                }
            }
        }
    }

    private final void d(AIOBubbleSkinInfo.c textInfo, int tokenId) {
        HashMap hashMapOf;
        IAIOTokenUtilsApi iAIOTokenUtilsApi = (IAIOTokenUtilsApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOTokenUtilsApi.class);
        String str = tokenMap.get(Integer.valueOf(tokenId));
        if (str != null) {
            int realTokenColor = iAIOTokenUtilsApi.getRealTokenColor(str, tokenId);
            if (textInfo.a() != null) {
                Integer a16 = textInfo.a();
                if (a16 == null || realTokenColor != a16.intValue()) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String format = String.format("#%06X", Arrays.copyOf(new Object[]{Integer.valueOf(realTokenColor & 16777215)}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                    Integer a17 = textInfo.a();
                    Intrinsics.checkNotNull(a17);
                    String format2 = String.format("#%06X", Arrays.copyOf(new Object[]{Integer.valueOf(16777215 & a17.intValue())}, 1));
                    Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
                    if (QLog.isColorLevel()) {
                        QLog.d("BubbleUtils", 1, tokenId + " -> " + str + ", color error, real: " + format + ", cur: " + format2);
                    }
                    if (iAIOTokenUtilsApi.enableReport()) {
                        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("id", str), TuplesKt.to("token", String.valueOf(tokenId)), TuplesKt.to("real", format), TuplesKt.to("cur", format2));
                        iAIOTokenUtilsApi.reportToBugly(hashMapOf);
                    }
                    if (iAIOTokenUtilsApi.enableFix()) {
                        if (QLog.isColorLevel()) {
                            QLog.d("BubbleUtils", 1, "fix " + tokenId + " " + str + " color from " + format2 + " to " + format);
                        }
                        textInfo.g(Integer.valueOf(realTokenColor));
                        textInfo.h(ColorStateList.valueOf(realTokenColor));
                    }
                }
            }
        }
    }

    private final AIOBubbleSkinInfo g(Context context, AIOMsgItem msgItem) {
        int i3;
        int i16;
        int i17;
        int i18;
        Drawable drawable;
        String valueOf;
        int i19;
        ColorStateList colorStateList;
        boolean isSelf = msgItem.isSelf();
        AIOBubbleSkinInfo.BackgroundImageInfo backgroundImageInfo = new AIOBubbleSkinInfo.BackgroundImageInfo();
        AIOBubbleSkinInfo.c cVar = new AIOBubbleSkinInfo.c();
        if (m.f194167a.c(msgItem)) {
            if (isSelf) {
                i18 = R.drawable.j8t;
            } else {
                i18 = R.drawable.j6v;
            }
            try {
                drawable = context.getResources().getDrawable(i18);
            } catch (Resources.NotFoundException e16) {
                QLog.d("MsgElementFilePathExtUtil", 1, "getDrawable with exception: " + e16);
                drawable = null;
            }
            backgroundImageInfo.b(drawable);
            AIOBubbleSkinInfo.BackgroundImageInfo.Companion companion = AIOBubbleSkinInfo.BackgroundImageInfo.INSTANCE;
            backgroundImageInfo.i(companion.c());
            backgroundImageInfo.h(companion.b());
            a(i18, h(backgroundImageInfo.a()));
            if (msgItem.getMsgRecord().peerUin > 0) {
                valueOf = String.valueOf(msgItem.getMsgRecord().peerUin);
            } else {
                IUixConvertAdapterApi iUixConvertAdapterApi = (IUixConvertAdapterApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IUixConvertAdapterApi.class);
                String str = msgItem.getMsgRecord().peerUid;
                Intrinsics.checkNotNullExpressionValue(str, "msgItem.msgRecord.peerUid");
                valueOf = String.valueOf(iUixConvertAdapterApi.getUinFromUid(str));
            }
            boolean isRobotAIO = ((IRobotServiceApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IRobotServiceApi.class)).isRobotAIO(valueOf, Integer.valueOf(msgItem.getMsgRecord().chatType));
            if (!isRobotAIO) {
                c(backgroundImageInfo, i18);
            }
            if (msgItem.isSelf()) {
                i19 = R.color.qui_common_bubble_host_text_primary;
            } else {
                i19 = R.color.qui_common_bubble_guest_text_primary;
            }
            cVar.g(Integer.valueOf(context.getResources().getColor(i19)));
            cVar.h(context.getResources().getColorStateList(i19));
            a(i19, cVar.b());
            if (!isRobotAIO) {
                d(cVar, i19);
            }
            if (isSelf) {
                if (com.tencent.mobileqq.aio.msglist.holder.component.text.util.a.f192006a.e()) {
                    colorStateList = context.getColorStateList(R.color.qui_common_bubble_host_text_link);
                } else {
                    colorStateList = context.getColorStateList(R.color.qui_common_bubble_host_text_primary);
                }
            } else {
                colorStateList = context.getColorStateList(R.color.qui_common_text_link);
            }
            cVar.j(colorStateList);
            cVar.i(0);
        } else {
            if (isSelf) {
                i3 = R.drawable.skin_aio_user_bubble_nor;
            } else {
                i3 = R.drawable.skin_aio_friend_bubble_nor;
            }
            String skinRootPath = SkinEngine.getInstances().getSkinRootPath();
            String str2 = File.separator;
            String str3 = skinRootPath + str2 + "drawable-xxhdpi" + str2 + "skin_aio_friend_bubble_nor.9.png";
            if (FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("vas_bubble_theme_load", false) && !isSelf && new File(str3).exists()) {
                if (com.tencent.qqnt.util.b.f362976b.isDebugVersion() || QLog.isColorLevel()) {
                    QLog.d("BubbleUtils", 1, "vas_bubble_theme_load theme friend bubble");
                }
                backgroundImageInfo.b(com.tencent.cachedrawable.dynamicdrawable.api.a.a().i(QZoneClickReport.ClickReportConfig.SOURCE_FROM_AIO).d(str3).a());
            } else {
                backgroundImageInfo.b(context.getResources().getDrawable(i3));
            }
            b(isSelf, i3, backgroundImageInfo.a());
            backgroundImageInfo.i(0);
            backgroundImageInfo.h(0);
            if (isSelf) {
                i16 = R.color.skin_chat_buble_mine;
            } else {
                i16 = R.color.skin_chat_buble;
            }
            cVar.g(Integer.valueOf(context.getResources().getColor(i16, context.getTheme())));
            cVar.h(context.getResources().getColorStateList(i16, context.getTheme()));
            if (isSelf) {
                i17 = R.color.skin_chat_buble_link_mine;
            } else {
                i17 = R.color.skin_chat_buble_link;
            }
            cVar.j(context.getColorStateList(i17));
            cVar.i(0);
        }
        AIOBubbleSkinInfo aIOBubbleSkinInfo = new AIOBubbleSkinInfo();
        aIOBubbleSkinInfo.h(backgroundImageInfo);
        aIOBubbleSkinInfo.l(cVar);
        aIOBubbleSkinInfo.i(i(msgItem));
        return aIOBubbleSkinInfo;
    }

    private final ColorStateList h(Drawable drawable) {
        GradientDrawable gradientDrawable;
        ColorStateList color;
        try {
            if (!(drawable instanceof LayerDrawable) || ((LayerDrawable) drawable).getNumberOfLayers() < 1) {
                return null;
            }
            Drawable drawable2 = ((LayerDrawable) drawable).getDrawable(0);
            if (drawable2 instanceof GradientDrawable) {
                gradientDrawable = (GradientDrawable) drawable2;
            } else {
                gradientDrawable = null;
            }
            if (Build.VERSION.SDK_INT < 24 || gradientDrawable == null) {
                return null;
            }
            color = gradientDrawable.getColor();
            return color;
        } catch (Throwable unused) {
            return null;
        }
    }

    @NotNull
    public final AIOBubbleSkinInfo e(@NotNull Context context, @NotNull AIOMsgItem msgItem, boolean isSelf, boolean useToken) {
        boolean z16;
        int i3;
        int i16;
        int i17;
        int i18;
        Drawable drawable;
        String valueOf;
        int i19;
        ColorStateList colorStateList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (AIOBubbleSkinInfo) iPatchRedirector.redirect((short) 4, this, context, msgItem, Boolean.valueOf(isSelf), Boolean.valueOf(useToken));
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        AIOBubbleSkinInfo.BackgroundImageInfo backgroundImageInfo = new AIOBubbleSkinInfo.BackgroundImageInfo();
        AIOBubbleSkinInfo.c cVar = new AIOBubbleSkinInfo.c();
        if (!useToken && !m.f194167a.c(msgItem)) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            if (isSelf) {
                i18 = R.drawable.j8u;
            } else {
                i18 = R.drawable.j6x;
            }
            try {
                drawable = context.getResources().getDrawable(i18);
            } catch (Resources.NotFoundException e16) {
                QLog.d("MsgElementFilePathExtUtil", 1, "getDrawable with exception: " + e16);
                drawable = null;
            }
            backgroundImageInfo.b(drawable);
            backgroundImageInfo.i(AIOBubbleSkinInfo.BackgroundImageInfo.INSTANCE.c());
            a(i18, h(backgroundImageInfo.a()));
            if (msgItem.getMsgRecord().peerUin > 0) {
                valueOf = String.valueOf(msgItem.getMsgRecord().peerUin);
            } else {
                IUixConvertAdapterApi iUixConvertAdapterApi = (IUixConvertAdapterApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IUixConvertAdapterApi.class);
                String str = msgItem.getMsgRecord().peerUid;
                Intrinsics.checkNotNullExpressionValue(str, "msgItem.msgRecord.peerUid");
                valueOf = String.valueOf(iUixConvertAdapterApi.getUinFromUid(str));
            }
            boolean isRobotAIO = ((IRobotServiceApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IRobotServiceApi.class)).isRobotAIO(valueOf, Integer.valueOf(msgItem.getMsgRecord().chatType));
            if (!isRobotAIO) {
                c(backgroundImageInfo, i18);
            }
            if (isSelf) {
                i19 = R.color.qui_common_bubble_host_text_primary;
            } else {
                i19 = R.color.qui_common_bubble_guest_text_primary;
            }
            cVar.g(Integer.valueOf(context.getResources().getColor(i19)));
            cVar.h(context.getResources().getColorStateList(i19));
            a(i19, cVar.b());
            if (!isRobotAIO) {
                d(cVar, i19);
            }
            if (isSelf) {
                if (com.tencent.mobileqq.aio.msglist.holder.component.text.util.a.f192006a.e()) {
                    colorStateList = context.getColorStateList(R.color.qui_common_bubble_host_text_link);
                } else {
                    colorStateList = context.getColorStateList(R.color.qui_common_bubble_host_text_primary);
                }
            } else {
                colorStateList = context.getColorStateList(R.color.qui_common_text_link);
            }
            cVar.j(colorStateList);
            cVar.i(0);
        } else {
            if (isSelf) {
                i3 = R.drawable.skin_aio_user_bubble_nor;
            } else {
                i3 = R.drawable.skin_aio_friend_bubble_nor;
            }
            String skinRootPath = SkinEngine.getInstances().getSkinRootPath();
            String str2 = File.separator;
            String str3 = skinRootPath + str2 + "drawable-xxhdpi" + str2 + "skin_aio_friend_bubble_nor.9.png";
            if (FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("vas_bubble_theme_load", false) && !isSelf && new File(str3).exists()) {
                if (com.tencent.qqnt.util.b.f362976b.isDebugVersion() || QLog.isColorLevel()) {
                    QLog.d("BubbleUtils", 1, "vas_bubble_theme_load theme friend bubble");
                }
                backgroundImageInfo.b(com.tencent.cachedrawable.dynamicdrawable.api.a.a().i(QZoneClickReport.ClickReportConfig.SOURCE_FROM_AIO).d(str3).a());
            } else {
                backgroundImageInfo.b(context.getResources().getDrawable(i3));
            }
            b(isSelf, i3, backgroundImageInfo.a());
            backgroundImageInfo.i(0);
            backgroundImageInfo.h(0);
            if (isSelf) {
                i16 = R.color.skin_chat_buble_mine;
            } else {
                i16 = R.color.skin_chat_buble;
            }
            cVar.g(Integer.valueOf(context.getResources().getColor(i16, context.getTheme())));
            cVar.h(context.getResources().getColorStateList(i16, context.getTheme()));
            if (isSelf) {
                i17 = R.color.skin_chat_buble_link_mine;
            } else {
                i17 = R.color.skin_chat_buble_link;
            }
            cVar.j(context.getColorStateList(i17));
            cVar.i(0);
        }
        AIOBubbleSkinInfo aIOBubbleSkinInfo = new AIOBubbleSkinInfo();
        aIOBubbleSkinInfo.h(backgroundImageInfo);
        aIOBubbleSkinInfo.l(cVar);
        aIOBubbleSkinInfo.i(f194168a.i(msgItem));
        return aIOBubbleSkinInfo;
    }

    @NotNull
    public final AIOBubbleSkinInfo f(@Nullable Context context, @NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AIOBubbleSkinInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) msgItem);
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (context instanceof Activity) {
            return g(context, msgItem);
        }
        if (context == null) {
            context = MobileQQ.sMobileQQ;
        }
        Intrinsics.checkNotNullExpressionValue(context, "context ?: MobileQQ.sMobileQQ");
        return g(context, msgItem);
    }

    @Nullable
    public final com.tencent.mobileqq.aio.msglist.holder.skin.padding.a i(@NotNull AIOMsgItem msgItem) {
        com.tencent.mobileqq.aio.msglist.holder.skin.padding.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.aio.msglist.holder.skin.padding.a) iPatchRedirector.redirect((short) 3, (Object) this, (Object) msgItem);
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (msgItem instanceof com.tencent.mobileqq.aio.msg.ae) {
            aVar = new com.tencent.mobileqq.aio.msglist.holder.skin.padding.j();
        } else if (msgItem instanceof com.tencent.mobileqq.aio.msg.u) {
            aVar = new com.tencent.mobileqq.aio.msglist.holder.skin.padding.h();
        } else if (msgItem instanceof com.tencent.mobileqq.aio.msg.o) {
            aVar = new com.tencent.mobileqq.aio.msglist.holder.skin.padding.e();
        } else if (msgItem instanceof LocationShareMsgItem) {
            aVar = new com.tencent.mobileqq.aio.msglist.holder.skin.padding.d();
        } else if (msgItem instanceof FoldMsgItem) {
            aVar = new com.tencent.mobileqq.aio.msglist.holder.skin.padding.c();
        } else if (msgItem instanceof FileMsgItem) {
            aVar = new com.tencent.mobileqq.aio.msglist.holder.skin.padding.b();
        } else if (msgItem instanceof OnlineFileMsgItem) {
            aVar = new com.tencent.mobileqq.aio.msglist.holder.skin.padding.i();
        } else if (msgItem instanceof com.tencent.mobileqq.aio.msg.aj) {
            aVar = new com.tencent.mobileqq.aio.msglist.holder.skin.padding.l();
        } else if (msgItem instanceof com.tencent.mobileqq.aio.msg.p) {
            aVar = new com.tencent.mobileqq.aio.msglist.holder.skin.padding.i();
        } else if (msgItem instanceof MarkdownMsgItem) {
            aVar = new com.tencent.mobileqq.aio.msglist.holder.component.markdown.view.a();
        } else if (msgItem instanceof com.tencent.mobileqq.aio.msg.m) {
            aVar = new com.tencent.mobileqq.aio.msglist.holder.skin.padding.j();
        } else if (msgItem instanceof PttMsgItem) {
            aVar = new com.tencent.mobileqq.aio.msglist.holder.skin.padding.g();
        } else {
            aVar = null;
        }
        if (aVar != null) {
            aVar.a(msgItem);
        }
        return aVar;
    }
}
