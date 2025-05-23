package com.tencent.mobileqq.qqecommerce.biz.hippy;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.hippy.qq.utils.HippyUtils;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.adapter.font.HippyFontScaleAdapter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.text.rich.bean.RichTextPreloadConfig;
import com.tencent.richframework.text.rich.parser.Patterns;
import com.tencent.richframework.text.rich.parser.RichTextEmojiParser;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001a\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/hippy/h;", "Lcom/tencent/mtt/hippy/adapter/font/HippyFontScaleAdapter;", "", "getFontScale", "", ReportConstant.COSTREPORT_PREFIX, "", "fontSize", "getEmoticonText", "", "fontFamilyName", "style", "getCustomFontFilePath", "getCustomDefaultFontFamily", "<init>", "()V", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class h implements HippyFontScaleAdapter {

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f262569b = {".ttf", ".otf"};

    @Override // com.tencent.mtt.hippy.adapter.font.HippyFontScaleAdapter
    public String getCustomDefaultFontFamily() {
        return null;
    }

    @Override // com.tencent.mtt.hippy.adapter.font.HippyFontScaleAdapter
    public String getCustomFontFilePath(String fontFamilyName, int style) {
        Intrinsics.checkNotNullParameter(fontFamilyName, "fontFamilyName");
        if (QLog.isColorLevel()) {
            QLog.i("ECHippyQQFontAdapter", 2, "getCustomFontFilePath fontFamilyName = " + fontFamilyName);
        }
        String hippyFontRootDir = HippyUtils.getHippyFontRootDir();
        for (String str : f262569b) {
            String str2 = hippyFontRootDir + fontFamilyName + str;
            if (new File(str2).exists()) {
                return str2;
            }
        }
        return null;
    }

    @Override // com.tencent.mtt.hippy.adapter.font.HippyFontScaleAdapter
    public CharSequence getEmoticonText(CharSequence s16, int fontSize) {
        int indexOf$default;
        if (TextUtils.isEmpty(s16)) {
            return "";
        }
        String changedStr = com.tencent.mobileqq.service.message.b.c(String.valueOf(s16));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(changedStr);
        Intrinsics.checkNotNullExpressionValue(changedStr, "changedStr");
        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) changedStr, '/', 0, false, 6, (Object) null);
        int i3 = (int) (fontSize / 2.5d);
        if (indexOf$default >= 0 && indexOf$default < changedStr.length() - 1 && Patterns.PATTERN_EMO.matcher(changedStr).find()) {
            RichTextEmojiParser.asyncParseSmiley(new RichTextPreloadConfig.TextImageSpanConfig().setIconSize(i3).setVerticalAlignment(0), spannableStringBuilder, null);
        }
        return new QQText(spannableStringBuilder, 2, i3);
    }

    @Override // com.tencent.mtt.hippy.adapter.font.HippyFontScaleAdapter
    public float getFontScale() {
        return 1.0f;
    }
}
