package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template;

import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchNineBoxContent;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchNineBoxGrid;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchPicture;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchPictureDetail;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchReportInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchTemplate;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchVideo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.StFeed;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.StFeedEx;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.StImage;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.StVideo;
import com.tencent.kuikly.core.nvi.serialization.json.JSONException;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchMultiImageVideoTemplateModel extends QSearchBaseTemplateModel {
    public QSearchNineBoxGrid contentData;
    public boolean isContainVideo;
    public int moreCount;
    public int nineBoxGridType;
    public List<List<QSearchMultiMediaInfo>> mediaList = new ArrayList();
    public int contentLines = 6;
    public List<String> feedPbTokenList = new ArrayList();

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List<java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchMultiMediaInfo>>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.util.List<java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchMultiMediaInfo>>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.util.List<java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchMultiMediaInfo>>, java.util.ArrayList] */
    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchBaseTemplateModel, com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel
    public final void appendFeedPbToken(ArrayList<String> arrayList) {
        String str;
        int size = this.mediaList.size();
        for (int i3 = 0; i3 < size; i3++) {
            int size2 = ((List) this.mediaList.get(i3)).size();
            for (int i16 = 0; i16 < size2; i16++) {
                StFeedEx stFeedEx = ((QSearchMultiMediaInfo) ((List) this.mediaList.get(i3)).get(i16)).stFeedEx;
                if (stFeedEx != null && (str = stFeedEx.feedPbToken) != null) {
                    arrayList.add(str);
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.List<java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchMultiMediaInfo>>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.List<java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchMultiMediaInfo>>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.util.List<java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchMultiMediaInfo>>, java.util.ArrayList] */
    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchBaseTemplateModel, com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel
    public final boolean canPlay() {
        if (this.nineBoxGridType == 1) {
            return this.isContainVideo;
        }
        return this.mediaList.size() == 1 && ((List) this.mediaList.get(0)).size() == 1 && ((QSearchMultiMediaInfo) ((List) this.mediaList.get(0)).get(0)).type == 2;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel
    public final boolean isValid() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01ba A[LOOP:1: B:81:0x0195->B:83:0x01ba, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01bc A[EDGE_INSN: B:84:0x01bc->B:85:0x01bc BREAK  A[LOOP:1: B:81:0x0195->B:83:0x01ba], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:91:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r11v6, types: [java.util.List<java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchMultiMediaInfo>>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r14v2, types: [com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchPicture, T] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.util.List<java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchMultiMediaInfo>>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r5v16, types: [java.util.List<java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchMultiMediaInfo>>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.util.List<java.lang.String>, java.util.ArrayList] */
    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchBaseTemplateModel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void parseContent(QSearchTemplate qSearchTemplate) {
        e eVar;
        int k3;
        int i3;
        IntRange until;
        IntProgression step;
        int first;
        int last;
        int step2;
        List listOfNotNull;
        List listOfNotNull2;
        String str;
        boolean isBlank;
        StFeed stFeed;
        int i16;
        int i17;
        StFeed stFeed2;
        String str2;
        super.parseContent(qSearchTemplate);
        QSearchNineBoxGrid decode = new QSearchNineBoxGrid(null, null, null, null, null, null, "", 0, null).decode(new e(qSearchTemplate.data));
        this.contentData = decode;
        List<QSearchNineBoxContent> list = decode.content;
        if (list == null) {
            return;
        }
        Intrinsics.checkNotNull(decode);
        this.nineBoxGridType = decode.nineBoxGridType;
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        int i18 = 0;
        while (true) {
            QSearchPicture qSearchPicture = null;
            if (i18 >= size) {
                break;
            }
            QSearchNineBoxContent qSearchNineBoxContent = list.get(i18);
            int i19 = qSearchNineBoxContent.type;
            QSearchReportInfo qSearchReportInfo = qSearchNineBoxContent.reportInfo;
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            QSearchPictureDetail qSearchPictureDetail = qSearchNineBoxContent.picture;
            objectRef.element = qSearchPictureDetail != null ? qSearchPictureDetail.small : 0;
            if (list.size() == 1) {
                QSearchPictureDetail qSearchPictureDetail2 = qSearchNineBoxContent.picture;
                objectRef.element = qSearchPictureDetail2 != null ? qSearchPictureDetail2.large : 0;
            }
            QSearchVideo qSearchVideo = qSearchNineBoxContent.video;
            if (qSearchVideo != null && (stFeed2 = qSearchVideo.feed) != null) {
                StImage stImage = stFeed2.cover;
                if (stImage == null || (str2 = stImage.picUrl) == null) {
                    if (stImage != null) {
                        str2 = stImage.layerPicUrl;
                    } else {
                        str2 = "";
                    }
                }
                ?? qSearchPicture2 = new QSearchPicture(null, null, 0, 0, null, 31, null);
                qSearchPicture2.picLink = str2;
                qSearchPicture2.jumpLink = qSearchVideo.jumpLink;
                objectRef.element = qSearchPicture2;
            }
            QSearchPicture qSearchPicture3 = (QSearchPicture) objectRef.element;
            if (qSearchPicture3 != null && (str = qSearchPicture3.picLink) != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(str);
                Boolean.valueOf(!isBlank).booleanValue();
                QSearchMultiMediaInfo qSearchMultiMediaInfo = new QSearchMultiMediaInfo();
                qSearchMultiMediaInfo.type = i19;
                if (i19 == 2) {
                    this.isContainVideo = true;
                }
                if (qSearchReportInfo != null) {
                    QSearchTemplateReportInfo qSearchTemplateReportInfo = new QSearchTemplateReportInfo();
                    qSearchTemplateReportInfo.eid = qSearchReportInfo.eid;
                    qSearchTemplateReportInfo.transferInfo = qSearchReportInfo.reportInfo;
                    qSearchMultiMediaInfo.reportInfo = qSearchTemplateReportInfo;
                }
                QSearchPicture qSearchPicture4 = (QSearchPicture) objectRef.element;
                if (qSearchPicture4 != null) {
                    int i26 = qSearchPicture4.width;
                    if (i26 > 0 && (i17 = qSearchPicture4.height) > 0) {
                        qSearchMultiMediaInfo.ratio = i26 / i17;
                    }
                    qSearchPicture = qSearchPicture4;
                }
                qSearchMultiMediaInfo.pictureInfo = qSearchPicture;
                QSearchVideo qSearchVideo2 = qSearchNineBoxContent.video;
                if (qSearchVideo2 != null && (stFeed = qSearchVideo2.feed) != null) {
                    StVideo stVideo = stFeed.video;
                    if (stVideo != null) {
                        int i27 = stVideo.width;
                        if (i27 > 0 && (i16 = stVideo.height) > 0) {
                            qSearchMultiMediaInfo.ratio = i27 / i16;
                        } else {
                            stVideo.width = 232;
                            stVideo.height = (int) (232 / qSearchMultiMediaInfo.ratio);
                        }
                    }
                    StFeedEx stFeedEx = new StFeedEx(stFeed, qSearchVideo2.rawData);
                    stFeedEx.loadFeedPB();
                    qSearchMultiMediaInfo.stFeedEx = stFeedEx;
                }
                StFeedEx stFeedEx2 = qSearchMultiMediaInfo.stFeedEx;
                if (stFeedEx2 != null) {
                    this.feedPbTokenList.add(stFeedEx2.feedPbToken);
                }
                arrayList.add(qSearchMultiMediaInfo);
            }
            i18++;
        }
        int min = Math.min(arrayList.size(), 9);
        QSearchNineBoxGrid qSearchNineBoxGrid = this.contentData;
        String str3 = qSearchNineBoxGrid != null ? qSearchNineBoxGrid.extension : null;
        int size2 = arrayList.size();
        if (str3 != null) {
            try {
                eVar = new e(str3);
                k3 = eVar.k("more_cnt", 0);
            } catch (JSONException unused) {
            }
            if (k3 <= 0) {
                int k16 = eVar.k("total_cnt", 0);
                if (k16 > 0) {
                    size2 = k16;
                }
            } else {
                this.moreCount = k3;
                if (min == 4) {
                    QSearchMultiMediaInfo qSearchMultiMediaInfo2 = new QSearchMultiMediaInfo();
                    qSearchMultiMediaInfo2.type = 1;
                    qSearchMultiMediaInfo2.pictureInfo = null;
                    Unit unit = Unit.INSTANCE;
                    arrayList.add(2, qSearchMultiMediaInfo2);
                    min++;
                }
                i3 = min % 3;
                until = RangesKt___RangesKt.until(0, min - i3);
                step = RangesKt___RangesKt.step(until, 3);
                first = step.getFirst();
                last = step.getLast();
                step2 = step.getStep();
                if ((step2 > 0 && first <= last) || (step2 < 0 && last <= first)) {
                    while (true) {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(arrayList.get(first));
                        arrayList2.add(arrayList.get(first + 1));
                        arrayList2.add(arrayList.get(first + 2));
                        this.mediaList.add(arrayList2);
                        if (first == last) {
                            break;
                        } else {
                            first += step2;
                        }
                    }
                }
                if (i3 == 1) {
                    ?? r56 = this.mediaList;
                    listOfNotNull2 = CollectionsKt__CollectionsKt.listOfNotNull(arrayList.get(min - 1));
                    r56.add(listOfNotNull2);
                }
                if (i3 == 2) {
                    ?? r36 = this.mediaList;
                    listOfNotNull = CollectionsKt__CollectionsKt.listOfNotNull((Object[]) new QSearchMultiMediaInfo[]{(QSearchMultiMediaInfo) arrayList.get(min - 2), (QSearchMultiMediaInfo) arrayList.get(min - 1)});
                    r36.add(listOfNotNull);
                    return;
                }
                return;
            }
        }
        k3 = Math.max(size2 - 9, 0);
        this.moreCount = k3;
        if (min == 4) {
        }
        i3 = min % 3;
        until = RangesKt___RangesKt.until(0, min - i3);
        step = RangesKt___RangesKt.step(until, 3);
        first = step.getFirst();
        last = step.getLast();
        step2 = step.getStep();
        if (step2 > 0) {
            while (true) {
                ArrayList arrayList22 = new ArrayList();
                arrayList22.add(arrayList.get(first));
                arrayList22.add(arrayList.get(first + 1));
                arrayList22.add(arrayList.get(first + 2));
                this.mediaList.add(arrayList22);
                if (first == last) {
                }
                first += step2;
            }
            if (i3 == 1) {
            }
            if (i3 == 2) {
            }
        }
        while (true) {
            ArrayList arrayList222 = new ArrayList();
            arrayList222.add(arrayList.get(first));
            arrayList222.add(arrayList.get(first + 1));
            arrayList222.add(arrayList.get(first + 2));
            this.mediaList.add(arrayList222);
            if (first == last) {
            }
            first += step2;
        }
        if (i3 == 1) {
        }
        if (i3 == 2) {
        }
    }
}
