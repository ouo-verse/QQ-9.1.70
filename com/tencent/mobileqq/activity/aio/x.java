package com.tencent.mobileqq.activity.aio;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.bussinfo.mutualmark.mutualmark$MutualmarkInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.bussinfo.mutualmark.mutualmark$ResourceInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.bussinfo.mutualmark.mutualmark$ResourceInfo_17;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7$RelationalChainChange;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7$RelationalChainInfo;
import tencent.intimate_relation.intimate_relation$IntimateInfo;
import tencent.intimate_relation.intimate_relation$SnsRelationInfo;

/* compiled from: P */
/* loaded from: classes10.dex */
public class x {

    /* renamed from: a, reason: collision with root package name */
    public String f180247a;

    /* renamed from: b, reason: collision with root package name */
    public String f180248b;

    /* renamed from: c, reason: collision with root package name */
    public int f180249c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f180250d = true;

    /* renamed from: e, reason: collision with root package name */
    public c f180251e;

    /* renamed from: f, reason: collision with root package name */
    public c f180252f;

    /* renamed from: g, reason: collision with root package name */
    public ArrayList<a> f180253g;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public c f180254a;

        /* renamed from: b, reason: collision with root package name */
        public c f180255b;
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f180256a;

        /* renamed from: b, reason: collision with root package name */
        public long f180257b;

        /* renamed from: c, reason: collision with root package name */
        public String f180258c;

        /* renamed from: d, reason: collision with root package name */
        public int f180259d;

        public boolean a() {
            return !TextUtils.isEmpty(this.f180256a);
        }

        @NonNull
        public String toString() {
            return "MutualMarkPushGrayTipInfo{notifyTime:" + this.f180257b + ", grayTipType:" + this.f180259d + ", }";
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public int f180260a;

        /* renamed from: b, reason: collision with root package name */
        public b f180261b;

        /* renamed from: c, reason: collision with root package name */
        public a f180262c;

        /* renamed from: d, reason: collision with root package name */
        public byte[] f180263d;

        /* compiled from: P */
        /* loaded from: classes10.dex */
        public static class a {

            /* renamed from: a, reason: collision with root package name */
            public int f180264a;

            public static a a(byte[] bArr) {
                intimate_relation$SnsRelationInfo intimate_relation_snsrelationinfo = new intimate_relation$SnsRelationInfo();
                a aVar = null;
                try {
                    intimate_relation_snsrelationinfo.mergeFrom(bArr);
                    if (intimate_relation_snsrelationinfo.intimate_list.has() && intimate_relation_snsrelationinfo.intimate_list.size() > 0) {
                        aVar = new a();
                        intimate_relation$IntimateInfo intimate_relation_intimateinfo = intimate_relation_snsrelationinfo.intimate_list.get(0);
                        if (intimate_relation_intimateinfo.lover.has() && intimate_relation_intimateinfo.lover.get().level.has()) {
                            aVar.f180264a = intimate_relation_intimateinfo.lover.get().level.get();
                        } else if (intimate_relation_intimateinfo.buddy.has() && intimate_relation_intimateinfo.buddy.get().level.has()) {
                            aVar.f180264a = intimate_relation_intimateinfo.buddy.get().level.get();
                        } else if (intimate_relation_intimateinfo.ladybro.has() && intimate_relation_intimateinfo.ladybro.get().level.has()) {
                            aVar.f180264a = intimate_relation_intimateinfo.ladybro.get().level.get();
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("ExtSnsIntimateInfo", 1, "parseFrom retInfo:" + aVar);
                    }
                    return aVar;
                } catch (Throwable th5) {
                    QLog.i("ExtSnsIntimateInfo", 1, "parseFrom error:" + th5.getMessage());
                    return null;
                }
            }

            @NonNull
            public String toString() {
                return "ExtSnsIntimatePushInfo{intimate_level:" + this.f180264a + ", }";
            }
        }

        /* compiled from: P */
        /* loaded from: classes10.dex */
        public static class b {

            /* renamed from: a, reason: collision with root package name */
            public long f180265a;

            /* renamed from: b, reason: collision with root package name */
            public long f180266b;

            /* renamed from: c, reason: collision with root package name */
            public long f180267c;

            /* renamed from: d, reason: collision with root package name */
            public long f180268d;

            /* renamed from: e, reason: collision with root package name */
            public int f180269e;

            /* renamed from: f, reason: collision with root package name */
            public String f180270f;

            /* renamed from: g, reason: collision with root package name */
            public String f180271g;

            /* renamed from: h, reason: collision with root package name */
            public long f180272h;

            /* renamed from: i, reason: collision with root package name */
            public long f180273i;

            /* renamed from: j, reason: collision with root package name */
            public long f180274j;

            /* renamed from: k, reason: collision with root package name */
            public long f180275k;

            /* renamed from: l, reason: collision with root package name */
            public int f180276l;

            /* renamed from: m, reason: collision with root package name */
            public String f180277m = "";

            /* renamed from: n, reason: collision with root package name */
            public String f180278n = "";

            /* renamed from: o, reason: collision with root package name */
            public String f180279o = "";

            /* renamed from: p, reason: collision with root package name */
            public String f180280p = "";

            /* renamed from: q, reason: collision with root package name */
            public String f180281q = "";

            /* renamed from: r, reason: collision with root package name */
            public boolean f180282r = false;

            /* renamed from: s, reason: collision with root package name */
            public boolean f180283s = false;

            /* renamed from: t, reason: collision with root package name */
            public int f180284t;

            /* renamed from: u, reason: collision with root package name */
            public boolean f180285u;

            public static b a(long j3, byte[] bArr) {
                boolean z16;
                mutualmark$MutualmarkInfo mutualmark_mutualmarkinfo = new mutualmark$MutualmarkInfo();
                mutualmark$ResourceInfo mutualmark_resourceinfo = null;
                try {
                    mutualmark_mutualmarkinfo.mergeFrom(bArr);
                    b bVar = new b();
                    bVar.f180265a = j3;
                    if (mutualmark_mutualmarkinfo.uint32_level.has()) {
                        bVar.f180266b = mutualmark_mutualmarkinfo.uint32_level.get();
                    }
                    if (mutualmark_mutualmarkinfo.uint64_last_action_time.has()) {
                        bVar.f180267c = mutualmark_mutualmarkinfo.uint64_last_action_time.get();
                    }
                    if (mutualmark_mutualmarkinfo.uint64_last_change_time.has()) {
                        bVar.f180268d = mutualmark_mutualmarkinfo.uint64_last_change_time.get();
                    }
                    if (mutualmark_mutualmarkinfo.uint32_continue_days.has()) {
                        bVar.f180269e = mutualmark_mutualmarkinfo.uint32_continue_days.get();
                    }
                    if (mutualmark_mutualmarkinfo.bytes_wildcard_wording.has()) {
                        bVar.f180270f = mutualmark_mutualmarkinfo.bytes_wildcard_wording.get().toStringUtf8();
                    }
                    if (mutualmark_mutualmarkinfo.bytes_duplicate_removal_key.has()) {
                        bVar.f180271g = mutualmark_mutualmarkinfo.bytes_duplicate_removal_key.get().toStringUtf8();
                    }
                    if (mutualmark_mutualmarkinfo.uint64_notify_time.has()) {
                        bVar.f180272h = mutualmark_mutualmarkinfo.uint64_notify_time.get();
                    }
                    if (mutualmark_mutualmarkinfo.uint64_icon_status.has()) {
                        bVar.f180273i = mutualmark_mutualmarkinfo.uint64_icon_status.get();
                    }
                    if (mutualmark_mutualmarkinfo.uint64_icon_status_end_time.has()) {
                        bVar.f180274j = mutualmark_mutualmarkinfo.uint64_icon_status_end_time.get();
                    }
                    if (mutualmark_mutualmarkinfo.uint64_sub_level.has()) {
                        bVar.f180275k = mutualmark_mutualmarkinfo.uint64_sub_level.get();
                    }
                    if (mutualmark_mutualmarkinfo.uint32_graytip_type.has()) {
                        bVar.f180276l = mutualmark_mutualmarkinfo.uint32_graytip_type.get();
                    }
                    if (mutualmark_mutualmarkinfo.mark_version.has()) {
                        bVar.f180284t = mutualmark_mutualmarkinfo.mark_version.get();
                    }
                    if (mutualmark_mutualmarkinfo.is_wearing.has()) {
                        bVar.f180285u = mutualmark_mutualmarkinfo.is_wearing.get();
                    }
                    if (mutualmark_mutualmarkinfo.uint32_close_flag.has()) {
                        if (mutualmark_mutualmarkinfo.uint32_close_flag.get() != 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        bVar.f180282r = z16;
                    }
                    if (mutualmark_mutualmarkinfo.bytes_resource_info.has()) {
                        mutualmark$ResourceInfo_17 mutualmark_resourceinfo_17 = new mutualmark$ResourceInfo_17();
                        try {
                            mutualmark_resourceinfo_17.mergeFrom(mutualmark_mutualmarkinfo.bytes_resource_info.get().toByteArray());
                        } catch (Throwable th5) {
                            QLog.i("MutualMarkInfo", 1, "ResourceInfo_17 parseFrom error:" + th5.getMessage());
                            mutualmark_resourceinfo_17 = null;
                        }
                        c(bVar, mutualmark_resourceinfo_17);
                    }
                    if (mutualmark_mutualmarkinfo.bytes_grade_resource_info.has()) {
                        mutualmark$ResourceInfo mutualmark_resourceinfo2 = new mutualmark$ResourceInfo();
                        try {
                            mutualmark_resourceinfo2.mergeFrom(mutualmark_mutualmarkinfo.bytes_grade_resource_info.get().toByteArray());
                            mutualmark_resourceinfo = mutualmark_resourceinfo2;
                        } catch (Throwable th6) {
                            QLog.i("MutualMarkInfo", 1, "ResourceInfo parseFrom error:" + th6.getMessage());
                        }
                        b(bVar, mutualmark_resourceinfo);
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("MutualMarkInfo", 1, "parseFrom retInfo:" + bVar);
                    }
                    return bVar;
                } catch (Throwable th7) {
                    QLog.i("MutualMarkInfo", 1, "MutualMarkPushInfo parseFrom error:" + th7.getMessage());
                    return null;
                }
            }

            private static void b(b bVar, mutualmark$ResourceInfo mutualmark_resourceinfo) {
                if (mutualmark_resourceinfo != null) {
                    if (mutualmark_resourceinfo.bytes_static_url.has()) {
                        String stringUtf8 = mutualmark_resourceinfo.bytes_static_url.get().toStringUtf8();
                        bVar.f180277m = stringUtf8;
                        bVar.f180277m = com.tencent.mobileqq.mutualmark.g.b(stringUtf8);
                    }
                    if (mutualmark_resourceinfo.bytes_dynamic_url.has()) {
                        String stringUtf82 = mutualmark_resourceinfo.bytes_dynamic_url.get().toStringUtf8();
                        bVar.f180278n = stringUtf82;
                        bVar.f180278n = com.tencent.mobileqq.mutualmark.g.b(stringUtf82);
                    }
                    if (mutualmark_resourceinfo.bytes_cartoon_url.has()) {
                        String stringUtf83 = mutualmark_resourceinfo.bytes_cartoon_url.get().toStringUtf8();
                        bVar.f180279o = stringUtf83;
                        bVar.f180279o = com.tencent.mobileqq.mutualmark.g.b(stringUtf83);
                    }
                    if (mutualmark_resourceinfo.bytes_cartoon_md5.has()) {
                        bVar.f180280p = mutualmark_resourceinfo.bytes_cartoon_md5.get().toStringUtf8();
                    }
                    if (mutualmark_resourceinfo.bytes_word.has()) {
                        bVar.f180281q = mutualmark_resourceinfo.bytes_word.get().toStringUtf8();
                    }
                    if (mutualmark_resourceinfo.uint32_play_cartoon.has()) {
                        boolean z16 = true;
                        if (mutualmark_resourceinfo.uint32_play_cartoon.get() != 1) {
                            z16 = false;
                        }
                        bVar.f180283s = z16;
                    }
                }
            }

            private static void c(b bVar, mutualmark$ResourceInfo_17 mutualmark_resourceinfo_17) {
                if (mutualmark_resourceinfo_17 != null) {
                    if (mutualmark_resourceinfo_17.bytes_static_url.has()) {
                        String stringUtf8 = mutualmark_resourceinfo_17.bytes_static_url.get().toStringUtf8();
                        bVar.f180277m = stringUtf8;
                        bVar.f180277m = com.tencent.mobileqq.mutualmark.g.b(stringUtf8);
                    }
                    if (mutualmark_resourceinfo_17.bytes_dynamic_url.has()) {
                        String stringUtf82 = mutualmark_resourceinfo_17.bytes_dynamic_url.get().toStringUtf8();
                        bVar.f180278n = stringUtf82;
                        bVar.f180278n = com.tencent.mobileqq.mutualmark.g.b(stringUtf82);
                    }
                    if (mutualmark_resourceinfo_17.bytes_cartoon_url.has()) {
                        String stringUtf83 = mutualmark_resourceinfo_17.bytes_cartoon_url.get().toStringUtf8();
                        bVar.f180279o = stringUtf83;
                        bVar.f180279o = com.tencent.mobileqq.mutualmark.g.b(stringUtf83);
                    }
                    if (mutualmark_resourceinfo_17.bytes_cartoon_md5.has()) {
                        bVar.f180280p = mutualmark_resourceinfo_17.bytes_cartoon_md5.get().toStringUtf8();
                    }
                    if (mutualmark_resourceinfo_17.bytes_word.has()) {
                        bVar.f180281q = mutualmark_resourceinfo_17.bytes_word.get().toStringUtf8();
                    }
                    if (mutualmark_resourceinfo_17.uint32_play_cartoon.has()) {
                        boolean z16 = true;
                        if (mutualmark_resourceinfo_17.uint32_play_cartoon.get() != 1) {
                            z16 = false;
                        }
                        bVar.f180283s = z16;
                    }
                }
            }

            @NonNull
            public String toString() {
                return "ExtSnsMutualMarkPushInfo{relation_type:" + this.f180265a + ", relation_level:" + this.f180266b + ", last_action_time:" + this.f180267c + ", last_change_time:" + this.f180268d + ", continue_days:" + this.f180269e + ", notify_time:" + this.f180272h + ", icon_status:" + this.f180273i + ", icon_status_end_time:" + this.f180274j + ", sub_level:" + this.f180275k + ", grayTipType:" + this.f180276l + ", gray_tip_duplicate_key:" + this.f180271g + ", icon_static_url:" + this.f180277m + ", icon_dynamic_url:" + this.f180278n + ", icon_cartoon_url:" + this.f180279o + ", icon_cartoon_md5:" + this.f180280p + ", icon_name:" + this.f180281q + ", user_close_flag:" + this.f180282r + ", play_cartoon:" + this.f180283s + ", mark_version:" + this.f180284t + ", is_wearing:" + this.f180285u + ", }";
            }
        }

        public static c c(submsgtype0xc7$RelationalChainInfo submsgtype0xc7_relationalchaininfo) {
            if (submsgtype0xc7_relationalchaininfo != null) {
                c cVar = new c();
                cVar.f180260a = submsgtype0xc7_relationalchaininfo.uint64_type.get();
                if (submsgtype0xc7_relationalchaininfo.bytes_attr.has()) {
                    cVar.f180261b = b.a(cVar.f180260a, submsgtype0xc7_relationalchaininfo.bytes_attr.get().toByteArray());
                }
                if (submsgtype0xc7_relationalchaininfo.bytes_intimate_info.has()) {
                    cVar.f180262c = a.a(submsgtype0xc7_relationalchaininfo.bytes_intimate_info.get().toByteArray());
                }
                if (submsgtype0xc7_relationalchaininfo.bytes_mutualmark_alienation.has()) {
                    cVar.f180263d = submsgtype0xc7_relationalchaininfo.bytes_mutualmark_alienation.get().toByteArray();
                }
                return cVar;
            }
            return null;
        }

        public int a() {
            b bVar = this.f180261b;
            if (bVar != null) {
                return (int) bVar.f180266b;
            }
            if (this.f180262c != null && com.tencent.mobileqq.activity.aio.intimate.e.e(this.f180260a)) {
                return this.f180262c.f180264a;
            }
            return 0;
        }

        public int b() {
            b bVar = this.f180261b;
            if (bVar != null) {
                return (int) bVar.f180275k;
            }
            return 0;
        }

        @NonNull
        public String toString() {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("ExtSnsRelationalChainPushInfo{");
            sb5.append("relation_type:");
            sb5.append(this.f180260a);
            sb5.append(", ");
            sb5.append("mutualMarkInfo:");
            sb5.append(this.f180261b);
            sb5.append(", ");
            sb5.append("intimateInfo:");
            sb5.append(this.f180262c);
            sb5.append(", ");
            sb5.append("relationIconFlag:");
            byte[] bArr = this.f180263d;
            if (bArr != null && bArr.length > 0) {
                int i3 = 0;
                while (true) {
                    byte[] bArr2 = this.f180263d;
                    if (i3 >= bArr2.length || i3 >= 10) {
                        break;
                    }
                    sb5.append((int) bArr2[i3]);
                    sb5.append(" ");
                    i3++;
                }
            }
            sb5.append(", ");
            sb5.append("}");
            return sb5.toString();
        }
    }

    public static x j(submsgtype0xc7$RelationalChainChange submsgtype0xc7_relationalchainchange, boolean z16) {
        x xVar = new x();
        xVar.f180250d = z16;
        xVar.f180247a = String.valueOf(submsgtype0xc7_relationalchainchange.uint64_src_uin.get());
        xVar.f180248b = String.valueOf(submsgtype0xc7_relationalchainchange.uint64_dst_uin.get());
        xVar.f180249c = submsgtype0xc7_relationalchainchange.uint32_change_type.get();
        if (submsgtype0xc7_relationalchainchange.msg_relational_chain_info_old.has()) {
            xVar.f180251e = c.c(submsgtype0xc7_relationalchainchange.msg_relational_chain_info_old.get());
        }
        if (submsgtype0xc7_relationalchainchange.msg_relational_chain_info_new.has()) {
            xVar.f180252f = c.c(submsgtype0xc7_relationalchainchange.msg_relational_chain_info_new.get());
        }
        if (submsgtype0xc7_relationalchainchange.rpt_relational_chain_infos.has() && submsgtype0xc7_relationalchainchange.rpt_relational_chain_infos.size() > 0) {
            xVar.f180253g = new ArrayList<>();
            for (int i3 = 0; i3 < submsgtype0xc7_relationalchainchange.rpt_relational_chain_infos.size(); i3++) {
                a aVar = new a();
                if (submsgtype0xc7_relationalchainchange.rpt_relational_chain_infos.get(i3) != null && submsgtype0xc7_relationalchainchange.rpt_relational_chain_infos.get(i3).msg_relational_chain_info_old.has()) {
                    aVar.f180254a = c.c(submsgtype0xc7_relationalchainchange.rpt_relational_chain_infos.get(i3).msg_relational_chain_info_old.get());
                }
                if (submsgtype0xc7_relationalchainchange.rpt_relational_chain_infos.get(i3) != null && submsgtype0xc7_relationalchainchange.rpt_relational_chain_infos.get(i3).msg_relational_chain_info_new.has()) {
                    aVar.f180255b = c.c(submsgtype0xc7_relationalchainchange.rpt_relational_chain_infos.get(i3).msg_relational_chain_info_new.get());
                }
                xVar.f180253g.add(aVar);
            }
        }
        return xVar;
    }

    private boolean k() {
        c.b bVar;
        if (!((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).isElegantVersion() || !com.tencent.relation.common.config.toggle.c.f364711x.g(false)) {
            return false;
        }
        c cVar = this.f180251e;
        if (cVar != null && (bVar = cVar.f180261b) != null && !TextUtils.isEmpty(bVar.f180270f)) {
            return false;
        }
        return true;
    }

    public String a() {
        c.b bVar;
        c cVar = this.f180252f;
        if (cVar != null && (bVar = cVar.f180261b) != null) {
            return bVar.f180280p;
        }
        return null;
    }

    public String b() {
        c.b bVar;
        c cVar = this.f180252f;
        if (cVar != null && (bVar = cVar.f180261b) != null) {
            return bVar.f180279o;
        }
        return null;
    }

    public String c() {
        c.b bVar;
        c cVar = this.f180252f;
        if (cVar != null && (bVar = cVar.f180261b) != null) {
            return bVar.f180277m;
        }
        return null;
    }

    public b d() {
        b bVar;
        if (this.f180249c == 2 && !k()) {
            c cVar = this.f180251e;
            if (cVar != null && cVar.f180261b != null) {
                bVar = new b();
                c.b bVar2 = this.f180251e.f180261b;
                bVar.f180256a = bVar2.f180270f;
                bVar.f180257b = bVar2.f180272h;
                bVar.f180258c = bVar2.f180271g;
                bVar.f180259d = bVar2.f180276l;
            }
            bVar = null;
        } else {
            c cVar2 = this.f180252f;
            if (cVar2 != null && cVar2.f180261b != null) {
                bVar = new b();
                c.b bVar3 = this.f180252f.f180261b;
                bVar.f180256a = bVar3.f180270f;
                bVar.f180257b = bVar3.f180272h;
                bVar.f180258c = bVar3.f180271g;
                bVar.f180259d = bVar3.f180276l;
            }
            bVar = null;
        }
        long f16 = f();
        long e16 = e();
        if (f16 == 21 && bVar != null && e16 == 1) {
            bVar.f180259d = 1;
        }
        return bVar;
    }

    public int e() {
        if (this.f180249c == 2) {
            c cVar = this.f180251e;
            if (cVar != null) {
                return cVar.a();
            }
            return 0;
        }
        c cVar2 = this.f180252f;
        if (cVar2 != null) {
            return cVar2.a();
        }
        return 0;
    }

    public int f() {
        if (this.f180249c == 2) {
            c cVar = this.f180251e;
            if (cVar != null) {
                return cVar.f180260a;
            }
            return 0;
        }
        c cVar2 = this.f180252f;
        if (cVar2 != null) {
            return cVar2.f180260a;
        }
        return 0;
    }

    public int g() {
        if (this.f180249c == 2) {
            c cVar = this.f180251e;
            if (cVar != null) {
                return cVar.b();
            }
            return 0;
        }
        c cVar2 = this.f180252f;
        if (cVar2 != null) {
            return cVar2.b();
        }
        return 0;
    }

    public boolean h() {
        c.b bVar;
        c cVar = this.f180252f;
        if (cVar == null || (bVar = cVar.f180261b) == null || !bVar.f180283s || TextUtils.isEmpty(bVar.f180279o) || TextUtils.isEmpty(this.f180252f.f180261b.f180280p)) {
            return false;
        }
        return true;
    }

    public boolean i() {
        c.b bVar;
        c cVar = this.f180252f;
        if (cVar != null && (bVar = cVar.f180261b) != null) {
            return !TextUtils.isEmpty(bVar.f180277m);
        }
        return false;
    }

    @NonNull
    public String toString() {
        return "ExtSnsRelationChainChangePushInfo{selfUin:" + this.f180247a + ", friendUin:" + this.f180248b + ", changeType:" + this.f180249c + ", old:" + this.f180251e + ", now:" + this.f180252f + ", }";
    }
}
