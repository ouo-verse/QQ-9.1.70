package com.tencent.hippykotlin.demo.pages.nearby.base.view.comment;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.TextViewExtKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class NBPFeedLikeBannerView extends ComposeView<NBPFeedLikeBannerAttr, NBPFeedLikeBannerEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPFeedLikeBannerAttr access$getAttr(NBPFeedLikeBannerView nBPFeedLikeBannerView) {
        return (NBPFeedLikeBannerAttr) nBPFeedLikeBannerView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedLikeBannerView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final NBPFeedLikeBannerView nBPFeedLikeBannerView = NBPFeedLikeBannerView.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedLikeBannerView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.marginLeft(16.0f);
                        mVar2.marginRight(16.0f);
                        mVar2.mo153width(NBPFeedLikeBannerView.this.getPagerData().m() - 32.0f);
                        return Unit.INSTANCE;
                    }
                });
                ah.a(viewContainer2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedLikeBannerView$body$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ImageView imageView) {
                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedLikeBannerView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(af afVar) {
                                af afVar2 = afVar;
                                afVar2.size(20.0f, 20.0f);
                                b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_HOA8tHr9GJQ.png", false, 2, null);
                                afVar2.t(QUIToken.color$default("text_primary"));
                                afVar2.absolutePositionAllZero();
                                afVar2.m150top(1.0f);
                                afVar2.m142left(0.0f);
                                afVar2.m154zIndex(1);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPFeedLikeBannerView nBPFeedLikeBannerView2 = NBPFeedLikeBannerView.this;
                cg.a(viewContainer2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedLikeBannerView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        final NBPFeedLikeBannerView nBPFeedLikeBannerView3 = NBPFeedLikeBannerView.this;
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedLikeBannerView.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                int collectionSizeOrDefault;
                                String sb5;
                                String joinToString$default;
                                List list;
                                String joinToString$default2;
                                int lastIndex;
                                ce ceVar2 = ceVar;
                                ceVar2.mo153width(ceVar2.getPagerData().m() - 32.0f);
                                ceVar2.lineHeight(22.0f);
                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                ceVar2.fontWeight500();
                                ceVar2.color(QUIToken.color$default("text_primary"));
                                ceVar2.firstLineHeadIndent(24.0f);
                                NBPFeedLikeBannerAttr access$getAttr = NBPFeedLikeBannerView.access$getAttr(NBPFeedLikeBannerView.this);
                                ReadWriteProperty readWriteProperty = access$getAttr.likeUserNicks$delegate;
                                KProperty<?>[] kPropertyArr = NBPFeedLikeBannerAttr.$$delegatedProperties;
                                List list2 = (List) readWriteProperty.getValue(access$getAttr, kPropertyArr[1]);
                                NBPFeedLikeBannerAttr access$getAttr2 = NBPFeedLikeBannerView.access$getAttr(NBPFeedLikeBannerView.this);
                                List<String> subList = list2.subList(0, Math.min(10, ((List) access$getAttr2.likeUserNicks$delegate.getValue(access$getAttr2, kPropertyArr[1])).size()));
                                NBPFeedLikeBannerView nBPFeedLikeBannerView4 = NBPFeedLikeBannerView.this;
                                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(subList, 10);
                                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                                for (String str : subList) {
                                    nBPFeedLikeBannerView4.getClass();
                                    ArrayList arrayList2 = new ArrayList();
                                    int i3 = 0;
                                    int i16 = 0;
                                    while (true) {
                                        if (i3 < str.length()) {
                                            char charAt = str.charAt(i3);
                                            i3++;
                                            if (i16 >= 14) {
                                                lastIndex = CollectionsKt__CollectionsKt.getLastIndex(arrayList2);
                                                arrayList2.set(lastIndex, MiniBoxNoticeInfo.APPNAME_SUFFIX);
                                                break;
                                            }
                                            if (charAt < '\u0100') {
                                                i16++;
                                                arrayList2.add(String.valueOf(charAt));
                                            } else if (charAt == '\ud83d') {
                                                if (i3 < str.length()) {
                                                    i16 += 2;
                                                    StringBuilder m3 = BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0.m(charAt);
                                                    m3.append(str.charAt(i3));
                                                    arrayList2.add(m3.toString());
                                                    i3++;
                                                }
                                            } else {
                                                i16 += 2;
                                                arrayList2.add(String.valueOf(charAt));
                                            }
                                        }
                                    }
                                    list = CollectionsKt___CollectionsKt.toList(arrayList2);
                                    joinToString$default2 = CollectionsKt___CollectionsKt.joinToString$default(list, "", null, null, 0, null, null, 62, null);
                                    arrayList.add(joinToString$default2);
                                }
                                NBPFeedLikeBannerAttr access$getAttr3 = NBPFeedLikeBannerView.access$getAttr(NBPFeedLikeBannerView.this);
                                ReadWriteProperty readWriteProperty2 = access$getAttr3.likeCount$delegate;
                                KProperty<?>[] kPropertyArr2 = NBPFeedLikeBannerAttr.$$delegatedProperties;
                                if (((Number) readWriteProperty2.getValue(access$getAttr3, kPropertyArr2[0])).intValue() <= 2) {
                                    sb5 = " \u8d5e\u4e86";
                                } else {
                                    StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m(" \u7b49");
                                    NBPFeedLikeBannerAttr access$getAttr4 = NBPFeedLikeBannerView.access$getAttr(NBPFeedLikeBannerView.this);
                                    m16.append(((Number) access$getAttr4.likeCount$delegate.getValue(access$getAttr4, kPropertyArr2[0])).intValue());
                                    m16.append("\u4eba\u8d5e\u4e86");
                                    sb5 = m16.toString();
                                }
                                StringBuilder sb6 = new StringBuilder();
                                joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, "\u3001", null, null, 0, null, null, 62, null);
                                sb6.append(joinToString$default);
                                sb6.append(sb5);
                                TextViewExtKt.textWithLineHeightFix(ceVar2, sb6.toString());
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
        return new NBPFeedLikeBannerAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPFeedLikeBannerEvent();
    }
}
