package ConfigPush;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class FileStoragePushFSSvcList extends JceStruct {
    static BigDataChannel cache_bigDataChannel;
    static DomainIpChannel cache_domainIpChannel;
    static FmtIPInfo cache_fmtIPInfo;
    static byte[] cache_pttlist;
    static ArrayList<FileStorageServerListInfo> cache_vC2CPicDownList;
    static ArrayList<FileStorageServerListInfo> cache_vGPicDownLoadList;
    static ArrayList<FileStorageServerListInfo> cache_vPicDownLoadList;
    static ArrayList<FileStorageServerListInfo> cache_vQzoneProxyServiceList;
    static ArrayList<FileStorageServerListInfo> cache_vUpLoadList;
    static ArrayList<FileStorageServerListInfo> cache_vUrlEncodeServiceList;
    static ArrayList<FileStorageServerListInfo> cache_vVipEmotionList;
    public BigDataChannel bigDataChannel;
    public DomainIpChannel domainIpChannel;
    public FmtIPInfo fmtIPInfo;
    public byte[] pttlist;
    public ArrayList<FileStorageServerListInfo> vC2CPicDownList;
    public ArrayList<FileStorageServerListInfo> vGPicDownLoadList;
    public ArrayList<FileStorageServerListInfo> vPicDownLoadList;
    public ArrayList<FileStorageServerListInfo> vQzoneProxyServiceList;
    public ArrayList<FileStorageServerListInfo> vUpLoadList;
    public ArrayList<FileStorageServerListInfo> vUrlEncodeServiceList;
    public ArrayList<FileStorageServerListInfo> vVipEmotionList;

    public FileStoragePushFSSvcList() {
        this.vUpLoadList = null;
        this.vPicDownLoadList = null;
        this.vGPicDownLoadList = null;
        this.vQzoneProxyServiceList = null;
        this.vUrlEncodeServiceList = null;
        this.bigDataChannel = null;
        this.vVipEmotionList = null;
        this.vC2CPicDownList = null;
        this.fmtIPInfo = null;
        this.domainIpChannel = null;
        this.pttlist = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_vUpLoadList == null) {
            cache_vUpLoadList = new ArrayList<>();
            cache_vUpLoadList.add(new FileStorageServerListInfo());
        }
        this.vUpLoadList = (ArrayList) jceInputStream.read((JceInputStream) cache_vUpLoadList, 0, true);
        if (cache_vPicDownLoadList == null) {
            cache_vPicDownLoadList = new ArrayList<>();
            cache_vPicDownLoadList.add(new FileStorageServerListInfo());
        }
        this.vPicDownLoadList = (ArrayList) jceInputStream.read((JceInputStream) cache_vPicDownLoadList, 1, true);
        if (cache_vGPicDownLoadList == null) {
            cache_vGPicDownLoadList = new ArrayList<>();
            cache_vGPicDownLoadList.add(new FileStorageServerListInfo());
        }
        this.vGPicDownLoadList = (ArrayList) jceInputStream.read((JceInputStream) cache_vGPicDownLoadList, 2, false);
        if (cache_vQzoneProxyServiceList == null) {
            cache_vQzoneProxyServiceList = new ArrayList<>();
            cache_vQzoneProxyServiceList.add(new FileStorageServerListInfo());
        }
        this.vQzoneProxyServiceList = (ArrayList) jceInputStream.read((JceInputStream) cache_vQzoneProxyServiceList, 3, false);
        if (cache_vUrlEncodeServiceList == null) {
            cache_vUrlEncodeServiceList = new ArrayList<>();
            cache_vUrlEncodeServiceList.add(new FileStorageServerListInfo());
        }
        this.vUrlEncodeServiceList = (ArrayList) jceInputStream.read((JceInputStream) cache_vUrlEncodeServiceList, 4, false);
        if (cache_bigDataChannel == null) {
            cache_bigDataChannel = new BigDataChannel();
        }
        this.bigDataChannel = (BigDataChannel) jceInputStream.read((JceStruct) cache_bigDataChannel, 5, false);
        if (cache_vVipEmotionList == null) {
            cache_vVipEmotionList = new ArrayList<>();
            cache_vVipEmotionList.add(new FileStorageServerListInfo());
        }
        this.vVipEmotionList = (ArrayList) jceInputStream.read((JceInputStream) cache_vVipEmotionList, 6, false);
        if (cache_vC2CPicDownList == null) {
            cache_vC2CPicDownList = new ArrayList<>();
            cache_vC2CPicDownList.add(new FileStorageServerListInfo());
        }
        this.vC2CPicDownList = (ArrayList) jceInputStream.read((JceInputStream) cache_vC2CPicDownList, 7, false);
        if (cache_fmtIPInfo == null) {
            cache_fmtIPInfo = new FmtIPInfo();
        }
        this.fmtIPInfo = (FmtIPInfo) jceInputStream.read((JceStruct) cache_fmtIPInfo, 8, false);
        if (cache_domainIpChannel == null) {
            cache_domainIpChannel = new DomainIpChannel();
        }
        this.domainIpChannel = (DomainIpChannel) jceInputStream.read((JceStruct) cache_domainIpChannel, 9, false);
        if (cache_pttlist == null) {
            cache_pttlist = r0;
            byte[] bArr = {0};
        }
        this.pttlist = jceInputStream.read(cache_pttlist, 10, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.vUpLoadList, 0);
        jceOutputStream.write((Collection) this.vPicDownLoadList, 1);
        ArrayList<FileStorageServerListInfo> arrayList = this.vGPicDownLoadList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
        ArrayList<FileStorageServerListInfo> arrayList2 = this.vQzoneProxyServiceList;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 3);
        }
        ArrayList<FileStorageServerListInfo> arrayList3 = this.vUrlEncodeServiceList;
        if (arrayList3 != null) {
            jceOutputStream.write((Collection) arrayList3, 4);
        }
        BigDataChannel bigDataChannel = this.bigDataChannel;
        if (bigDataChannel != null) {
            jceOutputStream.write((JceStruct) bigDataChannel, 5);
        }
        ArrayList<FileStorageServerListInfo> arrayList4 = this.vVipEmotionList;
        if (arrayList4 != null) {
            jceOutputStream.write((Collection) arrayList4, 6);
        }
        ArrayList<FileStorageServerListInfo> arrayList5 = this.vC2CPicDownList;
        if (arrayList5 != null) {
            jceOutputStream.write((Collection) arrayList5, 7);
        }
        FmtIPInfo fmtIPInfo = this.fmtIPInfo;
        if (fmtIPInfo != null) {
            jceOutputStream.write((JceStruct) fmtIPInfo, 8);
        }
        DomainIpChannel domainIpChannel = this.domainIpChannel;
        if (domainIpChannel != null) {
            jceOutputStream.write((JceStruct) domainIpChannel, 9);
        }
        byte[] bArr = this.pttlist;
        if (bArr != null) {
            jceOutputStream.write(bArr, 10);
        }
    }

    public FileStoragePushFSSvcList(ArrayList<FileStorageServerListInfo> arrayList, ArrayList<FileStorageServerListInfo> arrayList2, ArrayList<FileStorageServerListInfo> arrayList3, ArrayList<FileStorageServerListInfo> arrayList4, ArrayList<FileStorageServerListInfo> arrayList5, BigDataChannel bigDataChannel, ArrayList<FileStorageServerListInfo> arrayList6, ArrayList<FileStorageServerListInfo> arrayList7, FmtIPInfo fmtIPInfo, DomainIpChannel domainIpChannel, byte[] bArr) {
        this.vUpLoadList = arrayList;
        this.vPicDownLoadList = arrayList2;
        this.vGPicDownLoadList = arrayList3;
        this.vQzoneProxyServiceList = arrayList4;
        this.vUrlEncodeServiceList = arrayList5;
        this.bigDataChannel = bigDataChannel;
        this.vVipEmotionList = arrayList6;
        this.vC2CPicDownList = arrayList7;
        this.fmtIPInfo = fmtIPInfo;
        this.domainIpChannel = domainIpChannel;
        this.pttlist = bArr;
    }
}
