package com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.FeedRichTextContentParser;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.d;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextURLContent;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\n\bf\u0018\u0000 \b*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001(J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0003\u001a\u00020\u000bH\u0016J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\b\u0010\u0013\u001a\u00020\u0007H\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\b\u0010\u0018\u001a\u00020\u0007H\u0016J\b\u0010\u0019\u001a\u00020\u000bH\u0016J$\u0010\u001c\u001a\u001e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00020\u001aj\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0002`\u001bH\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u001e\u001a\u00020\u0007H\u0016J\u0010\u0010 \u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001fH\u0016J\b\u0010!\u001a\u00020\u0007H\u0016J\b\u0010\"\u001a\u00020\u0007H\u0016J\b\u0010#\u001a\u00020\u0007H\u0016J\b\u0010$\u001a\u00020\u0007H\u0016R\u0014\u0010'\u001a\u00020\u000b8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b%\u0010&\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/IParseRichTextConfig;", "T", "", "t", "Landroid/graphics/drawable/Drawable;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Ljava/lang/Object;)Landroid/graphics/drawable/Drawable;", "", "a", "(Ljava/lang/Object;)Z", "d", "", "p", "", "l", "", "", "getHighlightWords", "b", "u", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/TrimSpaceType;", "f", "j", "e", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "c", "getTraceID", "o", "", "r", "k", "g", h.F, "i", DomainData.DOMAIN_NAME, "()I", "linkColor", "Companion", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface IParseRichTextConfig<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f221625a;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\"\u0004\b\u0001\u0010\u0002J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0003H\u0007J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0003H\u0007J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0003H\u0007J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0003H\u0007\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/IParseRichTextConfig$Companion;", "", "T", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/IParseRichTextConfig;", "a", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStRichTextContent;", "b", "c", "e", "d", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f221625a = new Companion();

        @Metadata(d1 = {"\u0000Q\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0004\u001a\u00020\u0003H\u0096\u0001J%\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bH\u0096\u0001J\t\u0010\u000b\u001a\u00020\nH\u0096\u0001J\t\u0010\f\u001a\u00020\nH\u0096\u0001J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\rH\u0096\u0001J\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\u0002H\u0096\u0001J\t\u0010\u0011\u001a\u00020\nH\u0096\u0001J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0096\u0001J\t\u0010\u0014\u001a\u00020\u0013H\u0096\u0001J\t\u0010\u0015\u001a\u00020\u0013H\u0096\u0001J\t\u0010\u0016\u001a\u00020\u0013H\u0096\u0001J\t\u0010\u0017\u001a\u00020\u0013H\u0096\u0001J\t\u0010\u0018\u001a\u00020\u0013H\u0096\u0001J\t\u0010\u0019\u001a\u00020\u0013H\u0096\u0001J\t\u0010\u001a\u001a\u00020\u0013H\u0096\u0001J\t\u0010\u001b\u001a\u00020\u0013H\u0096\u0001J\u0011\u0010\u001c\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0002H\u0096\u0001J\t\u0010\u001d\u001a\u00020\u0013H\u0096\u0001J\t\u0010\u001f\u001a\u00020\u001eH\u0096\u0001J\u0011\u0010!\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010 H\u0096\u0001J\b\u0010\"\u001a\u00020\nH\u0016J\b\u0010#\u001a\u00020\u0013H\u0016R\u0014\u0010&\u001a\u00020\n8\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b$\u0010%\u00a8\u0006'"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/IParseRichTextConfig$Companion$a", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/IParseRichTextConfig;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStRichTextContent;", "", "l", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "c", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "t", "", "getHighlightWords", "Landroid/graphics/drawable/Drawable;", "v", ReportConstant.COSTREPORT_PREFIX, "getTraceID", "", "g", "i", "j", h.F, "u", "k", "e", "d", "w", "b", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/TrimSpaceType;", "f", "", "r", "p", "o", DomainData.DOMAIN_NAME, "()I", "linkColor", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes13.dex */
        public static final class a implements IParseRichTextConfig<GProStRichTextContent> {

            /* renamed from: b, reason: collision with root package name */
            private final /* synthetic */ IParseRichTextConfig<GProStRichTextContent> f221626b = Companion.f221625a.a();

            a() {
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public boolean b() {
                return this.f221626b.b();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            @NotNull
            public HashMap<String, Object> c() {
                return this.f221626b.c();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public boolean d() {
                return this.f221626b.d();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public boolean e() {
                return this.f221626b.e();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            @NotNull
            public TrimSpaceType f() {
                return this.f221626b.f();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public boolean g() {
                return this.f221626b.g();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            @NotNull
            public Collection<String> getHighlightWords() {
                return this.f221626b.getHighlightWords();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            @Nullable
            public String getTraceID() {
                return this.f221626b.getTraceID();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public boolean h() {
                return this.f221626b.h();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public boolean i() {
                return this.f221626b.i();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public boolean j() {
                return this.f221626b.j();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public boolean k() {
                return this.f221626b.k();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public float l() {
                return this.f221626b.l();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public int n() {
                return this.f221626b.n();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public boolean o() {
                return false;
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public int p() {
                return 16;
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public int q() {
                return this.f221626b.q();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            @Nullable
            public Set<Integer> r() {
                return this.f221626b.r();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public int s() {
                return this.f221626b.s();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public int t() {
                return this.f221626b.t();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public boolean u() {
                return this.f221626b.u();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            @Nullable
            /* renamed from: v, reason: merged with bridge method [inline-methods] */
            public Drawable m(@NotNull GProStRichTextContent t16) {
                Intrinsics.checkNotNullParameter(t16, "t");
                return this.f221626b.m(t16);
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public boolean a(@NotNull GProStRichTextContent t16) {
                Intrinsics.checkNotNullParameter(t16, "t");
                return this.f221626b.a(t16);
            }
        }

        @Metadata(d1 = {"\u0000Q\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0004\u001a\u00020\u0003H\u0096\u0001J%\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bH\u0096\u0001J\t\u0010\u000b\u001a\u00020\nH\u0096\u0001J\t\u0010\f\u001a\u00020\nH\u0096\u0001J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\rH\u0096\u0001J\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\u0002H\u0096\u0001J\t\u0010\u0011\u001a\u00020\nH\u0096\u0001J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0096\u0001J\t\u0010\u0014\u001a\u00020\u0013H\u0096\u0001J\t\u0010\u0015\u001a\u00020\u0013H\u0096\u0001J\t\u0010\u0016\u001a\u00020\u0013H\u0096\u0001J\t\u0010\u0017\u001a\u00020\u0013H\u0096\u0001J\t\u0010\u0018\u001a\u00020\u0013H\u0096\u0001J\t\u0010\u0019\u001a\u00020\u0013H\u0096\u0001J\t\u0010\u001a\u001a\u00020\u0013H\u0096\u0001J\u0011\u0010\u001b\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0002H\u0096\u0001J\t\u0010\u001c\u001a\u00020\u0013H\u0096\u0001J\t\u0010\u001e\u001a\u00020\u001dH\u0096\u0001J\u0011\u0010 \u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u001fH\u0096\u0001J\b\u0010!\u001a\u00020\nH\u0016J\b\u0010\"\u001a\u00020\u0013H\u0016J\b\u0010#\u001a\u00020\u0013H\u0016R\u0014\u0010&\u001a\u00020\n8\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b$\u0010%\u00a8\u0006'"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/IParseRichTextConfig$Companion$b", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/IParseRichTextConfig;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStRichTextContent;", "", "l", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "c", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "t", "", "getHighlightWords", "Landroid/graphics/drawable/Drawable;", "v", ReportConstant.COSTREPORT_PREFIX, "getTraceID", "", "i", "j", h.F, "u", "k", "e", "d", "w", "b", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/TrimSpaceType;", "f", "", "r", "p", "o", "g", DomainData.DOMAIN_NAME, "()I", "linkColor", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes13.dex */
        public static final class b implements IParseRichTextConfig<GProStRichTextContent> {

            /* renamed from: b, reason: collision with root package name */
            private final /* synthetic */ IParseRichTextConfig<GProStRichTextContent> f221627b = Companion.f221625a.a();

            b() {
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public boolean b() {
                return this.f221627b.b();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            @NotNull
            public HashMap<String, Object> c() {
                return this.f221627b.c();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public boolean d() {
                return this.f221627b.d();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public boolean e() {
                return this.f221627b.e();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            @NotNull
            public TrimSpaceType f() {
                return this.f221627b.f();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public boolean g() {
                return false;
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            @NotNull
            public Collection<String> getHighlightWords() {
                return this.f221627b.getHighlightWords();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            @Nullable
            public String getTraceID() {
                return this.f221627b.getTraceID();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public boolean h() {
                return this.f221627b.h();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public boolean i() {
                return this.f221627b.i();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public boolean j() {
                return this.f221627b.j();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public boolean k() {
                return this.f221627b.k();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public float l() {
                return this.f221627b.l();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public int n() {
                return this.f221627b.n();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public boolean o() {
                return false;
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public int p() {
                return 16;
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public int q() {
                return this.f221627b.q();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            @Nullable
            public Set<Integer> r() {
                return this.f221627b.r();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public int s() {
                return this.f221627b.s();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public int t() {
                return this.f221627b.t();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public boolean u() {
                return this.f221627b.u();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            @Nullable
            /* renamed from: v, reason: merged with bridge method [inline-methods] */
            public Drawable m(@NotNull GProStRichTextContent t16) {
                Intrinsics.checkNotNullParameter(t16, "t");
                return this.f221627b.m(t16);
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public boolean a(@NotNull GProStRichTextContent t16) {
                Intrinsics.checkNotNullParameter(t16, "t");
                return this.f221627b.a(t16);
            }
        }

        @Metadata(d1 = {"\u0000S\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0004\u001a\u00020\u0003H\u0096\u0001J%\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bH\u0096\u0001J\t\u0010\u000b\u001a\u00020\nH\u0096\u0001J\t\u0010\f\u001a\u00020\nH\u0096\u0001J\t\u0010\r\u001a\u00020\nH\u0096\u0001J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eH\u0096\u0001J\t\u0010\u0010\u001a\u00020\nH\u0096\u0001J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0006H\u0096\u0001J\t\u0010\u0013\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u0014\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u0015\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u0016\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u0017\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u0018\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u0019\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u001a\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u001c\u001a\u00020\u001bH\u0096\u0001J\u0011\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u001dH\u0096\u0001J\b\u0010\u001f\u001a\u00020\u0012H\u0016J\u0010\u0010 \u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u0002H\u0016J\u0012\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010#\u001a\u00020\u0012H\u0016R\u0014\u0010&\u001a\u00020\n8\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b$\u0010%\u00a8\u0006'"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/IParseRichTextConfig$Companion$c", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/IParseRichTextConfig;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStRichTextContent;", "", "l", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "c", "", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "t", "", "getHighlightWords", ReportConstant.COSTREPORT_PREFIX, "getTraceID", "", "g", "i", "j", "u", "k", "e", "d", "b", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/TrimSpaceType;", "f", "", "r", h.F, "w", "Landroid/graphics/drawable/Drawable;", "v", "o", DomainData.DOMAIN_NAME, "()I", "linkColor", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes13.dex */
        public static final class c implements IParseRichTextConfig<GProStRichTextContent> {

            /* renamed from: b, reason: collision with root package name */
            private final /* synthetic */ IParseRichTextConfig<GProStRichTextContent> f221628b = Companion.f221625a.a();

            c() {
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public boolean b() {
                return this.f221628b.b();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            @NotNull
            public HashMap<String, Object> c() {
                return this.f221628b.c();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public boolean d() {
                return this.f221628b.d();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public boolean e() {
                return this.f221628b.e();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            @NotNull
            public TrimSpaceType f() {
                return this.f221628b.f();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public boolean g() {
                return this.f221628b.g();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            @NotNull
            public Collection<String> getHighlightWords() {
                return this.f221628b.getHighlightWords();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            @Nullable
            public String getTraceID() {
                return this.f221628b.getTraceID();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public boolean h() {
                return false;
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public boolean i() {
                return this.f221628b.i();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public boolean j() {
                return this.f221628b.j();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public boolean k() {
                return this.f221628b.k();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public float l() {
                return this.f221628b.l();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public int n() {
                return this.f221628b.n();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public boolean o() {
                return false;
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public int p() {
                return this.f221628b.p();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public int q() {
                return this.f221628b.q();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            @Nullable
            public Set<Integer> r() {
                return this.f221628b.r();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public int s() {
                return this.f221628b.s();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public int t() {
                return this.f221628b.t();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public boolean u() {
                return this.f221628b.u();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            @Nullable
            /* renamed from: v, reason: merged with bridge method [inline-methods] */
            public Drawable m(@NotNull GProStRichTextContent t16) {
                Intrinsics.checkNotNullParameter(t16, "t");
                com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.c cVar = com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.c.f221632a;
                BaseApplication context = BaseApplication.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext()");
                return com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.c.c(cVar, t16, context, null, 4, null);
            }

            /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000c. Please report as an issue. */
            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public boolean a(@NotNull GProStRichTextContent t16) {
                Intrinsics.checkNotNullParameter(t16, "t");
                GProStRichTextURLContent gProStRichTextURLContent = t16.urlContent;
                switch (gProStRichTextURLContent.type) {
                    case 8:
                    case 9:
                        String str = gProStRichTextURLContent.thirdVideoInfo.cover;
                        if (str == null || str.length() == 0) {
                            return true;
                        }
                        break;
                    case 6:
                    case 7:
                        return false;
                    default:
                        return true;
                }
            }
        }

        @Metadata(d1 = {"\u0000S\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J%\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006H\u0096\u0001J\t\u0010\t\u001a\u00020\bH\u0096\u0001J\t\u0010\n\u001a\u00020\bH\u0096\u0001J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bH\u0096\u0001J\u0013\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\u0002H\u0096\u0001J\t\u0010\u000f\u001a\u00020\bH\u0096\u0001J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0096\u0001J\t\u0010\u0012\u001a\u00020\u0011H\u0096\u0001J\t\u0010\u0013\u001a\u00020\u0011H\u0096\u0001J\t\u0010\u0014\u001a\u00020\u0011H\u0096\u0001J\t\u0010\u0015\u001a\u00020\u0011H\u0096\u0001J\t\u0010\u0016\u001a\u00020\u0011H\u0096\u0001J\t\u0010\u0017\u001a\u00020\u0011H\u0096\u0001J\t\u0010\u0018\u001a\u00020\u0011H\u0096\u0001J\t\u0010\u0019\u001a\u00020\u0011H\u0096\u0001J\t\u0010\u001a\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010\u001b\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u0002H\u0096\u0001J\t\u0010\u001c\u001a\u00020\u0011H\u0096\u0001J\t\u0010\u001e\u001a\u00020\u001dH\u0096\u0001J\u0011\u0010 \u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u001fH\u0096\u0001J\b\u0010!\u001a\u00020\bH\u0016J\b\u0010#\u001a\u00020\"H\u0016R\u0014\u0010&\u001a\u00020\b8\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b$\u0010%\u00a8\u0006'"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/IParseRichTextConfig$Companion$d", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/IParseRichTextConfig;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStRichTextContent;", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "c", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "t", "", "getHighlightWords", "Landroid/graphics/drawable/Drawable;", "v", ReportConstant.COSTREPORT_PREFIX, "getTraceID", "", "g", "i", "j", h.F, "u", "k", "o", "e", "d", "w", "b", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/TrimSpaceType;", "f", "", "r", "p", "", "l", DomainData.DOMAIN_NAME, "()I", "linkColor", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes13.dex */
        public static final class d implements IParseRichTextConfig<GProStRichTextContent> {

            /* renamed from: b, reason: collision with root package name */
            private final /* synthetic */ IParseRichTextConfig<GProStRichTextContent> f221629b = Companion.f221625a.a();

            d() {
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public boolean b() {
                return this.f221629b.b();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            @NotNull
            public HashMap<String, Object> c() {
                return this.f221629b.c();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public boolean d() {
                return this.f221629b.d();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public boolean e() {
                return this.f221629b.e();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            @NotNull
            public TrimSpaceType f() {
                return this.f221629b.f();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public boolean g() {
                return this.f221629b.g();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            @NotNull
            public Collection<String> getHighlightWords() {
                return this.f221629b.getHighlightWords();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            @Nullable
            public String getTraceID() {
                return this.f221629b.getTraceID();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public boolean h() {
                return this.f221629b.h();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public boolean i() {
                return this.f221629b.i();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public boolean j() {
                return this.f221629b.j();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public boolean k() {
                return this.f221629b.k();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public float l() {
                return 13.0f;
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public int n() {
                return this.f221629b.n();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public boolean o() {
                return this.f221629b.o();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public int p() {
                return 13;
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public int q() {
                return this.f221629b.q();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            @Nullable
            public Set<Integer> r() {
                return this.f221629b.r();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public int s() {
                return this.f221629b.s();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public int t() {
                return this.f221629b.t();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public boolean u() {
                return this.f221629b.u();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            @Nullable
            /* renamed from: v, reason: merged with bridge method [inline-methods] */
            public Drawable m(@NotNull GProStRichTextContent t16) {
                Intrinsics.checkNotNullParameter(t16, "t");
                return this.f221629b.m(t16);
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public boolean a(@NotNull GProStRichTextContent t16) {
                Intrinsics.checkNotNullParameter(t16, "t");
                return this.f221629b.a(t16);
            }
        }

        Companion() {
        }

        @NotNull
        public final <T> IParseRichTextConfig<T> a() {
            return new IParseRichTextConfig<T>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig$Companion$defaultConfig$1

                /* renamed from: b, reason: collision with root package name and from kotlin metadata */
                @NotNull
                private final Lazy linkColor;

                /* renamed from: c, reason: collision with root package name and from kotlin metadata */
                @NotNull
                private final Lazy linkDrawable;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    Lazy lazy;
                    Lazy lazy2;
                    lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig$Companion$defaultConfig$1$linkColor$2
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        @NotNull
                        public final Integer invoke() {
                            BaseApplication context = BaseApplication.getContext();
                            Intrinsics.checkNotNullExpressionValue(context, "getContext()");
                            return Integer.valueOf(new com.tencent.mobileqq.guild.quiprofile.c(context, null, 0, false, 14, null).getColor(R.color.qui_common_text_link));
                        }
                    });
                    this.linkColor = lazy;
                    lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Drawable>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig$Companion$defaultConfig$1$linkDrawable$2
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        @Nullable
                        public final Drawable invoke() {
                            BaseApplication context = BaseApplication.getContext();
                            Intrinsics.checkNotNullExpressionValue(context, "getContext()");
                            Drawable drawable = new com.tencent.mobileqq.guild.quiprofile.c(context, null, 0, false, 14, null).getDrawable(R.drawable.guild_feed_url_icon_link);
                            if (drawable != null) {
                                int i3 = FeedRichTextContentParser.f221395c;
                                drawable.setBounds(0, 0, i3, i3);
                            } else {
                                drawable = null;
                            }
                            return d.l(drawable);
                        }
                    });
                    this.linkDrawable = lazy2;
                }

                @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
                public boolean a(T t16) {
                    return IParseRichTextConfig.a.s(this, t16);
                }

                @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
                public boolean b() {
                    return IParseRichTextConfig.a.t(this);
                }

                @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
                @NotNull
                public HashMap<String, Object> c() {
                    return IParseRichTextConfig.a.b(this);
                }

                @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
                public boolean d() {
                    return IParseRichTextConfig.a.r(this);
                }

                @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
                public boolean e() {
                    return IParseRichTextConfig.a.q(this);
                }

                @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
                @NotNull
                public TrimSpaceType f() {
                    return IParseRichTextConfig.a.u(this);
                }

                @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
                public boolean g() {
                    return IParseRichTextConfig.a.j(this);
                }

                @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
                @NotNull
                public Collection<String> getHighlightWords() {
                    return IParseRichTextConfig.a.f(this);
                }

                @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
                @Nullable
                public String getTraceID() {
                    return IParseRichTextConfig.a.i(this);
                }

                @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
                public boolean h() {
                    return IParseRichTextConfig.a.m(this);
                }

                @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
                public boolean i() {
                    return IParseRichTextConfig.a.k(this);
                }

                @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
                public boolean j() {
                    return IParseRichTextConfig.a.l(this);
                }

                @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
                public boolean k() {
                    return IParseRichTextConfig.a.o(this);
                }

                @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
                public float l() {
                    return IParseRichTextConfig.a.a(this);
                }

                @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
                @Nullable
                public Drawable m(T t16) {
                    return IParseRichTextConfig.a.g(this, t16);
                }

                @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
                public int n() {
                    return ((Number) this.linkColor.getValue()).intValue();
                }

                @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
                public boolean o() {
                    return IParseRichTextConfig.a.p(this);
                }

                @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
                public int p() {
                    return IParseRichTextConfig.a.c(this);
                }

                @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
                public int q() {
                    return IParseRichTextConfig.a.d(this);
                }

                @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
                @Nullable
                public Set<Integer> r() {
                    return IParseRichTextConfig.a.v(this);
                }

                @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
                public int s() {
                    return IParseRichTextConfig.a.h(this);
                }

                @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
                public int t() {
                    return IParseRichTextConfig.a.e(this);
                }

                @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
                public boolean u() {
                    return IParseRichTextConfig.a.n(this);
                }
            };
        }

        @JvmStatic
        @NotNull
        public final IParseRichTextConfig<GProStRichTextContent> b() {
            return new a();
        }

        @JvmStatic
        @NotNull
        public final IParseRichTextConfig<GProStRichTextContent> c() {
            return new b();
        }

        @JvmStatic
        @NotNull
        public final IParseRichTextConfig<GProStRichTextContent> d() {
            return new c();
        }

        @JvmStatic
        @NotNull
        public final IParseRichTextConfig<GProStRichTextContent> e() {
            return new d();
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class a {
        public static <T> float a(@NotNull IParseRichTextConfig<T> iParseRichTextConfig) {
            return 20.0f;
        }

        @NotNull
        public static <T> HashMap<String, Object> b(@NotNull IParseRichTextConfig<T> iParseRichTextConfig) {
            return new HashMap<>();
        }

        public static <T> int c(@NotNull IParseRichTextConfig<T> iParseRichTextConfig) {
            return 20;
        }

        public static <T> int d(@NotNull IParseRichTextConfig<T> iParseRichTextConfig) {
            return 0;
        }

        public static <T> int e(@NotNull IParseRichTextConfig<T> iParseRichTextConfig) {
            return -16777216;
        }

        @NotNull
        public static <T> Collection<String> f(@NotNull IParseRichTextConfig<T> iParseRichTextConfig) {
            List emptyList;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }

        @Nullable
        public static <T> Drawable g(@NotNull IParseRichTextConfig<T> iParseRichTextConfig, T t16) {
            return null;
        }

        public static <T> int h(@NotNull IParseRichTextConfig<T> iParseRichTextConfig) {
            return 1;
        }

        @Nullable
        public static <T> String i(@NotNull IParseRichTextConfig<T> iParseRichTextConfig) {
            return "";
        }

        public static <T> boolean j(@NotNull IParseRichTextConfig<T> iParseRichTextConfig) {
            return true;
        }

        public static <T> boolean k(@NotNull IParseRichTextConfig<T> iParseRichTextConfig) {
            return true;
        }

        public static <T> boolean l(@NotNull IParseRichTextConfig<T> iParseRichTextConfig) {
            return false;
        }

        public static <T> boolean m(@NotNull IParseRichTextConfig<T> iParseRichTextConfig) {
            return true;
        }

        public static <T> boolean n(@NotNull IParseRichTextConfig<T> iParseRichTextConfig) {
            return false;
        }

        public static <T> boolean o(@NotNull IParseRichTextConfig<T> iParseRichTextConfig) {
            return true;
        }

        public static <T> boolean p(@NotNull IParseRichTextConfig<T> iParseRichTextConfig) {
            return true;
        }

        public static <T> boolean q(@NotNull IParseRichTextConfig<T> iParseRichTextConfig) {
            return false;
        }

        public static <T> boolean r(@NotNull IParseRichTextConfig<T> iParseRichTextConfig) {
            return false;
        }

        public static <T> boolean s(@NotNull IParseRichTextConfig<T> iParseRichTextConfig, T t16) {
            return true;
        }

        public static <T> boolean t(@NotNull IParseRichTextConfig<T> iParseRichTextConfig) {
            return false;
        }

        @NotNull
        public static <T> TrimSpaceType u(@NotNull IParseRichTextConfig<T> iParseRichTextConfig) {
            return TrimSpaceType.LeadingSpaceAndEmptyLine;
        }

        @Nullable
        public static <T> Set<Integer> v(@NotNull IParseRichTextConfig<T> iParseRichTextConfig) {
            return null;
        }
    }

    boolean a(T t16);

    boolean b();

    @NotNull
    HashMap<String, Object> c();

    boolean d();

    boolean e();

    @NotNull
    TrimSpaceType f();

    boolean g();

    @NotNull
    Collection<String> getHighlightWords();

    @Nullable
    String getTraceID();

    boolean h();

    boolean i();

    boolean j();

    boolean k();

    float l();

    @Nullable
    Drawable m(T t16);

    int n();

    boolean o();

    int p();

    int q();

    @Nullable
    Set<Integer> r();

    int s();

    int t();

    boolean u();
}
