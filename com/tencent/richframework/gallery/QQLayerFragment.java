package com.tencent.richframework.gallery;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.gyf.immersionbar.BarHide;
import com.gyf.immersionbar.ImmersionBar;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.richframework.part.Part;
import com.tencent.richframework.gallery.part.AccountStatusPart;
import com.tencent.richframework.gallery.part.QQLayerNavigateBarImmersivePart;
import com.tencent.richframework.gallery.part.QQMediaStrategyPart;
import com.tencent.richframework.gallery.part.QQVideoProviderPart;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.IPermissionRequester;
import mqq.app.QQPermissionCallback;
import mqq.app.QQPermissionHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\u0006H&J\b\u0010\u000f\u001a\u00020\u0010H\u0014J-\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00062\u000e\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0016\u00a2\u0006\u0002\u0010\u0019J\u001a\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J5\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00062\u0016\u0010\u0014\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00160\u0015\"\u0004\u0018\u00010\u0016H\u0016\u00a2\u0006\u0002\u0010!R*\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/tencent/richframework/gallery/QQLayerFragment;", "Lcom/tencent/richframework/gallery/RFWLayerFragment;", "Lmqq/app/IPermissionRequester;", "()V", "permissionCallerMap", "", "", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "assembleParts", "", "Lcom/tencent/biz/richframework/part/Part;", "getMediaStrategyPart", "getPlayScene", "isSimplyNavigationBarImmersive", "", "onRequestPermissionsResult", "", "requestCode", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "view", "Landroid/view/View;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "requestPermissions", "caller", "(Ljava/lang/Object;I[Ljava/lang/String;)V", "qq-layer-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public abstract class QQLayerFragment extends RFWLayerFragment implements IPermissionRequester {

    @NotNull
    private final Map<Integer, ArrayList<Object>> permissionCallerMap = new LinkedHashMap();

    @Override // com.tencent.richframework.gallery.RFWLayerFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(super.assembleParts());
        arrayList.add(new QQVideoProviderPart(getPlayScene()));
        arrayList.add(getMediaStrategyPart());
        arrayList.add(new AccountStatusPart());
        if (!isOpenNavigationBarImmersive() && isSimplyNavigationBarImmersive()) {
            arrayList.add(0, new QQLayerNavigateBarImmersivePart());
        }
        return arrayList;
    }

    @NotNull
    public Part getMediaStrategyPart() {
        return new QQMediaStrategyPart();
    }

    public abstract int getPlayScene();

    protected boolean isSimplyNavigationBarImmersive() {
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int requestCode, @NotNull String[] permissions, @NotNull int[] grantResults) {
        boolean z16;
        ArrayList<Object> arrayList;
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

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ImmersionBar.n0(this).E(BarHide.FLAG_HIDE_STATUS_BAR).H();
    }

    public void requestPermissions(@NotNull Object caller, int requestCode, @NotNull String... permissions) {
        Intrinsics.checkNotNullParameter(caller, "caller");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        ArrayList arrayList = new ArrayList();
        int length = permissions.length;
        int i3 = 0;
        while (true) {
            boolean z16 = true;
            if (i3 >= length) {
                break;
            }
            String str = permissions[i3];
            if (str != null) {
                FragmentActivity activity = getActivity();
                if (activity == null || activity.checkSelfPermission(str) != 0) {
                    z16 = false;
                }
                if (!z16) {
                    arrayList.add(str);
                }
            }
            i3++;
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
