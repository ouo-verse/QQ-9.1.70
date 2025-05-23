package com.tencent.hippykotlin.demo.pages.qq_intimate_space.component;

import com.tencent.mobileqq.tianshu.ui.RedTouch;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class LoveSproutCardViewModel {
    public String intro;
    public List<String> introHighlightWords;

    public LoveSproutCardViewModel(LoveSproutCardConfig loveSproutCardConfig) {
        List<String> emptyList;
        String replace$default;
        String replace$default2;
        String replace$default3;
        String replace$default4;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.introHighlightWords = emptyList;
        String str = loveSproutCardConfig.getFlower().C;
        this.intro = str;
        this.introHighlightWords = LoveSproutCardViewKt.extractBracketedContent(str);
        replace$default = StringsKt__StringsJVMKt.replace$default(this.intro, "[", "", false, 4, (Object) null);
        replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, "]", "", false, 4, (Object) null);
        replace$default3 = StringsKt__StringsJVMKt.replace$default(replace$default2, "\\\\n", "\n", false, 4, (Object) null);
        replace$default4 = StringsKt__StringsJVMKt.replace$default(replace$default3, RedTouch.NEWLINE_CHAR, "\n", false, 4, (Object) null);
        this.intro = replace$default4;
    }
}
