package ng1;

import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.base.extension.d;
import com.tencent.mobileqq.guild.client.GuildClientParams;
import com.tencent.mobileqq.guild.client.selectaccount.GuildClientSelectZoneDialogFragment;
import com.tencent.mobileqq.guild.safety.j;
import com.tencent.mobileqq.qqguildsdk.data.db;
import com.tencent.mobileqq.qqguildsdk.data.dc;
import com.tencent.mobileqq.qqguildsdk.data.dd;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u001a\u0016\u0010\r\u001a\u00020\f2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/data/dd;", "area0List", "Lcom/tencent/mobileqq/guild/client/GuildClientParams;", "params", "", "Lcom/tencent/mobileqq/qqguildsdk/data/dc;", "areaLevelList", "", "b", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqguildsdk/data/db;", "areas", "", "a", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class b {
    @NotNull
    public static final String a(@Nullable ArrayList<db> arrayList) {
        String str = "";
        if (arrayList != null) {
            for (db dbVar : arrayList) {
                str = ((Object) str) + "{ " + dbVar.getDesc() + ":" + dbVar.getId() + " }";
            }
        }
        return str;
    }

    public static final void b(@NotNull dd area0List, @NotNull GuildClientParams params, @NotNull List<? extends dc> areaLevelList) {
        Integer num;
        Intrinsics.checkNotNullParameter(area0List, "area0List");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(areaLevelList, "areaLevelList");
        ArrayList<db> a16 = area0List.a();
        if (a16 != null) {
            num = Integer.valueOf(a16.size());
        } else {
            num = null;
        }
        j.d("GuildClientSelectUtil", "area0List | size - " + num + "  element - " + a(area0List.a()));
        GuildClientSelectZoneDialogFragment guildClientSelectZoneDialogFragment = new GuildClientSelectZoneDialogFragment(area0List, params, areaLevelList);
        FragmentManager supportFragmentManager = QBaseActivity.sTopActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "sTopActivity.supportFragmentManager");
        d.a(guildClientSelectZoneDialogFragment, supportFragmentManager, "GuildClientSelectZoneDialogFragment");
    }
}
