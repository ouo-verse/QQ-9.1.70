package com.tencent.mobileqq.troop.homework.homework.submit.data;

import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.AudioItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.BaseItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.BaseMediaItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.ContentItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.ImageItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.MediaListItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.VideoItem;
import com.tencent.mobileqq.troop.homework.homework.submit.media.SubmitHomeworkMediaManager;
import com.tencent.mobileqq.troop.homework.homework.submit.sso.e;
import com.tencent.mobileqq.troop.homework.homework.submit.sso.f;
import com.tencent.mobileqq.troop.homework.homework.submit.sso.j;
import com.tencent.mobileqq.troop.homework.homework.submit.sso.k;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0005B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0006H\u0002J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\tH\u0002J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u000bH\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\rH\u0002J\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0010*\u00020\u000fH\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0010*\u00020\u000fH\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0012J\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u00162\u0006\u0010\u0015\u001a\u00020\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/homework/submit/data/a;", "", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/BaseItem;", "managerItem", "Lcom/tencent/mobileqq/troop/homework/homework/submit/data/a$a;", "a", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/ContentItem;", "Lcom/tencent/mobileqq/troop/homework/homework/submit/sso/f;", "e", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/ImageItem;", "d", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/VideoItem;", "g", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/AudioItem;", h.F, "", "", "c", "(J)Ljava/lang/Integer;", "b", "Lcom/tencent/mobileqq/troop/homework/homework/submit/media/SubmitHomeworkMediaManager;", "mediaManager", "", "f", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f297087a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\t\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/homework/submit/data/a$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "position", "Lcom/tencent/mobileqq/troop/homework/homework/submit/sso/f;", "Lcom/tencent/mobileqq/troop/homework/homework/submit/sso/f;", "()Lcom/tencent/mobileqq/troop/homework/homework/submit/sso/f;", "content", "<init>", "(ILcom/tencent/mobileqq/troop/homework/homework/submit/sso/f;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.homework.submit.data.a$a, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public static final /* data */ class C8738a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int position;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final f content;

        public C8738a(int i3, @NotNull f content) {
            Intrinsics.checkNotNullParameter(content, "content");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) content);
            } else {
                this.position = i3;
                this.content = content;
            }
        }

        @NotNull
        public final f a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (f) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.content;
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.position;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof C8738a)) {
                return false;
            }
            C8738a c8738a = (C8738a) other;
            if (this.position == c8738a.position && Intrinsics.areEqual(this.content, c8738a.content)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            return (this.position * 31) + this.content.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return "SortedMedia(position=" + this.position + ", content=" + this.content + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final class b<T> implements Comparator {
        static IPatchRedirector $redirector_;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((C8738a) t16).b()), Integer.valueOf(((C8738a) t17).b()));
                return compareValues;
            }
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) t16, (Object) t17)).intValue();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51355);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f297087a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final C8738a a(BaseItem managerItem) {
        f g16;
        if (managerItem instanceof ContentItem) {
            return new C8738a(0, e((ContentItem) managerItem));
        }
        if (managerItem instanceof AudioItem) {
            f h16 = h((AudioItem) managerItem);
            if (h16 == null) {
                return null;
            }
            return new C8738a(1, h16);
        }
        if (managerItem instanceof ImageItem) {
            f d16 = d((ImageItem) managerItem);
            if (d16 == null) {
                return null;
            }
            return new C8738a(2, d16);
        }
        if (!(managerItem instanceof VideoItem) || (g16 = g((VideoItem) managerItem)) == null) {
            return null;
        }
        return new C8738a(3, g16);
    }

    private final Integer b(long j3) {
        boolean z16 = false;
        if (WebViewConstants.WV.ENABLE_WEBAIO_SWITCH <= j3 && j3 <= TTL.MAX_VALUE) {
            z16 = true;
        }
        if (z16) {
            return Integer.valueOf((int) j3);
        }
        return null;
    }

    private final Integer c(long j3) {
        boolean z16 = false;
        if (-2147483648000L <= j3 && j3 < 2147483647001L) {
            z16 = true;
        }
        if (z16) {
            return Integer.valueOf((int) (j3 / 1000));
        }
        return null;
    }

    private final f d(ImageItem managerItem) {
        boolean z16;
        String httpUrl = managerItem.getHttpUrl();
        if (httpUrl != null && httpUrl.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.c("SubmitHWDataTransfer", "transfer image item got null: " + managerItem.getFileName());
            return null;
        }
        return new f(new com.tencent.mobileqq.troop.homework.homework.submit.sso.b(httpUrl, Integer.valueOf(managerItem.getWidth()), Integer.valueOf(managerItem.getHeight())));
    }

    private final f e(ContentItem managerItem) {
        return new f(new e(managerItem.getContent()));
    }

    private final f g(VideoItem managerItem) {
        boolean z16;
        String httpUrl = managerItem.getHttpUrl();
        if (httpUrl != null && httpUrl.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.c("SubmitHWDataTransfer", "transfer video item got null: " + managerItem.getFileName());
            return null;
        }
        String posterHttpUrl = managerItem.getPosterHttpUrl();
        if (posterHttpUrl == null) {
            posterHttpUrl = "";
        }
        return new f(new j(posterHttpUrl, "\u4f5c\u4e1a", "\u70b9\u51fb\u4e0b\u8f7d\u89c6\u9891", httpUrl, httpUrl, Integer.valueOf(managerItem.getWidth()), Integer.valueOf(managerItem.getHeight())));
    }

    private final f h(AudioItem managerItem) {
        boolean z16;
        String httpUrl = managerItem.getHttpUrl();
        if (httpUrl != null && httpUrl.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.c("SubmitHWDataTransfer", "transfer voice item got null: " + managerItem.getFileName());
            return null;
        }
        Integer c16 = c(managerItem.getCountTime());
        Integer b16 = b(managerItem.getFileSize());
        if (c16 != null && b16 != null) {
            return new f(new k(httpUrl, c16, b16));
        }
        com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.c("SubmitHWDataTransfer", "transfer voice item got long to int overflow: " + managerItem.getFileName());
        return null;
    }

    @NotNull
    public final List<f> f(@NotNull SubmitHomeworkMediaManager mediaManager) {
        List sortedWith;
        int collectionSizeOrDefault;
        Collection listOfNotNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) mediaManager);
        }
        Intrinsics.checkNotNullParameter(mediaManager, "mediaManager");
        List<BaseItem> q16 = mediaManager.K().q();
        ArrayList arrayList = new ArrayList();
        for (BaseItem baseItem : q16) {
            if (!(baseItem instanceof MediaListItem)) {
                listOfNotNull = CollectionsKt__CollectionsKt.listOfNotNull(f297087a.a(baseItem));
            } else {
                ArrayList<BaseMediaItem> data = ((MediaListItem) baseItem).getData();
                listOfNotNull = new ArrayList();
                Iterator<T> it = data.iterator();
                while (it.hasNext()) {
                    C8738a a16 = f297087a.a((BaseMediaItem) it.next());
                    if (a16 != null) {
                        listOfNotNull.add(a16);
                    }
                }
            }
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, listOfNotNull);
        }
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList, new b());
        List list = sortedWith;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it5 = list.iterator();
        while (it5.hasNext()) {
            arrayList2.add(((C8738a) it5.next()).a());
        }
        return arrayList2;
    }
}
