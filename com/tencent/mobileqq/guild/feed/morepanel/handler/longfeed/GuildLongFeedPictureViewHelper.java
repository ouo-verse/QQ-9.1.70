package com.tencent.mobileqq.guild.feed.morepanel.handler.longfeed;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.morepanel.handler.longfeed.GuildLongFeedPictureGenerator;
import com.tencent.mobileqq.guild.feed.morepanel.handler.longfeed.GuildLongFeedPictureViewHelper;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.data.GProStFeedDetailRspWrapper;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.LongFeedParseParam;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.LongFeedParseSceneType;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data.LongFeedUIData;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.TextViewContainer;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.FeedRichTextView;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.TrimSpaceType;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProElem;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import x12.n;

@Metadata(d1 = {"\u00003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u0012\u0010\f\u001a\u00020\u000b*\u00020\u00072\u0006\u0010\n\u001a\u00020\tR!\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/handler/longfeed/GuildLongFeedPictureViewHelper;", "", "com/tencent/mobileqq/guild/feed/morepanel/handler/longfeed/GuildLongFeedPictureViewHelper$a", "c", "()Lcom/tencent/mobileqq/guild/feed/morepanel/handler/longfeed/GuildLongFeedPictureViewHelper$a;", "Lx12/n;", "binding", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/richtextspan/TextViewContainer;", "d", "Lcom/tencent/mobileqq/guild/feed/morepanel/handler/longfeed/GuildLongFeedPictureGenerator$a;", "param", "", "b", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/IParseRichTextConfig;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProElem;", "Lkotlin/Lazy;", "e", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/IParseRichTextConfig;", "textParseConfig", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildLongFeedPictureViewHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildLongFeedPictureViewHelper f220347a = new GuildLongFeedPictureViewHelper();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy textParseConfig;

    @Metadata(d1 = {"\u0000S\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0004\u001a\u00020\u0003H\u0096\u0001J%\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bH\u0096\u0001J\t\u0010\u000b\u001a\u00020\nH\u0096\u0001J\t\u0010\f\u001a\u00020\nH\u0096\u0001J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\rH\u0096\u0001J\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\u0002H\u0096\u0001J\t\u0010\u0011\u001a\u00020\nH\u0096\u0001J\t\u0010\u0013\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u0014\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u0015\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u0016\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u0017\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u0018\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u0019\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u001a\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u001b\u001a\u00020\u0012H\u0096\u0001J\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u001cH\u0096\u0001J\u0010\u0010\u001e\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010 \u001a\u00020\u001fH\u0016J\b\u0010!\u001a\u00020\u0012H\u0016J\b\u0010\"\u001a\u00020\nH\u0016J\n\u0010#\u001a\u0004\u0018\u00010\u0006H\u0016R\u0014\u0010&\u001a\u00020\n8\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b$\u0010%\u00a8\u0006'"}, d2 = {"com/tencent/mobileqq/guild/feed/morepanel/handler/longfeed/GuildLongFeedPictureViewHelper$a", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/IParseRichTextConfig;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProElem;", "", "l", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "c", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "t", "", "getHighlightWords", "Landroid/graphics/drawable/Drawable;", "v", ReportConstant.COSTREPORT_PREFIX, "", "g", "i", h.F, "u", "k", "o", "e", "d", "b", "", "r", "w", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/TrimSpaceType;", "f", "j", "p", "getTraceID", DomainData.DOMAIN_NAME, "()I", "linkColor", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements IParseRichTextConfig<GProElem> {

        /* renamed from: b, reason: collision with root package name */
        private final /* synthetic */ IParseRichTextConfig<GProElem> f220349b = IParseRichTextConfig.INSTANCE.a();

        a() {
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean b() {
            return this.f220349b.b();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @NotNull
        public HashMap<String, Object> c() {
            return this.f220349b.c();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean d() {
            return this.f220349b.d();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean e() {
            return this.f220349b.e();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @NotNull
        public TrimSpaceType f() {
            return TrimSpaceType.None;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean g() {
            return this.f220349b.g();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @NotNull
        public Collection<String> getHighlightWords() {
            return this.f220349b.getHighlightWords();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @Nullable
        /* renamed from: getTraceID */
        public String getF221023e() {
            return "";
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean h() {
            return this.f220349b.h();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean i() {
            return this.f220349b.i();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean j() {
            return true;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean k() {
            return this.f220349b.k();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public float l() {
            return this.f220349b.l();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public int n() {
            return this.f220349b.n();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean o() {
            return this.f220349b.o();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        /* renamed from: p */
        public int getF221022d() {
            return 20;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public int q() {
            return this.f220349b.q();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @Nullable
        public Set<Integer> r() {
            return this.f220349b.r();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public int s() {
            return this.f220349b.s();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public int t() {
            return this.f220349b.t();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean u() {
            return this.f220349b.u();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @Nullable
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        public Drawable m(@NotNull GProElem t16) {
            Intrinsics.checkNotNullParameter(t16, "t");
            return this.f220349b.m(t16);
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public boolean a(@NotNull GProElem t16) {
            Intrinsics.checkNotNullParameter(t16, "t");
            if (t16.type == 4 && t16.url.urlContent.type == 3) {
                return false;
            }
            return true;
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<a>() { // from class: com.tencent.mobileqq.guild.feed.morepanel.handler.longfeed.GuildLongFeedPictureViewHelper$textParseConfig$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildLongFeedPictureViewHelper.a invoke() {
                GuildLongFeedPictureViewHelper.a c16;
                c16 = GuildLongFeedPictureViewHelper.f220347a.c();
                return c16;
            }
        });
        textParseConfig = lazy;
    }

    GuildLongFeedPictureViewHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final a c() {
        return new a();
    }

    private final IParseRichTextConfig<GProElem> e() {
        return (IParseRichTextConfig) textParseConfig.getValue();
    }

    public final void b(@NotNull TextViewContainer textViewContainer, @NotNull GuildLongFeedPictureGenerator.GeneratorParam param) {
        Intrinsics.checkNotNullParameter(textViewContainer, "<this>");
        Intrinsics.checkNotNullParameter(param, "param");
        LongFeedUIData C = new GProStFeedDetailRspWrapper(param.getFeedInfo(), null, 2, 0 == true ? 1 : 0).C(new LongFeedParseParam(textViewContainer, new WeakReference(null), null, 0, null, e(), LongFeedParseSceneType.SHARE, null, 128, null));
        textViewContainer.setText(C.getSpannable(), C.b(), true);
        if ((textViewContainer.s() instanceof FeedRichTextView) && C.getHasItalicText()) {
            TextView s16 = textViewContainer.s();
            Intrinsics.checkNotNull(s16, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.FeedRichTextView");
            ((FeedRichTextView) s16).setCheckItalicText();
            textViewContainer.s().requestLayout();
        }
    }

    @NotNull
    public final TextViewContainer d(@NotNull n binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Context context = binding.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "binding.root.context");
        FeedRichTextView feedRichTextView = new FeedRichTextView(context);
        TextViewContainer textViewContainer = new TextViewContainer(binding.getRoot().getContext(), null, 0, 0, feedRichTextView);
        textViewContainer.setClipChildren(false);
        feedRichTextView.setClickable(false);
        feedRichTextView.setFocusable(false);
        feedRichTextView.setLineSpacing(26.0f, 1.0f);
        feedRichTextView.setTextSize(18.0f);
        feedRichTextView.setLetterSpacing(0.01875f);
        feedRichTextView.setBreakStrategy(0);
        feedRichTextView.setTextColor(feedRichTextView.getResources().getColorStateList(R.color.qui_common_text_primary));
        binding.f446963b.addView(textViewContainer, 0, new ViewGroup.LayoutParams(-1, -2));
        return textViewContainer;
    }
}
