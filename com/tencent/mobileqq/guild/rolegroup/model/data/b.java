package com.tencent.mobileqq.guild.rolegroup.model.data;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.widget.TextAndSwitchButtonBar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import ux1.g;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J(\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\tH\u0007J\u0016\u0010\u000f\u001a\u00020\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\fH\u0002J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u001e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007H\u0002\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/model/data/b;", "", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel;", "roleModel", "", "Lux1/g$b;", "e", "", "roleId", "", "showNewFeedWording", "f", "", "list", "", "g", "b", "a", "c", "viewId", "speakId", "d", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f232672a = new b();

    b() {
    }

    private final List<g.b> a() {
        return d(R.string.f154971g9, R.string.f154931g5);
    }

    private final List<g.b> b() {
        return d(R.string.f154961g8, R.string.f154921g4);
    }

    private final List<g.b> c() {
        return d(R.string.f154981g_, R.string.f154941g6);
    }

    private final List<g.b> d(int viewId, int speakId) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new g.b(HardCodeUtil.qqStr(R.string.f154951g7)));
        arrayList.add(new g.b(HardCodeUtil.qqStr(R.string.f155031ge), HardCodeUtil.qqStr(viewId)));
        arrayList.add(new g.b(HardCodeUtil.qqStr(R.string.f155021gd), HardCodeUtil.qqStr(speakId)));
        return arrayList;
    }

    @JvmStatic
    @NotNull
    public static final List<g.b> e(@NotNull RoleGroupModel roleModel) {
        TextAndSwitchButtonBar.ButtonState buttonState;
        Intrinsics.checkNotNullParameter(roleModel, "roleModel");
        ArrayList arrayList = new ArrayList();
        int size = roleModel.getRolePermission().h().size();
        for (int i3 = 0; i3 < size; i3++) {
            RolePermissionDesc rolePermissionDesc = roleModel.getRolePermission().h().get(i3);
            Intrinsics.checkNotNullExpressionValue(rolePermissionDesc, "roleModel.rolePermission.permissionTypeDescList[i]");
            RolePermissionDesc rolePermissionDesc2 = rolePermissionDesc;
            if (rolePermissionDesc2.e()) {
                if (i3 != roleModel.getRolePermission().h().size() - 1) {
                    arrayList.add(new g.b(rolePermissionDesc2.getTitle()));
                }
            } else {
                String title = rolePermissionDesc2.getTitle();
                String desc = rolePermissionDesc2.getDesc();
                boolean contains = roleModel.getRolePermission().i().contains(Integer.valueOf(rolePermissionDesc2.getPermissionType()));
                boolean contains2 = roleModel.getRolePermission().g().contains(Integer.valueOf(rolePermissionDesc2.getPermissionType()));
                if (rolePermissionDesc2.getPermType() == 1) {
                    buttonState = TextAndSwitchButtonBar.ButtonState.SWITCH_BUTTON;
                } else {
                    buttonState = TextAndSwitchButtonBar.ButtonState.IMAGE_ICON;
                }
                arrayList.add(new g.b(title, desc, contains, contains2, buttonState, rolePermissionDesc2.getPermissionType()));
            }
        }
        f232672a.g(arrayList);
        return arrayList;
    }

    @JvmStatic
    @NotNull
    public static final List<g.b> f(@NotNull RoleGroupModel roleModel, int roleId, boolean showNewFeedWording) {
        TextAndSwitchButtonBar.ButtonState buttonState;
        String replace$default;
        Intrinsics.checkNotNullParameter(roleModel, "roleModel");
        ArrayList<g.b> arrayList = new ArrayList();
        if (roleId != 2) {
            if (roleId != 7) {
                if (roleId != 4) {
                    if (roleId == 5) {
                        arrayList.addAll(f232672a.c());
                    }
                } else {
                    arrayList.addAll(f232672a.b());
                }
            } else {
                arrayList.addAll(f232672a.a());
            }
        } else {
            arrayList.addAll(f232672a.b());
        }
        if (showNewFeedWording && (roleId == 2 || roleId == 4 || roleId == 5)) {
            for (g.b bVar : arrayList) {
                String str = bVar.f440540d;
                if (str != null) {
                    Intrinsics.checkNotNullExpressionValue(str, "it.mSummary");
                    replace$default = StringsKt__StringsJVMKt.replace$default(str, "\u5b50\u9891\u9053", "\u5b50\u9891\u9053/\u7248\u5757", false, 4, (Object) null);
                    bVar.f440540d = replace$default;
                }
            }
        }
        Iterator<RolePermissionDesc> it = roleModel.getRolePermission().h().iterator();
        while (it.hasNext()) {
            RolePermissionDesc next = it.next();
            if (next.e()) {
                arrayList.add(new g.b(next.getTitle()));
            } else {
                String title = next.getTitle();
                String desc = next.getDesc();
                boolean contains = roleModel.getRolePermission().i().contains(Integer.valueOf(next.getPermissionType()));
                boolean contains2 = roleModel.getRolePermission().g().contains(Integer.valueOf(next.getPermissionType()));
                if (next.getPermType() == 1) {
                    buttonState = TextAndSwitchButtonBar.ButtonState.SWITCH_BUTTON;
                } else {
                    buttonState = TextAndSwitchButtonBar.ButtonState.IMAGE_ICON;
                }
                arrayList.add(new g.b(title, desc, contains, contains2, buttonState, next.getPermissionType()));
            }
        }
        f232672a.g(arrayList);
        return arrayList;
    }

    private final void g(List<g.b> list) {
        boolean z16;
        int size = list.size() - 2;
        if (1 <= size) {
            int i3 = 1;
            while (true) {
                g.b bVar = list.get(i3);
                if (list.get(i3).f440537a == 1 && list.get(i3 + 1).f440537a == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                bVar.f440545i = z16;
                if (i3 != size) {
                    i3++;
                } else {
                    return;
                }
            }
        }
    }
}
