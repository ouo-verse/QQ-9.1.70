package com.tencent.mobileqq.wink.editor.model;

import camera.SHADOW_BACKEND_INTERFACE.CircleTemplateInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u00a8\u0006\u0005"}, d2 = {"Lcamera/SHADOW_BACKEND_INTERFACE/CircleTemplateInfo;", "", "logoLocalPath", "Lcom/tencent/mobileqq/wink/editor/model/c;", "a", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class d {
    @NotNull
    public static final WinkUserInfo a(@NotNull CircleTemplateInfo circleTemplateInfo, @NotNull String logoLocalPath) {
        Intrinsics.checkNotNullParameter(circleTemplateInfo, "<this>");
        Intrinsics.checkNotNullParameter(logoLocalPath, "logoLocalPath");
        String nickWord = circleTemplateInfo.getNickWord();
        Intrinsics.checkNotNullExpressionValue(nickWord, "nickWord");
        String qqLogo = circleTemplateInfo.getQqLogo();
        Intrinsics.checkNotNullExpressionValue(qqLogo, "qqLogo");
        String timeMapWord = circleTemplateInfo.getTimeMapWord();
        Intrinsics.checkNotNullExpressionValue(timeMapWord, "timeMapWord");
        String genderMapWord = circleTemplateInfo.getGenderMapWord();
        Intrinsics.checkNotNullExpressionValue(genderMapWord, "genderMapWord");
        String locationMapWord = circleTemplateInfo.getLocationMapWord();
        Intrinsics.checkNotNullExpressionValue(locationMapWord, "locationMapWord");
        String descMapWord = circleTemplateInfo.getDescMapWord();
        Intrinsics.checkNotNullExpressionValue(descMapWord, "descMapWord");
        String StarMapWord = circleTemplateInfo.StarMapWord;
        Intrinsics.checkNotNullExpressionValue(StarMapWord, "StarMapWord");
        String monthLabelWord = circleTemplateInfo.getMonthLabelWord();
        Intrinsics.checkNotNullExpressionValue(monthLabelWord, "monthLabelWord");
        String dayLabelWord = circleTemplateInfo.getDayLabelWord();
        Intrinsics.checkNotNullExpressionValue(dayLabelWord, "dayLabelWord");
        String ageMapWord = circleTemplateInfo.getAgeMapWord();
        Intrinsics.checkNotNullExpressionValue(ageMapWord, "ageMapWord");
        return new WinkUserInfo(nickWord, qqLogo, logoLocalPath, timeMapWord, genderMapWord, locationMapWord, descMapWord, StarMapWord, monthLabelWord, dayLabelWord, ageMapWord);
    }
}
