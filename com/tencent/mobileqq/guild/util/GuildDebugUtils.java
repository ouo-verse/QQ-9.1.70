package com.tencent.mobileqq.guild.util;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\t\rB\t\b\u0002\u00a2\u0006\u0004\b#\u0010$J\u0011\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\bJ'\u0010\t\u001a\u00020\u0002\"\u000e\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\b\u001a\u00028\u0000H\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\u00022\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bH\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\u001f\u0010\u0014\u001a\u00020\u00022\u0010\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b\u00a2\u0006\u0004\b\u0014\u0010\u000eJ&\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u00172\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0002J$\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c\"\u0004\b\u0000\u0010\u00192\u0006\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u0002R#\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u001f\u001a\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/guild/util/GuildDebugUtils;", "", "", "guildId", "", "f", "Lcom/tencent/mobileqq/pb/MessageMicro;", "ITEM", "pb", "a", "(Lcom/tencent/mobileqq/pb/MessageMicro;)Ljava/lang/String;", "", "args", "b", "([Ljava/lang/Object;)Ljava/lang/String;", "Landroidx/fragment/app/Fragment;", "fragment", "Landroidx/fragment/app/FragmentManager;", tl.h.F, "arguments", "d", "name", "method", "Lkotlin/Lazy;", "c", "T", "tag", "valueName", "Lcom/tencent/mobileqq/guild/util/GuildDebugUtils$b;", "g", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "e", "()Ljava/util/concurrent/ConcurrentHashMap;", "newFeedSquareResults", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildDebugUtils {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildDebugUtils f235333a = new GuildDebugUtils();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, String> newFeedSquareResults = new ConcurrentHashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/util/GuildDebugUtils$a;", "", "", "a", "Ljava/util/concurrent/atomic/AtomicLong;", "b", "Ljava/util/concurrent/atomic/AtomicLong;", "sequence", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f235335a = new a();

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static final AtomicLong sequence = new AtomicLong(0);

        a() {
        }

        public final long a() {
            return sequence.incrementAndGet();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0019\b\u0000\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0018\u0010\u0011\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/util/GuildDebugUtils$b;", "T", "", "", "message", "d", "newValue", "", "e", "(Ljava/lang/Object;Ljava/lang/String;)V", "a", "Ljava/lang/String;", "tag", "b", "valueName", "c", "Ljava/lang/Object;", "lastValue", "", "Z", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_FIRST, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b<T> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String tag;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String valueName;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private T lastValue;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean first;

        public b(@NotNull String tag, @NotNull String valueName) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(valueName, "valueName");
            this.tag = tag;
            this.valueName = valueName;
            this.first = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String d(String message) {
            boolean z16;
            if (message.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                message = null;
            }
            if (message != null) {
                String str = "[" + message + "] ";
                if (str != null) {
                    return str;
                }
            }
            return "";
        }

        public final void e(T newValue, @NotNull String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            if (this.first) {
                Logger logger = Logger.f235387a;
                String str = this.tag;
                logger.d().i(str, 1, d(message) + this.valueName + " set: " + newValue + "[" + System.identityHashCode(this) + "]");
                this.lastValue = newValue;
                this.first = false;
                return;
            }
            if (!Intrinsics.areEqual(this.lastValue, newValue)) {
                Logger logger2 = Logger.f235387a;
                String str2 = this.tag;
                logger2.d().i(str2, 1, d(message) + this.valueName + " changed: " + this.lastValue + " -> " + newValue + "[" + System.identityHashCode(this) + "]");
                this.lastValue = newValue;
            }
        }
    }

    GuildDebugUtils() {
    }

    @JvmStatic
    @NotNull
    public static final <ITEM extends MessageMicro<ITEM>> String a(@NotNull ITEM pb5) {
        Intrinsics.checkNotNullParameter(pb5, "pb");
        String convertToJson = ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).convertToJson(pb5);
        Intrinsics.checkNotNullExpressionValue(convertToJson, "api(IGuildFeatureAdapter\u2026s.java).convertToJson(pb)");
        return convertToJson;
    }

    @JvmStatic
    @NotNull
    public static final String b(@NotNull Object[] args) {
        String joinToString$default;
        boolean z16;
        Intrinsics.checkNotNullParameter(args, "args");
        ArrayList arrayList = new ArrayList();
        for (Object obj : args) {
            if (obj != null && obj.getClass().isAnonymousClass()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                arrayList.add(obj);
            }
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", null, null, 0, null, new Function1<Object, CharSequence>() { // from class: com.tencent.mobileqq.guild.util.GuildDebugUtils$descriptionOf$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(@Nullable Object obj2) {
                return String.valueOf(obj2);
            }
        }, 30, null);
        return joinToString$default;
    }

    @JvmStatic
    public static final boolean f(@NotNull String guildId) {
        List emptyList;
        Boolean bool;
        Pair pair;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        boolean contains = emptyList.contains(guildId);
        com.tencent.mobileqq.guild.base.extension.r rVar = com.tencent.mobileqq.guild.base.extension.r.f214743a;
        String str = "";
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
        IGProGuildInfo guildInfo = ((IGPSService) S0).getGuildInfo(guildId);
        if (guildInfo != null) {
            bool = Boolean.valueOf(guildInfo.isMovePostSection());
        } else {
            bool = null;
        }
        if (contains) {
            pair = TuplesKt.to(Boolean.TRUE, "HardCode");
        } else if (bool == null) {
            pair = TuplesKt.to(Boolean.FALSE, "NullGuildInfo");
        } else {
            pair = TuplesKt.to(bool, "GuildInfo");
        }
        GuildDebugUtils guildDebugUtils = f235333a;
        String str2 = guildDebugUtils.e().get(guildId);
        if (str2 != null) {
            str = str2;
        }
        String pair2 = pair.toString();
        if (!Intrinsics.areEqual(str, pair2)) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GUILD_DEBUG", 2, "isNewFeedSquare " + guildId + MsgSummary.STR_COLON + pair2);
            }
            guildDebugUtils.e().put(guildId, pair2);
        }
        return ((Boolean) pair.getFirst()).booleanValue();
    }

    private final FragmentManager h(Fragment fragment) {
        if (fragment == null) {
            return null;
        }
        try {
            return fragment.getChildFragmentManager();
        } catch (IllegalStateException unused) {
            return null;
        }
    }

    @NotNull
    public final Lazy<String> c(@Nullable final Fragment fragment, @NotNull final String name, @NotNull final String method) {
        View view;
        Boolean bool;
        String str;
        final Fragment fragment2;
        Lazy<String> lazy;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(method, "method");
        View view2 = null;
        if (fragment != null) {
            view = fragment.getView();
        } else {
            view = null;
        }
        if (fragment != null) {
            bool = Boolean.valueOf(fragment.isDetached());
        } else {
            bool = null;
        }
        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            str = "D";
        } else if (Intrinsics.areEqual(bool, Boolean.FALSE)) {
            str = ExifInterface.GPS_MEASUREMENT_IN_PROGRESS;
        } else if (bool == null) {
            str = "U";
        } else {
            throw new NoWhenBranchMatchedException();
        }
        final String str2 = str;
        FragmentManager h16 = h(fragment);
        if (h16 != null) {
            fragment2 = h16.findFragmentByTag("GuildDiscoverController_QQGuildDiscoverFragment");
        } else {
            fragment2 = null;
        }
        if (view != null) {
            view2 = view.findViewById(R.id.wp8);
        }
        final View view3 = view2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.guild.util.GuildDebugUtils$fragmentDebugLog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                String str3 = name;
                String str4 = method;
                String str5 = str2;
                Fragment fragment3 = fragment;
                return "[" + str3 + "]" + str4 + "," + str5 + ",T:" + (fragment3 != null ? fragment3.getTag() : null) + ",id:" + System.identityHashCode(fragment) + "/" + System.identityHashCode(view3) + "/" + System.identityHashCode(fragment2);
            }
        });
        return lazy;
    }

    @NotNull
    public final String d(@Nullable Object[] arguments) {
        String joinToString$default;
        if (arguments == null) {
            return "";
        }
        ArrayList arrayList = new ArrayList(arguments.length);
        for (Object obj : arguments) {
            if (obj != null && obj.getClass().isAnonymousClass()) {
                obj = "<ANONYMOUS>";
            }
            arrayList.add(obj);
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", null, null, 0, null, new Function1<Object, CharSequence>() { // from class: com.tencent.mobileqq.guild.util.GuildDebugUtils$getArgumentsString$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(@Nullable Object obj2) {
                return String.valueOf(obj2);
            }
        }, 30, null);
        return joinToString$default;
    }

    @NotNull
    public final ConcurrentHashMap<String, String> e() {
        return newFeedSquareResults;
    }

    @NotNull
    public final <T> b<T> g(@NotNull String tag, @NotNull String valueName) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(valueName, "valueName");
        return new b<>("ValueChange." + tag, valueName);
    }
}
