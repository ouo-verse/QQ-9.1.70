package lp0;

import com.tencent.guild.api.media.album.GuildAlbumMediaType;
import com.tencent.guild.api.media.album.GuildPickPhotoResult;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import fo0.e;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sr0.a;
import sr0.b;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007J\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\nJ\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0004J(\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0012H\u0007J\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u000f\u001a\u00020\u0002J4\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00122\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002J\u001e\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0002\u00a8\u0006 "}, d2 = {"Llp0/a;", "", "", "content", "", "Lsr0/b;", "g", "Lfo0/e$l;", "intent", "f", "Lfo0/e$k;", "e", "Lcom/tencent/guild/api/media/album/d;", "mediaList", h.F, "originPath", "", CustomImageProps.QUALITY, "", QCircleLpReportDc010001.KEY_SUBTYPE, "b", "a", "subBusiType", "thumbPath", "d", "", "replyMsgId", "replyNick", "replyContent", "i", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f415333a = new a();

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: lp0.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public /* synthetic */ class C10741a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f415334a;

        static {
            int[] iArr = new int[GuildAlbumMediaType.values().length];
            try {
                iArr[GuildAlbumMediaType.VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GuildAlbumMediaType.PHOTO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f415334a = iArr;
        }
    }

    a() {
    }

    public static /* synthetic */ List c(a aVar, String str, boolean z16, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = 0;
        }
        return aVar.b(str, z16, i3);
    }

    @NotNull
    public final List<b> a(@NotNull String originPath) {
        List<b> listOf;
        Intrinsics.checkNotNullParameter(originPath, "originPath");
        b bVar = new b(3, 0, 2, null);
        bVar.i(new a.FileElement(originPath));
        listOf = CollectionsKt__CollectionsJVMKt.listOf(bVar);
        return listOf;
    }

    @JvmOverloads
    @NotNull
    public final List<b> b(@NotNull String originPath, boolean quality, int subType) {
        List<b> listOf;
        Intrinsics.checkNotNullParameter(originPath, "originPath");
        b bVar = new b(2, 0, 2, null);
        bVar.j(new a.AIOPicElement(originPath, quality, subType));
        listOf = CollectionsKt__CollectionsJVMKt.listOf(bVar);
        return listOf;
    }

    @NotNull
    public final List<b> d(@NotNull String originPath, int subBusiType, boolean quality, @Nullable String thumbPath) {
        List<b> listOf;
        Intrinsics.checkNotNullParameter(originPath, "originPath");
        b bVar = new b(5, 0, 2, null);
        bVar.m(new a.VideoElement(originPath, subBusiType, quality, thumbPath));
        listOf = CollectionsKt__CollectionsJVMKt.listOf(bVar);
        return listOf;
    }

    @NotNull
    public final List<b> e(@NotNull e.InputSendMultiTextIntent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        ArrayList arrayList = new ArrayList();
        if (intent.b().isEmpty()) {
            return arrayList;
        }
        Iterator<e.InputSendTextIntent> it = intent.b().iterator();
        while (it.hasNext()) {
            arrayList.addAll(com.tencent.guild.aio.util.e.f112380a.e(it.next()));
        }
        e.ReplyData replyData = intent.getReplyData();
        if (replyData != null) {
            b bVar = new b(7, 0, 2, null);
            bVar.k(new a.ReplyElement(replyData.getReplyMsgId(), replyData.getReplyNick(), replyData.getReplyContent()));
            arrayList.add(bVar);
        }
        return arrayList;
    }

    @NotNull
    public final List<b> f(@NotNull e.InputSendTextIntent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return com.tencent.guild.aio.util.e.f112380a.e(intent);
    }

    @NotNull
    public final List<b> g(@NotNull String content) {
        List split$default;
        Intrinsics.checkNotNullParameter(content, "content");
        ArrayList arrayList = new ArrayList();
        split$default = StringsKt__StringsKt.split$default((CharSequence) content, new String[]{"|"}, false, 0, 6, (Object) null);
        if (!(!split$default.isEmpty())) {
            split$default = null;
        }
        if (split$default != null) {
            return com.tencent.guild.aio.util.e.g(com.tencent.guild.aio.util.e.f112380a, content, 0, 0L, 0L, null, 30, null);
        }
        return arrayList;
    }

    @NotNull
    public final List<b> h(@NotNull List<GuildPickPhotoResult> mediaList) {
        int i3;
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        ArrayList arrayList = new ArrayList(mediaList.size());
        for (GuildPickPhotoResult guildPickPhotoResult : mediaList) {
            String localPath = guildPickPhotoResult.getLocalPath();
            if (localPath != null) {
                int i16 = C10741a.f415334a[guildPickPhotoResult.getResultUriType().ordinal()];
                if (i16 != 1) {
                    if (i16 != 2) {
                        arrayList.addAll(c(f415333a, localPath, guildPickPhotoResult.getQuality(), 0, 4, null));
                    } else {
                        if (ur0.a.f439860a.a(new File(localPath))) {
                            i3 = 11;
                        } else {
                            i3 = 0;
                        }
                        arrayList.addAll(f415333a.b(localPath, guildPickPhotoResult.getQuality(), i3));
                    }
                } else {
                    arrayList.addAll(f415333a.d(localPath, 4601, guildPickPhotoResult.getQuality(), guildPickPhotoResult.getThumbPath()));
                }
            }
        }
        return arrayList;
    }

    @NotNull
    public final b i(long replyMsgId, @NotNull String replyNick, @NotNull String replyContent) {
        Intrinsics.checkNotNullParameter(replyNick, "replyNick");
        Intrinsics.checkNotNullParameter(replyContent, "replyContent");
        b bVar = new b(7, 0, 2, null);
        bVar.k(new a.ReplyElement(replyMsgId, replyNick, replyContent));
        return bVar;
    }
}
