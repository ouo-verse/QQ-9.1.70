package com.tencent.autotemplate.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import com.tencent.autotemplate.filter.TAVOneClickFilmStickerEffect;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.model.TAVTransitionableVideo;
import com.tencent.tavkit.composition.resource.TAVEmptyResource;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;
import com.tencent.tavsticker.model.TAVSticker;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TAVCompositionUtils {
    static IPatchRedirector $redirector_;
    private static final String[] COLORS;
    public static int TEXT_SIZE;
    public static int WIDTH;
    private static String lastColor;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20373);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        WIDTH = 4000;
        TEXT_SIZE = 50;
        COLORS = new String[]{"#7A46FF", "#FF00B7", "#FF4273", "#FE9526", "#FFDC00", "#2FA0FF", "#00DADC"};
    }

    public TAVCompositionUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static CMTime calculateTotalTime(TAVComposition tAVComposition) {
        List<List<? extends TAVTransitionableVideo>> videoChannels = tAVComposition.getVideoChannels();
        CMTime cMTime = CMTime.CMTimeZero;
        for (List<? extends TAVTransitionableVideo> list : videoChannels) {
            CMTime cMTime2 = CMTime.CMTimeZero;
            Iterator<? extends TAVTransitionableVideo> it = list.iterator();
            while (it.hasNext()) {
                cMTime2 = cMTime2.add(((TAVClip) it.next()).getResource().getScaledDuration());
            }
            if (cMTime2.bigThan(cMTime)) {
                cMTime = cMTime2;
            }
        }
        return cMTime;
    }

    private static Bitmap draw(TAVComposition tAVComposition, long j3) {
        int i3;
        int i16;
        int i17;
        List<List<? extends TAVTransitionableVideo>> list;
        int i18;
        List<TAVSticker> list2;
        int i19;
        long j16 = j3;
        int i26 = WIDTH;
        int i27 = (int) (i26 * 0.9f);
        int i28 = (i26 - i27) / 2;
        List<List<? extends TAVTransitionableVideo>> videoChannels = tAVComposition.getVideoChannels();
        int size = videoChannels.size();
        List<TAVSticker> stickers = getStickers(tAVComposition);
        if (stickers != null && !stickers.isEmpty()) {
            i3 = stickers.size();
        } else {
            i3 = 0;
        }
        Bitmap createBitmap = Bitmap.createBitmap(WIDTH, (int) ((size + i3 + 2) * 150 * 1.5f), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setColor(-16777216);
        paint2.setTextSize(TEXT_SIZE);
        paint2.setTextAlign(Paint.Align.CENTER);
        int i29 = 0;
        while (i29 < videoChannels.size()) {
            List<? extends TAVTransitionableVideo> list3 = videoChannels.get(i29);
            if (list3 != null && !list3.isEmpty()) {
                i19 = i3;
                long j17 = 0;
                int i36 = 0;
                list = videoChannels;
                while (i36 < list3.size()) {
                    TAVClip tAVClip = (TAVClip) list3.get(i36);
                    int i37 = size;
                    List<TAVSticker> list4 = stickers;
                    long timeUs = tAVClip.getResource().getScaledDuration().getTimeUs() / 1000;
                    List<? extends TAVTransitionableVideo> list5 = list3;
                    Bitmap bitmap = createBitmap;
                    float f16 = (float) j16;
                    float f17 = i27;
                    int i38 = ((int) ((((float) j17) / f16) * f17)) + i28;
                    int i39 = i29 * 150;
                    int i46 = i28;
                    paint.setColor(getRandomColor());
                    int i47 = i27;
                    canvas.drawRect(new Rect(i38, i39, i38 + ((int) ((((float) timeUs) / f16) * f17)), i39 + 100), paint);
                    if (tAVClip.getResource() instanceof TAVEmptyResource) {
                        canvas.drawText("E" + timeUs, i38 + (r0 / 2), i39 + 50, paint2);
                    } else {
                        canvas.drawText(String.valueOf(timeUs), i38 + (r0 / 2), i39 + 50, paint2);
                    }
                    j17 += timeUs;
                    i36++;
                    j16 = j3;
                    list3 = list5;
                    createBitmap = bitmap;
                    size = i37;
                    stickers = list4;
                    i28 = i46;
                    i27 = i47;
                }
                i16 = i28;
                i17 = i27;
                i18 = size;
                list2 = stickers;
            } else {
                i16 = i28;
                i17 = i27;
                list = videoChannels;
                i18 = size;
                list2 = stickers;
                i19 = i3;
            }
            i29++;
            j16 = j3;
            videoChannels = list;
            i3 = i19;
            createBitmap = createBitmap;
            size = i18;
            stickers = list2;
            i28 = i16;
            i27 = i17;
        }
        int i48 = i28;
        int i49 = i27;
        int i56 = size;
        List<TAVSticker> list6 = stickers;
        int i57 = i3;
        Bitmap bitmap2 = createBitmap;
        if (i57 > 0) {
            paint.setColor(getRandomColor());
            int i58 = i56;
            int i59 = i58 * 150;
            canvas.drawRect(new Rect(0, i59, WIDTH, i59 + 10), paint);
            int i65 = 0;
            while (i65 < i57) {
                TAVSticker tAVSticker = list6.get(i65);
                CMTimeRange timeRange = tAVSticker.getTimeRange();
                long timeUs2 = timeRange.getStart().getTimeUs() / 1000;
                long timeUs3 = timeRange.getDuration().getTimeUs() / 1000;
                float f18 = (float) j3;
                int i66 = i49;
                float f19 = i66;
                int i67 = ((int) ((((float) timeUs2) / f18) * f19)) + i48;
                int i68 = (i58 + 1 + i65) * 150;
                paint.setColor(getRandomColor());
                int i69 = i67 + ((int) ((((float) timeUs3) / f18) * f19));
                canvas.drawRect(new Rect(i67, i68, i69, i68 + 100), paint);
                paint.setColor(getRandomColor());
                int i75 = i58;
                canvas.drawRect(new Rect(i67 - 2, 0, i67, i68), paint);
                paint.setColor(getRandomColor());
                canvas.drawRect(new Rect(i69, 0, i69 + 2, i68), paint);
                String stickerName = getStickerName(tAVSticker.getFilePath());
                if (stickerName == null) {
                    stickerName = String.valueOf(i65);
                }
                canvas.drawText(stickerName, i67 + (r8 / 2), i68 + 50, paint2);
                i65++;
                i49 = i66;
                i58 = i75;
            }
        }
        return bitmap2;
    }

    private static int getRandomColor() {
        String[] strArr = COLORS;
        int length = strArr.length;
        String str = strArr[RandomUtil.RandomInt(0, length)];
        while (lastColor == str) {
            str = COLORS[RandomUtil.RandomInt(0, length)];
        }
        lastColor = str;
        return Color.parseColor(str);
    }

    private static String getStickerName(String str) {
        int lastIndexOf;
        if (TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf(File.separator) + 1) >= str.length()) {
            return null;
        }
        return str.substring(lastIndexOf);
    }

    private static List<TAVSticker> getStickers(TAVComposition tAVComposition) {
        TAVVideoMixEffect videoMixEffect = tAVComposition.getVideoMixEffect();
        if (!(videoMixEffect instanceof TAVOneClickFilmStickerEffect)) {
            return null;
        }
        List<TAVSticker> stickers = ((TAVOneClickFilmStickerEffect) videoMixEffect).getStickerContext().getStickers();
        if (stickers.isEmpty()) {
            return null;
        }
        return stickers;
    }

    public static Bitmap showProfile(TAVComposition tAVComposition) {
        if (tAVComposition == null || tAVComposition.getVideoChannels().isEmpty()) {
            return null;
        }
        return draw(tAVComposition, calculateTotalTime(tAVComposition).getTimeUs() / 1000);
    }
}
