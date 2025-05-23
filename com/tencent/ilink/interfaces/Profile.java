package com.tencent.ilink.interfaces;

import com.google.protobuf.InvalidProtocolBufferException;
import com.tencent.luggage.wxa.s0.c;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* loaded from: classes7.dex */
public class Profile implements Serializable {
    public String bigheadurl;
    public String city;
    public String ilinkid;
    public String nickname;
    public String province;
    public String qrcodepath;
    public String requestTip;
    public String sex;
    public String smallheadurl;
    public long uin;

    public Profile() {
    }

    public static Profile pb2Profile(byte[] bArr) {
        Profile profile = new Profile();
        try {
            c a16 = c.a(bArr);
            if (a16 == null) {
                return null;
            }
            if (a16.k()) {
                profile.ilinkid = a16.d();
            }
            if (a16.hasUin()) {
                profile.uin = a16.getUin();
            }
            if (a16.hasNickname()) {
                profile.nickname = a16.getNickname();
            }
            if (a16.n()) {
                profile.sex = a16.g();
            }
            if (a16.l()) {
                profile.province = a16.e();
            }
            if (a16.j()) {
                profile.city = a16.c();
            }
            if (a16.o()) {
                profile.smallheadurl = a16.h();
            }
            if (a16.i()) {
                profile.bigheadurl = a16.b();
            }
            if (a16.m()) {
                profile.qrcodepath = a16.f();
            }
            return profile;
        } catch (InvalidProtocolBufferException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public byte[] serialize() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new ObjectOutputStream(byteArrayOutputStream).writeObject(this);
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    public String toString() {
        return "ilinkid:" + this.ilinkid + " ,uin:" + this.uin + " ,nickname:" + this.nickname + " ,sex:" + this.sex + " ,province:" + this.province + " ,city:" + this.city + ",smallheadurl:" + this.smallheadurl + " ,bigheadurl:" + this.bigheadurl + " ,qrcodepath:" + this.qrcodepath + ",requestTip:" + this.requestTip;
    }

    public Profile(byte[] bArr) {
        try {
            Profile profile = (Profile) new ObjectInputStream(new ByteArrayInputStream(bArr)).readObject();
            this.ilinkid = profile.ilinkid;
            this.uin = profile.uin;
            this.nickname = profile.nickname;
            this.sex = profile.sex;
            this.province = profile.province;
            this.city = profile.city;
            this.smallheadurl = profile.smallheadurl;
            this.bigheadurl = profile.bigheadurl;
            this.qrcodepath = profile.qrcodepath;
        } catch (IOException e16) {
            e16.printStackTrace();
        } catch (ClassNotFoundException e17) {
            e17.printStackTrace();
        }
    }
}
