package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.cell_like;
import NS_MOBILE_FEEDS.s_likeman;
import com.qzone.proxy.feedcomponent.service.QzonePolymorphicPraiseService;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellLikeInfo implements SmartParcelable {
    public static final String LIKE_LIST_TAB = "praise_list";
    public boolean isFakeOperation;

    @NeedParcel
    public boolean isLiked;

    @NeedParcel
    public ArrayList<LikeMan> likeMans;

    @NeedParcel
    public int likeNum;
    public String unikey;
    public boolean stateChanged = true;
    public String displayStr = "";
    public Integer integerUnikey = -1;

    @NeedParcel
    public String likeNumInfoFoldTxt = "";

    @NeedParcel
    public String likeKey = "";

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class LikeMan implements SmartParcelable {
        public static final int LIKE_TYPE_CUSTOM = 2;
        public static final int LIKE_TYPE_NORMAL = 0;
        public static final int LIKE_TYPE_SUPER = 1;
        public static final int Like_TYPE_POLY = 3;

        @NeedParcel
        public int likeType;

        @NeedParcel
        public PolymorphicPraiseEmotionData polymorphicPraiseData;

        @NeedParcel
        public User user;

        public LikeMan() {
        }

        public LikeMan(User user, int i3, CustomPraiseData customPraiseData) {
            this.user = user;
            this.likeType = i3;
        }

        public LikeMan(User user, int i3, CustomPraiseData customPraiseData, PolymorphicPraiseEmotionData polymorphicPraiseEmotionData) {
            this.user = user;
            this.likeType = i3;
            this.polymorphicPraiseData = polymorphicPraiseEmotionData;
        }
    }

    public List<LikeMan> getUserList() {
        ArrayList<LikeMan> arrayList = this.likeMans;
        if (arrayList != null) {
            Iterator<LikeMan> it = arrayList.iterator();
            while (it.hasNext()) {
                LikeMan next = it.next();
                if (next != null && !(next instanceof LikeMan)) {
                    it.remove();
                }
            }
        }
        return this.likeMans;
    }

    public static CellLikeInfo create(l lVar) {
        if (lVar == null || lVar.f50364m == null) {
            return null;
        }
        CellLikeInfo cellLikeInfo = new CellLikeInfo();
        cell_like cell_likeVar = lVar.f50364m;
        cellLikeInfo.likeNum = cell_likeVar.num;
        cellLikeInfo.isLiked = cell_likeVar.isliked == 1;
        cellLikeInfo.likeNumInfoFoldTxt = cell_likeVar.txt;
        cellLikeInfo.isFakeOperation = false;
        if (cell_likeVar.likemans != null) {
            cellLikeInfo.likeMans = new ArrayList<>();
            int size = lVar.f50364m.likemans.size();
            for (int i3 = 0; i3 < size; i3++) {
                LikeMan likeMan = new LikeMan();
                s_likeman s_likemanVar = lVar.f50364m.likemans.get(i3);
                User q16 = com.qzone.proxy.feedcomponent.util.e.q(s_likemanVar.user);
                likeMan.user = q16;
                if (q16 != null) {
                    q16.superLike = s_likemanVar.superflag;
                }
                likeMan.polymorphicPraiseData = PolymorphicPraiseEmotionData.createFrom(s_likemanVar.cpolyPraise);
                likeMan.likeType = s_likemanVar.superflag;
                cellLikeInfo.likeMans.add(likeMan);
                QzonePolymorphicPraiseService.getInstance().preLoadRes(likeMan.polymorphicPraiseData);
            }
        }
        return cellLikeInfo;
    }
}
