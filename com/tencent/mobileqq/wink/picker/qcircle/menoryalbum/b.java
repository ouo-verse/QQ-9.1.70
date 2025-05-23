package com.tencent.mobileqq.wink.picker.qcircle.menoryalbum;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.newalbum.collector.WinkNewMemoryAlbumResult;
import com.tencent.mobileqq.wink.newalbum.database.WinkNewAlbumDatabaseImp;
import com.tencent.mobileqq.wink.picker.core.ktx.ViewExKt;
import com.tencent.mobileqq.wink.sdk.Wink;
import com.tencent.mobileqq.wink.templatelibrary.memoryalbum.data.WinkAlbumItemWrapper;
import com.tencent.mobileqq.wink.templatelibrary.memoryalbum.viewmodel.WinkAlbumDataViewModel;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 32\u00020\u0001:\u00014B\u0019\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010&\u001a\u0004\u0018\u00010#\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\u0007H\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0002J&\u0010\u0015\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\u001c\u0010\u0016\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\u0018\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002JV\u0010\"\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001b2!\u0010 \u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00070\u001d2!\u0010!\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00070\u001dH\u0016R\u0016\u0010&\u001a\u0004\u0018\u00010#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010*\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010(R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00100\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qcircle/menoryalbum/b;", "Lcom/tencent/mobileqq/wink/picker/core/b;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/view/View;", "itemView", "uiStatus", "", "r", "", "isExpose", DomainData.DOMAIN_NAME, "p", "v", "t", "Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/data/a;", "data", "Landroid/widget/ImageView;", "bgView", "Landroid/widget/TextView;", "recommendText", "u", "w", "albumItem", "", "startTime", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "localMedia", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "onItemClick", "onItemSelect", "l", "Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/viewmodel/WinkAlbumDataViewModel;", "E", "Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/viewmodel/WinkAlbumDataViewModel;", "albumDataViewModel", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "G", "maskIv", "H", "Landroid/widget/TextView;", "I", "J", "Z", "needReport", "<init>", "(Landroid/view/View;Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/viewmodel/WinkAlbumDataViewModel;)V", "K", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b extends com.tencent.mobileqq.wink.picker.core.b {

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private final WinkAlbumDataViewModel albumDataViewModel;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private ImageView bgView;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private ImageView maskIv;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private TextView recommendText;

    /* renamed from: I, reason: from kotlin metadata */
    private final long startTime;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean needReport;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull View itemView, @Nullable WinkAlbumDataViewModel winkAlbumDataViewModel) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        this.albumDataViewModel = winkAlbumDataViewModel;
        this.bgView = (ImageView) itemView.findViewById(R.id.z2u);
        this.maskIv = (ImageView) itemView.findViewById(R.id.f166229z30);
        this.recommendText = (TextView) itemView.findViewById(R.id.z36);
        this.startTime = System.currentTimeMillis();
        this.needReport = true;
    }

    private final void n(boolean isExpose, int uiStatus) {
        String str;
        String str2;
        String str3 = "0";
        if (uiStatus == 3) {
            str = "1";
        } else if (uiStatus != 4) {
            str = "0";
        } else {
            str = "2";
        }
        WinkPublishQualityReportData.Builder eventId = new WinkPublishQualityReportData.Builder().eventId("WE_E_CLIP_PICKER_MEMORY_ENTER_INFO");
        if (!isExpose) {
            str2 = "0";
        } else {
            str2 = "1";
        }
        WinkPublishQualityReportData.Builder ext1 = eventId.ext1(str2);
        if (uiStatus != 0) {
            str3 = "1";
        }
        WinkPublishQualityReportData reportData = ext1.ext2(str3).ext3(str).attachInfo("Peak").getReportData();
        z93.c f16 = Wink.INSTANCE.f();
        if (f16 != null) {
            f16.a(reportData, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(Function1 onItemClick, b this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(onItemClick, "$onItemClick");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        onItemClick.invoke(it);
        this$0.n(false, this$0.q());
        EventCollector.getInstance().onViewClicked(it);
    }

    private final void p(View itemView, int uiStatus) {
        int i3;
        Map<String, Object> reportMap = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(reportMap, "reportMap");
        reportMap.put("dt_pgid", "pg_xsj_choose_media_new_page");
        reportMap.put("xsj_custom_pgid", "pg_xsj_choose_media_new_page");
        reportMap.put("dt_eid", WinkDaTongReportConstant.ElementId.EM_XSJ_MEMORIES_ALBUM_ENTRANCE);
        reportMap.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_XSJ_MEMORIES_ALBUM_ENTRANCE);
        if (uiStatus == 0) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        reportMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_AUTHORIZE_MEMORIES_COLLECTION, Integer.valueOf(i3));
        VideoReport.setElementId(itemView, WinkDaTongReportConstant.ElementId.EM_XSJ_MEMORIES_ALBUM_ENTRANCE);
        VideoReport.setElementParams(itemView, reportMap);
    }

    private final int q() {
        WinkAlbumItemWrapper winkAlbumItemWrapper;
        LiveData<Boolean> P1;
        LiveData<List<WinkAlbumItemWrapper>> Q1;
        List<WinkAlbumItemWrapper> value;
        Object firstOrNull;
        boolean z16 = false;
        if (!v83.e.f441245a.f()) {
            return 0;
        }
        WinkAlbumDataViewModel winkAlbumDataViewModel = this.albumDataViewModel;
        if (winkAlbumDataViewModel != null && (Q1 = winkAlbumDataViewModel.Q1()) != null && (value = Q1.getValue()) != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) value);
            winkAlbumItemWrapper = (WinkAlbumItemWrapper) firstOrNull;
        } else {
            winkAlbumItemWrapper = null;
        }
        if (winkAlbumItemWrapper != null) {
            if (winkAlbumItemWrapper.getWinkMemoryAlbum() != null) {
                return 3;
            }
            if (winkAlbumItemWrapper.getWinkNewAlbum() != null) {
                return 4;
            }
        }
        WinkAlbumDataViewModel winkAlbumDataViewModel2 = this.albumDataViewModel;
        if (winkAlbumDataViewModel2 != null && (P1 = winkAlbumDataViewModel2.P1()) != null) {
            z16 = Intrinsics.areEqual(P1.getValue(), Boolean.TRUE);
        }
        if (z16) {
            return 2;
        }
        return 1;
    }

    private final void r(View itemView, int uiStatus) {
        n(true, uiStatus);
        p(itemView, uiStatus);
    }

    private final void s(WinkAlbumItemWrapper albumItem, long startTime) {
        String str;
        String str2;
        String str3;
        String str4;
        int i3;
        String str5;
        Float firstOrNull;
        if (!this.needReport) {
            return;
        }
        this.needReport = false;
        long currentTimeMillis = System.currentTimeMillis() - startTime;
        WinkNewMemoryAlbumResult winkNewAlbum = albumItem.getWinkNewAlbum();
        if (winkNewAlbum != null) {
            str3 = winkNewAlbum.getCom.tencent.tmdownloader.internal.storage.table.CacheTable.TABLE_NAME java.lang.String().getTraceID();
            str4 = winkNewAlbum.getAlbumID();
            str5 = winkNewAlbum.getAlbumID();
            i3 = winkNewAlbum.getExposeTimes();
            firstOrNull = ArraysKt___ArraysKt.firstOrNull(winkNewAlbum.getCom.tencent.tmdownloader.internal.storage.table.CacheTable.TABLE_NAME java.lang.String().getTextSimilaritys());
            str = String.valueOf(firstOrNull);
            str2 = "1";
        } else {
            s53.a winkMemoryAlbum = albumItem.getWinkMemoryAlbum();
            str = "";
            str2 = "0";
            if (winkMemoryAlbum == null) {
                str3 = "";
                str4 = str3;
                i3 = 0;
                str5 = str4;
            } else {
                str4 = winkMemoryAlbum.getId();
                str3 = "";
                i3 = 0;
                str5 = str3;
            }
        }
        WinkPublishQualityReportData reportData = new WinkPublishQualityReportData.Builder().eventId("WE_E_CLIP_PICKER_SHOW_MEMORY_RESULT").traceId(str3).ext1(String.valueOf(currentTimeMillis)).ext2(str2).ext3(str4).ext4(str).attachInfo("Peak").getReportData();
        z93.c f16 = Wink.INSTANCE.f();
        if (f16 != null) {
            f16.a(reportData, 1);
        }
        new WinkNewAlbumDatabaseImp().U(str5, i3 + 1);
    }

    private final void t() {
        ImageView imageView = this.maskIv;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        ImageView imageView2 = this.bgView;
        if (imageView2 != null) {
            imageView2.setImageResource(R.drawable.ntf);
        }
        TextView textView = this.recommendText;
        if (textView != null) {
            textView.setText("\u56de\u5fc6\u5f71\u96c6\u751f\u6210\u4e2d");
        }
    }

    private final void u(WinkAlbumItemWrapper data, ImageView bgView, TextView recommendText) {
        LocalMediaInfo a16;
        if (data == null || (a16 = data.a()) == null) {
            return;
        }
        w53.b.f("MemoryAlbumFirstItemViewHolder", "showMemoryAlbum... coverPath:" + a16.path);
        if (bgView != null) {
            ViewExKt.n(bgView, a16);
        }
        ImageView imageView = this.maskIv;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        if (recommendText != null) {
            recommendText.setText("\u4e3a\u4f60\u751f\u6210\u591a\u7bc7\u56de\u5fc6");
        }
        s(data, this.startTime);
    }

    private final void v() {
        ImageView imageView = this.maskIv;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        ImageView imageView2 = this.bgView;
        if (imageView2 != null) {
            imageView2.setImageResource(R.drawable.ntf);
        }
        TextView textView = this.recommendText;
        if (textView != null) {
            textView.setText("\u5f00\u542f\u63a8\u8350\u56de\u5fc6\u5f71\u96c6");
        }
    }

    private final void w(ImageView bgView, TextView recommendText) {
        if (bgView != null) {
            bgView.setImageResource(R.drawable.ntf);
        }
        ImageView imageView = this.maskIv;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        if (recommendText != null) {
            recommendText.setText("\u6682\u65e0\u53ef\u751f\u6210\u56de\u5fc6");
        }
    }

    @Override // com.tencent.mobileqq.wink.picker.core.b
    public void l(@NotNull LocalMediaInfo localMedia, @NotNull final Function1<? super View, Unit> onItemClick, @NotNull Function1<? super View, Unit> onItemSelect) {
        WinkAlbumItemWrapper winkAlbumItemWrapper;
        LiveData<List<WinkAlbumItemWrapper>> Q1;
        List<WinkAlbumItemWrapper> value;
        Object firstOrNull;
        Intrinsics.checkNotNullParameter(localMedia, "localMedia");
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
        Intrinsics.checkNotNullParameter(onItemSelect, "onItemSelect");
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.qcircle.menoryalbum.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b.o(Function1.this, this, view);
            }
        });
        int q16 = q();
        w53.b.f("MemoryAlbumFirstItemViewHolder", "bindData, uiStatus=" + q16);
        if (q16 != 0) {
            if (q16 != 1) {
                if (q16 != 2) {
                    if (q16 == 3 || q16 == 4) {
                        WinkAlbumDataViewModel winkAlbumDataViewModel = this.albumDataViewModel;
                        if (winkAlbumDataViewModel != null && (Q1 = winkAlbumDataViewModel.Q1()) != null && (value = Q1.getValue()) != null) {
                            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) value);
                            winkAlbumItemWrapper = (WinkAlbumItemWrapper) firstOrNull;
                        } else {
                            winkAlbumItemWrapper = null;
                        }
                        w53.b.f("MemoryAlbumFirstItemViewHolder", "bindData, coverAlbum:" + winkAlbumItemWrapper);
                        u(winkAlbumItemWrapper, this.bgView, this.recommendText);
                    }
                } else {
                    w(this.bgView, this.recommendText);
                }
            } else {
                t();
            }
        } else {
            v();
        }
        View itemView = this.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        r(itemView, q16);
    }
}
