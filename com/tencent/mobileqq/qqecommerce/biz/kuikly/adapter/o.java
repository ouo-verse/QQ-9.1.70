package com.tencent.mobileqq.qqecommerce.biz.kuikly.adapter;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.text.rich.bean.RichTextPreloadConfig;
import com.tencent.richframework.text.rich.parser.RichTextEmojiParser;
import d01.y;
import d01.z;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u001c\u0010\u0010\u001a\u00020\r*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0002J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/adapter/o;", "Ld01/m;", "Lcom/tencent/kuikly/core/render/android/expand/component/d;", "textProps", "", "d", "", "textString", "", "b", "", "content", "c", "Landroid/text/SpannableStringBuilder;", "target", "replacement", "e", "Lcom/tencent/kuikly/core/render/android/a;", "context", "Ld01/y;", "inputParams", "Ld01/z;", "a", "", "Ljava/util/List;", "SYS_EMOTICON_SYMBOL_EX", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class o implements d01.m {

    /* renamed from: a, reason: collision with root package name */
    public static final o f262802a = new o();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final List<Integer> SYS_EMOTICON_SYMBOL_EX;

    static {
        List<Integer> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{324, 271, 250});
        SYS_EMOTICON_SYMBOL_EX = listOf;
    }

    o() {
    }

    private final boolean b(String textString) {
        return QQEmojiUtil.containsEmoji(textString) || QQSysFaceUtil.containsExpression(textString);
    }

    private final CharSequence c(CharSequence content) {
        boolean contains$default;
        SpannableStringBuilder spannableStringBuilder = content instanceof SpannableStringBuilder ? (SpannableStringBuilder) content : null;
        if (spannableStringBuilder == null) {
            return content;
        }
        if (TextUtils.isEmpty(content)) {
            return spannableStringBuilder;
        }
        contains$default = StringsKt__StringsKt.contains$default(content, (CharSequence) "/", false, 2, (Object) null);
        if (!contains$default) {
            return spannableStringBuilder;
        }
        try {
            Map<Integer, QQSysAndEmojiResInfo.QQEmoConfigItem> sysConfig = QQSysFaceUtil.sysConfigItemMap();
            Iterator<Integer> it = SYS_EMOTICON_SYMBOL_EX.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                if (sysConfig.containsKey(Integer.valueOf(intValue))) {
                    QQSysAndEmojiResInfo.QQEmoConfigItem qQEmoConfigItem = sysConfig.get(Integer.valueOf(intValue));
                    Intrinsics.checkNotNull(qQEmoConfigItem);
                    String str = "\u0014" + qQEmoConfigItem.QDes;
                    String sysEmotcationString = com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(intValue);
                    Intrinsics.checkNotNullExpressionValue(sysEmotcationString, "getSysEmotcationString(spanIndex)");
                    spannableStringBuilder = e(spannableStringBuilder, str, sysEmotcationString);
                }
            }
            Intrinsics.checkNotNullExpressionValue(sysConfig, "sysConfig");
            for (Map.Entry<Integer, QQSysAndEmojiResInfo.QQEmoConfigItem> entry : sysConfig.entrySet()) {
                Integer index = entry.getKey();
                String str2 = "\u0014" + entry.getValue().QDes;
                Intrinsics.checkNotNullExpressionValue(index, "index");
                String sysEmotcationString2 = com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(index.intValue());
                Intrinsics.checkNotNullExpressionValue(sysEmotcationString2, "getSysEmotcationString(index)");
                spannableStringBuilder = e(spannableStringBuilder, str2, sysEmotcationString2);
            }
            for (Map.Entry<Integer, QQSysAndEmojiResInfo.QQEmoConfigItem> entry2 : sysConfig.entrySet()) {
                Integer index2 = entry2.getKey();
                String symbol = entry2.getValue().QDes;
                Intrinsics.checkNotNullExpressionValue(symbol, "symbol");
                Intrinsics.checkNotNullExpressionValue(index2, "index");
                String sysEmotcationString3 = com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(index2.intValue());
                Intrinsics.checkNotNullExpressionValue(sysEmotcationString3, "getSysEmotcationString(index)");
                spannableStringBuilder = e(spannableStringBuilder, symbol, sysEmotcationString3);
            }
            int length = EmotcationConstants.SYS_EMOTICON_SYMBOL.length;
            for (int i3 = 0; i3 < length; i3++) {
                String str3 = "\u0014" + EmotcationConstants.SYS_EMOTICON_SYMBOL[i3];
                String sysEmotcationString4 = com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(i3);
                Intrinsics.checkNotNullExpressionValue(sysEmotcationString4, "getSysEmotcationString(localId)");
                spannableStringBuilder = e(spannableStringBuilder, str3, sysEmotcationString4);
            }
            int length2 = EmotcationConstants.SYS_EMOTICON_SYMBOL.length;
            for (int i16 = 0; i16 < length2; i16++) {
                String symbol2 = EmotcationConstants.SYS_EMOTICON_SYMBOL[i16];
                Intrinsics.checkNotNullExpressionValue(symbol2, "symbol");
                String sysEmotcationString5 = com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(i16);
                Intrinsics.checkNotNullExpressionValue(sysEmotcationString5, "getSysEmotcationString(localId)");
                spannableStringBuilder = e(spannableStringBuilder, symbol2, sysEmotcationString5);
            }
        } catch (Exception e16) {
            QLog.i("convertQQEmojiNameString2LocalIdString", 1, "convertQQEmojiNameString2LocalIdString exception", e16);
        }
        return spannableStringBuilder;
    }

    private final int d(com.tencent.kuikly.core.render.android.expand.component.d textProps) {
        JSONArray values = textProps.getValues();
        if (values != null && values.length() != 0) {
            int length = values.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject = values.optJSONObject(i3);
                if (optJSONObject != null) {
                    String text = optJSONObject.optString("text", "");
                    Intrinsics.checkNotNullExpressionValue(text, "text");
                    if (b(text)) {
                        return (int) (optJSONObject.optDouble("fontSize", textProps.getFontSize() * 1.0d) * 1.2d);
                    }
                }
            }
            return (int) textProps.getFontSize();
        }
        return (int) textProps.getFontSize();
    }

    @Override // d01.m
    public z a(com.tencent.kuikly.core.render.android.a context, y inputParams) {
        Intrinsics.checkNotNullParameter(inputParams, "inputParams");
        if (Intrinsics.areEqual(inputParams.getProcessor(), "emoji")) {
            CharSequence c16 = c(inputParams.getSourceText());
            if (QQEmojiUtil.containsEmoji(c16.toString()) || QQSysFaceUtil.containsExpression(c16.toString())) {
                return new z(new QQText(c16, 3, (int) (inputParams.getTextProps().getFontSize() * 1.2d)));
            }
        } else {
            if (Intrinsics.areEqual(inputParams.getProcessor(), "input")) {
                return new z(new QQTextBuilder(inputParams.getSourceText(), 3, d(inputParams.getTextProps())));
            }
            if (Intrinsics.areEqual(inputParams.getProcessor(), "em_code") && RichTextEmojiParser.match(inputParams.getSourceText())) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(inputParams.getSourceText());
                RichTextEmojiParser.asyncParseSmiley(new RichTextPreloadConfig.TextImageSpanConfig().setIconSize((int) (inputParams.getTextProps().getFontSize() * 1.2d)).setVerticalAlignment(0), spannableStringBuilder, null);
                return new z(new QQText(spannableStringBuilder, 3, (int) inputParams.getTextProps().getFontSize()));
            }
        }
        return new z(inputParams.getSourceText());
    }

    /* JADX WARN: Incorrect condition in loop: B:2:0x0007 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final SpannableStringBuilder e(SpannableStringBuilder spannableStringBuilder, String str, String str2) {
        boolean contains$default;
        int indexOf$default;
        while (contains$default) {
            String spannableStringBuilder2 = spannableStringBuilder.toString();
            Intrinsics.checkNotNullExpressionValue(spannableStringBuilder2, "spb.toString()");
            indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) spannableStringBuilder2, str, 0, false, 6, (Object) null);
            if (indexOf$default != -1) {
                spannableStringBuilder = spannableStringBuilder.replace(indexOf$default, str.length() + indexOf$default, (CharSequence) str2);
                Intrinsics.checkNotNullExpressionValue(spannableStringBuilder, "spb.replace(indexOfTarge\u2026rget.length, replacement)");
            }
        }
        return spannableStringBuilder;
    }
}
