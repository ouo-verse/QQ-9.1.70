package com.tencent.qqnt.aio.msg;

import android.text.TextUtils;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.msg.element.AIOElementType;
import com.tencent.qqnt.kernel.nativeinterface.AdelieActionBarElement;
import com.tencent.qqnt.kernel.nativeinterface.AdelieMsgAttr;
import com.tencent.qqnt.kernel.nativeinterface.AdelieRecommendedMsgElement;
import com.tencent.qqnt.kernel.nativeinterface.FeedBackStateInfo;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.InlineKeyboardButton;
import com.tencent.qqnt.kernel.nativeinterface.InlineKeyboardRow;
import com.tencent.qqnt.kernel.nativeinterface.MemoryStateMsgInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgAttributeInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgEmojiLikes;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.PrologueMsgElement;
import com.tencent.qqnt.kernel.nativeinterface.SendMsgRspTransSvrInfoAttr;
import com.tencent.qqnt.kernel.nativeinterface.TransSvrInfo;
import com.tencent.qqnt.kernel.nativeinterface.VASAIOPersonalElement;
import com.tencent.qqnt.kernel.nativeinterface.VASMsgAvatarPendant;
import com.tencent.qqnt.kernel.nativeinterface.VASMsgBubble;
import com.tencent.qqnt.kernel.nativeinterface.VASMsgElement;
import com.tencent.qqnt.kernel.nativeinterface.VASMsgFont;
import com.tencent.qqnt.kernel.nativeinterface.VASPersonalNamePlate;
import com.tencent.qqnt.kernel.nativeinterface.VASPersonalVipNumberInfo;
import com.tencent.qqnt.msg.MsgExtKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0012\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0012\u0010\u0004\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0012\u0010\u0005\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0012\u0010\u0006\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0012\u0010\u0007\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0012\u0010\t\u001a\u00020\u0002*\u00020\b2\u0006\u0010\u0001\u001a\u00020\b\u001a\u0012\u0010\n\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0012\u0010\u000b\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0012\u0010\f\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0012\u0010\r\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0012\u0010\u000e\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u001c\u0010\u0011\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fH\u0002\u001a\u0012\u0010\u0012\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0012\u0010\u0013\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0012\u0010\u0014\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0012\u0010\u0015\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000\u001a\f\u0010\u0017\u001a\u0004\u0018\u00010\u0016*\u00020\u0000\u001a\"\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a*\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u001a\n\u0010\u001d\u001a\u00020\u0002*\u00020\u0000\u001a\n\u0010\u001e\u001a\u00020\u0002*\u00020\u0000\u001a\u0012\u0010\u001f\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0012\u0010 \u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0014\u0010!\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0002\u001a\u0014\u0010\"\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0002\u001a\u0012\u0010#\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0012\u0010$\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0012\u0010%\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000\u001a\n\u0010'\u001a\u00020\u0002*\u00020&\u001a\n\u0010(\u001a\u00020\u0002*\u00020\u0000\u001a\n\u0010)\u001a\u00020\u0002*\u00020\u0000\u001a\n\u0010*\u001a\u00020\u0002*\u00020\u0000\u001a\f\u0010,\u001a\u0004\u0018\u00010+*\u00020\u0000\u001a\n\u0010-\u001a\u00020\u000f*\u00020+\u001a\u0012\u0010.\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0012\u0010/\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000\u001a\n\u00100\u001a\u00020\u000f*\u00020&\u001a\u0012\u00102\u001a\u00020\u0002*\u00020\u00002\u0006\u00101\u001a\u00020\u0000\u001a\u0010\u00105\u001a\b\u0012\u0004\u0012\u00020403*\u00020\u0000\u001a\f\u00107\u001a\u0004\u0018\u000106*\u00020\u0000\"\u0015\u0010:\u001a\u00020\u000f*\u00020&8F\u00a2\u0006\u0006\u001a\u0004\b8\u00109\"\u0015\u0010:\u001a\u00020\u000f*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b;\u0010<\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "other", "", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, ReportConstant.COSTREPORT_PREFIX, "w", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/qqnt/kernel/nativeinterface/MsgEmojiLikes;", "l", "D", HippyTKDListViewAdapter.X, "B", "G", "H", "", "appid", "J", "t", UserInfo.SEX_FEMALE, BdhLogUtil.LogTag.Tag_Conn, "v", "Lcom/tencent/qqnt/kernel/nativeinterface/AdelieActionBarElement;", "a", "", "content", "Ljava/util/HashMap;", "Lcom/tencent/qqnt/kernel/nativeinterface/InlineKeyboardButton;", "b", "i", "j", "y", DomainData.DOMAIN_NAME, "u", "r", "I", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "o", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "N", "M", "K", "L", "Lcom/tencent/qqnt/kernel/nativeinterface/AdelieRecommendedMsgElement;", "e", "f", "E", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "c", "oldMsgItem", "k", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/aio/msg/element/AIOElementType$MultiPicElement;", "O", "Lcom/tencent/qqnt/kernel/nativeinterface/PrologueMsgElement;", "d", h.F, "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)I", "streamStatus", "g", "(Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;)I", "aio_api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class d {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class a<T> implements Comparator {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b) t16).a()), Integer.valueOf(((com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b) t17).a()));
                return compareValues;
            }
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) t16, (Object) t17)).intValue();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class b<T> implements Comparator {
        static IPatchRedirector $redirector_;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b) t16).a()), Integer.valueOf(((com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b) t17).a()));
                return compareValues;
            }
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) t16, (Object) t17)).intValue();
        }
    }

    public static final boolean A(@NotNull AIOMsgItem aIOMsgItem, @NotNull AIOMsgItem other) {
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        ArrayList<MsgEmojiLikes> arrayList = aIOMsgItem.getMsgRecord().emojiLikesList;
        ArrayList<MsgEmojiLikes> arrayList2 = other.getMsgRecord().emojiLikesList;
        if (arrayList == null && arrayList2 == null) {
            return true;
        }
        if (arrayList == null || arrayList2 == null || arrayList.size() != arrayList2.size()) {
            return false;
        }
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            MsgEmojiLikes item1 = arrayList.get(i3);
            MsgEmojiLikes item2 = arrayList2.get(i3);
            Intrinsics.checkNotNullExpressionValue(item1, "item1");
            Intrinsics.checkNotNullExpressionValue(item2, "item2");
            if (!l(item1, item2)) {
                return false;
            }
        }
        return true;
    }

    public static final boolean B(@NotNull AIOMsgItem aIOMsgItem, @NotNull AIOMsgItem other) {
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return Intrinsics.areEqual(aIOMsgItem.X(), other.X());
    }

    public static final boolean C(@NotNull AIOMsgItem aIOMsgItem, @NotNull AIOMsgItem other) {
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (aIOMsgItem.i0().c() == other.i0().c() && Intrinsics.areEqual(aIOMsgItem.i0().a(), other.i0().a()) && Intrinsics.areEqual(aIOMsgItem.i0().b(), other.i0().b())) {
            return true;
        }
        return false;
    }

    public static final boolean D(@NotNull AIOMsgItem aIOMsgItem, @NotNull AIOMsgItem other) {
        Integer num;
        Integer num2;
        Integer num3;
        Integer num4;
        Integer num5;
        Integer num6;
        Integer num7;
        TransSvrInfo transSvrInfo;
        TransSvrInfo transSvrInfo2;
        TransSvrInfo transSvrInfo3;
        TransSvrInfo transSvrInfo4;
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        SendMsgRspTransSvrInfoAttr l3 = MsgExtKt.l(aIOMsgItem.getMsgRecord());
        SendMsgRspTransSvrInfoAttr l16 = MsgExtKt.l(other.getMsgRecord());
        Integer num8 = null;
        if (l3 != null) {
            num = Integer.valueOf(l3.rspCode);
        } else {
            num = null;
        }
        if (l16 != null) {
            num2 = Integer.valueOf(l16.rspCode);
        } else {
            num2 = null;
        }
        if (Intrinsics.areEqual(num, num2)) {
            if (l3 != null) {
                num3 = Integer.valueOf(l3.rspErrType);
            } else {
                num3 = null;
            }
            if (l16 != null) {
                num4 = Integer.valueOf(l16.rspErrType);
            } else {
                num4 = null;
            }
            if (Intrinsics.areEqual(num3, num4)) {
                if (l3 != null && (transSvrInfo4 = l3.transSvrInfo) != null) {
                    num5 = Integer.valueOf(transSvrInfo4.subType);
                } else {
                    num5 = null;
                }
                if (l16 != null && (transSvrInfo3 = l16.transSvrInfo) != null) {
                    num6 = Integer.valueOf(transSvrInfo3.subType);
                } else {
                    num6 = null;
                }
                if (Intrinsics.areEqual(num5, num6)) {
                    if (l3 != null && (transSvrInfo2 = l3.transSvrInfo) != null) {
                        num7 = Integer.valueOf(transSvrInfo2.retCode);
                    } else {
                        num7 = null;
                    }
                    if (l16 != null && (transSvrInfo = l16.transSvrInfo) != null) {
                        num8 = Integer.valueOf(transSvrInfo.retCode);
                    }
                    if (Intrinsics.areEqual(num7, num8)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static final boolean E(@NotNull AIOMsgItem aIOMsgItem, @NotNull AIOMsgItem other) {
        Integer num;
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        AdelieRecommendedMsgElement e16 = e(aIOMsgItem);
        Integer num2 = null;
        if (e16 != null) {
            num = Integer.valueOf(f(e16));
        } else {
            num = null;
        }
        AdelieRecommendedMsgElement e17 = e(other);
        if (e17 != null) {
            num2 = Integer.valueOf(f(e17));
        }
        return Intrinsics.areEqual(num, num2);
    }

    public static final boolean F(@NotNull AIOMsgItem aIOMsgItem, @NotNull AIOMsgItem other) {
        VASPersonalNamePlate vASPersonalNamePlate;
        VASPersonalNamePlate vASPersonalNamePlate2;
        Integer num;
        Integer num2;
        Integer num3;
        Integer num4;
        Integer num5;
        Integer num6;
        Integer num7;
        Integer num8;
        Integer num9;
        Integer num10;
        Integer num11;
        Integer num12;
        Integer num13;
        VASAIOPersonalElement vASAIOPersonalElement;
        VASAIOPersonalElement vASAIOPersonalElement2;
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        MsgAttributeInfo msgAttributeInfo = aIOMsgItem.P().get(1);
        Integer num14 = null;
        if (msgAttributeInfo != null && (vASAIOPersonalElement2 = msgAttributeInfo.vasPersonalInfo) != null) {
            vASPersonalNamePlate = vASAIOPersonalElement2.vasPersonalNamePlate;
        } else {
            vASPersonalNamePlate = null;
        }
        MsgAttributeInfo msgAttributeInfo2 = other.P().get(1);
        if (msgAttributeInfo2 != null && (vASAIOPersonalElement = msgAttributeInfo2.vasPersonalInfo) != null) {
            vASPersonalNamePlate2 = vASAIOPersonalElement.vasPersonalNamePlate;
        } else {
            vASPersonalNamePlate2 = null;
        }
        if (vASPersonalNamePlate != null) {
            num = vASPersonalNamePlate.vipType;
        } else {
            num = null;
        }
        if (vASPersonalNamePlate2 != null) {
            num2 = vASPersonalNamePlate2.vipType;
        } else {
            num2 = null;
        }
        if (Intrinsics.areEqual(num, num2)) {
            if (vASPersonalNamePlate != null) {
                num3 = vASPersonalNamePlate.vipStarFlag;
            } else {
                num3 = null;
            }
            if (vASPersonalNamePlate2 != null) {
                num4 = vASPersonalNamePlate2.vipStarFlag;
            } else {
                num4 = null;
            }
            if (Intrinsics.areEqual(num3, num4)) {
                if (vASPersonalNamePlate != null) {
                    num5 = vASPersonalNamePlate.vipLevel;
                } else {
                    num5 = null;
                }
                if (vASPersonalNamePlate2 != null) {
                    num6 = vASPersonalNamePlate2.vipLevel;
                } else {
                    num6 = null;
                }
                if (Intrinsics.areEqual(num5, num6)) {
                    if (vASPersonalNamePlate != null) {
                        num7 = vASPersonalNamePlate.namePlateId;
                    } else {
                        num7 = null;
                    }
                    if (vASPersonalNamePlate2 != null) {
                        num8 = vASPersonalNamePlate2.namePlateId;
                    } else {
                        num8 = null;
                    }
                    if (Intrinsics.areEqual(num7, num8)) {
                        if (vASPersonalNamePlate != null) {
                            num9 = vASPersonalNamePlate.isGray;
                        } else {
                            num9 = null;
                        }
                        if (vASPersonalNamePlate2 != null) {
                            num10 = vASPersonalNamePlate2.isGray;
                        } else {
                            num10 = null;
                        }
                        if (Intrinsics.areEqual(num9, num10)) {
                            if (vASPersonalNamePlate != null) {
                                num11 = vASPersonalNamePlate.gameNamePlateId;
                            } else {
                                num11 = null;
                            }
                            if (vASPersonalNamePlate2 != null) {
                                num12 = vASPersonalNamePlate2.gameNamePlateId;
                            } else {
                                num12 = null;
                            }
                            if (Intrinsics.areEqual(num11, num12)) {
                                if (vASPersonalNamePlate != null) {
                                    num13 = vASPersonalNamePlate.diyNamePlateItemId;
                                } else {
                                    num13 = null;
                                }
                                if (vASPersonalNamePlate2 != null) {
                                    num14 = vASPersonalNamePlate2.diyNamePlateItemId;
                                }
                                if (Intrinsics.areEqual(num13, num14) && u(aIOMsgItem, other) && r(aIOMsgItem, other)) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static final boolean G(@NotNull AIOMsgItem aIOMsgItem, @NotNull AIOMsgItem other) {
        VASMsgAvatarPendant vASMsgAvatarPendant;
        VASMsgAvatarPendant vASMsgAvatarPendant2;
        Integer num;
        VASMsgElement vASMsgElement;
        VASMsgElement vASMsgElement2;
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        MsgAttributeInfo msgAttributeInfo = aIOMsgItem.P().get(1);
        Integer num2 = null;
        if (msgAttributeInfo != null && (vASMsgElement2 = msgAttributeInfo.vasMsgInfo) != null) {
            vASMsgAvatarPendant = vASMsgElement2.avatarPendantInfo;
        } else {
            vASMsgAvatarPendant = null;
        }
        MsgAttributeInfo msgAttributeInfo2 = other.P().get(1);
        if (msgAttributeInfo2 != null && (vASMsgElement = msgAttributeInfo2.vasMsgInfo) != null) {
            vASMsgAvatarPendant2 = vASMsgElement.avatarPendantInfo;
        } else {
            vASMsgAvatarPendant2 = null;
        }
        if (vASMsgAvatarPendant != null) {
            num = vASMsgAvatarPendant.avatarId;
        } else {
            num = null;
        }
        if (vASMsgAvatarPendant2 != null) {
            num2 = vASMsgAvatarPendant2.avatarId;
        }
        if (Intrinsics.areEqual(num, num2) && J(aIOMsgItem, other, 23)) {
            return true;
        }
        return false;
    }

    public static final boolean H(@NotNull AIOMsgItem aIOMsgItem, @NotNull AIOMsgItem other) {
        VASMsgAvatarPendant vASMsgAvatarPendant;
        VASMsgAvatarPendant vASMsgAvatarPendant2;
        Long l3;
        Long l16;
        Integer num;
        VASMsgElement vASMsgElement;
        VASMsgElement vASMsgElement2;
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        MsgAttributeInfo msgAttributeInfo = aIOMsgItem.P().get(1);
        Integer num2 = null;
        if (msgAttributeInfo != null && (vASMsgElement2 = msgAttributeInfo.vasMsgInfo) != null) {
            vASMsgAvatarPendant = vASMsgElement2.avatarPendantInfo;
        } else {
            vASMsgAvatarPendant = null;
        }
        MsgAttributeInfo msgAttributeInfo2 = other.P().get(1);
        if (msgAttributeInfo2 != null && (vASMsgElement = msgAttributeInfo2.vasMsgInfo) != null) {
            vASMsgAvatarPendant2 = vASMsgElement.avatarPendantInfo;
        } else {
            vASMsgAvatarPendant2 = null;
        }
        if (vASMsgAvatarPendant != null) {
            l3 = vASMsgAvatarPendant.pendantId;
        } else {
            l3 = null;
        }
        if (vASMsgAvatarPendant2 != null) {
            l16 = vASMsgAvatarPendant2.pendantId;
        } else {
            l16 = null;
        }
        if (Intrinsics.areEqual(l3, l16)) {
            if (vASMsgAvatarPendant != null) {
                num = vASMsgAvatarPendant.pendantDiyInfoId;
            } else {
                num = null;
            }
            if (vASMsgAvatarPendant2 != null) {
                num2 = vASMsgAvatarPendant2.pendantDiyInfoId;
            }
            if (Intrinsics.areEqual(num, num2) && J(aIOMsgItem, other, 4)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean I(@NotNull AIOMsgItem aIOMsgItem, @NotNull AIOMsgItem other) {
        VASPersonalNamePlate vASPersonalNamePlate;
        VASPersonalNamePlate vASPersonalNamePlate2;
        Integer num;
        VASAIOPersonalElement vASAIOPersonalElement;
        VASAIOPersonalElement vASAIOPersonalElement2;
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        MsgAttributeInfo msgAttributeInfo = aIOMsgItem.P().get(1);
        Integer num2 = null;
        if (msgAttributeInfo != null && (vASAIOPersonalElement2 = msgAttributeInfo.vasPersonalInfo) != null) {
            vASPersonalNamePlate = vASAIOPersonalElement2.vasPersonalNamePlate;
        } else {
            vASPersonalNamePlate = null;
        }
        MsgAttributeInfo msgAttributeInfo2 = other.P().get(1);
        if (msgAttributeInfo2 != null && (vASAIOPersonalElement = msgAttributeInfo2.vasPersonalInfo) != null) {
            vASPersonalNamePlate2 = vASAIOPersonalElement.vasPersonalNamePlate;
        } else {
            vASPersonalNamePlate2 = null;
        }
        if (vASPersonalNamePlate != null) {
            num = vASPersonalNamePlate.extendNamePlateId;
        } else {
            num = null;
        }
        if (vASPersonalNamePlate2 != null) {
            num2 = vASPersonalNamePlate2.extendNamePlateId;
        }
        return Intrinsics.areEqual(num, num2);
    }

    private static final boolean J(AIOMsgItem aIOMsgItem, AIOMsgItem aIOMsgItem2, int i3) {
        VASPersonalVipNumberInfo vASPersonalVipNumberInfo;
        VASPersonalVipNumberInfo vASPersonalVipNumberInfo2;
        Integer num;
        Integer num2;
        Integer num3;
        Integer num4;
        Integer num5;
        Integer num6;
        Integer num7;
        VASAIOPersonalElement vASAIOPersonalElement;
        ArrayList<VASPersonalVipNumberInfo> arrayList;
        Object obj;
        boolean z16;
        VASAIOPersonalElement vASAIOPersonalElement2;
        ArrayList<VASPersonalVipNumberInfo> arrayList2;
        Object obj2;
        boolean z17;
        MsgAttributeInfo msgAttributeInfo = aIOMsgItem.P().get(1);
        Integer num8 = null;
        if (msgAttributeInfo != null && (vASAIOPersonalElement2 = msgAttributeInfo.vasPersonalInfo) != null && (arrayList2 = vASAIOPersonalElement2.vipNumbers) != null) {
            Iterator<T> it = arrayList2.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj2 = it.next();
                    Integer num9 = ((VASPersonalVipNumberInfo) obj2).appId;
                    if (num9 != null && num9.intValue() == i3) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        break;
                    }
                } else {
                    obj2 = null;
                    break;
                }
            }
            vASPersonalVipNumberInfo = (VASPersonalVipNumberInfo) obj2;
        } else {
            vASPersonalVipNumberInfo = null;
        }
        MsgAttributeInfo msgAttributeInfo2 = aIOMsgItem2.P().get(1);
        if (msgAttributeInfo2 != null && (vASAIOPersonalElement = msgAttributeInfo2.vasPersonalInfo) != null && (arrayList = vASAIOPersonalElement.vipNumbers) != null) {
            Iterator<T> it5 = arrayList.iterator();
            while (true) {
                if (it5.hasNext()) {
                    obj = it5.next();
                    Integer num10 = ((VASPersonalVipNumberInfo) obj).appId;
                    if (num10 != null && num10.intValue() == i3) {
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
            vASPersonalVipNumberInfo2 = (VASPersonalVipNumberInfo) obj;
        } else {
            vASPersonalVipNumberInfo2 = null;
        }
        if (vASPersonalVipNumberInfo != null) {
            num = vASPersonalVipNumberInfo.appId;
        } else {
            num = null;
        }
        if (vASPersonalVipNumberInfo2 != null) {
            num2 = vASPersonalVipNumberInfo2.appId;
        } else {
            num2 = null;
        }
        if (Intrinsics.areEqual(num, num2)) {
            if (vASPersonalVipNumberInfo != null) {
                num3 = vASPersonalVipNumberInfo.itemId;
            } else {
                num3 = null;
            }
            if (vASPersonalVipNumberInfo2 != null) {
                num4 = vASPersonalVipNumberInfo2.itemId;
            } else {
                num4 = null;
            }
            if (Intrinsics.areEqual(num3, num4)) {
                if (vASPersonalVipNumberInfo != null) {
                    num5 = vASPersonalVipNumberInfo.numberIdx;
                } else {
                    num5 = null;
                }
                if (vASPersonalVipNumberInfo2 != null) {
                    num6 = vASPersonalVipNumberInfo2.numberIdx;
                } else {
                    num6 = null;
                }
                if (Intrinsics.areEqual(num5, num6)) {
                    if (vASPersonalVipNumberInfo != null) {
                        num7 = vASPersonalVipNumberInfo.numberItemId;
                    } else {
                        num7 = null;
                    }
                    if (vASPersonalVipNumberInfo2 != null) {
                        num8 = vASPersonalVipNumberInfo2.numberItemId;
                    }
                    if (Intrinsics.areEqual(num7, num8)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static final boolean K(@NotNull AIOMsgItem aIOMsgItem) {
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        if (g(aIOMsgItem) == 1 || g(aIOMsgItem) == 4) {
            return true;
        }
        return false;
    }

    public static final boolean L(@NotNull AIOMsgItem aIOMsgItem) {
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        if (M(aIOMsgItem) && !K(aIOMsgItem)) {
            return true;
        }
        return false;
    }

    public static final boolean M(@NotNull AIOMsgItem aIOMsgItem) {
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        return N(aIOMsgItem.getMsgRecord());
    }

    public static final boolean N(@NotNull MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        if (h(msgRecord) > 0) {
            return true;
        }
        return false;
    }

    @NotNull
    public static final ArrayList<AIOElementType.MultiPicElement> O(@NotNull AIOMsgItem aIOMsgItem) {
        Object obj;
        AIOElementType.MultiPicElement multiPicElement;
        boolean z16;
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        Integer num = aIOMsgItem.getMsgRecord().fileGroupSize;
        Intrinsics.checkNotNullExpressionValue(num, "msgRecord.fileGroupSize");
        ArrayList<AIOElementType.MultiPicElement> arrayList = new ArrayList<>(num.intValue());
        Integer num2 = aIOMsgItem.getMsgRecord().fileGroupSize;
        Intrinsics.checkNotNullExpressionValue(num2, "msgRecord.fileGroupSize");
        int intValue = num2.intValue();
        for (int i3 = 0; i3 < intValue; i3++) {
            ArrayList<MsgElement> arrayList2 = aIOMsgItem.getMsgRecord().elements;
            Intrinsics.checkNotNullExpressionValue(arrayList2, "msgRecord.elements");
            Iterator<T> it = arrayList2.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    Integer num3 = ((MsgElement) obj).fileElement.fileGroupIndex;
                    if (num3 != null && num3.intValue() == i3) {
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
                long j3 = msgElement.elementId;
                String str = msgElement.fileElement.filePath;
                Intrinsics.checkNotNullExpressionValue(str, "it.fileElement.filePath");
                FileElement fileElement = msgElement.fileElement;
                Intrinsics.checkNotNullExpressionValue(fileElement, "it.fileElement");
                String P = P(fileElement);
                long intValue2 = msgElement.fileElement.progress.intValue();
                FileElement fileElement2 = msgElement.fileElement;
                long j16 = fileElement2.fileSize;
                Integer num4 = fileElement2.transferStatus;
                Intrinsics.checkNotNullExpressionValue(num4, "it.fileElement.transferStatus");
                multiPicElement = new AIOElementType.MultiPicElement(j3, str, P, intValue2, j16, num4.intValue());
            } else {
                multiPicElement = new AIOElementType.MultiPicElement(0L, "", "", 0L, 1L, 1);
            }
            arrayList.add(multiPicElement);
        }
        return arrayList;
    }

    private static final String P(FileElement fileElement) {
        HashMap<Integer, String> hashMap = fileElement.picThumbPath;
        if (hashMap == null || hashMap.isEmpty()) {
            return "";
        }
        Pair pair = new Pair(0, "");
        for (Map.Entry<Integer, String> entry : fileElement.picThumbPath.entrySet()) {
            Integer key = entry.getKey();
            Intrinsics.checkNotNullExpressionValue(key, "entry.key");
            if (key.intValue() > ((Number) pair.getFirst()).intValue()) {
                pair = new Pair(entry.getKey(), entry.getValue());
            }
        }
        return (String) pair.getSecond();
    }

    @Nullable
    public static final AdelieActionBarElement a(@NotNull AIOMsgItem aIOMsgItem) {
        AdelieActionBarElement adelieActionBarElement;
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        ArrayList<MsgElement> arrayList = aIOMsgItem.getMsgRecord().auxiliaryElements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msgRecord.auxiliaryElements");
        for (MsgElement msgElement : arrayList) {
            if (msgElement.elementType == 44 && (adelieActionBarElement = msgElement.actionBarElement) != null) {
                return adelieActionBarElement;
            }
        }
        return null;
    }

    @Nullable
    public static final HashMap<Integer, InlineKeyboardButton> b(@NotNull AIOMsgItem aIOMsgItem, @Nullable String str) {
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        AdelieActionBarElement a16 = a(aIOMsgItem);
        if (a16 == null) {
            return null;
        }
        ArrayList<InlineKeyboardButton> arrayList = new ArrayList();
        ArrayList<InlineKeyboardRow> arrayList2 = a16.rows;
        Intrinsics.checkNotNullExpressionValue(arrayList2, "actionBarElement.rows");
        Iterator<T> it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList.addAll(((InlineKeyboardRow) it.next()).buttons);
        }
        if (arrayList.isEmpty()) {
            if (QLog.isDevelopLevel()) {
                QLog.i("AIOMsgItem", 4, "getButtonShowState msgId " + aIOMsgItem.getMsgId() + " type " + aIOMsgItem.getMsgRecord().msgType + " list null");
            }
            return null;
        }
        HashMap<Integer, InlineKeyboardButton> hashMap = new HashMap<>();
        StringBuilder sb5 = new StringBuilder();
        for (InlineKeyboardButton inlineKeyboardButton : arrayList) {
            long j3 = inlineKeyboardButton.hideSeconds;
            if (j3 <= 0 || j3 >= System.currentTimeMillis() / 1000) {
                int i3 = inlineKeyboardButton.type;
                if (i3 == 5) {
                    int i16 = inlineKeyboardButton.feedBackData.opt;
                    if (i16 == 1) {
                        hashMap.put(1, inlineKeyboardButton);
                        sb5.append("LIKE, ");
                    } else if (i16 == 2) {
                        hashMap.put(2, inlineKeyboardButton);
                        sb5.append("DISLIKE, ");
                    } else if (i16 == 3) {
                        hashMap.put(4, inlineKeyboardButton);
                        sb5.append("STOP_GENERATE, ");
                    } else if (i16 == 4) {
                        hashMap.put(5, inlineKeyboardButton);
                        sb5.append("REGENERATE, ");
                    } else if (i16 == 6) {
                        hashMap.put(6, inlineKeyboardButton);
                        sb5.append("SHARE, ");
                    } else if (i16 == 7) {
                        hashMap.put(7, inlineKeyboardButton);
                        sb5.append("COPY, ");
                    }
                } else if (i3 == 6 && !TextUtils.isEmpty(str)) {
                    hashMap.put(3, inlineKeyboardButton);
                    sb5.append("TTS, ");
                }
            }
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("AIOMsgItem", 4, "getButtonShowState msgId " + aIOMsgItem.getMsgId() + " type " + aIOMsgItem.getMsgRecord().msgType + " list " + ((Object) sb5));
        }
        return hashMap;
    }

    public static final int c(@NotNull MsgRecord msgRecord) {
        Integer num;
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        ArrayList<MsgElement> elements = msgRecord.elements;
        Intrinsics.checkNotNullExpressionValue(elements, "elements");
        Iterator<T> it = elements.iterator();
        if (!it.hasNext()) {
            num = null;
        } else {
            Integer valueOf = Integer.valueOf(((MsgElement) it.next()).elementGroupId);
            while (it.hasNext()) {
                Integer valueOf2 = Integer.valueOf(((MsgElement) it.next()).elementGroupId);
                if (valueOf.compareTo(valueOf2) < 0) {
                    valueOf = valueOf2;
                }
            }
            num = valueOf;
        }
        Integer num2 = num;
        if (num2 != null) {
            return num2.intValue();
        }
        return 0;
    }

    @Nullable
    public static final PrologueMsgElement d(@NotNull AIOMsgItem aIOMsgItem) {
        PrologueMsgElement prologueMsgElement;
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        ArrayList<MsgElement> arrayList = aIOMsgItem.getMsgRecord().elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msgRecord.elements");
        for (MsgElement msgElement : arrayList) {
            if (msgElement.elementType == 46 && (prologueMsgElement = msgElement.prologueMsgElement) != null) {
                return prologueMsgElement;
            }
        }
        return null;
    }

    @Nullable
    public static final AdelieRecommendedMsgElement e(@NotNull AIOMsgItem aIOMsgItem) {
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        ArrayList<MsgElement> arrayList = aIOMsgItem.getMsgRecord().auxiliaryElements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msgRecord.auxiliaryElements");
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            AdelieRecommendedMsgElement adelieRecommendedMsgElement = ((MsgElement) it.next()).recommendedMsgElement;
            if (adelieRecommendedMsgElement != null) {
                return adelieRecommendedMsgElement;
            }
        }
        return null;
    }

    public static final int f(@NotNull AdelieRecommendedMsgElement adelieRecommendedMsgElement) {
        Intrinsics.checkNotNullParameter(adelieRecommendedMsgElement, "<this>");
        ArrayList<InlineKeyboardRow> rows = adelieRecommendedMsgElement.getRows();
        int i3 = 0;
        if (rows != null) {
            Iterator<T> it = rows.iterator();
            while (it.hasNext()) {
                ArrayList<InlineKeyboardButton> buttons = ((InlineKeyboardRow) it.next()).getButtons();
                if (buttons != null) {
                    Intrinsics.checkNotNullExpressionValue(buttons, "getButtons()");
                    for (InlineKeyboardButton inlineKeyboardButton : buttons) {
                        i3++;
                    }
                }
            }
        }
        return i3;
    }

    public static final int g(@NotNull AIOMsgItem aIOMsgItem) {
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        return h(aIOMsgItem.getMsgRecord());
    }

    public static final int h(@NotNull MsgRecord msgRecord) {
        long j3;
        AdelieMsgAttr adelieMsgAttr;
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        MsgAttributeInfo msgAttributeInfo = msgRecord.msgAttrs.get(16);
        if (msgAttributeInfo != null && (adelieMsgAttr = msgAttributeInfo.adelieMsgAttr) != null) {
            j3 = adelieMsgAttr.msgPushStatus;
        } else {
            j3 = 0;
        }
        return (int) j3;
    }

    public static final boolean i(@NotNull AIOMsgItem aIOMsgItem) {
        int i3;
        MemoryStateMsgInfo memoryStateMsgInfo;
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        MsgAttributeInfo msgAttributeInfo = aIOMsgItem.getMsgRecord().msgAttrs.get(18);
        if (msgAttributeInfo != null && (memoryStateMsgInfo = msgAttributeInfo.memoryStateMsgInfo) != null) {
            i3 = memoryStateMsgInfo.memoryStateMsgType;
        } else {
            i3 = 0;
        }
        if (i3 != 1) {
            return false;
        }
        return true;
    }

    public static final boolean j(@NotNull AIOMsgItem aIOMsgItem) {
        int i3;
        MemoryStateMsgInfo memoryStateMsgInfo;
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        MsgAttributeInfo msgAttributeInfo = aIOMsgItem.getMsgRecord().msgAttrs.get(18);
        if (msgAttributeInfo != null && (memoryStateMsgInfo = msgAttributeInfo.memoryStateMsgInfo) != null) {
            i3 = memoryStateMsgInfo.memoryStateMsgType;
        } else {
            i3 = 0;
        }
        if (i3 != 3) {
            return false;
        }
        return true;
    }

    public static final boolean k(@NotNull AIOMsgItem aIOMsgItem, @NotNull AIOMsgItem oldMsgItem) {
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        Intrinsics.checkNotNullParameter(oldMsgItem, "oldMsgItem");
        if (!M(aIOMsgItem) || aIOMsgItem.getMsgId() != oldMsgItem.getMsgId() || c(aIOMsgItem.getMsgRecord()) <= c(oldMsgItem.getMsgRecord())) {
            return false;
        }
        return true;
    }

    public static final boolean l(@NotNull MsgEmojiLikes msgEmojiLikes, @NotNull MsgEmojiLikes other) {
        Intrinsics.checkNotNullParameter(msgEmojiLikes, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (Intrinsics.areEqual(msgEmojiLikes.emojiId, other.emojiId) && msgEmojiLikes.emojiType == other.emojiType && msgEmojiLikes.likesCnt == other.likesCnt && msgEmojiLikes.isClicked == other.isClicked) {
            return true;
        }
        return false;
    }

    public static final boolean m(@NotNull AIOMsgItem aIOMsgItem, @NotNull AIOMsgItem other) {
        Long l3;
        MsgAttributeInfo msgAttributeInfo;
        AdelieMsgAttr adelieMsgAttr;
        MsgAttributeInfo msgAttributeInfo2;
        AdelieMsgAttr adelieMsgAttr2;
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        HashMap<Integer, MsgAttributeInfo> hashMap = aIOMsgItem.getMsgRecord().msgAttrs;
        Long l16 = null;
        if (hashMap != null && (msgAttributeInfo2 = hashMap.get(16)) != null && (adelieMsgAttr2 = msgAttributeInfo2.adelieMsgAttr) != null) {
            l3 = Long.valueOf(adelieMsgAttr2.msgPushStatus);
        } else {
            l3 = null;
        }
        HashMap<Integer, MsgAttributeInfo> hashMap2 = other.getMsgRecord().msgAttrs;
        if (hashMap2 != null && (msgAttributeInfo = hashMap2.get(16)) != null && (adelieMsgAttr = msgAttributeInfo.adelieMsgAttr) != null) {
            l16 = Long.valueOf(adelieMsgAttr.msgPushStatus);
        }
        return Intrinsics.areEqual(l3, l16);
    }

    public static final boolean n(@NotNull AIOMsgItem aIOMsgItem, @NotNull AIOMsgItem other) {
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.c p16 = aIOMsgItem.p();
        if (p16 != null) {
            return com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.d.a(p16, other.p());
        }
        return false;
    }

    public static final boolean o(@NotNull AIOMsgItem aIOMsgItem, @NotNull AIOMsgItem other) {
        View view;
        View view2;
        View view3;
        View view4;
        View view5;
        View view6;
        Integer num;
        Integer num2;
        Integer num3;
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        com.tencent.qqnt.aio.avatar.egg.a q16 = aIOMsgItem.q();
        Integer num4 = null;
        if (q16 != null) {
            view = q16.c();
        } else {
            view = null;
        }
        com.tencent.qqnt.aio.avatar.egg.a q17 = other.q();
        if (q17 != null) {
            view2 = q17.c();
        } else {
            view2 = null;
        }
        if (view == view2) {
            com.tencent.qqnt.aio.avatar.egg.a q18 = aIOMsgItem.q();
            if (q18 != null) {
                view3 = q18.f();
            } else {
                view3 = null;
            }
            com.tencent.qqnt.aio.avatar.egg.a q19 = other.q();
            if (q19 != null) {
                view4 = q19.f();
            } else {
                view4 = null;
            }
            if (view3 == view4) {
                com.tencent.qqnt.aio.avatar.egg.a q26 = aIOMsgItem.q();
                if (q26 != null) {
                    view5 = q26.e();
                } else {
                    view5 = null;
                }
                com.tencent.qqnt.aio.avatar.egg.a q27 = other.q();
                if (q27 != null) {
                    view6 = q27.e();
                } else {
                    view6 = null;
                }
                if (view5 == view6) {
                    com.tencent.qqnt.aio.avatar.egg.a q28 = aIOMsgItem.q();
                    if (q28 != null) {
                        num = Integer.valueOf(q28.g());
                    } else {
                        num = null;
                    }
                    com.tencent.qqnt.aio.avatar.egg.a q29 = other.q();
                    if (q29 != null) {
                        num2 = Integer.valueOf(q29.g());
                    } else {
                        num2 = null;
                    }
                    if (Intrinsics.areEqual(num, num2)) {
                        com.tencent.qqnt.aio.avatar.egg.a q36 = aIOMsgItem.q();
                        if (q36 != null) {
                            num3 = Integer.valueOf(q36.d());
                        } else {
                            num3 = null;
                        }
                        com.tencent.qqnt.aio.avatar.egg.a q37 = other.q();
                        if (q37 != null) {
                            num4 = Integer.valueOf(q37.d());
                        }
                        if (Intrinsics.areEqual(num3, num4)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static final boolean p(@NotNull AIOMsgItem aIOMsgItem, @NotNull AIOMsgItem other) {
        VASMsgBubble vASMsgBubble;
        VASMsgBubble vASMsgBubble2;
        Integer num;
        Integer num2;
        Integer num3;
        Integer num4;
        Integer num5;
        Integer num6;
        Integer num7;
        VASMsgElement vASMsgElement;
        VASMsgElement vASMsgElement2;
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        MsgAttributeInfo msgAttributeInfo = aIOMsgItem.P().get(1);
        Integer num8 = null;
        if (msgAttributeInfo != null && (vASMsgElement2 = msgAttributeInfo.vasMsgInfo) != null) {
            vASMsgBubble = vASMsgElement2.bubbleInfo;
        } else {
            vASMsgBubble = null;
        }
        MsgAttributeInfo msgAttributeInfo2 = other.P().get(1);
        if (msgAttributeInfo2 != null && (vASMsgElement = msgAttributeInfo2.vasMsgInfo) != null) {
            vASMsgBubble2 = vASMsgElement.bubbleInfo;
        } else {
            vASMsgBubble2 = null;
        }
        if (vASMsgBubble != null) {
            num = vASMsgBubble.bubbleId;
        } else {
            num = null;
        }
        if (vASMsgBubble2 != null) {
            num2 = vASMsgBubble2.bubbleId;
        } else {
            num2 = null;
        }
        if (Intrinsics.areEqual(num, num2)) {
            if (vASMsgBubble != null) {
                num3 = vASMsgBubble.subBubbleId;
            } else {
                num3 = null;
            }
            if (vASMsgBubble2 != null) {
                num4 = vASMsgBubble2.subBubbleId;
            } else {
                num4 = null;
            }
            if (Intrinsics.areEqual(num3, num4)) {
                if (vASMsgBubble != null) {
                    num5 = vASMsgBubble.bubbleDiyTextId;
                } else {
                    num5 = null;
                }
                if (vASMsgBubble2 != null) {
                    num6 = vASMsgBubble2.bubbleDiyTextId;
                } else {
                    num6 = null;
                }
                if (Intrinsics.areEqual(num5, num6)) {
                    if (vASMsgBubble != null) {
                        num7 = vASMsgBubble.canConvertToText;
                    } else {
                        num7 = null;
                    }
                    if (vASMsgBubble2 != null) {
                        num8 = vASMsgBubble2.canConvertToText;
                    }
                    if (Intrinsics.areEqual(num7, num8) && s(aIOMsgItem, other)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static final boolean q(@NotNull AIOMsgItem aIOMsgItem, @NotNull AIOMsgItem other) {
        Integer num;
        Integer num2;
        Integer num3;
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Pair<Integer, Integer> t16 = aIOMsgItem.t();
        Integer num4 = null;
        if (t16 != null) {
            num = t16.getFirst();
        } else {
            num = null;
        }
        Pair<Integer, Integer> t17 = other.t();
        if (t17 != null) {
            num2 = t17.getFirst();
        } else {
            num2 = null;
        }
        if (Intrinsics.areEqual(num, num2)) {
            Pair<Integer, Integer> t18 = aIOMsgItem.t();
            if (t18 != null) {
                num3 = t18.getSecond();
            } else {
                num3 = null;
            }
            Pair<Integer, Integer> t19 = other.t();
            if (t19 != null) {
                num4 = t19.getSecond();
            }
            if (Intrinsics.areEqual(num3, num4)) {
                return true;
            }
        }
        return false;
    }

    private static final boolean r(AIOMsgItem aIOMsgItem, AIOMsgItem aIOMsgItem2) {
        ArrayList<Integer> arrayList;
        VASAIOPersonalElement vASAIOPersonalElement;
        VASPersonalNamePlate vASPersonalNamePlate;
        VASAIOPersonalElement vASAIOPersonalElement2;
        VASPersonalNamePlate vASPersonalNamePlate2;
        MsgAttributeInfo msgAttributeInfo = aIOMsgItem.P().get(1);
        ArrayList<Integer> arrayList2 = null;
        if (msgAttributeInfo != null && (vASAIOPersonalElement2 = msgAttributeInfo.vasPersonalInfo) != null && (vASPersonalNamePlate2 = vASAIOPersonalElement2.vasPersonalNamePlate) != null) {
            arrayList = vASPersonalNamePlate2.carouselNamePlateIds;
        } else {
            arrayList = null;
        }
        MsgAttributeInfo msgAttributeInfo2 = aIOMsgItem2.P().get(1);
        if (msgAttributeInfo2 != null && (vASAIOPersonalElement = msgAttributeInfo2.vasPersonalInfo) != null && (vASPersonalNamePlate = vASAIOPersonalElement.vasPersonalNamePlate) != null) {
            arrayList2 = vASPersonalNamePlate.carouselNamePlateIds;
        }
        if (arrayList == null && arrayList2 == null) {
            return true;
        }
        if (arrayList == null || arrayList2 == null || arrayList.size() != arrayList2.size()) {
            return false;
        }
        int i3 = 0;
        for (Object obj : arrayList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (!Intrinsics.areEqual((Integer) obj, arrayList2.get(i3))) {
                return false;
            }
            i3 = i16;
        }
        return true;
    }

    public static final boolean s(@NotNull AIOMsgItem aIOMsgItem, @NotNull AIOMsgItem other) {
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return Intrinsics.areEqual(aIOMsgItem.u(), other.u());
    }

    public static final boolean t(@NotNull AIOMsgItem aIOMsgItem, @NotNull AIOMsgItem other) {
        Long l3;
        VASAIOPersonalElement vASAIOPersonalElement;
        VASAIOPersonalElement vASAIOPersonalElement2;
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        MsgAttributeInfo msgAttributeInfo = aIOMsgItem.P().get(1);
        Long l16 = null;
        if (msgAttributeInfo != null && (vASAIOPersonalElement2 = msgAttributeInfo.vasPersonalInfo) != null) {
            l3 = vASAIOPersonalElement2.troopNameColorId;
        } else {
            l3 = null;
        }
        MsgAttributeInfo msgAttributeInfo2 = other.P().get(1);
        if (msgAttributeInfo2 != null && (vASAIOPersonalElement = msgAttributeInfo2.vasPersonalInfo) != null) {
            l16 = vASAIOPersonalElement.troopNameColorId;
        }
        return Intrinsics.areEqual(l3, l16);
    }

    private static final boolean u(AIOMsgItem aIOMsgItem, AIOMsgItem aIOMsgItem2) {
        ArrayList<Integer> arrayList;
        VASAIOPersonalElement vASAIOPersonalElement;
        VASPersonalNamePlate vASPersonalNamePlate;
        VASAIOPersonalElement vASAIOPersonalElement2;
        VASPersonalNamePlate vASPersonalNamePlate2;
        MsgAttributeInfo msgAttributeInfo = aIOMsgItem.P().get(1);
        ArrayList<Integer> arrayList2 = null;
        if (msgAttributeInfo != null && (vASAIOPersonalElement2 = msgAttributeInfo.vasPersonalInfo) != null && (vASPersonalNamePlate2 = vASAIOPersonalElement2.vasPersonalNamePlate) != null) {
            arrayList = vASPersonalNamePlate2.diyNamePlateContentIds;
        } else {
            arrayList = null;
        }
        MsgAttributeInfo msgAttributeInfo2 = aIOMsgItem2.P().get(1);
        if (msgAttributeInfo2 != null && (vASAIOPersonalElement = msgAttributeInfo2.vasPersonalInfo) != null && (vASPersonalNamePlate = vASAIOPersonalElement.vasPersonalNamePlate) != null) {
            arrayList2 = vASPersonalNamePlate.diyNamePlateContentIds;
        }
        if (arrayList == null && arrayList2 == null) {
            return true;
        }
        if (arrayList == null || arrayList2 == null || arrayList.size() != arrayList2.size()) {
            return false;
        }
        int i3 = 0;
        for (Object obj : arrayList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (!Intrinsics.areEqual((Integer) obj, arrayList2.get(i3))) {
                return false;
            }
            i3 = i16;
        }
        return true;
    }

    public static final boolean v(@NotNull AIOMsgItem aIOMsgItem, @NotNull AIOMsgItem other) {
        Integer num;
        Integer num2;
        Long l3;
        Long l16;
        ArrayList<InlineKeyboardRow> arrayList;
        ArrayList<InlineKeyboardRow> arrayList2;
        Integer num3;
        FeedBackStateInfo feedBackStateInfo;
        FeedBackStateInfo feedBackStateInfo2;
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        MsgAttributeInfo msgAttributeInfo = aIOMsgItem.getMsgRecord().msgAttrs.get(17);
        Integer num4 = null;
        if (msgAttributeInfo != null && (feedBackStateInfo2 = msgAttributeInfo.feedBackStateInfo) != null) {
            num = Integer.valueOf(feedBackStateInfo2.likeOrDislike);
        } else {
            num = null;
        }
        MsgAttributeInfo msgAttributeInfo2 = other.getMsgRecord().msgAttrs.get(17);
        if (msgAttributeInfo2 != null && (feedBackStateInfo = msgAttributeInfo2.feedBackStateInfo) != null) {
            num2 = Integer.valueOf(feedBackStateInfo.likeOrDislike);
        } else {
            num2 = null;
        }
        if (!Intrinsics.areEqual(num, num2)) {
            return false;
        }
        AdelieActionBarElement a16 = a(aIOMsgItem);
        AdelieActionBarElement a17 = a(other);
        if (a16 == null && a17 == null) {
            return true;
        }
        if (a16 != null) {
            l3 = Long.valueOf(a16.botAppid);
        } else {
            l3 = null;
        }
        if (a17 != null) {
            l16 = Long.valueOf(a17.botAppid);
        } else {
            l16 = null;
        }
        if (!Intrinsics.areEqual(l3, l16)) {
            return false;
        }
        if (a16 != null) {
            arrayList = a16.rows;
        } else {
            arrayList = null;
        }
        if (a17 != null) {
            arrayList2 = a17.rows;
        } else {
            arrayList2 = null;
        }
        if (arrayList != null || arrayList2 != null) {
            if (arrayList != null) {
                num3 = Integer.valueOf(arrayList.size());
            } else {
                num3 = null;
            }
            if (arrayList2 != null) {
                num4 = Integer.valueOf(arrayList2.size());
            }
            if (Intrinsics.areEqual(num3, num4)) {
                ArrayList arrayList3 = new ArrayList();
                if (arrayList != null) {
                    Iterator<T> it = arrayList.iterator();
                    while (it.hasNext()) {
                        arrayList3.addAll(((InlineKeyboardRow) it.next()).buttons);
                    }
                }
                ArrayList arrayList4 = new ArrayList();
                if (arrayList2 != null) {
                    Iterator<T> it5 = arrayList2.iterator();
                    while (it5.hasNext()) {
                        arrayList4.addAll(((InlineKeyboardRow) it5.next()).buttons);
                    }
                }
                if (arrayList3.size() != arrayList4.size()) {
                    return false;
                }
                int size = arrayList3.size();
                for (int i3 = 0; i3 < size; i3++) {
                    Object obj = arrayList3.get(i3);
                    Intrinsics.checkNotNullExpressionValue(obj, "buttons[i]");
                    InlineKeyboardButton inlineKeyboardButton = (InlineKeyboardButton) obj;
                    Object obj2 = arrayList4.get(i3);
                    Intrinsics.checkNotNullExpressionValue(obj2, "otherButtons[i]");
                    InlineKeyboardButton inlineKeyboardButton2 = (InlineKeyboardButton) obj2;
                    int i16 = inlineKeyboardButton.type;
                    if (i16 != inlineKeyboardButton2.type) {
                        return false;
                    }
                    if (i16 == 5) {
                        if (inlineKeyboardButton.feedBackData.opt != inlineKeyboardButton2.feedBackData.opt) {
                            return false;
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static final boolean w(@NotNull AIOMsgItem aIOMsgItem, @NotNull AIOMsgItem other) {
        VASMsgFont vASMsgFont;
        VASMsgFont vASMsgFont2;
        Integer num;
        Integer num2;
        Long l3;
        Long l16;
        Integer num3;
        Integer num4;
        Integer num5;
        Integer num6;
        Integer num7;
        VASMsgElement vASMsgElement;
        VASMsgElement vASMsgElement2;
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        MsgAttributeInfo msgAttributeInfo = aIOMsgItem.P().get(1);
        Integer num8 = null;
        if (msgAttributeInfo != null && (vASMsgElement2 = msgAttributeInfo.vasMsgInfo) != null) {
            vASMsgFont = vASMsgElement2.vasFont;
        } else {
            vASMsgFont = null;
        }
        MsgAttributeInfo msgAttributeInfo2 = other.P().get(1);
        if (msgAttributeInfo2 != null && (vASMsgElement = msgAttributeInfo2.vasMsgInfo) != null) {
            vASMsgFont2 = vASMsgElement.vasFont;
        } else {
            vASMsgFont2 = null;
        }
        if (vASMsgFont != null) {
            num = vASMsgFont.fontId;
        } else {
            num = null;
        }
        if (vASMsgFont2 != null) {
            num2 = vASMsgFont2.fontId;
        } else {
            num2 = null;
        }
        if (Intrinsics.areEqual(num, num2)) {
            if (vASMsgFont != null) {
                l3 = vASMsgFont.subFontId;
            } else {
                l3 = null;
            }
            if (vASMsgFont2 != null) {
                l16 = vASMsgFont2.subFontId;
            } else {
                l16 = null;
            }
            if (Intrinsics.areEqual(l3, l16)) {
                if (vASMsgFont != null) {
                    num3 = vASMsgFont.diyFontCfgUpdateTime;
                } else {
                    num3 = null;
                }
                if (vASMsgFont2 != null) {
                    num4 = vASMsgFont2.diyFontCfgUpdateTime;
                } else {
                    num4 = null;
                }
                if (Intrinsics.areEqual(num3, num4)) {
                    if (vASMsgFont != null) {
                        num5 = vASMsgFont.diyFontImageId;
                    } else {
                        num5 = null;
                    }
                    if (vASMsgFont2 != null) {
                        num6 = vASMsgFont2.diyFontImageId;
                    } else {
                        num6 = null;
                    }
                    if (Intrinsics.areEqual(num5, num6)) {
                        if (vASMsgFont != null) {
                            num7 = vASMsgFont.magicFontType;
                        } else {
                            num7 = null;
                        }
                        if (vASMsgFont2 != null) {
                            num8 = vASMsgFont2.magicFontType;
                        }
                        if (Intrinsics.areEqual(num7, num8)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static final boolean x(@NotNull AIOMsgItem aIOMsgItem, @NotNull AIOMsgItem other) {
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return Intrinsics.areEqual(aIOMsgItem.E(), other.E());
    }

    public static final boolean y(@NotNull AIOMsgItem aIOMsgItem, @NotNull AIOMsgItem other) {
        List sortedWith;
        List sortedWith2;
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        List<com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b> c06 = other.c0();
        if (c06 == null) {
            c06 = new ArrayList<>();
        }
        List<com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b> c07 = aIOMsgItem.c0();
        if (c07 == null) {
            c07 = new ArrayList<>();
        }
        if (c07.size() == c06.size()) {
            sortedWith = CollectionsKt___CollectionsKt.sortedWith(c06, new a());
            sortedWith2 = CollectionsKt___CollectionsKt.sortedWith(c07, new b());
            int i3 = 0;
            for (Object obj : sortedWith) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                if (!Intrinsics.areEqual((com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b) obj, sortedWith2.get(i3))) {
                    return false;
                }
                i3 = i16;
            }
            return true;
        }
        return false;
    }

    public static final boolean z(@NotNull AIOMsgItem aIOMsgItem, @NotNull AIOMsgItem other) {
        Integer num;
        Integer num2;
        Boolean bool;
        Boolean bool2;
        Boolean bool3;
        Boolean bool4;
        Integer num3;
        Integer num4;
        String str;
        String str2;
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        Integer num5;
        Integer num6;
        Integer num7;
        Integer num8;
        String str3;
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        com.tencent.qqnt.aio.nick.f M = aIOMsgItem.M();
        String str4 = null;
        if (M != null) {
            num = Integer.valueOf(M.f());
        } else {
            num = null;
        }
        com.tencent.qqnt.aio.nick.f M2 = other.M();
        if (M2 != null) {
            num2 = Integer.valueOf(M2.f());
        } else {
            num2 = null;
        }
        if (Intrinsics.areEqual(num, num2)) {
            com.tencent.qqnt.aio.nick.f M3 = aIOMsgItem.M();
            if (M3 != null) {
                bool = Boolean.valueOf(M3.l());
            } else {
                bool = null;
            }
            com.tencent.qqnt.aio.nick.f M4 = other.M();
            if (M4 != null) {
                bool2 = Boolean.valueOf(M4.l());
            } else {
                bool2 = null;
            }
            if (Intrinsics.areEqual(bool, bool2)) {
                com.tencent.qqnt.aio.nick.f M5 = aIOMsgItem.M();
                if (M5 != null) {
                    bool3 = Boolean.valueOf(M5.m());
                } else {
                    bool3 = null;
                }
                com.tencent.qqnt.aio.nick.f M6 = other.M();
                if (M6 != null) {
                    bool4 = Boolean.valueOf(M6.m());
                } else {
                    bool4 = null;
                }
                if (Intrinsics.areEqual(bool3, bool4)) {
                    com.tencent.qqnt.aio.nick.f M7 = aIOMsgItem.M();
                    if (M7 != null) {
                        num3 = Integer.valueOf(M7.i());
                    } else {
                        num3 = null;
                    }
                    com.tencent.qqnt.aio.nick.f M8 = other.M();
                    if (M8 != null) {
                        num4 = Integer.valueOf(M8.i());
                    } else {
                        num4 = null;
                    }
                    if (Intrinsics.areEqual(num3, num4)) {
                        com.tencent.qqnt.aio.nick.f M9 = aIOMsgItem.M();
                        if (M9 != null) {
                            str = M9.h();
                        } else {
                            str = null;
                        }
                        com.tencent.qqnt.aio.nick.f M10 = other.M();
                        if (M10 != null) {
                            str2 = M10.h();
                        } else {
                            str2 = null;
                        }
                        if (Intrinsics.areEqual(str, str2)) {
                            com.tencent.qqnt.aio.nick.f M11 = aIOMsgItem.M();
                            if (M11 != null) {
                                iArr = M11.b();
                            } else {
                                iArr = null;
                            }
                            com.tencent.qqnt.aio.nick.f M12 = other.M();
                            if (M12 != null) {
                                iArr2 = M12.b();
                            } else {
                                iArr2 = null;
                            }
                            if (Arrays.equals(iArr, iArr2)) {
                                com.tencent.qqnt.aio.nick.f M13 = aIOMsgItem.M();
                                if (M13 != null) {
                                    iArr3 = M13.e();
                                } else {
                                    iArr3 = null;
                                }
                                com.tencent.qqnt.aio.nick.f M14 = other.M();
                                if (M14 != null) {
                                    iArr4 = M14.e();
                                } else {
                                    iArr4 = null;
                                }
                                if (Arrays.equals(iArr3, iArr4)) {
                                    com.tencent.qqnt.aio.nick.f M15 = aIOMsgItem.M();
                                    if (M15 != null) {
                                        num5 = Integer.valueOf(M15.c());
                                    } else {
                                        num5 = null;
                                    }
                                    com.tencent.qqnt.aio.nick.f M16 = other.M();
                                    if (M16 != null) {
                                        num6 = Integer.valueOf(M16.c());
                                    } else {
                                        num6 = null;
                                    }
                                    if (Intrinsics.areEqual(num5, num6)) {
                                        com.tencent.qqnt.aio.nick.f M17 = aIOMsgItem.M();
                                        if (M17 != null) {
                                            num7 = Integer.valueOf(M17.g());
                                        } else {
                                            num7 = null;
                                        }
                                        com.tencent.qqnt.aio.nick.f M18 = other.M();
                                        if (M18 != null) {
                                            num8 = Integer.valueOf(M18.g());
                                        } else {
                                            num8 = null;
                                        }
                                        if (Intrinsics.areEqual(num7, num8)) {
                                            com.tencent.qqnt.aio.nick.f M19 = aIOMsgItem.M();
                                            if (M19 != null) {
                                                str3 = M19.j();
                                            } else {
                                                str3 = null;
                                            }
                                            com.tencent.qqnt.aio.nick.f M20 = other.M();
                                            if (M20 != null) {
                                                str4 = M20.j();
                                            }
                                            if (TextUtils.equals(str3, str4)) {
                                                return true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
