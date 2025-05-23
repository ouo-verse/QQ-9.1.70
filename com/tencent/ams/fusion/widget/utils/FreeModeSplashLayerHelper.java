package com.tencent.ams.fusion.widget.utils;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import com.tencent.ams.fusion.widget.animatorview.animator.KeepAnimator;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.LineLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.RectangleShapeLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.TextLayer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class FreeModeSplashLayerHelper {
    static IPatchRedirector $redirector_ = null;
    public static final int DEFAULT = 0;
    private static final String DEFAULT_REVERSE_TEXT = "\u6446\u6b63\u624b\u673a\u8fdb\u884c\u8df3\u8f6c";
    private static final String DEFAULT_TXT1 = "VIP\u6b4c\u66f2";
    private static final String DEFAULT_TXT2 = "\u514d\u8d39\u542c10\u5206\u949f";
    private static final String DEFAULT_TXT3 = "\u5b8c\u6210\u4e92\u52a8\u6216\u70b9\u51fb\uff0c\u514d\u8d39\u542c\u6b4c";
    private static final String DEFAULT_TXT4 = "\u8df3\u8f6c\u8be6\u60c5\u9875\u6216\u7b2c\u4e09\u65b9\u5e94\u7528";
    private static final String DESC_COLOR = "#999999";
    public static final int FREE_MODE = 1;
    private static final String LINE_COLOR = "#00F8AC";
    public static final int PURE_MODE = 2;
    public static final String REVERSE_TXT_TAG = "reverseTextTag";
    private static final String TXT_COLOR = "#000000";
    private static RectF sButtonRectF;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface OnFreeModeButtonClickListener {
        void onFreeModeButtonClick(float f16, float f17);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39006);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            sButtonRectF = null;
        }
    }

    public FreeModeSplashLayerHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static List<AnimatorLayer> buildFreeModeCardLayers(Context context, List<AnimatorLayer> list, int i3, float f16, String str, String str2, String str3, String str4) {
        String str5;
        String str6;
        String str7;
        String str8;
        if (context != null && !Utils.isEmpty(list) && i3 != 0 && f16 != 0.0f) {
            int relativeSize375 = Utils.getRelativeSize375(context, 306);
            int relativeSize3752 = Utils.getRelativeSize375(context, 181);
            ArrayList arrayList = new ArrayList();
            RectangleShapeLayer rectangleShapeLayer = new RectangleShapeLayer(relativeSize375, relativeSize3752, Color.parseColor("#FFFFFF"));
            rectangleShapeLayer.setRadius(50.0f);
            float f17 = i3 / 2;
            rectangleShapeLayer.setCenterX(f17);
            rectangleShapeLayer.setY(f16);
            rectangleShapeLayer.setAnimator(new KeepAnimator(rectangleShapeLayer));
            list.add(rectangleShapeLayer);
            float textPaintHeight = Utils.getTextPaintHeight(Utils.dp2px(25.0f)) + f16 + Utils.dp2px(10.0f);
            if (TextUtils.isEmpty(str)) {
                str5 = DEFAULT_TXT1;
            } else {
                str5 = str;
            }
            int i16 = relativeSize375 - 80;
            String str9 = str5;
            AnimatorLayer createTextLayer = createTextLayer(str5, Color.parseColor(TXT_COLOR), Utils.dp2px(25.0f), f17, textPaintHeight, true, i16);
            float min = Math.min(createTextLayer.getWidth(), createTextLayer.getPaint().measureText(str9));
            float f18 = i3;
            float f19 = (f18 - min) / 2.0f;
            float f26 = f19 + min;
            float dp2px = textPaintHeight + Utils.dp2px(2.0f);
            float dp2px2 = textPaintHeight - Utils.dp2px(1.0f);
            LineLayer lineLayer = new LineLayer(f19, f26, dp2px, dp2px2);
            lineLayer.setColor(Color.parseColor(LINE_COLOR));
            lineLayer.setCenterX(f17);
            lineLayer.setStrokeWidth(Utils.dp2px(2.88f));
            lineLayer.setStrokeCap(Paint.Cap.ROUND);
            lineLayer.setAnimator(new KeepAnimator(lineLayer));
            list.add(lineLayer);
            LineLayer lineLayer2 = new LineLayer(f19 + (min * 0.35f), f26 + Utils.dp2px(2.0f), dp2px + Utils.dp2px(5.0f), dp2px2 + Utils.dp2px(4.0f));
            lineLayer2.setColor(Color.parseColor(LINE_COLOR));
            lineLayer2.setCenterX(f17);
            lineLayer2.setStrokeWidth(Utils.dp2px(2.88f));
            lineLayer2.setStrokeCap(Paint.Cap.ROUND);
            lineLayer2.setAnimator(new KeepAnimator(lineLayer2));
            list.add(lineLayer2);
            float textPaintHeight2 = textPaintHeight + Utils.getTextPaintHeight(Utils.dp2px(19.0f));
            if (TextUtils.isEmpty(str2)) {
                str6 = DEFAULT_TXT2;
            } else {
                str6 = str2;
            }
            AnimatorLayer createTextLayer2 = createTextLayer(str6, Color.parseColor(TXT_COLOR), Utils.dp2px(19.0f), f17, textPaintHeight2, true, i16);
            list.add(createTextLayer2);
            list.add(createTextLayer);
            float min2 = ((f18 + Math.min(createTextLayer2.getWidth(), createTextLayer2.getPaint().measureText(str6))) / 2.0f) + Utils.dp2px(3.0f);
            float dp2px3 = Utils.dp2px(4.0f) + min2;
            float dp2px4 = (textPaintHeight2 - Utils.dp2px(19.0f)) + Utils.dp2px(4.0f);
            float dp2px5 = dp2px4 - Utils.dp2px(4.0f);
            LineLayer lineLayer3 = new LineLayer(min2, dp2px3, dp2px4, dp2px5);
            lineLayer3.setColor(Color.parseColor(LINE_COLOR));
            lineLayer3.setStrokeWidth(Utils.dp2px(2.4f));
            lineLayer3.setStrokeCap(Paint.Cap.ROUND);
            lineLayer3.setAnimator(new KeepAnimator(lineLayer3));
            list.add(lineLayer3);
            float dp2px6 = min2 + Utils.dp2px(1.0f);
            LineLayer lineLayer4 = new LineLayer(dp2px6, Utils.dp2px(3.0f) + dp2px6, dp2px4 + Utils.dp2px(3.0f), dp2px5 + Utils.dp2px(5.0f));
            lineLayer4.setColor(Color.parseColor(LINE_COLOR));
            lineLayer4.setCenterX(f17);
            lineLayer4.setStrokeWidth(Utils.dp2px(2.4f));
            lineLayer4.setStrokeCap(Paint.Cap.ROUND);
            lineLayer4.setAnimator(new KeepAnimator(lineLayer4));
            list.add(lineLayer4);
            int relativeSize3753 = Utils.getRelativeSize375(context, 272);
            int relativeSize3754 = Utils.getRelativeSize375(context, 43);
            RectangleShapeLayer rectangleShapeLayer2 = new RectangleShapeLayer(relativeSize3753, relativeSize3754, Color.parseColor(LINE_COLOR));
            rectangleShapeLayer2.setRadius(80.0f);
            rectangleShapeLayer2.setCenterX(f17);
            rectangleShapeLayer2.setY(f16 + Utils.dp2px(96.0f));
            rectangleShapeLayer2.setAnimator(new KeepAnimator(rectangleShapeLayer2));
            list.add(rectangleShapeLayer2);
            float f27 = relativeSize3753 / 2;
            float f28 = relativeSize3754;
            sButtonRectF = new RectF(rectangleShapeLayer2.getCenterX() - f27, rectangleShapeLayer2.getY(), rectangleShapeLayer2.getCenterX() + f27, rectangleShapeLayer2.getY() + f28);
            Logger.i("build click button area :" + sButtonRectF);
            if (TextUtils.isEmpty(str3)) {
                str7 = DEFAULT_TXT3;
            } else {
                str7 = str3;
            }
            TextLayer createTextLayer3 = createTextLayer(str7, Color.parseColor(TXT_COLOR), Utils.dp2px(13.0f), f17, rectangleShapeLayer2.getCenterY() + (Utils.dp2px(10.0f) / 2.0f), true, relativeSize3753);
            list.add(createTextLayer3);
            createTextLayer3.setTag(REVERSE_TXT_TAG);
            arrayList.add(createTextLayer3);
            if (TextUtils.isEmpty(str4)) {
                str8 = DEFAULT_TXT4;
            } else {
                str8 = str4;
            }
            list.add(createTextLayer(str8, Color.parseColor(DESC_COLOR), Utils.dp2px(10.0f), f17, rectangleShapeLayer2.getY() + f28 + Utils.getTextPaintHeight(Utils.dp2px(10.0f)) + Utils.dp2px(8.0f), false, relativeSize3753));
            return arrayList;
        }
        Logger.e("buildFreeModeCardLayers invalid params.");
        return null;
    }

    private static TextLayer createTextLayer(String str, int i3, float f16, float f17, float f18, boolean z16, int i16) {
        TextLayer textLayer = new TextLayer(str, i3, f16);
        textLayer.setShadowLayer(1.0f, 1.0f, 1.0f, Utils.buildColorFromARGB(0.2f, 0.0f, 0.0f, 0.0f));
        textLayer.setTextAlign(Paint.Align.CENTER);
        textLayer.setWidth(i16);
        textLayer.setEllipsizeAtEnd(true);
        textLayer.setX(f17);
        textLayer.setY(f18);
        textLayer.setTextBold(z16);
        textLayer.setAnimator(new KeepAnimator(textLayer));
        return textLayer;
    }

    public static RectF getFreeModeButtonArea() {
        return sButtonRectF;
    }

    public static boolean isClickInFreeModeButton(float f16, float f17) {
        RectF freeModeButtonArea = getFreeModeButtonArea();
        if (freeModeButtonArea != null && freeModeButtonArea.contains(f16, f17)) {
            return true;
        }
        return false;
    }

    public static void onBackInteractProgress(List<AnimatorLayer> list) {
        if (!Utils.isEmpty(list)) {
            for (AnimatorLayer animatorLayer : list) {
                if ((animatorLayer instanceof TextLayer) && REVERSE_TXT_TAG.equals(animatorLayer.getTag())) {
                    ((TextLayer) animatorLayer).setText("\u6446\u6b63\u624b\u673a\u8fdb\u884c\u8df3\u8f6c");
                }
            }
        }
    }
}
