package com.tencent.biz.qqcircle.immersive.personal.data;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleProfile$QQGroup;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b&\b\u0086\b\u0018\u0000 #2\u00020\u0001:\u0001\nBi\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\u0006\u0010!\u001a\u00020\u0004\u0012\u0006\u0010%\u001a\u00020\u0007\u0012\u0006\u0010'\u001a\u00020\u0007\u0012\u0006\u0010*\u001a\u00020\u0002\u0012\u0006\u0010+\u001a\u00020\u0002\u0012\u0006\u0010/\u001a\u00020\u0007\u0012\b\b\u0002\u00102\u001a\u00020\u0007\u00a2\u0006\u0004\b3\u00104J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u0017\u0010\u001d\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018R\u0017\u0010!\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010%\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010'\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\"\u001a\u0004\b&\u0010$R\u0017\u0010*\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b(\u0010\u0016\u001a\u0004\b)\u0010\u0018R\u0017\u0010+\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0016\u001a\u0004\b(\u0010\u0018R\"\u0010/\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010\"\u001a\u0004\b,\u0010$\"\u0004\b-\u0010.R\"\u00102\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010\"\u001a\u0004\b0\u0010$\"\u0004\b1\u0010.\u00a8\u00065"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/personal/data/o;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/biz/qqcircle/immersive/personal/data/TroopItemType;", "a", "Lcom/tencent/biz/qqcircle/immersive/personal/data/TroopItemType;", "j", "()Lcom/tencent/biz/qqcircle/immersive/personal/data/TroopItemType;", "type", "", "b", "J", "f", "()J", "id", "c", "Ljava/lang/String;", tl.h.F, "()Ljava/lang/String;", "name", "d", "desc", "e", "headUrl", "I", "g", "()I", "memberNum", "Z", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Z", "isFull", "k", "isActive", "i", "getJoinAuth", "joinAuth", "text", DomainData.DOMAIN_NAME, "setJoined", "(Z)V", "isJoined", "l", "o", "isBound", "<init>", "(Lcom/tencent/biz/qqcircle/immersive/personal/data/TroopItemType;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IZZLjava/lang/String;Ljava/lang/String;ZZ)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.biz.qqcircle.immersive.personal.data.o, reason: from toString */
/* loaded from: classes4.dex */
public final /* data */ class QFSTroopItemInfo {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    private static final Comparator<QFSTroopItemInfo> f88551n = new k(new g(new f(new e(new b()))));

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    private static final Comparator<QFSTroopItemInfo> f88552o = new h(new c());

    /* renamed from: p, reason: collision with root package name */
    @NotNull
    private static final Comparator<QFSTroopItemInfo> f88553p = new l(new j(new i(new d())));

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final TroopItemType type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final long id;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String name;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String desc;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String headUrl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final int memberNum;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isFull;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isActive;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String joinAuth;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String text;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isJoined;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isBound;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\"\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u0016\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\rR'\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0010j\b\u0012\u0004\u0012\u00020\u0007`\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R'\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0010j\b\u0012\u0004\u0012\u00020\u0007`\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R'\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0010j\b\u0012\u0004\u0012\u00020\u0007`\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015R\u0014\u0010\u001b\u001a\u00020\u001a8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001a8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/personal/data/o$a;", "", "", "Lqqcircle/QQCircleProfile$QQGroup;", "groups", "", "isBound", "Lcom/tencent/biz/qqcircle/immersive/personal/data/o;", "b", VipFunCallConstants.KEY_GROUP, "a", "", "text", "Lcom/tencent/biz/qqcircle/immersive/personal/data/TroopItemType;", "type", "c", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "profileHostComparator", "Ljava/util/Comparator;", "g", "()Ljava/util/Comparator;", "profileGuestComparator", "f", "feedComparator", "e", "", "INVALID_TROOP_ID", "J", "NO_BIND_TROOP_ID", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.immersive.personal.data.o$a, reason: from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ QFSTroopItemInfo d(Companion companion, String str, TroopItemType troopItemType, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                troopItemType = TroopItemType.TEXT;
            }
            return companion.c(str, troopItemType);
        }

        @NotNull
        public final QFSTroopItemInfo a(@NotNull QQCircleProfile$QQGroup group, boolean isBound) {
            Intrinsics.checkNotNullParameter(group, "group");
            TroopItemType troopItemType = TroopItemType.DATA;
            long j3 = group.f429310id.get();
            String str = group.name.get();
            Intrinsics.checkNotNullExpressionValue(str, "group.name.get()");
            String str2 = group.desc.get();
            Intrinsics.checkNotNullExpressionValue(str2, "group.desc.get()");
            String str3 = group.head_url.get();
            Intrinsics.checkNotNullExpressionValue(str3, "group.head_url.get()");
            int i3 = group.member_num.get();
            boolean z16 = group.is_full.get();
            boolean z17 = group.is_active.get();
            String stringUtf8 = group.join_auth.get().toStringUtf8();
            Intrinsics.checkNotNullExpressionValue(stringUtf8, "group.join_auth.get().toStringUtf8()");
            return new QFSTroopItemInfo(troopItemType, j3, str, str2, str3, i3, z16, z17, stringUtf8, "", group.is_join.get(), isBound);
        }

        @NotNull
        public final List<QFSTroopItemInfo> b(@NotNull List<QQCircleProfile$QQGroup> groups, boolean isBound) {
            Intrinsics.checkNotNullParameter(groups, "groups");
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = groups.iterator();
            while (it.hasNext()) {
                arrayList.add(QFSTroopItemInfo.INSTANCE.a((QQCircleProfile$QQGroup) it.next(), isBound));
            }
            return arrayList;
        }

        @NotNull
        public final QFSTroopItemInfo c(@NotNull String text, @NotNull TroopItemType type) {
            long j3;
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(type, "type");
            if (type == TroopItemType.RESET) {
                j3 = 0;
            } else {
                j3 = -1;
            }
            return new QFSTroopItemInfo(type, j3, "", "", "", 0, false, false, "", text, false, false);
        }

        @NotNull
        public final Comparator<QFSTroopItemInfo> e() {
            return QFSTroopItemInfo.f88553p;
        }

        @NotNull
        public final Comparator<QFSTroopItemInfo> f() {
            return QFSTroopItemInfo.f88552o;
        }

        @NotNull
        public final Comparator<QFSTroopItemInfo> g() {
            return QFSTroopItemInfo.f88551n;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.biz.qqcircle.immersive.personal.data.o$b */
    /* loaded from: classes4.dex */
    public static final class b<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Boolean.valueOf(!((QFSTroopItemInfo) t16).getIsBound()), Boolean.valueOf(!((QFSTroopItemInfo) t17).getIsBound()));
            return compareValues;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.biz.qqcircle.immersive.personal.data.o$c */
    /* loaded from: classes4.dex */
    public static final class c<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Boolean.valueOf(((QFSTroopItemInfo) t16).getIsFull()), Boolean.valueOf(((QFSTroopItemInfo) t17).getIsFull()));
            return compareValues;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.biz.qqcircle.immersive.personal.data.o$d */
    /* loaded from: classes4.dex */
    public static final class d<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Boolean.valueOf(!((QFSTroopItemInfo) t16).getIsBound()), Boolean.valueOf(!((QFSTroopItemInfo) t17).getIsBound()));
            return compareValues;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenBy$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.biz.qqcircle.immersive.personal.data.o$e */
    /* loaded from: classes4.dex */
    public static final class e<T> implements Comparator {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Comparator f88566d;

        public e(Comparator comparator) {
            this.f88566d = comparator;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            boolean z16;
            int compareValues;
            int compare = this.f88566d.compare(t16, t17);
            if (compare == 0) {
                TroopItemType type = ((QFSTroopItemInfo) t16).getType();
                TroopItemType troopItemType = TroopItemType.TEXT;
                boolean z17 = true;
                if (type != troopItemType) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                Boolean valueOf = Boolean.valueOf(z16);
                if (((QFSTroopItemInfo) t17).getType() == troopItemType) {
                    z17 = false;
                }
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(valueOf, Boolean.valueOf(z17));
                return compareValues;
            }
            return compare;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenBy$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.biz.qqcircle.immersive.personal.data.o$f */
    /* loaded from: classes4.dex */
    public static final class f<T> implements Comparator {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Comparator f88567d;

        public f(Comparator comparator) {
            this.f88567d = comparator;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            Boolean bool;
            Boolean bool2;
            int compareValues;
            int compare = this.f88567d.compare(t16, t17);
            if (compare == 0) {
                QFSTroopItemInfo qFSTroopItemInfo = (QFSTroopItemInfo) t16;
                if (!qFSTroopItemInfo.getIsBound() && qFSTroopItemInfo.getType() != TroopItemType.TEXT) {
                    bool = Boolean.valueOf(qFSTroopItemInfo.getIsFull());
                } else {
                    bool = Boolean.FALSE;
                }
                QFSTroopItemInfo qFSTroopItemInfo2 = (QFSTroopItemInfo) t17;
                if (!qFSTroopItemInfo2.getIsBound() && qFSTroopItemInfo2.getType() != TroopItemType.TEXT) {
                    bool2 = Boolean.valueOf(qFSTroopItemInfo2.getIsFull());
                } else {
                    bool2 = Boolean.FALSE;
                }
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(bool, bool2);
                return compareValues;
            }
            return compare;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenBy$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.biz.qqcircle.immersive.personal.data.o$g */
    /* loaded from: classes4.dex */
    public static final class g<T> implements Comparator {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Comparator f88568d;

        public g(Comparator comparator) {
            this.f88568d = comparator;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            Boolean bool;
            Boolean bool2;
            int compareValues;
            int compare = this.f88568d.compare(t16, t17);
            if (compare == 0) {
                QFSTroopItemInfo qFSTroopItemInfo = (QFSTroopItemInfo) t16;
                if (!qFSTroopItemInfo.getIsBound() && qFSTroopItemInfo.getType() != TroopItemType.TEXT) {
                    bool = Boolean.valueOf(!qFSTroopItemInfo.getIsActive());
                } else {
                    bool = Boolean.FALSE;
                }
                QFSTroopItemInfo qFSTroopItemInfo2 = (QFSTroopItemInfo) t17;
                if (!qFSTroopItemInfo2.getIsBound() && qFSTroopItemInfo2.getType() != TroopItemType.TEXT) {
                    bool2 = Boolean.valueOf(!qFSTroopItemInfo2.getIsActive());
                } else {
                    bool2 = Boolean.FALSE;
                }
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(bool, bool2);
                return compareValues;
            }
            return compare;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenBy$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.biz.qqcircle.immersive.personal.data.o$h */
    /* loaded from: classes4.dex */
    public static final class h<T> implements Comparator {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Comparator f88569d;

        public h(Comparator comparator) {
            this.f88569d = comparator;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            int compare = this.f88569d.compare(t16, t17);
            if (compare == 0) {
                QFSTroopItemInfo qFSTroopItemInfo = (QFSTroopItemInfo) t16;
                boolean isFull = qFSTroopItemInfo.getIsFull();
                boolean isJoined = qFSTroopItemInfo.getIsJoined();
                if (isFull) {
                    isJoined = !isJoined;
                }
                Boolean valueOf = Boolean.valueOf(isJoined);
                QFSTroopItemInfo qFSTroopItemInfo2 = (QFSTroopItemInfo) t17;
                boolean isFull2 = qFSTroopItemInfo2.getIsFull();
                boolean isJoined2 = qFSTroopItemInfo2.getIsJoined();
                if (isFull2) {
                    isJoined2 = !isJoined2;
                }
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(valueOf, Boolean.valueOf(isJoined2));
                return compareValues;
            }
            return compare;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenBy$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.biz.qqcircle.immersive.personal.data.o$i */
    /* loaded from: classes4.dex */
    public static final class i<T> implements Comparator {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Comparator f88570d;

        public i(Comparator comparator) {
            this.f88570d = comparator;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            int compare = this.f88570d.compare(t16, t17);
            if (compare == 0) {
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(Boolean.valueOf(((QFSTroopItemInfo) t16).getIsFull()), Boolean.valueOf(((QFSTroopItemInfo) t17).getIsFull()));
                return compareValues;
            }
            return compare;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenBy$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.biz.qqcircle.immersive.personal.data.o$j */
    /* loaded from: classes4.dex */
    public static final class j<T> implements Comparator {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Comparator f88571d;

        public j(Comparator comparator) {
            this.f88571d = comparator;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            int compare = this.f88571d.compare(t16, t17);
            if (compare == 0) {
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(Boolean.valueOf(((QFSTroopItemInfo) t16).getIsJoined()), Boolean.valueOf(((QFSTroopItemInfo) t17).getIsJoined()));
                return compareValues;
            }
            return compare;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.biz.qqcircle.immersive.personal.data.o$k */
    /* loaded from: classes4.dex */
    public static final class k<T> implements Comparator {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Comparator f88572d;

        public k(Comparator comparator) {
            this.f88572d = comparator;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            long j3;
            long j16;
            int compareValues;
            int compare = this.f88572d.compare(t16, t17);
            if (compare == 0) {
                QFSTroopItemInfo qFSTroopItemInfo = (QFSTroopItemInfo) t17;
                if (!qFSTroopItemInfo.getIsBound() && qFSTroopItemInfo.getType() != TroopItemType.TEXT) {
                    j3 = Long.valueOf(qFSTroopItemInfo.getId());
                } else {
                    j3 = Long.MIN_VALUE;
                }
                QFSTroopItemInfo qFSTroopItemInfo2 = (QFSTroopItemInfo) t16;
                if (!qFSTroopItemInfo2.getIsBound() && qFSTroopItemInfo2.getType() != TroopItemType.TEXT) {
                    j16 = Long.valueOf(qFSTroopItemInfo2.getId());
                } else {
                    j16 = Long.MIN_VALUE;
                }
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(j3, j16);
                return compareValues;
            }
            return compare;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.biz.qqcircle.immersive.personal.data.o$l */
    /* loaded from: classes4.dex */
    public static final class l<T> implements Comparator {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Comparator f88573d;

        public l(Comparator comparator) {
            this.f88573d = comparator;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            int compare = this.f88573d.compare(t16, t17);
            if (compare == 0) {
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((QFSTroopItemInfo) t17).getId()), Long.valueOf(((QFSTroopItemInfo) t16).getId()));
                return compareValues;
            }
            return compare;
        }
    }

    public QFSTroopItemInfo(@NotNull TroopItemType type, long j3, @NotNull String name, @NotNull String desc, @NotNull String headUrl, int i3, boolean z16, boolean z17, @NotNull String joinAuth, @NotNull String text, boolean z18, boolean z19) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(headUrl, "headUrl");
        Intrinsics.checkNotNullParameter(joinAuth, "joinAuth");
        Intrinsics.checkNotNullParameter(text, "text");
        this.type = type;
        this.id = j3;
        this.name = name;
        this.desc = desc;
        this.headUrl = headUrl;
        this.memberNum = i3;
        this.isFull = z16;
        this.isActive = z17;
        this.joinAuth = joinAuth;
        this.text = text;
        this.isJoined = z18;
        this.isBound = z19;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getHeadUrl() {
        return this.headUrl;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QFSTroopItemInfo)) {
            return false;
        }
        QFSTroopItemInfo qFSTroopItemInfo = (QFSTroopItemInfo) other;
        if (this.type == qFSTroopItemInfo.type && this.id == qFSTroopItemInfo.id && Intrinsics.areEqual(this.name, qFSTroopItemInfo.name) && Intrinsics.areEqual(this.desc, qFSTroopItemInfo.desc) && Intrinsics.areEqual(this.headUrl, qFSTroopItemInfo.headUrl) && this.memberNum == qFSTroopItemInfo.memberNum && this.isFull == qFSTroopItemInfo.isFull && this.isActive == qFSTroopItemInfo.isActive && Intrinsics.areEqual(this.joinAuth, qFSTroopItemInfo.joinAuth) && Intrinsics.areEqual(this.text, qFSTroopItemInfo.text) && this.isJoined == qFSTroopItemInfo.isJoined && this.isBound == qFSTroopItemInfo.isBound) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: g, reason: from getter */
    public final int getMemberNum() {
        return this.memberNum;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((((this.type.hashCode() * 31) + androidx.fragment.app.a.a(this.id)) * 31) + this.name.hashCode()) * 31) + this.desc.hashCode()) * 31) + this.headUrl.hashCode()) * 31) + this.memberNum) * 31;
        boolean z16 = this.isFull;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int i17 = (hashCode + i16) * 31;
        boolean z17 = this.isActive;
        int i18 = z17;
        if (z17 != 0) {
            i18 = 1;
        }
        int hashCode2 = (((((i17 + i18) * 31) + this.joinAuth.hashCode()) * 31) + this.text.hashCode()) * 31;
        boolean z18 = this.isJoined;
        int i19 = z18;
        if (z18 != 0) {
            i19 = 1;
        }
        int i26 = (hashCode2 + i19) * 31;
        boolean z19 = this.isBound;
        if (!z19) {
            i3 = z19 ? 1 : 0;
        }
        return i26 + i3;
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final String getText() {
        return this.text;
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final TroopItemType getType() {
        return this.type;
    }

    /* renamed from: k, reason: from getter */
    public final boolean getIsActive() {
        return this.isActive;
    }

    /* renamed from: l, reason: from getter */
    public final boolean getIsBound() {
        return this.isBound;
    }

    /* renamed from: m, reason: from getter */
    public final boolean getIsFull() {
        return this.isFull;
    }

    /* renamed from: n, reason: from getter */
    public final boolean getIsJoined() {
        return this.isJoined;
    }

    public final void o(boolean z16) {
        this.isBound = z16;
    }

    @NotNull
    public String toString() {
        return "QFSTroopItemInfo(type=" + this.type + ", id=" + this.id + ", name=" + this.name + ", desc=" + this.desc + ", headUrl=" + this.headUrl + ", memberNum=" + this.memberNum + ", isFull=" + this.isFull + ", isActive=" + this.isActive + ", joinAuth=" + this.joinAuth + ", text=" + this.text + ", isJoined=" + this.isJoined + ", isBound=" + this.isBound + ")";
    }
}
