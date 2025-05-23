package com.qzone.reborn.share;

import NS_MOBILE_FEEDS.s_droplist_option;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes37.dex */
public interface c {

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface b {
        void a(int i3, BusinessFeedData businessFeedData, s_droplist_option s_droplist_optionVar, int i16, boolean z16);
    }

    /* compiled from: P */
    /* renamed from: com.qzone.reborn.share.c$c, reason: collision with other inner class name */
    /* loaded from: classes37.dex */
    public interface InterfaceC0499c {
        void a(int i3, BusinessFeedData businessFeedData);
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface d {
        void a(int i3, BusinessFeedData businessFeedData, s_droplist_option s_droplist_optionVar);
    }

    void B(int i3, d dVar);

    void I(int i3, b bVar);

    boolean j();

    void m(int i3, InterfaceC0499c interfaceC0499c);

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public static class a {

        /* renamed from: f, reason: collision with root package name */
        static final LinkedList<a> f59483f = new LinkedList<>();

        /* renamed from: c, reason: collision with root package name */
        public String f59486c;

        /* renamed from: d, reason: collision with root package name */
        public s_droplist_option f59487d;

        /* renamed from: a, reason: collision with root package name */
        public int f59484a = 0;

        /* renamed from: b, reason: collision with root package name */
        public int f59485b = 0;

        /* renamed from: e, reason: collision with root package name */
        public int f59488e = -1;

        static {
            for (int i3 = 0; i3 <= 20; i3++) {
                f59483f.add(new a());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static a a() {
            a poll;
            LinkedList<a> linkedList = f59483f;
            synchronized (linkedList) {
                poll = linkedList.poll();
            }
            if (poll == null) {
                poll = new a();
            }
            poll.f59484a = 0;
            poll.f59485b = 0;
            poll.f59486c = "";
            poll.f59487d = null;
            return poll;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static void b(a aVar) {
            if (aVar == null) {
                return;
            }
            LinkedList<a> linkedList = f59483f;
            synchronized (linkedList) {
                if (linkedList.size() < 20) {
                    linkedList.add(aVar);
                }
            }
        }
    }
}
