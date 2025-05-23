package com.qzone.reborn.part.publish.mood.imageai;

import android.content.Context;
import android.graphics.Color;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.common.account.LoginData;
import com.qzone.util.ar;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u0006\u0010\n\u001a\u00020\u0002J\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u0002J\u0006\u0010\u000e\u001a\u00020\u000bJ\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u000fJ\u000e\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011J\u0016\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0017R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0019R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/qzone/reborn/part/publish/mood/imageai/f;", "", "", "b", "", "c", "originalText", "newText", "", tl.h.F, "g", "", "j", "f", "i", "", "e", "Landroid/content/Context;", "context", "d", "aiText", "", "a", UserInfo.SEX_FEMALE, "EXCEPT_GUIDE_LEFT_TEXT_WIDTH_RATIO", "Ljava/util/List;", "renderColorsLight", "renderColorsNight", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f58673a = new f();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final float EXCEPT_GUIDE_LEFT_TEXT_WIDTH_RATIO = ar.e(235.0f) / ar.e(375.0f);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final List<Integer> renderColorsLight;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final List<Integer> renderColorsNight;

    static {
        List<Integer> listOf;
        List<Integer> listOf2;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(Color.parseColor("#CDBCFF")), Integer.valueOf(Color.parseColor("#D6D3FF")), Integer.valueOf(Color.parseColor("#FFD5FA")), Integer.valueOf(Color.parseColor("#FFDFD4")), Integer.valueOf(Color.parseColor("#CED5FF"))});
        renderColorsLight = listOf;
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(Color.parseColor("#60508A")), Integer.valueOf(Color.parseColor("#5F5C7D")), Integer.valueOf(Color.parseColor("#8B6285")), Integer.valueOf(Color.parseColor("#896051")), Integer.valueOf(Color.parseColor("#676B80"))});
        renderColorsNight = listOf2;
    }

    f() {
    }

    @JvmStatic
    public static final boolean b() {
        return com.qzone.reborn.configx.g.f53821a.b().h0();
    }

    @JvmStatic
    public static final String c() {
        return LoginData.getInstance().getUin() + "_" + System.currentTimeMillis();
    }

    private final int h(String originalText, String newText) {
        int length = originalText.length();
        int length2 = newText.length();
        int i3 = length + 1;
        int[][] iArr = new int[i3];
        for (int i16 = 0; i16 < i3; i16++) {
            iArr[i16] = new int[length2 + 1];
        }
        if (1 <= length) {
            int i17 = 1;
            while (true) {
                if (1 <= length2) {
                    int i18 = 1;
                    while (true) {
                        int i19 = i17 - 1;
                        int i26 = i18 - 1;
                        if (originalText.charAt(i19) == newText.charAt(i26)) {
                            iArr[i17][i18] = iArr[i19][i26] + 1;
                        } else {
                            int[] iArr2 = iArr[i17];
                            iArr2[i18] = Math.max(iArr[i19][i18], iArr2[i26]);
                        }
                        if (i18 == length2) {
                            break;
                        }
                        i18++;
                    }
                }
                if (i17 == length) {
                    break;
                }
                i17++;
            }
        }
        return iArr[length][length2];
    }

    public final float a(String originalText, String aiText) {
        Intrinsics.checkNotNullParameter(originalText, "originalText");
        Intrinsics.checkNotNullParameter(aiText, "aiText");
        int length = aiText.length();
        int h16 = h(originalText, aiText);
        if (length > 0) {
            return h16 / length;
        }
        return 0.0f;
    }

    public final int d(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        int o16 = pl.a.f426446a.o(context) - ((int) (EXCEPT_GUIDE_LEFT_TEXT_WIDTH_RATIO * r0.o(context)));
        QLog.i("QZonePublishPicToTextManager", 1, "[getGuideLeftTextMaxWidth] maxWidth=" + o16);
        return o16;
    }

    public final List<Integer> e() {
        if (QQTheme.isNowThemeIsNight()) {
            return renderColorsNight;
        }
        return renderColorsLight;
    }

    public final boolean f() {
        boolean d16 = com.qzone.reborn.util.i.b().d("is_granted_mood_pic_to_text", false);
        QLog.i("QZonePublishPicToTextManager", 1, "[isGrantedPicToText] isShow:" + d16);
        return d16;
    }

    public final boolean g() {
        boolean d16 = com.qzone.reborn.util.i.b().d("is_show_pic_to_text_guide_view", false);
        QLog.i("QZonePublishPicToTextManager", 1, "[isShowGuideView] isShow:" + d16);
        return d16;
    }

    public final void i() {
        QLog.i("QZonePublishPicToTextManager", 1, "[saveGrantedPicToText]");
        com.qzone.reborn.util.i.b().l("is_granted_mood_pic_to_text", true);
    }

    public final void j() {
        QLog.i("QZonePublishPicToTextManager", 1, "[saveShownGuideView]");
        com.qzone.reborn.util.i.b().l("is_show_pic_to_text_guide_view", true);
    }
}
