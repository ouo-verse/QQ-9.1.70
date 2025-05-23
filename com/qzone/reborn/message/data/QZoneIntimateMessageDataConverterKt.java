package com.qzone.reborn.message.data;

import bl.CommonNoticePattonInfo;
import bl.CommonPattonAction;
import bl.CommonStRichMsg;
import com.qzone.reborn.albumx.common.convert.bean.CommonStPicSpecUrlEntry;
import com.qzone.reborn.albumx.common.convert.enumtype.CommonEnumPhotoSpec;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZIntimateSpaceReader$StNotice;
import qzone.QZIntimateSpaceReader$StNoticePattonInfo;
import qzone.QZIntimateSpaceReader$StPattonAction;
import qzone.QZoneBaseMeta$StImage;
import qzone.QZoneBaseMeta$StMedia;
import qzone.QZoneBaseMeta$StRichMsg;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002\u001a\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002\u001a\f\u0010\b\u001a\u00020\u0006*\u00020\u0004H\u0002\u001a\f\u0010\n\u001a\u00020\u0001*\u00020\tH\u0002\u001a\f\u0010\r\u001a\u00020\f*\u00020\u000bH\u0002\u001a\u0016\u0010\u0010\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0002\u001a\u0012\u0010\u0012\u001a\u00020\u0011*\b\u0012\u0004\u0012\u00020\u00060\u0003H\u0002\u00a8\u0006\u0013"}, d2 = {"Lqzone/QZIntimateSpaceReader$StNotice;", "Lbl/c;", "f", "", "Lqzone/QZoneBaseMeta$StRichMsg;", "", "Lbl/h;", "j", "k", "Lqzone/QZIntimateSpaceReader$StNoticePattonInfo;", h.F, "Lqzone/QZIntimateSpaceReader$StPattonAction;", "Lbl/d;", "i", "", "defaultImageUrl", "d", "", "g", "qzone_df_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneIntimateMessageDataConverterKt {
    public static final /* synthetic */ CommonNoticePattonInfo a(QZIntimateSpaceReader$StNotice qZIntimateSpaceReader$StNotice) {
        return f(qZIntimateSpaceReader$StNotice);
    }

    public static final /* synthetic */ CommonPattonAction b(QZIntimateSpaceReader$StPattonAction qZIntimateSpaceReader$StPattonAction) {
        return i(qZIntimateSpaceReader$StPattonAction);
    }

    public static final /* synthetic */ List c(List list) {
        return j(list);
    }

    private static final CommonNoticePattonInfo d(CommonNoticePattonInfo commonNoticePattonInfo, String str) {
        if (commonNoticePattonInfo.getPattonType() == 2 && !k9.a.i(k9.a.k(commonNoticePattonInfo.getLefttxtRightPic().getPicInfo()))) {
            commonNoticePattonInfo.getLefttxtRightPic().getPicInfo().getDefaultUrl().c(str);
            List<CommonStPicSpecUrlEntry> e16 = commonNoticePattonInfo.getLefttxtRightPic().getPicInfo().e();
            CommonStPicSpecUrlEntry commonStPicSpecUrlEntry = new CommonStPicSpecUrlEntry();
            commonStPicSpecUrlEntry.c(CommonEnumPhotoSpec.PHOTO_SPEC_CURRENT.ordinal());
            commonStPicSpecUrlEntry.getUrl().c(str);
            e16.add(commonStPicSpecUrlEntry);
        }
        return commonNoticePattonInfo;
    }

    public static final CommonNoticePattonInfo f(QZIntimateSpaceReader$StNotice qZIntimateSpaceReader$StNotice) {
        QZIntimateSpaceReader$StNoticePattonInfo qZIntimateSpaceReader$StNoticePattonInfo = qZIntimateSpaceReader$StNotice.notice_patton.get();
        Intrinsics.checkNotNullExpressionValue(qZIntimateSpaceReader$StNoticePattonInfo, "notice_patton.get()");
        CommonNoticePattonInfo h16 = h(qZIntimateSpaceReader$StNoticePattonInfo);
        CollectionsKt__MutableCollectionsKt.retainAll((List) h16.getPlainTxt().a(), (Function1) new Function1<CommonStRichMsg, Boolean>() { // from class: com.qzone.reborn.message.data.QZoneIntimateMessageDataConverterKt$getProcessedPattonInfo$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(CommonStRichMsg it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it.getType() == 0);
            }
        });
        CollectionsKt__MutableCollectionsKt.retainAll((List) h16.getLefttxtRightPic().b(), (Function1) new Function1<CommonStRichMsg, Boolean>() { // from class: com.qzone.reborn.message.data.QZoneIntimateMessageDataConverterKt$getProcessedPattonInfo$2
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(CommonStRichMsg it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it.getType() == 0);
            }
        });
        return h16;
    }

    private static final void g(List<CommonStRichMsg> list) {
        for (CommonStRichMsg commonStRichMsg : list) {
            if (commonStRichMsg.getType() == 0) {
                commonStRichMsg.i(QZonePassiveMessageFeedPreprocessor.f58250a.k(commonStRichMsg.getContent(), true));
            }
        }
    }

    private static final CommonNoticePattonInfo h(QZIntimateSpaceReader$StNoticePattonInfo qZIntimateSpaceReader$StNoticePattonInfo) {
        CommonNoticePattonInfo commonNoticePattonInfo = new CommonNoticePattonInfo(0, null, null, false, 15, null);
        commonNoticePattonInfo.f(qZIntimateSpaceReader$StNoticePattonInfo.patton_type.get());
        List<QZoneBaseMeta$StRichMsg> list = qZIntimateSpaceReader$StNoticePattonInfo.plain_txt.txt_info.get();
        Intrinsics.checkNotNullExpressionValue(list, "plain_txt.txt_info.get()");
        CommonNoticePattonInfo.CommonPlainTxtInfo commonPlainTxtInfo = new CommonNoticePattonInfo.CommonPlainTxtInfo(j(list));
        g(commonPlainTxtInfo.a());
        commonNoticePattonInfo.g(commonPlainTxtInfo);
        List<QZoneBaseMeta$StRichMsg> list2 = qZIntimateSpaceReader$StNoticePattonInfo.lefttxt_right_pic.txt_info.get();
        Intrinsics.checkNotNullExpressionValue(list2, "lefttxt_right_pic.txt_info.get()");
        List<CommonStRichMsg> j3 = j(list2);
        QZoneBaseMeta$StImage qZoneBaseMeta$StImage = qZIntimateSpaceReader$StNoticePattonInfo.lefttxt_right_pic.pic_info.get();
        Intrinsics.checkNotNullExpressionValue(qZoneBaseMeta$StImage, "lefttxt_right_pic.pic_info.get()");
        commonNoticePattonInfo.e(new CommonNoticePattonInfo.CommonLeftTxtRightPicInfo(j3, mj.b.a(qZoneBaseMeta$StImage)));
        e(commonNoticePattonInfo, null, 1, null);
        return commonNoticePattonInfo;
    }

    public static final CommonPattonAction i(QZIntimateSpaceReader$StPattonAction qZIntimateSpaceReader$StPattonAction) {
        int i3 = qZIntimateSpaceReader$StPattonAction.action_type.get() == 1 ? 3 : 0;
        String str = qZIntimateSpaceReader$StPattonAction.schema_url.get();
        Intrinsics.checkNotNullExpressionValue(str, "schema_url.get()");
        return new CommonPattonAction(i3, str);
    }

    public static final List<CommonStRichMsg> j(List<QZoneBaseMeta$StRichMsg> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(k((QZoneBaseMeta$StRichMsg) it.next()));
        }
        return arrayList;
    }

    private static final CommonStRichMsg k(QZoneBaseMeta$StRichMsg qZoneBaseMeta$StRichMsg) {
        int i3 = qZoneBaseMeta$StRichMsg.type.get();
        String str = qZoneBaseMeta$StRichMsg.content.get();
        Intrinsics.checkNotNullExpressionValue(str, "content.get()");
        String str2 = qZoneBaseMeta$StRichMsg.uid.get();
        Intrinsics.checkNotNullExpressionValue(str2, "uid.get()");
        String str3 = qZoneBaseMeta$StRichMsg.name.get();
        Intrinsics.checkNotNullExpressionValue(str3, "name.get()");
        int i16 = qZoneBaseMeta$StRichMsg.who.get();
        String str4 = qZoneBaseMeta$StRichMsg.url.get();
        Intrinsics.checkNotNullExpressionValue(str4, "url.get()");
        String str5 = qZoneBaseMeta$StRichMsg.uin.get();
        Intrinsics.checkNotNullExpressionValue(str5, "uin.get()");
        List<QZoneBaseMeta$StMedia> list = qZoneBaseMeta$StRichMsg.media_items.get();
        Intrinsics.checkNotNullExpressionValue(list, "media_items.get()");
        ArrayList arrayList = new ArrayList();
        for (QZoneBaseMeta$StMedia it : list) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList.add(mj.b.b(it));
        }
        return new CommonStRichMsg(i3, str, str2, str3, i16, str4, str5, arrayList);
    }

    static /* synthetic */ CommonNoticePattonInfo e(CommonNoticePattonInfo commonNoticePattonInfo, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = "https://qzonestyle.gtimg.cn/qzone/client/mqq/news/kongjianxiaoxi.png";
        }
        return d(commonNoticePattonInfo, str);
    }
}
