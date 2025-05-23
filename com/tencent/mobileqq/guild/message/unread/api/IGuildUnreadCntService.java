package com.tencent.mobileqq.guild.message.unread.api;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.Observer;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
@Deprecated
/* loaded from: classes14.dex */
public interface IGuildUnreadCntService extends IRuntimeService {

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f230838a;

        /* renamed from: b, reason: collision with root package name */
        public String f230839b;

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            String str = this.f230839b;
            if (str == null) {
                if (aVar.f230839b == null && this.f230838a == aVar.f230838a) {
                    return true;
                }
                return false;
            }
            if (str.equals(aVar.f230839b) && this.f230838a == aVar.f230838a) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i3;
            String str = this.f230839b;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            return (i3 * 31) + this.f230838a;
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public long f230842a;

        /* renamed from: b, reason: collision with root package name */
        public long f230843b;

        /* renamed from: c, reason: collision with root package name */
        public long f230844c;

        /* renamed from: d, reason: collision with root package name */
        public long f230845d;

        /* renamed from: e, reason: collision with root package name */
        public long f230846e;

        /* renamed from: f, reason: collision with root package name */
        public int f230847f;

        /* renamed from: g, reason: collision with root package name */
        public int f230848g;

        public c() {
            a();
        }

        public void a() {
            this.f230842a = 0L;
            this.f230843b = 0L;
            this.f230844c = 0L;
            this.f230845d = 0L;
            this.f230846e = 0L;
            this.f230847f = 0;
            this.f230848g = 0;
        }

        public String toString() {
            return "redCnt:" + this.f230842a + " grayCnt:" + this.f230843b + " atMeCnt:" + this.f230844c + " atAllCnt:" + this.f230845d + " calendarCnt:" + this.f230846e + " showType:" + this.f230847f + " msgNotifyType:" + this.f230848g + " ";
        }
    }

    void addImmediateObserver(Observer observer);

    void addObserver(Observer observer);

    void deleteObserver(Observer observer);

    b getChannelUnreadCnt(String str, int i3);

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class b implements Cloneable {

        /* renamed from: d, reason: collision with root package name */
        public long f230840d;

        /* renamed from: e, reason: collision with root package name */
        public int f230841e;

        public b() {
            this.f230840d = 0L;
            this.f230841e = 1;
        }

        @NonNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b clone() throws CloneNotSupportedException {
            b bVar = (b) super.clone();
            bVar.f230840d = this.f230840d;
            bVar.f230841e = this.f230841e;
            return bVar;
        }

        public int b() {
            if (this.f230840d <= 0) {
                return 0;
            }
            int i3 = this.f230841e;
            if (i3 != 2 && i3 != 4) {
                return 2;
            }
            return 3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            long j3 = this.f230840d;
            if (j3 == 0 && ((b) obj).f230840d == 0) {
                return true;
            }
            b bVar = (b) obj;
            if (j3 == bVar.f230840d && this.f230841e == bVar.f230841e) {
                return true;
            }
            return false;
        }

        public String toString() {
            return "unreadCnt:" + this.f230840d + " showType:" + this.f230841e + " ";
        }

        public b(long j3, int i3) {
            this.f230840d = j3;
            this.f230841e = i3;
        }
    }
}
