package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.qqmini.sdk.launcher.core.proxy.Permissions;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/qqmini/sdk/launcher/core/proxy/Permissions;", "", "b", "qqmini_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class av {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f347835a;

        static {
            int[] iArr = new int[Permissions.values().length];
            try {
                iArr[Permissions.WRITE_EXTERNAL_STORAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Permissions.ACCESS_FINE_LOCATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Permissions.ACCESS_COARSE_LOCATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Permissions.READ_EXTERNAL_STORAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Permissions.CAMERA.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Permissions.RECORD_AUDIO.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f347835a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String b(Permissions permissions) {
        switch (a.f347835a[permissions.ordinal()]) {
            case 1:
                return QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE;
            case 2:
                return "android.permission.ACCESS_FINE_LOCATION";
            case 3:
                return "android.permission.ACCESS_COARSE_LOCATION";
            case 4:
                return QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE;
            case 5:
                return QQPermissionConstants.Permission.CAMERA;
            case 6:
                return QQPermissionConstants.Permission.RECORD_AUDIO;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
