package com.tencent.luggage.wxa.k5;

import com.tencent.luggage.wxa.hn.gi;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends b {

        /* renamed from: a, reason: collision with root package name */
        public final gi f131436a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(gi appInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(appInfo, "appInfo");
            this.f131436a = appInfo;
        }

        public final gi a() {
            return this.f131436a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof a) && Intrinsics.areEqual(this.f131436a, ((a) obj).f131436a)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.f131436a.hashCode();
        }

        public String toString() {
            return "Header(appInfo=" + this.f131436a + ')';
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.k5.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6357b extends b {

        /* renamed from: a, reason: collision with root package name */
        public final String f131437a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C6357b(String nickName) {
            super(null);
            Intrinsics.checkNotNullParameter(nickName, "nickName");
            this.f131437a = nickName;
        }

        public final String a() {
            return this.f131437a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof C6357b) && Intrinsics.areEqual(this.f131437a, ((C6357b) obj).f131437a)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.f131437a.hashCode();
        }

        public String toString() {
            return "PluginTitle(nickName=" + this.f131437a + ')';
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends b {

        /* renamed from: a, reason: collision with root package name */
        public final com.tencent.luggage.wxa.i5.h f131438a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(com.tencent.luggage.wxa.i5.h usageInfoItem) {
            super(null);
            Intrinsics.checkNotNullParameter(usageInfoItem, "usageInfoItem");
            this.f131438a = usageInfoItem;
        }

        public final com.tencent.luggage.wxa.i5.h a() {
            return this.f131438a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof c) && Intrinsics.areEqual(this.f131438a, ((c) obj).f131438a)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.f131438a.hashCode();
        }

        public String toString() {
            return "UserInfo(usageInfoItem=" + this.f131438a + ')';
        }
    }

    public b() {
    }

    public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
