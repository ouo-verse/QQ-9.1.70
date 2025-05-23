package com.tencent.mobileqq.flock.base;

import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.richframework.gallery.QQLayerFragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.QQPermissionCallback;
import mqq.app.QQPermissionHelper;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J7\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\u0016\u0010\r\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\f0\u000b\"\u0004\u0018\u00010\fH\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0010J/\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00062\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016\u00a2\u0006\u0004\b\u0013\u0010\u0014R0\u0010\u001a\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\u0016j\b\u0012\u0004\u0012\u00020\b`\u00170\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/flock/base/FlockLayerBaseFragment;", "Lcom/tencent/richframework/gallery/QQLayerFragment;", "Lmqq/app/IPermissionRequester;", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "getPlayScene", "", "caller", "requestCode", "", "", "permissions", "", "requestPermissions", "(Ljava/lang/Object;I[Ljava/lang/String;)V", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/Map;", "permissionCallerMap", "<init>", "()V", "D", "a", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public abstract class FlockLayerBaseFragment extends QQLayerFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Map<Integer, ArrayList<Object>> permissionCallerMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/flock/base/FlockLayerBaseFragment$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.flock.base.FlockLayerBaseFragment$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24417);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public FlockLayerBaseFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.permissionCallerMap = new LinkedHashMap();
        }
    }

    @Override // com.tencent.richframework.gallery.QQLayerFragment, com.tencent.richframework.gallery.RFWLayerFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(super.assembleParts());
        arrayList.add(0, new com.tencent.mobileqq.flock.layer.part.a());
        arrayList.add(new com.tencent.mobileqq.flock.layer.part.e());
        return arrayList;
    }

    @Override // com.tencent.richframework.gallery.QQLayerFragment
    public int getPlayScene() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 147;
    }

    @Override // com.tencent.richframework.gallery.QQLayerFragment, androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int requestCode, @NotNull String[] permissions, @NotNull int[] grantResults) {
        boolean z16;
        ArrayList<Object> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(requestCode), permissions, grantResults);
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

    @Override // com.tencent.richframework.gallery.QQLayerFragment, mqq.app.IPermissionRequester
    public void requestPermissions(@NotNull Object caller, int requestCode, @NotNull String... permissions) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, caller, Integer.valueOf(requestCode), permissions);
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
