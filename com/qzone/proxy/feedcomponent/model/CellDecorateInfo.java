package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_COMM.PicDecorateInfo;
import NS_MOBILE_FEEDS.cell_decorate;
import NS_MOBILE_FEEDS.cnst.PICDECORATE;
import NS_MOBILE_FEEDS.s_KapuPraise;
import NS_MOBILE_FEEDS.s_PolyPraise;
import NS_MOBILE_FEEDS.s_PrdData;
import NS_MOBILE_FEEDS.stcustomPraise;
import android.text.TextUtils;
import com.qzone.homepage.business.model.QzoneCustomTrackData;
import com.qzone.personalize.business.FeedSkinData;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellDecorateInfo implements SmartParcelable {

    @NeedParcel
    public CellCustomPraise cellCustomPraise;

    @NeedParcel
    public CellGiftData cellGiftData;

    @NeedParcel
    public ArrayList<CellKapuPraise> cellKapuPraiseList;

    @NeedParcel
    public ArrayList<CellPolymorphicPraise> cellPokePraiseList;

    @NeedParcel
    public CellPolymorphicPraise cellPolymorphicPraise;

    @NeedParcel
    public CellPrdData cellPrdData;

    @NeedParcel
    public QzoneCustomTrackData customTrackDeco;

    @NeedParcel
    public FeedSkinData skinData;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class CellPolymorphicPraise implements SmartParcelable {

        @NeedParcel
        public int iItemId;

        @NeedParcel
        public String strPraisePic = "";

        @NeedParcel
        public String strText = "";

        @NeedParcel
        public int itype = 0;

        @NeedParcel
        public int resourceId = 0;

        @NeedParcel
        public int combo = 0;

        public static CellPolymorphicPraise create(cell_decorate cell_decorateVar) {
            if (cell_decorateVar == null) {
                return null;
            }
            return create(cell_decorateVar.polyPraise);
        }

        public static CellPolymorphicPraise create(s_PolyPraise s_polypraise) {
            if (s_polypraise == null) {
                return null;
            }
            CellPolymorphicPraise cellPolymorphicPraise = new CellPolymorphicPraise();
            cellPolymorphicPraise.iItemId = s_polypraise.iItemId;
            cellPolymorphicPraise.strPraisePic = s_polypraise.strPicUrl;
            cellPolymorphicPraise.strText = s_polypraise.strText;
            cellPolymorphicPraise.itype = s_polypraise.itype;
            cellPolymorphicPraise.resourceId = s_polypraise.resourceId;
            cellPolymorphicPraise.combo = s_polypraise.pokeLikeCombo;
            return cellPolymorphicPraise;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class CellCustomPraise implements SmartParcelable {

        @NeedParcel
        public int cmShowActionId;

        @NeedParcel
        public int iFrameRate;

        @NeedParcel
        public int iItemId;

        @NeedParcel
        public int subType;

        @NeedParcel
        public int type;

        @NeedParcel
        public long uiComboCount;

        @NeedParcel
        public String strPraisePic = "";

        @NeedParcel
        public String strPraiseZip = "";

        @NeedParcel
        public String strPraiseComboZip = "";

        @NeedParcel
        public String strPraiseButton = "";

        public static CellCustomPraise create(cell_decorate cell_decorateVar) {
            if (cell_decorateVar == null || cell_decorateVar.customPraise == null) {
                return null;
            }
            CellCustomPraise cellCustomPraise = new CellCustomPraise();
            stcustomPraise stcustompraise = cell_decorateVar.customPraise;
            cellCustomPraise.iItemId = stcustompraise.iItemId;
            cellCustomPraise.iFrameRate = stcustompraise.iFrameRate;
            cellCustomPraise.strPraiseButton = stcustompraise.strPraiseButton;
            cellCustomPraise.strPraiseComboZip = stcustompraise.strPraiseComboZip;
            cellCustomPraise.strPraisePic = stcustompraise.strPraisePic;
            cellCustomPraise.strPraiseZip = stcustompraise.strPraiseZip;
            cellCustomPraise.type = stcustompraise.customPraisetype;
            cellCustomPraise.uiComboCount = stcustompraise.uiComboCount;
            cellCustomPraise.subType = stcustompraise.subpraisetype;
            cellCustomPraise.cmShowActionId = stcustompraise.iPraiseActId;
            return cellCustomPraise;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class CellPrdData implements SmartParcelable {

        @NeedParcel
        public int iType = 0;

        @NeedParcel
        public String strResUrl = "";

        @NeedParcel
        public String strColorBegin = "";

        @NeedParcel
        public String strColorEnd = "";

        public static CellPrdData create(cell_decorate cell_decorateVar) {
            s_PrdData s_prddata;
            if (cell_decorateVar == null || (s_prddata = cell_decorateVar.sprdData) == null || s_prddata.iType == -1 || TextUtils.isEmpty(s_prddata.strResUrl)) {
                return null;
            }
            CellPrdData cellPrdData = new CellPrdData();
            s_PrdData s_prddata2 = cell_decorateVar.sprdData;
            cellPrdData.iType = s_prddata2.iType;
            cellPrdData.strResUrl = s_prddata2.strResUrl;
            cellPrdData.strColorBegin = s_prddata2.strColorBegin;
            cellPrdData.strColorEnd = s_prddata2.strColorEnd;
            return cellPrdData;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class CellGiftData implements SmartParcelable {
        public static final int INDEX_CARD = 1;
        public static final int INDEX_GIFT = 2;
        public static final int TYPE_GIFT = 1;
        public static final int TYPE_NEW_YEAR_SIGN = 2;

        @NeedParcel
        public int iType = -1;

        @NeedParcel
        public String strReverseUrl = "";

        @NeedParcel
        public String strPlayZipUrl = "";

        @NeedParcel
        public String actionUrl = "";

        @NeedParcel
        public String positiveUrl = "";

        @NeedParcel
        public boolean isFirst = true;

        @NeedParcel
        public int currentIndex = 0;

        public static CellGiftData create(cell_decorate cell_decorateVar) {
            Map<String, byte[]> map;
            PicDecorateInfo picDecorateInfo;
            if (cell_decorateVar == null || (map = cell_decorateVar.mapInfoData) == null || !map.containsKey(PICDECORATE.value) || (picDecorateInfo = (PicDecorateInfo) com.qzone.adapter.feedcomponent.i.H().u(PicDecorateInfo.class, cell_decorateVar.mapInfoData.get(PICDECORATE.value))) == null) {
                return null;
            }
            CellGiftData cellGiftData = new CellGiftData();
            cellGiftData.iType = picDecorateInfo.iType;
            cellGiftData.strReverseUrl = picDecorateInfo.strReverseUrl;
            cellGiftData.strPlayZipUrl = picDecorateInfo.strPlayZipUrl;
            return cellGiftData;
        }
    }

    public static CellDecorateInfo create(l lVar) {
        if (lVar == null || lVar.f50347d0 == null) {
            return null;
        }
        CellDecorateInfo cellDecorateInfo = new CellDecorateInfo();
        cellDecorateInfo.cellCustomPraise = CellCustomPraise.create(lVar.f50347d0);
        cellDecorateInfo.cellPolymorphicPraise = CellPolymorphicPraise.create(lVar.f50347d0);
        cellDecorateInfo.cellPrdData = CellPrdData.create(lVar.f50347d0);
        cellDecorateInfo.skinData = com.qzone.proxy.feedcomponent.util.e.b(lVar.f50347d0);
        cellDecorateInfo.cellGiftData = CellGiftData.create(lVar.f50347d0);
        cellDecorateInfo.customTrackDeco = com.qzone.proxy.feedcomponent.util.e.a(lVar.f50347d0);
        cell_decorate cell_decorateVar = lVar.f50347d0;
        if (cell_decorateVar != null && cell_decorateVar.pokePraise != null) {
            cellDecorateInfo.cellPokePraiseList = new ArrayList<>(lVar.f50347d0.pokePraise.size());
            Iterator<s_PolyPraise> it = lVar.f50347d0.pokePraise.iterator();
            while (it.hasNext()) {
                CellPolymorphicPraise create = CellPolymorphicPraise.create(it.next());
                if (create != null) {
                    cellDecorateInfo.cellPokePraiseList.add(create);
                }
            }
        }
        cell_decorate cell_decorateVar2 = lVar.f50347d0;
        if (cell_decorateVar2 != null && cell_decorateVar2.kapuPraise != null) {
            cellDecorateInfo.cellKapuPraiseList = new ArrayList<>(lVar.f50347d0.kapuPraise.size());
            Iterator<s_KapuPraise> it5 = lVar.f50347d0.kapuPraise.iterator();
            while (it5.hasNext()) {
                CellKapuPraise create2 = CellKapuPraise.create(it5.next());
                if (create2 != null) {
                    cellDecorateInfo.cellKapuPraiseList.add(create2);
                }
            }
        }
        return cellDecorateInfo;
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class CellKapuPraise implements SmartParcelable {

        @NeedParcel
        public int iItemId;

        @NeedParcel
        public long iCount = 0;

        @NeedParcel
        public String strName = "";

        public static CellKapuPraise create(s_KapuPraise s_kapupraise) {
            if (s_kapupraise == null) {
                return null;
            }
            CellKapuPraise cellKapuPraise = new CellKapuPraise();
            cellKapuPraise.iItemId = s_kapupraise.iItemId;
            cellKapuPraise.iCount = s_kapupraise.iCount;
            cellKapuPraise.strName = s_kapupraise.strName;
            return cellKapuPraise;
        }
    }
}
