package com.qzone.reborn.message.data;

import androidx.exifinterface.media.ExifInterface;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellCommentInfo;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellFunnyTreadSpace;
import com.qzone.proxy.feedcomponent.model.CellLeftThumb;
import com.qzone.proxy.feedcomponent.model.CellLocalInfo;
import com.qzone.proxy.feedcomponent.model.CellOperationInfo;
import com.qzone.proxy.feedcomponent.model.CellSummary;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.Reply;
import com.qzone.proxy.feedcomponent.util.i;
import com.qzone.reborn.feedx.util.n;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u001d\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b%\u0010&J\u000e\u0010\u0004\u001a\u00020\u0003*\u0004\u0018\u00010\u0002H\u0002J\u000e\u0010\u0005\u001a\u00020\u0003*\u0004\u0018\u00010\u0002H\u0002J\f\u0010\u0006\u001a\u00020\u0003*\u00020\u0002H\u0002J\f\u0010\u0007\u001a\u00020\u0003*\u0004\u0018\u00010\u0002J\f\u0010\b\u001a\u00020\u0003*\u0004\u0018\u00010\u0002J\f\u0010\t\u001a\u00020\u0003*\u0004\u0018\u00010\u0002J\f\u0010\n\u001a\u00020\u0003*\u0004\u0018\u00010\u0002J\f\u0010\u000b\u001a\u00020\u0003*\u0004\u0018\u00010\u0002J\f\u0010\f\u001a\u00020\u0003*\u0004\u0018\u00010\u0002J\f\u0010\r\u001a\u00020\u0003*\u0004\u0018\u00010\u0002J\f\u0010\u000e\u001a\u00020\u0003*\u0004\u0018\u00010\u0002J\f\u0010\u000f\u001a\u00020\u0003*\u0004\u0018\u00010\u0002J\f\u0010\u0010\u001a\u00020\u0003*\u0004\u0018\u00010\u0002J\f\u0010\u0011\u001a\u00020\u0003*\u0004\u0018\u00010\u0002J\f\u0010\u0012\u001a\u00020\u0003*\u0004\u0018\u00010\u0002J\f\u0010\u0013\u001a\u00020\u0003*\u0004\u0018\u00010\u0002J\f\u0010\u0014\u001a\u00020\u0003*\u0004\u0018\u00010\u0002J\f\u0010\u0015\u001a\u00020\u0003*\u0004\u0018\u00010\u0002J\f\u0010\u0016\u001a\u00020\u0003*\u0004\u0018\u00010\u0002J\n\u0010\u0017\u001a\u00020\u0003*\u00020\u0002J\n\u0010\u0018\u001a\u00020\u0003*\u00020\u0002J\n\u0010\u0019\u001a\u00020\u0003*\u00020\u0002J\n\u0010\u001a\u001a\u00020\u0003*\u00020\u0002J\n\u0010\u001b\u001a\u00020\u0003*\u00020\u0002J\n\u0010\u001c\u001a\u00020\u0003*\u00020\u0002J\n\u0010\u001d\u001a\u00020\u0003*\u00020\u0002J\f\u0010\u001e\u001a\u00020\u0003*\u0004\u0018\u00010\u0002J\f\u0010\u001f\u001a\u00020\u0003*\u0004\u0018\u00010\u0002J\f\u0010 \u001a\u00020\u0003*\u0004\u0018\u00010\u0002R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\"0!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010#\u00a8\u0006'"}, d2 = {"Lcom/qzone/reborn/message/data/f;", "", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "", "i", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "p", "g", DomainData.DOMAIN_NAME, "l", h.F, "t", "k", "d", ReportConstant.COSTREPORT_PREFIX, "w", "v", BdhLogUtil.LogTag.Tag_Conn, "c", HippyTKDListViewAdapter.X, "u", "B", "a", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "y", "j", "r", "e", "f", "b", "", "", "Ljava/util/Set;", "canInteractApp", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f58260a = new f();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Set<Integer> canInteractApp;

    static {
        Set<Integer> of5;
        of5 = SetsKt__SetsKt.setOf((Object[]) new Integer[]{311, 4, 202, 6100, 423, 2, 7035});
        canInteractApp = of5;
    }

    f() {
    }

    private final boolean i(BusinessFeedData businessFeedData) {
        boolean contains;
        CellFeedCommInfo feedCommInfo;
        contains = CollectionsKt___CollectionsKt.contains(canInteractApp, (businessFeedData == null || (feedCommInfo = businessFeedData.getFeedCommInfo()) == null) ? null : Integer.valueOf(feedCommInfo.appid));
        return contains;
    }

    private final boolean p(BusinessFeedData businessFeedData) {
        return businessFeedData.getUser().curUserType == 52;
    }

    public final boolean f(BusinessFeedData businessFeedData) {
        CellSummary cellSummaryV2;
        String str;
        boolean startsWith$default;
        boolean endsWith$default;
        CellSummary cellSummaryV22;
        if (e(businessFeedData)) {
            return true;
        }
        String str2 = (businessFeedData == null || (cellSummaryV22 = businessFeedData.getCellSummaryV2()) == null) ? null : cellSummaryV22.customPraiseStr;
        if (!(str2 == null || str2.length() == 0)) {
            return true;
        }
        if (businessFeedData != null && (cellSummaryV2 = businessFeedData.getCellSummaryV2()) != null && (str = cellSummaryV2.summary) != null) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, "[em]e10071[/em]", false, 2, null);
            if (startsWith$default) {
                endsWith$default = StringsKt__StringsJVMKt.endsWith$default(str, ",text:\u7acb\u5373\u8bbe\u7f6e}", false, 2, null);
                if (endsWith$default) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean j(BusinessFeedData businessFeedData) {
        Intrinsics.checkNotNullParameter(businessFeedData, "<this>");
        return q(businessFeedData) && businessFeedData.getUser().uin == 211178900;
    }

    public final boolean k(BusinessFeedData businessFeedData) {
        return l(businessFeedData) && !t(businessFeedData);
    }

    public final boolean m(BusinessFeedData businessFeedData) {
        Intrinsics.checkNotNullParameter(businessFeedData, "<this>");
        CellFeedCommInfo feedCommInfoV2 = businessFeedData.getFeedCommInfoV2();
        if (feedCommInfoV2 != null && feedCommInfoV2.isShowGoMessageBoard()) {
            return true;
        }
        CellFeedCommInfo feedCommInfoV22 = businessFeedData.getFeedCommInfoV2();
        return feedCommInfoV22 != null && feedCommInfoV22.appid == 334;
    }

    public final boolean o(BusinessFeedData businessFeedData) {
        Intrinsics.checkNotNullParameter(businessFeedData, "<this>");
        CellFeedCommInfo feedCommInfoV2 = businessFeedData.getFeedCommInfoV2();
        if (feedCommInfoV2 != null && feedCommInfoV2.appid == 333) {
            CellLocalInfo localInfoV2 = businessFeedData.getLocalInfoV2();
            if (localInfoV2 != null && localInfoV2.canReturnGift) {
                return true;
            }
        }
        return false;
    }

    public final boolean q(BusinessFeedData businessFeedData) {
        boolean z16;
        Intrinsics.checkNotNullParameter(businessFeedData, "<this>");
        CellFeedCommInfo feedCommInfoV2 = businessFeedData.getFeedCommInfoV2();
        if (!(feedCommInfoV2 != null && feedCommInfoV2.appid == 312)) {
            CellFeedCommInfo feedCommInfoV22 = businessFeedData.getFeedCommInfoV2();
            if (!(feedCommInfoV22 != null && feedCommInfoV22.appid == 333)) {
                z16 = false;
                return (p(businessFeedData) || !z16 || y(businessFeedData)) ? false : true;
            }
        }
        z16 = true;
        if (p(businessFeedData)) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean r(BusinessFeedData businessFeedData) {
        boolean z16;
        boolean z17;
        String summary;
        boolean endsWith$default;
        String str;
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(businessFeedData, "<this>");
        CellFeedCommInfo feedCommInfoV2 = businessFeedData.getFeedCommInfoV2();
        if (feedCommInfoV2 != null && feedCommInfoV2.appid == 312) {
            CellFeedCommInfo cellFeedCommInfo = businessFeedData.cellFeedCommInfo;
            if (cellFeedCommInfo != null && (str = cellFeedCommInfo.actionurl) != null) {
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, "mqzone://arouse/homepage?uin=", false, 2, null);
                if (startsWith$default) {
                    z16 = true;
                    if (z16) {
                        CellLeftThumb leftThumb = businessFeedData.getLeftThumb();
                        if (leftThumb != null && (summary = leftThumb.getSummary()) != null) {
                            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(summary, "\u540c\u610f\u4e86\u4f60\u7684\u7a7a\u95f4\u8bbf\u95ee\u7533\u8bf7", false, 2, null);
                            if (endsWith$default) {
                                z17 = true;
                                if (z17) {
                                    return true;
                                }
                            }
                        }
                        z17 = false;
                        if (z17) {
                        }
                    }
                }
            }
            z16 = false;
            if (z16) {
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean t(BusinessFeedData businessFeedData) {
        CellFeedCommInfo feedCommInfoV2;
        List list;
        Object last;
        boolean z16;
        boolean z17;
        CellCommentInfo commentInfoV2;
        ArrayList<Comment> arrayList;
        Object firstOrNull;
        List<Reply> list2;
        int collectionSizeOrDefault;
        if (!l(businessFeedData) || businessFeedData == null || (feedCommInfoV2 = businessFeedData.getFeedCommInfoV2()) == null) {
            return false;
        }
        int time = (int) (feedCommInfoV2.getTime() / 1000);
        int i3 = businessFeedData.getMainComment().time;
        BusinessFeedData originalInfo = businessFeedData.getOriginalInfo();
        if (originalInfo != null && (commentInfoV2 = originalInfo.getCommentInfoV2()) != null && (arrayList = commentInfoV2.commments) != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
            Comment comment = (Comment) firstOrNull;
            if (comment != null && (list2 = comment.replies) != null) {
                List<Reply> list3 = list2;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it = list3.iterator();
                while (it.hasNext()) {
                    arrayList2.add(Integer.valueOf(((Reply) it.next()).date));
                }
                list = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList2);
                if (time != i3) {
                    return false;
                }
                List list4 = list;
                if (!(list4 == null || list4.isEmpty())) {
                    last = CollectionsKt___CollectionsKt.last((List<? extends Object>) list);
                    int intValue = ((Number) last).intValue();
                    boolean z18 = time > intValue;
                    if (!list.contains(Integer.valueOf(time))) {
                        if (!(i3 <= time && time <= intValue)) {
                            z16 = false;
                            return !z18 || z16;
                        }
                    }
                    z16 = true;
                    if (z18) {
                    }
                }
                boolean z19 = time > i3;
                String commentText = businessFeedData.getMainComment().comment;
                String summaryText = n.e(businessFeedData);
                if (time - 1 == i3) {
                    Intrinsics.checkNotNullExpressionValue(commentText, "commentText");
                    if (commentText.length() > 0) {
                        Intrinsics.checkNotNullExpressionValue(summaryText, "summaryText");
                        if ((summaryText.length() > 0) && Intrinsics.areEqual(commentText, summaryText)) {
                            z17 = true;
                            return !z19 ? false : false;
                        }
                    }
                }
                z17 = false;
                return !z19 ? false : false;
            }
        }
        list = null;
        if (time != i3) {
        }
    }

    public final boolean y(BusinessFeedData businessFeedData) {
        String str;
        boolean contains$default;
        Intrinsics.checkNotNullParameter(businessFeedData, "<this>");
        CellFeedCommInfo feedCommInfoV2 = businessFeedData.getFeedCommInfoV2();
        if (feedCommInfoV2 == null || (str = feedCommInfoV2.ugckey) == null) {
            return false;
        }
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "urgeupdate", false, 2, (Object) null);
        return contains$default;
    }

    public final boolean z(BusinessFeedData businessFeedData) {
        Intrinsics.checkNotNullParameter(businessFeedData, "<this>");
        CellFunnyTreadSpace cellFunnyTreadSpace = businessFeedData.cellFunnyTreadSpace;
        List<String> list = cellFunnyTreadSpace != null ? cellFunnyTreadSpace.actions : null;
        return !(list == null || list.isEmpty());
    }

    public final boolean b(BusinessFeedData businessFeedData) {
        return (businessFeedData != null ? businessFeedData.getPermissionInfoV2() : null) != null && (businessFeedData.getPermissionInfoV2().permission_mask & 1) > 0;
    }

    public final boolean d(BusinessFeedData businessFeedData) {
        CellLocalInfo localInfoV2 = businessFeedData != null ? businessFeedData.getLocalInfoV2() : null;
        if (localInfoV2 != null && !localInfoV2.canReturnGift) {
            CellFeedCommInfo feedCommInfoV2 = businessFeedData.getFeedCommInfoV2();
            if (!(feedCommInfoV2 != null && feedCommInfoV2.appid == 333)) {
                return localInfoV2.canComment || localInfoV2.canReferComment || localInfoV2.canReply || localInfoV2.canReferReply;
            }
        }
        return false;
    }

    private final boolean A(BusinessFeedData businessFeedData) {
        if (!(businessFeedData != null && businessFeedData.feedType == 4098)) {
            return false;
        }
        CellOperationInfo operationInfoV2 = businessFeedData.getOperationInfoV2();
        if ((operationInfoV2 != null ? operationInfoV2.busiParam : null) != null) {
            return Intrinsics.areEqual("1", businessFeedData.getOperationInfoV2().busiParam.get(156));
        }
        return false;
    }

    public final boolean e(BusinessFeedData businessFeedData) {
        CellSummary cellSummaryV2;
        Map<String, String> map;
        if (((businessFeedData == null || (cellSummaryV2 = businessFeedData.getCellSummaryV2()) == null || (map = cellSummaryV2.mapExt) == null) ? null : map.get("guide_text")) != null) {
            CellSummary cellSummaryV22 = businessFeedData.getCellSummaryV2();
            if ((cellSummaryV22 != null ? cellSummaryV22.barrageEffectInfo : null) != null) {
                return true;
            }
        }
        return false;
    }

    public final boolean B(BusinessFeedData businessFeedData) {
        if (businessFeedData != null && businessFeedData.feedType == 4098) {
            CellFeedCommInfo feedCommInfoV2 = businessFeedData.getFeedCommInfoV2();
            if (feedCommInfoV2 != null && feedCommInfoV2.isHighFiveAgain()) {
                return true;
            }
        }
        return false;
    }

    public final boolean C(BusinessFeedData businessFeedData) {
        return businessFeedData != null && businessFeedData.feedType == 4098 && i.h(businessFeedData);
    }

    public final boolean a(BusinessFeedData businessFeedData) {
        return (businessFeedData != null && businessFeedData.feedType == 4098) && i.g(businessFeedData);
    }

    public final boolean c(BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return false;
        }
        return C(businessFeedData) || A(businessFeedData) || B(businessFeedData);
    }

    public final boolean g(BusinessFeedData businessFeedData) {
        CellFeedCommInfo cellFeedCommInfo;
        CellFeedCommInfo cellFeedCommInfo2;
        if ((businessFeedData == null || (cellFeedCommInfo2 = businessFeedData.getCellFeedCommInfo()) == null || cellFeedCommInfo2.appid != 4) ? false : true) {
            return true;
        }
        return businessFeedData != null && (cellFeedCommInfo = businessFeedData.getCellFeedCommInfo()) != null && cellFeedCommInfo.appid == 423;
    }

    public final boolean h(BusinessFeedData businessFeedData) {
        boolean startsWith$default;
        if (businessFeedData == null) {
            return false;
        }
        String e16 = n.e(businessFeedData);
        Intrinsics.checkNotNullExpressionValue(e16, "getSummaryText(this)");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(e16, "[em]e10035[/em] \u63d0\u5230\u6211", false, 2, null);
        return startsWith$default;
    }

    public final boolean l(BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return false;
        }
        CellLocalInfo localInfoV2 = businessFeedData.getLocalInfoV2();
        return (localInfoV2 != null && !localInfoV2.canReturnGift && (localInfoV2.canReply || localInfoV2.canReferReply)) && (!C(businessFeedData) && !u(businessFeedData)) && i(businessFeedData);
    }

    public final boolean n(BusinessFeedData businessFeedData) {
        CellFeedCommInfo cellFeedCommInfo;
        CellFeedCommInfo cellFeedCommInfo2;
        CellFeedCommInfo cellFeedCommInfo3;
        if ((businessFeedData == null || (cellFeedCommInfo3 = businessFeedData.getCellFeedCommInfo()) == null || cellFeedCommInfo3.appid != 311) ? false : true) {
            return true;
        }
        if ((businessFeedData == null || (cellFeedCommInfo2 = businessFeedData.getCellFeedCommInfo()) == null || cellFeedCommInfo2.appid != 202) ? false : true) {
            return true;
        }
        return businessFeedData != null && (cellFeedCommInfo = businessFeedData.getCellFeedCommInfo()) != null && cellFeedCommInfo.appid == 6100;
    }

    public final boolean s(BusinessFeedData businessFeedData) {
        if (businessFeedData == null || !C(businessFeedData)) {
            return false;
        }
        CellFeedCommInfo feedCommInfoV2 = businessFeedData.getFeedCommInfoV2();
        return !(feedCommInfoV2 != null && feedCommInfoV2.appid == 217);
    }

    public final boolean u(BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return false;
        }
        if (A(businessFeedData) || businessFeedData.isFakeHighFive) {
            return true;
        }
        return B(businessFeedData) && !a(businessFeedData);
    }

    public final boolean v(BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return false;
        }
        boolean z16 = !s(businessFeedData) && (x(businessFeedData) || u(businessFeedData));
        CellSummary cellSummaryV2 = businessFeedData.getCellSummaryV2();
        String str = cellSummaryV2 != null ? cellSummaryV2.customPraiseStr : null;
        return z16 && (str == null || str.length() == 0);
    }

    public final boolean w(BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return false;
        }
        CellSummary cellSummaryV2 = businessFeedData.getCellSummaryV2();
        String str = cellSummaryV2 != null ? cellSummaryV2.customPraiseStr : null;
        return s(businessFeedData) && (str == null || str.length() == 0);
    }

    public final boolean x(BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return false;
        }
        if (!C(businessFeedData) || A(businessFeedData)) {
            return B(businessFeedData) && a(businessFeedData);
        }
        return true;
    }
}
