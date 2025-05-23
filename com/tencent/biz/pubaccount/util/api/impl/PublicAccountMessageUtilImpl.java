package com.tencent.biz.pubaccount.util.api.impl;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountMessageUtil;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/* loaded from: classes32.dex */
public class PublicAccountMessageUtilImpl implements IPublicAccountMessageUtil {
    public static final String ITEM_ACTION_DATA = "actionData";
    public static final String ITEM_ANDROID_URL_NAME = "androidurl";
    public static final String ITEM_APPID = "appid";
    public static final String ITEM_A_ACTION_DATA = "a_actionData";
    private static final String ITEM_A_RANK_LIST_URL = "aru";
    public static final String ITEM_COVER_NAME = "cover";
    public static final String ITEM_DIGEST_NAME = "digest";
    public static final String ITEM_FLAG_NAME = "flag";
    public static final String ITEM_GRAY_TIPS = "grayTips";
    private static final String ITEM_ICONS = "icons";
    public static final String ITEM_ICON_NAME = "icon";
    public static final String ITEM_IOS_URL_NAME = "iosurl";
    public static final String ITEM_I_ACTION_DATA = "i_actionData";
    private static final String ITEM_I_RANK_LIST_URL = "iru";
    public static final String ITEM_LIST_ROOT_NAME = "appmsg";
    private static final String ITEM_MORE_TEXT = "more";
    private static final String ITEM_NATIVE_JUMP_STRING = "nativejump";
    public static final String ITEM_NEED_LOGIN = "needlogin";
    private static final String ITEM_NEW_TIME_NAME = "new_time";
    private static final String ITEM_RANK_LIST_DESC = "desc";
    private static final String ITEM_RANK_LIST_DOWNLOAD = "ard";
    private static final String ITEM_RANK_LIST_NAME = "rna";
    private static final String ITEM_RANK_LIST_SCHEMA = "irs";
    public static final String ITEM_SENDER_EMAIL_NAME = "email";
    public static final String ITEM_SENDER_NAME_NAME = "name";
    public static final String ITEM_SENDER_ROOT_NAME = "sender";
    public static final String ITEM_SOURCE_NAME = "icon";
    public static final String ITEM_STRUCT_FIRST_LEVEL_NAME = "item";
    public static final String ITEM_STRUCT_LIST_ROOT_NAME = "msg";
    public static final String ITEM_TIME_NAME = "time";
    public static final String ITEM_TITLE_NAME = "title";
    public static final String ITEM_URL_ACTION_NAME = "action";
    public static final String ITEM_URL_NAME = "url";
    private static final String ITEM_VIDEO_FLAG = "rflag";
    private static final String ITEM_WEATHER = "wea";
    private static final String ITEM_WEA_AREA = "area";
    private static final String ITEM_WEA_EURL = "e_url";
    private static final String ITEM_WEA_JURL = "j_url";
    private static final String ITEM_WEA_NWEA = "n_wea";
    private static final String ITEM_WEA_OWEA = "o_wea";
    private static final String ITEM_WEA_REAL_AD = "b_ad";
    private static final String ITEM_WEA_TEMPER = "temper";
    private static final String ITEM_WEA_TWEA = "t_wea";
    private static final String ITEM_WEA_TYPE = "t";
    public static final int MAIL_FLAG_HAS_ATTACHMENT = 1;
    public static final int MAIL_FLAG_NO_ATTACHMENT = 0;
    public static final String META_NAME = "meta";
    public static final String ROOT_NAME = "msg";
    public static final String TYPE_NAME = "type";
    public static final int TYPE_PA_APP_SHARE = 3;
    public static final int TYPE_PA_IMAGE_TEXT = 1;
    public static final int TYPE_PA_TEXT_TEXT = 2;

    private static String getTextContent(Node node) {
        String sb5;
        if (node.getNodeType() == 3) {
            sb5 = node.getNodeValue();
        } else {
            StringBuilder sb6 = new StringBuilder();
            NodeList childNodes = node.getChildNodes();
            int length = childNodes.getLength();
            for (int i3 = 0; i3 < length; i3++) {
                Node item = childNodes.item(i3);
                if (item.getNodeType() == 3) {
                    sb6.append(item.getNodeValue());
                }
            }
            sb5 = sb6.toString();
        }
        return sb5 == null ? "" : sb5;
    }

    private static PAMessage.Item parseItem(Node node) {
        Node namedItem;
        PAMessage.Item item = new PAMessage.Item();
        NodeList childNodes = node.getChildNodes();
        int length = childNodes.getLength();
        for (int i3 = 0; i3 < length; i3++) {
            Node item2 = childNodes.item(i3);
            String textContent = getTextContent(item2);
            String nodeName = item2.getNodeName();
            if (nodeName.equals("cover")) {
                item.cover = textContent;
            } else if (nodeName.equals(ITEM_DIGEST_NAME)) {
                if (item.digestList == null) {
                    item.digestList = new ArrayList();
                }
                item.digestList.add(textContent);
            } else if (nodeName.equals("title")) {
                item.title = textContent;
                NamedNodeMap attributes = item2.getAttributes();
                item.mVideoFlag = 0;
                if (attributes != null && attributes.getLength() > 0 && (namedItem = attributes.getNamedItem(ITEM_VIDEO_FLAG)) != null) {
                    try {
                        item.mVideoFlag = Integer.parseInt(namedItem.getNodeValue());
                    } catch (NumberFormatException unused) {
                    }
                }
            } else if (nodeName.equals("url")) {
                NamedNodeMap attributes2 = item2.getAttributes();
                if (attributes2 != null && attributes2.getLength() > 0) {
                    Node namedItem2 = attributes2.getNamedItem("action");
                    if (namedItem2 != null) {
                        item.actionUrl = namedItem2.getNodeValue();
                    }
                    Node namedItem3 = attributes2.getNamedItem(ITEM_ACTION_DATA);
                    Node namedItem4 = attributes2.getNamedItem(ITEM_A_ACTION_DATA);
                    Node namedItem5 = attributes2.getNamedItem(ITEM_I_ACTION_DATA);
                    Node namedItem6 = attributes2.getNamedItem("appid");
                    if (namedItem3 != null) {
                        item.actionData = namedItem3.getNodeValue();
                    }
                    if (namedItem4 != null) {
                        item.a_actionData = namedItem4.getNodeValue();
                    }
                    if (namedItem5 != null) {
                        item.i_actionData = namedItem5.getNodeValue();
                    }
                    long j3 = 0;
                    if (namedItem6 != null) {
                        try {
                            if (!TextUtils.isEmpty(namedItem6.getNodeValue())) {
                                j3 = Long.parseLong(namedItem6.getNodeValue());
                            }
                        } catch (Exception e16) {
                            if (QLog.isColorLevel()) {
                                QLog.d(PublicAccountMessageUtilImpl.class.getSimpleName(), 2, e16.getMessage(), e16);
                            }
                        }
                    }
                    item.appId = j3;
                }
                item.url = textContent;
            } else if (nodeName.equals("flag")) {
                item.flag = Integer.parseInt(textContent);
            } else if (nodeName.equals("icon")) {
                item.icon = textContent;
            } else if (nodeName.equals("icon")) {
                item.source = textContent;
            } else if (nodeName.equals("time")) {
                item.time = Long.valueOf(textContent).longValue();
            } else if (nodeName.equals("sender")) {
                NodeList childNodes2 = item2.getChildNodes();
                int length2 = childNodes2.getLength();
                for (int i16 = 0; i16 < length2; i16++) {
                    Node item3 = childNodes2.item(i16);
                    String nodeName2 = item3.getNodeName();
                    if (nodeName2.equals("email")) {
                        item.senderEmail = item3.getNodeValue();
                    } else if (nodeName2.equals("name")) {
                        item.senderName = item3.getNodeValue();
                    }
                }
            } else if (nodeName.equals(ITEM_ANDROID_URL_NAME)) {
                item.androidUrl = textContent;
            } else if (nodeName.equals(ITEM_IOS_URL_NAME)) {
                item.iosUrl = textContent;
            } else if (nodeName.equals(ITEM_NEED_LOGIN)) {
                if (Integer.valueOf(textContent).intValue() == 1) {
                    item.needLogin = true;
                }
            } else if (nodeName.equals(ITEM_NATIVE_JUMP_STRING)) {
                item.nativeJumpString = textContent;
            } else if (nodeName.equals(ITEM_ICONS)) {
                item.iconsString = textContent;
            } else if (nodeName.equals(ITEM_RANK_LIST_NAME)) {
                item.rankListName = textContent;
            } else if (nodeName.equals(ITEM_A_RANK_LIST_URL)) {
                item.a_rankListUrl = getNodeJson(item2);
            } else if (nodeName.equals(ITEM_I_RANK_LIST_URL)) {
                item.i_rankListUrl = textContent;
            } else if (nodeName.equals(ITEM_RANK_LIST_DOWNLOAD)) {
                item.rankListDownload = getNodeJson(item2);
            } else if (nodeName.equals(ITEM_RANK_LIST_SCHEMA)) {
                item.rankListSchema = textContent;
            } else if (nodeName.equals("desc")) {
                item.desc = textContent;
            } else if (nodeName.equals("area")) {
                item.weaArea = textContent;
            } else if (nodeName.equals(ITEM_WEA_TEMPER)) {
                item.weaTemper = textContent;
            } else if (nodeName.equals(ITEM_WEATHER)) {
                item.weather = textContent;
            } else if (nodeName.equals(ITEM_WEA_OWEA)) {
                item.oneWeather = textContent;
            } else if (nodeName.equals(ITEM_WEA_TWEA)) {
                item.twoWeather = textContent;
            } else if (nodeName.equals(ITEM_WEA_JURL)) {
                item.weaJumpUrl = textContent;
            } else if (nodeName.equals(ITEM_WEA_EURL)) {
                item.weaExposeUrl = textContent;
            } else if (nodeName.equals("t")) {
                item.type = textContent;
            } else if (nodeName.equals(ITEM_NEW_TIME_NAME)) {
                item.time = Long.valueOf(textContent).longValue();
            } else if (nodeName.equals(ITEM_WEA_REAL_AD)) {
                item.isAd = textContent;
            } else if (nodeName.equals(ITEM_WEA_NWEA)) {
                item.nowTime = textContent;
            }
        }
        return item;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountMessageUtil
    public boolean jumpNative(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        new Bundle();
        Uri.parse(str).getPath();
        return false;
    }

    private static PAMessage fromStructXML(String str) {
        if (str == null) {
            return null;
        }
        try {
            DocumentBuilder newDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            if (newDocumentBuilder == null) {
                return null;
            }
            try {
                Document parse = newDocumentBuilder.parse(new ByteArrayInputStream(str.getBytes()));
                if (parse == null) {
                    return null;
                }
                Node firstChild = parse.getFirstChild();
                if (!firstChild.getNodeName().equals("msg")) {
                    return null;
                }
                PAMessage pAMessage = new PAMessage();
                pAMessage.items = new ArrayList<>();
                NodeList childNodes = firstChild.getChildNodes();
                int length = childNodes.getLength();
                for (int i3 = 0; i3 < length; i3++) {
                    Node item = childNodes.item(i3);
                    String textContent = getTextContent(item);
                    if (item.getNodeName().equals("type")) {
                        pAMessage.type = Integer.valueOf(textContent).intValue();
                    } else if (item.getNodeName().equals(ITEM_STRUCT_FIRST_LEVEL_NAME)) {
                        pAMessage.items.add(parseItem(item));
                    }
                }
                return pAMessage;
            } catch (IOException e16) {
                e16.printStackTrace();
                return null;
            } catch (SAXException e17) {
                e17.printStackTrace();
                return null;
            }
        } catch (ParserConfigurationException e18) {
            e18.printStackTrace();
            return null;
        }
    }

    private static String getNodeJson(Node node) {
        NodeList childNodes;
        if (node == null || (childNodes = node.getChildNodes()) == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (int i3 = 0; i3 < childNodes.getLength(); i3++) {
            Node item = childNodes.item(i3);
            try {
                jSONObject.put(item.getNodeName(), getTextContent(item));
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v17, types: [java.lang.Throwable, java.io.IOException] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v5 */
    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountMessageUtil
    public Object fromByteArray(byte[] bArr) {
        ObjectInputStream objectInputStream;
        ObjectInputStream objectInputStream2;
        PAMessage pAMessage = null;
        if (bArr == 0) {
            return null;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            try {
                try {
                    objectInputStream = new ObjectInputStream(byteArrayInputStream);
                } catch (IOException unused) {
                    objectInputStream = null;
                } catch (ClassNotFoundException e16) {
                    e = e16;
                    objectInputStream = null;
                } catch (Exception e17) {
                    e = e17;
                    objectInputStream = null;
                } catch (OutOfMemoryError e18) {
                    e = e18;
                    objectInputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    bArr = 0;
                    if (bArr != 0) {
                        try {
                            bArr.close();
                        } catch (IOException e19) {
                            e19.printStackTrace();
                            throw th;
                        }
                    }
                    byteArrayInputStream.close();
                    throw th;
                }
                try {
                    PAMessage pAMessage2 = (PAMessage) objectInputStream.readObject();
                    try {
                        objectInputStream.close();
                        byteArrayInputStream.close();
                        objectInputStream2 = objectInputStream;
                    } catch (IOException e26) {
                        e26.printStackTrace();
                        objectInputStream2 = e26;
                    }
                    pAMessage = pAMessage2;
                    bArr = objectInputStream2;
                } catch (IOException unused2) {
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    byteArrayInputStream.close();
                    return pAMessage;
                } catch (ClassNotFoundException e27) {
                    e = e27;
                    e.printStackTrace();
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    byteArrayInputStream.close();
                    bArr = objectInputStream;
                    return pAMessage;
                } catch (Exception e28) {
                    e = e28;
                    e.printStackTrace();
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    byteArrayInputStream.close();
                    bArr = objectInputStream;
                    return pAMessage;
                } catch (OutOfMemoryError e29) {
                    e = e29;
                    e.printStackTrace();
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    byteArrayInputStream.close();
                    bArr = objectInputStream;
                    return pAMessage;
                }
            } catch (IOException e36) {
                e36.printStackTrace();
                bArr = e36;
            }
            return pAMessage;
        } catch (Throwable th6) {
            th = th6;
        }
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountMessageUtil
    public Object fromXML(String str) {
        if (str == null) {
            return null;
        }
        try {
            DocumentBuilder newDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            if (newDocumentBuilder == null) {
                return null;
            }
            try {
                Document parse = newDocumentBuilder.parse(new ByteArrayInputStream(str.getBytes()));
                if (parse == null) {
                    return null;
                }
                Node firstChild = parse.getFirstChild();
                PAMessage pAMessage = new PAMessage();
                pAMessage.items = new ArrayList<>();
                NodeList childNodes = firstChild.getChildNodes();
                int length = childNodes.getLength();
                for (int i3 = 0; i3 < length; i3++) {
                    Node item = childNodes.item(i3);
                    String textContent = getTextContent(item);
                    if (item.getNodeName().equals("type")) {
                        pAMessage.type = Integer.valueOf(textContent).intValue();
                    } else if (item.getNodeName().equals(ITEM_LIST_ROOT_NAME)) {
                        NodeList childNodes2 = item.getChildNodes();
                        int length2 = childNodes2.getLength();
                        for (int i16 = 0; i16 < length2; i16++) {
                            Node item2 = childNodes2.item(i16);
                            if (item2.getNodeType() == 1) {
                                pAMessage.items.add(parseItem(item2));
                            }
                        }
                    } else if (item.getNodeName().equals(META_NAME)) {
                        NodeList childNodes3 = item.getChildNodes();
                        int length3 = childNodes3.getLength();
                        for (int i17 = 0; i17 < length3; i17++) {
                            Node item3 = childNodes3.item(i17);
                            String textContent2 = getTextContent(item3);
                            String nodeName = item3.getNodeName();
                            if (nodeName.equalsIgnoreCase("time")) {
                                pAMessage.sendTime = Long.valueOf(textContent2).longValue();
                            } else if (nodeName.equalsIgnoreCase("more")) {
                                pAMessage.moreText = textContent2;
                            } else if (nodeName.equalsIgnoreCase(ITEM_GRAY_TIPS)) {
                                pAMessage.grayTips = textContent2;
                            }
                        }
                    }
                }
                return pAMessage;
            } catch (IOException e16) {
                e16.printStackTrace();
                return null;
            } catch (SAXException e17) {
                e17.printStackTrace();
                return null;
            }
        } catch (ParserConfigurationException e18) {
            e18.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0047 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountMessageUtil
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] toByteArray(Object obj) {
        Throwable th5;
        ObjectOutputStream objectOutputStream;
        byte[] bArr = null;
        bArr = null;
        bArr = null;
        ObjectOutputStream objectOutputStream2 = null;
        if (obj == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        try {
            try {
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    objectOutputStream.writeObject(obj);
                    bArr = byteArrayOutputStream.toByteArray();
                    objectOutputStream.close();
                    byteArrayOutputStream.close();
                } catch (IOException e17) {
                    e = e17;
                    e.printStackTrace();
                    if (objectOutputStream != null) {
                        objectOutputStream.close();
                    }
                    byteArrayOutputStream.close();
                    return bArr;
                } catch (OutOfMemoryError e18) {
                    e = e18;
                    e.printStackTrace();
                    if (objectOutputStream != null) {
                        objectOutputStream.close();
                    }
                    byteArrayOutputStream.close();
                    return bArr;
                }
            } catch (IOException e19) {
                e = e19;
                objectOutputStream = null;
            } catch (OutOfMemoryError e26) {
                e = e26;
                objectOutputStream = null;
            } catch (Throwable th6) {
                th5 = th6;
                if (objectOutputStream2 != null) {
                }
                byteArrayOutputStream.close();
                throw th5;
            }
            return bArr;
        } catch (Throwable th7) {
            th5 = th7;
            objectOutputStream2 = objectOutputStream;
            if (objectOutputStream2 != null) {
                try {
                    objectOutputStream2.close();
                } catch (IOException e27) {
                    e27.printStackTrace();
                    throw th5;
                }
            }
            byteArrayOutputStream.close();
            throw th5;
        }
    }
}
