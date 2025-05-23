package com.tencent.gdt.tangram.ad.qzone;

import android.text.TextUtils;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.e;
import com.qzone.proxy.feedcomponent.text.TextCell;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes31.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private static final String f108417b = "com.tencent.gdt.tangram.ad.qzone.b";

    /* renamed from: a, reason: collision with root package name */
    protected BusinessFeedData f108418a;

    public b(BusinessFeedData businessFeedData) {
        if (businessFeedData != null) {
            this.f108418a = businessFeedData;
        }
    }

    public int a(int i3, Object obj) {
        int d16 = d(i3, obj);
        String str = f108417b;
        d.b(str, "basicActionType = " + d16);
        if (d16 != 2) {
            if (d16 == 3) {
                BusinessFeedData businessFeedData = this.f108418a;
                return (businessFeedData == null || !businessFeedData.isImaxVideoAdv()) ? 3 : 1000;
            }
            if (d16 != 5 && d16 != 46) {
                if (d16 == 49) {
                    BusinessFeedData businessFeedData2 = this.f108418a;
                    return (businessFeedData2 == null || !businessFeedData2.isImaxVideoAdv()) ? 49 : 1000;
                }
                if (d16 != 54 && d16 != 62) {
                    switch (d16) {
                        case 20:
                            int h16 = h();
                            d.b(str, "operationActionType = " + h16);
                            if (h16 != 2 && h16 != 5) {
                                if (h16 == 22) {
                                    if (i() == 4) {
                                        return 22;
                                    }
                                    d.c(str, "getAdAction error");
                                    return -1;
                                }
                                if (h16 != 46) {
                                    d.c(str, "getActionTypeFinally error");
                                    return -1;
                                }
                            }
                            return h16;
                        case 21:
                        case 22:
                            break;
                        default:
                            d.c(str, "getActionTypeFinally error");
                            return -1;
                    }
                }
            }
        }
        return d16;
    }

    public String b() {
        if (!n() || this.f108418a.getOperationInfoV2() == null) {
            return null;
        }
        return this.f108418a.getOperationInfoV2().appid;
    }

    public String c() {
        if (!n() || this.f108418a.getOperationInfoV2() == null) {
            return null;
        }
        return this.f108418a.getOperationInfoV2().schemaPageUrl;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:14:0x001a. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:15:0x001d. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int d(int i3, Object obj) {
        if (!n()) {
            return -1;
        }
        if (i3 != 12) {
            if (i3 != 34) {
                if (i3 != 53) {
                    if (i3 != 1000) {
                        switch (i3) {
                            case 1:
                                break;
                            case 2:
                            case 3:
                                break;
                            case 4:
                                break;
                            case 5:
                                if (this.f108418a.getPictureInfo() != null) {
                                    return this.f108418a.getPictureInfo().actiontype;
                                }
                                return -1;
                            case 6:
                                if ((!this.f108418a.isSupportSoundPlayOut() || this.f108418a.getVideoInfo() == null || !this.f108418a.getVideoInfo().isGdtVideoVolumeOpened || !this.f108418a.getVideoInfo().isGdtAdVideoPlaying) && !this.f108418a.isGdt585AdVideo() && (!this.f108418a.isMiniAppGdtAdv() || !this.f108418a.switchToTangramProtocol())) {
                                    if (this.f108418a.getVideoInfo() != null) {
                                        return this.f108418a.getVideoInfo().actionType;
                                    }
                                    return -1;
                                }
                                if (this.f108418a.getRecommAction() != null) {
                                    return this.f108418a.getRecommAction().actionType;
                                }
                                return -1;
                            case 7:
                                if (this.f108418a.getFeedCommInfo().actiontype == 20) {
                                    return 20;
                                }
                                if (this.f108418a.getCellSummaryV2() != null) {
                                    return this.f108418a.getCellSummaryV2().actionType;
                                }
                                return -1;
                            case 8:
                                if (this.f108418a.getRecommAction() != null) {
                                    return this.f108418a.getRecommAction().actionType;
                                }
                                return -1;
                            case 9:
                            case 10:
                                if (this.f108418a.getOperationInfoV2() != null) {
                                    return this.f108418a.getOperationInfoV2().actionType;
                                }
                                return -1;
                            default:
                                switch (i3) {
                                    case 15:
                                    case 16:
                                    case 17:
                                    case 18:
                                    case 20:
                                        break;
                                    case 19:
                                        break;
                                    case 21:
                                        if (l() <= 0 && this.f108418a.getVideoInfo() != null) {
                                            return this.f108418a.getVideoInfo().actionType;
                                        }
                                        return -1;
                                    case 22:
                                    case 23:
                                    case 25:
                                        break;
                                    case 24:
                                        return (obj == null || obj != 0L) ? 20 : 5;
                                    default:
                                        switch (i3) {
                                            case 27:
                                                break;
                                            case 28:
                                            case 30:
                                                break;
                                            case 29:
                                                if (this.f108418a.isBrandUgcAdvFeeds() && this.f108418a.getCellBottomRecomm() != null) {
                                                    return this.f108418a.getCellBottomRecomm().actiontype;
                                                }
                                                if (this.f108418a.getFeedCommInfo() != null) {
                                                    return this.f108418a.getFeedCommInfo().actiontype;
                                                }
                                                return -1;
                                            case 31:
                                                if (this.f108418a.getCellBottomRecomm() != null) {
                                                    return this.f108418a.getCellBottomRecomm().actiontype;
                                                }
                                                if (this.f108418a.getRecommAction() != null) {
                                                    return this.f108418a.getRecommAction().actionType;
                                                }
                                                return -1;
                                            case 32:
                                                break;
                                            default:
                                                return -1;
                                        }
                                }
                        }
                    }
                    if (this.f108418a.getFeedCommInfo() != null) {
                        return this.f108418a.getFeedCommInfo().actiontype;
                    }
                    return -1;
                }
                if (this.f108418a.getUser() != null && this.f108418a.getUser().actiontype == 2) {
                    return 2;
                }
                if (this.f108418a.getCellUserInfo() != null) {
                    return this.f108418a.getCellUserInfo().actionType;
                }
                return -1;
            }
            if (this.f108418a.getCellSummaryV2() != null) {
                return this.f108418a.getCellSummaryV2().actionType;
            }
            return -1;
        }
        if (this.f108418a.getCellAdvContainerAttach() != null) {
            return this.f108418a.getCellAdvContainerAttach().actiontype;
        }
        return -1;
    }

    public Map<Integer, String> e() {
        HashMap hashMap;
        String obj;
        if (TextUtils.isEmpty(g())) {
            hashMap = null;
        } else {
            hashMap = new HashMap();
            hashMap.put(new Integer(132), g());
        }
        String str = f108417b;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("busiParam =");
        if (hashMap == null) {
            obj = "null";
        } else {
            obj = hashMap.toString();
        }
        sb5.append(obj);
        d.b(str, sb5.toString());
        return hashMap;
    }

    public Map<Integer, String> f() {
        if (!n() || this.f108418a.getOperationInfoV2() == null) {
            return null;
        }
        return this.f108418a.getOperationInfoV2().cookie;
    }

    public String g() {
        if (n() && this.f108418a.getOperationInfoV2() != null && this.f108418a.getOperationInfoV2().busiParam != null && this.f108418a.getRecommAction() != null && this.f108418a.getOperationInfoV2().busiParam.containsKey(new Integer(132)) && !TextUtils.isEmpty(this.f108418a.getOperationInfoV2().busiParam.get(new Integer(132)))) {
            if (this.f108418a.getRecommAction().advPos != 5 && this.f108418a.getRecommAction().advPos != 6 && this.f108418a.getRecommAction().advPos != 10) {
                d.b(f108417b, "getMyMediaShareInfo is null");
                return null;
            }
            d.b(f108417b, "getMyMediaShareInfo =" + this.f108418a.getOperationInfoV2().busiParam.get(132));
            return this.f108418a.getOperationInfoV2().busiParam.get(132);
        }
        d.b(f108417b, "getMyMediaShareInfo is null");
        return null;
    }

    public int h() {
        BusinessFeedData businessFeedData = this.f108418a;
        if (businessFeedData == null || businessFeedData.getOperationInfoV2() == null) {
            return -1;
        }
        return this.f108418a.getOperationInfoV2().actionType;
    }

    public int i() {
        String feedTypeStr = n() ? this.f108418a.getFeedTypeStr() : null;
        if ("outlink".equalsIgnoreCase(feedTypeStr)) {
            return 1;
        }
        if ("page_outlink".equalsIgnoreCase(feedTypeStr)) {
            return 2;
        }
        if ("page".equalsIgnoreCase(feedTypeStr)) {
            return 3;
        }
        if ("app".equalsIgnoreCase(feedTypeStr)) {
            return 4;
        }
        return "local_adv".equalsIgnoreCase(feedTypeStr) ? 5 : 0;
    }

    public String k(int i3, Object... objArr) {
        if (!n()) {
            return null;
        }
        String str = this.f108418a.getOperationInfo().downloadUrl;
        if (this.f108418a.isLocalAd()) {
            if (i3 != 2 && i3 != 3) {
                if ((i3 == 30 || i3 == 7) && objArr != null && objArr.length == 1) {
                    Object obj = objArr[0];
                    if ((obj instanceof ArrayList) && (((ArrayList) obj).get(0) instanceof TextCell)) {
                        String j3 = j((ArrayList) objArr[0]);
                        if (!TextUtils.isEmpty(j3)) {
                            str = j3;
                        }
                    }
                }
            } else {
                str = this.f108418a.getUser().actionurl;
            }
        }
        if ((i3 == 31 || (this.f108418a.isBrandUgcAdvFeeds() && i3 == 29)) && this.f108418a.getCellBottomRecomm() != null && this.f108418a.getCellBottomRecomm().actiontype == 2 && !TextUtils.isEmpty(this.f108418a.getCellBottomRecomm().actionurl)) {
            str = this.f108418a.getCellBottomRecomm().actionurl;
        }
        if (objArr != null && objArr.length == 1) {
            Object obj2 = objArr[0];
            if (obj2 instanceof e) {
                return ((e) obj2).c();
            }
        }
        if (objArr != null && objArr.length == 1) {
            Object obj3 = objArr[0];
            if (obj3 instanceof String) {
                str = (String) obj3;
            }
        }
        if (this.f108418a.getCellAdvContainerAttach() != null && this.f108418a.getCellAdvContainerAttach().actiontype == 2) {
            str = this.f108418a.getCellAdvContainerAttach().actionurl;
        }
        if (this.f108418a.isAppAd() && i3 == 8) {
            str = str + "&_autodownload=1";
        }
        d.b(f108417b, "url =" + str);
        return str;
    }

    public int l() {
        BusinessFeedData businessFeedData = this.f108418a;
        if (businessFeedData == null || businessFeedData.getFeedCommInfo() == null || this.f108418a.getFeedCommInfo().getStMapABTest() == null || this.f108418a.getFeedCommInfo().getStMapABTest().get(26) == null) {
            return -1;
        }
        return this.f108418a.getFeedCommInfo().getStMapABTest().get(26).intValue();
    }

    public boolean m() {
        return n() && this.f108418a.getOperationInfo().yingYongBao;
    }

    protected boolean n() {
        BusinessFeedData businessFeedData = this.f108418a;
        return businessFeedData != null && businessFeedData.isGDTAdvFeed();
    }

    private static String j(ArrayList<TextCell> arrayList) {
        if (arrayList == null) {
            return null;
        }
        Iterator<TextCell> it = arrayList.iterator();
        while (it.hasNext()) {
            TextCell next = it.next();
            if (!TextUtils.isEmpty(next.getUrl())) {
                d.c(f108417b, "cellUrl =" + next.getUrl());
                return next.getUrl();
            }
        }
        return null;
    }
}
