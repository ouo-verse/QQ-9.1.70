package com.tencent.hippykotlin.demo.pages.foundation.qui_component;

import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUITokenKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUITokenThemeMode;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.RenderView;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.h;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class QActionSheetView extends DeclarativeBaseView<QActionSheetAttr, QActionSheetEvent> {
    public final QActionSheetEvent eventInstance = new QActionSheetEvent();

    public final void addButton(final String str) {
        performTaskWhenRenderViewDidLoad(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.qui_component.QActionSheetView$addButton$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                RenderView renderView = QActionSheetView.this.getRenderView();
                if (renderView != null) {
                    RenderView.b(renderView, "addButton", str, null, 4, null);
                }
                return Unit.INSTANCE;
            }
        });
    }

    public final void addCancelButton() {
        performTaskWhenRenderViewDidLoad(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.qui_component.QActionSheetView$addCancelButton$1
            public final /* synthetic */ String $text = "\u53d6\u6d88";

            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                RenderView renderView = QActionSheetView.this.getRenderView();
                if (renderView != null) {
                    RenderView.b(renderView, "addCancelButton", this.$text, null, 4, null);
                }
                return Unit.INSTANCE;
            }
        });
    }

    public final void addRadioButton(String str, boolean z16) {
        e eVar = new e();
        eVar.v("text", str);
        eVar.w("selected", z16);
        final String eVar2 = eVar.toString();
        performTaskWhenRenderViewDidLoad(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.qui_component.QActionSheetView$addRadioButton$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                RenderView renderView = QActionSheetView.this.getRenderView();
                if (renderView != null) {
                    RenderView.b(renderView, "addRadioButton", eVar2, null, 4, null);
                }
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new QActionSheetAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return this.eventInstance;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final void didInit() {
        super.didInit();
        if (QUITokenKt.quiTokenThemeMode(h.a()) == QUITokenThemeMode.ONLY_DAY_AND_NIGHT) {
            if (QUIToken.INSTANCE.isNightMode()) {
                ((QActionSheetAttr) getViewAttr()).with("theme", "night");
                return;
            } else {
                ((QActionSheetAttr) getViewAttr()).with("theme", "day");
                return;
            }
        }
        if (QUITokenKt.quiTokenThemeMode(h.a()) == QUITokenThemeMode.ONLY_DAY) {
            ((QActionSheetAttr) getViewAttr()).with("theme", "day");
        } else if (QUITokenKt.quiTokenThemeMode(h.a()) == QUITokenThemeMode.ONLY_NIGHT) {
            ((QActionSheetAttr) getViewAttr()).with("theme", "night");
        }
    }

    public final void dismiss() {
        performTaskWhenRenderViewDidLoad(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.qui_component.QActionSheetView$dismiss$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                RenderView renderView = QActionSheetView.this.getRenderView();
                if (renderView != null) {
                    RenderView.b(renderView, "dismiss", null, null, 6, null);
                }
                return Unit.INSTANCE;
            }
        });
    }

    public final void show() {
        performTaskWhenRenderViewDidLoad(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.qui_component.QActionSheetView$show$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                RenderView renderView = QActionSheetView.this.getRenderView();
                if (renderView != null) {
                    RenderView.b(renderView, "show", null, null, 6, null);
                }
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final String viewName() {
        return "VasActionSheetView";
    }
}
