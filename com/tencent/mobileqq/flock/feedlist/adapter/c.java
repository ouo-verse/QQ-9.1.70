package com.tencent.mobileqq.flock.feedlist.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.biz.richframework.part.adapter.section.SectionViewHolder;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.flock.api.FlockConstants$FlockListScene;
import com.tencent.mobileqq.flock.feedcommon.section.FlockFeedCommonParticipantSection;
import com.tencent.mobileqq.flock.feedcommon.section.FlockFeedCommonPoiSection;
import com.tencent.mobileqq.flock.feedcommon.section.FlockFeedCommonTimeSection;
import com.tencent.mobileqq.flock.feedcommon.section.FlockFeedCommonTopicSection;
import com.tencent.mobileqq.flock.feedcommon.section.g;
import com.tencent.mobileqq.flock.feeddetail.bean.FlockFeedDetailInitBean;
import com.tencent.mobileqq.flock.feedlist.section.FlockFeedListCardOperateSection;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import y45.k;
import y45.l;
import y45.o;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010 \u001a\u00020\u001c\u00a2\u0006\u0004\b$\u0010%J\"\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J&\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\b\u0010\u000f\u001a\u00020\u0006H\u0016J4\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00042\u001a\u0010\u0015\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00020\u00140\u00130\u000bH\u0016J2\u0010\u001b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u00172\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u000bH\u0014R\u0017\u0010 \u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010#\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/flock/feedlist/adapter/c;", "Lcom/tencent/mobileqq/flock/base/a;", "Lcom/tencent/mobileqq/flock/feeddetail/bean/a;", "data", "Landroid/view/View;", "view", "", "position", "", "c", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "e", "getLayoutId", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "itemView", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "sections", "initSection", "Lcom/tencent/biz/richframework/part/adapter/section/SectionViewHolder;", "holder", "", "payloads", "f", "Lcom/tencent/mobileqq/flock/api/FlockConstants$FlockListScene;", "Lcom/tencent/mobileqq/flock/api/FlockConstants$FlockListScene;", "getType", "()Lcom/tencent/mobileqq/flock/api/FlockConstants$FlockListScene;", "type", "d", "()I", "detailSourceType", "<init>", "(Lcom/tencent/mobileqq/flock/api/FlockConstants$FlockListScene;)V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class c extends com.tencent.mobileqq.flock.base.a<com.tencent.mobileqq.flock.feeddetail.bean.a> {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FlockConstants$FlockListScene type;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f210133a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35421);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[FlockConstants$FlockListScene.values().length];
            try {
                iArr[FlockConstants$FlockListScene.TROOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FlockConstants$FlockListScene.ACTIVITY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FlockConstants$FlockListScene.RECOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FlockConstants$FlockListScene.PUBLISH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[FlockConstants$FlockListScene.JOIN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[FlockConstants$FlockListScene.TOPIC_AGGREGATION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f210133a = iArr;
        }
    }

    public c(@NotNull FlockConstants$FlockListScene type) {
        Intrinsics.checkNotNullParameter(type, "type");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) type);
        } else {
            this.type = type;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00dd, code lost:
    
        if (r6 == null) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void c(com.tencent.mobileqq.flock.feeddetail.bean.a data, View view, int position) {
        Map<String, Object> emptyMap;
        y45.b a16;
        Integer num;
        String str;
        String str2;
        Long l3;
        if (data != null && (a16 = data.a()) != null) {
            Pair[] pairArr = new Pair[10];
            k kVar = a16.f449379n;
            Long l16 = null;
            if (kVar != null) {
                num = Integer.valueOf(kVar.f449416b);
            } else {
                num = null;
            }
            pairArr[0] = TuplesKt.to("participants_num", String.valueOf(num));
            pairArr[1] = TuplesKt.to("activity_result_id", a16.f449366a.toString());
            o oVar = a16.f449369d;
            if (oVar != null) {
                str = oVar.f449450b;
            } else {
                str = null;
            }
            pairArr[2] = TuplesKt.to("publisher_event_results", String.valueOf(str));
            l lVar = a16.f449376k;
            if (lVar != null) {
                str2 = lVar.f449420b;
            } else {
                str2 = null;
            }
            pairArr[3] = TuplesKt.to("activity_location", String.valueOf(str2));
            pairArr[4] = TuplesKt.to("recommand_rank", Integer.valueOf(position + 1));
            pairArr[5] = TuplesKt.to("group_id", String.valueOf(a16.f449367b));
            y45.a aVar = a16.f449374i;
            if (aVar != null) {
                l3 = Long.valueOf(aVar.f449361a);
            } else {
                l3 = null;
            }
            pairArr[6] = TuplesKt.to("activity_start_time", String.valueOf(l3));
            y45.a aVar2 = a16.f449374i;
            if (aVar2 != null) {
                l16 = Long.valueOf(aVar2.f449362b);
            }
            pairArr[7] = TuplesKt.to("activity_end_time", String.valueOf(l16));
            pairArr[8] = TuplesKt.to("activity_name", a16.f449371f.toString());
            String b16 = com.tencent.mobileqq.flock.ktx.e.b(a16);
            if (b16 == null) {
                b16 = "";
            }
            pairArr[9] = TuplesKt.to("activity_topic", b16);
            emptyMap = MapsKt__MapsKt.mutableMapOf(pairArr);
        }
        emptyMap = MapsKt__MapsKt.emptyMap();
        com.tencent.mobileqq.flock.datong.c.d(view, "em_bas_partner_act_item", new com.tencent.mobileqq.flock.datong.b().g(emptyMap));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(c this$0, SectionViewHolder holder, com.tencent.mobileqq.flock.feeddetail.bean.a item, View view) {
        int i3;
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        Intrinsics.checkNotNullParameter(item, "$item");
        if (a.f210133a[this$0.type.ordinal()] == 1) {
            i3 = 1008;
        } else {
            i3 = 1006;
        }
        int i16 = i3;
        com.tencent.mobileqq.flock.a aVar = com.tencent.mobileqq.flock.a.f209993a;
        Context context = holder.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "holder.itemView.context");
        o oVar = item.a().f449369d;
        if (oVar != null) {
            str = oVar.f449449a;
        } else {
            str = null;
        }
        String id5 = item.a().f449366a;
        long j3 = item.a().f449373h;
        long j16 = item.a().f449368c;
        int d16 = this$0.d();
        Intrinsics.checkNotNullExpressionValue(id5, "id");
        aVar.a(context, new FlockFeedDetailInitBean(str, id5, j3, j16, null, null, d16, i16, 48, null));
        EventCollector.getInstance().onViewClicked(view);
    }

    public final int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        switch (a.f210133a[this.type.ordinal()]) {
            case 1:
                return 3;
            case 2:
            case 3:
                return 2;
            case 4:
            case 5:
                return 4;
            case 6:
                return 6;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean isForViewType(@NotNull com.tencent.mobileqq.flock.feeddetail.bean.a item, @NotNull List<com.tencent.mobileqq.flock.feeddetail.bean.a> items, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, item, items, Integer.valueOf(position))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder2(@NotNull final com.tencent.mobileqq.flock.feeddetail.bean.a item, @NotNull final SectionViewHolder<?> holder, int position, @NotNull List<Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, item, holder, Integer.valueOf(position), payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.onBindViewHolder2((c) item, (SectionViewHolder) holder, position, payloads);
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.flock.feedlist.adapter.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.g(c.this, holder, item, view);
            }
        });
        View view = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        c(item, view, position);
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public int getLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return R.layout.e87;
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public void initSection(@NotNull ViewGroup parent, @NotNull View itemView, @NotNull List<Class<? extends Section<com.tencent.mobileqq.flock.feeddetail.bean.a>>> sections) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, parent, itemView, sections);
            return;
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(sections, "sections");
        sections.add(com.tencent.mobileqq.flock.feedcommon.section.e.class);
        sections.add(FlockFeedCommonPoiSection.class);
        sections.add(FlockFeedCommonTimeSection.class);
        sections.add(FlockFeedCommonTopicSection.class);
        sections.add(FlockFeedCommonParticipantSection.class);
        sections.add(FlockFeedListCardOperateSection.class);
        if (this.type == FlockConstants$FlockListScene.TOPIC_AGGREGATION) {
            sections.add(com.tencent.mobileqq.topicaggregation.section.a.class);
        } else {
            sections.add(com.tencent.mobileqq.flock.feedlist.section.a.class);
        }
        if (this.type != FlockConstants$FlockListScene.PUBLISH) {
            sections.add(com.tencent.mobileqq.flock.feedlist.section.c.class);
            sections.add(g.class);
        }
    }
}
