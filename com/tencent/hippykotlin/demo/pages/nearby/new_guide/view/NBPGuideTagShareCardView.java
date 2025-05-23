package com.tencent.hippykotlin.demo.pages.nearby.new_guide.view;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.QQComposeViewExtCreator$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporterKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.ImageEvent;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.LoadSuccessParams;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class NBPGuideTagShareCardView extends ComposeView<NBPGuideTagShareCardAttr, NBPGuideTagShareCardEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPGuideTagShareCardView.class, "themeBackgroundUrl", "getThemeBackgroundUrl()Ljava/lang/String;", 0)};
    public static final List<String> BACKGROUND_SHARE_THEME_URLS;
    public boolean isBaseResLoaded;
    public boolean isBgResLoaded;
    public Integer sharedViewTag;
    public final ReadWriteProperty themeBackgroundUrl$delegate = c.a("");

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPGuideTagShareCardAttr access$getAttr(NBPGuideTagShareCardView nBPGuideTagShareCardView) {
        return (NBPGuideTagShareCardAttr) nBPGuideTagShareCardView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideTagShareCardView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                NBPGuideTagShareCardView.this.sharedViewTag = Integer.valueOf(viewContainer2.getNativeRef());
                final NBPGuideTagShareCardView nBPGuideTagShareCardView = NBPGuideTagShareCardView.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideTagShareCardView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        NBPGuideTagShareCardView nBPGuideTagShareCardView2 = NBPGuideTagShareCardView.this;
                        KProperty<Object>[] kPropertyArr = NBPGuideTagShareCardView.$$delegatedProperties;
                        mVar2.size(Math.min(nBPGuideTagShareCardView2.getPagerData().m(), 420.0f) - 48.0f, NBPGuideTagShareCardView.this.getCardRealHeight());
                        mVar2.alignItemsCenter();
                        mVar2.mo113backgroundColor(h.INSTANCE.j());
                        final NBPGuideTagShareCardView nBPGuideTagShareCardView3 = NBPGuideTagShareCardView.this;
                        Function0<? extends Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideTagShareCardView.body.1.1.1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                NBPGuideTagShareCardAttr access$getAttr = NBPGuideTagShareCardView.access$getAttr(NBPGuideTagShareCardView.this);
                                return Integer.valueOf(((Number) access$getAttr.themeIndex$delegate.getValue(access$getAttr, NBPGuideTagShareCardAttr.$$delegatedProperties[0])).intValue());
                            }
                        };
                        final NBPGuideTagShareCardView nBPGuideTagShareCardView4 = NBPGuideTagShareCardView.this;
                        mVar2.bindValueChange(function0, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideTagShareCardView.body.1.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(Object obj) {
                                NBPGuideTagShareCardView nBPGuideTagShareCardView5 = NBPGuideTagShareCardView.this;
                                nBPGuideTagShareCardView5.isBgResLoaded = false;
                                List<String> list = NBPGuideTagShareCardView.BACKGROUND_SHARE_THEME_URLS;
                                NBPGuideTagShareCardAttr access$getAttr = NBPGuideTagShareCardView.access$getAttr(nBPGuideTagShareCardView5);
                                nBPGuideTagShareCardView5.themeBackgroundUrl$delegate.setValue(nBPGuideTagShareCardView5, NBPGuideTagShareCardView.$$delegatedProperties[0], list.get(((Number) access$getAttr.themeIndex$delegate.getValue(access$getAttr, NBPGuideTagShareCardAttr.$$delegatedProperties[0])).intValue()));
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPGuideTagShareCardView nBPGuideTagShareCardView2 = NBPGuideTagShareCardView.this;
                ah.a(viewContainer2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideTagShareCardView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ImageView imageView) {
                        ImageView imageView2 = imageView;
                        final NBPGuideTagShareCardView nBPGuideTagShareCardView3 = NBPGuideTagShareCardView.this;
                        imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideTagShareCardView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(af afVar) {
                                af afVar2 = afVar;
                                afVar2.absolutePositionAllZero();
                                NBPGuideTagShareCardView nBPGuideTagShareCardView4 = NBPGuideTagShareCardView.this;
                                b.a.b(afVar2, (String) nBPGuideTagShareCardView4.themeBackgroundUrl$delegate.getValue(nBPGuideTagShareCardView4, NBPGuideTagShareCardView.$$delegatedProperties[0]), false, 2, null);
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPGuideTagShareCardView nBPGuideTagShareCardView4 = NBPGuideTagShareCardView.this;
                        imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideTagShareCardView.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageEvent imageEvent) {
                                final NBPGuideTagShareCardView nBPGuideTagShareCardView5 = NBPGuideTagShareCardView.this;
                                imageEvent.j(new Function1<LoadSuccessParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideTagShareCardView.body.1.2.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(LoadSuccessParams loadSuccessParams) {
                                        NBPGuideTagShareCardView.this.isBgResLoaded = true;
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPGuideTagShareCardView nBPGuideTagShareCardView3 = NBPGuideTagShareCardView.this;
                cg.a(viewContainer2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideTagShareCardView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        final NBPGuideTagShareCardView nBPGuideTagShareCardView4 = NBPGuideTagShareCardView.this;
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideTagShareCardView.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                ce ceVar2 = ceVar;
                                ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                ceVar2.color(h.INSTANCE.b());
                                ceVar2.fontWeight500();
                                ceVar2.text("\u6211\u7684\u5174\u8da3\u6210\u5206\u5361");
                                NBPGuideTagShareCardView nBPGuideTagShareCardView5 = NBPGuideTagShareCardView.this;
                                KProperty<Object>[] kPropertyArr = NBPGuideTagShareCardView.$$delegatedProperties;
                                ceVar2.marginTop(nBPGuideTagShareCardView5.getCardRealHeight() * 0.121212125f);
                                ceVar2.m154zIndex(2);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPGuideTagShareCardView nBPGuideTagShareCardView4 = NBPGuideTagShareCardView.this;
                viewContainer2.addChild(new NBPGuideTagBaseCardView(), new Function1<NBPGuideTagBaseCardView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideTagShareCardView$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(NBPGuideTagBaseCardView nBPGuideTagBaseCardView) {
                        NBPGuideTagBaseCardView nBPGuideTagBaseCardView2 = nBPGuideTagBaseCardView;
                        final NBPGuideTagShareCardView nBPGuideTagShareCardView5 = NBPGuideTagShareCardView.this;
                        nBPGuideTagBaseCardView2.attr(new Function1<NBPGuideTagBaseCardAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideTagShareCardView.body.1.4.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPGuideTagBaseCardAttr nBPGuideTagBaseCardAttr) {
                                NBPGuideTagBaseCardAttr nBPGuideTagBaseCardAttr2 = nBPGuideTagBaseCardAttr;
                                nBPGuideTagBaseCardAttr2.positionAbsolute();
                                NBPGuideTagShareCardView nBPGuideTagShareCardView6 = NBPGuideTagShareCardView.this;
                                KProperty<Object>[] kPropertyArr = NBPGuideTagShareCardView.$$delegatedProperties;
                                nBPGuideTagBaseCardAttr2.m150top(nBPGuideTagShareCardView6.getCardRealHeight() * 0.22727273f);
                                nBPGuideTagBaseCardAttr2.m142left(0.0f);
                                nBPGuideTagBaseCardAttr2.m154zIndex(1);
                                nBPGuideTagBaseCardAttr2.setTagList(NBPGuideTagShareCardView.access$getAttr(NBPGuideTagShareCardView.this).getTagList());
                                nBPGuideTagBaseCardAttr2.setEmojiPosition(NBPGuideTagShareCardView.access$getAttr(NBPGuideTagShareCardView.this).getEmojiPosition());
                                nBPGuideTagBaseCardAttr2.setEmojiRotation(NBPGuideTagShareCardView.access$getAttr(NBPGuideTagShareCardView.this).getEmojiRotation());
                                nBPGuideTagBaseCardAttr2.setTagColor(NBPGuideTagShareCardView.access$getAttr(NBPGuideTagShareCardView.this).getTagColor());
                                nBPGuideTagBaseCardAttr2.setEmojiUrl(NBPGuideTagShareCardView.access$getAttr(NBPGuideTagShareCardView.this).getEmojiUrl());
                                nBPGuideTagBaseCardAttr2.setTagPositions(NBPGuideTagShareCardView.access$getAttr(NBPGuideTagShareCardView.this).getTagPositions());
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPGuideTagShareCardView nBPGuideTagShareCardView6 = NBPGuideTagShareCardView.this;
                        nBPGuideTagBaseCardView2.event(new Function1<NBPGuideTagBaseCardEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideTagShareCardView.body.1.4.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPGuideTagBaseCardEvent nBPGuideTagBaseCardEvent) {
                                final NBPGuideTagShareCardView nBPGuideTagShareCardView7 = NBPGuideTagShareCardView.this;
                                nBPGuideTagBaseCardEvent.resLoadedEventHandler = new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideTagShareCardView.body.1.4.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Boolean bool) {
                                        NBPGuideTagShareCardView.this.isBaseResLoaded = bool.booleanValue();
                                        return Unit.INSTANCE;
                                    }
                                };
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
        return new NBPGuideTagShareCardAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPGuideTagShareCardEvent();
    }

    public final float getCardRealHeight() {
        return ((Math.min(getPagerData().m(), 420.0f) - 48.0f) * 528.0f) / 396.0f;
    }

    public final void getSharePhotoPath(final Function1<? super String, Unit> function1, final int i3) {
        Unit unit;
        if (!this.isBaseResLoaded || !this.isBgResLoaded) {
            if (i3 > 5) {
                function1.invoke(null);
                return;
            } else {
                TimerKt.d(1000, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideTagShareCardView$getSharePhotoPath$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        NBPGuideTagShareCardView.this.getSharePhotoPath(function1, i3 + 1);
                        return Unit.INSTANCE;
                    }
                });
                return;
            }
        }
        Integer num = this.sharedViewTag;
        if (num != null) {
            QQNearbyModule.Companion.getInstance().viewToImage(num.intValue(), QQComposeViewExtCreator$$ExternalSyntheticOutline0.m("QQ_NEARBY_GUIDE_PUBLISH_", Utils.INSTANCE.calendarModule(getPagerId()).formatTime(APICallTechReporterKt.NBPCurrentTime()), ".png"), false, function1);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            function1.invoke(null);
        }
    }

    static {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_lHxUagUV71c.png", "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_De0S1V8FI1O.png", "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_xyoIxLUQh61.png", "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_3oPNp3VKJ4X.png", "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_rL2F16YlcKT.png"});
        BACKGROUND_SHARE_THEME_URLS = listOf;
    }
}
