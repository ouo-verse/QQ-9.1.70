package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.p001double.view;

import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.Audience;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildWaveAvatarAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildWaveAvatarView;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.m;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class GuildDoubleItemMiddleAvatarView extends ComposeView<GuildDoubleItemMiddleAvatarAttr, GuildDoubleItemMiddleAvatarEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ GuildDoubleItemMiddleAvatarAttr access$getAttr(GuildDoubleItemMiddleAvatarView guildDoubleItemMiddleAvatarView) {
        return (GuildDoubleItemMiddleAvatarAttr) guildDoubleItemMiddleAvatarView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.double.view.GuildDoubleItemMiddleAvatarView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                List take;
                final int i3;
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.double.view.GuildDoubleItemMiddleAvatarView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.m140flex(1.0f);
                        mVar2.flexDirectionRow();
                        mVar2.alignItemsCenter();
                        return Unit.INSTANCE;
                    }
                });
                take = CollectionsKt___CollectionsKt.take(GuildDoubleItemMiddleAvatarView.access$getAttr(GuildDoubleItemMiddleAvatarView.this).audienceList, GuildDoubleItemMiddleAvatarView.access$getAttr(GuildDoubleItemMiddleAvatarView.this).maxAvatarCount);
                final GuildDoubleItemMiddleAvatarView guildDoubleItemMiddleAvatarView = GuildDoubleItemMiddleAvatarView.this;
                final int i16 = 0;
                for (Object obj : take) {
                    int i17 = i16 + 1;
                    if (i16 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    final Audience audience = (Audience) obj;
                    int i18 = audience.sex;
                    if (!(i18 == 1)) {
                        if (!(i18 == 255)) {
                            i3 = 12145050;
                            viewContainer2.addChild(new GuildWaveAvatarView(), new Function1<GuildWaveAvatarView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.double.view.GuildDoubleItemMiddleAvatarView$body$1$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(GuildWaveAvatarView guildWaveAvatarView) {
                                    final int i19 = i16;
                                    final GuildDoubleItemMiddleAvatarView guildDoubleItemMiddleAvatarView2 = guildDoubleItemMiddleAvatarView;
                                    final Audience audience2 = audience;
                                    final int i26 = i3;
                                    guildWaveAvatarView.attr(new Function1<GuildWaveAvatarAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.double.view.GuildDoubleItemMiddleAvatarView$body$1$2$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(GuildWaveAvatarAttr guildWaveAvatarAttr) {
                                            GuildWaveAvatarAttr guildWaveAvatarAttr2 = guildWaveAvatarAttr;
                                            guildWaveAvatarAttr2.marginLeft(i19 == 0 ? 0.0f : GuildDoubleItemMiddleAvatarView.access$getAttr(guildDoubleItemMiddleAvatarView2).marginBetweenAvatar);
                                            GuildDoubleItemMiddleAvatarAttr access$getAttr = GuildDoubleItemMiddleAvatarView.access$getAttr(guildDoubleItemMiddleAvatarView2);
                                            ReadWriteProperty readWriteProperty = access$getAttr.play$delegate;
                                            KProperty<?>[] kPropertyArr = GuildDoubleItemMiddleAvatarAttr.$$delegatedProperties;
                                            boolean booleanValue = ((Boolean) readWriteProperty.getValue(access$getAttr, kPropertyArr[0])).booleanValue();
                                            ReadWriteProperty readWriteProperty2 = guildWaveAvatarAttr2.play$delegate;
                                            KProperty<?>[] kPropertyArr2 = GuildWaveAvatarAttr.$$delegatedProperties;
                                            readWriteProperty2.setValue(guildWaveAvatarAttr2, kPropertyArr2[0], Boolean.valueOf(booleanValue));
                                            guildWaveAvatarAttr2.src = audience2.avatar;
                                            int i27 = i26;
                                            guildWaveAvatarAttr2.colorR = (i27 >> 16) & 255;
                                            guildWaveAvatarAttr2.colorG = (i27 >> 8) & 255;
                                            guildWaveAvatarAttr2.colorB = i27 & 255;
                                            guildWaveAvatarAttr2.maxAlpha = 0.9f;
                                            GuildDoubleItemMiddleAvatarAttr access$getAttr2 = GuildDoubleItemMiddleAvatarView.access$getAttr(guildDoubleItemMiddleAvatarView2);
                                            guildWaveAvatarAttr2.userScrolling$delegate.setValue(guildWaveAvatarAttr2, kPropertyArr2[1], Boolean.valueOf(((Boolean) access$getAttr2.userScrolling$delegate.getValue(access$getAttr2, kPropertyArr[1])).booleanValue()));
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                            i16 = i17;
                        }
                    }
                    i3 = 2334944;
                    viewContainer2.addChild(new GuildWaveAvatarView(), new Function1<GuildWaveAvatarView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.double.view.GuildDoubleItemMiddleAvatarView$body$1$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(GuildWaveAvatarView guildWaveAvatarView) {
                            final int i19 = i16;
                            final GuildDoubleItemMiddleAvatarView guildDoubleItemMiddleAvatarView2 = guildDoubleItemMiddleAvatarView;
                            final Audience audience2 = audience;
                            final int i26 = i3;
                            guildWaveAvatarView.attr(new Function1<GuildWaveAvatarAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.double.view.GuildDoubleItemMiddleAvatarView$body$1$2$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(GuildWaveAvatarAttr guildWaveAvatarAttr) {
                                    GuildWaveAvatarAttr guildWaveAvatarAttr2 = guildWaveAvatarAttr;
                                    guildWaveAvatarAttr2.marginLeft(i19 == 0 ? 0.0f : GuildDoubleItemMiddleAvatarView.access$getAttr(guildDoubleItemMiddleAvatarView2).marginBetweenAvatar);
                                    GuildDoubleItemMiddleAvatarAttr access$getAttr = GuildDoubleItemMiddleAvatarView.access$getAttr(guildDoubleItemMiddleAvatarView2);
                                    ReadWriteProperty readWriteProperty = access$getAttr.play$delegate;
                                    KProperty<?>[] kPropertyArr = GuildDoubleItemMiddleAvatarAttr.$$delegatedProperties;
                                    boolean booleanValue = ((Boolean) readWriteProperty.getValue(access$getAttr, kPropertyArr[0])).booleanValue();
                                    ReadWriteProperty readWriteProperty2 = guildWaveAvatarAttr2.play$delegate;
                                    KProperty<?>[] kPropertyArr2 = GuildWaveAvatarAttr.$$delegatedProperties;
                                    readWriteProperty2.setValue(guildWaveAvatarAttr2, kPropertyArr2[0], Boolean.valueOf(booleanValue));
                                    guildWaveAvatarAttr2.src = audience2.avatar;
                                    int i27 = i26;
                                    guildWaveAvatarAttr2.colorR = (i27 >> 16) & 255;
                                    guildWaveAvatarAttr2.colorG = (i27 >> 8) & 255;
                                    guildWaveAvatarAttr2.colorB = i27 & 255;
                                    guildWaveAvatarAttr2.maxAlpha = 0.9f;
                                    GuildDoubleItemMiddleAvatarAttr access$getAttr2 = GuildDoubleItemMiddleAvatarView.access$getAttr(guildDoubleItemMiddleAvatarView2);
                                    guildWaveAvatarAttr2.userScrolling$delegate.setValue(guildWaveAvatarAttr2, kPropertyArr2[1], Boolean.valueOf(((Boolean) access$getAttr2.userScrolling$delegate.getValue(access$getAttr2, kPropertyArr[1])).booleanValue()));
                                    return Unit.INSTANCE;
                                }
                            });
                            return Unit.INSTANCE;
                        }
                    });
                    i16 = i17;
                }
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new GuildDoubleItemMiddleAvatarAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new GuildDoubleItemMiddleAvatarEvent();
    }
}
