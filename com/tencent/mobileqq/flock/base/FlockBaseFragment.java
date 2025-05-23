package com.tencent.mobileqq.flock.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.part.ImmersivePartFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.IPermissionRequester;
import mqq.app.QQPermissionCallback;
import mqq.app.QQPermissionHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 /2\u00020\u00012\u00020\u0002:\u00010B\u0007\u00a2\u0006\u0004\b-\u0010.J\b\u0010\u0004\u001a\u00020\u0003H&J$\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006`\u0007H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0014J\b\u0010\u000b\u001a\u00020\nH\u0014J\b\u0010\r\u001a\u00020\fH\u0014J&\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0018\u001a\u00020\fH\u0014J\b\u0010\u0019\u001a\u00020\u0016H\u0004J7\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\n2\u0016\u0010\u001d\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u001c\"\u0004\u0018\u00010\u0003H\u0016\u00a2\u0006\u0004\b\u001e\u0010\u001fJ/\u0010\"\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\n2\u000e\u0010\u001d\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u001c2\u0006\u0010!\u001a\u00020 H\u0016\u00a2\u0006\u0004\b\"\u0010#R\u0018\u0010&\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R0\u0010,\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00060(j\b\u0012\u0004\u0012\u00020\u0006`)0'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/flock/base/FlockBaseFragment;", "Lcom/tencent/biz/richframework/part/ImmersivePartFragment;", "Lmqq/app/IPermissionRequester;", "", "getPageId", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "ph", "getLogTag", "", "getStatusBarColor", "", "isUseDarkTextStatusBar", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "", "onResume", "qh", "registerDaTongReportPageId", "caller", "requestCode", "", "permissions", "requestPermissions", "(Ljava/lang/Object;I[Ljava/lang/String;)V", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "contentView", "", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "D", "Ljava/util/Map;", "permissionCallerMap", "<init>", "()V", "E", "a", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public abstract class FlockBaseFragment extends ImmersivePartFragment implements IPermissionRequester {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private View contentView;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Map<Integer, ArrayList<Object>> permissionCallerMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/flock/base/FlockBaseFragment$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.flock.base.FlockBaseFragment$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23793);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public FlockBaseFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.permissionCallerMap = new LinkedHashMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "FlockBaseFragment";
    }

    @NotNull
    public abstract String getPageId();

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean isUseDarkTextStatusBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return !QQTheme.isNowThemeIsNight();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View onCreateView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            onCreateView = (View) iPatchRedirector.redirect((short) 6, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            onCreateView = super.onCreateView(inflater, container, savedInstanceState);
            this.contentView = onCreateView;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int requestCode, @NotNull String[] permissions, @NotNull int[] grantResults) {
        boolean z16;
        ArrayList<Object> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(requestCode), permissions, grantResults);
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

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onResume();
        if (!qh()) {
            registerDaTongReportPageId();
        }
    }

    @NotNull
    public HashMap<String, Object> ph() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (HashMap) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new HashMap<>();
    }

    protected boolean qh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void registerDaTongReportPageId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            if (this.contentView == null) {
                QLog.w("FlockBaseFragment", 1, "registerDaTongReportPageId, contentView is null ");
                return;
            }
            VideoReport.addToDetectionWhitelist(getActivity());
            VideoReport.setPageId(this.contentView, getPageId());
            VideoReport.setPageParams(this.contentView, com.tencent.mobileqq.flock.datong.a.f210009a.b(ph()));
        }
    }

    @Override // mqq.app.IPermissionRequester
    public void requestPermissions(@NotNull Object caller, int requestCode, @NotNull String... permissions) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, caller, Integer.valueOf(requestCode), permissions);
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
