package com.tencent.mobileqq.vip.api.impl;

import QQService.EVIPSPEC;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.api.IVasRecentData;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.flash.VipFlashNickNameView;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.updatesystem.business.ColorNameBusiness;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vip.api.IVipColorName;
import com.tencent.mobileqq.vip.api.IVipDataUtils;
import com.tencent.mobileqq.vip.api.VipData;
import com.tencent.mobileqq.vip.api.VipInfoForBusiness;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.QUIEllipsizeTextView;
import com.tencent.widget.SingleLineTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p33.ScannerData;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 D2\u00020\u0001:\u0001EB\u0007\u00a2\u0006\u0004\bB\u0010CJ.\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\u000e\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\"\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J$\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0018\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\tH\u0002J\u0018\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0006H\u0002J\u0018\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020 H\u0002J$\u0010$\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J,\u0010$\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u001c\u0010%\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010(\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010'\u001a\u00020&H\u0016J\u001a\u0010)\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010'\u001a\u00020&H\u0016J\u001c\u0010*\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010+\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010.\u001a\u00020\u00102\u0006\u0010-\u001a\u00020,H\u0016J\u0010\u00101\u001a\u0004\u0018\u0001002\u0006\u0010/\u001a\u00020\u0002J\u001a\u00104\u001a\u0004\u0018\u0001032\u0006\u0010/\u001a\u00020\u00022\b\u00102\u001a\u0004\u0018\u000100R\u001a\u00105\u001a\u00020\t8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u001a\u00109\u001a\u00020\t8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b9\u00106\u001a\u0004\b:\u00108R\u001a\u0010;\u001a\u00020\t8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b;\u00106\u001a\u0004\b<\u00108R\u0017\u0010>\u001a\u00020=8\u0006\u00a2\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/vip/api/impl/VipColorNameImpl;", "Lcom/tencent/mobileqq/vip/api/IVipColorName;", "Landroid/view/View;", "textView", "", "uin", "", "isVip", "noise", "", "setColorNameByUin", "isFriendsVipOpen", "Lcom/tencent/mobileqq/data/Card;", IndividuationUrlHelper.UrlId.CARD_HOME, "isCardVipOpen", "itemId", "", "setGradientByColorName", "Lp33/a;", "data", "setGradientColors", "", NodeProps.COLORS, "isSingleTextColor", "view", "textColor", "setSingleTextColor", "isBold", "setTextBold", "width", "Landroid/graphics/LinearGradient;", "getLinearGradient", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Landroid/graphics/BitmapShader;", "getBitmapShader", "updateColorNameByUin", "updateColorNameByCard", "Lcom/tencent/mobileqq/vip/api/VipInfoForBusiness;", "info", "updateColorNameByVipBusinessWithoutUin", "updateColorNameByVipBusiness", "aSyncSetGradient", "clearTextColorGradient", "Landroid/content/Context;", "context", "openChangeColorNamePage", "v", "Landroid/graphics/Paint;", "getPaint", "paint", "Landroid/graphics/Rect;", "getWidth", "NONE", "I", "getNONE", "()I", "RED_NAME", "getRED_NAME", "COLOR_NAME", "getCOLOR_NAME", "Lcom/tencent/mobileqq/vas/updatesystem/business/ColorNameBusiness;", "updateSystem", "Lcom/tencent/mobileqq/vas/updatesystem/business/ColorNameBusiness;", "getUpdateSystem", "()Lcom/tencent/mobileqq/vas/updatesystem/business/ColorNameBusiness;", "<init>", "()V", "Companion", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VipColorNameImpl implements IVipColorName {
    static IPatchRedirector $redirector_;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final boolean IS_SUPPORT_BOLD;
    private final int COLOR_NAME;
    private final int NONE;
    private final int RED_NAME;

    @NotNull
    private final ColorNameBusiness updateSystem;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/vip/api/impl/VipColorNameImpl$a;", "", "", "IS_SUPPORT_BOLD", "Z", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vip.api.impl.VipColorNameImpl$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50177);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            INSTANCE = new Companion(null);
            IS_SUPPORT_BOLD = ar.INSTANCE.b("linkliang", "2024-03-12", "vas_color_name_bold_9030").isEnable(true);
        }
    }

    public VipColorNameImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.RED_NAME = 1;
        this.COLOR_NAME = 2;
        QQVasUpdateBusiness businessInstance = ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance((Class<QQVasUpdateBusiness>) ColorNameBusiness.class);
        Intrinsics.checkNotNullExpressionValue(businessInstance, "api(IVasBusinessManager:\u2026NameBusiness::class.java)");
        this.updateSystem = (ColorNameBusiness) businessInstance;
    }

    private final BitmapShader getBitmapShader(Bitmap bitmap) {
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        return new BitmapShader(bitmap, tileMode, tileMode);
    }

    private final LinearGradient getLinearGradient(int width, int[] colors) {
        return new LinearGradient(0.0f, 0.0f, width, 0.0f, colors, (float[]) null, Shader.TileMode.CLAMP);
    }

    private final boolean isCardVipOpen(Card card) {
        boolean z16 = false;
        if (card != null) {
            if (card.isVipOpen(EVIPSPEC.E_SP_QQVIP) || card.isVipOpen(EVIPSPEC.E_SP_SUPERVIP) || card.isVipOpen(EVIPSPEC.E_SP_BIGCLUB)) {
                z16 = true;
            }
            QLog.d("VipColorNameImpl", 2, "isVipOpen:" + card.uin + "," + z16);
        }
        return z16;
    }

    private final boolean isFriendsVipOpen(String uin) {
        IVasRecentData.FriendsVipData friendsVipData = ((IVasRecentData) QRoute.api(IVasRecentData.class)).getFriendsVipData(uin);
        if (friendsVipData.getGrayNameplateFlag() == 0 && friendsVipData.getVipType() > 0) {
            return true;
        }
        return false;
    }

    private final boolean isSingleTextColor(int[] colors) {
        int i3 = colors[0];
        int length = colors.length;
        int i16 = 0;
        while (i16 < length) {
            int i17 = colors[i16];
            if (i3 != i17) {
                return false;
            }
            i16++;
            i3 = i17;
        }
        return IS_SUPPORT_BOLD;
    }

    private final int setColorNameByUin(View textView, String uin, boolean isVip, boolean noise) {
        boolean z16;
        if (textView != null) {
            if (uin != null && uin.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                if (SimpleUIUtil.getSimpleUISwitch()) {
                    return this.NONE;
                }
                VipData vipDataForFriends = IVipDataUtils.INSTANCE.a().getVipDataForFriends(uin);
                int colorName = vipDataForFriends.getColorName();
                if (colorName <= 0) {
                    if (!vipDataForFriends.getUseDefaultNickColor() && colorName >= 0 && isVip) {
                        setSingleTextColor(textView, textView.getContext().getColor(R.color.qui_common_feedback_error));
                        return this.RED_NAME;
                    }
                    return this.NONE;
                }
                setGradientColors(textView, this.updateSystem.getColorNameData(colorName), noise);
                if (QLog.isDebugVersion()) {
                    VasLogReporter.INSTANCE.getVipColorName().reportLow("uin[" + uin + "] use color[" + colorName + "] in view[" + textView + "]");
                }
                return this.COLOR_NAME;
            }
        }
        return this.NONE;
    }

    static /* synthetic */ int setColorNameByUin$default(VipColorNameImpl vipColorNameImpl, View view, String str, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            z17 = true;
        }
        return vipColorNameImpl.setColorNameByUin(view, str, z16, z17);
    }

    private final void setGradientByColorName(final int itemId, final View textView, final String uin) {
        if (itemId <= 0) {
            return;
        }
        if (this.updateSystem.hasCache(itemId)) {
            setGradientColors$default(this, textView, this.updateSystem.getColorNameData(itemId), false, 4, null);
            if (QLog.isDebugVersion()) {
                VasLogReporter.INSTANCE.getVipColorName().reportLow("uin[" + uin + "] use color[" + itemId + "] in view[" + textView + "]");
                return;
            }
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vip.api.impl.p
            @Override // java.lang.Runnable
            public final void run() {
                VipColorNameImpl.setGradientByColorName$lambda$1(VipColorNameImpl.this, itemId, textView, uin);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setGradientByColorName$lambda$1(final VipColorNameImpl this$0, final int i3, final View textView, final String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(textView, "$textView");
        final p33.a colorNameData = this$0.updateSystem.getColorNameData(i3);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vip.api.impl.o
            @Override // java.lang.Runnable
            public final void run() {
                VipColorNameImpl.setGradientByColorName$lambda$1$lambda$0(VipColorNameImpl.this, textView, colorNameData, str, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setGradientByColorName$lambda$1$lambda$0(VipColorNameImpl this$0, View textView, p33.a aVar, String str, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(textView, "$textView");
        setGradientColors$default(this$0, textView, aVar, false, 4, null);
        if (QLog.isDebugVersion()) {
            VasLogReporter.INSTANCE.getVipColorName().reportLow("uin[" + str + "] use color[" + i3 + "] in view[" + textView + "]");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setGradientColors(View textView, p33.a data, boolean noise) {
        boolean z16;
        if (data != null && data.getCom.tencent.mtt.hippy.dom.node.NodeProps.COLORS java.lang.String().length >= 2) {
            Paint paint = getPaint(textView);
            if (data.getBold() && noise) {
                z16 = true;
            } else {
                z16 = false;
            }
            setTextBold(textView, z16);
            if (paint != null) {
                paint.setShader(null);
            }
            Rect width = getWidth(textView, paint);
            if (width != null) {
                if (isSingleTextColor(data.getCom.tencent.mtt.hippy.dom.node.NodeProps.COLORS java.lang.String())) {
                    setSingleTextColor(textView, data.getCom.tencent.mtt.hippy.dom.node.NodeProps.COLORS java.lang.String()[0]);
                } else if (data.getUseImageShader() && data.getShaderBitmap() != null) {
                    if (paint != null) {
                        Bitmap shaderBitmap = data.getShaderBitmap();
                        Intrinsics.checkNotNull(shaderBitmap);
                        paint.setShader(getBitmapShader(shaderBitmap));
                    }
                } else if (paint != null) {
                    paint.setShader(getLinearGradient(width.width(), data.getCom.tencent.mtt.hippy.dom.node.NodeProps.COLORS java.lang.String()));
                }
                ScannerData scannerData = data.getScannerData();
                if (scannerData != null) {
                    if (textView instanceof VipFlashNickNameView) {
                        VipFlashNickNameView vipFlashNickNameView = (VipFlashNickNameView) textView;
                        vipFlashNickNameView.b();
                        vipFlashNickNameView.a(width.width(), width.height(), scannerData.getSweepColor(), scannerData.getIsSingle(), noise ? 1 : 0);
                        return;
                    }
                    if (textView instanceof SingleLineTextView) {
                        SingleLineTextView singleLineTextView = (SingleLineTextView) textView;
                        singleLineTextView.stop();
                        singleLineTextView.startScanning(width.width(), width.height(), scannerData.getSweepColor(), Boolean.valueOf(scannerData.getIsSingle()), noise ? 1 : 0);
                    } else if (textView instanceof QUIEllipsizeTextView) {
                        QUIEllipsizeTextView qUIEllipsizeTextView = (QUIEllipsizeTextView) textView;
                        qUIEllipsizeTextView.stopScanning();
                        qUIEllipsizeTextView.startScanning(width.width(), width.height(), scannerData.getSweepColor(), scannerData.getIsSingle(), noise ? 1 : 0);
                    } else if (textView instanceof x03.a) {
                        x03.a aVar = (x03.a) textView;
                        aVar.o();
                        aVar.e(width.width(), width.height(), scannerData.getSweepColor(), scannerData.getIsSingle(), noise ? 1 : 0);
                    }
                }
            }
        }
    }

    static /* synthetic */ void setGradientColors$default(VipColorNameImpl vipColorNameImpl, View view, p33.a aVar, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = true;
        }
        vipColorNameImpl.setGradientColors(view, aVar, z16);
    }

    private final void setSingleTextColor(View view, int textColor) {
        if (view instanceof TextView) {
            ((TextView) view).setTextColor(textColor);
        } else if (view instanceof SingleLineTextView) {
            ((SingleLineTextView) view).setTextColor(textColor);
        }
    }

    private final void setTextBold(View view, boolean isBold) {
        if (!IS_SUPPORT_BOLD) {
            return;
        }
        Typeface defaultFromStyle = Typeface.defaultFromStyle(isBold ? 1 : 0);
        if (view instanceof SingleLineTextView) {
            ((SingleLineTextView) view).setTypeface(defaultFromStyle);
        } else if (view instanceof TextView) {
            ((TextView) view).setTypeface(defaultFromStyle);
        }
    }

    @Override // com.tencent.mobileqq.vip.api.IVipColorName
    public void aSyncSetGradient(@Nullable View textView, @Nullable String uin) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) textView, (Object) uin);
            return;
        }
        if (textView != null) {
            if (uin != null && uin.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                setGradientByColorName(IVipDataUtils.INSTANCE.a().getVipDataForFriends(uin).getColorName(), textView, uin);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.vip.api.IVipColorName
    public void clearTextColorGradient(@Nullable View textView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) textView);
            return;
        }
        if (textView == 0) {
            return;
        }
        Paint paint = getPaint(textView);
        if (paint != null) {
            paint.setShader(null);
        }
        setTextBold(textView, false);
        if (textView instanceof VipFlashNickNameView) {
            ((VipFlashNickNameView) textView).b();
            return;
        }
        if (textView instanceof SingleLineTextView) {
            ((SingleLineTextView) textView).stop();
        } else if (textView instanceof QUIEllipsizeTextView) {
            ((QUIEllipsizeTextView) textView).stopScanning();
        } else if (textView instanceof x03.a) {
            ((x03.a) textView).o();
        }
    }

    public final int getCOLOR_NAME() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.COLOR_NAME;
    }

    public final int getNONE() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.NONE;
    }

    @Nullable
    public final Paint getPaint(@NotNull View v3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (Paint) iPatchRedirector.redirect((short) 14, (Object) this, (Object) v3);
        }
        Intrinsics.checkNotNullParameter(v3, "v");
        if (v3 instanceof SingleLineTextView) {
            return ((SingleLineTextView) v3).getPaint();
        }
        if (v3 instanceof TextView) {
            return ((TextView) v3).getPaint();
        }
        return null;
    }

    public final int getRED_NAME() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.RED_NAME;
    }

    @NotNull
    public final ColorNameBusiness getUpdateSystem() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ColorNameBusiness) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.updateSystem;
    }

    @Nullable
    public final Rect getWidth(@NotNull View v3, @Nullable Paint paint) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (Rect) iPatchRedirector.redirect((short) 15, (Object) this, (Object) v3, (Object) paint);
        }
        Intrinsics.checkNotNullParameter(v3, "v");
        if (paint == null) {
            return null;
        }
        if (v3 instanceof SingleLineTextView) {
            str = ((SingleLineTextView) v3).getText().toString();
        } else if (v3 instanceof TextView) {
            str = ((TextView) v3).getText().toString();
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Rect rect = new Rect();
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect;
    }

    @Override // com.tencent.mobileqq.vip.api.IVipColorName
    public void openChangeColorNamePage(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        String stringDataSet = VasToggle.VIP_COLORFUL_NAME.getStringDataSet("setUrl", "");
        if (!TextUtils.isEmpty(stringDataSet)) {
            if (((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).isEnable()) {
                IVasHybridRoute iVasHybridRoute = (IVasHybridRoute) QRoute.api(IVasHybridRoute.class);
                Intrinsics.checkNotNull(stringDataSet);
                iVasHybridRoute.openBrowser(context, stringDataSet, 1039, null);
            } else {
                Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
                intent.setFlags(268435456);
                VasWebviewUtil.openQQBrowserActivity(context, stringDataSet, -1L, intent, true, 1039);
            }
        }
    }

    @Override // com.tencent.mobileqq.vip.api.IVipColorName
    public boolean updateColorNameByCard(@Nullable View textView, @Nullable Card card) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) textView, (Object) card)).booleanValue();
        }
        if (textView == null || card == null) {
            return false;
        }
        String str = card.uin;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        int colorNameByUin$default = setColorNameByUin$default(this, textView, card.uin, isCardVipOpen(card), false, 8, null);
        if (colorNameByUin$default < this.COLOR_NAME) {
            clearTextColorGradient(textView);
        }
        if (colorNameByUin$default <= this.NONE) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.vip.api.IVipColorName
    public boolean updateColorNameByUin(@Nullable View textView, @Nullable String uin, boolean isVip) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? updateColorNameByUin(textView, uin, isVip, true) : ((Boolean) iPatchRedirector.redirect((short) 6, this, textView, uin, Boolean.valueOf(isVip))).booleanValue();
    }

    @Override // com.tencent.mobileqq.vip.api.IVipColorName
    public int updateColorNameByVipBusiness(@Nullable View textView, @NotNull VipInfoForBusiness info) {
        int i3;
        VipData vipData;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this, (Object) textView, (Object) info)).intValue();
        }
        Intrinsics.checkNotNullParameter(info, "info");
        if (textView == null) {
            return this.NONE;
        }
        if (SimpleUIUtil.getSimpleUISwitch()) {
            return this.NONE;
        }
        com.tencent.mobileqq.vip.api.a colorName = info.getColorName();
        int i16 = 0;
        if (colorName != null) {
            i3 = colorName.a();
        } else {
            i3 = 0;
        }
        if (i3 > 0) {
            com.tencent.mobileqq.vip.api.a colorName2 = info.getColorName();
            if (colorName2 != null) {
                i16 = colorName2.a();
            }
            setGradientByColorName(i16, textView, info.getUin());
            return this.COLOR_NAME;
        }
        String uin = info.getUin();
        if (uin == null || uin.length() == 0) {
            i16 = 1;
        }
        if (i16 != 0) {
            return this.NONE;
        }
        if (info.getVipDataFlag() > 0) {
            IVipDataUtils.Companion companion = IVipDataUtils.INSTANCE;
            companion.a().updateFlagData(info.getUin(), info.getVipDataFlag());
            vipData = companion.a().getVipDataForFriends(info.getUin());
        } else {
            vipData = null;
        }
        if (vipData != null && vipData.getColorName() > 0) {
            aSyncSetGradient(textView, info.getUin());
            return this.COLOR_NAME;
        }
        clearTextColorGradient(textView);
        if (info.getNameplateType() > 0) {
            if (vipData != null && vipData.getUseDefaultNickColor()) {
                return this.NONE;
            }
            setColorNameByUin$default(this, textView, info.getUin(), true, false, 8, null);
            return this.RED_NAME;
        }
        return this.NONE;
    }

    @Override // com.tencent.mobileqq.vip.api.IVipColorName
    public int updateColorNameByVipBusinessWithoutUin(@Nullable View textView, @NotNull VipInfoForBusiness info) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this, (Object) textView, (Object) info)).intValue();
        }
        Intrinsics.checkNotNullParameter(info, "info");
        if (textView == null) {
            return this.NONE;
        }
        if (SimpleUIUtil.getSimpleUISwitch()) {
            return this.NONE;
        }
        com.tencent.mobileqq.vip.api.a colorName = info.getColorName();
        int i16 = 0;
        if (colorName != null) {
            i3 = colorName.a();
        } else {
            i3 = 0;
        }
        if (i3 > 0) {
            com.tencent.mobileqq.vip.api.a colorName2 = info.getColorName();
            if (colorName2 != null) {
                i16 = colorName2.a();
            }
            setGradientByColorName(i16, textView, info.getUin());
            return this.COLOR_NAME;
        }
        clearTextColorGradient(textView);
        if (info.getNameplateType() > 0) {
            if (info.getColorName() != null) {
                com.tencent.mobileqq.vip.api.a colorName3 = info.getColorName();
                if (colorName3 != null && colorName3.b()) {
                    i16 = 1;
                }
                if (i16 == 0) {
                    setSingleTextColor(textView, textView.getContext().getColor(R.color.qui_common_feedback_error));
                    VasLogReporter.INSTANCE.getVipColorName().reportLow("use color[" + i3 + "] in view[" + textView + "]");
                    return this.RED_NAME;
                }
            }
            return this.NONE;
        }
        return this.NONE;
    }

    @Override // com.tencent.mobileqq.vip.api.IVipColorName
    public boolean updateColorNameByUin(@Nullable View textView, @Nullable String uin, boolean isVip, boolean noise) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, this, textView, uin, Boolean.valueOf(isVip), Boolean.valueOf(noise))).booleanValue();
        }
        if (textView != null) {
            if (!(uin == null || uin.length() == 0)) {
                int colorNameByUin = setColorNameByUin(textView, uin, isVip || isFriendsVipOpen(uin), noise);
                if (colorNameByUin < this.COLOR_NAME) {
                    clearTextColorGradient(textView);
                }
                return colorNameByUin > this.NONE;
            }
        }
        return false;
    }
}
