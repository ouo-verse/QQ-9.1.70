package com.tencent.tdf.filepicker;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes26.dex */
public class FileInfo {
    static IPatchRedirector $redirector_;
    final byte[] buffer;
    final String name;
    final String path;
    final long size;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class Builder {
        static IPatchRedirector $redirector_;
        private byte[] bytes;
        private String name;
        private String path;
        private long size;

        public Builder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public FileInfo build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (FileInfo) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return new FileInfo(this.path, this.name, this.size, this.bytes);
        }

        public Builder withData(byte[] bArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Builder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) bArr);
            }
            this.bytes = bArr;
            return this;
        }

        public Builder withName(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
            this.name = str;
            return this;
        }

        public Builder withPath(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Builder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            this.path = str;
            return this;
        }

        public Builder withSize(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, j3);
            }
            this.size = j3;
            return this;
        }
    }

    public FileInfo(String str, String str2, long j3, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, Long.valueOf(j3), bArr);
            return;
        }
        this.path = str;
        this.name = str2;
        this.size = j3;
        this.buffer = bArr;
    }

    public byte[] getBuffer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (byte[]) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.buffer;
    }

    public String getName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.name;
    }

    public String getPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.path;
    }

    public long getSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        return this.size;
    }

    public HashMap<String, Object> toMap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (HashMap) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("path", this.path);
        hashMap.put("name", this.name);
        hashMap.put("size", Long.valueOf(this.size));
        hashMap.put("bytes", this.buffer);
        return hashMap;
    }
}
