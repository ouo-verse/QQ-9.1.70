package com.tencent.mobileqq.guild.feed.nativedetail.content.guildinfo.section;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.adapter.section.SectionIOCKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.nativedetail.content.guildinfo.section.GuildInfoNewSection$itemClickListener$2;
import com.tencent.mobileqq.guild.feed.nativedetail.content.widget.GuildInfoGuideBar;
import com.tencent.mobileqq.guild.feed.nativedetail.content.widget.d;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\t*\u0001!\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b'\u0010(J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J(\u0010\u0013\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0014J\b\u0010\u0014\u001a\u00020\nH\u0016R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001b\u0010&\u001a\u00020!8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/guildinfo/section/GuildInfoNewSection;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/guildinfo/section/a;", "Lrl1/b;", "t", "Lrl1/a;", ReportConstant.COSTREPORT_PREFIX, "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "Lql1/a;", "data", "", "position", "", "", "payload", "v", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "titleTv", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/widget/GuildInfoGuideBar;", "e", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/widget/GuildInfoGuideBar;", "guildInfoBar", "Landroid/widget/LinearLayout;", "f", "Landroid/widget/LinearLayout;", ParseCommon.CONTAINER, "com/tencent/mobileqq/guild/feed/nativedetail/content/guildinfo/section/GuildInfoNewSection$itemClickListener$2$a", h.F, "Lkotlin/Lazy;", "u", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/content/guildinfo/section/GuildInfoNewSection$itemClickListener$2$a;", "itemClickListener", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildInfoNewSection extends a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TextView titleTv;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private GuildInfoGuideBar guildInfoBar;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private LinearLayout container;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy itemClickListener;

    public GuildInfoNewSection() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GuildInfoNewSection$itemClickListener$2.a>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.guildinfo.section.GuildInfoNewSection$itemClickListener$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/content/guildinfo/section/GuildInfoNewSection$itemClickListener$2$a", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/widget/d;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "stFeed", "", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes13.dex */
            public static final class a implements d {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ GuildInfoNewSection f221154a;

                a(GuildInfoNewSection guildInfoNewSection) {
                    this.f221154a = guildInfoNewSection;
                }

                @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.widget.d
                public void a(@NotNull GProStFeed stFeed) {
                    rl1.b t16;
                    LinearLayout linearLayout;
                    Intrinsics.checkNotNullParameter(stFeed, "stFeed");
                    t16 = this.f221154a.t();
                    if (t16 != null) {
                        linearLayout = this.f221154a.container;
                        if (linearLayout == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
                            linearLayout = null;
                        }
                        t16.h1(stFeed, linearLayout);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a(GuildInfoNewSection.this);
            }
        });
        this.itemClickListener = lazy;
    }

    private final rl1.a s() {
        return (rl1.a) SectionIOCKt.getIocInterface(this, rl1.a.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final rl1.b t() {
        return (rl1.b) SectionIOCKt.getIocInterface(this, rl1.b.class);
    }

    private final GuildInfoNewSection$itemClickListener$2.a u() {
        return (GuildInfoNewSection$itemClickListener$2.a) this.itemClickListener.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(GuildInfoNewSection this$0, ql1.a data, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        rl1.b t16 = this$0.t();
        if (t16 != null) {
            t16.e9(data.getGuildInfo());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.wbw};
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        super.onDestroy();
        GuildInfoGuideBar guildInfoGuideBar = this.guildInfoBar;
        if (guildInfoGuideBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildInfoBar");
            guildInfoGuideBar = null;
        }
        guildInfoGuideBar.B();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        View findViewById = getRootView().findViewById(R.id.wjo);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.guild_info_title)");
        this.titleTv = (TextView) findViewById;
        View findViewById2 = getRootView().findViewById(R.id.w8r);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026ail_guild_info_guide_bar)");
        this.guildInfoBar = (GuildInfoGuideBar) findViewById2;
        View findViewById3 = getRootView().findViewById(R.id.f71233nl);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026end_feeds_list_container)");
        this.container = (LinearLayout) findViewById3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void onBindData(@NotNull final ql1.a data, int position, @Nullable List<Object> payload) {
        JumpGuildParam.JoinInfoParam joinInfoParam;
        Integer num;
        Intrinsics.checkNotNullParameter(data, "data");
        GuildInfoGuideBar guildInfoGuideBar = null;
        if (data.getLoadMainDataSuccess()) {
            TextView textView = this.titleTv;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleTv");
                textView = null;
            }
            TextView textView2 = this.titleTv;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleTv");
                textView2 = null;
            }
            textView.setText(textView2.getContext().getText(R.string.f1358702m));
        } else {
            TextView textView3 = this.titleTv;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleTv");
                textView3 = null;
            }
            TextView textView4 = this.titleTv;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleTv");
                textView4 = null;
            }
            textView3.setText(textView4.getContext().getText(R.string.f13823090));
        }
        GuildInfoGuideBar guildInfoGuideBar2 = this.guildInfoBar;
        if (guildInfoGuideBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildInfoBar");
            guildInfoGuideBar2 = null;
        }
        IGProGuildInfo guildInfo = data.getGuildInfo();
        rl1.a s16 = s();
        if (s16 != null) {
            joinInfoParam = s16.b();
        } else {
            joinInfoParam = null;
        }
        rl1.a s17 = s();
        if (s17 != null) {
            num = s17.getBusinessType();
        } else {
            num = null;
        }
        guildInfoGuideBar2.n(guildInfo, joinInfoParam, num, 1);
        GuildInfoGuideBar guildInfoGuideBar3 = this.guildInfoBar;
        if (guildInfoGuideBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildInfoBar");
            guildInfoGuideBar3 = null;
        }
        guildInfoGuideBar3.setGuildInfoOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.guildinfo.section.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildInfoNewSection.w(GuildInfoNewSection.this, data, view);
            }
        });
        GuildInfoGuideBar guildInfoGuideBar4 = this.guildInfoBar;
        if (guildInfoGuideBar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildInfoBar");
        } else {
            guildInfoGuideBar = guildInfoGuideBar4;
        }
        guildInfoGuideBar.l(data.d(), u(), data.getTraceId());
    }
}
