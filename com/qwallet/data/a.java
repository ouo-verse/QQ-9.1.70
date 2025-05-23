package com.qwallet.data;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseArray;
import com.qwallet.data.ImageManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletApi;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static String f41551a = "Folder";

    /* renamed from: b, reason: collision with root package name */
    private static SparseArray<ArrayList<a>> f41552b = new SparseArray<>();

    /* compiled from: P */
    /* renamed from: com.qwallet.data.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0305a {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ Context a(a aVar) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ Drawable[] b(a aVar) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ InterfaceC0305a c(a aVar) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ ImageManager.c d(a aVar) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ ImageManager e(a aVar) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ String f(a aVar) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void g(a aVar, Drawable[] drawableArr) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ Drawable h(a aVar, File file) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ Drawable[] i(a aVar, List list, Drawable drawable) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ List j(a aVar, String str) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void k(a aVar, String str, boolean z16) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void l(a aVar, int i3, Drawable drawable) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void m(a aVar, int i3, Drawable[] drawableArr) {
        throw null;
    }

    public static String p(String str, ImageManager imageManager, Context context) {
        String md5Encode = ((IQWalletApi) QRoute.api(IQWalletApi.class)).md5Encode(str);
        if (md5Encode != null && md5Encode.length() > 0) {
            String h16 = imageManager.h(str);
            if (TextUtils.isEmpty(h16)) {
                String qWalletTmpPath = ((IQWalletApi) QRoute.api(IQWalletApi.class)).getQWalletTmpPath();
                if (!TextUtils.isEmpty(qWalletTmpPath)) {
                    if (qWalletTmpPath.charAt(qWalletTmpPath.length() - 1) != '/' && qWalletTmpPath.charAt(qWalletTmpPath.length() - 1) != '\\') {
                        qWalletTmpPath = qWalletTmpPath + '/';
                    }
                    return qWalletTmpPath + md5Encode;
                }
                return qWalletTmpPath;
            }
            return h16;
        }
        return null;
    }
}
