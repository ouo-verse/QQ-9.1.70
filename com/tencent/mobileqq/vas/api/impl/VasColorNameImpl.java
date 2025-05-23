package com.tencent.mobileqq.vas.api.impl;

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
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.vas.api.IVasColorName;
import com.tencent.mobileqq.vas.flashname.IFlashNickNameComponent;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.updatesystem.business.ColorNameBusiness;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqnt.classadapter.SingleLineTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p33.ScannerData;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 %2\u00020\u0001:\u0001&B\u0007\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0002J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0014\u001a\u00020\u0006H\u0002J\u0018\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J8\u0010!\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0004H\u0016J(\u0010\"\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/VasColorNameImpl;", "Lcom/tencent/mobileqq/vas/api/IVasColorName;", "", NodeProps.COLORS, "", "isSingleTextColor", "Landroid/view/View;", "view", "", "textColor", "", "setSingleTextColor", "isBold", "setTextBold", "grayType", "vipType", "canShowColorName", "setTextColor", "Landroid/graphics/Rect;", "getWidth", "v", "Landroid/graphics/Paint;", "getPaint", "width", "Landroid/graphics/LinearGradient;", "getLinearGradient", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Landroid/graphics/BitmapShader;", "getBitmapShader", "colorNameId", "useDefaultNickColor", "noise", "updateTitle", "needAddTitleCover", "<init>", "()V", "Companion", "a", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasColorNameImpl implements IVasColorName {
    private static final boolean IS_SUPPORT_BOLD = com.tencent.mobileqq.vas.ar.INSTANCE.b("linkliang", "2024-03-12", "vas_color_name_bold_9030").isEnable(true);

    private final boolean canShowColorName(int grayType, int vipType) {
        if (grayType == 0 && vipType > 0) {
            return true;
        }
        return false;
    }

    private final BitmapShader getBitmapShader(Bitmap bitmap) {
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        return new BitmapShader(bitmap, tileMode, tileMode);
    }

    private final LinearGradient getLinearGradient(int width, int[] colors) {
        return new LinearGradient(0.0f, 0.0f, width, 0.0f, colors, (float[]) null, Shader.TileMode.CLAMP);
    }

    private final Paint getPaint(View v3) {
        if (v3 instanceof SingleLineTextView) {
            return ((SingleLineTextView) v3).getPaint();
        }
        if (v3 instanceof TextView) {
            return ((TextView) v3).getPaint();
        }
        return null;
    }

    private final Rect getWidth(View view) {
        String str;
        if (view instanceof SingleLineTextView) {
            str = ((SingleLineTextView) view).getText().toString();
        } else if (view instanceof TextView) {
            str = ((TextView) view).getText().toString();
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            return new Rect();
        }
        Rect rect = new Rect();
        Paint paint = getPaint(view);
        if (paint != null) {
            paint.getTextBounds(str, 0, str.length(), rect);
        }
        return rect;
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
            ((SingleLineTextView) view).setTypeface(defaultFromStyle, false);
        } else if (view instanceof TextView) {
            ((TextView) view).setTypeface(defaultFromStyle);
        }
    }

    private final void setTextColor(View view) {
        if (view instanceof SingleLineTextView) {
            SingleLineTextView singleLineTextView = (SingleLineTextView) view;
            singleLineTextView.setTextColor(singleLineTextView.getResources().getColorStateList(R.color.qui_common_feedback_error));
        } else if (view instanceof TextView) {
            TextView textView = (TextView) view;
            textView.setTextColor(textView.getResources().getColorStateList(R.color.qui_common_feedback_error));
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IVasColorName
    public void needAddTitleCover(int grayType, int vipType, int colorNameId, @NotNull View view) {
        p33.a colorNameData;
        Intrinsics.checkNotNullParameter(view, "view");
        ((IFlashNickNameComponent) QRoute.api(IFlashNickNameComponent.class)).removeNickCover(view);
        if (!SimpleUIUtil.getSimpleUISwitch() && canShowColorName(grayType, vipType) && colorNameId > 0 && (colorNameData = ((ColorNameBusiness) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(ColorNameBusiness.class)).getColorNameData(colorNameId)) != null) {
            ScannerData scannerData = colorNameData.getScannerData();
            boolean z16 = false;
            if (scannerData != null && scannerData.getHasCoverAnim()) {
                z16 = true;
            }
            if (z16) {
                ((IFlashNickNameComponent) QRoute.api(IFlashNickNameComponent.class)).addNickCover(view);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.vas.api.IVasColorName
    public void updateTitle(int grayType, int vipType, int colorNameId, @NotNull View view, boolean useDefaultNickColor, boolean noise) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (SimpleUIUtil.getSimpleUISwitch() || useDefaultNickColor || !canShowColorName(grayType, vipType) || colorNameId < 0) {
            return;
        }
        if (colorNameId == 0) {
            setTextColor(view);
            return;
        }
        Rect width = getWidth(view);
        int width2 = width.width();
        int height = width.height();
        p33.a colorNameData = ((ColorNameBusiness) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(ColorNameBusiness.class)).getColorNameData(colorNameId);
        if (colorNameData == null || colorNameData.getCom.tencent.mtt.hippy.dom.node.NodeProps.COLORS java.lang.String().length < 2) {
            return;
        }
        setTextBold(view, false);
        if (isSingleTextColor(colorNameData.getCom.tencent.mtt.hippy.dom.node.NodeProps.COLORS java.lang.String())) {
            setSingleTextColor(view, colorNameData.getCom.tencent.mtt.hippy.dom.node.NodeProps.COLORS java.lang.String()[0]);
        } else if (colorNameData.getUseImageShader() && colorNameData.getShaderBitmap() != null) {
            Paint paint = getPaint(view);
            if (paint != null) {
                Bitmap shaderBitmap = colorNameData.getShaderBitmap();
                Intrinsics.checkNotNull(shaderBitmap);
                paint.setShader(getBitmapShader(shaderBitmap));
            }
        } else {
            Paint paint2 = getPaint(view);
            if (paint2 != null) {
                paint2.setShader(getLinearGradient(width2, colorNameData.getCom.tencent.mtt.hippy.dom.node.NodeProps.COLORS java.lang.String()));
            }
        }
        ScannerData scannerData = colorNameData.getScannerData();
        if (scannerData != null) {
            if (view instanceof SingleLineTextView) {
                SingleLineTextView singleLineTextView = (SingleLineTextView) view;
                singleLineTextView.stop();
                singleLineTextView.startScanning(width2, height, scannerData.getSweepColor(), Boolean.valueOf(scannerData.getIsSingle()), noise ? 1 : 0);
            } else if (view instanceof x03.a) {
                x03.a aVar = (x03.a) view;
                aVar.o();
                aVar.e(width2, height, scannerData.getSweepColor(), scannerData.getIsSingle(), noise ? 1 : 0);
            }
        }
    }
}
