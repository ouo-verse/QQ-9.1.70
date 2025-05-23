package h73;

import com.tencent.mobileqq.wink.editor.WinkImageTavCut;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.mobileqq.wink.editor.draft.WinkEditData;
import com.tencent.mobileqq.wink.editor.sticker.l;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u53.i;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ,\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J,\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b\u00a8\u0006\r"}, d2 = {"Lh73/b;", "", "Lcom/tencent/mobileqq/wink/editor/WinkVideoTavCut;", "videoTavCut", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "a", "Lcom/tencent/mobileqq/wink/editor/WinkImageTavCut;", "imageTavCut", "b", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f404555a = new b();

    b() {
    }

    @NotNull
    public final HashMap<String, String> a(@Nullable WinkVideoTavCut videoTavCut) {
        boolean booleanValue;
        boolean booleanValue2;
        boolean booleanValue3;
        HashMap<String, String> hashMap = new HashMap<>();
        if (videoTavCut != null) {
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_STICKER_CHANGED, String.valueOf(videoTavCut.i2()));
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_STICKER_CHANGED_ID, videoTavCut.y1());
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_STICKER_ID_INFO, l.z(videoTavCut.K1()));
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_STICKER_TYPE_COUNT_ID, l.A(videoTavCut.K1()));
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_SPECIAL_EFFECTS_ID_INFO, l.w(videoTavCut.K1()));
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_SPECIAL_EFFECTS_TYPE_COUNT_ID, l.x(videoTavCut.K1()));
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_FILTER_CHANGED, String.valueOf(videoTavCut.a2()));
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_FILTER_CHANGED_ID, String.valueOf(videoTavCut.X()));
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEMPLATE_CHANGED, String.valueOf(videoTavCut.S()));
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEMPLATE_CHANGED_ID, videoTavCut.A1());
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_SPECIAL_EFFECTS, String.valueOf(videoTavCut.h2()));
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_SPECIAL_EFFECTS_ID, String.valueOf(videoTavCut.x1()));
        }
        Boolean bool = i.f438430c;
        boolean z16 = false;
        if (bool == null) {
            booleanValue = false;
        } else {
            booleanValue = bool.booleanValue();
        }
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_WNS_OPEN_FAST_COMPRESS, String.valueOf(booleanValue));
        Boolean bool2 = i.f438428a;
        if (bool2 == null) {
            booleanValue2 = false;
        } else {
            booleanValue2 = bool2.booleanValue();
        }
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_WNS_OPEN_FFMPEG_DECODE, String.valueOf(booleanValue2));
        Boolean bool3 = i.f438433f;
        if (bool3 == null) {
            booleanValue3 = false;
        } else {
            booleanValue3 = bool3.booleanValue();
        }
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_WNS_OPEN_HIGH_QUALITY_EDIT, String.valueOf(booleanValue3));
        Boolean bool4 = i.f438432e;
        if (bool4 != null) {
            z16 = bool4.booleanValue();
        }
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_WNS_OPEN_NON_ACCURATE_EXTRACT_FRAME, String.valueOf(z16));
        return hashMap;
    }

    @NotNull
    public final HashMap<String, String> b(@Nullable WinkImageTavCut imageTavCut) {
        String str;
        String str2;
        String str3;
        String str4;
        HashMap<String, String> hashMap = new HashMap<>();
        if (imageTavCut != null) {
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_STICKER_CHANGED, String.valueOf(imageTavCut.h1()));
            WinkEditData Z0 = imageTavCut.Z0();
            String str5 = null;
            if (Z0 != null) {
                str = l.z(Z0);
            } else {
                str = null;
            }
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_STICKER_ID_INFO, String.valueOf(str));
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_STICKER_CHANGED_ID, imageTavCut.U0());
            WinkEditData Z02 = imageTavCut.Z0();
            if (Z02 != null) {
                str2 = l.A(Z02);
            } else {
                str2 = null;
            }
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_STICKER_TYPE_COUNT_ID, String.valueOf(str2));
            WinkEditData Z03 = imageTavCut.Z0();
            if (Z03 != null) {
                str3 = l.w(Z03);
            } else {
                str3 = null;
            }
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_SPECIAL_EFFECTS_ID_INFO, String.valueOf(str3));
            WinkEditData Z04 = imageTavCut.Z0();
            if (Z04 != null) {
                str5 = l.x(Z04);
            }
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_SPECIAL_EFFECTS_TYPE_COUNT_ID, String.valueOf(str5));
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_FILTER_CHANGED, String.valueOf(imageTavCut.e1()));
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_FILTER_CHANGED_ID, String.valueOf(imageTavCut.X()));
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEMPLATE_CHANGED, String.valueOf(imageTavCut.S()));
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEMPLATE_CHANGED_ID, imageTavCut.V0());
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_SPECIAL_EFFECTS, String.valueOf(imageTavCut.g1()));
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_SPECIAL_EFFECTS_ID, String.valueOf(imageTavCut.T0()));
            String str6 = "1";
            if (imageTavCut.a1()) {
                str4 = "1";
            } else {
                str4 = "0";
            }
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_MOSAIC_CHANGED, str4);
            WinkEditData Z05 = imageTavCut.Z0();
            boolean z16 = false;
            if (Z05 != null && Z05.isAIElimination()) {
                z16 = true;
            }
            if (!z16) {
                str6 = "0";
            }
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_ELIMINATE_CHANGED, str6);
        }
        return hashMap;
    }
}
