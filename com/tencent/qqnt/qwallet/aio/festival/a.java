package com.tencent.qqnt.qwallet.aio.festival;

import com.qwallet.utils.QWalletUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qwallet.utils.g;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0016\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bR$\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/qwallet/aio/festival/a;", "", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/qwallet/aio/festival/a$a;", "Lkotlin/collections/ArrayList;", "e", "", "b", "", "msgTime", "", "c", "", "uniKey", "d", "a", "Ljava/util/ArrayList;", "playedList", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f361721a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ArrayList<SaveData> playedList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0013\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0011\u001a\u0004\b\t\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/qwallet/aio/festival/a$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "uniKey", "b", "uin", "", "J", "()J", "msgTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;J)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.qwallet.aio.festival.a$a, reason: collision with other inner class name and from toString */
    /* loaded from: classes25.dex */
    public static final /* data */ class SaveData {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String uniKey;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String uin;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final long msgTime;

        public SaveData(@NotNull String uniKey, @NotNull String uin, long j3) {
            Intrinsics.checkNotNullParameter(uniKey, "uniKey");
            Intrinsics.checkNotNullParameter(uin, "uin");
            this.uniKey = uniKey;
            this.uin = uin;
            this.msgTime = j3;
        }

        /* renamed from: a, reason: from getter */
        public final long getMsgTime() {
            return this.msgTime;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getUin() {
            return this.uin;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getUniKey() {
            return this.uniKey;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SaveData)) {
                return false;
            }
            SaveData saveData = (SaveData) other;
            if (Intrinsics.areEqual(this.uniKey, saveData.uniKey) && Intrinsics.areEqual(this.uin, saveData.uin) && this.msgTime == saveData.msgTime) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.uniKey.hashCode() * 31) + this.uin.hashCode()) * 31) + androidx.fragment.app.a.a(this.msgTime);
        }

        @NotNull
        public String toString() {
            return "SaveData(uniKey=" + this.uniKey + ", uin=" + this.uin + ", msgTime=" + this.msgTime + ")";
        }
    }

    static {
        a aVar = new a();
        f361721a = aVar;
        playedList = aVar.e();
    }

    a() {
    }

    private final void b() {
        JSONArray jSONArray = new JSONArray();
        for (SaveData saveData : playedList) {
            if (!f361721a.c(saveData.getMsgTime())) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("uniKey", saveData.getUniKey());
                jSONObject.put("uin", saveData.getUin());
                jSONObject.put("msgTime", saveData.getMsgTime());
                jSONArray.mo162put(jSONObject);
            }
        }
        String jSONArray2 = jSONArray.toString();
        Intrinsics.checkNotNullExpressionValue(jSONArray2, "jsonArray.toString()");
        g.q("qwallet_hb_festival_aio_anim_played_nt", jSONArray2);
    }

    private final boolean c(long msgTime) {
        if (NetConnInfoCenter.getServerTime() - msgTime > 90000) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004d A[Catch: all -> 0x0068, TRY_LEAVE, TryCatch #0 {all -> 0x0068, blocks: (B:3:0x0009, B:9:0x001d, B:11:0x0029, B:14:0x0040, B:22:0x004d), top: B:2:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final ArrayList<SaveData> e() {
        String i3;
        boolean z16;
        boolean z17;
        ArrayList<SaveData> arrayList = new ArrayList<>();
        try {
            i3 = g.i("qwallet_hb_festival_aio_anim_played_nt");
            if (i3.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
        } catch (Throwable th5) {
            QLog.e("FestivalNativeData", 4, th5, new Object[0]);
        }
        if (z16) {
            return arrayList;
        }
        JSONArray jSONArray = new JSONArray(i3);
        int length = jSONArray.length();
        for (int i16 = 0; i16 < length; i16++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i16);
            long optLong = optJSONObject.optLong("msgTime");
            String uniKey = optJSONObject.optString("uniKey");
            if (!c(optLong)) {
                if (uniKey != null && uniKey.length() != 0) {
                    z17 = false;
                    if (z17) {
                        Intrinsics.checkNotNullExpressionValue(uniKey, "uniKey");
                        String optString = optJSONObject.optString("uin");
                        Intrinsics.checkNotNullExpressionValue(optString, "indexObj.optString(\"uin\")");
                        arrayList.add(new SaveData(uniKey, optString, optLong));
                    }
                }
                z17 = true;
                if (z17) {
                }
            }
        }
        return arrayList;
    }

    public final void a(@NotNull String uniKey, long msgTime) {
        Intrinsics.checkNotNullParameter(uniKey, "uniKey");
        ArrayList<SaveData> arrayList = playedList;
        String h16 = QWalletUtils.h();
        if (h16 == null) {
            h16 = "";
        }
        arrayList.add(new SaveData(uniKey, h16, msgTime));
        b();
    }

    public final boolean d(@NotNull String uniKey, long msgTime) {
        boolean z16;
        Intrinsics.checkNotNullParameter(uniKey, "uniKey");
        if (c(msgTime)) {
            QLog.d("FestivalNativeData", 1, uniKey + " isPlayed isOutOfTime msgTime = " + msgTime);
            return true;
        }
        ArrayList<SaveData> arrayList = playedList;
        boolean z17 = false;
        if (!(arrayList instanceof Collection) || !arrayList.isEmpty()) {
            Iterator<T> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                SaveData saveData = (SaveData) it.next();
                if (Intrinsics.areEqual(saveData.getUniKey(), uniKey) && Intrinsics.areEqual(saveData.getUin(), QWalletUtils.h())) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    z17 = true;
                    break;
                }
            }
        }
        QLog.d("FestivalNativeData", 1, uniKey + " isPlayed result = " + z17);
        return z17;
    }
}
