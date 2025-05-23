package com.qzone.widget;

import NS_MOBILE_FEEDS.s_droplist_option;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes37.dex */
public interface f {

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface b {
        void a(int i3, BusinessFeedData businessFeedData, s_droplist_option s_droplist_optionVar, int i16, boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface c {
        void a(int i3, BusinessFeedData businessFeedData);
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface d {
        void a(int i3, BusinessFeedData businessFeedData, s_droplist_option s_droplist_optionVar);
    }

    void H(int i3, d dVar);

    boolean j();

    BusinessFeedData o();

    void p();

    void w(int i3, b bVar);

    void z(int i3, c cVar);

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public static class a {

        /* renamed from: f, reason: collision with root package name */
        static final LinkedList<a> f60853f = new LinkedList<>();

        /* renamed from: c, reason: collision with root package name */
        public String f60856c;

        /* renamed from: d, reason: collision with root package name */
        public s_droplist_option f60857d;

        /* renamed from: a, reason: collision with root package name */
        public int f60854a = 0;

        /* renamed from: b, reason: collision with root package name */
        public int f60855b = 0;

        /* renamed from: e, reason: collision with root package name */
        public int f60858e = -1;

        static {
            for (int i3 = 0; i3 <= 20; i3++) {
                f60853f.add(new a());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static a a() {
            a poll;
            LinkedList<a> linkedList = f60853f;
            synchronized (linkedList) {
                poll = linkedList.poll();
            }
            if (poll == null) {
                poll = new a();
            }
            poll.f60854a = 0;
            poll.f60855b = 0;
            poll.f60856c = "";
            poll.f60857d = null;
            return poll;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static void b(a aVar) {
            if (aVar == null) {
                return;
            }
            LinkedList<a> linkedList = f60853f;
            synchronized (linkedList) {
                if (linkedList.size() < 20) {
                    linkedList.add(aVar);
                }
            }
        }
    }
}
