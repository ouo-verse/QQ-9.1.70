package com.tencent.hippykotlin.demo.pages.nearby.new_guide.view;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideTagCardView;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import f35.e;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.random.Random;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class NBPGuideTagCardView extends ComposeView<NBPGuideTagCardAttr, NBPGuideTagCardEvent> {
    public static final List<String> BACKGROUND_THEME_URLS;
    public static final List<String> EMOJI_URLS;
    public static final List<h> TAG_COLORS;
    public aa<NBPGuideTagShareCardView> guideTagShareCardViewRef;
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPGuideTagCardView.class, "themeBackgroundUrl", "getThemeBackgroundUrl()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPGuideTagCardView.class, "cardRealWidth", "getCardRealWidth()F", 0)};
    public static final Companion Companion = new Companion();
    public final ReadWriteProperty themeBackgroundUrl$delegate = c.a("");
    public final ReadWriteProperty cardRealWidth$delegate = c.a(Float.valueOf(372.0f));

    /* loaded from: classes31.dex */
    public static final class Companion {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPGuideTagCardAttr access$getAttr(NBPGuideTagCardView nBPGuideTagCardView) {
        return (NBPGuideTagCardAttr) nBPGuideTagCardView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        List mutableListOf;
        List listOf;
        List shuffled;
        List listOf2;
        List shuffled2;
        List list;
        List mutableList;
        NBPGuideTagCardAttr nBPGuideTagCardAttr = (NBPGuideTagCardAttr) getAttr();
        float f16 = 2;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new NBPGuideTagPosition((getCardRealWidth() - 200.0f) / f16, ((getCardRealHeight() - 36.0f) / f16) - (getCardRealHeight() * 0.09259259f), 1));
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new NBPGuideTagPosition[]{generateTagPosition$enumunboxing$(57, 49, 1), generateTagPosition$enumunboxing$(50, 43, 2), generateTagPosition$enumunboxing$(39, 95, 1), generateTagPosition$enumunboxing$(141, 113, 1), generateTagPosition$enumunboxing$(50, 137, 2)});
        shuffled = CollectionsKt__CollectionsJVMKt.shuffled(listOf);
        Iterator it = shuffled.iterator();
        while (it.hasNext()) {
            mutableListOf.add((NBPGuideTagPosition) it.next());
        }
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new NBPGuideTagPosition[]{generateTagPosition$enumunboxing$(153, 39, 1), generateTagPosition$enumunboxing$(43, 76, 2), generateTagPosition$enumunboxing$(56, 113, 2), generateTagPosition$enumunboxing$(39, 125, 1), generateTagPosition$enumunboxing$(60, 141, 1), generateTagPosition$enumunboxing$(135, 139, 1)});
        shuffled2 = CollectionsKt__CollectionsJVMKt.shuffled(listOf2);
        Iterator it5 = shuffled2.iterator();
        while (it5.hasNext()) {
            mutableListOf.add((NBPGuideTagPosition) it5.next());
        }
        list = CollectionsKt___CollectionsKt.toList(mutableListOf);
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list);
        nBPGuideTagCardAttr.setTagPositions(new com.tencent.kuikly.core.reactive.collection.c<>(mutableList, null, null, 6, null));
        this.cardRealWidth$delegate.setValue(this, $$delegatedProperties[1], Float.valueOf(Math.min(getPagerData().m(), 420.0f) - 48.0f));
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideTagCardView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final NBPGuideTagCardView nBPGuideTagCardView = NBPGuideTagCardView.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideTagCardView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        float m3 = mVar2.getPagerData().m();
                        NBPGuideTagCardView nBPGuideTagCardView2 = NBPGuideTagCardView.this;
                        NBPGuideTagCardView.Companion companion = NBPGuideTagCardView.Companion;
                        mVar2.size(m3, nBPGuideTagCardView2.getCardRealHeight());
                        mVar2.paddingLeft(24.0f);
                        mVar2.paddingRight(24.0f);
                        mVar2.allCenter();
                        final NBPGuideTagCardView nBPGuideTagCardView3 = NBPGuideTagCardView.this;
                        Function0<? extends Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideTagCardView.body.1.1.1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                NBPGuideTagCardAttr access$getAttr = NBPGuideTagCardView.access$getAttr(NBPGuideTagCardView.this);
                                return Integer.valueOf(((Number) access$getAttr.mainTagId$delegate.getValue(access$getAttr, NBPGuideTagCardAttr.$$delegatedProperties[0])).intValue());
                            }
                        };
                        final NBPGuideTagCardView nBPGuideTagCardView4 = NBPGuideTagCardView.this;
                        mVar2.bindValueChange(function0, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideTagCardView.body.1.1.2
                            {
                                super(1);
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            /* JADX WARN: Removed duplicated region for block: B:21:0x006c  */
                            @Override // kotlin.jvm.functions.Function1
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                            */
                            public final Unit invoke(Object obj) {
                                Object randomOrNull;
                                List listOf3;
                                Object random;
                                Object random2;
                                Object obj2;
                                List<String> list2;
                                Object firstOrNull;
                                List<e> list3 = NBPGuideTagCardView.access$getAttr(NBPGuideTagCardView.this).tagSpecificIconList;
                                String str = null;
                                if (list3 != null) {
                                    NBPGuideTagCardView nBPGuideTagCardView5 = NBPGuideTagCardView.this;
                                    Iterator<T> it6 = list3.iterator();
                                    while (true) {
                                        if (!it6.hasNext()) {
                                            obj2 = null;
                                            break;
                                        }
                                        obj2 = it6.next();
                                        int i3 = ((e) obj2).f397795d;
                                        NBPGuideTagCardAttr access$getAttr = NBPGuideTagCardView.access$getAttr(nBPGuideTagCardView5);
                                        if (i3 == ((Number) access$getAttr.mainTagId$delegate.getValue(access$getAttr, NBPGuideTagCardAttr.$$delegatedProperties[0])).intValue()) {
                                            break;
                                        }
                                    }
                                    e eVar = (e) obj2;
                                    if (eVar != null && (list2 = eVar.f397796e) != null) {
                                        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list2);
                                        String str2 = (String) firstOrNull;
                                        if (str2 != null) {
                                            str = str2;
                                            NBPGuideTagCardAttr access$getAttr2 = NBPGuideTagCardView.access$getAttr(NBPGuideTagCardView.this);
                                            if (str == null) {
                                                NBPGuideTagCardView.Companion.getClass();
                                                random2 = CollectionsKt___CollectionsKt.random(NBPGuideTagCardView.EMOJI_URLS, Random.INSTANCE);
                                                str = (String) random2;
                                            }
                                            access$getAttr2.setEmojiUrl(str);
                                            NBPGuideTagCardAttr access$getAttr3 = NBPGuideTagCardView.access$getAttr(NBPGuideTagCardView.this);
                                            NBPGuideTagCardView nBPGuideTagCardView6 = NBPGuideTagCardView.this;
                                            nBPGuideTagCardView6.getClass();
                                            listOf3 = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{new Pair(Float.valueOf(nBPGuideTagCardView6.getCardRealWidth() * 0.28134558f), Float.valueOf(0.0f)), new Pair(Float.valueOf(nBPGuideTagCardView6.getCardRealWidth() * 0.42507645f), Float.valueOf(0.0f)), new Pair(Float.valueOf(nBPGuideTagCardView6.getCardRealWidth() * 0.57186544f), Float.valueOf(0.0f)), new Pair(Float.valueOf(nBPGuideTagCardView6.getCardRealWidth() * 0.71865445f), Float.valueOf(0.0f)), new Pair(Float.valueOf(nBPGuideTagCardView6.getCardRealWidth() * 0.853211f), Float.valueOf(nBPGuideTagCardView6.getCardRealHeight() * 0.2962963f)), new Pair(Float.valueOf(nBPGuideTagCardView6.getCardRealWidth() * 0.853211f), Float.valueOf(nBPGuideTagCardView6.getCardRealHeight() * 0.5185185f)), new Pair(Float.valueOf(nBPGuideTagCardView6.getCardRealWidth() * 0.853211f), Float.valueOf(nBPGuideTagCardView6.getCardRealHeight() * 0.7407407f)), new Pair(Float.valueOf(nBPGuideTagCardView6.getCardRealWidth() * 0.70642203f), Float.valueOf(nBPGuideTagCardView6.getCardRealHeight() * 0.7407407f)), new Pair(Float.valueOf(nBPGuideTagCardView6.getCardRealWidth() * 0.559633f), Float.valueOf(nBPGuideTagCardView6.getCardRealHeight() * 0.7407407f)), new Pair(Float.valueOf(nBPGuideTagCardView6.getCardRealWidth() * 0.26911315f), Float.valueOf(nBPGuideTagCardView6.getCardRealHeight() * 0.7407407f)), new Pair(Float.valueOf(nBPGuideTagCardView6.getCardRealWidth() * 0.14678898f), Float.valueOf(nBPGuideTagCardView6.getCardRealHeight() * 0.7407407f)), new Pair(Float.valueOf(nBPGuideTagCardView6.getCardRealWidth() * 0.0f), Float.valueOf(nBPGuideTagCardView6.getCardRealHeight() * 0.7407407f)), new Pair(Float.valueOf(nBPGuideTagCardView6.getCardRealWidth() * 0.0f), Float.valueOf(nBPGuideTagCardView6.getCardRealHeight() * 0.5185185f)), new Pair(Float.valueOf(nBPGuideTagCardView6.getCardRealWidth() * 0.0f), Float.valueOf(nBPGuideTagCardView6.getCardRealHeight() * 0.2962963f))});
                                            Random.Companion companion2 = Random.INSTANCE;
                                            random = CollectionsKt___CollectionsKt.random(listOf3, companion2);
                                            access$getAttr3.setEmojiPosition((Pair) random);
                                            NBPGuideTagCardAttr access$getAttr4 = NBPGuideTagCardView.access$getAttr(NBPGuideTagCardView.this);
                                            NBPGuideTagCardView.this.getClass();
                                            access$getAttr4.setEmojiRotation(companion2.nextInt(-30, 30));
                                            NBPGuideTagCardAttr access$getAttr5 = NBPGuideTagCardView.access$getAttr(NBPGuideTagCardView.this);
                                            List<String> list4 = NBPGuideTagCardView.BACKGROUND_THEME_URLS;
                                            access$getAttr5.themeIndex$delegate.setValue(access$getAttr5, NBPGuideTagCardAttr.$$delegatedProperties[1], Integer.valueOf(companion2.nextInt(0, list4.size())));
                                            NBPGuideTagCardView nBPGuideTagCardView7 = NBPGuideTagCardView.this;
                                            nBPGuideTagCardView7.themeBackgroundUrl$delegate.setValue(nBPGuideTagCardView7, NBPGuideTagCardView.$$delegatedProperties[0], list4.get(NBPGuideTagCardView.access$getAttr(nBPGuideTagCardView7).getThemeIndex()));
                                            NBPGuideTagCardAttr access$getAttr6 = NBPGuideTagCardView.access$getAttr(NBPGuideTagCardView.this);
                                            NBPGuideTagCardView.Companion.getClass();
                                            access$getAttr6.setTagColor(NBPGuideTagCardView.TAG_COLORS.get(NBPGuideTagCardView.access$getAttr(NBPGuideTagCardView.this).getThemeIndex()));
                                            ((NBPGuideTagCardEvent) NBPGuideTagCardView.this.getViewEvent()).getClass();
                                            return Unit.INSTANCE;
                                        }
                                    }
                                }
                                List<String> list5 = NBPGuideTagCardView.access$getAttr(NBPGuideTagCardView.this).tagCommonIconList;
                                if (list5 != null) {
                                    randomOrNull = CollectionsKt___CollectionsKt.randomOrNull(list5, Random.INSTANCE);
                                    str = (String) randomOrNull;
                                }
                                NBPGuideTagCardAttr access$getAttr22 = NBPGuideTagCardView.access$getAttr(NBPGuideTagCardView.this);
                                if (str == null) {
                                }
                                access$getAttr22.setEmojiUrl(str);
                                NBPGuideTagCardAttr access$getAttr32 = NBPGuideTagCardView.access$getAttr(NBPGuideTagCardView.this);
                                NBPGuideTagCardView nBPGuideTagCardView62 = NBPGuideTagCardView.this;
                                nBPGuideTagCardView62.getClass();
                                listOf3 = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{new Pair(Float.valueOf(nBPGuideTagCardView62.getCardRealWidth() * 0.28134558f), Float.valueOf(0.0f)), new Pair(Float.valueOf(nBPGuideTagCardView62.getCardRealWidth() * 0.42507645f), Float.valueOf(0.0f)), new Pair(Float.valueOf(nBPGuideTagCardView62.getCardRealWidth() * 0.57186544f), Float.valueOf(0.0f)), new Pair(Float.valueOf(nBPGuideTagCardView62.getCardRealWidth() * 0.71865445f), Float.valueOf(0.0f)), new Pair(Float.valueOf(nBPGuideTagCardView62.getCardRealWidth() * 0.853211f), Float.valueOf(nBPGuideTagCardView62.getCardRealHeight() * 0.2962963f)), new Pair(Float.valueOf(nBPGuideTagCardView62.getCardRealWidth() * 0.853211f), Float.valueOf(nBPGuideTagCardView62.getCardRealHeight() * 0.5185185f)), new Pair(Float.valueOf(nBPGuideTagCardView62.getCardRealWidth() * 0.853211f), Float.valueOf(nBPGuideTagCardView62.getCardRealHeight() * 0.7407407f)), new Pair(Float.valueOf(nBPGuideTagCardView62.getCardRealWidth() * 0.70642203f), Float.valueOf(nBPGuideTagCardView62.getCardRealHeight() * 0.7407407f)), new Pair(Float.valueOf(nBPGuideTagCardView62.getCardRealWidth() * 0.559633f), Float.valueOf(nBPGuideTagCardView62.getCardRealHeight() * 0.7407407f)), new Pair(Float.valueOf(nBPGuideTagCardView62.getCardRealWidth() * 0.26911315f), Float.valueOf(nBPGuideTagCardView62.getCardRealHeight() * 0.7407407f)), new Pair(Float.valueOf(nBPGuideTagCardView62.getCardRealWidth() * 0.14678898f), Float.valueOf(nBPGuideTagCardView62.getCardRealHeight() * 0.7407407f)), new Pair(Float.valueOf(nBPGuideTagCardView62.getCardRealWidth() * 0.0f), Float.valueOf(nBPGuideTagCardView62.getCardRealHeight() * 0.7407407f)), new Pair(Float.valueOf(nBPGuideTagCardView62.getCardRealWidth() * 0.0f), Float.valueOf(nBPGuideTagCardView62.getCardRealHeight() * 0.5185185f)), new Pair(Float.valueOf(nBPGuideTagCardView62.getCardRealWidth() * 0.0f), Float.valueOf(nBPGuideTagCardView62.getCardRealHeight() * 0.2962963f))});
                                Random.Companion companion22 = Random.INSTANCE;
                                random = CollectionsKt___CollectionsKt.random(listOf3, companion22);
                                access$getAttr32.setEmojiPosition((Pair) random);
                                NBPGuideTagCardAttr access$getAttr42 = NBPGuideTagCardView.access$getAttr(NBPGuideTagCardView.this);
                                NBPGuideTagCardView.this.getClass();
                                access$getAttr42.setEmojiRotation(companion22.nextInt(-30, 30));
                                NBPGuideTagCardAttr access$getAttr52 = NBPGuideTagCardView.access$getAttr(NBPGuideTagCardView.this);
                                List<String> list42 = NBPGuideTagCardView.BACKGROUND_THEME_URLS;
                                access$getAttr52.themeIndex$delegate.setValue(access$getAttr52, NBPGuideTagCardAttr.$$delegatedProperties[1], Integer.valueOf(companion22.nextInt(0, list42.size())));
                                NBPGuideTagCardView nBPGuideTagCardView72 = NBPGuideTagCardView.this;
                                nBPGuideTagCardView72.themeBackgroundUrl$delegate.setValue(nBPGuideTagCardView72, NBPGuideTagCardView.$$delegatedProperties[0], list42.get(NBPGuideTagCardView.access$getAttr(nBPGuideTagCardView72).getThemeIndex()));
                                NBPGuideTagCardAttr access$getAttr62 = NBPGuideTagCardView.access$getAttr(NBPGuideTagCardView.this);
                                NBPGuideTagCardView.Companion.getClass();
                                access$getAttr62.setTagColor(NBPGuideTagCardView.TAG_COLORS.get(NBPGuideTagCardView.access$getAttr(NBPGuideTagCardView.this).getThemeIndex()));
                                ((NBPGuideTagCardEvent) NBPGuideTagCardView.this.getViewEvent()).getClass();
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPGuideTagCardView nBPGuideTagCardView2 = NBPGuideTagCardView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideTagCardView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final NBPGuideTagCardView nBPGuideTagCardView3 = NBPGuideTagCardView.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideTagCardView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                NBPGuideTagCardView nBPGuideTagCardView4 = NBPGuideTagCardView.this;
                                NBPGuideTagCardView.Companion companion = NBPGuideTagCardView.Companion;
                                tVar.size(nBPGuideTagCardView4.getCardRealWidth(), NBPGuideTagCardView.this.getCardRealHeight());
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPGuideTagCardView nBPGuideTagCardView4 = NBPGuideTagCardView.this;
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideTagCardView.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                final NBPGuideTagCardView nBPGuideTagCardView5 = NBPGuideTagCardView.this;
                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideTagCardView.body.1.2.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        af afVar2 = afVar;
                                        afVar2.absolutePositionAllZero();
                                        NBPGuideTagCardView nBPGuideTagCardView6 = NBPGuideTagCardView.this;
                                        b.a.b(afVar2, (String) nBPGuideTagCardView6.themeBackgroundUrl$delegate.getValue(nBPGuideTagCardView6, NBPGuideTagCardView.$$delegatedProperties[0]), false, 2, null);
                                        afVar2.borderRadius(16.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPGuideTagCardView nBPGuideTagCardView5 = NBPGuideTagCardView.this;
                        vVar2.addChild(new NBPGuideTagBaseCardView(), new Function1<NBPGuideTagBaseCardView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideTagCardView.body.1.2.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPGuideTagBaseCardView nBPGuideTagBaseCardView) {
                                final NBPGuideTagCardView nBPGuideTagCardView6 = NBPGuideTagCardView.this;
                                nBPGuideTagBaseCardView.attr(new Function1<NBPGuideTagBaseCardAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideTagCardView.body.1.2.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(NBPGuideTagBaseCardAttr nBPGuideTagBaseCardAttr) {
                                        NBPGuideTagBaseCardAttr nBPGuideTagBaseCardAttr2 = nBPGuideTagBaseCardAttr;
                                        nBPGuideTagBaseCardAttr2.setTagList(NBPGuideTagCardView.access$getAttr(NBPGuideTagCardView.this).getTagList());
                                        nBPGuideTagBaseCardAttr2.setEmojiPosition(NBPGuideTagCardView.access$getAttr(NBPGuideTagCardView.this).getEmojiPosition());
                                        nBPGuideTagBaseCardAttr2.setTagColor(NBPGuideTagCardView.access$getAttr(NBPGuideTagCardView.this).getTagColor());
                                        nBPGuideTagBaseCardAttr2.setEmojiUrl(NBPGuideTagCardView.access$getAttr(NBPGuideTagCardView.this).getEmojiUrl());
                                        nBPGuideTagBaseCardAttr2.setTagPositions(NBPGuideTagCardView.access$getAttr(NBPGuideTagCardView.this).getTagPositions());
                                        nBPGuideTagBaseCardAttr2.setEmojiRotation(NBPGuideTagCardView.access$getAttr(NBPGuideTagCardView.this).getEmojiRotation());
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPGuideTagCardView nBPGuideTagCardView3 = NBPGuideTagCardView.this;
                viewContainer2.addChild(new NBPGuideTagShareCardView(), new Function1<NBPGuideTagShareCardView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideTagCardView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(NBPGuideTagShareCardView nBPGuideTagShareCardView) {
                        NBPGuideTagShareCardView nBPGuideTagShareCardView2 = nBPGuideTagShareCardView;
                        final NBPGuideTagCardView nBPGuideTagCardView4 = NBPGuideTagCardView.this;
                        nBPGuideTagShareCardView2.ref(nBPGuideTagShareCardView2, new Function1<aa<NBPGuideTagShareCardView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideTagCardView.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(aa<NBPGuideTagShareCardView> aaVar) {
                                NBPGuideTagCardView.this.guideTagShareCardViewRef = aaVar;
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPGuideTagCardView nBPGuideTagCardView5 = NBPGuideTagCardView.this;
                        nBPGuideTagShareCardView2.attr(new Function1<NBPGuideTagShareCardAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideTagCardView.body.1.3.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPGuideTagShareCardAttr nBPGuideTagShareCardAttr) {
                                NBPGuideTagShareCardAttr nBPGuideTagShareCardAttr2 = nBPGuideTagShareCardAttr;
                                nBPGuideTagShareCardAttr2.positionAbsolute();
                                Attr.absolutePosition$default(nBPGuideTagShareCardAttr2, 0.0f, nBPGuideTagShareCardAttr2.getPagerData().m() * 2, 0.0f, 0.0f, 13, null);
                                nBPGuideTagShareCardAttr2.setTagList(NBPGuideTagCardView.access$getAttr(NBPGuideTagCardView.this).getTagList());
                                nBPGuideTagShareCardAttr2.setEmojiPosition(NBPGuideTagCardView.access$getAttr(NBPGuideTagCardView.this).getEmojiPosition());
                                nBPGuideTagShareCardAttr2.setEmojiRotation(NBPGuideTagCardView.access$getAttr(NBPGuideTagCardView.this).getEmojiRotation());
                                nBPGuideTagShareCardAttr2.themeIndex$delegate.setValue(nBPGuideTagShareCardAttr2, NBPGuideTagShareCardAttr.$$delegatedProperties[0], Integer.valueOf(NBPGuideTagCardView.access$getAttr(NBPGuideTagCardView.this).getThemeIndex()));
                                nBPGuideTagShareCardAttr2.setTagColor(NBPGuideTagCardView.access$getAttr(NBPGuideTagCardView.this).getTagColor());
                                nBPGuideTagShareCardAttr2.setEmojiUrl(NBPGuideTagCardView.access$getAttr(NBPGuideTagCardView.this).getEmojiUrl());
                                nBPGuideTagShareCardAttr2.setTagPositions(NBPGuideTagCardView.access$getAttr(NBPGuideTagCardView.this).getTagPositions());
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
        return new NBPGuideTagCardAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPGuideTagCardEvent();
    }

    public final NBPGuideTagPosition generateTagPosition$enumunboxing$(int i3, int i16, int i17) {
        Random.Companion companion = Random.INSTANCE;
        return new NBPGuideTagPosition(getCardRealWidth() * (companion.nextInt(i3 - 5, i3 + 5) / 327.0f), getCardRealHeight() * (companion.nextInt(i16 - 5, i16 + 5) / 216.0f), i17);
    }

    public final float getCardRealHeight() {
        return (getCardRealWidth() * 216.0f) / 327.0f;
    }

    public final float getCardRealWidth() {
        return ((Number) this.cardRealWidth$delegate.getValue(this, $$delegatedProperties[1])).floatValue();
    }

    static {
        List<String> listOf;
        List<String> listOf2;
        List<h> listOf3;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_-_HMrGc3CL9.png", "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_p1NbexUO_-k.png", "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_DM2PCh8PmFp.png", "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_oPwk8cry317.png", "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_sTb5M8VBwoH.png"});
        BACKGROUND_THEME_URLS = listOf;
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_EqnOIh-6gfM.png", "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_D_kxKdksXJe.png", "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_q4zsV1YVvMx.png", "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_1nsZ5WJ1xPP.png"});
        EMOJI_URLS = listOf2;
        listOf3 = CollectionsKt__CollectionsKt.listOf((Object[]) new h[]{new h(6640111L, 1.0f), new h(15428143L, 1.0f), new h(2861823L, 1.0f), new h(15314455L, 1.0f), new h(375674L, 1.0f)});
        TAG_COLORS = listOf3;
    }
}
