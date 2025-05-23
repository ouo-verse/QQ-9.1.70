package com.tencent.qqnt.aio.emoReply;

import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOEmoReplyApi;
import com.tencent.qqnt.aio.emoReply.c;
import com.tencent.qqnt.emotion.api.IAIOEmoticonApi;
import com.tencent.qqnt.emotion.info.SystemAndEmojiEmotionInfo;
import com.tencent.qqnt.kernel.nativeinterface.EmojiUseInfo;
import com.tencent.qqnt.kernel.nativeinterface.IGetRecentUseEmojiListCallback;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.view.FilterEnum;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001(B\t\b\u0002\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\b\u001a\u00020\u00022\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u0017\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u000f\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0011R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR$\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0004j\b\u0012\u0004\u0012\u00020\u0011`\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00190#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010$\u00a8\u0006)"}, d2 = {"Lcom/tencent/qqnt/aio/emoReply/c;", "", "", "g", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/EmojiUseInfo;", "Lkotlin/collections/ArrayList;", "emojiInfoList", "j", "", "c", "", "chatType", h.F, "(Ljava/lang/Integer;)V", "count", "", "Lcom/tencent/qqnt/emotion/info/SystemAndEmojiEmotionInfo;", "f", "(ILjava/lang/Integer;)Ljava/util/List;", "e", "(Ljava/lang/Integer;)Ljava/util/List;", "info", "k", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/qqnt/aio/emoReply/c$a;", "b", "Ljava/util/concurrent/CopyOnWriteArrayList;", "cachedEmoticonList", "Ljava/util/ArrayList;", "defaultEmoticonDataList", "", "d", "J", "expiredTime", "Ljava/util/Comparator;", "Ljava/util/Comparator;", "comparator", "<init>", "()V", "a", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f349875a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final CopyOnWriteArrayList<a> cachedEmoticonList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ArrayList<SystemAndEmojiEmotionInfo> defaultEmoticonDataList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static long expiredTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Comparator<a> comparator;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0016\u001a\u00020\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001a\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0018\u001a\u0004\b\u0010\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqnt/aio/emoReply/c$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "d", "(I)V", "count", "", "b", "J", "c", "()J", "e", "(J)V", "updateTime", "Lcom/tencent/qqnt/emotion/info/SystemAndEmojiEmotionInfo;", "Lcom/tencent/qqnt/emotion/info/SystemAndEmojiEmotionInfo;", "()Lcom/tencent/qqnt/emotion/info/SystemAndEmojiEmotionInfo;", "info", "<init>", "(IJLcom/tencent/qqnt/emotion/info/SystemAndEmojiEmotionInfo;)V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final /* data */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int count;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private long updateTime;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final SystemAndEmojiEmotionInfo info;

        public a(int i3, long j3, @NotNull SystemAndEmojiEmotionInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Long.valueOf(j3), info);
                return;
            }
            this.count = i3;
            this.updateTime = j3;
            this.info = info;
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.count;
        }

        @NotNull
        public final SystemAndEmojiEmotionInfo b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (SystemAndEmojiEmotionInfo) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.info;
        }

        public final long c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
            }
            return this.updateTime;
        }

        public final void d(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
            } else {
                this.count = i3;
            }
        }

        public final void e(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, j3);
            } else {
                this.updateTime = j3;
            }
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof a)) {
                return false;
            }
            a aVar = (a) other;
            if (this.count == aVar.count && this.updateTime == aVar.updateTime && Intrinsics.areEqual(this.info, aVar.info)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
            }
            return (((this.count * 31) + androidx.fragment.app.a.a(this.updateTime)) * 31) + this.info.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (String) iPatchRedirector.redirect((short) 11, (Object) this);
            }
            return "CountedEmoticonData(count=" + this.count + ", updateTime=" + this.updateTime + ", info=" + this.info + ")";
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42360);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        c cVar = new c();
        f349875a = cVar;
        cachedEmoticonList = new CopyOnWriteArrayList<>();
        defaultEmoticonDataList = new ArrayList<>();
        cVar.g();
        comparator = new Comparator() { // from class: com.tencent.qqnt.aio.emoReply.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int d16;
                d16 = c.d((c.a) obj, (c.a) obj2);
                return d16;
            }
        };
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean c() {
        if (System.currentTimeMillis() < expiredTime) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int d(a aVar, a aVar2) {
        int compare = Intrinsics.compare(aVar2.a(), aVar.a());
        if (compare == 0) {
            return Intrinsics.compare(aVar2.c(), aVar.c());
        }
        return compare;
    }

    private final void g() {
        int[] iArr = {76, 124, 66, 277, FilterEnum.MIC_PTU_BAIXI, 99};
        for (int i3 = 0; i3 < 6; i3++) {
            int convertToLocal = QQSysFaceUtil.convertToLocal(iArr[i3]);
            if (!((IAIOEmoReplyApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOEmoReplyApi.class)).isInEmoFilterList(1, String.valueOf(convertToLocal))) {
                defaultEmoticonDataList.add(new SystemAndEmojiEmotionInfo(1, convertToLocal, ""));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(int i3, String str, ArrayList emojiInfoList) {
        QLog.d("EmoReplyRecentEmoDataSource", 2, "queryRecentUseEmoticon: result = " + i3 + ", errMsg = " + str + ", emojiInfoList = " + emojiInfoList.size());
        if (i3 == 0) {
            expiredTime = System.currentTimeMillis() + 10000;
            c cVar = f349875a;
            Intrinsics.checkNotNullExpressionValue(emojiInfoList, "emojiInfoList");
            cVar.j(emojiInfoList);
            d.a(cachedEmoticonList, comparator);
        }
    }

    private final void j(ArrayList<EmojiUseInfo> emojiInfoList) {
        cachedEmoticonList.clear();
        QLog.d("EmoReplyRecentEmoDataSource", 2, "convertToEmoticonInfo size=" + emojiInfoList.size());
        Iterator<EmojiUseInfo> it = emojiInfoList.iterator();
        while (it.hasNext()) {
            EmojiUseInfo next = it.next();
            try {
                String str = next.emojiId;
                Intrinsics.checkNotNullExpressionValue(str, "emojiInfo.emojiId");
                if (Integer.parseInt(str) >= 0) {
                    int i3 = next.emojiType;
                    String serverId = next.emojiId;
                    IAIOEmoticonApi iAIOEmoticonApi = (IAIOEmoticonApi) QRoute.api(IAIOEmoticonApi.class);
                    Intrinsics.checkNotNullExpressionValue(serverId, "serverId");
                    int convertToLocal = iAIOEmoticonApi.convertToLocal(Integer.parseInt(serverId), i3);
                    if (!((IAIOEmoReplyApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOEmoReplyApi.class)).isInEmoFilterList(i3, String.valueOf(convertToLocal))) {
                        cachedEmoticonList.add(new a(next.usedCount, next.updateTime, new SystemAndEmojiEmotionInfo(i3, convertToLocal, "")));
                    }
                }
            } catch (Exception e16) {
                QLog.d("EmoReplyRecentEmoDataSource", 2, "convertToEmoticonInfo: " + e16);
            }
        }
    }

    @NotNull
    public final List<SystemAndEmojiEmotionInfo> e(@Nullable Integer chatType) {
        int collectionSizeOrDefault;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this, (Object) chatType);
        }
        h(chatType);
        ArrayList arrayList = new ArrayList();
        CopyOnWriteArrayList<a> copyOnWriteArrayList = cachedEmoticonList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(copyOnWriteArrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((a) it.next()).b());
        }
        arrayList.addAll(arrayList2);
        arrayList.addAll(defaultEmoticonDataList);
        HashSet hashSet = new HashSet();
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : arrayList) {
            SystemAndEmojiEmotionInfo systemAndEmojiEmotionInfo = (SystemAndEmojiEmotionInfo) obj;
            if (hashSet.add(new Pair(Integer.valueOf(systemAndEmojiEmotionInfo.getCode()), Integer.valueOf(systemAndEmojiEmotionInfo.c())))) {
                arrayList3.add(obj);
            }
        }
        return arrayList3;
    }

    @NotNull
    public final List<SystemAndEmojiEmotionInfo> f(int count, @Nullable Integer chatType) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this, count, (Object) chatType);
        }
        h(chatType);
        ArrayList arrayList = new ArrayList(cachedEmoticonList);
        if (arrayList.size() >= count) {
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((a) it.next()).b());
            }
            return arrayList2.subList(0, count);
        }
        int min = Math.min(count - arrayList.size(), defaultEmoticonDataList.size());
        ArrayList arrayList3 = new ArrayList();
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault2);
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            arrayList4.add(((a) it5.next()).b());
        }
        arrayList3.addAll(arrayList4);
        ArrayList<SystemAndEmojiEmotionInfo> arrayList5 = defaultEmoticonDataList;
        ArrayList arrayList6 = new ArrayList();
        for (Object obj : arrayList5) {
            SystemAndEmojiEmotionInfo systemAndEmojiEmotionInfo = (SystemAndEmojiEmotionInfo) obj;
            if (!arrayList3.isEmpty()) {
                Iterator it6 = arrayList3.iterator();
                while (it6.hasNext()) {
                    z16 = true;
                    if (((SystemAndEmojiEmotionInfo) it6.next()).getCode() == systemAndEmojiEmotionInfo.getCode()) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        break;
                    }
                }
            }
            z16 = false;
            if (!z16) {
                arrayList6.add(obj);
            }
        }
        arrayList3.addAll(arrayList6.subList(0, Math.min(min, arrayList6.size())));
        return arrayList3;
    }

    public final void h(@Nullable Integer chatType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) chatType);
        } else {
            if (c()) {
                QLog.d("EmoReplyRecentEmoDataSource", 2, "queryRecentUseEmoticon: checkValid false, use cache");
                return;
            }
            if (chatType != null) {
                i3 = chatType.intValue();
            }
            ((IMsgService) QRoute.api(IMsgService.class)).getRecentEmojiList(i3, new IGetRecentUseEmojiListCallback() { // from class: com.tencent.qqnt.aio.emoReply.b
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetRecentUseEmojiListCallback
                public final void onGetRecentUseEmojiListCallback(int i16, String str, ArrayList arrayList) {
                    c.i(i16, str, arrayList);
                }
            });
        }
    }

    public final void k(@NotNull SystemAndEmojiEmotionInfo info) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) info);
            return;
        }
        Intrinsics.checkNotNullParameter(info, "info");
        Iterator<a> it = cachedEmoticonList.iterator();
        int i3 = 0;
        while (true) {
            if (it.hasNext()) {
                if (it.next().b().getCode() == info.getCode()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                } else {
                    i3++;
                }
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 != -1) {
            CopyOnWriteArrayList<a> copyOnWriteArrayList = cachedEmoticonList;
            a aVar = copyOnWriteArrayList.get(i3);
            aVar.d(aVar.a() + 1);
            copyOnWriteArrayList.get(i3).e(System.currentTimeMillis() / 1000);
            copyOnWriteArrayList.get(i3).b().e(info.getTitle());
        } else {
            cachedEmoticonList.add(new a(1, System.currentTimeMillis() / 1000, info));
        }
        d.a(cachedEmoticonList, comparator);
    }
}
