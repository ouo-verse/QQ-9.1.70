package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.AppShareIDConfigInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import javax.xml.parsers.DocumentBuilderFactory;
import msf.msgcomm.msg_comm$PluginInfo;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import protocol.KQQConfig.GetResourceRespInfo;

/* compiled from: P */
/* loaded from: classes20.dex */
public class h {
    public static AppShareID a(msg_comm$PluginInfo msg_comm_plugininfo) {
        AppShareID appShareID = new AppShareID();
        appShareID.uiResID = msg_comm_plugininfo.res_id.get();
        appShareID.strPkgName = msg_comm_plugininfo.pkg_name.get();
        appShareID.uiNewVer = msg_comm_plugininfo.new_ver.get();
        appShareID.sResType = (short) msg_comm_plugininfo.res_type.get();
        appShareID.sLanType = (short) msg_comm_plugininfo.lan_type.get();
        appShareID.sPriority = (short) msg_comm_plugininfo.priority.get();
        appShareID.strResName = msg_comm_plugininfo.res_name.get();
        appShareID.strResDesc = msg_comm_plugininfo.res_desc.get();
        appShareID.strResURLBig = msg_comm_plugininfo.res_url_big.get();
        appShareID.strResURLSmall = msg_comm_plugininfo.res_url_small.get();
        AppShareIDConfigInfo c16 = c(msg_comm_plugininfo.res_conf.get());
        if (c16 != null) {
            appShareID.officalwebsite = c16.officalwebsite;
            appShareID.appstorelink = c16.appstorelink;
            appShareID.messagetail = c16.messagetail;
            appShareID.bundleid = c16.bundleid;
            appShareID.sourceUrl = c16.sourceUrl;
        }
        appShareID.updateTime = System.currentTimeMillis();
        return appShareID;
    }

    public static AppShareID b(GetResourceRespInfo getResourceRespInfo) {
        AppShareID appShareID = new AppShareID();
        appShareID.uiResID = getResourceRespInfo.uiResID;
        appShareID.strPkgName = getResourceRespInfo.strPkgName;
        appShareID.uiNewVer = getResourceRespInfo.uiNewVer;
        appShareID.sResType = getResourceRespInfo.sResType;
        appShareID.sLanType = getResourceRespInfo.sLanType;
        appShareID.sPriority = getResourceRespInfo.sPriority;
        appShareID.strResName = getResourceRespInfo.strResName;
        appShareID.strResDesc = getResourceRespInfo.strResDesc;
        appShareID.strResURLBig = getResourceRespInfo.strResURL_big;
        appShareID.strResURLSmall = getResourceRespInfo.strResURL_small;
        AppShareIDConfigInfo c16 = c(getResourceRespInfo.strResConf);
        if (c16 != null) {
            appShareID.officalwebsite = c16.officalwebsite;
            appShareID.appstorelink = c16.appstorelink;
            appShareID.messagetail = c16.messagetail;
            appShareID.bundleid = c16.bundleid;
            appShareID.sourceUrl = c16.sourceUrl;
        }
        appShareID.updateTime = System.currentTimeMillis();
        return appShareID;
    }

    public static AppShareIDConfigInfo c(String str) {
        Node item;
        Node firstChild;
        if (str != null && !"".equals(str)) {
            try {
                NodeList childNodes = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>" + str).getBytes())).getDocumentElement().getChildNodes();
                AppShareIDConfigInfo appShareIDConfigInfo = new AppShareIDConfigInfo();
                for (int i3 = 0; i3 < childNodes.getLength(); i3++) {
                    if (childNodes.item(i3).getNodeType() == 1 && (firstChild = (item = childNodes.item(i3)).getFirstChild()) != null) {
                        if ("officalwebsite".equals(item.getNodeName())) {
                            appShareIDConfigInfo.officalwebsite = firstChild.getNodeValue();
                        } else if ("androidlink".equals(item.getNodeName())) {
                            appShareIDConfigInfo.appstorelink = firstChild.getNodeValue();
                        } else if ("messagetail".equals(item.getNodeName())) {
                            appShareIDConfigInfo.messagetail = firstChild.getNodeValue();
                        } else if ("bundleid".equals(item.getNodeName())) {
                            appShareIDConfigInfo.bundleid = firstChild.getNodeValue();
                        } else if ("sourceUrl".equals(item.getNodeName())) {
                            appShareIDConfigInfo.sourceUrl = firstChild.getNodeValue();
                        }
                    }
                }
                return appShareIDConfigInfo;
            } catch (Exception unused) {
                QLog.w("share_appid", 2, "parser from xml is error,xmlStr:" + str);
            }
        }
        return null;
    }

    public static String d(long j3) {
        long c16 = com.tencent.biz.common.util.a.c(j3);
        if (c16 != 0) {
            j3 = c16;
        }
        String hexString = Integer.toHexString((int) j3);
        StringBuffer stringBuffer = new StringBuffer(hexString);
        for (int i3 = 0; i3 < 8 - hexString.length(); i3++) {
            stringBuffer.insert(0, "0");
        }
        stringBuffer.insert(0, "QQ");
        return stringBuffer.toString().toUpperCase();
    }

    public static long e(long j3) {
        return i(d(j3));
    }

    public static long f(long j3) {
        return h(g(j3));
    }

    public static String g(long j3) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.putInt((int) j3);
        allocate.flip();
        allocate.order(ByteOrder.BIG_ENDIAN);
        StringBuffer stringBuffer = new StringBuffer(Integer.toHexString(allocate.getInt()));
        int length = stringBuffer.length();
        for (int i3 = 0; i3 < 8 - length; i3++) {
            stringBuffer.insert(0, "0");
        }
        stringBuffer.insert(0, "QQ");
        return stringBuffer.toString().toUpperCase();
    }

    public static long h(String str) {
        long parseLong = Long.parseLong(str.substring(2), 16);
        long a16 = com.tencent.biz.common.util.a.a(parseLong);
        if (a16 != 0) {
            return a16;
        }
        return parseLong;
    }

    public static long i(String str) {
        long parseLong = Long.parseLong(str.substring(2), 16);
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.putLong(parseLong);
        allocate.flip();
        allocate.order(ByteOrder.BIG_ENDIAN);
        long j3 = allocate.getLong();
        if (QLog.isColorLevel()) {
            QLog.d("share_appid", 2, str + " change to ShareID =" + (j3 >>> 32));
        }
        return j3 >>> 32;
    }
}
