package com.tencent.biz.qqcircle.immersive.personal.model;

import com.tencent.biz.qqcircle.immersive.feed.event.QFSFeedPermissionChangeEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qcircle.api.qqvideo.event.QCircleFeedJSPermissionChangeEvent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00192\u00020\u0001:\u0003\u0014\u0018\u0019B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J*\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0011\u001a\u00020\u0004J\u0016\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\rJ\u001e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\bJ\u0006\u0010\u0019\u001a\u00020\u0004R \u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001cR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u001e\u00a8\u0006!"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/personal/model/b;", "", "Lcom/tencent/biz/qqcircle/immersive/personal/model/b$c;", "callback", "", h.F, "g", "", "", "qcircleUgcRightList", "qzoneUgcRightList", "", "f", "", "e", "d", "i", "j", "feedId", "isDoTopStick", "a", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "newUgcRightFlag", "b", "c", "", "Lcom/tencent/biz/qqcircle/immersive/personal/model/b$b;", "Ljava/util/Map;", "operatorMap", "Lcom/tencent/biz/qqcircle/immersive/personal/model/b$c;", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class b {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final List<Long> f88733d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final List<Long> f88734e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final List<Long> f88735f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final List<Long> f88736g;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, FeedOperatorBean> operatorMap = new LinkedHashMap();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c callback;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0018\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u000b\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001b\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\"\u0010!\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u001d\u001a\u0004\b\u0019\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/personal/model/b$b;", "", "", "toString", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "f", "(Ljava/lang/String;)V", "feedId", "", "b", "Z", "e", "()Z", "j", "(Z)V", "isQZoneVideo", "", "c", "I", "()I", "g", "(I)V", "hasTopStickChange", "d", h.F, "hasUgcRightChange", "", "J", "()J", "i", "(J)V", "newUgcRightFlag", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.immersive.personal.model.b$b, reason: collision with other inner class name and from toString */
    /* loaded from: classes4.dex */
    public static final class FeedOperatorBean {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private String feedId = "";

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean isQZoneVideo;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private int hasTopStickChange;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private int hasUgcRightChange;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private long newUgcRightFlag;

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getFeedId() {
            return this.feedId;
        }

        /* renamed from: b, reason: from getter */
        public final int getHasTopStickChange() {
            return this.hasTopStickChange;
        }

        /* renamed from: c, reason: from getter */
        public final int getHasUgcRightChange() {
            return this.hasUgcRightChange;
        }

        /* renamed from: d, reason: from getter */
        public final long getNewUgcRightFlag() {
            return this.newUgcRightFlag;
        }

        /* renamed from: e, reason: from getter */
        public final boolean getIsQZoneVideo() {
            return this.isQZoneVideo;
        }

        public final void f(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.feedId = str;
        }

        public final void g(int i3) {
            this.hasTopStickChange = i3;
        }

        public final void h(int i3) {
            this.hasUgcRightChange = i3;
        }

        public final void i(long j3) {
            this.newUgcRightFlag = j3;
        }

        public final void j(boolean z16) {
            this.isQZoneVideo = z16;
        }

        @NotNull
        public String toString() {
            return "FeedOperatorBean(feedId='" + this.feedId + "', isQZoneVideo=" + this.isQZoneVideo + ", hasTopStickChange=" + this.hasTopStickChange + ", hasUgcRightChange=" + this.hasUgcRightChange + ", newUgcRightFlag=" + this.newUgcRightFlag + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u001e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/personal/model/b$c;", "", "", "tabType", "", "b", "", "feedIds", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public interface c {
        void a(@NotNull String tabType, @NotNull List<String> feedIds);

        void b(@NotNull String tabType);
    }

    static {
        ArrayList arrayList = new ArrayList();
        arrayList.add(2L);
        f88733d = arrayList;
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(1L);
        f88734e = arrayList2;
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(5L);
        f88735f = arrayList3;
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add(1L);
        arrayList4.add(2L);
        arrayList4.add(3L);
        arrayList4.add(4L);
        arrayList4.add(6L);
        f88736g = arrayList4;
    }

    private final void d() {
        this.operatorMap.clear();
    }

    private final boolean e() {
        boolean z16;
        Collection<FeedOperatorBean> values = this.operatorMap.values();
        if ((values instanceof Collection) && values.isEmpty()) {
            return false;
        }
        for (FeedOperatorBean feedOperatorBean : values) {
            if (feedOperatorBean.getHasTopStickChange() != 0) {
                if (feedOperatorBean.getHasUgcRightChange() == 0) {
                    z16 = true;
                } else if (feedOperatorBean.getIsQZoneVideo()) {
                    z16 = f88735f.contains(Long.valueOf(feedOperatorBean.getNewUgcRightFlag()));
                } else {
                    z16 = f88733d.contains(Long.valueOf(feedOperatorBean.getNewUgcRightFlag()));
                }
            } else {
                z16 = false;
            }
            if (z16) {
                return true;
            }
        }
        return false;
    }

    private final List<String> f(List<Long> qcircleUgcRightList, List<Long> qzoneUgcRightList) {
        int collectionSizeOrDefault;
        List<String> mutableList;
        boolean z16;
        Collection<FeedOperatorBean> values = this.operatorMap.values();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = values.iterator();
        while (true) {
            boolean z17 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((FeedOperatorBean) next).getHasUgcRightChange() == 0) {
                z17 = false;
            }
            if (z17) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            FeedOperatorBean feedOperatorBean = (FeedOperatorBean) obj;
            if ((feedOperatorBean.getIsQZoneVideo() && qzoneUgcRightList.contains(Long.valueOf(feedOperatorBean.getNewUgcRightFlag()))) || (!feedOperatorBean.getIsQZoneVideo() && qcircleUgcRightList.contains(Long.valueOf(feedOperatorBean.getNewUgcRightFlag())))) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList2.add(obj);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
        Iterator it5 = arrayList2.iterator();
        while (it5.hasNext()) {
            arrayList3.add(((FeedOperatorBean) it5.next()).getFeedId());
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList3);
        return mutableList;
    }

    private final void g() {
        for (Map.Entry<String, FeedOperatorBean> entry : this.operatorMap.entrySet()) {
            String key = entry.getKey();
            QLog.i("QFSPersonalTabOperateModel", 1, "operator record: " + ((Object) key) + " - " + entry.getValue());
        }
    }

    private final void h(c callback) {
        if (e()) {
            QLog.i("QFSPersonalTabOperateModel", 1, "privateProdsTabHandleOperate 1, shouldRefresh");
            if (callback != null) {
                callback.b("qfs_personal_tab_private_prods");
                return;
            }
            return;
        }
        if (!f(f88733d, f88735f).isEmpty()) {
            QLog.i("QFSPersonalTabOperateModel", 1, "privateProdsTabHandleOperate 2, shouldRefresh");
            if (callback != null) {
                callback.b("qfs_personal_tab_private_prods");
                return;
            }
            return;
        }
        List<String> f16 = f(f88734e, f88736g);
        if (!f16.isEmpty()) {
            QLog.i("QFSPersonalTabOperateModel", 1, "privateProdsTabHandleOperate 3, shouldDeleteFeed");
            if (callback != null) {
                callback.a("qfs_personal_tab_private_prods", f16);
                return;
            }
            return;
        }
        QLog.i("QFSPersonalTabOperateModel", 1, "privateProdsTabHandleOperate 4, do nothing");
    }

    public final void a(@NotNull String feedId, boolean isDoTopStick) {
        int i3;
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        if (isDoTopStick) {
            i3 = 1;
        } else {
            i3 = -1;
        }
        FeedOperatorBean feedOperatorBean = this.operatorMap.get(feedId);
        if (feedOperatorBean != null) {
            feedOperatorBean.g(feedOperatorBean.getHasTopStickChange() + i3);
            return;
        }
        FeedOperatorBean feedOperatorBean2 = new FeedOperatorBean();
        feedOperatorBean2.f(feedId);
        feedOperatorBean2.g(feedOperatorBean2.getHasTopStickChange() + i3);
        this.operatorMap.put(feedId, feedOperatorBean2);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(@NotNull SimpleBaseEvent event, @NotNull String feedId, long newUgcRightFlag) {
        int i3;
        boolean z16;
        FeedOperatorBean feedOperatorBean;
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        int i16 = -1;
        if (event instanceof QFSFeedPermissionChangeEvent) {
            if (newUgcRightFlag == 1) {
                i3 = 1;
            } else if (newUgcRightFlag == 2) {
                i3 = -1;
            }
            z16 = event instanceof QCircleFeedJSPermissionChangeEvent;
            if (z16) {
                if (newUgcRightFlag == 0) {
                    i16 = 0;
                } else if (newUgcRightFlag != 5) {
                    i16 = 1;
                }
                i3 = i16;
            }
            feedOperatorBean = this.operatorMap.get(feedId);
            if (feedOperatorBean == null) {
                feedOperatorBean.h(feedOperatorBean.getHasUgcRightChange() + i3);
                feedOperatorBean.i(newUgcRightFlag);
                return;
            }
            FeedOperatorBean feedOperatorBean2 = new FeedOperatorBean();
            feedOperatorBean2.f(feedId);
            feedOperatorBean2.j(z16);
            feedOperatorBean2.h(feedOperatorBean2.getHasUgcRightChange() + i3);
            feedOperatorBean2.i(newUgcRightFlag);
            this.operatorMap.put(feedId, feedOperatorBean2);
            return;
        }
        i3 = 0;
        z16 = event instanceof QCircleFeedJSPermissionChangeEvent;
        if (z16) {
        }
        feedOperatorBean = this.operatorMap.get(feedId);
        if (feedOperatorBean == null) {
        }
    }

    public final void c() {
        if (this.operatorMap.isEmpty()) {
            return;
        }
        g();
        h(this.callback);
        d();
    }

    public final void i(@NotNull c callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
    }

    public final void j() {
        this.callback = null;
        d();
    }
}
