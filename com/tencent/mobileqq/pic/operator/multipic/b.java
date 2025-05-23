package com.tencent.mobileqq.pic.operator.multipic;

import com.qq.taf.jce.HexUtil;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.common.app.AppInterface;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.Constants;
import com.tencent.mobileqq.data.SigInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pic.f;
import com.tencent.mobileqq.pic.l;
import com.tencent.mobileqq.pic.operator.multipic.c;
import com.tencent.mobileqq.pic.q;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.BaseUploadProcessor;
import com.tencent.mobileqq.transfile.ServerAddr;
import com.tencent.mobileqq.transfile.protohandler.RichProto;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import tencent.im.msg.im_msg_body$CustomFace;
import tencent.im.msg.im_msg_body$NotOnlineImage;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b {
    static IPatchRedirector $redirector_;
    private volatile long C;
    private Random D;

    /* renamed from: d, reason: collision with root package name */
    public String f258762d;

    /* renamed from: e, reason: collision with root package name */
    public String f258763e;

    /* renamed from: f, reason: collision with root package name */
    protected WeakReference<AppInterface> f258764f;

    /* renamed from: h, reason: collision with root package name */
    ArrayList<q> f258765h;

    /* renamed from: i, reason: collision with root package name */
    List<l> f258766i;

    /* renamed from: m, reason: collision with root package name */
    c.a f258767m;

    public b(c.a aVar, WeakReference<AppInterface> weakReference) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar, (Object) weakReference);
            return;
        }
        this.D = new Random(System.currentTimeMillis());
        this.f258767m = aVar;
        this.f258765h = aVar.f258771d;
        this.f258766i = aVar.f258772e;
        this.f258762d = aVar.f258768a;
        this.f258763e = aVar.f258769b;
        this.f258764f = weakReference;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(im_msg_body$CustomFace im_msg_body_customface) {
        if (QLog.isColorLevel() && im_msg_body_customface != null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[CustomFace]uint32_server_ip:" + im_msg_body_customface.uint32_server_ip.get());
            sb5.append(",uint32_server_port:" + im_msg_body_customface.uint32_server_port.get());
            sb5.append(",uint32_file_id:" + im_msg_body_customface.uint32_file_id.get());
            sb5.append(",bytes_md5:" + HexUtil.bytes2HexStr(im_msg_body_customface.bytes_md5.get().toByteArray()));
            sb5.append(",str_file_path:" + im_msg_body_customface.str_file_path.get());
            sb5.append(",uint32_origin:" + im_msg_body_customface.uint32_origin.get());
            sb5.append(",uint32_width:" + im_msg_body_customface.uint32_width.get());
            sb5.append(",uint32_height:" + im_msg_body_customface.uint32_height.get());
            sb5.append(",uint32_height:" + im_msg_body_customface.uint32_height.get());
            sb5.append(",image_type:" + im_msg_body_customface.image_type.get());
            return sb5.toString();
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String c(im_msg_body$NotOnlineImage im_msg_body_notonlineimage) {
        if (QLog.isColorLevel() && im_msg_body_notonlineimage != null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[NotOnlineImage]file_path:" + im_msg_body_notonlineimage.file_path.get().toStringUtf8());
            sb5.append(",file_len:" + im_msg_body_notonlineimage.file_len.get());
            sb5.append(",download_path:" + im_msg_body_notonlineimage.download_path.get().toStringUtf8());
            sb5.append(",res_id:" + im_msg_body_notonlineimage.res_id.get().toStringUtf8());
            sb5.append(",pic_md5:" + HexUtil.bytes2HexStr(im_msg_body_notonlineimage.pic_md5.get().toByteArray()));
            sb5.append(",pic_height:" + im_msg_body_notonlineimage.pic_height.get());
            sb5.append(",pic_width:" + im_msg_body_notonlineimage.pic_width.get());
            sb5.append(",original:" + im_msg_body_notonlineimage.original.get());
            sb5.append(",img_type:" + im_msg_body_notonlineimage.img_type.get());
            sb5.append(",uint32_file_id:" + im_msg_body_notonlineimage.uint32_file_id.get());
            return sb5.toString();
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public im_msg_body$CustomFace d(im_msg_body$NotOnlineImage im_msg_body_notonlineimage) {
        im_msg_body$CustomFace im_msg_body_customface = new im_msg_body$CustomFace();
        try {
            im_msg_body_customface.uint32_file_id.set(im_msg_body_notonlineimage.uint32_file_id.get());
            Integer num = 66;
            im_msg_body_customface.uint32_file_type.set(num.intValue());
            im_msg_body_customface.uint32_useful.set(1);
            SigInfo.fillCustomFaceSessionKey(this.f258764f.get(), im_msg_body_customface);
            im_msg_body_customface.bytes_md5.set(ByteStringMicro.copyFrom(im_msg_body_notonlineimage.pic_md5.get().toByteArray()));
            if (im_msg_body_notonlineimage.res_id.has()) {
                im_msg_body_customface.str_file_path.set(im_msg_body_notonlineimage.res_id.get().toStringUtf8());
            } else if (im_msg_body_notonlineimage.download_path.has()) {
                im_msg_body_customface.str_file_path.set(im_msg_body_notonlineimage.download_path.get().toStringUtf8());
            }
            im_msg_body_customface.uint32_origin.set(im_msg_body_notonlineimage.original.get());
            im_msg_body_customface.biz_type.set(4);
            im_msg_body_customface.uint32_source.set(104);
            im_msg_body_customface.uint32_width.set(im_msg_body_notonlineimage.pic_width.get());
            im_msg_body_customface.uint32_height.set(im_msg_body_notonlineimage.pic_height.get());
            im_msg_body_customface.uint32_size.set(im_msg_body_notonlineimage.file_len.get());
            im_msg_body_customface.uint32_thumb_width.set(im_msg_body_notonlineimage.uint32_thumb_width.get());
            im_msg_body_customface.uint32_thumb_height.set(im_msg_body_notonlineimage.uint32_thumb_height.get());
            im_msg_body_customface.image_type.set(im_msg_body_notonlineimage.img_type.get());
            f.c(this.f258763e, this.f258762d, "uploadForwardMultiMsgPics.convert2CustomFace", a(im_msg_body_customface));
            return im_msg_body_customface;
        } catch (Exception e16) {
            f.e(this.f258763e, this.f258762d, "uploadForwardMultiMsgPics.convert2CustomFace", "Exception, " + e16.toString());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public im_msg_body$NotOnlineImage e(im_msg_body$CustomFace im_msg_body_customface) {
        im_msg_body$NotOnlineImage im_msg_body_notonlineimage = new im_msg_body$NotOnlineImage();
        try {
            im_msg_body_notonlineimage.uint32_file_id.set(im_msg_body_customface.uint32_file_id.get());
            im_msg_body_notonlineimage.download_path.set(ByteStringMicro.copyFromUtf8("BADBADBAD"));
            StringBuilder sb5 = new StringBuilder();
            long j3 = this.C;
            this.C = 1 + j3;
            sb5.append(j3);
            sb5.append("BADBADBAD");
            sb5.append(this.D.nextInt());
            im_msg_body_notonlineimage.res_id.set(ByteStringMicro.copyFromUtf8(sb5.toString()));
            im_msg_body_notonlineimage.file_path.set(ByteStringMicro.copyFromUtf8(im_msg_body_customface.str_file_path.get()));
            im_msg_body_notonlineimage.file_len.set(im_msg_body_customface.uint32_size.get());
            im_msg_body_notonlineimage.pic_md5.set(im_msg_body_customface.bytes_md5.get());
            im_msg_body_notonlineimage.pic_height.set(im_msg_body_customface.uint32_height.get());
            im_msg_body_notonlineimage.pic_width.set(im_msg_body_customface.uint32_width.get());
            im_msg_body_notonlineimage.original.set(im_msg_body_customface.uint32_origin.get());
            im_msg_body_notonlineimage.img_type.set(im_msg_body_customface.image_type.get());
            im_msg_body_notonlineimage.biz_type.set(4);
            im_msg_body_notonlineimage.uint32_thumb_width.set(im_msg_body_customface.uint32_thumb_width.get());
            im_msg_body_notonlineimage.uint32_thumb_height.set(im_msg_body_customface.uint32_thumb_height.get());
            f.c(this.f258763e, this.f258762d, "uploadForwardMultiMsgPics.createNotOnlineImage", "OK, " + c(im_msg_body_notonlineimage));
            return im_msg_body_notonlineimage;
        } catch (Exception e16) {
            f.c(this.f258763e, this.f258762d, "uploadForwardMultiMsgPics.createNotOnlineImage", "Failed, Exception" + e16.toString());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public im_msg_body$CustomFace f(RichProto.RichProtoReq.PicUpReq picUpReq, RichProto.RichProtoResp.GroupPicUpResp groupPicUpResp, int i3) {
        im_msg_body$CustomFace im_msg_body_customface = new im_msg_body$CustomFace();
        try {
            l lVar = this.f258766i.get(i3);
            int i16 = 0;
            if (groupPicUpResp != null) {
                im_msg_body_customface.uint32_file_id.set((int) groupPicUpResp.groupFileID);
                ArrayList<ServerAddr> arrayList = groupPicUpResp.mIpList;
                if (arrayList != null && arrayList.size() > 0) {
                    ServerAddr serverAddr = groupPicUpResp.mIpList.get(0);
                    im_msg_body_customface.uint32_server_ip.set(BaseUploadProcessor.ipToLong(serverAddr.mIp));
                    im_msg_body_customface.uint32_server_port.set(serverAddr.port);
                }
            } else {
                im_msg_body_customface.uint32_file_id.set(0);
            }
            Integer num = 66;
            im_msg_body_customface.uint32_file_type.set(num.intValue());
            im_msg_body_customface.uint32_useful.set(1);
            SigInfo.fillCustomFaceSessionKey(this.f258764f.get(), im_msg_body_customface);
            if (picUpReq != null) {
                im_msg_body_customface.bytes_md5.set(ByteStringMicro.copyFrom(picUpReq.md5));
                im_msg_body_customface.str_file_path.set(picUpReq.fileName);
                PBUInt32Field pBUInt32Field = im_msg_body_customface.uint32_origin;
                if (picUpReq.isRaw) {
                    i16 = 1;
                }
                pBUInt32Field.set(i16);
                im_msg_body_customface.uint32_width.set(picUpReq.width);
                im_msg_body_customface.uint32_height.set(picUpReq.height);
                im_msg_body_customface.uint32_size.set((int) picUpReq.fileSize);
            } else {
                im_msg_body_customface.bytes_md5.set(ByteStringMicro.copyFrom(new byte[]{Constants.VIRTUAL_GAMEPAD_PARAMS_RESP, 97, 100}));
                im_msg_body_customface.str_file_path.set(WidgetCacheConstellationData.BAD);
                im_msg_body_customface.uint32_origin.set(0);
                im_msg_body_customface.uint32_width.set(lVar.f258731f.f258815a0);
                im_msg_body_customface.uint32_height.set(lVar.f258731f.f258816b0);
                im_msg_body_customface.uint32_size.set(0);
            }
            im_msg_body_customface.biz_type.set(4);
            im_msg_body_customface.uint32_source.set(104);
            im_msg_body_customface.uint32_thumb_width.set(lVar.f258731f.M);
            im_msg_body_customface.uint32_thumb_height.set(lVar.f258731f.N);
            im_msg_body_customface.image_type.set(lVar.f258731f.f258819e0);
            f.c(this.f258763e, this.f258762d, "uploadForwardMultiMsgPics.createCustomFace", "[" + i3 + "] OK, " + a(im_msg_body_customface));
            return im_msg_body_customface;
        } catch (Exception e16) {
            f.e(this.f258763e, this.f258762d, "uploadForwardMultiMsgPics.createCustomFace", "[" + i3 + "] failed, Exception, " + e16.toString());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public im_msg_body$NotOnlineImage h(RichProto.RichProtoReq.PicUpReq picUpReq, RichProto.RichProtoResp.C2CPicUpResp c2CPicUpResp, int i3) {
        im_msg_body$NotOnlineImage im_msg_body_notonlineimage = new im_msg_body$NotOnlineImage();
        try {
            l lVar = this.f258766i.get(i3);
            int i16 = 1;
            if (picUpReq != null) {
                im_msg_body_notonlineimage.file_path.set(ByteStringMicro.copyFromUtf8(picUpReq.fileName));
                im_msg_body_notonlineimage.file_len.set((int) picUpReq.fileSize);
                im_msg_body_notonlineimage.pic_md5.set(ByteStringMicro.copyFrom(picUpReq.md5));
                im_msg_body_notonlineimage.pic_height.set(picUpReq.height);
                im_msg_body_notonlineimage.pic_width.set(picUpReq.width);
                PBUInt32Field pBUInt32Field = im_msg_body_notonlineimage.original;
                if (!picUpReq.isRaw) {
                    i16 = 0;
                }
                pBUInt32Field.set(i16);
            } else {
                im_msg_body_notonlineimage.file_path.set(ByteStringMicro.copyFromUtf8(WidgetCacheConstellationData.BAD));
                im_msg_body_notonlineimage.file_len.set(0);
                im_msg_body_notonlineimage.pic_md5.set(ByteStringMicro.copyFrom(new byte[]{Constants.VIRTUAL_GAMEPAD_PARAMS_RESP, 97, 100}));
                im_msg_body_notonlineimage.pic_height.set(lVar.f258731f.f258816b0);
                im_msg_body_notonlineimage.pic_width.set(lVar.f258731f.f258815a0);
                im_msg_body_notonlineimage.original.set(0);
            }
            if (c2CPicUpResp != null) {
                String str = c2CPicUpResp.mUuid;
                if (str != null) {
                    im_msg_body_notonlineimage.download_path.set(ByteStringMicro.copyFromUtf8(str));
                }
                String str2 = c2CPicUpResp.mResid;
                if (str2 != null) {
                    im_msg_body_notonlineimage.res_id.set(ByteStringMicro.copyFromUtf8(str2));
                }
            } else {
                im_msg_body_notonlineimage.download_path.set(ByteStringMicro.copyFromUtf8(WidgetCacheConstellationData.BAD));
                im_msg_body_notonlineimage.res_id.set(ByteStringMicro.copyFromUtf8(WidgetCacheConstellationData.BAD));
            }
            im_msg_body_notonlineimage.img_type.set(lVar.f258731f.f258819e0);
            im_msg_body_notonlineimage.biz_type.set(4);
            im_msg_body_notonlineimage.uint32_thumb_width.set(lVar.f258731f.M);
            im_msg_body_notonlineimage.uint32_thumb_height.set(lVar.f258731f.N);
            f.c(this.f258763e, this.f258762d, "uploadForwardMultiMsgPics.createNotOnlineImage", "[" + i3 + "] OK, " + c(im_msg_body_notonlineimage));
            return im_msg_body_notonlineimage;
        } catch (Exception e16) {
            f.c(this.f258763e, this.f258762d, "uploadForwardMultiMsgPics.createNotOnlineImage", "[" + i3 + "] failed, Exception" + e16.toString());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i() {
        int i3;
        synchronized (this.f258765h) {
            Iterator<q> it = this.f258765h.iterator();
            i3 = 0;
            while (it.hasNext()) {
                if (it.next().f258790a == -2) {
                    i3++;
                }
            }
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        this.f258767m.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k() {
        int size = this.f258766i.size() - i();
        q qVar = new q();
        qVar.f258790a = 0;
        qVar.f258793d = Integer.valueOf(size);
        this.f258767m.b(qVar);
    }
}
