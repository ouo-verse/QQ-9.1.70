package com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person;

import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConstKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyProKtxKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainKtxKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.MarkerViewExtKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPAvatarAttr;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPAvatarView;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.a;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.g;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import defpackage.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* loaded from: classes31.dex */
public final class NBPPersonMarkerView extends ComposeView<NBPPersonMarkerAttr, NBPPersonMarkerEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPPersonMarkerAttr access$getAttr(NBPPersonMarkerView nBPPersonMarkerView) {
        return (NBPPersonMarkerAttr) nBPPersonMarkerView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final NBPPersonMarkerView nBPPersonMarkerView = NBPPersonMarkerView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final NBPPersonMarkerView nBPPersonMarkerView2 = NBPPersonMarkerView.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerView.body.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                MarkerViewExtKt.bindMarkerStatusChange(tVar2, NBPPersonMarkerView.access$getAttr(NBPPersonMarkerView.this).getViewModel(), 0.1f);
                                NBPMainKtxKt.boxShadowWithBlackSet$default(tVar2, new g(0.0f, 7.7f, 12.83f, h.INSTANCE.a(0.12f)));
                                tVar2.m154zIndex(1);
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPPersonMarkerView nBPPersonMarkerView3 = NBPPersonMarkerView.this;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerView.body.1.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                a aVar = NBPPersonMarkerView.access$getAttr(NBPPersonMarkerView.this).getViewModel().anchor;
                                final NBPPersonMarkerView nBPPersonMarkerView4 = NBPPersonMarkerView.this;
                                MarkerViewExtKt.bindMarkerPopShow(uVar, aVar, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerView.body.1.1.2.1
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        NBPPersonMarkerView.access$getAttr(NBPPersonMarkerView.this).getViewModel().readyToFocus = true;
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPPersonMarkerView nBPPersonMarkerView4 = NBPPersonMarkerView.this;
                        vVar2.addChild(new NBPAvatarView(), new Function1<NBPAvatarView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerView.body.1.1.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPAvatarView nBPAvatarView) {
                                final NBPPersonMarkerView nBPPersonMarkerView5 = NBPPersonMarkerView.this;
                                nBPAvatarView.attr(new Function1<NBPAvatarAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerView.body.1.1.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(NBPAvatarAttr nBPAvatarAttr) {
                                        NBPAvatarAttr nBPAvatarAttr2 = nBPAvatarAttr;
                                        nBPAvatarAttr2.url = NBPPersonMarkerView.access$getAttr(NBPPersonMarkerView.this).getViewModel().person.f440883h;
                                        nBPAvatarAttr2.dressBorderUrl = NearbyProKtxKt.avatarDressBorderUrl(NBPPersonMarkerView.access$getAttr(NBPPersonMarkerView.this).getViewModel().person);
                                        nBPAvatarAttr2.size = 28.0f;
                                        nBPAvatarAttr2.borderWidth$delegate.setValue(nBPAvatarAttr2, NBPAvatarAttr.$$delegatedProperties[0], Float.valueOf(NBPPersonMarkerView.access$getAttr(NBPPersonMarkerView.this).getViewModel().isFocused() ? 1.75f : 2.5f));
                                        if (k.a(c.f117352a)) {
                                            nBPAvatarAttr2.imageRenderScale = 2.0f;
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
                final NBPPersonMarkerView nBPPersonMarkerView2 = NBPPersonMarkerView.this;
                Function1<NBPPersonMarkerFocusedAttachmentView, Unit> function1 = new Function1<NBPPersonMarkerFocusedAttachmentView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(NBPPersonMarkerFocusedAttachmentView nBPPersonMarkerFocusedAttachmentView) {
                        NBPPersonMarkerFocusedAttachmentView nBPPersonMarkerFocusedAttachmentView2 = nBPPersonMarkerFocusedAttachmentView;
                        final NBPPersonMarkerView nBPPersonMarkerView3 = NBPPersonMarkerView.this;
                        nBPPersonMarkerFocusedAttachmentView2.ref(nBPPersonMarkerFocusedAttachmentView2, new Function1<aa<NBPPersonMarkerFocusedAttachmentView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(aa<NBPPersonMarkerFocusedAttachmentView> aaVar) {
                                NBPPersonMarkerView.access$getAttr(NBPPersonMarkerView.this).getViewModel().attachmentViewRef = aaVar;
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPPersonMarkerView nBPPersonMarkerView4 = NBPPersonMarkerView.this;
                        nBPPersonMarkerFocusedAttachmentView2.attr(new Function1<NBPPersonMarkerFocusedAttachmentAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerView.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPPersonMarkerFocusedAttachmentAttr nBPPersonMarkerFocusedAttachmentAttr) {
                                int collectionSizeOrDefault;
                                NBPPersonMarkerFocusedAttachmentAttr nBPPersonMarkerFocusedAttachmentAttr2 = nBPPersonMarkerFocusedAttachmentAttr;
                                nBPPersonMarkerFocusedAttachmentAttr2.markerStatus$delegate.setValue(nBPPersonMarkerFocusedAttachmentAttr2, NBPPersonMarkerFocusedAttachmentAttr.$$delegatedProperties[0], NBPPersonMarkerView.access$getAttr(NBPPersonMarkerView.this).getViewModel().getStatus());
                                List<t35.a> list = NBPPersonMarkerView.access$getAttr(NBPPersonMarkerView.this).getViewModel().person.G;
                                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                                Iterator<T> it = list.iterator();
                                while (it.hasNext()) {
                                    arrayList.add(((t35.a) it.next()).f435363e);
                                }
                                nBPPersonMarkerFocusedAttachmentAttr2.tags = arrayList;
                                nBPPersonMarkerFocusedAttachmentAttr2.m154zIndex(0);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                };
                com.tencent.kuikly.core.base.u uVar = NBPPersonMarkerFocusedAttachmentViewKt.maxScale;
                viewContainer2.addChild(new NBPPersonMarkerFocusedAttachmentView(), function1);
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new NBPPersonMarkerAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPPersonMarkerEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        super.created();
        NBPPersonMarkerViewModel viewModel = ((NBPPersonMarkerAttr) getAttr()).getViewModel();
        viewModel.getClass();
        e jsonWithMainPgParamsImp = NearbyConstKt.jsonWithMainPgParamsImp();
        jsonWithMainPgParamsImp.v("dt_eid", "em_nearby_avatar_icon");
        jsonWithMainPgParamsImp.v("nearby_frame_id", NearbyProKtxKt.avatarDressBorderUrl(viewModel.person));
        jsonWithMainPgParamsImp.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_imp", jsonWithMainPgParamsImp);
    }
}
