package com.tencent.biz.pubaccount.weishi.report;

import NS_KING_SOCIALIZE_META.stMetaTag;
import NS_KING_SOCIALIZE_META.stMetaUgcVideoSeg;
import UserGrowth.stDevice;
import UserGrowth.stH5OpInfo;
import UserGrowth.stReportItem;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import UserGrowth.stWaterFallCardStyle;
import UserGrowth.stWeishiReportRsp;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi.net.l;
import com.tencent.biz.pubaccount.weishi.util.p;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.QUA;
import i10.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a implements com.tencent.biz.pubaccount.weishi.net.c {

    /* renamed from: a, reason: collision with root package name */
    private static String f81485a = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.biz.pubaccount.weishi.report.a$a, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    public class C0829a implements com.tencent.biz.pubaccount.weishi.net.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f81486a;

        C0829a(String str) {
            this.f81486a = str;
        }

        @Override // com.tencent.biz.pubaccount.weishi.net.c
        public void a(l lVar) {
            Object obj;
            x.b("weishi-report", "report " + this.f81486a + " start...");
            if (lVar == null || (obj = lVar.f80999l) == null || !(obj instanceof stWeishiReportRsp)) {
                return;
            }
            stWeishiReportRsp stweishireportrsp = (stWeishiReportRsp) obj;
            x.b("weishi-report", "report" + this.f81486a + "end: " + stweishireportrsp.code + stweishireportrsp.f25135msg);
        }
    }

    static {
        d();
    }

    public static stReportItem b(stSimpleMetaFeed stsimplemetafeed, int i3) {
        stReportItem g16 = g();
        g16.upos = i3 + 1;
        if (stsimplemetafeed == null) {
            x.f("weishi-report", "convertFeedToReport feed == null");
            return g16;
        }
        g16.map_pass_back = stsimplemetafeed.map_pass_back;
        g16.authorid = stsimplemetafeed.poster_id;
        g16.feedid = stsimplemetafeed.f25129id;
        g16.title = stsimplemetafeed.feed_desc;
        stMetaUgcVideoSeg stmetaugcvideoseg = stsimplemetafeed.video;
        if (stmetaugcvideoseg != null) {
            g16.video_time = stmetaugcvideoseg.duration;
        }
        stSimpleMetaPerson stsimplemetaperson = stsimplemetafeed.poster;
        if (stsimplemetaperson != null) {
            g16.authorid = stsimplemetaperson.f25130id;
            g16.authorname = stsimplemetaperson.nick;
        }
        stMetaTag stmetatag = stsimplemetafeed.bt_style;
        if (stmetatag != null && !TextUtils.isEmpty(stmetatag.title)) {
            g16.ext_map = e(stsimplemetafeed.bt_style.title);
        }
        int i16 = stsimplemetafeed.video_type;
        if (i16 == 7) {
            g16.video_type = 7;
        } else if (i16 == 6) {
            g16.video_type = 6;
        } else {
            stH5OpInfo sth5opinfo = stsimplemetafeed.h5_op_info;
            if (sth5opinfo != null && !TextUtils.isEmpty(sth5opinfo.h5Url)) {
                g16.video_type = 1;
            } else {
                int i17 = stsimplemetafeed.video_type;
                if (i17 == 0) {
                    g16.video_type = 0;
                } else {
                    g16.video_type = i17;
                }
            }
        }
        g16.traceId = stsimplemetafeed.traceId;
        g16.feed_map_ext = stsimplemetafeed.map_ext;
        l(g16, stsimplemetafeed.waterFallCardStyle);
        g16.pool_type = stsimplemetafeed.videoPoolType;
        return g16;
    }

    private static String d() {
        return f81485a;
    }

    private static Map<String, String> e(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("qq_bt_text", str);
        return hashMap;
    }

    public static String f(Context context) {
        return "";
    }

    public static stReportItem g() {
        String account = BaseApplicationImpl.getApplication().getRuntime().getAccount();
        stReportItem streportitem = new stReportItem();
        streportitem.imp_date = (int) (System.currentTimeMillis() / 1000);
        streportitem.uin = TextUtils.isEmpty(account) ? 0L : com.tencent.biz.qqstory.utils.f.a(account, 0L);
        streportitem.network_type = p.g().toLowerCase();
        streportitem.f25125os = "android" + p.i() + " - " + p.e();
        streportitem.city = d();
        streportitem.f25124ip = p.d();
        streportitem.qua = QUA.getQUA3();
        streportitem.vendor = ah.C();
        stDevice stdevice = new stDevice();
        stdevice.encrypted_deviceid = iz.a.g().f();
        stdevice.qimei = p.j();
        streportitem.device = stdevice;
        streportitem.exist_weishi = com.tencent.biz.qqstory.utils.l.c(BaseApplication.getContext()) ? 2 : 1;
        return streportitem;
    }

    public static void j(int i3, int i16, int i17, stSimpleMetaFeed stsimplemetafeed, String str) {
        stReportItem b16 = b(stsimplemetafeed, i17);
        b16.optype = i16;
        b16.pagetype = i3;
        if (!TextUtils.isEmpty(str)) {
            b16.downloadscene = str;
        }
        k(i16, b16);
    }

    public static void k(int i3, stReportItem streportitem) {
        streportitem.optype = i3;
        i(streportitem);
    }

    public static void c(ArrayList<stReportItem> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            com.tencent.biz.pubaccount.weishi.net.g.b().g(new l(new j(arrayList), null, new C0829a(h(arrayList.get(0).optype, arrayList.get(0).pagetype)), 2001));
            return;
        }
        x.f("weishi-report", "[UserActionReportPresenter.java][doReport] report error items!");
    }

    public static void i(stReportItem streportitem) {
        if (streportitem == null) {
            x.f("weishi-report", "report error item = null");
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(streportitem);
        c(arrayList);
    }

    private static void l(stReportItem streportitem, stWaterFallCardStyle stwaterfallcardstyle) {
        if (stwaterfallcardstyle != null) {
            streportitem.card_type = stwaterfallcardstyle.cardType;
            streportitem.ratioW = stwaterfallcardstyle.ratioW;
            streportitem.ratioH = stwaterfallcardstyle.ratioH;
            streportitem.isFullSpan = stwaterfallcardstyle.isFullSpan;
        }
    }

    private static String h(int i3, int i16) {
        String qqStr;
        if (i3 == 1) {
            qqStr = HardCodeUtil.qqStr(R.string.f172870uw4);
        } else if (i3 != 1001) {
            switch (i3) {
                case 3:
                    qqStr = HardCodeUtil.qqStr(R.string.uv7);
                    break;
                case 4:
                    qqStr = HardCodeUtil.qqStr(R.string.uvo);
                    if (i16 == 2) {
                        qqStr = HardCodeUtil.qqStr(R.string.uw5);
                        break;
                    } else if (i16 == 6) {
                        qqStr = HardCodeUtil.qqStr(R.string.uvu);
                        break;
                    }
                    break;
                case 5:
                    qqStr = HardCodeUtil.qqStr(R.string.f171699ka2);
                    break;
                case 6:
                    qqStr = HardCodeUtil.qqStr(R.string.uvv);
                    if (i16 == 2) {
                        qqStr = HardCodeUtil.qqStr(R.string.uvy);
                        break;
                    } else if (i16 == 6) {
                        qqStr = HardCodeUtil.qqStr(R.string.uvf);
                        break;
                    } else if (i16 == 12) {
                        qqStr = HardCodeUtil.qqStr(R.string.uv8);
                        break;
                    } else if (i16 == 14) {
                        qqStr = HardCodeUtil.qqStr(R.string.uvb);
                        break;
                    }
                    break;
                case 7:
                    qqStr = HardCodeUtil.qqStr(R.string.uvs);
                    break;
                case 8:
                    qqStr = HardCodeUtil.qqStr(R.string.uvh);
                    break;
                default:
                    switch (i3) {
                        case 112:
                            qqStr = HardCodeUtil.qqStr(R.string.uvl);
                            if (i16 == 9) {
                                qqStr = "\u8fdb\u5165H5";
                                break;
                            } else if (i16 == 12) {
                                qqStr = HardCodeUtil.qqStr(R.string.f172866uw0);
                                break;
                            }
                            break;
                        case 113:
                            qqStr = HardCodeUtil.qqStr(R.string.uvc);
                            break;
                        case 114:
                            qqStr = HardCodeUtil.qqStr(R.string.uvw);
                            if (i16 == 12) {
                                qqStr = HardCodeUtil.qqStr(R.string.uvk);
                                break;
                            }
                            break;
                        case 115:
                            qqStr = HardCodeUtil.qqStr(R.string.uve);
                            if (i16 == 12) {
                                qqStr = HardCodeUtil.qqStr(R.string.uvm);
                                break;
                            }
                            break;
                        case 116:
                            qqStr = HardCodeUtil.qqStr(R.string.f172868uw2);
                            break;
                        case 117:
                            qqStr = HardCodeUtil.qqStr(R.string.uvt);
                            if (i16 == 12) {
                                qqStr = HardCodeUtil.qqStr(R.string.uv6);
                                break;
                            }
                            break;
                        case 118:
                            qqStr = HardCodeUtil.qqStr(R.string.uw8);
                            break;
                        case 119:
                            qqStr = HardCodeUtil.qqStr(R.string.uvz);
                            break;
                        case 120:
                            qqStr = HardCodeUtil.qqStr(R.string.f172867uw1);
                            break;
                        case 121:
                            qqStr = HardCodeUtil.qqStr(R.string.uvj);
                            break;
                        default:
                            switch (i3) {
                                case 127:
                                    qqStr = HardCodeUtil.qqStr(R.string.uvx);
                                    break;
                                case 128:
                                    qqStr = HardCodeUtil.qqStr(R.string.uvn);
                                    break;
                                case 129:
                                    qqStr = HardCodeUtil.qqStr(R.string.uvr);
                                    break;
                                case 130:
                                    qqStr = HardCodeUtil.qqStr(R.string.uw6);
                                    break;
                                case 131:
                                    qqStr = HardCodeUtil.qqStr(R.string.uva);
                                    break;
                                case 132:
                                    qqStr = HardCodeUtil.qqStr(R.string.uvd);
                                    break;
                                case 133:
                                    qqStr = HardCodeUtil.qqStr(R.string.uvi);
                                    break;
                                default:
                                    switch (i3) {
                                        case 137:
                                            qqStr = HardCodeUtil.qqStr(R.string.uvq);
                                            break;
                                        case 138:
                                            qqStr = HardCodeUtil.qqStr(R.string.f172869uw3);
                                            break;
                                        case 139:
                                            qqStr = HardCodeUtil.qqStr(R.string.uvg);
                                            break;
                                        default:
                                            qqStr = "";
                                            break;
                                    }
                            }
                    }
            }
        } else {
            qqStr = HardCodeUtil.qqStr(R.string.uv_);
        }
        return i16 == 3 ? HardCodeUtil.qqStr(R.string.uvp) : qqStr;
    }
}
