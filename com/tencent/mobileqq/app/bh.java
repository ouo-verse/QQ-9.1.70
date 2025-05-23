package com.tencent.mobileqq.app;

import NearbyGroup.RspGetAreaList;
import NearbyGroup.RspGetGroupInArea;
import NearbyGroup.RspGetNearbyGroup;
import NeighborSvc.RespGetNeighbors;
import com.tencent.av.service.LBSInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import tencent.im.oidb.cmd0x7f5.cmd0x7f5$GroupInfo;

/* compiled from: P */
/* loaded from: classes11.dex */
public class bh implements BusinessObserver {
    static IPatchRedirector $redirector_;

    public bh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void handleGetAreaList(boolean z16, Object obj) {
        if (z16) {
            if (obj == null) {
                onGetAreaList(true, null, false);
                return;
            }
            Object[] objArr = (Object[]) obj;
            onGetAreaList(true, (RspGetAreaList) objArr[1], ((Boolean) objArr[0]).booleanValue());
            return;
        }
        onGetAreaList(false, null, false);
    }

    private void handleGetFace2FaceNearbyUserList(boolean z16, Object obj) {
        if (obj == null) {
            return;
        }
        Object[] objArr = (Object[]) obj;
        onGetFaceToFaceNearbyUserList(z16, (List) objArr[0], ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
    }

    private void handleGetGroupInArea(boolean z16, Object obj) {
        if (z16) {
            if (obj == null) {
                onGetGroupInArea(true, null);
                return;
            } else {
                onGetGroupInArea(true, (RspGetGroupInArea) ((Object[]) obj)[0]);
                return;
            }
        }
        onGetGroupInArea(false, null);
    }

    private void handleGetGroups(boolean z16, Object[] objArr) {
        int intValue = ((Integer) objArr[0]).intValue();
        boolean booleanValue = ((Boolean) objArr[1]).booleanValue();
        RspGetNearbyGroup rspGetNearbyGroup = (RspGetNearbyGroup) objArr[2];
        if (z16) {
            onGetGroups(intValue, true, booleanValue, rspGetNearbyGroup);
        } else {
            onGetGroups(intValue, false, booleanValue, rspGetNearbyGroup);
        }
    }

    private void handleGetNeighbors(boolean z16, Object obj) {
        if (z16) {
            if (obj == null) {
                return;
            }
            Object[] objArr = (Object[]) obj;
            onUpdateNeighbors(true, (String) objArr[0], (RespGetNeighbors) objArr[1], ((Boolean) objArr[2]).booleanValue(), 0);
            return;
        }
        onUpdateNeighbors(false, null, null, false, -1);
    }

    private void handleGetPoi(boolean z16, Object obj) {
        if (obj == null) {
            return;
        }
        if (z16) {
            Object[] objArr = (Object[]) obj;
            onUpdatePOI(true, (byte[]) objArr[0], (String) objArr[1], (String) objArr[2], (String) objArr[3]);
        } else {
            onUpdatePOI(false, (byte[]) obj, null, null, null);
        }
    }

    private void handleGetStreetViewUrl(boolean z16, Object obj) {
        if (z16 && obj != null) {
            onGetStreetViewUrl(true, (byte[]) obj);
        }
    }

    private void handleGetSwitcher(boolean z16, Object[] objArr) {
        if (z16) {
            onUpdateGetSwitch(true, ((Integer) objArr[0]).intValue(), ((Boolean) objArr[1]).booleanValue());
        } else {
            onUpdateGetSwitch(false, -1, false);
        }
    }

    private void handleGetUserCurrentLocation(boolean z16, Object obj) {
        if (z16 && obj != null) {
            Object[] objArr = (Object[]) obj;
            onGetUserLocation(true, new LBSInfo(String.valueOf(objArr[0]), String.valueOf(objArr[1]), String.valueOf(objArr[2]), String.valueOf(objArr[3]), String.valueOf(objArr[4]), String.valueOf(objArr[5]), String.valueOf(objArr[6]), String.valueOf(objArr[7]), ((Integer) objArr[8]).doubleValue(), ((Integer) objArr[9]).doubleValue(), ((Integer) objArr[10]).doubleValue(), (String[]) objArr[11]));
        } else {
            onGetUserLocation(false, null);
        }
    }

    private void handleSetShowInNearbyTroops(boolean z16, Object obj) {
        if (z16 && obj != null) {
            Object[] objArr = (Object[]) obj;
            onGetSetShowInNearbyTroopsResult(true, ((Long) objArr[0]).longValue(), ((Boolean) objArr[1]).booleanValue());
        } else {
            onGetSetShowInNearbyTroopsResult(false, 0L, false);
        }
    }

    protected void onGetAreaList(boolean z16, RspGetAreaList rspGetAreaList, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), rspGetAreaList, Boolean.valueOf(z17));
        }
    }

    protected void onGetEntrance(boolean z16, Object[] objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Boolean.valueOf(z16), objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onGetFaceToFaceNearbyUserList(boolean z16, List<com.tencent.mobileqq.facetoface.g> list, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Boolean.valueOf(z16), list, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onGetFaceToFaceNearbyUserPush(com.tencent.mobileqq.facetoface.g gVar, boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, gVar, Boolean.valueOf(z16), Integer.valueOf(i3));
        }
    }

    protected void onGetGroupInArea(boolean z16, RspGetGroupInArea rspGetGroupInArea) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(z16), rspGetGroupInArea);
        }
    }

    protected void onGetGroups(int i3, boolean z16, boolean z17, RspGetNearbyGroup rspGetNearbyGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17), rspGetNearbyGroup);
        }
    }

    protected void onGetLbsShareSearch(boolean z16, Object[] objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Boolean.valueOf(z16), objArr);
        }
    }

    protected void onGetLbsShareShop(boolean z16, Object[] objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Boolean.valueOf(z16), objArr);
        }
    }

    protected void onGetNearbyRecommender(boolean z16, Object[] objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Boolean.valueOf(z16), objArr);
        }
    }

    protected void onGetNewNearbyTroops(boolean z16, int i3, cmd0x7f5$GroupInfo cmd0x7f5_groupinfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), Integer.valueOf(i3), cmd0x7f5_groupinfo);
        }
    }

    protected void onGetSetShowInNearbyTroopsResult(boolean z16, long j3, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Boolean.valueOf(z16), Long.valueOf(j3), Boolean.valueOf(z17));
        }
    }

    protected void onGetShareShopDetail(boolean z16, Object[] objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Boolean.valueOf(z16), objArr);
        }
    }

    protected void onGetStreetViewUrl(boolean z16, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Boolean.valueOf(z16), bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onGetUserLocation(boolean z16, LBSInfo lBSInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Boolean.valueOf(z16), lBSInfo);
        }
    }

    protected void onRcvNearbyRecommendTroopPush(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Boolean.valueOf(z16), Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                switch (i3) {
                    case 9:
                        onUpdateSetShareStatus(z16, ((Boolean) obj).booleanValue());
                        return;
                    case 10:
                        handleGetSwitcher(z16, (Object[]) obj);
                        return;
                    case 11:
                        handleGetStreetViewUrl(z16, obj);
                        return;
                    default:
                        switch (i3) {
                            case 13:
                                handleGetGroupInArea(z16, obj);
                                return;
                            case 14:
                                handleSetShowInNearbyTroops(z16, obj);
                                return;
                            case 15:
                                onGetLbsShareSearch(z16, (Object[]) obj);
                                return;
                            case 16:
                                onGetLbsShareShop(z16, (Object[]) obj);
                                return;
                            case 17:
                                onGetShareShopDetail(z16, (Object[]) obj);
                                return;
                            case 18:
                                handleGetUserCurrentLocation(z16, obj);
                                return;
                            case 19:
                                onRcvNearbyRecommendTroopPush(z16, ((Integer) obj).intValue());
                                return;
                            default:
                                switch (i3) {
                                    case 24:
                                        onGetEntrance(z16, (Object[]) obj);
                                        return;
                                    case 25:
                                        handleGetFace2FaceNearbyUserList(z16, obj);
                                        return;
                                    case 26:
                                        if (obj == null) {
                                            return;
                                        }
                                        Object[] objArr = (Object[]) obj;
                                        onGetFaceToFaceNearbyUserPush((com.tencent.mobileqq.facetoface.g) objArr[0], ((Boolean) objArr[1]).booleanValue(), ((Integer) objArr[2]).intValue());
                                        return;
                                    case 27:
                                        onGetNearbyRecommender(z16, (Object[]) obj);
                                        return;
                                    case 28:
                                        Object[] objArr2 = (Object[]) obj;
                                        onGetNewNearbyTroops(z16, ((Integer) objArr2[0]).intValue(), (cmd0x7f5$GroupInfo) objArr2[1]);
                                        return;
                                    default:
                                        return;
                                }
                        }
                }
            }
            handleGetNeighbors(z16, obj);
            return;
        }
        handleGetPoi(z16, obj);
    }

    protected void onUpdateGetSwitch(boolean z16, int i3, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), Integer.valueOf(i3), Boolean.valueOf(z17));
        }
    }

    protected void onUpdateNeighbors(boolean z16, String str, RespGetNeighbors respGetNeighbors, boolean z17, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str, respGetNeighbors, Boolean.valueOf(z17), Integer.valueOf(i3));
        }
    }

    protected void onUpdatePOI(boolean z16, byte[] bArr, String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), bArr, str, str2, str3);
        }
    }

    protected void onUpdateSetShareStatus(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
    }
}
