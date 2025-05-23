package com.tencent.mobileqq.service;

import com.qq.jce.wup.UniPacket;
import com.qq.taf.RequestPacket;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Set;

/* loaded from: classes18.dex */
public class PttUniPacket extends UniPacket {
    static IPatchRedirector $redirector_;
    public static String TAG;
    JceOutputStream josAttribute;
    JceOutputStream josData;
    JceOutputStream josPackage;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42304);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            TAG = PttUniPacket.class.getSimpleName();
        }
    }

    public PttUniPacket(boolean z16) {
        super(z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, z16);
        }
    }

    @Override // com.qq.jce.wup.UniPacket, com.qq.jce.wup.UniAttribute, com.qq.jce.wup.OldUniAttribute
    public byte[] encode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (byte[]) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        RequestPacket requestPacket = this._package;
        if (requestPacket.iVersion == 2) {
            String str = requestPacket.sServantName;
            if (str != null && !str.equals("")) {
                String str2 = this._package.sFuncName;
                if (str2 == null || str2.equals("")) {
                    throw new IllegalArgumentException("funcName can not is null");
                }
            } else {
                throw new IllegalArgumentException("servantName can not is null");
            }
        } else {
            if (requestPacket.sServantName == null) {
                requestPacket.sServantName = "";
            }
            if (requestPacket.sFuncName == null) {
                requestPacket.sFuncName = "";
            }
        }
        JceOutputStream jceOutputStream = this.josData;
        if (jceOutputStream == null) {
            this.josData = new JceOutputStream(0);
        } else {
            jceOutputStream.getByteBuffer().clear();
        }
        this.josData.setServerEncoding(this.encodeName);
        short s16 = this._package.iVersion;
        if (s16 != 2 && s16 != 1) {
            this.josData.write((Map) this._newData, 0);
        } else {
            this.josData.write((Map) this._data, 0);
        }
        this._package.sBuffer = JceUtil.getJceBufArray(this.josData.getByteBuffer());
        JceOutputStream jceOutputStream2 = this.josPackage;
        if (jceOutputStream2 == null) {
            this.josPackage = new JceOutputStream(0);
        } else {
            jceOutputStream2.getByteBuffer().clear();
        }
        this.josPackage.setServerEncoding(this.encodeName);
        writeTo(this.josPackage);
        int position = this.josPackage.getByteBuffer().position();
        int i3 = position + 4;
        ByteBuffer allocate = ByteBuffer.allocate(i3);
        allocate.putInt(i3);
        byte[] array = allocate.array();
        System.arraycopy(this.josPackage.getByteBuffer().array(), 0, array, 4, position);
        return array;
    }

    @Override // com.qq.jce.wup.UniPacket, com.qq.jce.wup.UniAttribute, com.qq.jce.wup.OldUniAttribute
    public <T> void put(String str, T t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) t16);
            return;
        }
        if (this._newData != null) {
            if (str != null) {
                if (t16 != null) {
                    if (!(t16 instanceof Set)) {
                        JceOutputStream jceOutputStream = this.josAttribute;
                        if (jceOutputStream == null) {
                            this.josAttribute = new JceOutputStream();
                        } else {
                            jceOutputStream.getByteBuffer().clear();
                        }
                        this.josAttribute.setServerEncoding(this.encodeName);
                        this.josAttribute.write(t16, 0);
                        this._newData.put(str, JceUtil.getJceBufArray(this.josAttribute.getByteBuffer()));
                        return;
                    }
                    throw new IllegalArgumentException("can not support Set");
                }
                throw new IllegalArgumentException("put value can not is null");
            }
            throw new IllegalArgumentException("put key can not is null");
        }
        super.put(str, t16);
    }
}
