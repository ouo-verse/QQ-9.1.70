package cooperation.qqfav;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.imcore.message.ad;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.helper.v;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.MessageForDLFile;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.i;
import com.tencent.mobileqq.structmsg.k;
import com.tencent.mobileqq.structmsg.view.ag;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.data.n;
import com.tencent.mobileqq.troop.data.t;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.al;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.fav.NtMultiFavUtils;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import cooperation.qqfav.c;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import mqq.app.MobileQQ;
import mqq.app.api.ProcessConstant;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class QfavUtil {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, List<Field>> f390589a = new HashMap();

    public static boolean A(ChatMessage chatMessage) {
        AbsStructMsg absStructMsg;
        if (chatMessage == null || !(chatMessage instanceof MessageForStructing) || (absStructMsg = ((MessageForStructing) chatMessage).structingMsg) == null || absStructMsg.mMsgServiceID != 14) {
            return false;
        }
        return true;
    }

    public static boolean B() {
        SharedPreferences v3 = v("QfavEdit");
        if (v3 != null) {
            return v3.getBoolean(BaseApplicationImpl.sApplication.getRuntime().getAccount() + "QfavEdit", false);
        }
        return true;
    }

    public static boolean C(ChatMessage chatMessage) {
        AbsStructMsg absStructMsg;
        if (chatMessage == null || !(chatMessage instanceof MessageForStructing) || (absStructMsg = ((MessageForStructing) chatMessage).structingMsg) == null || absStructMsg.mMsgServiceID != 35) {
            return false;
        }
        return true;
    }

    private static boolean D(ChatMessage chatMessage) {
        if ((chatMessage instanceof MessageForFile) && (chatMessage.extObj instanceof MsgRecord)) {
            return true;
        }
        return false;
    }

    public static boolean E(String str, long j3) {
        if (str != null && j3 < 0) {
            j3 = new File(str).length();
        }
        if (str != null && j3 > 10485760) {
            return true;
        }
        return false;
    }

    private static byte[] F(long j3) {
        byte[] bArr = new byte[8];
        for (int i3 = 0; i3 < 8; i3++) {
            bArr[i3] = (byte) ((j3 >> (64 - (r3 * 8))) & 255);
        }
        return bArr;
    }

    public static byte[] G(QQAppInterface qQAppInterface, long j3, ChatMessage chatMessage, String str) {
        String str2;
        FileManagerEntity fileManagerEntityByMsgFile;
        boolean z16 = chatMessage instanceof MessageForTroopFile;
        FileManagerEntity fileManagerEntity = null;
        if (!z16 && !(chatMessage instanceof MessageForFile)) {
            return null;
        }
        QfavBuilder qfavBuilder = new QfavBuilder(3);
        if (D(chatMessage)) {
            if (QLog.isColorLevel()) {
                QLog.d(ProcessConstant.QQFAV, 2, "parcel nt file msg");
            }
            MsgRecord msgRecord = (MsgRecord) chatMessage.extObj;
            if (msgRecord != null) {
                qfavBuilder.I(msgRecord, msgRecord.getChatType());
            }
        } else if (chatMessage instanceof MessageForFile) {
            i((MessageForFile) chatMessage);
            if (chatMessage.isMultiMsg) {
                if (QLog.isColorLevel()) {
                    QLog.d(ProcessConstant.QQFAV, 2, "parcelFileMsg create new entity");
                }
                fileManagerEntityByMsgFile = v.b(qQAppInterface, chatMessage);
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d(ProcessConstant.QQFAV, 2, "parcelFileMsg get entity from db");
                }
                fileManagerEntityByMsgFile = FileManagerUtil.getFileManagerEntityByMsgFile(qQAppInterface, (MessageForFile) chatMessage);
            }
            FileManagerEntity fileManagerEntity2 = fileManagerEntityByMsgFile;
            k(fileManagerEntity2);
            if (fileManagerEntity2 != null) {
                qfavBuilder.u(qQAppInterface, null, fileManagerEntity2, chatMessage, true);
            } else if (QLog.isColorLevel()) {
                QLog.d(ProcessConstant.QQFAV, 2, "entity == null");
            }
        } else if (z16) {
            MessageForTroopFile messageForTroopFile = (MessageForTroopFile) chatMessage;
            j(messageForTroopFile);
            if (chatMessage.isMultiMsg) {
                if (QLog.isColorLevel()) {
                    QLog.d(ProcessConstant.QQFAV, 2, "parcelFileMsg, isMultiMsg T, create new entity");
                }
                fileManagerEntity = v.b(qQAppInterface, chatMessage);
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d(ProcessConstant.QQFAV, 2, "parcelFileMsg, isMultiMsg T, find in db");
                }
                t m3 = TroopFileUtils.m(qQAppInterface, messageForTroopFile);
                if (m3 != null) {
                    fileManagerEntity = v.d(m3);
                    TroopFileManager F = TroopFileManager.F(qQAppInterface, m3.f294971e);
                    if (F != null && fileManagerEntity != null && !TextUtils.isEmpty(fileManagerEntity.strTroopFilePath)) {
                        n A = F.A(fileManagerEntity.strTroopFilePath);
                        if (A != null) {
                            fileManagerEntity.lastTime = A.f294923i;
                            fileManagerEntity.selfUin = String.valueOf(A.f294920f);
                        }
                    } else if (QLog.isColorLevel()) {
                        QLog.d(ProcessConstant.QQFAV, 2, "troopFileManager != null or fileManagerEntity4Favorite.strTroopFilePath == null");
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.d(ProcessConstant.QQFAV, 2, "info == null");
                }
            }
            FileManagerEntity fileManagerEntity3 = fileManagerEntity;
            k(fileManagerEntity3);
            v.a(fileManagerEntity3, messageForTroopFile);
            if (fileManagerEntity3 != null) {
                qfavBuilder.u(qQAppInterface, null, fileManagerEntity3, messageForTroopFile, true);
            } else if (QLog.isColorLevel()) {
                QLog.d(ProcessConstant.QQFAV, 2, "fileManagerEntity4Favorite == null");
            }
        } else if (chatMessage instanceof MessageForDLFile) {
            MessageForDLFile messageForDLFile = (MessageForDLFile) chatMessage;
            DataLineMsgRecord d16 = qQAppInterface.getMessageFacade().t1(messageForDLFile.deviceType).d(messageForDLFile.associatedId);
            if (d16 != null) {
                str2 = d16.path;
            } else {
                str2 = "";
            }
            if (!FileUtils.fileExistsAndNotEmpty(str2)) {
                qfavBuilder.w(qQAppInterface, null, str2);
            }
        }
        ContentValues contentValues = new ContentValues();
        ContentValues contentValues2 = (ContentValues) qfavBuilder.O().getExtras().getParcelable("fileContents");
        if (contentValues2 != null) {
            contentValues.put("fileContents", d(contentValues2));
        }
        String k3 = ad.k(chatMessage);
        long j16 = chatMessage.time;
        contentValues.put("sUin", k3);
        contentValues.put("time", Long.valueOf(j16));
        contentValues.put("entityNickName", str);
        return o(j3, 3L, contentValues);
    }

    public static byte[] H(QQAppInterface qQAppInterface, long j3, ChatMessage chatMessage, String str) {
        AbsStructMsg absStructMsg;
        if (chatMessage == null) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            str = v.c(qQAppInterface, chatMessage);
        }
        if (!(chatMessage instanceof MessageForFile) && !(chatMessage instanceof MessageForTroopFile) && !(chatMessage instanceof MessageForDLFile)) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("cvEntityContents", m(chatMessage, ""));
            bundle.putString("sEntityClassName", chatMessage.getClass().getName());
            bundle.putString("entityNickName", str);
            if ((chatMessage instanceof MessageForStructing) && (absStructMsg = ((MessageForStructing) chatMessage).structingMsg) != null) {
                bundle.putByteArray("sEntityData", absStructMsg.getBytes());
            }
            return o(j3, 1L, bundle);
        }
        return G(qQAppInterface, j3, chatMessage, str);
    }

    public static byte[] I(long j3, long j16) {
        return p(j3, 5L, F(j16));
    }

    public static byte[] J(long j3, Map<String, String> map) {
        if (map != null && map.size() != 0) {
            ContentValues contentValues = new ContentValues();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                contentValues.put(entry.getKey(), entry.getValue());
            }
            return o(j3, 4L, contentValues);
        }
        return null;
    }

    public static void K(QQAppInterface qQAppInterface, Contact contact, MessageForStructing messageForStructing, MessageForStructing messageForStructing2, List<ChatMessage> list, Map<String, String> map, ArrayList<byte[]> arrayList) {
        MessageForStructing messageForStructing3;
        boolean z16;
        List<ChatMessage> list2;
        Map<String, String> map2;
        String str;
        MessageForStructing messageForStructing4;
        if (messageForStructing == null) {
            return;
        }
        if (messageForStructing2 == null) {
            messageForStructing3 = messageForStructing;
        } else {
            messageForStructing3 = messageForStructing2;
        }
        if (list != null && list.size() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean z17 = z16;
        if (z17) {
            list2 = list;
            map2 = map;
        } else {
            List<MsgRecord> h16 = NtMultiFavUtils.h(contact, messageForStructing.uniseq, messageForStructing3.uniseq);
            if (h16 != null) {
                list2 = NtMultiFavUtils.c(qQAppInterface, h16);
                map2 = NtMultiFavUtils.l(NtMultiFavUtils.d(h16));
            } else {
                list2 = null;
                map2 = null;
            }
        }
        if (list2 == null) {
            return;
        }
        try {
            for (ChatMessage chatMessage : list2) {
                if (map2 != null) {
                    str = map2.get(ad.k(chatMessage));
                } else {
                    str = null;
                }
                arrayList.add(H(qQAppInterface, messageForStructing3.uniseq, chatMessage, str));
                if (C(chatMessage)) {
                    if (z17) {
                        messageForStructing4 = (MessageForStructing) chatMessage;
                    } else {
                        messageForStructing4 = messageForStructing;
                    }
                    K(qQAppInterface, contact, messageForStructing4, (MessageForStructing) chatMessage, null, null, arrayList);
                }
            }
        } catch (Exception e16) {
            QLog.e(ProcessConstant.QQFAV, 2, "parcelMergeMsg exception:" + e16);
        }
    }

    public static byte[] L(long j3, AbsStructMsg absStructMsg) {
        if (absStructMsg == null) {
            return null;
        }
        return p(j3, 2L, absStructMsg.getBytes());
    }

    public static String[] M(byte[] bArr) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Element documentElement;
        String str6 = null;
        try {
            documentElement = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(bArr)).getDocumentElement();
            if (TextUtils.isEmpty(null)) {
                str = documentElement.getAttribute("url");
            } else {
                str = null;
            }
        } catch (IOException e16) {
            e = e16;
            str = null;
            str2 = null;
        } catch (ParserConfigurationException e17) {
            e = e17;
            str = null;
            str2 = null;
        } catch (SAXException e18) {
            e = e18;
            str = null;
            str2 = null;
        }
        try {
            NodeList childNodes = documentElement.getChildNodes();
            int length = childNodes.getLength();
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            for (int i3 = 0; i3 < length; i3++) {
                try {
                    Node item = childNodes.item(i3);
                    String nodeName = item.getNodeName();
                    if (nodeName.equals(PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME)) {
                        NodeList childNodes2 = item.getChildNodes();
                        for (int i16 = 0; i16 < childNodes2.getLength(); i16++) {
                            Node item2 = childNodes2.item(i16);
                            if (item2.getNodeName().equals("picture")) {
                                if (TextUtils.isEmpty(str4)) {
                                    str4 = item2.getAttributes().getNamedItem("cover").getNodeValue();
                                }
                            } else if (item2.getNodeName().equals("title")) {
                                if (TextUtils.isEmpty(str6)) {
                                    str6 = w(item2);
                                }
                            } else if (item2.getNodeName().equals("summary")) {
                                if (TextUtils.isEmpty(str3)) {
                                    str3 = w(item2);
                                }
                            } else if (item2.getNodeName().equals("audio")) {
                                NamedNodeMap attributes = item2.getAttributes();
                                if (TextUtils.isEmpty(str4)) {
                                    str4 = attributes.getNamedItem("cover").getNodeValue();
                                }
                                if (TextUtils.isEmpty(str5)) {
                                    str5 = attributes.getNamedItem("src").getNodeValue();
                                }
                            }
                        }
                    } else if (nodeName.equals("source") && TextUtils.isEmpty(str2)) {
                        str2 = item.getAttributes().getNamedItem("name").getNodeValue();
                    }
                } catch (IOException e19) {
                    e = e19;
                    e.printStackTrace();
                    return new String[]{str6, str, str2, str3, str4, str5};
                } catch (ParserConfigurationException e26) {
                    e = e26;
                    e.printStackTrace();
                    return new String[]{str6, str, str2, str3, str4, str5};
                } catch (SAXException e27) {
                    e = e27;
                    e.printStackTrace();
                    return new String[]{str6, str, str2, str3, str4, str5};
                }
            }
        } catch (IOException e28) {
            e = e28;
            str2 = null;
            str3 = str2;
            str4 = str3;
            str5 = str4;
            e.printStackTrace();
            return new String[]{str6, str, str2, str3, str4, str5};
        } catch (ParserConfigurationException e29) {
            e = e29;
            str2 = null;
            str3 = str2;
            str4 = str3;
            str5 = str4;
            e.printStackTrace();
            return new String[]{str6, str, str2, str3, str4, str5};
        } catch (SAXException e36) {
            e = e36;
            str2 = null;
            str3 = str2;
            str4 = str3;
            str5 = str4;
            e.printStackTrace();
            return new String[]{str6, str, str2, str3, str4, str5};
        }
        return new String[]{str6, str, str2, str3, str4, str5};
    }

    public static void N(boolean z16) {
        SharedPreferences v3 = v("QfavEdit");
        if (v3 != null) {
            boolean commit = v3.edit().putBoolean(BaseApplicationImpl.sApplication.getRuntime().getAccount() + "QfavEdit", z16).commit();
            if (QLog.isColorLevel()) {
                QLog.i(ProcessConstant.QQFAV, 2, "setEditFlag:" + z16 + ",suc:" + commit);
            }
        }
    }

    public static void O(String str) {
        SharedPreferences v3 = v("mobileQQ");
        String str2 = "qfav_click_red_point_" + str;
        if (!v3.getBoolean(str2, false)) {
            v3.edit().putBoolean(str2, true).apply();
        }
        String str3 = "favorites_entry_red_point_" + str;
        if (!v3.getBoolean(str3, false)) {
            v3.edit().putBoolean(str3, true).apply();
        }
    }

    public static void P(String str) {
        SharedPreferences v3 = v("mobileQQ");
        String str2 = "qfav_unsupport_msg_dialog_flag_" + str;
        if (!v3.getBoolean(str2, false)) {
            v3.edit().putBoolean(str2, true).apply();
        }
    }

    public static void Q(Context context, int i3, int i16) {
        final QQToast makeText = QQToast.makeText(context, i16, i3, 2000);
        final int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.title_bar_height) - ((int) al.a(context, 5.0f));
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() != mainLooper.getThread()) {
            new Handler(mainLooper).post(new Runnable() { // from class: cooperation.qqfav.QfavUtil.1
                @Override // java.lang.Runnable
                public void run() {
                    QQToast.this.show(dimensionPixelSize);
                }
            });
        } else {
            makeText.show(dimensionPixelSize);
        }
    }

    public static void R(Context context, String str, int i3) {
        final QQToast makeText = QQToast.makeText(context, i3, str, 2000);
        final int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.title_bar_height) - ((int) al.a(context, 5.0f));
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() != mainLooper.getThread()) {
            new Handler(mainLooper).post(new Runnable() { // from class: cooperation.qqfav.QfavUtil.2
                @Override // java.lang.Runnable
                public void run() {
                    QQToast.this.show(dimensionPixelSize);
                }
            });
        } else {
            makeText.show(dimensionPixelSize);
        }
    }

    public static long S(List<byte[]> list) {
        if (list != null && list.size() != 0) {
            Iterator<byte[]> it = list.iterator();
            while (it.hasNext()) {
                long T = T(it.next());
                if (T > 0) {
                    return T;
                }
            }
        }
        return -1L;
    }

    public static long T(byte[] bArr) {
        if (bArr == null || bArr.length <= 16 || c(bArr, 8) != 5) {
            return -1L;
        }
        return c(bArr, 16);
    }

    public static Map<String, String> U(List<byte[]> list) {
        if (list != null && list.size() != 0) {
            Iterator<byte[]> it = list.iterator();
            while (it.hasNext()) {
                Map<String, String> V = V(it.next());
                if (V != null) {
                    return V;
                }
            }
        }
        return null;
    }

    public static Map<String, String> V(byte[] bArr) {
        HashMap hashMap = null;
        if (bArr != null && bArr.length > 16) {
            if (c(bArr, 8) != 4) {
                if (QLog.isColorLevel()) {
                    QLog.d(ProcessConstant.QQFAV, 2, "unParcelStructMsg, is not structMsg");
                }
                return null;
            }
            Parcel obtain = Parcel.obtain();
            obtain.unmarshall(bArr, 16, bArr.length - 16);
            obtain.setDataPosition(0);
            ContentValues contentValues = (ContentValues) ContentValues.CREATOR.createFromParcel(obtain);
            OaidMonitor.parcelRecycle(obtain);
            if (contentValues == null) {
                return null;
            }
            hashMap = new HashMap();
            for (String str : contentValues.keySet()) {
                hashMap.put(str, contentValues.getAsString(str));
            }
        }
        return hashMap;
    }

    public static AbsStructMsg W(List<byte[]> list) {
        if (list != null && list.size() != 0) {
            Iterator<byte[]> it = list.iterator();
            while (it.hasNext()) {
                AbsStructMsg X = X(it.next());
                if (X != null) {
                    return X;
                }
            }
        }
        return null;
    }

    public static AbsStructMsg X(byte[] bArr) {
        if (bArr == null || bArr.length <= 16) {
            return null;
        }
        if (c(bArr, 8) != 2) {
            if (QLog.isColorLevel()) {
                QLog.d(ProcessConstant.QQFAV, 2, "unParcelStructMsg, is not structMsg");
            }
            return null;
        }
        byte[] bArr2 = new byte[bArr.length - 16];
        System.arraycopy(bArr, 16, bArr2, 0, bArr.length - 16);
        return i.d(bArr2);
    }

    public static ContentValues Y(byte[] bArr) {
        if (bArr == null || bArr.length <= 16) {
            return null;
        }
        if (c(bArr, 8) != 3) {
            if (QLog.isColorLevel()) {
                QLog.d(ProcessConstant.QQFAV, 2, "unParcelStructMsg, is not structMsg");
            }
            return null;
        }
        return b(bArr, 16, bArr.length - 16);
    }

    public static c.a Z(byte[] bArr) {
        if (bArr == null || bArr.length <= 16 || c(bArr, 8) != 1) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 16, bArr.length - 16);
        obtain.setDataPosition(0);
        Bundle bundle = (Bundle) Bundle.CREATOR.createFromParcel(obtain);
        OaidMonitor.parcelRecycle(obtain);
        String string = bundle.getString("entityNickName");
        Entity e16 = e((ContentValues) bundle.getParcelable("cvEntityContents"), bundle.getString("sEntityClassName"));
        if (e16 instanceof ChatMessage) {
            if (e16 instanceof MessageForStructing) {
                byte[] byteArray = bundle.getByteArray("sEntityData");
                if (byteArray != null) {
                    ((MessageForStructing) e16).structingMsg = i.d(byteArray);
                }
                return new c.a((ChatMessage) e16, string);
            }
            return new c.a((ChatMessage) e16, string);
        }
        return null;
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        return str;
    }

    public static List<c> a0(List<byte[]> list) {
        if (list != null && list.size() != 0) {
            ArrayList arrayList = new ArrayList();
            for (byte[] bArr : list) {
                long c16 = c(bArr, 8);
                if (c16 != 2) {
                    if (c16 == 1) {
                        long c17 = c(bArr, 0);
                        c.a Z = Z(bArr);
                        if (Z != null) {
                            arrayList.add(new c(c17, c16, Z.f390603a, Z.f390604b));
                        } else if (QLog.isColorLevel()) {
                            QLog.i(ProcessConstant.QQFAV, 2, "unparcelMergeMsg is null");
                        }
                    } else if (c16 == 3) {
                        long c18 = c(bArr, 0);
                        ContentValues Y = Y(bArr);
                        if (Y != null) {
                            arrayList.add(new c(c18, c16, Y));
                        }
                    }
                }
            }
            return arrayList;
        }
        return null;
    }

    public static ContentValues b(byte[] bArr, int i3, int i16) {
        if (bArr == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, i3, i16);
        obtain.setDataPosition(0);
        ContentValues contentValues = (ContentValues) ContentValues.CREATOR.createFromParcel(obtain);
        OaidMonitor.parcelRecycle(obtain);
        return contentValues;
    }

    private static long c(byte[] bArr, int i3) {
        long j3 = 0;
        for (int i16 = 0; i16 < 8; i16++) {
            j3 = (j3 << 8) | (bArr[i16 + i3] & 255);
        }
        return j3;
    }

    public static byte[] d(ContentValues contentValues) {
        if (contentValues == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        contentValues.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        return marshall;
    }

    public static Entity e(ContentValues contentValues, String str) {
        return f(contentValues, str, "");
    }

    private static Entity f(ContentValues contentValues, String str, String str2) {
        try {
            Entity entity = (Entity) Class.forName(str).newInstance();
            if (entity != null && contentValues != null) {
                for (Field field : q(entity)) {
                    String str3 = str2 + field.getName();
                    Class<?> type = field.getType();
                    if (Entity.class.isAssignableFrom(type)) {
                        Entity f16 = f(contentValues, type.getName(), str3 + ".");
                        entity.setStatus(1002);
                        field.set(entity, f16);
                    } else if (type == List.class) {
                        int intValue = contentValues.getAsInteger(str3 + ".n").intValue();
                        ArrayList arrayList = new ArrayList();
                        for (int i3 = 0; i3 < intValue; i3++) {
                            arrayList.add(f(contentValues, contentValues.getAsString(str3 + "." + i3 + ".-"), str3 + "." + i3 + "."));
                        }
                        field.set(entity, arrayList);
                    } else if (type == Long.TYPE) {
                        field.set(entity, contentValues.getAsLong(str3));
                    } else if (type == Integer.TYPE) {
                        field.set(entity, contentValues.getAsInteger(str3));
                    } else if (type == String.class) {
                        field.set(entity, contentValues.getAsString(str3));
                    } else if (type == Byte.TYPE) {
                        field.set(entity, contentValues.getAsByte(str3));
                    } else if (type == byte[].class) {
                        field.set(entity, contentValues.getAsByteArray(str3));
                    } else if (type == Short.TYPE) {
                        field.set(entity, contentValues.getAsShort(str3));
                    } else if (type == Boolean.TYPE) {
                        field.set(entity, contentValues.getAsBoolean(str3));
                    } else if (type == Float.TYPE) {
                        field.set(entity, contentValues.getAsFloat(str3));
                    } else if (type == Double.TYPE) {
                        field.set(entity, contentValues.getAsDouble(str3));
                    }
                }
                if (entity.getId() != -1) {
                    entity.setStatus(1001);
                    return entity;
                }
                entity.setStatus(1002);
                return entity;
            }
            return entity;
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] g(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        byte b16 = bArr[0];
        int length = bArr.length - 1;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 1, bArr2, 0, length);
        if (b16 == 1) {
            return k.h(bArr2);
        }
        return bArr2;
    }

    private static void h(int i3, int i16, String str, String str2, String str3, String str4, String str5, long j3, String str6, String str7) {
        if (QLog.isColorLevel()) {
            QLog.d(ProcessConstant.QQFAV, 2, "dumpFileInfo\uff0ccloudtype:" + i3 + " bid:" + i16 + " uuid\uff1a" + str + " troopfilepath:" + str2 + " name:" + str5 + " size:" + j3 + " md5:" + str6 + " path:" + str7);
        }
    }

    private static void i(MessageForFile messageForFile) {
        if (messageForFile == null) {
            if (QLog.isColorLevel()) {
                QLog.d(ProcessConstant.QQFAV, 2, "dumpFileInfo\uff0c messageforfile is null");
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.d(ProcessConstant.QQFAV, 2, "dumpFileInfo\uff0c MessageForFile:");
            }
            l(messageForFile.fileName, messageForFile.filePath, messageForFile.fileSize, messageForFile.extStr);
        }
    }

    private static void j(MessageForTroopFile messageForTroopFile) {
        if (messageForTroopFile == null) {
            if (QLog.isColorLevel()) {
                QLog.d(ProcessConstant.QQFAV, 2, "dumpFileInfo\uff0c messageforfile is null");
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.d(ProcessConstant.QQFAV, 2, "dumpFileInfo\uff0c MessageForTroopFile:");
            }
            l(messageForTroopFile.fileName, messageForTroopFile.uuid, messageForTroopFile.fileSize, messageForTroopFile.extStr);
        }
    }

    private static void k(FileManagerEntity fileManagerEntity) {
        if (fileManagerEntity == null) {
            if (QLog.isColorLevel()) {
                QLog.d(ProcessConstant.QQFAV, 2, "dumpFileInfo\uff0c entity is null");
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.d(ProcessConstant.QQFAV, 2, "dumpFileInfo\uff0c entity");
            }
            h(FileManagerUtil.getFileSrcCloudType(fileManagerEntity), fileManagerEntity.busId, fileManagerEntity.Uuid, fileManagerEntity.strTroopFilePath, fileManagerEntity.WeiYunDirKey, fileManagerEntity.WeiYunFileId, fileManagerEntity.fileName, fileManagerEntity.fileSize, fileManagerEntity.strFileMd5, fileManagerEntity.getFilePath());
        }
    }

    private static void l(String str, String str2, long j3, String str3) {
        if (QLog.isColorLevel()) {
            QLog.d(ProcessConstant.QQFAV, 2, "dumpFileInfo\uff0c name:" + str + " size:" + j3 + " strExtInfo:" + str3 + " path or uuid:" + str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0065 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x004c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ContentValues m(Entity entity, String str) {
        Object obj;
        ContentValues contentValues = new ContentValues();
        for (Field field : q(entity)) {
            String str2 = str + field.getName();
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            try {
                obj = field.get(entity);
            } catch (IllegalAccessException e16) {
                e16.printStackTrace();
                obj = null;
                if (obj instanceof Entity) {
                }
            } catch (IllegalArgumentException e17) {
                e17.printStackTrace();
                obj = null;
                if (obj instanceof Entity) {
                }
            }
            if (obj instanceof Entity) {
                contentValues.putAll(m((Entity) obj, str2 + "."));
            } else if (obj instanceof Integer) {
                contentValues.put(str2, (Integer) obj);
            } else if (obj instanceof Long) {
                contentValues.put(str2, (Long) obj);
            } else if (obj instanceof String) {
                contentValues.put(str2, (String) obj);
            } else if (obj instanceof byte[]) {
                contentValues.put(str2, (byte[]) obj);
            } else if (obj instanceof Short) {
                contentValues.put(str2, (Short) obj);
            } else {
                boolean z16 = obj instanceof Boolean;
                if (z16) {
                    contentValues.put(str2, (Boolean) obj);
                } else if (obj instanceof Double) {
                    contentValues.put(str2, (Double) obj);
                } else if (obj instanceof Float) {
                    contentValues.put(str2, (Float) obj);
                } else if (obj instanceof Byte) {
                    contentValues.put(str2, (Byte) obj);
                } else if (z16) {
                    contentValues.put(str2, (Boolean) obj);
                } else if (obj instanceof List) {
                    try {
                        contentValues.putAll(n((List) obj, str2 + "."));
                    } catch (Exception e18) {
                        e18.printStackTrace();
                    }
                }
            }
        }
        return contentValues;
    }

    private static ContentValues n(List<Entity> list, String str) {
        ContentValues contentValues = new ContentValues();
        if (list != null && list.size() > 0) {
            contentValues.put(str + DomainData.DOMAIN_NAME, Integer.valueOf(list.size()));
            for (int i3 = 0; i3 < list.size(); i3++) {
                contentValues.put(str + i3 + ".-", list.get(i3).getClass().getName());
                contentValues.putAll(m(list.get(i3), str + i3 + "."));
            }
        }
        return contentValues;
    }

    private static byte[] o(long j3, long j16, Parcelable parcelable) {
        if (parcelable == null) {
            return p(j3, j16, null);
        }
        Parcel obtain = Parcel.obtain();
        parcelable.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        return p(j3, j16, marshall);
    }

    private static byte[] p(long j3, long j16, byte[] bArr) {
        int i3;
        if (bArr != null && bArr.length != 0) {
            i3 = bArr.length + 16;
        } else {
            i3 = 16;
        }
        byte[] bArr2 = new byte[i3];
        System.arraycopy(F(j3), 0, bArr2, 0, 8);
        System.arraycopy(F(j16), 0, bArr2, 8, 8);
        if (bArr != null && bArr.length > 0) {
            System.arraycopy(bArr, 0, bArr2, 16, bArr.length);
        }
        return bArr2;
    }

    private static List<Field> q(Entity entity) {
        Class<?> cls = entity.getClass();
        List<Field> list = f390589a.get(cls);
        if (list == null) {
            list = new ArrayList<>();
            for (Field field : cls.getFields()) {
                if (!Modifier.isStatic(field.getModifiers())) {
                    list.add(field);
                }
            }
            f390589a.put(cls.getName(), list);
        }
        return list;
    }

    public static int r(int i3) {
        if (i3 != 1) {
            if (i3 != 1006) {
                if (i3 != 3000) {
                    return 1;
                }
                return 3;
            }
            return 5;
        }
        return 2;
    }

    public static com.tencent.mobileqq.structmsg.view.e s(StructMsgForImageShare structMsgForImageShare) {
        if (structMsgForImageShare.getItemCount() > 0) {
            AbsStructMsgElement itemByIndex = structMsgForImageShare.getItemByIndex(0);
            if (itemByIndex instanceof ag) {
                ag agVar = (ag) itemByIndex;
                if (agVar.U0.size() > 0 && (agVar.U0.get(0) instanceof com.tencent.mobileqq.structmsg.view.e)) {
                    return (com.tencent.mobileqq.structmsg.view.e) agVar.U0.get(0);
                }
            }
        }
        return null;
    }

    public static void t(long j3, List<c> list, List<c> list2) {
        if (list != null && list2 != null) {
            for (c cVar : list) {
                if (cVar.f390602d == j3) {
                    list2.add(cVar);
                }
            }
        }
    }

    public static int u(int i3) {
        if (i3 != 1) {
            if (i3 != 3000) {
                return 3;
            }
            return 5;
        }
        return 4;
    }

    private static SharedPreferences v(String str) {
        if (!QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeBool("qfavSpMigrateFlag", false)) {
            QMMKV.migrateToSpAdapter(MobileQQ.sMobileQQ, str, "common_mmkv_configurations");
            QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeBool("qfavSpMigrateFlag", true);
        }
        return QMMKV.fromSpAdapter(MobileQQ.sMobileQQ, str, "common_mmkv_configurations");
    }

    private static String w(Node node) {
        String sb5;
        if (node.getNodeType() == 3) {
            sb5 = node.getNodeValue();
        } else {
            StringBuilder sb6 = new StringBuilder();
            int length = node.getChildNodes().getLength();
            for (int i3 = 0; i3 < length; i3++) {
                Node item = node.getChildNodes().item(i3);
                if (item != null && item.getNodeType() == 3) {
                    sb6.append(item.getNodeValue());
                }
            }
            sb5 = sb6.toString();
        }
        if (sb5 == null) {
            return "";
        }
        return sb5;
    }

    public static ContentValues x(AppInterface appInterface, FileManagerEntity fileManagerEntity, String str, boolean z16) {
        int fileSrcCloudType;
        String str2;
        boolean z17;
        File file;
        byte[] bArr;
        String str3;
        if (fileManagerEntity == null && TextUtils.isEmpty(str)) {
            return null;
        }
        if (!z16 && fileManagerEntity == null) {
            return null;
        }
        e.a().f390609a = true;
        if (z16) {
            fileSrcCloudType = 3;
        } else {
            fileSrcCloudType = FileManagerUtil.getFileSrcCloudType(fileManagerEntity);
        }
        if (fileSrcCloudType == 5) {
            str2 = fileManagerEntity.strFilePath;
            z17 = true;
        } else {
            str2 = str;
            z17 = z16;
        }
        if (z17 && !TextUtils.isEmpty(str2)) {
            file = new File(str2);
        } else {
            file = null;
        }
        if (fileManagerEntity != null) {
            bArr = fileManagerEntity.fileName.getBytes();
        } else if (file != null) {
            bArr = file.getName().getBytes();
        } else {
            bArr = null;
        }
        if (bArr.length >= 256) {
            new ContentValues().put("errorMsg", BaseApplication.getContext().getResources().getString(R.string.f170926b44));
            return null;
        }
        if (fileSrcCloudType != 1) {
            if (fileSrcCloudType != 2 && fileSrcCloudType != 3) {
                if (fileSrcCloudType != 4) {
                    if (fileSrcCloudType != 5) {
                        new ContentValues().put("errorMsg", BaseApplication.getContext().getResources().getString(R.string.b46));
                        return null;
                    }
                } else if (104 == fileManagerEntity.busId) {
                    long j3 = fileManagerEntity.lastTime;
                    if (j3 > 0 && j3 <= System.currentTimeMillis() / 1000) {
                        new ContentValues().put("errorMsg", BaseApplication.getContext().getResources().getString(R.string.f170925b43));
                        return null;
                    }
                }
            }
        } else {
            long j16 = fileManagerEntity.lastTime;
            if (j16 > 0 && j16 <= System.currentTimeMillis() / 1000) {
                new ContentValues().put("errorMsg", BaseApplication.getContext().getResources().getString(R.string.f170925b43));
                return null;
            }
        }
        if (fileManagerEntity != null) {
            String str4 = fileManagerEntity.selfUin;
            String str5 = fileManagerEntity.peerUin;
            boolean z18 = fileManagerEntity.bSend;
            int i3 = fileManagerEntity.peerType;
            if (i3 != 1 && i3 != 1000 && i3 != 1004 && i3 != 3000 && !z18) {
                str4 = str5;
            }
            if (TextUtils.isEmpty(str4)) {
                appInterface.getCurrentAccountUin();
            }
        }
        if (fileSrcCloudType != 1) {
            if (fileSrcCloudType != 2) {
                if (fileSrcCloudType != 4) {
                    str3 = "";
                } else {
                    str3 = fileManagerEntity.strTroopFilePath;
                }
            } else if (TextUtils.isEmpty(fileManagerEntity.WeiYunDirKey)) {
                str3 = fileManagerEntity.WeiYunFileId;
            } else {
                str3 = fileManagerEntity.WeiYunDirKey + fileManagerEntity.WeiYunFileId;
            }
        } else {
            str3 = fileManagerEntity.Uuid;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("fileCloudType", Integer.valueOf(fileSrcCloudType));
        if (fileManagerEntity != null) {
            contentValues.put("fileUuId", str3);
            contentValues.put("fileSize", Long.valueOf(fileManagerEntity.fileSize));
            contentValues.put(WadlProxyConsts.PARAM_FILENAME, fileManagerEntity.fileName);
            contentValues.put("fileMd5", fileManagerEntity.strFileMd5);
            contentValues.put("filePath", fileManagerEntity.getFilePath());
            contentValues.put("fileThumbPath", fileManagerEntity.strThumbPath);
            contentValues.put("filePeerType", Integer.valueOf(fileManagerEntity.peerType));
            contentValues.put("fileBid", Integer.valueOf(fileManagerEntity.busId));
            contentValues.put("filePeerUin", fileManagerEntity.peerUin);
        } else {
            contentValues.put("filePath", str2);
        }
        return contentValues;
    }

    public static ContentValues y(WeiYunFileInfo weiYunFileInfo) {
        String str;
        if (weiYunFileInfo == null) {
            return null;
        }
        if (TextUtils.isEmpty(weiYunFileInfo.f209604e)) {
            str = weiYunFileInfo.f209603d;
        } else {
            str = weiYunFileInfo.f209604e + weiYunFileInfo.f209603d;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("fileCloudType", (Integer) 2);
        contentValues.put("fileUuId", str);
        contentValues.put("fileSize", Long.valueOf(weiYunFileInfo.f209606h));
        contentValues.put(WadlProxyConsts.PARAM_FILENAME, weiYunFileInfo.f209605f);
        contentValues.put("fileMd5", weiYunFileInfo.I);
        contentValues.put("filePath", weiYunFileInfo.H);
        contentValues.put("fileThumbPath", "");
        contentValues.put("filePeerType", (Integer) 0);
        contentValues.put("fileBid", (Integer) 25);
        contentValues.put("fileSha1", weiYunFileInfo.J);
        return contentValues;
    }

    public static boolean z(String str) {
        return v("mobileQQ").getBoolean("qfav_unsupport_msg_dialog_flag_" + str, false);
    }
}
