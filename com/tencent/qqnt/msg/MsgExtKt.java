package com.tencent.qqnt.msg;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zplan.show.IZPlanMsgService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.EmojiZPlan;
import com.tencent.qqnt.kernel.nativeinterface.FaceElement;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgAttributeInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.qqnt.kernel.nativeinterface.QQConnectAttr;
import com.tencent.qqnt.kernel.nativeinterface.SendMsgRspTransSvrInfoAttr;
import com.tencent.qqnt.kernel.nativeinterface.TextElement;
import com.tencent.qqnt.kernel.nativeinterface.ZPlanMsgElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.msg.ExtBufForUI$ExtData;
import tencent.im.msg.ExtBufForUI$MsgReply;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0005*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u000e\u0010\b\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0003\u001a\n\u0010\n\u001a\u00020\u0001*\u00020\t\u001a\n\u0010\u000b\u001a\u00020\u0001*\u00020\t\u001a\u0012\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f*\u00020\u0000\u001a\n\u0010\u000e\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u000f\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0010\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0011\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0012\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0013\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0014\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0015\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0017\u001a\u00020\u0001*\u00020\u0016\u001a\n\u0010\u0018\u001a\u00020\u0001*\u00020\u0016\u001a\n\u0010\u0019\u001a\u00020\u0001*\u00020\u0016\u001a\n\u0010\u001a\u001a\u00020\u0001*\u00020\u0016\u001a\n\u0010\u001b\u001a\u00020\u0001*\u00020\u0016\u001a\n\u0010\u001c\u001a\u00020\u0001*\u00020\u0016\u001a\n\u0010\u001d\u001a\u00020\u0001*\u00020\u0016\u001a\u000e\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u0003\u001a\u0012\u0010\"\u001a\u00020\u0001*\u00020\u00002\u0006\u0010!\u001a\u00020 \u001a\n\u0010#\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010$\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010%\u001a\u00020\u0001*\u00020\u0000\u001a\u0012\u0010&\u001a\u00020\u0001*\u00020\u00002\u0006\u0010!\u001a\u00020 \u001a\n\u0010'\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010(\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010)\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010*\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010+\u001a\u00020\u0001*\u00020\u0000\u001a\u0012\u0010,\u001a\u00020\u0001*\u00020\u00002\u0006\u0010!\u001a\u00020 \u001a\n\u0010-\u001a\u00020 *\u00020\u0000\u001a&\u00101\u001a\b\u0012\u0004\u0012\u00020 0\f2\u0016\u00100\u001a\u0012\u0012\u0004\u0012\u00020\u00050.j\b\u0012\u0004\u0012\u00020\u0005`/H\u0002\u001a\n\u00102\u001a\u00020\u0001*\u00020\u0000\u001a\n\u00103\u001a\u00020\u0001*\u00020\u0000\u001a*\u0010:\u001a\u000206*\u00020\u00002\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u000206042\n\b\u0002\u00109\u001a\u0004\u0018\u000108\u001a\f\u0010;\u001a\u0004\u0018\u000105*\u00020\u0000\u001a\n\u0010<\u001a\u00020\u0001*\u00020\u0000\u001a\u0012\u0010>\u001a\u000206*\u00020\u00002\u0006\u0010=\u001a\u00020\u0001\u001a\u0012\u0010@\u001a\u00020\u0001*\u00020\u00002\u0006\u0010?\u001a\u00020\u0001\u001a\n\u0010A\u001a\u00020\u0001*\u00020\u0000\u001a\u0012\u0010B\u001a\u00020\u0001*\u00020\u00002\u0006\u0010?\u001a\u00020\u0001\u001a\n\u0010C\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010D\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010E\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010G\u001a\u00020\u0001*\u00020F\u001a\n\u0010H\u001a\u00020\u0001*\u00020\u0000\u001a\f\u0010J\u001a\u0004\u0018\u00010I*\u00020\u0000\u001a\f\u0010L\u001a\u0004\u0018\u00010K*\u00020\u0000\u001a\n\u0010M\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010N\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010O\u001a\u00020 *\u00020\u0000\"\u0015\u0010R\u001a\u00020 *\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\bP\u0010Q\u00a8\u0006S"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "", ExifInterface.LATITUDE_SOUTH, "", "type", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "i", "viewType", "T", "Lcom/tencent/qqnt/msg/d;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "K", "", tl.h.F, "M", "Y", BdhLogUtil.LogTag.Tag_Req, "y", "Z", "L", "X", "w", "Lcom/tencent/qqnt/kernel/nativeinterface/PicElement;", HippyTKDListViewAdapter.X, "r", "d", "a0", ReportConstant.COSTREPORT_PREFIX, "o", "u", "picSubType", "v", "", "selfTinyId", "E", "V", "D", "G", UserInfo.SEX_FEMALE, "U", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "W", BdhLogUtil.LogTag.Tag_Conn, "g", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", DTParamKey.REPORT_KEY_VISUAL_ELEMENTS, "f", "P", "t", "Lkotlin/Function1;", "Ltencent/im/msg/ExtBufForUI$ExtData;", "", "op", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "cb", "c0", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "hasReply", "e0", "isUserOnline", "e", "c", "b", "H", "I", "J", "Lcom/tencent/qqnt/kernel/nativeinterface/FaceElement;", "N", "O", "Lcom/tencent/qqnt/kernel/nativeinterface/QQConnectAttr;", "k", "Lcom/tencent/qqnt/kernel/nativeinterface/SendMsgRspTransSvrInfoAttr;", "l", "B", "b0", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/qqnt/msg/d;)Ljava/lang/String;", "senderUid", "msg_api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class MsgExtKt {
    public static final boolean A(@NotNull MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        if (msgRecord.msgType != 1) {
            return true;
        }
        return false;
    }

    public static final boolean B(@NotNull MsgRecord msgRecord) {
        Integer fileGroupSize;
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        if (msgRecord.chatType == 8 && (fileGroupSize = msgRecord.fileGroupSize) != null) {
            Intrinsics.checkNotNullExpressionValue(fileGroupSize, "fileGroupSize");
            if (fileGroupSize.intValue() >= 4) {
                return true;
            }
        }
        return false;
    }

    public static final boolean C(@NotNull MsgRecord msgRecord, @NotNull String selfTinyId) {
        boolean z16;
        List<MsgElement> h16;
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        Intrinsics.checkNotNullParameter(selfTinyId, "selfTinyId");
        if (selfTinyId.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && msgRecord.msgType == 11 && (h16 = h(msgRecord)) != null) {
            h16.isEmpty();
            if (h16.get(0).textGiftElement != null && Intrinsics.areEqual(String.valueOf(h16.get(0).textGiftElement.receiverUin), selfTinyId)) {
                return true;
            }
            if (h16.get(0).liveGiftElement != null && Intrinsics.areEqual(h16.get(0).liveGiftElement.kStrReceiverTinyId, selfTinyId)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean D(@NotNull MsgRecord msgRecord) {
        boolean z16;
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        ArrayList<MsgElement> arrayList = msgRecord.elements;
        boolean z17 = false;
        if (arrayList == null) {
            return false;
        }
        arrayList.isEmpty();
        ArrayList<MsgElement> elements = msgRecord.elements;
        Intrinsics.checkNotNullExpressionValue(elements, "elements");
        if (!(elements instanceof Collection) || !elements.isEmpty()) {
            Iterator<T> it = elements.iterator();
            while (it.hasNext()) {
                TextElement textElement = ((MsgElement) it.next()).textElement;
                if (textElement != null && textElement.atType == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            }
        }
        z17 = true;
        return !z17;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0060 A[EDGE_INSN: B:27:0x0060->B:8:0x0060 BREAK  A[LOOP:0: B:12:0x002d->B:28:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[LOOP:0: B:12:0x002d->B:28:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean E(@NotNull MsgRecord msgRecord, @NotNull String selfTinyId) {
        boolean z16;
        boolean z17;
        Long l3;
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        Intrinsics.checkNotNullParameter(selfTinyId, "selfTinyId");
        ArrayList<MsgElement> arrayList = msgRecord.elements;
        boolean z18 = false;
        if (arrayList == null) {
            return false;
        }
        arrayList.isEmpty();
        ArrayList<MsgElement> elements = msgRecord.elements;
        Intrinsics.checkNotNullExpressionValue(elements, "elements");
        if (!(elements instanceof Collection) || !elements.isEmpty()) {
            Iterator<T> it = elements.iterator();
            while (it.hasNext()) {
                TextElement textElement = ((MsgElement) it.next()).textElement;
                if (textElement != null && textElement.atType == 2) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    if (textElement != null) {
                        l3 = Long.valueOf(textElement.atTinyId);
                    } else {
                        l3 = null;
                    }
                    if (Intrinsics.areEqual(String.valueOf(l3), selfTinyId)) {
                        z17 = true;
                        if (!z17) {
                            break;
                        }
                    }
                }
                z17 = false;
                if (!z17) {
                }
            }
        }
        z18 = true;
        return !z18;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0055, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(java.lang.String.valueOf(r4), r8) == false) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006e A[EDGE_INSN: B:28:0x006e->B:10:0x006e BREAK  A[LOOP:0: B:13:0x0029->B:29:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[LOOP:0: B:13:0x0029->B:29:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean F(@NotNull MsgRecord msgRecord, @NotNull String selfTinyId) {
        boolean z16;
        boolean z17;
        boolean z18;
        Long l3;
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        Intrinsics.checkNotNullParameter(selfTinyId, "selfTinyId");
        ArrayList<MsgElement> elements = msgRecord.elements;
        boolean z19 = false;
        if (elements == null) {
            return false;
        }
        Intrinsics.checkNotNullExpressionValue(elements, "elements");
        if (!(elements instanceof Collection) || !elements.isEmpty()) {
            for (MsgElement msgElement : elements) {
                TextElement textElement = msgElement.textElement;
                if (textElement != null && textElement.atType == 2) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    if (textElement != null) {
                        l3 = Long.valueOf(textElement.atTinyId);
                    } else {
                        l3 = null;
                    }
                }
                TextElement textElement2 = msgElement.textElement;
                if (textElement2 != null && textElement2.atType == 1) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z17 || msgRecord.sendStatus == 4) {
                    z18 = false;
                    if (!z18) {
                        break;
                    }
                }
                z18 = true;
                if (!z18) {
                }
            }
        }
        z19 = true;
        return !z19;
    }

    public static final boolean G(@NotNull MsgRecord msgRecord) {
        boolean z16;
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        ArrayList<MsgElement> arrayList = msgRecord.elements;
        if (arrayList == null) {
            return false;
        }
        arrayList.isEmpty();
        ArrayList<MsgElement> elements = msgRecord.elements;
        Intrinsics.checkNotNullExpressionValue(elements, "elements");
        if ((elements instanceof Collection) && elements.isEmpty()) {
            return false;
        }
        Iterator<T> it = elements.iterator();
        while (it.hasNext()) {
            TextElement textElement = ((MsgElement) it.next()).textElement;
            if (textElement != null && textElement.atType == 64) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return true;
            }
        }
        return false;
    }

    public static final boolean H(@NotNull MsgRecord msgRecord) {
        boolean z16;
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        ArrayList<MsgElement> arrayList = msgRecord.elements;
        if (arrayList == null) {
            return false;
        }
        arrayList.isEmpty();
        ArrayList<MsgElement> elements = msgRecord.elements;
        Intrinsics.checkNotNullExpressionValue(elements, "elements");
        if ((elements instanceof Collection) && elements.isEmpty()) {
            return false;
        }
        Iterator<T> it = elements.iterator();
        while (it.hasNext()) {
            TextElement textElement = ((MsgElement) it.next()).textElement;
            if (textElement != null && textElement.atType == 32) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return true;
            }
        }
        return false;
    }

    public static final boolean I(@NotNull MsgRecord msgRecord) {
        boolean z16;
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        ArrayList<MsgElement> arrayList = msgRecord.elements;
        if (arrayList == null) {
            return false;
        }
        arrayList.isEmpty();
        ArrayList<MsgElement> elements = msgRecord.elements;
        Intrinsics.checkNotNullExpressionValue(elements, "elements");
        if ((elements instanceof Collection) && elements.isEmpty()) {
            return false;
        }
        Iterator<T> it = elements.iterator();
        while (it.hasNext()) {
            TextElement textElement = ((MsgElement) it.next()).textElement;
            if (textElement != null && textElement.atType == 128) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return true;
            }
        }
        return false;
    }

    public static final boolean J(@NotNull MsgRecord msgRecord) {
        boolean z16;
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        ArrayList<MsgElement> arrayList = msgRecord.elements;
        if (arrayList == null) {
            return false;
        }
        arrayList.isEmpty();
        ArrayList<MsgElement> elements = msgRecord.elements;
        Intrinsics.checkNotNullExpressionValue(elements, "elements");
        if ((elements instanceof Collection) && elements.isEmpty()) {
            return false;
        }
        Iterator<T> it = elements.iterator();
        while (it.hasNext()) {
            TextElement textElement = ((MsgElement) it.next()).textElement;
            if (textElement != null && textElement.atType == 256) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return true;
            }
        }
        return false;
    }

    public static final boolean K(@NotNull d dVar) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(dVar, "<this>");
        if (dVar.a().msgType != 5) {
            return false;
        }
        ArrayList<MsgElement> arrayList = dVar.a().elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msgRecord.elements");
        if (!(arrayList instanceof Collection) || !arrayList.isEmpty()) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                if (((MsgElement) it.next()).elementType == 23) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    z17 = true;
                    break;
                }
            }
        }
        z17 = false;
        if (!z17) {
            return false;
        }
        return true;
    }

    public static final boolean L(@NotNull MsgRecord msgRecord) {
        FileElement fileElement;
        Integer num;
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        if (!w(msgRecord)) {
            return false;
        }
        MsgElement i3 = i(msgRecord, 3);
        if (i3 != null) {
            fileElement = i3.fileElement;
        } else {
            fileElement = null;
        }
        if (fileElement == null || (num = fileElement.subElementType) == null || num.intValue() != 1) {
            return false;
        }
        return true;
    }

    public static final boolean M(@NotNull MsgRecord msgRecord) {
        List<MsgElement> h16;
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        if (msgRecord.msgType != 2 || (h16 = h(msgRecord)) == null || h16.size() != 1 || h16.get(0).elementType != 2) {
            return false;
        }
        return true;
    }

    public static final boolean N(@NotNull FaceElement faceElement) {
        Intrinsics.checkNotNullParameter(faceElement, "<this>");
        if (faceElement.faceType == 5) {
            return true;
        }
        return false;
    }

    public static final boolean O(@NotNull MsgRecord msgRecord) {
        MsgElement i3;
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        if (msgRecord.msgType != 2 || msgRecord.elements.isEmpty() || (i3 = i(msgRecord, 6)) == null) {
            return false;
        }
        FaceElement faceElement = i3.faceElement;
        Intrinsics.checkNotNullExpressionValue(faceElement, "msgElement.faceElement");
        return N(faceElement);
    }

    public static final boolean P(@NotNull MsgRecord msgRecord) {
        ArrayList<MsgElement> elements;
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        int i3 = msgRecord.msgType;
        if ((i3 != 2 && i3 != 9 && i3 != 7 && i3 != 2 && i3 != 3 && i3 != 10 && i3 != 11 && i3 != 17 && i3 != 6) || (elements = msgRecord.elements) == null) {
            return false;
        }
        Intrinsics.checkNotNullExpressionValue(elements, "elements");
        Iterator<T> it = elements.iterator();
        while (it.hasNext()) {
            int i16 = ((MsgElement) it.next()).elementType;
            if (i16 != 6 && i16 != 1 && i16 != 7 && i16 != 5 && i16 != 2 && i16 != 14 && i16 != 17 && i16 != 3 && i16 != 9 && i16 != 10 && i16 != 11 && i16 != 4) {
                return false;
            }
        }
        return true;
    }

    public static final boolean Q(@NotNull d dVar) {
        ArrayList<MsgElement> arrayList;
        boolean z16;
        Intrinsics.checkNotNullParameter(dVar, "<this>");
        if (dVar.a().msgType != 5 || (arrayList = dVar.a().elements) == null || arrayList.isEmpty()) {
            return false;
        }
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            if (((MsgElement) it.next()).grayTipElement != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return true;
            }
        }
        return false;
    }

    public static final boolean R(@NotNull MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        int i3 = msgRecord.sendType;
        if (i3 != 3 && i3 != 6 && U(msgRecord)) {
            return true;
        }
        return false;
    }

    public static final boolean S(@NotNull MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        int i3 = msgRecord.sendType;
        if (i3 == 1 || i3 == 2 || i3 == 4 || TextUtils.equals(MobileQQ.sMobileQQ.waitAppRuntime().getCurrentUid(), msgRecord.senderUid)) {
            return true;
        }
        return false;
    }

    public static final boolean T(int i3) {
        if (i3 != 3 && i3 != 60 && i3 != 62 && i3 != 9 && i3 != 11 && i3 != 13 && i3 != 0 && i3 != 5 && i3 != 96 && i3 != 97 && i3 != 7 && i3 != 19 && i3 != 22 && i3 != 24 && i3 != 34 && i3 != 43 && i3 != 45 && i3 != 31 && i3 != 88) {
            return false;
        }
        return true;
    }

    public static final boolean U(@NotNull MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        if (msgRecord.sendStatus == 2) {
            return true;
        }
        return false;
    }

    public static final boolean V(@NotNull MsgRecord msgRecord) {
        Integer num;
        boolean z16;
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        ArrayList<MsgElement> arrayList = msgRecord.elements;
        if (arrayList == null) {
            return false;
        }
        arrayList.isEmpty();
        ArrayList<MsgElement> elements = msgRecord.elements;
        Intrinsics.checkNotNullExpressionValue(elements, "elements");
        if ((elements instanceof Collection) && elements.isEmpty()) {
            return false;
        }
        Iterator<T> it = elements.iterator();
        while (it.hasNext()) {
            TextElement textElement = ((MsgElement) it.next()).textElement;
            if (textElement != null) {
                num = Integer.valueOf(textElement.atType);
            } else {
                num = null;
            }
            if ((num == null || num.intValue() != 32) && ((num == null || num.intValue() != 128) && (num == null || num.intValue() != 256))) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return true;
            }
        }
        return false;
    }

    public static final boolean W(@NotNull MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        return false;
    }

    public static final boolean X(@NotNull MsgRecord msgRecord) {
        FileElement fileElement;
        Integer num;
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        if (!w(msgRecord)) {
            return false;
        }
        MsgElement i3 = i(msgRecord, 3);
        if (i3 != null) {
            fileElement = i3.fileElement;
        } else {
            fileElement = null;
        }
        if (fileElement == null || (num = fileElement.subElementType) == null || num.intValue() != 2) {
            return false;
        }
        return true;
    }

    public static final boolean Y(@NotNull MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        if (msgRecord.msgType != 7) {
            return false;
        }
        Iterator<MsgElement> it = msgRecord.elements.iterator();
        while (it.hasNext()) {
            MsgElement next = it.next();
            if (next.elementType == 5) {
                if (next.videoElement == null) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public static final boolean Z(@NotNull MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        if (msgRecord.msgType == 10) {
            return true;
        }
        return false;
    }

    public static final boolean a0(@NotNull PicElement picElement) {
        Intrinsics.checkNotNullParameter(picElement, "<this>");
        EmojiZPlan emojiZPlan = picElement.emojiZplan;
        if (emojiZPlan != null && emojiZPlan.actionId != 0) {
            return true;
        }
        return false;
    }

    public static final boolean b(@NotNull MsgRecord msgRecord, boolean z16) {
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        if (z16 && G(msgRecord)) {
            return true;
        }
        return false;
    }

    public static final boolean b0(@NotNull MsgRecord msgRecord) {
        ZPlanMsgElement zPlanMsgElement;
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        if (msgRecord.msgType != 2 || i(msgRecord, 1) == null) {
            return false;
        }
        MsgAttributeInfo msgAttributeInfo = msgRecord.msgAttrs.get(11);
        if (msgAttributeInfo != null) {
            zPlanMsgElement = msgAttributeInfo.zPlanMsgInfo;
        } else {
            zPlanMsgElement = null;
        }
        if (zPlanMsgElement == null) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0058 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[LOOP:0: B:10:0x0025->B:31:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean c(@NotNull MsgRecord msgRecord) {
        boolean z16;
        boolean z17;
        boolean z18;
        Integer num;
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        ArrayList<MsgElement> arrayList = msgRecord.elements;
        if (arrayList == null) {
            return false;
        }
        arrayList.isEmpty();
        ArrayList<MsgElement> elements = msgRecord.elements;
        Intrinsics.checkNotNullExpressionValue(elements, "elements");
        if ((elements instanceof Collection) && elements.isEmpty()) {
            return false;
        }
        Iterator<T> it = elements.iterator();
        while (it.hasNext()) {
            TextElement textElement = ((MsgElement) it.next()).textElement;
            if (textElement != null && textElement.atType == 8) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                if (textElement != null && (num = textElement.needNotify) != null && num.intValue() == 1) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18) {
                    z17 = true;
                    if (!z17) {
                        return true;
                    }
                }
            }
            z17 = false;
            if (!z17) {
            }
        }
        return false;
    }

    public static final void c0(@NotNull MsgRecord msgRecord, @NotNull Function1<? super ExtBufForUI$ExtData, Unit> op5, @Nullable IOperateCallback iOperateCallback) {
        int i3;
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        Intrinsics.checkNotNullParameter(op5, "op");
        ExtBufForUI$ExtData extBufForUI$ExtData = new ExtBufForUI$ExtData();
        int i16 = -1;
        try {
            byte[] bArr = msgRecord.extInfoForUI;
            if (bArr != null) {
                extBufForUI$ExtData.mergeFrom(bArr);
            }
        } catch (Throwable th5) {
            long j3 = msgRecord.msgId;
            byte[] bArr2 = msgRecord.extInfoForUI;
            if (bArr2 != null) {
                i3 = bArr2.length;
            } else {
                i3 = -1;
            }
            QLog.e("MsgExt", 1, "MsgRecord[updateMsgLocalExt] merge err. msgId=" + j3 + ", bufSize=" + i3 + ", e=", th5);
        }
        try {
            op5.invoke(extBufForUI$ExtData);
            w e16 = f.e();
            if (e16 != null) {
                Contact contact = new Contact(msgRecord.chatType, msgRecord.peerUid, msgRecord.guildId);
                long j16 = msgRecord.msgId;
                byte[] byteArray = extBufForUI$ExtData.toByteArray();
                Intrinsics.checkNotNullExpressionValue(byteArray, "ext.toByteArray()");
                e16.updateMsgRecordExtPbBufForUI(contact, j16, byteArray, iOperateCallback);
            }
        } catch (Throwable th6) {
            long j17 = msgRecord.msgId;
            byte[] bArr3 = msgRecord.extInfoForUI;
            if (bArr3 != null) {
                i16 = bArr3.length;
            }
            QLog.e("MsgExt", 1, "MsgRecord[updateMsgLocalExt] write err. msgId=" + j17 + ", bufSize=" + i16 + ", e=", th6);
        }
    }

    public static final boolean d(@NotNull PicElement picElement) {
        Intrinsics.checkNotNullParameter(picElement, "<this>");
        if (!a0(picElement) && !o(picElement)) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ void d0(MsgRecord msgRecord, Function1 function1, IOperateCallback iOperateCallback, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            iOperateCallback = null;
        }
        c0(msgRecord, function1, iOperateCallback);
    }

    public static final boolean e(@NotNull MsgRecord msgRecord, boolean z16) {
        boolean z17;
        Integer num;
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        ArrayList<MsgElement> arrayList = msgRecord.elements;
        if (arrayList == null) {
            return false;
        }
        arrayList.isEmpty();
        ArrayList<MsgElement> elements = msgRecord.elements;
        Intrinsics.checkNotNullExpressionValue(elements, "elements");
        if ((elements instanceof Collection) && elements.isEmpty()) {
            return false;
        }
        for (MsgElement msgElement : elements) {
            if ((msgRecord.atType == 256 && (num = msgElement.textElement.needNotify) != null && num.intValue() == 1) || ((z16 && msgRecord.atType == 128) || msgRecord.atType == 32)) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                return true;
            }
        }
        return false;
    }

    public static final void e0(@NotNull final MsgRecord msgRecord, final boolean z16) {
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.msg.h
            @Override // java.lang.Runnable
            public final void run() {
                MsgExtKt.f0(MsgRecord.this, z16);
            }
        }, 64, null, false);
    }

    private static final List<String> f(ArrayList<MsgElement> arrayList) {
        int collectionSizeOrDefault;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        for (MsgElement msgElement : arrayList) {
            StringBuilder sb5 = new StringBuilder();
            Field[] declaredFields = msgElement.getClass().getDeclaredFields();
            Intrinsics.checkNotNullExpressionValue(declaredFields, "elem.javaClass.declaredFields");
            for (Field field : declaredFields) {
                try {
                    field.setAccessible(true);
                    Object obj = field.get(msgElement);
                    if (obj != null) {
                        Intrinsics.checkNotNullExpressionValue(obj, "get(elem)");
                        sb5.append(" ");
                        sb5.append(field.getName());
                        sb5.append(":");
                        sb5.append(obj);
                    }
                } catch (Exception unused) {
                }
            }
            arrayList2.add(sb5.toString());
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(MsgRecord this_updateMsgReply, final boolean z16) {
        Intrinsics.checkNotNullParameter(this_updateMsgReply, "$this_updateMsgReply");
        d0(this_updateMsgReply, new Function1<ExtBufForUI$ExtData, Unit>(z16) { // from class: com.tencent.qqnt.msg.MsgExtKt$updateMsgReply$1$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ boolean $hasReply;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$hasReply = z16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, z16);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ExtBufForUI$ExtData extBufForUI$ExtData) {
                invoke2(extBufForUI$ExtData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ExtBufForUI$ExtData it) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                Intrinsics.checkNotNullParameter(it, "it");
                ExtBufForUI$MsgReply extBufForUI$MsgReply = new ExtBufForUI$MsgReply();
                extBufForUI$MsgReply.msgHasReply.set(this.$hasReply);
                it.msgReply.set(extBufForUI$MsgReply);
            }
        }, null, 2, null);
    }

    @NotNull
    public static final String g(@NotNull MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        int i3 = msgRecord.msgType;
        int i16 = msgRecord.subMsgType;
        long j3 = msgRecord.msgSeq;
        long j16 = msgRecord.msgId;
        String str = msgRecord.senderUid;
        String str2 = msgRecord.guildId;
        String str3 = msgRecord.channelId;
        ArrayList<MsgElement> arrayList = msgRecord.elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "this.elements");
        return "type:" + i3 + " subType:" + i16 + " seq:" + j3 + "  id:" + j16 + " \n tinyId:" + str + "\n guildId:" + str2 + "\n channelId:" + str3 + "\n element:" + f(arrayList) + " \n.";
    }

    @Nullable
    public static final List<MsgElement> h(@NotNull MsgRecord msgRecord) {
        boolean z16;
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        ArrayList<MsgElement> arrayList = msgRecord.elements;
        if (arrayList != null) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                int i3 = ((MsgElement) obj).elementType;
                if (i3 != 43 && i3 != 44) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    arrayList2.add(obj);
                }
            }
            return arrayList2;
        }
        return null;
    }

    @Nullable
    public static final MsgElement i(@NotNull MsgRecord msgRecord, int i3) {
        boolean z16;
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        ArrayList<MsgElement> elements = msgRecord.elements;
        Object obj = null;
        if (elements.isEmpty()) {
            return null;
        }
        Intrinsics.checkNotNullExpressionValue(elements, "elements");
        Iterator<T> it = elements.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((MsgElement) next).elementType == i3) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                obj = next;
                break;
            }
        }
        return (MsgElement) obj;
    }

    @Nullable
    public static final ExtBufForUI$ExtData j(@NotNull MsgRecord msgRecord) {
        boolean z16;
        int i3;
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        byte[] bArr = msgRecord.extInfoForUI;
        if (bArr != null) {
            Intrinsics.checkNotNull(bArr);
            if (bArr.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                try {
                    ExtBufForUI$ExtData extBufForUI$ExtData = new ExtBufForUI$ExtData();
                    extBufForUI$ExtData.mergeFrom(msgRecord.extInfoForUI);
                    return extBufForUI$ExtData;
                } catch (Throwable th5) {
                    long j3 = msgRecord.msgId;
                    byte[] bArr2 = msgRecord.extInfoForUI;
                    if (bArr2 != null) {
                        i3 = bArr2.length;
                    } else {
                        i3 = -1;
                    }
                    QLog.e("MsgExt", 1, "MsgRecord[getMsgLocalExt] merge err. msgId=" + j3 + ", bufSize=" + i3 + ", e=", th5);
                }
            }
        }
        return null;
    }

    @Nullable
    public static final QQConnectAttr k(@NotNull MsgRecord msgRecord) {
        MsgAttributeInfo msgAttributeInfo;
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        if (msgRecord.elements.isEmpty() || i(msgRecord, 2) == null || (msgAttributeInfo = msgRecord.msgAttrs.get(12)) == null) {
            return null;
        }
        return msgAttributeInfo.qqConnectAttr;
    }

    @Nullable
    public static final SendMsgRspTransSvrInfoAttr l(@NotNull MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        MsgAttributeInfo msgAttributeInfo = msgRecord.msgAttrs.get(15);
        if (msgAttributeInfo != null) {
            return msgAttributeInfo.sendMsgRspTransSvrInfo;
        }
        return null;
    }

    @NotNull
    public static final String m(@NotNull d dVar) {
        Intrinsics.checkNotNullParameter(dVar, "<this>");
        String str = dVar.a().senderUid;
        Intrinsics.checkNotNullExpressionValue(str, "msgRecord.senderUid");
        return str;
    }

    @NotNull
    public static final String n(@NotNull MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        MsgElement i3 = i(msgRecord, 1);
        if (i3 == null) {
            return "";
        }
        return IZPlanMsgService.ZPLAN_MSG_PREFIX + i3.textElement.content;
    }

    public static final boolean o(@NotNull PicElement picElement) {
        Intrinsics.checkNotNullParameter(picElement, "<this>");
        if (picElement.picSubType == 14) {
            return true;
        }
        return false;
    }

    public static final boolean p(@NotNull MsgRecord msgRecord) {
        ArrayList<MsgElement> arrayList;
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        if (msgRecord.msgType != 16 || (arrayList = msgRecord.elements) == null || arrayList.size() < 1 || i(msgRecord, 19) == null) {
            return false;
        }
        return true;
    }

    public static final boolean q(@NotNull MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        if (p(msgRecord) && msgRecord.subMsgType == 1) {
            return true;
        }
        return false;
    }

    public static final boolean r(@NotNull PicElement picElement) {
        Intrinsics.checkNotNullParameter(picElement, "<this>");
        if (u(picElement) && !d(picElement)) {
            return true;
        }
        return false;
    }

    public static final boolean s(@NotNull PicElement picElement) {
        Integer num;
        Intrinsics.checkNotNullParameter(picElement, "<this>");
        if (picElement.picSubType == 13 && (num = picElement.picSubSubType) != null && num.intValue() == 2) {
            return true;
        }
        return false;
    }

    public static final boolean t(@NotNull MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        if (msgRecord.directMsgFlag == 1) {
            return true;
        }
        return false;
    }

    public static final boolean u(@NotNull PicElement picElement) {
        boolean z16;
        boolean endsWith$default;
        Intrinsics.checkNotNullParameter(picElement, "<this>");
        if (x(picElement)) {
            return true;
        }
        String str = picElement.fileName;
        if (str != null) {
            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(str, QzoneEmotionUtils.SIGN_ICON_URL_END, false, 2, null);
            if (endsWith$default) {
                z16 = true;
                if (z16 && !v(picElement.picSubType)) {
                    return false;
                }
            }
        }
        z16 = false;
        return z16 ? true : true;
    }

    public static final boolean v(int i3) {
        if (i3 == 1 || i3 == 2 || i3 == 3 || i3 == 4 || i3 == 5 || i3 == 7 || i3 == 8 || i3 == 9 || i3 == 10 || i3 == 11 || i3 == 12 || i3 == 13 || i3 == 14) {
            return true;
        }
        return false;
    }

    public static final boolean w(@NotNull MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        if (msgRecord.msgType == 3) {
            return true;
        }
        return false;
    }

    public static final boolean x(@NotNull PicElement picElement) {
        Integer num;
        Intrinsics.checkNotNullParameter(picElement, "<this>");
        Integer num2 = picElement.picType;
        if ((num2 == null || num2.intValue() != 2000) && ((num = picElement.picType) == null || num.intValue() != 2)) {
            return false;
        }
        return true;
    }

    public static final boolean y(@NotNull MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        if (msgRecord.msgType == 2) {
            return true;
        }
        return false;
    }

    public static final boolean z(@NotNull MsgRecord msgRecord) {
        ExtBufForUI$MsgReply extBufForUI$MsgReply;
        PBBoolField pBBoolField;
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        ExtBufForUI$ExtData j3 = j(msgRecord);
        if (j3 != null && (extBufForUI$MsgReply = j3.msgReply) != null && (pBBoolField = extBufForUI$MsgReply.msgHasReply) != null) {
            return pBBoolField.get();
        }
        return false;
    }
}
