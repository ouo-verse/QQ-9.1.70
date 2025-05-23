package co0;

import com.tencent.guild.aio.halfpop.c;
import com.tencent.guild.aio.halfpop.menu.n;
import com.tencent.guild.api.appsetting.IAppSetting;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJJ\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00040\u00022\u001c\u0010\u0005\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00040\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t\u00a8\u0006\u000e"}, d2 = {"Lco0/b;", "", "", "Ljava/lang/Class;", "Lcom/tencent/guild/aio/halfpop/menu/n;", "itemClsLi", "data", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "addDebug", "a", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a */
    @NotNull
    public static final b f31162a = new b();

    b() {
    }

    public static /* synthetic */ List b(b bVar, List list, Object obj, com.tencent.aio.api.runtime.a aVar, boolean z16, int i3, Object obj2) {
        if ((i3 & 8) != 0) {
            z16 = true;
        }
        return bVar.a(list, obj, aVar, z16);
    }

    @NotNull
    public final List<n<Object>> a(@NotNull List<? extends Class<? extends n<? extends Object>>> itemClsLi, @NotNull Object data, @NotNull com.tencent.aio.api.runtime.a aioContext, boolean addDebug) {
        Intrinsics.checkNotNullParameter(itemClsLi, "itemClsLi");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = itemClsLi.iterator();
        while (it.hasNext()) {
            Object newInstance = ((Class) it.next()).newInstance();
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.tencent.guild.aio.halfpop.menu.IMenuItem<kotlin.Any>");
            n nVar = (n) newInstance;
            nVar.e(data, aioContext);
            if (nVar.a(data)) {
                arrayList.add(nVar);
            }
        }
        if (addDebug && !((IAppSetting) QRoute.api(IAppSetting.class)).mo112public() && (data instanceof GuildMsgItem)) {
            Iterator<T> it5 = c.f110667a.a().iterator();
            while (it5.hasNext()) {
                Object newInstance2 = ((Class) it5.next()).newInstance();
                Intrinsics.checkNotNull(newInstance2, "null cannot be cast to non-null type com.tencent.guild.aio.halfpop.menu.IMenuItem<kotlin.Any>");
                n nVar2 = (n) newInstance2;
                nVar2.e(data, aioContext);
                if (nVar2.a(data)) {
                    arrayList.add(nVar2);
                }
            }
        }
        return arrayList;
    }
}
