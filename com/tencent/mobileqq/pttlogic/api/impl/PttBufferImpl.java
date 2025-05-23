package com.tencent.mobileqq.pttlogic.api.impl;

import com.tencent.mobileqq.pttlogic.api.IPttBuffer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes16.dex */
public class PttBufferImpl implements IPttBuffer {
    static IPatchRedirector $redirector_ = null;
    private static final String PATH_SUFFIX = "~tmp";
    private static final Map<String, IPttBuffer.a> S_TASK_MAP;
    private static int sMaxBufferSize;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21800);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            sMaxBufferSize = 4000;
            S_TASK_MAP = new ConcurrentHashMap(2);
        }
    }

    public PttBufferImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void clearBufferTask(String str, boolean z16) {
        File file;
        IPttBuffer.a aVar = S_TASK_MAP.get(str);
        if (aVar != null) {
            ByteArrayOutputStream byteArrayOutputStream = aVar.f261298b;
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (Exception unused) {
                }
            }
            FileOutputStream fileOutputStream = aVar.f261300d;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Exception unused2) {
                }
                aVar.f261300d = null;
            }
            if (z16 && (file = aVar.f261299c) != null) {
                file.delete();
                aVar.f261299c = null;
            }
            S_TASK_MAP.remove(str);
        }
    }

    private void writeBufferToFile(IPttBuffer.a aVar, boolean z16) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        if (aVar != null && (byteArrayOutputStream = aVar.f261298b) != null) {
            if (byteArrayOutputStream.size() > 0) {
                if (aVar.f261299c == null) {
                    File file = new File(aVar.f261297a + PATH_SUFFIX);
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    aVar.f261300d = new FileOutputStream(file);
                    aVar.f261299c = file;
                }
                aVar.f261298b.writeTo(aVar.f261300d);
            }
            if (z16) {
                FileOutputStream fileOutputStream = aVar.f261300d;
                if (fileOutputStream != null) {
                    fileOutputStream.flush();
                    aVar.f261300d.close();
                    aVar.f261300d = null;
                }
                if (aVar.f261299c != null) {
                    File file2 = new File(aVar.f261297a);
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (!aVar.f261299c.renameTo(file2)) {
                        FileUtils.copyFile(aVar.f261299c, file2);
                        aVar.f261299c.delete();
                    }
                    aVar.f261299c = null;
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.pttlogic.api.IPttBuffer
    public boolean appendBuffer(String str, byte[] bArr, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, str, bArr, Integer.valueOf(i3))).booleanValue();
        }
        IPttBuffer.a aVar = S_TASK_MAP.get(str);
        if (aVar != null) {
            if (aVar.f261298b == null) {
                aVar.f261298b = new ByteArrayOutputStream(i3 << 1);
            }
            aVar.f261298b.write(bArr, 0, i3);
            if (aVar.f261298b.size() >= sMaxBufferSize) {
                try {
                    writeBufferToFile(aVar, false);
                } catch (IOException unused) {
                }
                aVar.f261298b.reset();
            }
        }
        return true;
    }

    @Override // com.tencent.mobileqq.pttlogic.api.IPttBuffer
    public void cancelBufferTask(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            clearBufferTask(str, true);
        }
    }

    @Override // com.tencent.mobileqq.pttlogic.api.IPttBuffer
    public boolean createBufferTask(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
        }
        Map<String, IPttBuffer.a> map = S_TASK_MAP;
        if (map.get(str) == null) {
            IPttBuffer.a aVar = new IPttBuffer.a();
            aVar.f261297a = str;
            map.put(str, aVar);
            return true;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.pttlogic.api.IPttBuffer
    public boolean flush(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str)).booleanValue();
        }
        IPttBuffer.a aVar = S_TASK_MAP.get(str);
        if (aVar != null && aVar.f261298b != null) {
            try {
                writeBufferToFile(aVar, true);
            } catch (IOException unused) {
            }
            aVar.f261298b.reset();
        }
        clearBufferTask(str, true);
        return true;
    }

    @Override // com.tencent.mobileqq.pttlogic.api.IPttBuffer
    public Map getTaskMap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Map) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return S_TASK_MAP;
    }

    @Override // com.tencent.mobileqq.pttlogic.api.IPttBuffer
    public void setMaxBufferSize(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            sMaxBufferSize = i3;
        }
    }
}
