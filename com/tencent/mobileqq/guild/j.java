package com.tencent.mobileqq.guild;

import com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi;
import com.tencent.mobileqq.guild.home.fragments.GuildHomeFragment;
import com.tencent.mobileqq.guild.homev2.fragments.GuildHomeV2Fragment;
import com.tencent.mobileqq.guild.setting.guildsetting.GuildSettingFragment;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\"\u0010\f\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00020\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/j;", "", "", "objClassName", "", "b", "Ljava/lang/String;", "packageName", "", "kotlin.jvm.PlatformType", "c", "Ljava/util/List;", "classWhiteList", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final j f226354a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String packageName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<String> classWhiteList;

    static {
        String substringBeforeLast$default;
        List listOf;
        int collectionSizeOrDefault;
        j jVar = new j();
        f226354a = jVar;
        String name = jVar.getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "javaClass.name");
        substringBeforeLast$default = StringsKt__StringsKt.substringBeforeLast$default(name, ".", (String) null, 2, (Object) null);
        packageName = substringBeforeLast$default;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{GuildHomeFragment.class, GuildSettingFragment.class, GuildHomeV2Fragment.class, ((IGuildFeedUtilsApi) QRoute.api(IGuildFeedUtilsApi.class)).getFeedNativeDetailFragment(), ((IGuildFeedUtilsApi) QRoute.api(IGuildFeedUtilsApi.class)).getGuildFeedGalleryFragment()});
        List list = listOf;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((Class) it.next()).getName());
        }
        classWhiteList = arrayList;
    }

    j() {
    }

    public final boolean b(@NotNull String objClassName) {
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(objClassName, "objClassName");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(objClassName, packageName, false, 2, null);
        boolean contains = classWhiteList.contains(objClassName);
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildGProWaitWhiteList", 2, "objClassName: " + objClassName + ", packageName: " + packageName + ", isGuildPackage: " + startsWith$default + ", inWhiteList: " + contains);
        }
        return contains;
    }
}
