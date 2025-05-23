package com.tencent.open.agent.auth.presenter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.open.agent.util.t;
import com.tencent.open.virtual.OpenSdkVirtualUtil;
import ep3.m;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes22.dex */
public class VirtualCreatorPresenter implements ep3.l {

    /* renamed from: a, reason: collision with root package name */
    private m f340272a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.open.agent.auth.model.f f340273b;

    /* renamed from: c, reason: collision with root package name */
    private int f340274c = 0;

    /* loaded from: classes22.dex */
    class a implements fp3.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.open.model.a f340287a;

        a(com.tencent.open.model.a aVar) {
            this.f340287a = aVar;
        }

        @Override // fp3.d
        public boolean a(boolean z16, String str, int i3, String str2) {
            t.b("VirtualCreatorPresenter", "createVirtual onResult success=", Boolean.valueOf(z16), ", errCode=", Integer.valueOf(i3), ", errMsg=", str2);
            com.tencent.open.agent.util.d.h("KEY_CREATE_VIRTUAL_D17", this.f340287a, z16);
            if (z16) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    i3 = jSONObject.optInt("ErrorCode");
                    if (i3 == 0) {
                        VirtualCreatorPresenter.this.i(true, jSONObject.optLong("uint64_vuid"), i3);
                        return false;
                    }
                } catch (JSONException e16) {
                    t.a("VirtualCreatorPresenter", "OpenVirtual.createVirtual.e:", e16);
                }
            }
            VirtualCreatorPresenter.this.i(false, 0L, i3);
            return false;
        }
    }

    /* loaded from: classes22.dex */
    class b implements fp3.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.open.model.a f340289a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f340290b;

        b(com.tencent.open.model.a aVar, String str) {
            this.f340289a = aVar;
            this.f340290b = str;
        }

        /* JADX WARN: Removed duplicated region for block: B:5:0x0056  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x005e  */
        @Override // fp3.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean a(boolean z16, String str, int i3, String str2) {
            JSONObject jSONObject;
            int optInt;
            boolean z17;
            t.b("VirtualCreatorPresenter", "OpenVirtual.uploadAvatarImage.result:", OpenSdkVirtualUtil.h(str, this.f340289a.f341678a));
            String str3 = null;
            if (z16) {
                try {
                    jSONObject = new JSONObject(str);
                    optInt = jSONObject.optInt("ErrorCode");
                } catch (JSONException e16) {
                    e = e16;
                }
                try {
                } catch (JSONException e17) {
                    e = e17;
                    i3 = optInt;
                    t.a("VirtualCreatorPresenter", "OpenVirtual.uploadAvatarImage.e:", e);
                    z17 = false;
                    if (z17) {
                    }
                    return false;
                }
                if (optInt == 0) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("msg_img_data");
                    if (optJSONObject != null) {
                        str3 = optJSONObject.optString("str_file_name");
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    i3 = optInt;
                    if (z17) {
                        VirtualCreatorPresenter.this.j(z17, this.f340290b, str3, i3);
                    } else {
                        VirtualCreatorPresenter.this.f340274c++;
                        if (VirtualCreatorPresenter.this.f340274c >= 2) {
                            VirtualCreatorPresenter.this.j(z17, this.f340290b, str3, i3);
                        } else {
                            t.b("VirtualCreatorPresenter", "OpenVirtual.uploadAvatarImage need retry mUploadAvatarRetryCount=" + VirtualCreatorPresenter.this.f340274c);
                            return true;
                        }
                    }
                    return false;
                }
                i3 = jSONObject.optInt("uint32_ret_to_http", optInt);
            }
            z17 = false;
            if (z17) {
            }
            return false;
        }
    }

    public VirtualCreatorPresenter(m mVar, com.tencent.open.agent.auth.model.f fVar) {
        this.f340272a = mVar;
        this.f340273b = fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(final boolean z16, final long j3, final int i3) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.open.agent.auth.presenter.VirtualCreatorPresenter.2
            @Override // java.lang.Runnable
            public void run() {
                VirtualCreatorPresenter.this.f340272a.df(z16, j3, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final boolean z16, final String str, final String str2, final int i3) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.open.agent.auth.presenter.VirtualCreatorPresenter.4
            @Override // java.lang.Runnable
            public void run() {
                VirtualCreatorPresenter.this.f340272a.pe(z16, str, str2, i3);
            }
        });
    }

    @Override // ep3.l
    public void a(final String str, final int i3, final int i16) {
        t.b("VirtualCreatorPresenter", "decodeAvatarImage path=", str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.open.agent.auth.presenter.VirtualCreatorPresenter.5
            /* JADX WARN: Removed duplicated region for block: B:10:0x0056 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:12:0x0057  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                Throwable th5;
                Bitmap bitmap;
                final Bitmap bitmap2 = null;
                try {
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(new File(str)));
                    try {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inSampleSize = (int) BaseImageUtil.getOptRatio(bufferedInputStream, i3, i16);
                        bitmap = com.tencent.mobileqq.util.j.d(str, options);
                        if (bitmap != null) {
                            try {
                                int i17 = i3;
                                bitmap = com.tencent.open.agent.util.g.t(bitmap, i17, i17);
                            } catch (Throwable th6) {
                                th5 = th6;
                                try {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (Exception e16) {
                                        bitmap2 = bitmap;
                                        e = e16;
                                        t.d("VirtualCreatorPresenter", "Exception", e);
                                        if (bitmap2 != null) {
                                        }
                                    }
                                } catch (Throwable th7) {
                                    th5.addSuppressed(th7);
                                }
                                throw th5;
                            }
                        }
                        bitmap2 = bitmap;
                        bufferedInputStream.close();
                    } catch (Throwable th8) {
                        th5 = th8;
                        bitmap = null;
                    }
                } catch (Exception e17) {
                    e = e17;
                }
                if (bitmap2 != null) {
                    return;
                }
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.open.agent.auth.presenter.VirtualCreatorPresenter.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        VirtualCreatorPresenter.this.f340272a.s3(bitmap2, str);
                    }
                });
            }
        });
    }

    @Override // ep3.l
    public void b(long j3, String str, String str2, boolean z16) {
        t.b("VirtualCreatorPresenter", "OpenVirtual.createVirtual nickName=", str, ", headId=", str2);
        com.tencent.open.model.a b16 = hp3.b.e().b(String.valueOf(j3));
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && b16 != null) {
            com.tencent.open.agent.util.d.B("KEY_CREATE_VIRTUAL_D17");
            this.f340273b.b(j3, str, str2, b16, z16, new a(b16));
        } else {
            t.b("VirtualCreatorPresenter", "OpenVirtual.createVirtual.return for params error");
            i(false, 0L, -1);
        }
    }

    @Override // ep3.l
    public void c(String str, String str2, boolean z16, String str3) {
        if (!TextUtils.isEmpty(str3) && new File(str3).exists()) {
            this.f340274c = 0;
            com.tencent.open.model.a b16 = hp3.b.e().b(str);
            if (!this.f340273b.a(str2, str3, b16.f341678a, str, z16, new b(b16, str2))) {
                j(false, str2, null, -2);
                return;
            }
            return;
        }
        t.b("VirtualCreatorPresenter", "OpenVirtual.uploadAvatarImage.error image file not exist");
        j(false, str2, null, -2);
    }
}
