package com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view;

import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.TagViewAttr;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.layout.FlexWrap;
import com.tencent.kuikly.core.views.ImageEvent;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class SelectedTagView extends ComposeView<TagViewAttr, SelectedTagEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ TagViewAttr access$getAttr(SelectedTagView selectedTagView) {
        return (TagViewAttr) selectedTagView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.SelectedTagView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.SelectedTagView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.borderRadius(4.0f);
                        mVar2.mo113backgroundColor(new h(443832831L));
                        mVar2.mo141height(32.0f);
                        mVar2.margin(6.0f);
                        mVar2.flexDirectionRow();
                        mVar2.alignItemsCenter();
                        mVar2.flexWrap(FlexWrap.WRAP);
                        return Unit.INSTANCE;
                    }
                });
                final SelectedTagView selectedTagView = SelectedTagView.this;
                cg.a(viewContainer2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.SelectedTagView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        final SelectedTagView selectedTagView2 = SelectedTagView.this;
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.SelectedTagView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                ce ceVar2 = ceVar;
                                ceVar2.marginLeft(8.0f);
                                ceVar2.text(SelectedTagView.access$getAttr(SelectedTagView.this).getTag().tag.f435363e);
                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                ceVar2.fontWeight500();
                                ceVar2.color(new h(4285815295L));
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final SelectedTagView selectedTagView2 = SelectedTagView.this;
                ah.a(viewContainer2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.SelectedTagView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ImageView imageView) {
                        ImageView imageView2 = imageView;
                        imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.SelectedTagView.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(af afVar) {
                                af afVar2 = afVar;
                                afVar2.size(12.0f, 12.0f);
                                b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_igs3LjZQCen.png", false, 2, null);
                                afVar2.t(new h(4285815295L));
                                afVar2.margin(0.0f, 4.0f, 0.0f, 10.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final SelectedTagView selectedTagView3 = SelectedTagView.this;
                        imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.SelectedTagView.body.1.3.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageEvent imageEvent) {
                                final SelectedTagView selectedTagView4 = SelectedTagView.this;
                                imageEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.SelectedTagView.body.1.3.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        SelectedTagView selectedTagView5 = SelectedTagView.this;
                                        selectedTagView5.emit("delete", SelectedTagView.access$getAttr(selectedTagView5));
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new TagViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new SelectedTagEvent();
    }
}
