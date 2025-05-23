package cooperation.qqindividuality.ipc;

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
public class b extends RemoteCommand {

    /* renamed from: a, reason: collision with root package name */
    private SparseArray<List<a>> f390760a;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface a {
        boolean a(int i3, Bundle bundle);
    }

    public b(AppRuntime appRuntime) {
        super("com.tencent.individuality.individualityremotecommand");
        this.f390760a = new SparseArray<>();
        a(0, new c());
    }

    public boolean a(int i3, a aVar) {
        List<a> list = this.f390760a.get(i3);
        if (list == null) {
            list = new ArrayList<>();
            this.f390760a.put(i3, list);
        }
        if (!list.contains(aVar)) {
            return list.add(aVar);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand
    public Bundle invoke(Bundle bundle, RemoteCommand.OnInvokeFinishLinstener onInvokeFinishLinstener) {
        int i3 = bundle.getInt("com.tencent.individuality.individualityremotecommand.id", -1);
        if (-1 != i3) {
            if (QLog.isDevelopLevel()) {
                QLog.i("IndividualityRemoteCommand", 4, "invoke: dataInvoke=" + bundle.toString());
            }
            List<a> list = this.f390760a.get(i3);
            if (list != null) {
                Iterator<a> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next().a(i3, bundle)) {
                        return bundle;
                    }
                }
            }
            List<a> list2 = this.f390760a.get(0);
            if (list2 != null) {
                Iterator<a> it5 = list2.iterator();
                while (it5.hasNext() && !it5.next().a(i3, bundle)) {
                }
            }
        }
        return bundle;
    }
}
