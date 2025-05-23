package com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view;

import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConstKt;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.data.TagInfo;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.TagViewAttr;
import com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view_model.NBPTagsEditViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.layout.FlexWrap;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.reactive.collection.c;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* loaded from: classes31.dex */
public final class NBPSelectedTagListView extends ComposeView<SelectedTagListAttr, l> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ SelectedTagListAttr access$getAttr(NBPSelectedTagListView nBPSelectedTagListView) {
        return (SelectedTagListAttr) nBPSelectedTagListView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPSelectedTagListView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPSelectedTagListView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.flexDirectionRow();
                        mVar2.flexWrap(FlexWrap.WRAP);
                        return Unit.INSTANCE;
                    }
                });
                final NBPTagsEditViewModel nBPTagsEditViewModel = NBPSelectedTagListView.access$getAttr(NBPSelectedTagListView.this).viewModel;
                if (nBPTagsEditViewModel != null) {
                    final NBPSelectedTagListView nBPSelectedTagListView = NBPSelectedTagListView.this;
                    LoopDirectivesViewKt.a(viewContainer2, new Function0<c<TagInfo>>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPSelectedTagListView$body$1$2$1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final c<TagInfo> invoke() {
                            return NBPTagsEditViewModel.this.getSelectedTags();
                        }
                    }, new Function2<LoopDirectivesView<TagInfo>, TagInfo, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPSelectedTagListView$body$1$2$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Unit invoke(LoopDirectivesView<TagInfo> loopDirectivesView, TagInfo tagInfo) {
                            final TagInfo tagInfo2 = tagInfo;
                            final NBPSelectedTagListView nBPSelectedTagListView2 = NBPSelectedTagListView.this;
                            final NBPTagsEditViewModel nBPTagsEditViewModel2 = nBPTagsEditViewModel;
                            loopDirectivesView.addChild(new SelectedTagView(), new Function1<SelectedTagView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPSelectedTagListView$body$1$2$2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(SelectedTagView selectedTagView) {
                                    SelectedTagView selectedTagView2 = selectedTagView;
                                    final TagInfo tagInfo3 = TagInfo.this;
                                    final NBPSelectedTagListView nBPSelectedTagListView3 = nBPSelectedTagListView2;
                                    selectedTagView2.attr(new Function1<TagViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPSelectedTagListView.body.1.2.2.1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(TagViewAttr tagViewAttr) {
                                            tagViewAttr.setTag(TagInfo.this);
                                            NBPTagsEditViewModel nBPTagsEditViewModel3 = NBPSelectedTagListView.access$getAttr(nBPSelectedTagListView3).viewModel;
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final NBPTagsEditViewModel nBPTagsEditViewModel3 = nBPTagsEditViewModel2;
                                    final NBPSelectedTagListView nBPSelectedTagListView4 = nBPSelectedTagListView2;
                                    selectedTagView2.event(new Function1<SelectedTagEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPSelectedTagListView.body.1.2.2.1.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(SelectedTagEvent selectedTagEvent) {
                                            final NBPTagsEditViewModel nBPTagsEditViewModel4 = NBPTagsEditViewModel.this;
                                            final NBPSelectedTagListView nBPSelectedTagListView5 = nBPSelectedTagListView4;
                                            selectedTagEvent.registerEvent("delete", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPSelectedTagListView.body.1.2.2.1.2.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(Object obj) {
                                                    TagViewAttr tagViewAttr = obj instanceof TagViewAttr ? (TagViewAttr) obj : null;
                                                    if (tagViewAttr != null) {
                                                        NBPTagsEditViewModel nBPTagsEditViewModel5 = NBPTagsEditViewModel.this;
                                                        NBPSelectedTagListView nBPSelectedTagListView6 = nBPSelectedTagListView5;
                                                        nBPTagsEditViewModel5.toggleTag(tagViewAttr.getTag());
                                                        e nearbyDTBaseParams = NearbyConstKt.getNearbyDTBaseParams();
                                                        nearbyDTBaseParams.v("dt_pgid", "pg_nearby_tag_edit");
                                                        nearbyDTBaseParams.v("dt_eid", "em_nearby_kl_del_tag");
                                                        NBPTagsEditViewModel nBPTagsEditViewModel6 = NBPSelectedTagListView.access$getAttr(nBPSelectedTagListView6).viewModel;
                                                        nearbyDTBaseParams.v("nearby_kl_appid", nBPTagsEditViewModel6 != null ? Integer.valueOf(nBPTagsEditViewModel6.appId) : null);
                                                        e eVar = new e();
                                                        NBPTagsEditViewModel nBPTagsEditViewModel7 = NBPSelectedTagListView.access$getAttr(nBPSelectedTagListView6).viewModel;
                                                        eVar.v("nearby_kl_appid", nBPTagsEditViewModel7 != null ? Integer.valueOf(nBPTagsEditViewModel7.appId) : null);
                                                        Unit unit = Unit.INSTANCE;
                                                        nearbyDTBaseParams.v("cur_pg", eVar);
                                                        nearbyDTBaseParams.v("nearby_kl_tag_id", String.valueOf(tagViewAttr.getTag().tag.f435362d));
                                                        nearbyDTBaseParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                                        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", nearbyDTBaseParams);
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
                            return Unit.INSTANCE;
                        }
                    });
                }
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new SelectedTagListAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
