package com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view;

import com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view_model.NBPTagsEditViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.layout.FlexWrap;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function1;

/* loaded from: classes31.dex */
public final class NBPMBTITagList extends ComposeView<NBPMBTITagAttr, NBPMBTITagEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPMBTITagAttr access$getAttr(NBPMBTITagList nBPMBTITagList) {
        return (NBPMBTITagAttr) nBPMBTITagList.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPMBTITagList$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                List<MBTITagAttr> list;
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPMBTITagList$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.margin(12.0f, 16.0f, 12.0f, 16.0f);
                        mVar2.flexDirectionRow();
                        mVar2.flexWrap(FlexWrap.WRAP);
                        return Unit.INSTANCE;
                    }
                });
                NBPTagsEditViewModel nBPTagsEditViewModel = NBPMBTITagList.access$getAttr(NBPMBTITagList.this).viewModel;
                if (nBPTagsEditViewModel != null && (list = nBPTagsEditViewModel.mbtiTags) != null) {
                    final NBPMBTITagList nBPMBTITagList = NBPMBTITagList.this;
                    final int i3 = 0;
                    for (Object obj : list) {
                        int i16 = i3 + 1;
                        if (i3 < 0) {
                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                        }
                        final MBTITagAttr mBTITagAttr = (MBTITagAttr) obj;
                        viewContainer2.addChild(new MBTITagView(), new Function1<MBTITagView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPMBTITagList$body$1$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(MBTITagView mBTITagView) {
                                MBTITagView mBTITagView2 = mBTITagView;
                                final NBPMBTITagList nBPMBTITagList2 = NBPMBTITagList.this;
                                final MBTITagAttr mBTITagAttr2 = mBTITagAttr;
                                final int i17 = i3;
                                mBTITagView2.attr(new Function1<MBTITagAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPMBTITagList$body$1$2$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(MBTITagAttr mBTITagAttr3) {
                                        MBTITagAttr mBTITagAttr4 = mBTITagAttr3;
                                        mBTITagAttr4.viewModel = NBPMBTITagList.access$getAttr(NBPMBTITagList.this).viewModel;
                                        MBTITagAttr mBTITagAttr5 = mBTITagAttr2;
                                        mBTITagAttr4.leftTag = mBTITagAttr5.leftTag;
                                        mBTITagAttr4.leftMeaning = mBTITagAttr5.leftMeaning;
                                        mBTITagAttr4.rightTag = mBTITagAttr5.rightTag;
                                        mBTITagAttr4.rightMeaning = mBTITagAttr5.rightMeaning;
                                        mBTITagAttr4.index = i17;
                                        mBTITagAttr4.setSelectTag(mBTITagAttr5.getSelectTag());
                                        mBTITagAttr4.margin(0.0f, i17 % 2 == 1 ? 12.0f : 0.0f, 12.0f, 0.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPMBTITagList nBPMBTITagList3 = NBPMBTITagList.this;
                                mBTITagView2.event(new Function1<MBTITagEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPMBTITagList$body$1$2$1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(MBTITagEvent mBTITagEvent) {
                                        final NBPMBTITagList nBPMBTITagList4 = NBPMBTITagList.this;
                                        mBTITagEvent.registerEvent("select", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.NBPMBTITagList.body.1.2.1.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Object obj2) {
                                                NBPTagsEditViewModel nBPTagsEditViewModel2;
                                                MBTITagAttr mBTITagAttr3 = obj2 instanceof MBTITagAttr ? (MBTITagAttr) obj2 : null;
                                                if (mBTITagAttr3 != null && (nBPTagsEditViewModel2 = NBPMBTITagList.access$getAttr(NBPMBTITagList.this).viewModel) != null) {
                                                    if (mBTITagAttr3.getSelectTag() == -1) {
                                                        if (nBPTagsEditViewModel2.containsMBTITag()) {
                                                            nBPTagsEditViewModel2.getSelectedMBTI().remove(mBTITagAttr3);
                                                            CollectionsKt__MutableCollectionsKt.removeFirst(nBPTagsEditViewModel2.getSelectedTags());
                                                        }
                                                    } else {
                                                        if (nBPTagsEditViewModel2.getSelectedMBTI().contains(mBTITagAttr3)) {
                                                            nBPTagsEditViewModel2.getSelectedMBTI().remove(mBTITagAttr3);
                                                        }
                                                        nBPTagsEditViewModel2.getSelectedMBTI().add(mBTITagAttr3);
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
                        i3 = i16;
                    }
                }
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new NBPMBTITagAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPMBTITagEvent();
    }
}
