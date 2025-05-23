package ij1;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.GuildScheduleInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.v8rt.anno.NotNull;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCapsule;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStNotice;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProTopFeed;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes13.dex */
public class c {
    public static ArrayList<String> a(GProCapsule gProCapsule) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (gProCapsule != null && gProCapsule.avatarMetaList.size() != 0) {
            Iterator<String> it = gProCapsule.avatarMetaList.iterator();
            while (it.hasNext()) {
                try {
                    arrayList.add(it.next());
                } catch (Exception e16) {
                    QLog.d("GuildFeedTransFormUtils", 1, "transForm transFormFeedCapsuleUrl error:" + e16.getMessage());
                }
            }
            return arrayList;
        }
        return arrayList;
    }

    @Nullable
    public static GuildGameDistributeAdData b(String str, @Nullable byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return new GuildGameDistributeAdData(str, bArr);
    }

    @NotNull
    public static ArrayList<g> c(List<GProStFeed> list, String str) {
        ArrayList<g> arrayList = new ArrayList<>();
        if (list != null && list.size() != 0) {
            Iterator<GProStFeed> it = list.iterator();
            while (it.hasNext()) {
                try {
                    g gVar = new g(it.next());
                    if (!TextUtils.isEmpty(str)) {
                        gVar.e(str);
                    }
                    if (gVar.A()) {
                        arrayList.add(gVar.E());
                    }
                } catch (Exception e16) {
                    QLog.d("GuildFeedTransFormUtils", 1, "transForm transFormFeedListToBlockList error:" + e16.getMessage());
                }
            }
            return arrayList;
        }
        return arrayList;
    }

    public static ArrayList<h> d(ArrayList<GProTopFeed> arrayList) {
        ArrayList<h> arrayList2 = new ArrayList<>();
        if (arrayList != null && arrayList.size() != 0) {
            Iterator<GProTopFeed> it = arrayList.iterator();
            while (it.hasNext()) {
                try {
                    arrayList2.add(new h(it.next()).i());
                } catch (Exception e16) {
                    QLog.d("GuildFeedTransFormUtils", 1, "transForm transFormFeedListToBlockList error:" + e16.getMessage());
                }
            }
            return arrayList2;
        }
        return arrayList2;
    }

    public static ArrayList<v<?>> e(List<GProStNotice> list) {
        ArrayList<v<?>> arrayList = new ArrayList<>();
        if (list != null && list.size() != 0) {
            Iterator<GProStNotice> it = list.iterator();
            while (it.hasNext()) {
                try {
                    arrayList.add(new a(it.next()).i());
                } catch (Exception e16) {
                    QLog.d("GuildFeedTransFormUtils", 1, "transForm transFormMessageListToBlockList error:" + e16.getMessage());
                }
            }
            return arrayList;
        }
        return arrayList;
    }

    @Nullable
    public static GuildScheduleInfo f(byte[] bArr) {
        return ((IGPSService) ch.R0(IGPSService.class)).decodeGuildScheduleInfo(bArr);
    }
}
