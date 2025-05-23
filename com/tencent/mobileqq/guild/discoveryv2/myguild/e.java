package com.tencent.mobileqq.guild.discoveryv2.myguild;

import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMedalInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendLabel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/myguild/e;", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002J\u0016\u0010\t\u001a\u00020\u00052\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002J\u001e\u0010\u000e\u001a\u00020\r2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/myguild/e$a;", "", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendLabel;", "tagList", "", "c", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProMedalInfo;", "medalInfos", "b", "topGuildList", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.discoveryv2.myguild.e$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(@Nullable List<String> topGuildList, @NotNull IGProGuildInfo guildInfo) {
            Intrinsics.checkNotNullParameter(guildInfo, "guildInfo");
            if (topGuildList == null) {
                return false;
            }
            for (String str : topGuildList) {
                if (!TextUtils.isEmpty(str) && TextUtils.equals(str, guildInfo.getGuildID())) {
                    return true;
                }
            }
            return false;
        }

        @NotNull
        public final String b(@Nullable List<? extends IGProMedalInfo> medalInfos) {
            ArrayList<IGProMedalInfo> arrayList;
            boolean z16;
            boolean z17 = false;
            if (medalInfos != null) {
                arrayList = new ArrayList();
                for (Object obj : medalInfos) {
                    IGProMedalInfo iGProMedalInfo = (IGProMedalInfo) obj;
                    if (iGProMedalInfo.getExpireTime() != 0 && iGProMedalInfo.getExpireTime() <= NetConnInfoCenter.getServerTime()) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    if (z16) {
                        arrayList.add(obj);
                    }
                }
            } else {
                arrayList = null;
            }
            ArrayList arrayList2 = arrayList;
            if (arrayList2 == null || arrayList2.isEmpty()) {
                z17 = true;
            }
            if (z17) {
                return "";
            }
            for (IGProMedalInfo iGProMedalInfo2 : arrayList) {
                if (!(iGProMedalInfo2 instanceof IGProMedalInfo)) {
                    iGProMedalInfo2 = null;
                }
                if (iGProMedalInfo2 != null && iGProMedalInfo2.getOfficialMedalInfoExt().getIsOffical()) {
                    return com.tencent.mobileqq.guild.util.an.INSTANCE.d();
                }
            }
            return "";
        }

        @NotNull
        public final List<String> c(@Nullable List<? extends IGProRecommendLabel> tagList) {
            boolean z16;
            List take;
            int collectionSizeOrDefault;
            boolean z17;
            List<String> emptyList;
            List<? extends IGProRecommendLabel> list = tagList;
            if (list != null && !list.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                return emptyList;
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : tagList) {
                String labelName = ((IGProRecommendLabel) obj).getLabelName();
                if (labelName != null && labelName.length() != 0) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (!z17) {
                    arrayList.add(obj);
                }
            }
            take = CollectionsKt___CollectionsKt.take(arrayList, 2);
            List list2 = take;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                arrayList2.add(((IGProRecommendLabel) it.next()).getLabelName());
            }
            return arrayList2;
        }

        Companion() {
        }
    }
}
