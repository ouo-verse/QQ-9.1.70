package com.tencent.mobileqq.zootopia.download.ui;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.minispecial.api.impl.ThirdPartyMiniApiImpl;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.RoundRelativeLayout;
import com.tencent.mobileqq.z1.download.data.ZPlanModVersionSimpleData;
import com.tencent.mobileqq.z1.download.data.ZootopiaResData;
import com.tencent.mobileqq.z1.download.data.ZootopiaSummaryData;
import com.tencent.mobileqq.z1.download.diffpatch.ZPlanMapDiffPatchInfo;
import com.tencent.mobileqq.zootopia.download.ZootopiaDownloadManager;
import com.tencent.mobileqq.zootopia.download.data.ZootopiaDownloadData;
import com.tencent.mobileqq.zootopia.download.ui.downloading.DownloadingPayloadData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qui.quiblurview.QQBlurView;
import com.tencent.sqshow.zootopia.mapstatus.MapStatus;
import com.tencent.sqshow.zootopia.utils.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import pv4.y;
import qv4.v;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u000b\b&\u0018\u0000 1*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u00012B\u0007\u00a2\u0006\u0004\b/\u00100J\"\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011J\u0016\u0010\u0016\u001a\u00020\u000f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0014H\u0016J\u000e\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0017J!\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u00042\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u000e\u0010 \u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u001eJ\b\u0010!\u001a\u00020\u001aH\u0016R\u001a\u0010'\u001a\u00020\"8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R(\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040(8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/ui/a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "VH", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/zootopia/download/ui/d;", "oldData", "Lpv4/y;", "versionInfo", "Lqv4/g;", ThirdPartyMiniApiImpl.KEY_MAP_INFO, "j0", "verInfo", "data", "", "n0", "", "i0", "Lqv4/v;", "rsp", "p0", "", "dataList", "updateList", "Lcom/tencent/mobileqq/zootopia/download/ui/downloading/a;", "payload", "o0", "", "index", "l0", "(Lcom/tencent/mobileqq/zootopia/download/ui/d;Ljava/lang/Integer;)V", "", "id", "deleteData", "getItemCount", "Lid3/d;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lid3/d;", "k0", "()Lid3/d;", "reportHelper", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "getDataList", "()Ljava/util/List;", "setDataList", "(Ljava/util/List;)V", "<init>", "()V", "D", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public abstract class a<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    /* renamed from: D, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final id3.d reportHelper = new id3.d(null, 1, null);

    /* renamed from: C, reason: from kotlin metadata */
    private List<d> dataList = new ArrayList();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/ui/a$a;", "", "Landroid/view/View;", "itemView", "", "a", "", "BLUR_CORNER", UserInfo.SEX_FEMALE, "", "PAGE_PARAMS_MAP_ID", "Ljava/lang/String;", "PAGE_PARAMS_MODULE_ID", "TAG", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.download.ui.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(View itemView) {
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) itemView.findViewById(R.id.ped);
            roundRelativeLayout.f316197h = 6;
            roundRelativeLayout.f316195e = ViewUtils.dpToPx(10.0f);
            QQBlurView qQBlurView = (QQBlurView) itemView.findViewById(R.id.pee);
            qQBlurView.j(itemView);
            qQBlurView.m(qQBlurView);
            qQBlurView.z(new ColorDrawable(q.a(R.color.f8376s)));
            qQBlurView.x();
        }

        Companion() {
        }
    }

    private final void i0(d data) {
        if (data.getCom.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy.KEY_DOWNLOAD_STATUS java.lang.String() == 2 || data.getCom.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy.KEY_DOWNLOAD_STATUS java.lang.String() == 1) {
            String id5 = data.getData().getSummaryData().getId();
            if (Intrinsics.areEqual(data.getCom.tencent.mobileqq.app.AppConstants.Key.COLUMN_IS_VALID java.lang.String(), Boolean.FALSE)) {
                QLog.e("Zootopia_BaseDownloadAdapter", 1, "checkDownloadingData " + id5 + " status inValid");
                return;
            }
            Integer qqVerTip = data.getQqVerTip();
            if (qqVerTip != null && qqVerTip.intValue() == 1) {
                QLog.e("Zootopia_BaseDownloadAdapter", 1, "checkDownloadingData " + id5 + " status EM_QQ_LOWWER");
                return;
            }
            if (qqVerTip != null && qqVerTip.intValue() == 2) {
                QLog.e("Zootopia_BaseDownloadAdapter", 1, "checkDownloadingData " + id5 + " status EM_QQ_HIGHER");
                return;
            }
            Integer mapVerTip = data.getMapVerTip();
            if (mapVerTip != null && mapVerTip.intValue() == 1) {
                QLog.w("Zootopia_BaseDownloadAdapter", 1, "checkDownloadingData " + id5 + " status needUpdate");
                data.k(null);
                data.m(null);
                if (data.getStatus() == MapStatus.MAP_STATUS_UPDATE) {
                    data.o(null);
                }
                ZootopiaDownloadManager.M0(ZootopiaDownloadManager.f327992a, com.tencent.mobileqq.zootopia.download.c.f328029a.e(data.getData()), false, null, false, 12, null);
                return;
            }
            QLog.e("Zootopia_BaseDownloadAdapter", 1, "checkDownloadingData " + id5 + " normal");
        }
    }

    private final boolean n0(y verInfo, d data) {
        return (verInfo.f427736i == 0 && verInfo.f427730c == 0 && Intrinsics.areEqual(verInfo.f427731d, data.getData().getResData().getVersion()) && verInfo.f427729b == 0) ? false : true;
    }

    public final void deleteData(String id5) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Iterator<d> it = this.dataList.iterator();
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                i3 = -1;
                break;
            } else if (Intrinsics.areEqual(it.next().getData().getSummaryData().getId(), id5)) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 >= 0) {
            this.dataList.remove(i3);
            notifyItemRemoved(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final List<d> getDataList() {
        return this.dataList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.dataList.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: k0, reason: from getter */
    public final id3.d getReportHelper() {
        return this.reportHelper;
    }

    public final void l0(d data, Integer index) {
        Intrinsics.checkNotNullParameter(data, "data");
        int size = this.dataList.size();
        if (index != null) {
            this.dataList.add(index.intValue(), data);
            notifyItemInserted(index.intValue());
        } else {
            this.dataList.add(data);
            notifyItemInserted(size);
        }
    }

    public final void o0(DownloadingPayloadData payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        Iterator<d> it = this.dataList.iterator();
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                i3 = -1;
                break;
            } else if (Intrinsics.areEqual(it.next().getData().getSummaryData().getId(), payload.getId())) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 >= 0) {
            d dVar = this.dataList.get(i3);
            Float progress = payload.getProgress();
            if (progress != null) {
                dVar.l(progress.floatValue());
            }
            Integer downloadStatus = payload.getDownloadStatus();
            if (downloadStatus != null) {
                dVar.j(downloadStatus.intValue());
            }
            Integer realTimeSpeed = payload.getRealTimeSpeed();
            if (realTimeSpeed != null) {
                dVar.n(Integer.valueOf(realTimeSpeed.intValue()));
            }
            Integer averageSpeed = payload.getAverageSpeed();
            if (averageSpeed != null) {
                dVar.i(Integer.valueOf(averageSpeed.intValue()));
            }
            notifyItemChanged(i3, payload);
        }
    }

    public void updateList(List<d> dataList) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        this.dataList.clear();
        this.dataList.addAll(dataList);
        notifyDataSetChanged();
    }

    public final void p0(v rsp) {
        y[] yVarArr;
        boolean z16;
        qv4.g gVar;
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        y[] yVarArr2 = rsp.f430204a;
        if (yVarArr2 == null) {
            return;
        }
        qv4.g[] gVarArr = rsp.f430205b;
        boolean z17 = true;
        if (yVarArr2.length == 0) {
            return;
        }
        QLog.i("Zootopia_BaseDownloadAdapter", 1, "updateVersion Info " + yVarArr2.length);
        int length = yVarArr2.length;
        int i3 = 0;
        while (i3 < length) {
            y yVar = yVarArr2[i3];
            Iterator<d> it = this.dataList.iterator();
            int i16 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i16 = -1;
                    break;
                } else if (it.next().getData().getResData().getId() == yVar.f427728a ? z17 : false) {
                    break;
                } else {
                    i16++;
                }
            }
            if (i16 < 0 || i16 >= this.dataList.size()) {
                yVarArr = yVarArr2;
                z16 = z17;
            } else {
                d dVar = this.dataList.get(i16);
                yVarArr = yVarArr2;
                QLog.i("Zootopia_BaseDownloadAdapter", 1, yVar.f427728a + " - " + dVar.getData().getSummaryData().getTitle() + " have updateInfo updateVersion: " + yVar.f427731d + " , nowVersion: " + dVar.getData().getResData().getVersion() + ", mapStatus: " + yVar.f427736i + " , mapVerTips: " + yVar.f427730c + ", qqVerTips: " + yVar.f427729b);
                if (n0(yVar, dVar)) {
                    dVar.m(Integer.valueOf(yVar.f427729b));
                    dVar.k(Integer.valueOf(yVar.f427730c));
                    com.tencent.sqshow.zootopia.mapstatus.d dVar2 = com.tencent.sqshow.zootopia.mapstatus.d.f370777a;
                    MapStatus b16 = dVar2.b(yVar.f427736i, Integer.valueOf(dVar.getData().getResData().getDownloadStatus()));
                    if (b16 == null && (b16 = dVar2.c(yVar.f427729b)) == null) {
                        int i17 = yVar.f427730c;
                        String version = dVar.getData().getResData().getVersion();
                        String str = yVar.f427731d;
                        Intrinsics.checkNotNullExpressionValue(str, "verInfo.nowMapVer");
                        b16 = dVar2.a(i17, version, str);
                        if (b16 == null) {
                            b16 = com.tencent.sqshow.zootopia.mapstatus.d.e(dVar2, Integer.valueOf(dVar.getData().getResData().getDownloadStatus()), null, 2, null);
                        }
                    }
                    dVar.o(b16);
                    if (yVar.f427730c == 1 && Intrinsics.areEqual(dVar.getData().getResData().getVersion(), yVar.f427731d)) {
                        z16 = true;
                        QLog.e("Zootopia_BaseDownloadAdapter", 1, yVar.f427728a + " need update but version error " + yVar.f427731d);
                    } else if (dVar.getCom.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy.KEY_DOWNLOAD_STATUS java.lang.String() != 5 && yVar.f427736i != 0) {
                        z16 = true;
                        QLog.i("Zootopia_BaseDownloadAdapter", 1, yVar.f427728a + " status " + dVar.getCom.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy.KEY_DOWNLOAD_STATUS java.lang.String() + " but is invalid");
                    } else if (dVar.getCom.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy.KEY_DOWNLOAD_STATUS java.lang.String() != 5 && yVar.f427729b != 0) {
                        z16 = true;
                        QLog.i("Zootopia_BaseDownloadAdapter", 1, yVar.f427728a + " status " + dVar.getCom.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy.KEY_DOWNLOAD_STATUS java.lang.String() + " but is qqVerTip is " + yVar.f427729b);
                    } else {
                        if (gVarArr != null) {
                            int length2 = gVarArr.length;
                            for (int i18 = 0; i18 < length2; i18++) {
                                gVar = gVarArr[i18];
                                if (gVar.f430142a == yVar.f427728a) {
                                    break;
                                }
                            }
                        }
                        gVar = null;
                        Integer valueOf = gVar != null ? Integer.valueOf(gVar.f430142a) : null;
                        String str2 = gVar != null ? gVar.f430145d : null;
                        String str3 = gVar != null ? gVar.f430150i : null;
                        z16 = true;
                        QLog.i("Zootopia_BaseDownloadAdapter", 1, "MapInfo " + valueOf + " " + str2 + " ==> " + str3 + ", data.status= " + dVar.getStatus());
                        d j06 = j0(dVar, yVar, gVar);
                        if (yVar.f427730c == 0) {
                            ZootopiaDownloadManager zootopiaDownloadManager = ZootopiaDownloadManager.f327992a;
                            String valueOf2 = String.valueOf(yVar.f427728a);
                            String str4 = yVar.f427731d;
                            Intrinsics.checkNotNullExpressionValue(str4, "verInfo.nowMapVer");
                            zootopiaDownloadManager.V0(valueOf2, str4);
                        }
                        i0(j06);
                        this.dataList.set(i16, j06);
                        notifyItemChanged(i16);
                    }
                } else {
                    z16 = true;
                }
            }
            i3++;
            z17 = z16;
            yVarArr2 = yVarArr;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final d j0(d oldData, y versionInfo, qv4.g mapInfo) {
        boolean z16;
        ZootopiaSummaryData summaryData;
        String str;
        if (mapInfo != null && (str = mapInfo.f430145d) != null) {
            if (str.length() > 0) {
                z16 = true;
                if (!z16) {
                    String valueOf = String.valueOf(mapInfo.f430142a);
                    int i3 = mapInfo.f430143b;
                    String str2 = mapInfo.f430145d;
                    String str3 = str2 == null ? "" : str2;
                    String str4 = mapInfo.f430146e;
                    String str5 = str4 == null ? "" : str4;
                    String str6 = mapInfo.f430148g;
                    String str7 = str6 == null ? "" : str6;
                    String str8 = mapInfo.f430152k;
                    String str9 = str8 == null ? "" : str8;
                    String str10 = mapInfo.f430144c;
                    if (str10 == null) {
                        str10 = "";
                    }
                    summaryData = new ZootopiaSummaryData(valueOf, i3, str3, str5, str7, str9, str10);
                } else {
                    summaryData = oldData.getData().getSummaryData();
                }
                int i16 = versionInfo.f427728a;
                String str11 = versionInfo.f427732e;
                Intrinsics.checkNotNullExpressionValue(str11, "versionInfo.cosURL");
                String str12 = versionInfo.f427731d;
                Intrinsics.checkNotNullExpressionValue(str12, "versionInfo.nowMapVer");
                d dVar = new d(new ZootopiaDownloadData(summaryData, new ZootopiaResData(i16, str11, str12, oldData.getData().getResData().getFilePath(), oldData.getData().getResData().getDownloadStatus(), versionInfo.f427734g, oldData.getData().getResData().getProgress(), oldData.getData().getResData().getCompleteTime(), oldData.getData().getResData().getStartTime(), ZPlanModVersionSimpleData.INSTANCE.b(versionInfo), oldData.getData().getResData().isSilentDownload(), oldData.getData().getResData().getNeedNotification(), ZPlanMapDiffPatchInfo.INSTANCE.b(versionInfo.f427742o)), oldData.getData().getExtraData()));
                dVar.p(Boolean.valueOf(versionInfo.f427736i == 1));
                dVar.k(Integer.valueOf(versionInfo.f427730c));
                dVar.m(Integer.valueOf(versionInfo.f427729b));
                dVar.j(oldData.getCom.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy.KEY_DOWNLOAD_STATUS java.lang.String());
                dVar.l(oldData.getProgress());
                dVar.o(oldData.getStatus());
                return dVar;
            }
        }
        z16 = false;
        if (!z16) {
        }
        int i162 = versionInfo.f427728a;
        String str112 = versionInfo.f427732e;
        Intrinsics.checkNotNullExpressionValue(str112, "versionInfo.cosURL");
        String str122 = versionInfo.f427731d;
        Intrinsics.checkNotNullExpressionValue(str122, "versionInfo.nowMapVer");
        d dVar2 = new d(new ZootopiaDownloadData(summaryData, new ZootopiaResData(i162, str112, str122, oldData.getData().getResData().getFilePath(), oldData.getData().getResData().getDownloadStatus(), versionInfo.f427734g, oldData.getData().getResData().getProgress(), oldData.getData().getResData().getCompleteTime(), oldData.getData().getResData().getStartTime(), ZPlanModVersionSimpleData.INSTANCE.b(versionInfo), oldData.getData().getResData().isSilentDownload(), oldData.getData().getResData().getNeedNotification(), ZPlanMapDiffPatchInfo.INSTANCE.b(versionInfo.f427742o)), oldData.getData().getExtraData()));
        dVar2.p(Boolean.valueOf(versionInfo.f427736i == 1));
        dVar2.k(Integer.valueOf(versionInfo.f427730c));
        dVar2.m(Integer.valueOf(versionInfo.f427729b));
        dVar2.j(oldData.getCom.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy.KEY_DOWNLOAD_STATUS java.lang.String());
        dVar2.l(oldData.getProgress());
        dVar2.o(oldData.getStatus());
        return dVar2;
    }

    public static /* synthetic */ void m0(a aVar, d dVar, Integer num, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                num = null;
            }
            aVar.l0(dVar, num);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: insert");
    }
}
