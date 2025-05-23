package cs1;

import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.GuildMainFrameConstants;
import com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.GuildLeftBarRepo;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes14.dex */
public class c extends b {
    public JumpGuildParam E;
    public String F;

    @Override // cs1.b
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c) || !super.equals(obj)) {
            return false;
        }
        c cVar = (c) obj;
        if (Objects.equals(this.E, cVar.E) && Objects.equals(this.F, cVar.F)) {
            return true;
        }
        return false;
    }

    @Override // cs1.b
    public int f() {
        return GuildMainFrameConstants.f227269m;
    }

    @Override // cs1.b
    public int hashCode() {
        return Objects.hash(Integer.valueOf(super.hashCode()), this.E, this.F);
    }

    @Override // cs1.b
    public String i() {
        return GuildLeftBarRepo.t(this.f391795d, "");
    }

    @Override // cs1.b
    public String toString() {
        return "GuildLeftBarJoinUIData{guildName='" + this.F + "', headAvatarUrl='" + this.C + "'joinGuildParam=" + this.E + '}' + super.toString();
    }
}
