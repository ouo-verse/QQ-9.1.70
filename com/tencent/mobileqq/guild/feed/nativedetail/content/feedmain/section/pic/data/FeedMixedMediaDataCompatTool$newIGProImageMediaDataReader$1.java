package com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.pic.data;

import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.pic.data.FeedMixedMediaDataCompatTool;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProImage;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProThumbImage;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u001d\u0010\u0007\u001a\u0004\u0018\u00010\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001d\u0010\t\u001a\u0004\u0018\u00010\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\b\u0010\u0006R'\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0010R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00128VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00128VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014R\u0014\u0010\u001a\u001a\u00020\u000b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u000b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u000b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u0019R\u0014\u0010 \u001a\u00020\u000b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010\u0019\u00a8\u0006!"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/pic/data/FeedMixedMediaDataCompatTool$newIGProImageMediaDataReader$1", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/pic/data/FeedMixedMediaDataCompatTool$a;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProThumbImage;", "b", "Lkotlin/Lazy;", "e", "()Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProThumbImage;", "thumbImage", "c", "image", "Lkotlin/Pair;", "", "d", "()Lkotlin/Pair;", "picSize", "", "Z", NodeProps.CUSTOM_PROP_ISGIF, "", "getThumbUrl", "()Ljava/lang/String;", "thumbUrl", "getPicUrl", "picUrl", "getDisplayIndex", "()I", "displayIndex", "getWidth", "width", "getHeight", "height", "getType", "type", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedMixedMediaDataCompatTool$newIGProImageMediaDataReader$1 extends FeedMixedMediaDataCompatTool.a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy thumbImage;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy image;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy picSize;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean isGif;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ IGProImage f221136f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedMixedMediaDataCompatTool$newIGProImageMediaDataReader$1(final IGProImage iGProImage) {
        super(iGProImage);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        this.f221136f = iGProImage;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<IGProThumbImage>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.pic.data.FeedMixedMediaDataCompatTool$newIGProImageMediaDataReader$1$thumbImage$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final IGProThumbImage invoke() {
                ArrayList<IGProThumbImage> thumbImages = IGProImage.this.getThumbImages();
                Object obj = null;
                if (thumbImages == null) {
                    return null;
                }
                Iterator<T> it = thumbImages.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (((IGProThumbImage) next).getLevel() == 2) {
                        obj = next;
                        break;
                    }
                }
                return (IGProThumbImage) obj;
            }
        });
        this.thumbImage = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<IGProThumbImage>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.pic.data.FeedMixedMediaDataCompatTool$newIGProImageMediaDataReader$1$image$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final IGProThumbImage invoke() {
                ArrayList<IGProThumbImage> thumbImages = IGProImage.this.getThumbImages();
                Object obj = null;
                if (thumbImages == null) {
                    return null;
                }
                Iterator<T> it = thumbImages.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (((IGProThumbImage) next).getLevel() == 3) {
                        obj = next;
                        break;
                    }
                }
                return (IGProThumbImage) obj;
            }
        });
        this.image = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Pair<? extends Integer, ? extends Integer>>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.pic.data.FeedMixedMediaDataCompatTool$newIGProImageMediaDataReader$1$picSize$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Pair<? extends Integer, ? extends Integer> invoke() {
                IGProThumbImage c16;
                Pair<? extends Integer, ? extends Integer> pair;
                c16 = FeedMixedMediaDataCompatTool$newIGProImageMediaDataReader$1.this.c();
                if (c16 != null) {
                    if (!((c16.getWidth() == 0 || c16.getHeight() == 0) ? false : true)) {
                        c16 = null;
                    }
                    if (c16 != null && (pair = TuplesKt.to(Integer.valueOf(c16.getWidth()), Integer.valueOf(c16.getHeight()))) != null) {
                        return pair;
                    }
                }
                return TuplesKt.to(Integer.valueOf(iGProImage.getWidth()), Integer.valueOf(iGProImage.getHeight()));
            }
        });
        this.picSize = lazy3;
        this.isGif = iGProImage.getImageType() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGProThumbImage c() {
        return (IGProThumbImage) this.image.getValue();
    }

    private final Pair<Integer, Integer> d() {
        return (Pair) this.picSize.getValue();
    }

    private final IGProThumbImage e() {
        return (IGProThumbImage) this.thumbImage.getValue();
    }

    @Override // qj1.l
    public int getDisplayIndex() {
        return this.f221136f.getDisplayIndex();
    }

    @Override // qj1.l
    public int getHeight() {
        return d().getSecond().intValue();
    }

    @Override // qj1.l
    @NotNull
    public String getPicUrl() {
        IGProThumbImage c16 = c();
        String str = null;
        if (c16 != null) {
            if (this.isGif) {
                c16 = null;
            }
            if (c16 != null) {
                str = c16.getUrl();
            }
        }
        if (str == null) {
            String url = this.f221136f.getUrl();
            Intrinsics.checkNotNullExpressionValue(url, "src.url");
            return url;
        }
        return str;
    }

    @Override // qj1.l
    @Nullable
    public String getThumbUrl() {
        String url;
        IGProThumbImage e16 = e();
        if (e16 != null) {
            if (this.isGif) {
                e16 = null;
            }
            if (e16 != null && (url = e16.getUrl()) != null) {
                return url;
            }
        }
        return this.f221136f.getUrl();
    }

    @Override // qj1.l
    public int getType() {
        if (this.isGif) {
            return 3;
        }
        return 1;
    }

    @Override // qj1.l
    public int getWidth() {
        return d().getFirst().intValue();
    }
}
