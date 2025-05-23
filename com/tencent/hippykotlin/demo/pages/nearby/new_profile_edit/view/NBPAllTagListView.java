package com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.FastClickUtils;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.data.TagInfo;
import com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view_model.NBPTagsEditViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view_model.TagTabObservable;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.b;
import com.tencent.kuikly.core.base.event.AnimationCompletionParams;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.FrameEventKt;
import com.tencent.kuikly.core.base.event.PanGestureParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.layout.FlexWrap;
import com.tencent.kuikly.core.layout.d;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.ScrollParams;
import com.tencent.kuikly.core.views.ScrollerAttr;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ao;
import com.tencent.kuikly.core.views.ap;
import com.tencent.kuikly.core.views.aq;
import com.tencent.kuikly.core.views.ar;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import t35.a;

/* loaded from: classes31.dex */
public final class NBPAllTagListView extends ComposeView<NBPAllTagsAttr, NBPAllTagsEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPAllTagListView.class, "shouldAnimate", "getShouldAnimate()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPAllTagListView.class, "topValue", "getTopValue()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPAllTagListView.class, "animateTopValue", "getAnimateTopValue()F", 0)};
    public final ReadWriteProperty animateTopValue$delegate;
    public boolean expanded;
    public final FastClickUtils fastClickUtils;
    public final ReadWriteProperty shouldAnimate$delegate = c.a(Boolean.FALSE);
    public final ReadWriteProperty topValue$delegate;

    public NBPAllTagListView() {
        Float valueOf = Float.valueOf(0.0f);
        this.topValue$delegate = c.a(valueOf);
        this.animateTopValue$delegate = c.a(valueOf);
        this.fastClickUtils = new FastClickUtils(500L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPAllTagsAttr access$getAttr(NBPAllTagListView nBPAllTagListView) {
        return (NBPAllTagsAttr) nBPAllTagListView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPAllTagListView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final NBPAllTagListView nBPAllTagListView = NBPAllTagListView.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPAllTagListView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        float floatValue;
                        m mVar2 = mVar;
                        mVar2.mo113backgroundColor(QUIToken.color$default("bg_bottom_standard"));
                        mVar2.flexDirectionColumn();
                        mVar2.mo153width(mVar2.getPagerData().m());
                        NBPAllTagListView nBPAllTagListView2 = NBPAllTagListView.this;
                        if (!((Boolean) nBPAllTagListView2.shouldAnimate$delegate.getValue(nBPAllTagListView2, NBPAllTagListView.$$delegatedProperties[0])).booleanValue()) {
                            floatValue = ((Number) r0.topValue$delegate.getValue(NBPAllTagListView.this, NBPAllTagListView.$$delegatedProperties[1])).floatValue();
                            mVar2.m150top(floatValue);
                        } else {
                            mVar2.m150top(NBPAllTagListView.this.getAnimateTopValue());
                        }
                        mVar2.m138bottom(0.0f);
                        mVar2.mo141height(mVar2.getPagerData().l() * 0.8f);
                        mVar2.animate(b.Companion.l(b.INSTANCE, 0.1f, null, 2, null), Float.valueOf(NBPAllTagListView.this.getAnimateTopValue()));
                        return Unit.INSTANCE;
                    }
                });
                final NBPAllTagListView nBPAllTagListView2 = NBPAllTagListView.this;
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPAllTagListView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        final NBPAllTagListView nBPAllTagListView3 = NBPAllTagListView.this;
                        event.animationCompletion(new Function1<AnimationCompletionParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPAllTagListView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(AnimationCompletionParams animationCompletionParams) {
                                float floatValue;
                                r4.shouldAnimate$delegate.setValue(NBPAllTagListView.this, NBPAllTagListView.$$delegatedProperties[0], Boolean.valueOf(false));
                                float l3 = NBPAllTagListView.this.getPagerData().l() * 0.2f;
                                floatValue = ((Number) r1.topValue$delegate.getValue(NBPAllTagListView.this, NBPAllTagListView.$$delegatedProperties[1])).floatValue();
                                if (floatValue == l3) {
                                    NBPAllTagListView.this.emit("expand", Boolean.TRUE);
                                    NBPAllTagListView.this.expanded = true;
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPAllTagListView nBPAllTagListView3 = NBPAllTagListView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPAllTagListView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPAllTagListView.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.borderRadius(8.0f, 8.0f, 0.0f, 0.0f);
                                tVar2.size(tVar2.getPagerData().m(), 36.0f);
                                tVar2.mo113backgroundColor(QUIToken.color$default("bg_middle_light"));
                                tVar2.allCenter();
                                tVar2.m151touchEnable(true);
                                return Unit.INSTANCE;
                            }
                        });
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPAllTagListView.body.1.3.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPAllTagListView.body.1.3.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.size(36.0f, 5.0f);
                                        tVar2.borderRadius(3.0f);
                                        tVar2.mo113backgroundColor(QUIToken.color$default("fill_standard_secondary"));
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPAllTagListView nBPAllTagListView4 = NBPAllTagListView.this;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPAllTagListView.body.1.3.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final NBPAllTagListView nBPAllTagListView5 = NBPAllTagListView.this;
                                uVar.pan(new Function1<PanGestureParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPAllTagListView.body.1.3.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(PanGestureParams panGestureParams) {
                                        float floatValue;
                                        float floatValue2;
                                        PanGestureParams panGestureParams2 = panGestureParams;
                                        float l3 = NBPAllTagListView.this.getPagerData().l() - NBPAllTagListView.access$getAttr(NBPAllTagListView.this).initHeight;
                                        float l16 = NBPAllTagListView.this.getPagerData().l() * 0.2f;
                                        float f16 = (l3 + l16) / 2;
                                        String state = panGestureParams2.getState();
                                        int hashCode = state.hashCode();
                                        if (hashCode != 100571) {
                                            if (hashCode != 3357649) {
                                                if (hashCode == 109757538 && state.equals("start")) {
                                                    r8.shouldAnimate$delegate.setValue(NBPAllTagListView.this, NBPAllTagListView.$$delegatedProperties[0], Boolean.valueOf(false));
                                                }
                                            } else if (state.equals("move")) {
                                                NBPAllTagListView.this.setTopValue(Math.max(l16, Math.min(l3, panGestureParams2.getPageY())));
                                                NBPAllTagListView nBPAllTagListView6 = NBPAllTagListView.this;
                                                floatValue2 = ((Number) nBPAllTagListView6.topValue$delegate.getValue(nBPAllTagListView6, NBPAllTagListView.$$delegatedProperties[1])).floatValue();
                                                nBPAllTagListView6.setAnimateTopValue(floatValue2);
                                            }
                                        } else if (state.equals("end")) {
                                            r3.shouldAnimate$delegate.setValue(NBPAllTagListView.this, NBPAllTagListView.$$delegatedProperties[0], Boolean.valueOf(true));
                                            NBPAllTagListView nBPAllTagListView7 = NBPAllTagListView.this;
                                            if (panGestureParams2.getPageY() >= f16) {
                                                l16 = l3;
                                            }
                                            nBPAllTagListView7.setAnimateTopValue(l16);
                                            NBPAllTagListView nBPAllTagListView8 = NBPAllTagListView.this;
                                            nBPAllTagListView8.setTopValue(nBPAllTagListView8.getAnimateTopValue());
                                            floatValue = ((Number) r8.topValue$delegate.getValue(NBPAllTagListView.this, NBPAllTagListView.$$delegatedProperties[1])).floatValue();
                                            if (floatValue == l3) {
                                                NBPAllTagListView.this.emit("expand", Boolean.FALSE);
                                                NBPAllTagListView.this.expanded = false;
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPAllTagListView nBPAllTagListView4 = NBPAllTagListView.this;
                ar.a(viewContainer2, new Function1<aq<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPAllTagListView$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(aq<?, ?> aqVar) {
                        aq<?, ?> aqVar2 = aqVar;
                        final NBPAllTagListView nBPAllTagListView5 = NBPAllTagListView.this;
                        aqVar2.ref(aqVar2, new Function1<aa<aq<?, ?>>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPAllTagListView.body.1.4.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(aa<aq<?, ?>> aaVar) {
                                NBPAllTagListView nBPAllTagListView6 = NBPAllTagListView.this;
                                KProperty<Object>[] kPropertyArr = NBPAllTagListView.$$delegatedProperties;
                                nBPAllTagListView6.getClass();
                                return Unit.INSTANCE;
                            }
                        });
                        aqVar2.attr(new Function1<ao, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPAllTagListView.body.1.4.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ao aoVar) {
                                ao aoVar2 = aoVar;
                                aoVar2.m140flex(1.0f);
                                aoVar2.flexDirectionColumn();
                                aoVar2.mo153width(aoVar2.getPagerData().m());
                                aoVar2.m138bottom(0.0f);
                                aoVar2.justifyContentCenter();
                                aoVar2.showScrollerIndicator(false);
                                ScrollerAttr.bouncesEnable$default(aoVar2, false, false, 2, null);
                                aoVar2.mo113backgroundColor(QUIToken.color$default("bg_middle_light"));
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPAllTagListView nBPAllTagListView6 = NBPAllTagListView.this;
                        aqVar2.event(new Function1<ap, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPAllTagListView.body.1.4.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ap apVar) {
                                final NBPAllTagListView nBPAllTagListView7 = NBPAllTagListView.this;
                                apVar.dragBegin(new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPAllTagListView.body.1.4.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ScrollParams scrollParams) {
                                        float floatValue;
                                        float l3 = NBPAllTagListView.this.getPagerData().l() - NBPAllTagListView.access$getAttr(NBPAllTagListView.this).initHeight;
                                        float l16 = NBPAllTagListView.this.getPagerData().l() * 0.2f;
                                        floatValue = ((Number) r1.topValue$delegate.getValue(NBPAllTagListView.this, NBPAllTagListView.$$delegatedProperties[1])).floatValue();
                                        if (floatValue == l3) {
                                            r3.shouldAnimate$delegate.setValue(NBPAllTagListView.this, NBPAllTagListView.$$delegatedProperties[0], Boolean.valueOf(true));
                                            NBPAllTagListView.this.setAnimateTopValue(l16);
                                            NBPAllTagListView nBPAllTagListView8 = NBPAllTagListView.this;
                                            nBPAllTagListView8.setTopValue(nBPAllTagListView8.getAnimateTopValue());
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        w.a(aqVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPAllTagListView.body.1.4.4
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPAllTagListView.body.1.4.4.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.flexDirectionRow();
                                        tVar2.marginLeft(16.0f);
                                        tVar2.alignItemsCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPAllTagListView.body.1.4.4.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPAllTagListView.body.1.4.4.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.color(QUIToken.color$default("text_primary"));
                                                ceVar2.text("\u6dfb\u52a0\u66f4\u591a\u6807\u7b7e");
                                                ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                ceVar2.fontWeight500();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPAllTagListView nBPAllTagListView7 = NBPAllTagListView.this;
                        w.a(aqVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPAllTagListView.body.1.4.5
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPAllTagListView.body.1.4.5.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.flexDirectionRow();
                                        tVar2.mo153width(tVar2.getPagerData().m());
                                        tVar2.alignItemsCenter();
                                        tVar2.marginTop(18.0f);
                                        tVar2.flexWrap(FlexWrap.WRAP);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPAllTagListView nBPAllTagListView8 = NBPAllTagListView.this;
                                ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPAllTagListView.body.1.4.5.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        final NBPAllTagListView nBPAllTagListView9 = NBPAllTagListView.this;
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPAllTagListView.body.1.4.5.2.1
                                            {
                                                super(1);
                                            }

                                            /* JADX WARN: Type inference failed for: r0v10, types: [java.util.List<com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view_model.TagTabObservable>, java.util.ArrayList] */
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                NBPTagsEditViewModel nBPTagsEditViewModel;
                                                ?? r06;
                                                Object obj;
                                                String str;
                                                af afVar2 = afVar;
                                                afVar2.size(24.0f, 24.0f);
                                                afVar2.marginLeft(16.0f);
                                                NBPTagsEditViewModel nBPTagsEditViewModel2 = NBPAllTagListView.access$getAttr(NBPAllTagListView.this).viewModel;
                                                if ((nBPTagsEditViewModel2 != null ? nBPTagsEditViewModel2.getState() : null) == NBPTagsEditViewModel.TagState.SUCCESS && (nBPTagsEditViewModel = NBPAllTagListView.access$getAttr(NBPAllTagListView.this).viewModel) != null && (r06 = nBPTagsEditViewModel.tagTabList) != 0) {
                                                    Iterator it = r06.iterator();
                                                    while (true) {
                                                        if (!it.hasNext()) {
                                                            obj = null;
                                                            break;
                                                        }
                                                        obj = it.next();
                                                        if (((TagTabObservable) obj).tagType == 10000) {
                                                            break;
                                                        }
                                                    }
                                                    TagTabObservable tagTabObservable = (TagTabObservable) obj;
                                                    if (tagTabObservable != null && (str = tagTabObservable.tagTypeIcon) != null) {
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPAllTagListView nBPAllTagListView9 = NBPAllTagListView.this;
                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPAllTagListView.body.1.4.5.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final NBPAllTagListView nBPAllTagListView10 = NBPAllTagListView.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPAllTagListView.body.1.4.5.3.1
                                            {
                                                super(1);
                                            }

                                            /* JADX WARN: Code restructure failed: missing block: B:28:0x0089, code lost:
                                            
                                                if ((r2 != null && r2.hitSelectTagMaxLimit()) == false) goto L35;
                                             */
                                            /* JADX WARN: Code restructure failed: missing block: B:9:0x0033, code lost:
                                            
                                                r0 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r1, new java.lang.String[]{"|"}, false, 0, 6, (java.lang.Object) null);
                                             */
                                            @Override // kotlin.jvm.functions.Function1
                                            /*
                                                Code decompiled incorrectly, please refer to instructions dump.
                                            */
                                            public final Unit invoke(ce ceVar) {
                                                String str;
                                                TagInfo mBTITag;
                                                a aVar;
                                                List split$default;
                                                Object first;
                                                ce ceVar2 = ceVar;
                                                ceVar2.marginLeft(4.0f);
                                                ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                ceVar2.fontWeight500();
                                                ceVar2.color(QUIToken.color$default("text_primary"));
                                                NBPTagsEditViewModel nBPTagsEditViewModel = NBPAllTagListView.access$getAttr(NBPAllTagListView.this).viewModel;
                                                if (nBPTagsEditViewModel != null) {
                                                    TagInfo mBTITag2 = nBPTagsEditViewModel.getMBTITag();
                                                    if (mBTITag2 != null && (aVar = mBTITag2.tag) != null && (r1 = aVar.f435363e) != null && split$default != null) {
                                                        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) split$default);
                                                        str = (String) first;
                                                    } else {
                                                        str = "";
                                                    }
                                                    if (str != null) {
                                                        NBPAllTagListView nBPAllTagListView11 = NBPAllTagListView.this;
                                                        if (str.length() == 0) {
                                                            ceVar2.text("MBTI\u4eba\u683c");
                                                        } else {
                                                            NBPTagsEditViewModel nBPTagsEditViewModel2 = NBPAllTagListView.access$getAttr(nBPAllTagListView11).viewModel;
                                                            if ((nBPTagsEditViewModel2 == null || nBPTagsEditViewModel2.containsMBTITag()) ? false : true) {
                                                                NBPTagsEditViewModel nBPTagsEditViewModel3 = NBPAllTagListView.access$getAttr(nBPAllTagListView11).viewModel;
                                                            }
                                                            ceVar2.text("MBTI\u4eba\u683c\uff1a" + str);
                                                            NBPTagsEditViewModel nBPTagsEditViewModel4 = NBPAllTagListView.access$getAttr(nBPAllTagListView11).viewModel;
                                                            if (nBPTagsEditViewModel4 != null && (mBTITag = nBPTagsEditViewModel4.getMBTITag()) != null) {
                                                                if (nBPTagsEditViewModel4.containsMBTITag()) {
                                                                    CollectionsKt__MutableCollectionsKt.removeFirst(nBPTagsEditViewModel4.getSelectedTags());
                                                                }
                                                                nBPTagsEditViewModel4.getSelectedTags().add(0, mBTITag);
                                                            }
                                                        }
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPAllTagListView nBPAllTagListView10 = NBPAllTagListView.this;
                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPAllTagListView.body.1.4.5.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final NBPAllTagListView nBPAllTagListView11 = NBPAllTagListView.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPAllTagListView.body.1.4.5.4.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.positionAbsolute();
                                                ceVar2.m149right(16.0f);
                                                ceVar2.m138bottom(3.0f);
                                                ceVar2.fontWeight400();
                                                ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                ceVar2.color(new h(9211020L, 1.0f));
                                                ceVar2.text("\u5fc5\u987b\u9009\u4e2d4\u4e2a\u7ef4\u5ea6\u540e\u624d\u80fd\u6dfb\u52a0\u6807\u7b7e");
                                                NBPTagsEditViewModel nBPTagsEditViewModel = NBPAllTagListView.access$getAttr(NBPAllTagListView.this).viewModel;
                                                ceVar2.m152visibility((nBPTagsEditViewModel == null || nBPTagsEditViewModel.isMBTITagValid()) ? false : true);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPAllTagListView nBPAllTagListView8 = NBPAllTagListView.this;
                        aqVar2.addChild(new NBPMBTITagList(), new Function1<NBPMBTITagList, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPAllTagListView.body.1.4.6
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPMBTITagList nBPMBTITagList) {
                                final NBPAllTagListView nBPAllTagListView9 = NBPAllTagListView.this;
                                nBPMBTITagList.attr(new Function1<NBPMBTITagAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPAllTagListView.body.1.4.6.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(NBPMBTITagAttr nBPMBTITagAttr) {
                                        nBPMBTITagAttr.viewModel = NBPAllTagListView.access$getAttr(NBPAllTagListView.this).viewModel;
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPAllTagListView nBPAllTagListView9 = NBPAllTagListView.this;
                        w.a(aqVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPAllTagListView.body.1.4.7
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPAllTagListView.body.1.4.7.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.allCenter();
                                        tVar2.flexDirectionColumn();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPAllTagListView nBPAllTagListView10 = NBPAllTagListView.this;
                                vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPAllTagListView.body.1.4.7.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        final NBPAllTagListView nBPAllTagListView11 = NBPAllTagListView.this;
                                        FrameEventKt.d(uVar, new Function1<d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPAllTagListView.body.1.4.7.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(d dVar) {
                                                d dVar2 = dVar;
                                                NBPTagsEditViewModel nBPTagsEditViewModel = NBPAllTagListView.access$getAttr(NBPAllTagListView.this).viewModel;
                                                if (nBPTagsEditViewModel != null) {
                                                    nBPTagsEditViewModel.handleOnSizeChanged(dVar2.getWidth());
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPAllTagListView nBPAllTagListView11 = NBPAllTagListView.this;
                                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPAllTagListView.body.1.4.7.3
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        NBPTagsEditViewModel nBPTagsEditViewModel = NBPAllTagListView.access$getAttr(NBPAllTagListView.this).viewModel;
                                        return Boolean.valueOf((nBPTagsEditViewModel != null ? nBPTagsEditViewModel.getState() : null) == NBPTagsEditViewModel.TagState.SUCCESS);
                                    }
                                };
                                final NBPAllTagListView nBPAllTagListView12 = NBPAllTagListView.this;
                                ConditionViewKt.c(vVar2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPAllTagListView.body.1.4.7.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView) {
                                        final int i3;
                                        ConditionView conditionView2 = conditionView;
                                        NBPTagsEditViewModel nBPTagsEditViewModel = NBPAllTagListView.access$getAttr(NBPAllTagListView.this).viewModel;
                                        List<TagTabObservable> list = nBPTagsEditViewModel != null ? nBPTagsEditViewModel.tagTabList : null;
                                        Intrinsics.checkNotNull(list);
                                        ArrayList arrayList = new ArrayList();
                                        Iterator<T> it = list.iterator();
                                        while (true) {
                                            if (!it.hasNext()) {
                                                break;
                                            }
                                            Object next = it.next();
                                            if ((((TagTabObservable) next).tagType != 10000 ? 1 : 0) != 0) {
                                                arrayList.add(next);
                                            }
                                        }
                                        final NBPAllTagListView nBPAllTagListView13 = NBPAllTagListView.this;
                                        Iterator it5 = arrayList.iterator();
                                        while (it5.hasNext()) {
                                            Object next2 = it5.next();
                                            int i16 = i3 + 1;
                                            if (i3 < 0) {
                                                CollectionsKt__CollectionsKt.throwIndexOverflow();
                                            }
                                            final TagTabObservable tagTabObservable = (TagTabObservable) next2;
                                            w.a(conditionView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPAllTagListView$body$1$4$7$4$2$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(v vVar3) {
                                                    v vVar4 = vVar3;
                                                    final int i17 = i3;
                                                    vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPAllTagListView$body$1$4$7$4$2$1.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(t tVar) {
                                                            t tVar2 = tVar;
                                                            tVar2.marginTop(i17 != 0 ? 24.0f : 0.0f);
                                                            tVar2.flexDirectionRow();
                                                            tVar2.mo153width(tVar2.getPagerData().m());
                                                            tVar2.alignItemsCenter();
                                                            tVar2.flexWrap(FlexWrap.WRAP);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final TagTabObservable tagTabObservable2 = tagTabObservable;
                                                    ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPAllTagListView$body$1$4$7$4$2$1.2
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ImageView imageView) {
                                                            final TagTabObservable tagTabObservable3 = TagTabObservable.this;
                                                            imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPAllTagListView.body.1.4.7.4.2.1.2.1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(af afVar) {
                                                                    af afVar2 = afVar;
                                                                    afVar2.size(24.0f, 24.0f);
                                                                    afVar2.marginLeft(16.0f);
                                                                    b.a.b(afVar2, TagTabObservable.this.tagTypeIcon, false, 2, null);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final TagTabObservable tagTabObservable3 = tagTabObservable;
                                                    cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPAllTagListView$body$1$4$7$4$2$1.3
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(TextView textView) {
                                                            final TagTabObservable tagTabObservable4 = TagTabObservable.this;
                                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPAllTagListView.body.1.4.7.4.2.1.3.1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ce ceVar) {
                                                                    ce ceVar2 = ceVar;
                                                                    ceVar2.marginLeft(4.0f);
                                                                    ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                                    ceVar2.fontWeight500();
                                                                    ceVar2.text(TagTabObservable.this.tagTypeName);
                                                                    ceVar2.color(QUIToken.color$default("text_primary"));
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            conditionView2.addChild(new NBPOptionalTagView(), new Function1<NBPOptionalTagView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPAllTagListView$body$1$4$7$4$2$2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(NBPOptionalTagView nBPOptionalTagView) {
                                                    final TagTabObservable tagTabObservable2 = TagTabObservable.this;
                                                    final NBPAllTagListView nBPAllTagListView14 = nBPAllTagListView13;
                                                    nBPOptionalTagView.attr(new Function1<OptionalTagAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPAllTagListView$body$1$4$7$4$2$2.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(OptionalTagAttr optionalTagAttr) {
                                                            OptionalTagAttr optionalTagAttr2 = optionalTagAttr;
                                                            optionalTagAttr2.mo153width(optionalTagAttr2.getPagerData().m() - 20);
                                                            optionalTagAttr2.alignSelfCenter();
                                                            optionalTagAttr2.margin(6.0f, 0.0f, -6.0f, 0.0f);
                                                            optionalTagAttr2.tagTabObservable$delegate.setValue(optionalTagAttr2, OptionalTagAttr.$$delegatedProperties[0], TagTabObservable.this);
                                                            optionalTagAttr2.viewModel = NBPAllTagListView.access$getAttr(nBPAllTagListView14).viewModel;
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            i3 = i16;
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPAllTagListView nBPAllTagListView13 = NBPAllTagListView.this;
                                Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPAllTagListView.body.1.4.7.5
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        NBPTagsEditViewModel nBPTagsEditViewModel = NBPAllTagListView.access$getAttr(NBPAllTagListView.this).viewModel;
                                        return Boolean.valueOf((nBPTagsEditViewModel != null ? nBPTagsEditViewModel.getState() : null) == NBPTagsEditViewModel.TagState.ERROR);
                                    }
                                };
                                final NBPAllTagListView nBPAllTagListView14 = NBPAllTagListView.this;
                                ConditionViewKt.b(vVar2, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPAllTagListView.body.1.4.7.6
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView) {
                                        final NBPAllTagListView nBPAllTagListView15 = NBPAllTagListView.this;
                                        w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPAllTagListView.body.1.4.7.6.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar3) {
                                                v vVar4 = vVar3;
                                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPAllTagListView.body.1.4.7.6.1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.m140flex(1.0f);
                                                        tVar2.allCenter();
                                                        tVar2.flexDirectionColumn();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPAllTagListView nBPAllTagListView16 = NBPAllTagListView.this;
                                                vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPAllTagListView.body.1.4.7.6.1.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(u uVar) {
                                                        final NBPAllTagListView nBPAllTagListView17 = NBPAllTagListView.this;
                                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPAllTagListView.body.1.4.7.6.1.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                NBPTagsEditViewModel nBPTagsEditViewModel;
                                                                if (!NBPAllTagListView.this.fastClickUtils.isFastDoubleClick() && (nBPTagsEditViewModel = NBPAllTagListView.access$getAttr(NBPAllTagListView.this).viewModel) != null) {
                                                                    nBPTagsEditViewModel.fetchAllTags();
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPAllTagListView.body.1.4.7.6.1.3
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ImageView imageView) {
                                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPAllTagListView.body.1.4.7.6.1.3.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(af afVar) {
                                                                af afVar2 = afVar;
                                                                afVar2.size(86.0f, 86.0f);
                                                                b.a.b(afVar2, "data:image/png;base64,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", false, 2, null);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPAllTagListView.body.1.4.7.6.1.4
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPAllTagListView.body.1.4.7.6.1.4.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                ce ceVar2 = ceVar;
                                                                ceVar2.marginTop(24.0f);
                                                                ceVar2.text("\u7f51\u7edc\u5f02\u5e38\uff0c\u70b9\u51fb\u91cd\u8bd5");
                                                                ce.fontSize$default(ceVar2, 13.0f, null, 2, null);
                                                                ceVar2.color(h.INSTANCE.b());
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
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        w.a(aqVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPAllTagListView.body.1.4.8
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPAllTagListView.body.1.4.8.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.size(tVar2.getPagerData().m(), 30.0f);
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

    /* JADX WARN: Multi-variable type inference failed */
    public final void collapseView() {
        this.shouldAnimate$delegate.setValue(this, $$delegatedProperties[0], Boolean.TRUE);
        setAnimateTopValue(getPagerData().l() - ((NBPAllTagsAttr) getAttr()).initHeight);
        setTopValue(getAnimateTopValue());
        this.expanded = false;
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new NBPAllTagsAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPAllTagsEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        super.created();
        setTopValue(getPagerData().l() - ((NBPAllTagsAttr) getAttr()).initHeight);
        setAnimateTopValue(((Number) this.topValue$delegate.getValue(this, $$delegatedProperties[1])).floatValue());
    }

    public final float getAnimateTopValue() {
        return ((Number) this.animateTopValue$delegate.getValue(this, $$delegatedProperties[2])).floatValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void handleOnRootSizeChanged() {
        float l3;
        if (!this.expanded) {
            l3 = getPagerData().l() - ((NBPAllTagsAttr) getAttr()).initHeight;
        } else {
            l3 = getPagerData().l() * 0.2f;
        }
        setAnimateTopValue(l3);
        setTopValue(getAnimateTopValue());
    }

    public final void setAnimateTopValue(float f16) {
        this.animateTopValue$delegate.setValue(this, $$delegatedProperties[2], Float.valueOf(f16));
    }

    public final void setTopValue(float f16) {
        this.topValue$delegate.setValue(this, $$delegatedProperties[1], Float.valueOf(f16));
    }
}
