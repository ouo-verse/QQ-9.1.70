package com.tencent.mobileqq.guild.temp.api.impl;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emosm.emocompat.impl.GuildPicSenderApi;
import com.tencent.mobileqq.emoticon.api.ISogouEmojiService;
import com.tencent.mobileqq.guild.temp.api.ISouGouEmoDiffApi;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

/* compiled from: P */
/* loaded from: classes33.dex */
public class SouGouEmoDiffApiImpl implements ISouGouEmoDiffApi {
    public static final String ADDRESS = "/sogou";
    private static final String TAG = "SouGouEmoDiffApiImpl";

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaseQQAppInterface f235254a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f235255b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f235256c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f235257d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f235258e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f235259f;

        a(BaseQQAppInterface baseQQAppInterface, Activity activity, String str, String str2, String str3, int i3) {
            this.f235254a = baseQQAppInterface;
            this.f235255b = activity;
            this.f235256c = str;
            this.f235257d = str2;
            this.f235258e = str3;
            this.f235259f = i3;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            ChatActivityFacade.J0((QQAppInterface) this.f235254a, this.f235255b, SouGouEmoDiffApiImpl.this.createSessionInfo(this.f235256c, this.f235257d), this.f235258e, this.f235259f);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007c A[Catch: Exception -> 0x0078, TRY_LEAVE, TryCatch #5 {Exception -> 0x0078, blocks: (B:45:0x0074, B:38:0x007c), top: B:44:0x0074 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0074 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v3, types: [java.io.OutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String copyFileFromInputStreamUri(Context context, Uri uri, String str, String str2) {
        ?? r85;
        FileOutputStream fileOutputStream;
        String str3 = null;
        str3 = null;
        str3 = null;
        InputStream inputStream = null;
        try {
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getPathFromInputStreamUri exception", e16);
        }
        try {
            try {
                context = context.getContentResolver().openInputStream(uri);
                try {
                    byte[] bArr = new byte[8192];
                    File file = new File(str);
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    File file2 = new File(str, str2);
                    if (file2.exists()) {
                        file2.delete();
                    }
                    fileOutputStream = new FileOutputStream(file2);
                    while (true) {
                        try {
                            int read = context.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        } catch (Exception e17) {
                            e = e17;
                            e.printStackTrace();
                            if (context != 0) {
                                context.close();
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            return str3;
                        }
                    }
                    fileOutputStream.flush();
                    str3 = file2.getPath();
                    context.close();
                    fileOutputStream.close();
                } catch (Exception e18) {
                    e = e18;
                    fileOutputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    str = null;
                    inputStream = context;
                    r85 = str;
                    if (inputStream != null) {
                    }
                    if (r85 != 0) {
                    }
                    throw th;
                }
            } catch (Exception e19) {
                e = e19;
                context = 0;
                fileOutputStream = null;
            } catch (Throwable th6) {
                th = th6;
                r85 = 0;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e26) {
                        QLog.e(TAG, 1, "getPathFromInputStreamUri exception", e26);
                        throw th;
                    }
                }
                if (r85 != 0) {
                    r85.close();
                }
                throw th;
            }
            return str3;
        } catch (Throwable th7) {
            th = th7;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SessionInfo createSessionInfo(String str, String str2) {
        SessionInfo sessionInfo = new SessionInfo();
        sessionInfo.f179555d = 10014;
        sessionInfo.f179559f = str;
        sessionInfo.f179557e = str2;
        return sessionInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$sendNewExp$0(Context context, Uri uri, String str, com.tencent.aio.api.runtime.a aVar) {
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir == null) {
            QLog.e(TAG, 1, "sendNewExp getExternalCacheDir is null");
            return;
        }
        String copyFileFromInputStreamUri = copyFileFromInputStreamUri(context, uri, externalCacheDir.getPath() + ADDRESS, str);
        QLog.i(TAG, 1, "sendNewExp path: $path");
        if (copyFileFromInputStreamUri == null || copyFileFromInputStreamUri.isEmpty()) {
            return;
        }
        GuildPicSenderApi.c(aVar, copyFileFromInputStreamUri, aVar.g().r().c().f(), aVar.g().r().c().j(), 1, false);
    }

    @Override // com.tencent.mobileqq.guild.temp.api.ISouGouEmoDiffApi
    public String getOpenId(Context context, String str, String str2) {
        return "";
    }

    @Override // com.tencent.mobileqq.guild.temp.api.ISouGouEmoDiffApi
    public void pullMultipleEmojiKey(Activity activity, BaseQQAppInterface baseQQAppInterface, String str, String str2, List<String> list) {
        ((ISogouEmojiService) QRoute.api(ISogouEmojiService.class)).createSogouEmojiForNT(activity, baseQQAppInterface, new SouGouEmoPanelSenderProcessor(activity, str, str2)).pullMultipleEmojiKey(list);
    }

    @Override // com.tencent.mobileqq.guild.temp.api.ISouGouEmoDiffApi
    public void sendNewExp(final Context context, final com.tencent.aio.api.runtime.a aVar, final Uri uri, final String str) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.temp.api.impl.f
            @Override // java.lang.Runnable
            public final void run() {
                SouGouEmoDiffApiImpl.lambda$sendNewExp$0(context, uri, str, aVar);
            }
        }, 64, null, true);
    }

    @Override // com.tencent.mobileqq.guild.temp.api.ISouGouEmoDiffApi
    public void trySend(Activity activity, BaseQQAppInterface baseQQAppInterface, String str, String str2, int i3, String str3) {
        ((ISogouEmojiService) QRoute.api(ISogouEmojiService.class)).createSogouEmojiForNT(activity, baseQQAppInterface, new SouGouEmoPanelSenderProcessor(activity, str, str2)).trySend(i3, str3);
    }

    @Override // com.tencent.mobileqq.guild.temp.api.ISouGouEmoDiffApi
    public void sendIMEEXpression(BaseQQAppInterface baseQQAppInterface, Activity activity, String str, String str2, String str3, String str4) {
        int i3 = InputMethodUtil.ACTION_SOGOU_EXPRESSION.equals(str4) ? 1034 : 1038;
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        if (!((activity.checkSelfPermission(QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE) == 0) && (activity.checkSelfPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0))) {
            QQPermissionFactory.getQQPermission(activity, new BusinessConfig(QQPermissionConstants.Business.ID.SOGOU_EMOJI, QQPermissionConstants.Business.SCENE.SEND_SOGOU_EMOJI)).requestPermissions(QQPermissionConstants.Permission.GROUP_STORAGE, 2, new a(baseQQAppInterface, activity, str, str2, str3, i3));
        } else {
            ChatActivityFacade.J0((QQAppInterface) baseQQAppInterface, activity, createSessionInfo(str, str2), str3, i3);
        }
    }
}
