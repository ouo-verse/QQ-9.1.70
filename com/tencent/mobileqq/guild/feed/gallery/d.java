package com.tencent.mobileqq.guild.feed.gallery;

import android.util.Log;
import android.util.Pair;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.guild.feed.adapter.n;
import com.tencent.mobileqq.guild.feed.util.bm;
import com.tencent.mobileqq.guild.picload.e;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J$\u0010\n\u001a\u00020\u00042\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bH\u0007J\u0016\u0010\r\u001a\u00020\u00042\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/d;", "", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStImage;", "info", "", "a", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/guild/feed/adapter/n;", "Lkotlin/collections/ArrayList;", "dataList", "b", "", "list", "c", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f219630a = new d();

    d() {
    }

    @JvmStatic
    public static final void a(@Nullable GProStImage info) {
        if (info != null) {
            String i3 = bm.i(info);
            Pair<Integer, Integer> j3 = bm.j(info);
            Object obj = j3.first;
            Intrinsics.checkNotNullExpressionValue(obj, "imageSize.first");
            int intValue = ((Number) obj).intValue();
            Object obj2 = j3.second;
            Intrinsics.checkNotNullExpressionValue(obj2, "imageSize.second");
            Option c16 = b.c(i3, intValue, ((Number) obj2).intValue(), false, 8, null);
            c16.setPredecode(false);
            e.a().e(c16);
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("Guild_Feed_GAL_GuildFeedPreLoad", "[preLoadGalleryImage] url:" + i3.hashCode() + ", w:" + j3.first + ", h:" + j3.second + " ");
            }
        }
    }

    @JvmStatic
    public static final void b(@Nullable ArrayList<n> dataList) {
        boolean z16;
        Integer num;
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            if (dataList != null) {
                num = Integer.valueOf(dataList.size());
            } else {
                num = null;
            }
            Log.d("Guild_Feed_GAL_GuildFeedPreLoad", "[preLoadGalleryImage] dataList size:" + num);
        }
        if (dataList != null && !dataList.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        Iterator<T> it = dataList.iterator();
        while (it.hasNext()) {
            a(((n) it.next()).c());
        }
    }

    public final void c(@Nullable List<GProStImage> list) {
        Integer num;
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            if (list != null) {
                num = Integer.valueOf(list.size());
            } else {
                num = null;
            }
            Log.d("Guild_Feed_GAL_GuildFeedPreLoad", "[preLoadGalleryImage] list size:" + num);
        }
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                a((GProStImage) it.next());
            }
        }
    }
}
