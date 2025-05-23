package com.tencent.mobileqq.pttlogic.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;

@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IPttBuffer extends QRouteApi {

    /* loaded from: classes16.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f261297a;

        /* renamed from: b, reason: collision with root package name */
        public ByteArrayOutputStream f261298b;

        /* renamed from: c, reason: collision with root package name */
        public File f261299c;

        /* renamed from: d, reason: collision with root package name */
        public FileOutputStream f261300d;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    boolean appendBuffer(String str, byte[] bArr, int i3);

    void cancelBufferTask(String str);

    boolean createBufferTask(String str);

    boolean flush(String str);

    Map getTaskMap();

    void setMaxBufferSize(int i3);
}
