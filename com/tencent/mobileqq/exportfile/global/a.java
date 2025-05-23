package com.tencent.mobileqq.exportfile.global;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.kernel.nativeinterface.FileBridgeDirectoryType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/FileBridgeDirectoryType;", "", "a", "wifiphoto_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.exportfile.global.a$a, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public /* synthetic */ class C7515a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f205535a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24681);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[FileBridgeDirectoryType.values().length];
            try {
                iArr[FileBridgeDirectoryType.KDISK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FileBridgeDirectoryType.KMUSIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FileBridgeDirectoryType.KMOVIES.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FileBridgeDirectoryType.KDESKTOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[FileBridgeDirectoryType.KRECENT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[FileBridgeDirectoryType.KDOWNLOADS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[FileBridgeDirectoryType.KPICTURES.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[FileBridgeDirectoryType.KAPPLICATIONS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[FileBridgeDirectoryType.KHOME.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[FileBridgeDirectoryType.KDOCUMENTS.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            f205535a = iArr;
        }
    }

    public static final int a(@NotNull FileBridgeDirectoryType fileBridgeDirectoryType) {
        Intrinsics.checkNotNullParameter(fileBridgeDirectoryType, "<this>");
        switch (C7515a.f205535a[fileBridgeDirectoryType.ordinal()]) {
            case 1:
                return R.drawable.filelook_disk;
            case 2:
                return R.drawable.filelook_audio;
            case 3:
                return R.drawable.filelook_video_blue;
            case 4:
                return R.drawable.filelook_desktop;
            case 5:
                return R.drawable.filelook_recent;
            case 6:
                return R.drawable.filelook_download;
            case 7:
                return R.drawable.filelook_image;
            case 8:
                return R.drawable.filelook_application;
            case 9:
                return R.drawable.filelook_home;
            case 10:
                return R.drawable.filelook_manuscript;
            default:
                return R.drawable.filelook_floder;
        }
    }
}
