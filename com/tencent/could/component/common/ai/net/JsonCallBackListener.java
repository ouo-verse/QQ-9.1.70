package com.tencent.could.component.common.ai.net;

import android.os.Handler;
import android.os.Looper;
import com.tencent.could.component.common.ai.utils.GZipUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* compiled from: P */
/* loaded from: classes5.dex */
public class JsonCallBackListener implements CallBackListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public IJsonDataListener f99985a;

    /* renamed from: b, reason: collision with root package name */
    public Handler f99986b;

    public JsonCallBackListener(IJsonDataListener iJsonDataListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iJsonDataListener);
        } else {
            this.f99986b = new Handler(Looper.getMainLooper());
            this.f99985a = iJsonDataListener;
        }
    }

    @Override // com.tencent.could.component.common.ai.net.CallBackListener
    public void cleanListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else if (this.f99985a != null) {
            this.f99985a = null;
        }
    }

    public String inputGzipConvertToString(InputStream inputStream) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) inputStream);
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (-1 != read) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        String uncompressToString = GZipUtils.uncompressToString(byteArrayOutputStream.toByteArray());
                        byteArrayOutputStream.close();
                        return uncompressToString;
                    }
                }
            } finally {
            }
        } catch (IOException e16) {
            TxNetWorkHelper.getInstance().logError("JsonCallBackListener", "Gzip ConvertToString error! " + e16.getMessage());
            return null;
        }
    }

    public String inputStreamConvertToString(InputStream inputStream) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) inputStream);
        }
        try {
            StringBuilder sb5 = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb5.append(readLine);
                } else {
                    return sb5.toString();
                }
            }
        } catch (IOException e16) {
            TxNetWorkHelper.getInstance().logError("JsonCallBackListener", "ConvertToString error! " + e16.getMessage());
            return null;
        }
    }

    @Override // com.tencent.could.component.common.ai.net.CallBackListener
    public void onFailed(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            this.f99986b.post(new Runnable(str) { // from class: com.tencent.could.component.common.ai.net.JsonCallBackListener.2
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ String f99989a;

                {
                    this.f99989a = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) JsonCallBackListener.this, (Object) str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    IJsonDataListener iJsonDataListener = JsonCallBackListener.this.f99985a;
                    if (iJsonDataListener != null) {
                        iJsonDataListener.onFailed(this.f99989a);
                        JsonCallBackListener.this.cleanListener();
                    }
                }
            });
        }
    }

    @Override // com.tencent.could.component.common.ai.net.CallBackListener
    public void onSuccess(InputStream inputStream, boolean z16) {
        String inputStreamConvertToString;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, inputStream, Boolean.valueOf(z16));
            return;
        }
        if (z16) {
            inputStreamConvertToString = inputGzipConvertToString(inputStream);
        } else {
            inputStreamConvertToString = inputStreamConvertToString(inputStream);
        }
        TxNetWorkHelper.getInstance().logDebug("JsonCallBackListener", "get finalResult string!");
        this.f99986b.post(new Runnable(inputStreamConvertToString) { // from class: com.tencent.could.component.common.ai.net.JsonCallBackListener.1
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f99987a;

            {
                this.f99987a = inputStreamConvertToString;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) JsonCallBackListener.this, (Object) inputStreamConvertToString);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                IJsonDataListener iJsonDataListener = JsonCallBackListener.this.f99985a;
                if (iJsonDataListener != null) {
                    iJsonDataListener.onSuccess(this.f99987a);
                    JsonCallBackListener.this.cleanListener();
                }
            }
        });
    }
}
