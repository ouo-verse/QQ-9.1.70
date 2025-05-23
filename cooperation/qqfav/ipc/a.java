package cooperation.qqfav.ipc;

import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a extends RemoteCommand {

    /* renamed from: a, reason: collision with root package name */
    private SparseArray<List<InterfaceC10113a>> f390653a;

    /* compiled from: P */
    /* renamed from: cooperation.qqfav.ipc.a$a, reason: collision with other inner class name */
    /* loaded from: classes28.dex */
    public interface InterfaceC10113a {
        boolean a(int i3, Bundle bundle);
    }

    public a(AppRuntime appRuntime) {
        super("com.tencent.qqfav.favoritesremotecommand");
        this.f390653a = new SparseArray<>();
        a(0, new b());
    }

    public boolean a(int i3, InterfaceC10113a interfaceC10113a) {
        List<InterfaceC10113a> list = this.f390653a.get(i3);
        if (list == null) {
            list = new ArrayList<>();
            this.f390653a.put(i3, list);
        }
        if (!list.contains(interfaceC10113a)) {
            return list.add(interfaceC10113a);
        }
        return false;
    }

    public boolean b(int i3, InterfaceC10113a interfaceC10113a) {
        List<InterfaceC10113a> list = this.f390653a.get(i3);
        if (list != null && list.contains(interfaceC10113a)) {
            return list.remove(interfaceC10113a);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand
    public Bundle invoke(Bundle bundle, RemoteCommand.OnInvokeFinishLinstener onInvokeFinishLinstener) {
        int i3 = bundle.getInt("com.tencent.qqfav.favoritesremotecommand.id", -1);
        if (-1 != i3) {
            if (QLog.isDevelopLevel()) {
                QLog.i("FavoritesRemoteCommand", 4, "invoke: dataInvoke=" + bundle.toString());
            }
            List<InterfaceC10113a> list = this.f390653a.get(i3);
            if (list != null) {
                Iterator<InterfaceC10113a> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next().a(i3, bundle)) {
                        return bundle;
                    }
                }
            }
            List<InterfaceC10113a> list2 = this.f390653a.get(0);
            if (list2 != null) {
                Iterator<InterfaceC10113a> it5 = list2.iterator();
                while (it5.hasNext() && !it5.next().a(i3, bundle)) {
                }
            }
        }
        return bundle;
    }
}
