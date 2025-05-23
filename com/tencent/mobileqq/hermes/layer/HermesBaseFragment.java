package com.tencent.mobileqq.hermes.layer;

import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.richframework.gallery.RFWLayerFragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.IPermissionRequester;
import mqq.app.QQPermissionCallback;
import mqq.app.QQPermissionHelper;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J7\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0016\u0010\t\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b0\u0007\"\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\u000b\u0010\fJ/\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0010R0\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0012j\b\u0012\u0004\u0012\u00020\u0003`\u00130\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/hermes/layer/HermesBaseFragment;", "Lcom/tencent/richframework/gallery/RFWLayerFragment;", "Lmqq/app/IPermissionRequester;", "", "caller", "", "requestCode", "", "", "permissions", "", "requestPermissions", "(Ljava/lang/Object;I[Ljava/lang/String;)V", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/Map;", "permissionCallerMap", "<init>", "()V", "hermes-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public class HermesBaseFragment extends RFWLayerFragment implements IPermissionRequester {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Map<Integer, ArrayList<Object>> permissionCallerMap;

    public HermesBaseFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.permissionCallerMap = new LinkedHashMap();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int requestCode, @NotNull String[] permissions, @NotNull int[] grantResults) {
        boolean z16;
        ArrayList<Object> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(requestCode), permissions, grantResults);
            return;
        }
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && (arrayList = this.permissionCallerMap.get(Integer.valueOf(requestCode))) != null) {
            for (Object obj : arrayList) {
                if (obj instanceof QQPermissionCallback) {
                    ArrayList arrayList2 = new ArrayList();
                    int length = grantResults.length;
                    int i3 = 0;
                    int i16 = 0;
                    while (i3 < length) {
                        int i17 = i16 + 1;
                        if (grantResults[i3] != 0) {
                            arrayList2.add(permissions[i16]);
                        }
                        i3++;
                        i16 = i17;
                    }
                    if (!arrayList2.isEmpty()) {
                        ((QQPermissionCallback) obj).deny(requestCode, permissions, grantResults);
                    } else {
                        ((QQPermissionCallback) obj).grant(requestCode, permissions, grantResults);
                    }
                } else {
                    QQPermissionHelper.requestResult(obj, requestCode, permissions, grantResults);
                }
            }
            this.permissionCallerMap.remove(Integer.valueOf(requestCode));
        }
    }

    @Override // mqq.app.IPermissionRequester
    public void requestPermissions(@NotNull Object caller, int requestCode, @NotNull String... permissions) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, caller, Integer.valueOf(requestCode), permissions);
            return;
        }
        Intrinsics.checkNotNullParameter(caller, "caller");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        ArrayList arrayList = new ArrayList();
        for (String str : permissions) {
            if (str != null) {
                FragmentActivity activity = getActivity();
                if (activity != null && activity.checkSelfPermission(str) == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    arrayList.add(str);
                }
            }
        }
        if (!arrayList.isEmpty()) {
            ArrayList<Object> arrayList2 = this.permissionCallerMap.get(Integer.valueOf(requestCode));
            if (arrayList2 == null) {
                arrayList2 = new ArrayList<>();
            }
            Iterator<T> it = arrayList2.iterator();
            boolean z17 = false;
            while (it.hasNext()) {
                if (Intrinsics.areEqual(caller, it.next())) {
                    z17 = true;
                }
            }
            if (!z17) {
                arrayList2.add(caller);
                this.permissionCallerMap.put(Integer.valueOf(requestCode), arrayList2);
            }
            Object[] array = arrayList.toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            requestPermissions((String[]) array, requestCode);
            return;
        }
        if (caller instanceof QQPermissionCallback) {
            ((QQPermissionCallback) caller).grant(requestCode, permissions, null);
        } else {
            QQPermissionHelper.doExecuteSuccess(caller, requestCode);
        }
    }
}
