package com.tencent.mobileqq.guild.inbox.startpanel;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService;
import com.tencent.mobileqq.guild.summary.GuildSummaryUIData;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes13.dex */
public class p implements Cloneable {
    public GuildSummaryUIData D;
    public int G;
    public boolean H;
    public boolean I;

    /* renamed from: d, reason: collision with root package name */
    public int f226295d;

    /* renamed from: m, reason: collision with root package name */
    public long f226300m;

    /* renamed from: e, reason: collision with root package name */
    public String f226296e = "";

    /* renamed from: f, reason: collision with root package name */
    public String f226297f = "";

    /* renamed from: h, reason: collision with root package name */
    public String f226298h = "";

    /* renamed from: i, reason: collision with root package name */
    public String f226299i = "";
    public IGuildUnreadCntService.b C = new IGuildUnreadCntService.b();
    public boolean E = false;
    public String F = "";

    private p b(boolean z16) {
        try {
            p pVar = (p) clone();
            pVar.E = z16;
            return pVar;
        } catch (CloneNotSupportedException e16) {
            throw new IllegalStateException("Expect newUiDataWithSelect() won't reach here!", e16);
        }
    }

    public static p c(@NonNull List<p> list) {
        if (list.isEmpty()) {
            return null;
        }
        Iterator<p> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().E) {
                return null;
            }
        }
        for (p pVar : list) {
            if (pVar.f226295d == 0) {
                return pVar;
            }
        }
        return list.get(0);
    }

    public p a(String str) {
        boolean equals = TextUtils.equals(this.f226296e, str);
        if (this.E != equals) {
            return b(equals);
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        p pVar = (p) obj;
        if (this.f226295d == pVar.f226295d && this.f226300m == pVar.f226300m && this.E == pVar.E && Objects.equals(this.f226296e, pVar.f226296e) && Objects.equals(this.f226297f, pVar.f226297f) && Objects.equals(this.f226298h, pVar.f226298h) && Objects.equals(this.f226299i, pVar.f226299i) && Objects.equals(this.C, pVar.C) && Objects.equals(this.D, pVar.D) && Objects.equals(this.F, pVar.F) && Objects.equals(Integer.valueOf(this.G), Integer.valueOf(pVar.G)) && Objects.equals(Integer.valueOf(this.C.f230841e), Integer.valueOf(pVar.C.f230841e))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.f226295d), this.f226296e, this.f226297f, this.f226298h, this.f226299i, Long.valueOf(this.f226300m), this.C, this.D, Boolean.valueOf(this.E), this.F, Integer.valueOf(this.G));
    }

    public String toString() {
        return "InboxNodeUIData{inboxType=" + this.f226295d + ", inboxKey='" + this.f226296e + "', channelId='" + this.f226297f + "', tinyId='" + this.f226298h + "', nickName='" + this.f226299i + "', lastMsgTime=" + this.f226300m + ", cntInfo=" + this.C + ", isSelect=" + this.E + ", srcGuildId=" + this.F + ", memberType=" + this.G + ", summaryUIData=" + this.D + '}';
    }
}
