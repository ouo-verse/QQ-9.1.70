package com.tencent.mobileqq.guild.home.viewmodels.header;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.guild.home.viewmodels.header.uidata.GuildHomeHeaderGameDistribute;
import com.tencent.mobileqq.guild.home.viewmodels.header.uidata.GuildHomeHeaderNavigationBar;
import com.tencent.mobileqq.guild.home.viewmodels.header.uidata.GuildHomeHeaderSpace;
import com.tencent.mobileqq.guild.util.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ-\u0010\u0006\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0003*\u00020\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0005\u001a\u00028\u0000H\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b*\b\u0012\u0004\u0012\u00020\u00020\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/home/viewmodels/header/i;", "", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/b;", "T", "", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "b", "(Ljava/util/List;Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/b;)Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/b;", "", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f225419a = new i();

    i() {
    }

    @JvmStatic
    @Nullable
    public static final <T extends com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b> T b(@NotNull List<T> list, @NotNull T item) {
        Object obj;
        boolean z16;
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(item, "item");
        Iterator<T> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b) obj).getId() == item.getId()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        T t16 = (T) obj;
        if (t16 == null) {
            Logger.f235387a.d().w("Guild.MF.headerBars.GuildHomeHeaderBarsViewModelHelper", 1, "replaceData but not found old data!");
            list.add(item);
            return null;
        }
        list.set(list.indexOf(t16), item);
        return t16;
    }

    @NotNull
    public final List<com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b> a(@NotNull List<? extends com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : list) {
            if (((com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b) obj).getIsActive()) {
                arrayList2.add(obj);
            }
        }
        if (arrayList2.isEmpty()) {
            arrayList.add(GuildHomeHeaderSpace.INSTANCE.b(15.0f));
            return arrayList;
        }
        int i3 = 0;
        com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b bVar = (com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b) arrayList2.get(0);
        if (bVar instanceof GuildHomeHeaderNavigationBar) {
            arrayList.add(GuildHomeHeaderSpace.INSTANCE.b(11.0f));
        } else if (bVar instanceof GuildHomeHeaderGameDistribute) {
            arrayList.add(GuildHomeHeaderSpace.INSTANCE.b(15.0f));
        } else if (bVar instanceof com.tencent.mobileqq.guild.home.viewmodels.header.uidata.e) {
            arrayList.add(GuildHomeHeaderSpace.INSTANCE.b(15.0f));
        }
        for (Object obj2 : arrayList2) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b bVar2 = (com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b) obj2;
            arrayList.add(bVar2);
            if (bVar2 instanceof GuildHomeHeaderNavigationBar) {
                arrayList.add(GuildHomeHeaderSpace.INSTANCE.b(11.0f));
            } else if (bVar2 instanceof GuildHomeHeaderGameDistribute) {
                arrayList.add(GuildHomeHeaderSpace.INSTANCE.b(15.0f));
            }
            i3 = i16;
        }
        return arrayList;
    }
}
