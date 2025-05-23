package cs1;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.guild.mainframe.helper.d;
import com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.GuildLeftBarRepo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes14.dex */
public abstract class b implements Cloneable {
    public static Comparator<b> D = new Comparator() { // from class: cs1.a
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int k3;
            k3 = b.k((b) obj, (b) obj2);
            return k3;
        }
    };

    /* renamed from: d, reason: collision with root package name */
    public int f391795d;

    /* renamed from: e, reason: collision with root package name */
    public String f391796e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f391797f;

    /* renamed from: h, reason: collision with root package name */
    public boolean f391798h;

    /* renamed from: m, reason: collision with root package name */
    public int f391800m;

    /* renamed from: i, reason: collision with root package name */
    public Bundle f391799i = new Bundle();
    public String C = "";

    public b(int i3, String str) {
        this.f391795d = i3;
        this.f391796e = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int k(b bVar, b bVar2) {
        if (bVar != null && bVar2 != null) {
            return bVar.l(bVar2);
        }
        return 0;
    }

    public boolean b() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b clone() throws CloneNotSupportedException {
        return (b) super.clone();
    }

    public b d() {
        try {
            return clone();
        } catch (CloneNotSupportedException e16) {
            QLog.w("Guild.MF.Lt.GuildListItemBaseBuilder", 1, "copy", e16);
            return null;
        }
    }

    public List<Integer> e(b bVar) {
        ArrayList arrayList = new ArrayList();
        if (this.f391800m != bVar.f391800m || !TextUtils.equals(this.C, bVar.C)) {
            arrayList.add(1);
        }
        if (this.f391797f != bVar.f391797f || this.f391798h != bVar.f391798h) {
            arrayList.add(3);
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f391795d == bVar.f391795d && this.f391800m == bVar.f391800m && Objects.equals(this.f391796e, bVar.f391796e) && Objects.equals(this.C, bVar.C) && this.f391797f == bVar.f391797f && this.f391798h == bVar.f391798h) {
            return true;
        }
        return false;
    }

    public abstract int f();

    public int h() {
        return this.f391795d;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.f391795d), this.f391796e, Integer.valueOf(this.f391800m), this.C);
    }

    public String i() {
        return GuildLeftBarRepo.t(this.f391795d, this.f391796e);
    }

    public boolean j() {
        return com.tencent.mobileqq.guild.mainframe.helper.d.f().b().equals(new d.a(this.f391795d, this.f391796e));
    }

    public final int l(b bVar) {
        if (bVar == null || f() == bVar.f()) {
            return 0;
        }
        return f() - bVar.f();
    }

    public String toString() {
        return "GuildLeftBarItemBaseUIData{itemType=" + this.f391795d + ", guildId='" + this.f391796e + "', isGuildBanned='" + this.f391797f + "', isGuildOwner='" + this.f391798h + "', extra=" + this.f391799i + ", headDrawableId=" + this.f391800m + ", headAvatarUrl='" + this.C + "'}";
    }

    public void m() {
    }
}
