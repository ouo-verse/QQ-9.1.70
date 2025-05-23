package com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView;

import com.tencent.kuikly.core.base.event.ClickParams;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes31.dex */
public final class PopDownMenuItemData {
    public Function1<? super ClickParams, Unit> clickEvent;
    public boolean enableClick;
    public float iconSize;
    public String itemIcon;
    public String itemName;
    public float textSize;

    public PopDownMenuItemData() {
        this(null, null, null, 7, null);
    }

    public PopDownMenuItemData(String str, String str2, Function1<? super ClickParams, Unit> function1) {
        this.itemName = str;
        this.itemIcon = str2;
        this.clickEvent = function1;
        this.enableClick = true;
        this.textSize = 17.0f;
        this.iconSize = 24.0f;
    }

    public /* synthetic */ PopDownMenuItemData(String str, String str2, Function1 function1, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.PopDownMenuItemData.1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                return Unit.INSTANCE;
            }
        });
    }
}
