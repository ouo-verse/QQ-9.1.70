package com.tencent.mobileqq.guild.nt.qzone.api.impl;

import com.tencent.mobileqq.guild.nt.qzone.api.IQzoneEmotionUtilsApi;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/nt/qzone/api/impl/QzoneEmotionUtilsApiImpl;", "Lcom/tencent/mobileqq/guild/nt/qzone/api/IQzoneEmotionUtilsApi;", "()V", "getEmoCount", "", "str", "", "getSmileyPattern", "Ljava/util/regex/Pattern;", "replaceEmoCode", ReportConstant.COSTREPORT_PREFIX, "splash2Emo", "qqguild-boundaries-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class QzoneEmotionUtilsApiImpl implements IQzoneEmotionUtilsApi {
    @Override // com.tencent.mobileqq.guild.nt.qzone.api.IQzoneEmotionUtilsApi
    public int getEmoCount(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "str");
        return QzoneEmotionUtils.getEmoCount(str);
    }

    @Override // com.tencent.mobileqq.guild.nt.qzone.api.IQzoneEmotionUtilsApi
    @NotNull
    public Pattern getSmileyPattern() {
        Pattern SMILEY_PATTERN = QzoneEmotionUtils.SMILEY_PATTERN;
        Intrinsics.checkNotNullExpressionValue(SMILEY_PATTERN, "SMILEY_PATTERN");
        return SMILEY_PATTERN;
    }

    @Override // com.tencent.mobileqq.guild.nt.qzone.api.IQzoneEmotionUtilsApi
    @NotNull
    public String replaceEmoCode(@NotNull String str, @NotNull String s16) {
        Intrinsics.checkNotNullParameter(str, "str");
        Intrinsics.checkNotNullParameter(s16, "s");
        String replaceEmoCode = QzoneEmotionUtils.replaceEmoCode(str, s16);
        Intrinsics.checkNotNullExpressionValue(replaceEmoCode, "replaceEmoCode(str, s)");
        return replaceEmoCode;
    }

    @Override // com.tencent.mobileqq.guild.nt.qzone.api.IQzoneEmotionUtilsApi
    @NotNull
    public String splash2Emo(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "str");
        String splash2Emo = QzoneEmotionUtils.splash2Emo(str);
        Intrinsics.checkNotNullExpressionValue(splash2Emo, "splash2Emo(str)");
        return splash2Emo;
    }
}
