package com.qzone.proxy.feedcomponent.model;

import NS_CLIENT_SHOW_ALL_INFO.AllInfo;
import NS_COMM_VIP_GROWTH.IconInfo;
import NS_COMM_VIP_GROWTH.SearchClientShowInfoRsp;
import NS_COMM_VIP_GROWTH.UserClientShowInfo;
import NS_MOBILE_FEEDS.cell_comm_mall;
import SWEET_NEW_PRIVILEGE.sweet_style_info_item;
import android.text.TextUtils;
import com.qzone.proxy.vipcomponent.VipComponentProxy;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.trpcprotocol.sweet.verification.judge.DynamicNickModule;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellMallInfo implements SmartParcelable {

    @NeedParcel
    public CellQQNewVip cellQQNewVip;

    @NeedParcel
    public CellQQUionVip cellQQUionVip;

    @NeedParcel
    public CellSweetVip cellSweetVip;

    @NeedParcel
    public String nickTypeId = "0";

    @NeedParcel
    public String nickUrl = "";

    public static CellMallInfo create(l lVar, String str) {
        cell_comm_mall cell_comm_mallVar;
        if (lVar == null || (cell_comm_mallVar = lVar.f50385w0) == null || cell_comm_mallVar.busi_buff == null) {
            return null;
        }
        CellMallInfo cellMallInfo = new CellMallInfo();
        AllInfo allInfo = (AllInfo) com.qzone.adapter.feedcomponent.i.H().u(AllInfo.class, lVar.f50385w0.busi_buff);
        if (allInfo != null) {
            byte[] bArr = allInfo.vecQQBigVipInfo;
            if (bArr != null) {
                cellMallInfo.cellQQUionVip = CellQQUionVip.create(bArr);
            }
            SearchClientShowInfoRsp searchClientShowInfoRsp = allInfo.stYellowVipInfo;
            if (searchClientShowInfoRsp != null && searchClientShowInfoRsp.iCode == 0) {
                cellMallInfo.cellQQNewVip = CellQQNewVip.create(searchClientShowInfoRsp.stUserClientShowInfo);
            }
            byte[] bArr2 = allInfo.vecSweetStyleInfo;
            if (bArr2 != null) {
                cellMallInfo.cellSweetVip = CellSweetVip.create(bArr2, str);
            }
            if (allInfo.DynamicNickModuleRsp != null) {
                DynamicNickModule dynamicNickModule = new DynamicNickModule();
                try {
                    dynamicNickModule.mergeFrom(allInfo.DynamicNickModuleRsp);
                    cellMallInfo.nickTypeId = "" + dynamicNickModule.style_type.get();
                    cellMallInfo.nickUrl = "" + dynamicNickModule.style_url.get();
                } catch (InvalidProtocolBufferMicroException unused) {
                }
            }
        }
        return cellMallInfo;
    }

    public static CellMallInfo merge(l lVar, CellMallInfo cellMallInfo, String str) {
        cell_comm_mall cell_comm_mallVar;
        if (lVar == null || (cell_comm_mallVar = lVar.f50385w0) == null || cell_comm_mallVar.busi_buff == null) {
            return cellMallInfo;
        }
        CellMallInfo cellMallInfo2 = new CellMallInfo();
        AllInfo allInfo = (AllInfo) com.qzone.adapter.feedcomponent.i.H().u(AllInfo.class, lVar.f50385w0.busi_buff);
        if (allInfo != null) {
            byte[] bArr = allInfo.vecQQBigVipInfo;
            if (bArr != null) {
                cellMallInfo2.cellQQUionVip = CellQQUionVip.create(bArr);
            }
            SearchClientShowInfoRsp searchClientShowInfoRsp = allInfo.stYellowVipInfo;
            if (searchClientShowInfoRsp != null && searchClientShowInfoRsp.iCode == 0) {
                cellMallInfo2.cellQQNewVip = CellQQNewVip.create(searchClientShowInfoRsp.stUserClientShowInfo);
            }
            byte[] bArr2 = allInfo.vecSweetStyleInfo;
            if (bArr2 != null) {
                cellMallInfo2.cellSweetVip = CellSweetVip.create(bArr2, str);
            }
            if (allInfo.DynamicNickModuleRsp != null) {
                DynamicNickModule dynamicNickModule = new DynamicNickModule();
                try {
                    dynamicNickModule.mergeFrom(allInfo.DynamicNickModuleRsp);
                    cellMallInfo2.nickTypeId = "" + dynamicNickModule.style_type.get();
                    cellMallInfo2.nickUrl = "" + dynamicNickModule.style_url.get();
                } catch (InvalidProtocolBufferMicroException unused) {
                }
            }
        } else if (cellMallInfo != null) {
            cellMallInfo2.cellQQUionVip = cellMallInfo.cellQQUionVip;
        }
        return cellMallInfo2;
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class CellQQNewVip implements SmartParcelable {

        @NeedParcel
        public int iLevel;

        @NeedParcel
        public int isShowIcon;

        @NeedParcel
        public Map<String, IconInfo> qqNewVipIconMap;

        public static CellQQNewVip create(UserClientShowInfo userClientShowInfo) {
            if (userClientShowInfo == null) {
                return null;
            }
            CellQQNewVip cellQQNewVip = new CellQQNewVip();
            Map<String, IconInfo> map = userClientShowInfo.mapIconInfo;
            cellQQNewVip.isShowIcon = (map == null || map.size() == 0) ? 0 : 1;
            cellQQNewVip.qqNewVipIconMap = userClientShowInfo.mapIconInfo;
            cellQQNewVip.iLevel = userClientShowInfo.iLevel;
            return cellQQNewVip;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class CellQQUionVip implements SmartParcelable {

        @NeedParcel
        public int iLevel;

        @NeedParcel
        public int iVip;

        @NeedParcel
        public Map<String, IconInfo> qqUnionIconMap;

        @NeedParcel
        public String strUid;

        public static CellQQUionVip create(byte[] bArr) {
            UserClientShowInfo userClientShowInfo;
            if (bArr == null || (userClientShowInfo = (UserClientShowInfo) com.qzone.adapter.feedcomponent.i.H().u(UserClientShowInfo.class, bArr)) == null) {
                return null;
            }
            CellQQUionVip cellQQUionVip = new CellQQUionVip();
            cellQQUionVip.iVip = (userClientShowInfo.iVip <= 0 || userClientShowInfo.iIsUseVipIcon <= 0) ? 0 : 1;
            cellQQUionVip.strUid = userClientShowInfo.strUid;
            cellQQUionVip.iLevel = userClientShowInfo.iLevel;
            cellQQUionVip.qqUnionIconMap = userClientShowInfo.mapIconInfo;
            return cellQQUionVip;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class CellSweetVip implements SmartParcelable {

        @NeedParcel
        public Map<String, String> extendMap;

        @NeedParcel
        public Long iLevel;

        @NeedParcel
        public String iconJumpUrl;

        @NeedParcel
        public String iconPicUrl;

        public static CellSweetVip create(byte[] bArr, String str) {
            if (bArr == null) {
                return null;
            }
            sweet_style_info_item sweet_style_info_itemVar = (sweet_style_info_item) com.qzone.adapter.feedcomponent.i.H().u(sweet_style_info_item.class, bArr);
            if (!TextUtils.isEmpty(str) && !"0".equals(str) && sweet_style_info_itemVar != null && !TextUtils.isEmpty(sweet_style_info_itemVar.pic_url) && !TextUtils.isEmpty(sweet_style_info_itemVar.jump_url)) {
                VipComponentProxy vipComponentProxy = VipComponentProxy.f50997g;
                if (vipComponentProxy.getServiceInterface().getLoveVipInfo("" + str) == null) {
                    vipComponentProxy.getServiceInterface().updateLoveVipInfo(str, sweet_style_info_itemVar);
                }
            }
            if (sweet_style_info_itemVar == null) {
                return null;
            }
            CellSweetVip cellSweetVip = new CellSweetVip();
            cellSweetVip.iLevel = Long.valueOf(sweet_style_info_itemVar.level);
            cellSweetVip.iconPicUrl = sweet_style_info_itemVar.pic_url;
            cellSweetVip.iconJumpUrl = sweet_style_info_itemVar.jump_url;
            cellSweetVip.extendMap = sweet_style_info_itemVar.map_ext;
            return cellSweetVip;
        }
    }
}
