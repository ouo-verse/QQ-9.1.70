package fn1;

import android.graphics.Bitmap;
import android.text.SpannableStringBuilder;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.guild.feed.widget.u;
import com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import en1.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u0010"}, d2 = {"Lfn1/d;", "Len1/a;", "", "width", "height", "roundPx", "Lcom/tencent/image/DownloadParams$DecodeHandler;", "c", "Lorg/json/JSONObject;", "contentJson", "Len1/a$a;", "result", "", "a", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class d implements en1.a {
    private final DownloadParams.DecodeHandler c(final int width, final int height, final int roundPx) {
        return new DownloadParams.DecodeHandler() { // from class: fn1.c
            @Override // com.tencent.image.DownloadParams.DecodeHandler
            public final Bitmap run(DownloadParams downloadParams, Bitmap bitmap) {
                Bitmap d16;
                d16 = d.d(roundPx, width, height, downloadParams, bitmap);
                return d16;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bitmap d(int i3, int i16, int i17, DownloadParams downloadParams, Bitmap bitmap) {
        if (bitmap != null) {
            return BaseImageUtil.getRoundedCornerBitmap(bitmap, i3, i16, i17);
        }
        return bitmap;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0038  */
    @Override // en1.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(@NotNull JSONObject contentJson, @NotNull a.C10251a result) {
        boolean z16;
        boolean isBlank;
        Intrinsics.checkNotNullParameter(contentJson, "contentJson");
        Intrinsics.checkNotNullParameter(result, "result");
        JSONObject jSONObject = contentJson.getJSONObject("group_content");
        long j3 = jSONObject.getLong("group_code");
        String string = jSONObject.getString("group_name");
        String string2 = jSONObject.getString("group_avatar");
        if (string2 != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(string2);
            if (!isBlank) {
                z16 = false;
                if (z16) {
                    Intrinsics.checkNotNullExpressionValue(string2, "{\n            groupAvatar\n        }");
                } else {
                    string2 = ITroopAvatarUtilApi.REGEXP_URL_STRING + j3 + '/' + j3 + "/100";
                }
                int dpToPx = ViewUtils.dpToPx(14.0f);
                int dpToPx2 = ViewUtils.dpToPx(2.0f);
                URLDrawable icon = URLDrawable.getDrawable(string2, URLDrawable.URLDrawableOptions.obtain());
                icon.setBounds(0, 0, dpToPx, dpToPx);
                icon.setDecodeHandler(c(dpToPx, dpToPx, dpToPx2));
                Intrinsics.checkNotNullExpressionValue(icon, "icon");
                u uVar = new u(icon, 1);
                uVar.a(0, ViewUtils.dpToPx(4.0f));
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                result.getTextContent().append(" ");
                spannableStringBuilder.setSpan(uVar, 0, 1, 33);
                result.getTextContent().append((CharSequence) spannableStringBuilder);
                result.getTextContent().append((CharSequence) new SpannableStringBuilder(string));
            }
        }
        z16 = true;
        if (z16) {
        }
        int dpToPx3 = ViewUtils.dpToPx(14.0f);
        int dpToPx22 = ViewUtils.dpToPx(2.0f);
        URLDrawable icon2 = URLDrawable.getDrawable(string2, URLDrawable.URLDrawableOptions.obtain());
        icon2.setBounds(0, 0, dpToPx3, dpToPx3);
        icon2.setDecodeHandler(c(dpToPx3, dpToPx3, dpToPx22));
        Intrinsics.checkNotNullExpressionValue(icon2, "icon");
        u uVar2 = new u(icon2, 1);
        uVar2.a(0, ViewUtils.dpToPx(4.0f));
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
        result.getTextContent().append(" ");
        spannableStringBuilder2.setSpan(uVar2, 0, 1, 33);
        result.getTextContent().append((CharSequence) spannableStringBuilder2);
        result.getTextContent().append((CharSequence) new SpannableStringBuilder(string));
    }
}
