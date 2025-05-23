package com.tencent.mobileqq.aio.utils;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.MsgSimpleInfo;
import com.tencent.mobileqq.aio.msg.template.ITemplateMsgApi;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.zplan.show.IZPlanMsgService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqnt.aio.nick.api.INickNameApi;
import com.tencent.qqnt.kernel.nativeinterface.AdelieActionBarElement;
import com.tencent.qqnt.kernel.nativeinterface.ArkElement;
import com.tencent.qqnt.kernel.nativeinterface.BeatTypeEnum;
import com.tencent.qqnt.kernel.nativeinterface.FaceElement;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.FoldingInfo;
import com.tencent.qqnt.kernel.nativeinterface.InlineKeyboardButton;
import com.tencent.qqnt.kernel.nativeinterface.InlineKeyboardRow;
import com.tencent.qqnt.kernel.nativeinterface.LinkInfo;
import com.tencent.qqnt.kernel.nativeinterface.MarkdownElement;
import com.tencent.qqnt.kernel.nativeinterface.MemberInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgAttributeInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.PublicAccountAttrs;
import com.tencent.qqnt.kernel.nativeinterface.QQConnectAttr;
import com.tencent.qqnt.kernel.nativeinterface.TextElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.GrayTipElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.XmlElement;
import com.tencent.qqnt.msg.MsgExtKt;
import com.tencent.util.QQCustomArkDialogUtil;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0004\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0004\u001a\n\u0010\u0007\u001a\u00020\u0001*\u00020\u0004\u001a\n\u0010\b\u001a\u00020\u0001*\u00020\u0004\u001a\n\u0010\t\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\n\u001a\u00020\u0001*\u00020\u0004\u001a\n\u0010\u000b\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\f\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\r\u001a\u00020\u0001*\u00020\u0004\u001a\n\u0010\u000e\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u000f\u001a\u00020\u0001*\u00020\u0004\u001a\n\u0010\u0010\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0011\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0012\u001a\u00020\u0001*\u00020\u0004\u001a\n\u0010\u0013\u001a\u00020\u0001*\u00020\u0004\u001a\n\u0010\u0014\u001a\u00020\u0001*\u00020\u0004\u001a\n\u0010\u0015\u001a\u00020\u0001*\u00020\u0004\u001a\n\u0010\u0016\u001a\u00020\u0001*\u00020\u0004\u001a\u0010\u0010\u0019\u001a\u00020\u00012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u001a\n\u0010\u001a\u001a\u00020\u0001*\u00020\u0004\u001a\n\u0010\u001b\u001a\u00020\u0001*\u00020\u0004\u001a\n\u0010\u001c\u001a\u00020\u0001*\u00020\u0004\u001a\n\u0010\u001d\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u001e\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u001f\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010 \u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010!\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\"\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010$\u001a\u00020#*\u00020\u0000\u001a\f\u0010%\u001a\u00020#*\u00020\u0000H\u0002\u001a\u0016\u0010)\u001a\u0004\u0018\u00010(*\u00020&2\b\b\u0002\u0010'\u001a\u00020\u0001\u001a\n\u0010*\u001a\u00020#*\u00020\u0000\u001a\n\u0010+\u001a\u00020#*\u00020\u0000\u001a\n\u0010,\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010-\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010.\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010/\u001a\u00020\u0001*\u00020\u0000\u001a\n\u00100\u001a\u00020\u0001*\u00020\u0000\u001a\n\u00101\u001a\u00020\u0001*\u00020\u0000\u001a\n\u00102\u001a\u00020\u0001*\u00020\u0000\u001a\n\u00103\u001a\u00020\u0001*\u00020\u0000\u001a\n\u00104\u001a\u00020\u0001*\u00020\u0004\u001a\n\u00105\u001a\u00020\u0001*\u00020\u0000\u001a\n\u00106\u001a\u00020\u0001*\u00020\u0000\u001a\n\u00107\u001a\u00020\u0001*\u00020\u0004\u001a\n\u00108\u001a\u00020\u0001*\u00020\u0000\u001a\n\u00109\u001a\u00020(*\u00020\u0000\u001a\n\u0010:\u001a\u00020(*\u00020\u0000\u001a\f\u0010<\u001a\u0004\u0018\u00010;*\u00020\u0000\u001a\n\u0010=\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010?\u001a\u00020>*\u00020\u0000\u001a\n\u0010@\u001a\u00020\u0001*\u00020\u0004\u001a\f\u0010B\u001a\u0004\u0018\u00010A*\u00020\u0004\u001a\n\u0010C\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010D\u001a\u00020\u0001*\u00020\u0000\"\u001a\u0010H\u001a\u00020E8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\bF\u0010G\u00a8\u0006I"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "", "Z", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "r", "p", "a0", "X", "t", "u", "L", "y", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "d0", "I", "H", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "P", "W", "V", "Y", "M", "Lcom/tencent/qqnt/kernel/nativeinterface/ArkElement;", "arkElement", "a", "B", "b", "c", HippyTKDListViewAdapter.X, "E", "e0", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "N", "D", "", "i", "g0", "Lcom/tencent/qqnt/kernel/nativeinterface/MemberInfo;", "forceRemarkFirst", "", "j", "f", tl.h.F, "K", "c0", "w", "J", ReportConstant.COSTREPORT_PREFIX, "O", "U", "b0", "G", UserInfo.SEX_FEMALE, BdhLogUtil.LogTag.Tag_Req, ExifInterface.LATITUDE_SOUTH, "f0", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/kernel/nativeinterface/QQConnectAttr;", "g", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/aio/msg/MsgSimpleInfo;", "l", "T", "Lcom/tencent/qqnt/kernel/nativeinterface/LinkInfo;", "d", "v", "o", "", "e", "()I", "MAX_SHOW_NICK_NAME_LEN", "aio_api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final int f194141a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49809);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f194141a = 19;
        }
    }

    public static final boolean A(@NotNull AIOMsgItem aIOMsgItem) {
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        return B(aIOMsgItem.getMsgRecord());
    }

    public static final boolean B(@NotNull MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        if (!b(msgRecord) && !c(msgRecord)) {
            return false;
        }
        return true;
    }

    public static final boolean C(@NotNull AIOMsgItem aIOMsgItem) {
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        if (aIOMsgItem.getMsgRecord().msgType == 5) {
            return true;
        }
        return false;
    }

    public static final boolean D(@NotNull AIOMsgItem aIOMsgItem) {
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        if (aIOMsgItem.getMsgRecord().msgType == 17) {
            return true;
        }
        return false;
    }

    public static final boolean E(@NotNull AIOMsgItem aIOMsgItem) {
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        if (MsgExtKt.y(aIOMsgItem.getMsgRecord()) && !r(aIOMsgItem.getMsgRecord()) && !a0(aIOMsgItem.getMsgRecord()) && !MsgExtKt.M(aIOMsgItem.getMsgRecord()) && !MsgExtKt.O(aIOMsgItem.getMsgRecord()) && !G(aIOMsgItem.getMsgRecord())) {
            return true;
        }
        return false;
    }

    public static final boolean F(@NotNull AIOMsgItem aIOMsgItem) {
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        return G(aIOMsgItem.getMsgRecord());
    }

    /* JADX WARN: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean G(@NotNull MsgRecord msgRecord) {
        boolean z16;
        boolean z17;
        boolean z18;
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        if (msgRecord.msgType == 2) {
            ArrayList<MsgElement> arrayList = msgRecord.elements;
            if (arrayList != null) {
                if (!arrayList.isEmpty()) {
                    Iterator<T> it = arrayList.iterator();
                    while (it.hasNext()) {
                        int i3 = ((MsgElement) it.next()).elementType;
                        if (i3 != 14 && i3 != 17) {
                            z17 = false;
                        } else {
                            z17 = true;
                        }
                        if (z17) {
                            z18 = true;
                            break;
                        }
                    }
                }
                z18 = false;
                if (z18) {
                    z16 = true;
                    if (z16) {
                        return true;
                    }
                }
            }
            z16 = false;
            if (z16) {
            }
        }
        if (msgRecord.msgType == 31) {
            return true;
        }
        return false;
    }

    public static final boolean H(@NotNull AIOMsgItem aIOMsgItem) {
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        return I(aIOMsgItem.getMsgRecord());
    }

    public static final boolean I(@NotNull MsgRecord msgRecord) {
        ArrayList<MsgElement> elements;
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        if (msgRecord.msgType != 8 || (elements = msgRecord.elements) == null) {
            return false;
        }
        Intrinsics.checkNotNullExpressionValue(elements, "elements");
        Iterator<T> it = elements.iterator();
        while (it.hasNext()) {
            if (((MsgElement) it.next()).elementType != 16) {
                return false;
            }
        }
        return true;
    }

    public static final boolean J(@NotNull AIOMsgItem aIOMsgItem) {
        MsgElement msgElement;
        GrayTipElement grayTipElement;
        XmlElement xmlElement;
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        ArrayList<MsgElement> arrayList = aIOMsgItem.getMsgRecord().elements;
        if (arrayList == null || arrayList.isEmpty() || (msgElement = arrayList.get(0)) == null || (grayTipElement = msgElement.grayTipElement) == null || (xmlElement = grayTipElement.xmlElement) == null || ((int) xmlElement.busiId) != 1061 || ((int) xmlElement.busiType) != 12) {
            return false;
        }
        return true;
    }

    public static final boolean K(@NotNull AIOMsgItem aIOMsgItem) {
        FileElement fileElement;
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        MsgElement firstTypeElement = aIOMsgItem.getFirstTypeElement(3);
        if (firstTypeElement == null || (fileElement = firstTypeElement.fileElement) == null || com.tencent.qqnt.aio.element.file.util.a.d(fileElement) != 0) {
            return false;
        }
        return true;
    }

    public static final boolean L(@NotNull AIOMsgItem aIOMsgItem) {
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        return MsgExtKt.M(aIOMsgItem.getMsgRecord());
    }

    public static final boolean M(@NotNull MsgRecord msgRecord) {
        boolean z16;
        String str;
        Object obj;
        ArkElement arkElement;
        boolean z17;
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        if (!u(msgRecord)) {
            return false;
        }
        try {
            ArrayList<MsgElement> arrayList = msgRecord.elements;
            Intrinsics.checkNotNullExpressionValue(arrayList, "this.elements");
            Iterator<T> it = arrayList.iterator();
            while (true) {
                str = null;
                if (it.hasNext()) {
                    obj = it.next();
                    if (((MsgElement) obj).arkElement != null) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            MsgElement msgElement = (MsgElement) obj;
            if (msgElement != null && (arkElement = msgElement.arkElement) != null) {
                str = arkElement.bytesData;
            }
        } catch (Exception e16) {
            QLog.e("MsgElementFilePathExtUtil", 1, "error when parse ark json: " + e16);
            z16 = false;
        }
        if (str == null) {
            return false;
        }
        z16 = Intrinsics.areEqual(new JSONObject(str).optString("app"), "com.tencent.map");
        if (!z16) {
            return false;
        }
        return true;
    }

    public static final boolean N(@NotNull AIOMsgItem aIOMsgItem) {
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        if (aIOMsgItem.getMsgRecord().msgType == 6) {
            return true;
        }
        return false;
    }

    public static final boolean O(@NotNull AIOMsgItem aIOMsgItem) {
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        if (aIOMsgItem.getMsgRecord().chatType == 103) {
            return true;
        }
        return false;
    }

    public static final boolean P(@NotNull MsgRecord msgRecord) {
        ArrayList<MsgElement> arrayList;
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        int i3 = msgRecord.msgType;
        if ((i3 == 11 || i3 == 15) && (arrayList = msgRecord.elements) != null && arrayList.size() != 0) {
            ArrayList<MsgElement> elements = msgRecord.elements;
            Intrinsics.checkNotNullExpressionValue(elements, "elements");
            Iterator<T> it = elements.iterator();
            while (it.hasNext()) {
                if (((MsgElement) it.next()).textGiftElement != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final boolean Q(@NotNull AIOMsgItem aIOMsgItem) {
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        return al.e(aIOMsgItem.getMsgRecord());
    }

    public static final boolean R(@NotNull AIOMsgItem aIOMsgItem) {
        MsgElement i3;
        MarkdownElement markdownElement;
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        if (!F(aIOMsgItem) || (i3 = MsgExtKt.i(aIOMsgItem.getMsgRecord(), 14)) == null || (markdownElement = i3.markdownElement) == null || markdownElement.mdExtType == 0) {
            return false;
        }
        return true;
    }

    public static final boolean S(@NotNull MsgRecord msgRecord) {
        MsgElement i3;
        MarkdownElement markdownElement;
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        if (!G(msgRecord) || (i3 = MsgExtKt.i(msgRecord, 14)) == null || (markdownElement = i3.markdownElement) == null || markdownElement.mdExtType == 0) {
            return false;
        }
        return true;
    }

    public static final boolean T(@NotNull MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        LinkInfo d16 = d(msgRecord);
        if (d16 == null) {
            return false;
        }
        if (MsgExtKt.S(msgRecord)) {
            return true;
        }
        if (TextUtils.isEmpty(d16.title) || TextUtils.isEmpty(d16.desc) || TextUtils.isEmpty(d16.icon)) {
            return false;
        }
        return true;
    }

    public static final boolean U(@NotNull AIOMsgItem aIOMsgItem) {
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        return MsgExtKt.U(aIOMsgItem.getMsgRecord());
    }

    public static final boolean V(@NotNull MsgRecord msgRecord) {
        PublicAccountAttrs publicAccountAttrs;
        Long l3;
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        if (msgRecord.msgType != 11 || msgRecord.chatType != 103 || MsgExtKt.S(msgRecord) || !Intrinsics.areEqual(msgRecord.peerUid, "u_2ZRcriDgt2a46svnxKPPMw")) {
            return false;
        }
        MsgAttributeInfo msgAttributeInfo = msgRecord.msgAttrs.get(4);
        if (msgAttributeInfo != null) {
            publicAccountAttrs = msgAttributeInfo.publicAccountAttrs;
        } else {
            publicAccountAttrs = null;
        }
        if (publicAccountAttrs == null || (l3 = publicAccountAttrs.bitmap) == null || (l3.longValue() & 12) == 0) {
            return false;
        }
        return true;
    }

    public static final boolean W(@NotNull MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        if (msgRecord.msgType == 11 && msgRecord.chatType == 103 && !MsgExtKt.S(msgRecord) && Intrinsics.areEqual(msgRecord.peerUid, "u_2ZRcriDgt2a46svnxKPPMw")) {
            return true;
        }
        return false;
    }

    public static final boolean X(@NotNull MsgRecord msgRecord) {
        ArrayList<MsgElement> arrayList;
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        if (msgRecord.msgType != 2 || (arrayList = msgRecord.elements) == null || arrayList.size() != 1 || MsgExtKt.i(msgRecord, 6) == null) {
            return false;
        }
        return true;
    }

    public static final boolean Y(@NotNull MsgRecord msgRecord) {
        ArkElement arkElement;
        Object obj;
        boolean z16;
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        if (!u(msgRecord)) {
            return false;
        }
        ArrayList<MsgElement> arrayList = msgRecord.elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "this.elements");
        Iterator<T> it = arrayList.iterator();
        while (true) {
            arkElement = null;
            if (it.hasNext()) {
                obj = it.next();
                if (((MsgElement) obj).arkElement != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        MsgElement msgElement = (MsgElement) obj;
        if (msgElement != null) {
            arkElement = msgElement.arkElement;
        }
        if (!a(arkElement)) {
            return false;
        }
        return true;
    }

    public static final boolean Z(@NotNull AIOMsgItem aIOMsgItem) {
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        return a0(aIOMsgItem.getMsgRecord());
    }

    public static final boolean a(@Nullable ArkElement arkElement) {
        String str;
        if (arkElement != null) {
            str = arkElement.bytesData;
        } else {
            str = null;
        }
        if (str == null) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return ((ITemplateMsgApi) QRoute.api(ITemplateMsgApi.class)).isTemplateMsg(jSONObject.optString("app"), jSONObject.optString(QQCustomArkDialogUtil.BIZ_SRC), jSONObject.optString("view"));
        } catch (Exception unused) {
            return false;
        }
    }

    public static final boolean a0(@NotNull MsgRecord msgRecord) {
        ArrayList<MsgElement> elements;
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        if (msgRecord.msgType != 2 || (elements = msgRecord.elements) == null) {
            return false;
        }
        Intrinsics.checkNotNullExpressionValue(elements, "elements");
        for (MsgElement msgElement : elements) {
            int i3 = msgElement.elementType;
            if (i3 != 6 && i3 != 1 && i3 != 43 && i3 != 44) {
                return false;
            }
            if (i3 == 6) {
                FaceElement faceElement = msgElement.faceElement;
                Intrinsics.checkNotNullExpressionValue(faceElement, "it.faceElement");
                if (MsgExtKt.N(faceElement)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static final boolean b(@NotNull MsgRecord msgRecord) {
        BeatTypeEnum beatTypeEnum;
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        FoldingInfo foldingInfo = msgRecord.foldingInfo;
        if (foldingInfo != null) {
            beatTypeEnum = foldingInfo.beatType;
        } else {
            beatTypeEnum = null;
        }
        if (beatTypeEnum == BeatTypeEnum.KFOLDCANSPREAD) {
            return true;
        }
        return false;
    }

    public static final boolean b0(@NotNull AIOMsgItem aIOMsgItem) {
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        if (aIOMsgItem.s0() != null) {
            return true;
        }
        return false;
    }

    public static final boolean c(@NotNull MsgRecord msgRecord) {
        BeatTypeEnum beatTypeEnum;
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        FoldingInfo foldingInfo = msgRecord.foldingInfo;
        if (foldingInfo != null) {
            beatTypeEnum = foldingInfo.beatType;
        } else {
            beatTypeEnum = null;
        }
        if (beatTypeEnum == BeatTypeEnum.KFOLDNOTSPREAD) {
            return true;
        }
        return false;
    }

    public static final boolean c0(@NotNull AIOMsgItem aIOMsgItem) {
        FileElement fileElement;
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        MsgElement firstTypeElement = aIOMsgItem.getFirstTypeElement(3);
        if (firstTypeElement == null || (fileElement = firstTypeElement.fileElement) == null || com.tencent.qqnt.aio.element.file.util.a.d(fileElement) != 2) {
            return false;
        }
        return true;
    }

    @Nullable
    public static final LinkInfo d(@NotNull MsgRecord msgRecord) {
        TextElement textElement;
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        if (msgRecord.msgType != 2) {
            return null;
        }
        int i3 = msgRecord.chatType;
        if ((i3 != 1 && i3 != 2) || msgRecord.elements.size() != 1 || msgRecord.elements.get(0).elementType != 1 || (textElement = msgRecord.elements.get(0).textElement) == null) {
            return null;
        }
        return textElement.linkInfo;
    }

    public static final boolean d0(@NotNull AIOMsgItem aIOMsgItem) {
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        if (aIOMsgItem.getMsgRecord().msgType != 2 || aIOMsgItem.getMsgRecord().elements == null) {
            return false;
        }
        ArrayList<MsgElement> arrayList = aIOMsgItem.getMsgRecord().elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msgRecord.elements");
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            if (((MsgElement) it.next()).elementType == 5) {
                return true;
            }
        }
        return false;
    }

    public static final int e() {
        return f194141a;
    }

    public static final boolean e0(@NotNull AIOMsgItem aIOMsgItem) {
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        return MsgExtKt.Z(aIOMsgItem.getMsgRecord());
    }

    @NotNull
    public static final CharSequence f(@NotNull AIOMsgItem aIOMsgItem) {
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        CharSequence g06 = g0(aIOMsgItem);
        QRouteApi api = QRoute.api(INickNameApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(INickNameApi::class.java)");
        return INickNameApi.a.a((INickNameApi) api, g06, false, 2, null);
    }

    public static final boolean f0(@NotNull AIOMsgItem aIOMsgItem) {
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        return MsgExtKt.b0(aIOMsgItem.getMsgRecord());
    }

    @Nullable
    public static final QQConnectAttr g(@NotNull AIOMsgItem aIOMsgItem) {
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        return MsgExtKt.k(aIOMsgItem.getMsgRecord());
    }

    private static final CharSequence g0(AIOMsgItem aIOMsgItem) {
        MemberInfo K = aIOMsgItem.K();
        String str = null;
        if (K != null) {
            str = k(K, false, 1, null);
        }
        if (str == null) {
            return al.i(aIOMsgItem.getMsgRecord());
        }
        return str;
    }

    @NotNull
    public static final CharSequence h(@NotNull AIOMsgItem aIOMsgItem) {
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        String obj = f(aIOMsgItem).toString();
        int wordCountNeo = StringUtil.getWordCountNeo(obj);
        int i3 = f194141a;
        if (wordCountNeo > i3) {
            return StringUtil.substringNeo(obj, 0, i3 - 3) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
        }
        return obj;
    }

    @NotNull
    public static final CharSequence i(@NotNull AIOMsgItem aIOMsgItem) {
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        return ((INickNameApi) QRoute.api(INickNameApi.class)).getEmotionNickName(g0(aIOMsgItem), 13);
    }

    @Nullable
    public static final String j(@NotNull MemberInfo memberInfo, boolean z16) {
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        Intrinsics.checkNotNullParameter(memberInfo, "<this>");
        boolean z27 = true;
        if (!aq.f194114a.a() && !z16) {
            String cardName = memberInfo.cardName;
            Intrinsics.checkNotNullExpressionValue(cardName, "cardName");
            if (cardName.length() > 0) {
                z19 = true;
            } else {
                z19 = false;
            }
            if (z19) {
                return memberInfo.cardName;
            }
            String remark = memberInfo.remark;
            Intrinsics.checkNotNullExpressionValue(remark, "remark");
            if (remark.length() > 0) {
                z26 = true;
            } else {
                z26 = false;
            }
            if (z26) {
                return memberInfo.remark;
            }
            String nick = memberInfo.nick;
            Intrinsics.checkNotNullExpressionValue(nick, "nick");
            if (nick.length() <= 0) {
                z27 = false;
            }
            if (!z27) {
                return null;
            }
            return memberInfo.nick;
        }
        String remark2 = memberInfo.remark;
        Intrinsics.checkNotNullExpressionValue(remark2, "remark");
        if (remark2.length() > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            return memberInfo.remark;
        }
        String cardName2 = memberInfo.cardName;
        Intrinsics.checkNotNullExpressionValue(cardName2, "cardName");
        if (cardName2.length() > 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z18) {
            return memberInfo.cardName;
        }
        String nick2 = memberInfo.nick;
        Intrinsics.checkNotNullExpressionValue(nick2, "nick");
        if (nick2.length() <= 0) {
            z27 = false;
        }
        if (!z27) {
            return null;
        }
        return memberInfo.nick;
    }

    public static /* synthetic */ String k(MemberInfo memberInfo, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        return j(memberInfo, z16);
    }

    @NotNull
    public static final MsgSimpleInfo l(@NotNull AIOMsgItem aIOMsgItem) {
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        return new MsgSimpleInfo(aIOMsgItem.getMsgId(), aIOMsgItem.getMsgSeq(), aIOMsgItem.getMsgRecord().msgTime);
    }

    @NotNull
    public static final String m(@NotNull AIOMsgItem aIOMsgItem) {
        String replace$default;
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        MsgElement i3 = MsgExtKt.i(aIOMsgItem.getMsgRecord(), 1);
        if (i3 == null) {
            return "";
        }
        String str = i3.textElement.content;
        Intrinsics.checkNotNullExpressionValue(str, "msgElement.textElement.content");
        replace$default = StringsKt__StringsJVMKt.replace$default(str, IZPlanMsgService.ZPLAN_MSG_PREFIX, "", false, 4, (Object) null);
        return replace$default;
    }

    @NotNull
    public static final String n(@NotNull AIOMsgItem aIOMsgItem) {
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        return MsgExtKt.n(aIOMsgItem.getMsgRecord());
    }

    public static final boolean o(@NotNull AIOMsgItem aIOMsgItem) {
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        if (com.tencent.qqnt.aio.msg.d.i(aIOMsgItem)) {
            return true;
        }
        AdelieActionBarElement a16 = com.tencent.qqnt.aio.msg.d.a(aIOMsgItem);
        if (a16 == null) {
            return false;
        }
        ArrayList<InlineKeyboardRow> arrayList = a16.rows;
        Intrinsics.checkNotNullExpressionValue(arrayList, "actionBarElement.rows");
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            ArrayList<InlineKeyboardButton> arrayList2 = ((InlineKeyboardRow) it.next()).buttons;
            Intrinsics.checkNotNullExpressionValue(arrayList2, "row.buttons");
            Iterator<T> it5 = arrayList2.iterator();
            while (it5.hasNext()) {
                if (((InlineKeyboardButton) it5.next()).type == 6) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final boolean p(@NotNull MsgRecord msgRecord) {
        MsgElement i3;
        Integer num;
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        if (!r(msgRecord) || (i3 = MsgExtKt.i(msgRecord, 6)) == null || (num = i3.faceElement.stickerType) == null || num.intValue() != 3) {
            return false;
        }
        return true;
    }

    public static final boolean q(@NotNull AIOMsgItem aIOMsgItem) {
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        return r(aIOMsgItem.getMsgRecord());
    }

    public static final boolean r(@NotNull MsgRecord msgRecord) {
        ArrayList<MsgElement> arrayList;
        MsgElement i3;
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        if (msgRecord.msgType != 2 || (arrayList = msgRecord.elements) == null || arrayList.size() != 1 || (i3 = MsgExtKt.i(msgRecord, 6)) == null) {
            return false;
        }
        Integer num = i3.faceElement.stickerType;
        if ((num != null && num.intValue() == 0) || TextUtils.isEmpty(i3.faceElement.packId) || TextUtils.isEmpty(i3.faceElement.stickerId)) {
            return false;
        }
        return true;
    }

    public static final boolean s(@NotNull AIOMsgItem aIOMsgItem) {
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        if (aIOMsgItem.getMsgRecord().anonymousExtInfo != null) {
            return true;
        }
        return false;
    }

    public static final boolean t(@NotNull AIOMsgItem aIOMsgItem) {
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        return u(aIOMsgItem.getMsgRecord());
    }

    public static final boolean u(@NotNull MsgRecord msgRecord) {
        ArrayList<MsgElement> elements;
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        if (msgRecord.msgType != 11 || (elements = msgRecord.elements) == null) {
            return false;
        }
        Intrinsics.checkNotNullExpressionValue(elements, "elements");
        Iterator<T> it = elements.iterator();
        while (it.hasNext()) {
            if (((MsgElement) it.next()).elementType != 10) {
                return false;
            }
        }
        return true;
    }

    public static final boolean v(@NotNull AIOMsgItem aIOMsgItem) {
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        if (!Z(aIOMsgItem) || (aIOMsgItem.getMsgRecord().subMsgType & 1024) != 1024) {
            return false;
        }
        return true;
    }

    public static final boolean w(@NotNull AIOMsgItem aIOMsgItem) {
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        if (c0(aIOMsgItem) && aIOMsgItem.p0() == 1) {
            return true;
        }
        return false;
    }

    public static final boolean x(@NotNull AIOMsgItem aIOMsgItem) {
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        return MsgExtKt.w(aIOMsgItem.getMsgRecord());
    }

    public static final boolean y(@NotNull AIOMsgItem aIOMsgItem) {
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        return z(aIOMsgItem.getMsgRecord());
    }

    public static final boolean z(@NotNull MsgRecord msgRecord) {
        ArrayList<MsgElement> arrayList;
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        if (msgRecord.msgType != 2 || (arrayList = msgRecord.elements) == null || arrayList.size() != 1) {
            return false;
        }
        ArrayList<MsgElement> elements = msgRecord.elements;
        Intrinsics.checkNotNullExpressionValue(elements, "elements");
        Iterator<T> it = elements.iterator();
        while (it.hasNext()) {
            if (((MsgElement) it.next()).elementType == 2 && ((msgRecord.subMsgType & 8192) >> 13) == 1) {
                return true;
            }
        }
        return false;
    }
}
