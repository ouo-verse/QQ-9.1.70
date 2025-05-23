package com.qzone.reborn.albumx.qzonex.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.qzone.album.base.Service.QzoneAlbumPicDownloadService;
import com.qzone.album.business.downloader.DownloadQueue;
import com.qzone.album.business.photolist.ui.menu.QZoneMakeVideoPopupMenu;
import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.misc.network.downloader.i;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.reborn.albumx.common.convert.bean.CommonStPicUrl;
import com.qzone.reborn.albumx.common.convert.enumtype.CommonEnumPhotoSpec;
import com.qzone.reborn.albumx.qzonex.view.u;
import com.tencent.aelight.camera.qqstory.api.IJumpUtil;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.album.QzonePhotoInfo;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.QZonePermission;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 Q2\u00020\u0001:\u0001&B/\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u0010,\u001a\u00020)\u0012\u0016\u00100\u001a\u0012\u0012\u0004\u0012\u00020-0\bj\b\u0012\u0004\u0012\u00020-`\n\u00a2\u0006\u0004\bO\u0010PJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J.\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J(\u0010\u0012\u001a\u00020\u00042\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00060\bj\b\u0012\u0004\u0012\u00020\u0006`\n2\u0006\u0010\u0011\u001a\u00020\u0002H\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\u0012\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\u0017\u001a\u00020\u0004H\u0002J<\u0010\u001d\u001a\u00020\u00042\u001e\u0010\u0018\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\bj\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u0001`\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u0004H\u0002J\b\u0010\u001f\u001a\u00020\u0004H\u0002J \u0010 \u001a\u00020\u00042\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00060\bj\b\u0012\u0004\u0012\u00020\u0006`\nH\u0002J\u0010\u0010\"\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\rH\u0002J*\u0010#\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u001a\u0010\u000b\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\t0\bj\n\u0012\u0006\u0012\u0004\u0018\u00010\t`\nJ\u0006\u0010$\u001a\u00020\u0004R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R$\u00100\u001a\u0012\u0012\u0004\u0012\u00020-0\bj\b\u0012\u0004\u0012\u00020-`\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010:\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00107R\u0018\u0010<\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u00107R*\u0010>\u001a\u0016\u0012\u0004\u0012\u00020-\u0018\u00010\bj\n\u0012\u0004\u0012\u00020-\u0018\u0001`\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010/R\u0018\u0010A\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R.\u0010C\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bj\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u0001`\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010/R\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010J\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010M\u00a8\u0006R"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/view/u;", "", "", "isRecommendEnable", "", "v", "", "p2vRecommendId", "Ljava/util/ArrayList;", "Lcom/qzone/album/data/model/PhotoCacheData;", "Lkotlin/collections/ArrayList;", "p2vRecommendList", "G", "", "resId", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "selectedDynamicMatterPath", "isFromRecommend", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "t", "r", "text", "P", "B", "videolist", "Lcom/qzone/misc/network/downloader/i$f;", "outerDownloadListener", "Landroid/content/DialogInterface$OnClickListener;", "onNegBtnClickListener", ReportConstant.COSTREPORT_PREFIX, "L", "N", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "albumType", "u", "M", "O", "Landroid/app/Activity;", "a", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "b", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "albumInfo", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", "c", "Ljava/util/ArrayList;", "mediaList", "Lcom/qzone/album/business/photolist/ui/menu/QZoneMakeVideoPopupMenu;", "d", "Lcom/qzone/album/business/photolist/ui/menu/QZoneMakeVideoPopupMenu;", "makeVideoPopupMenu", "Landroid/view/View$OnClickListener;", "e", "Landroid/view/View$OnClickListener;", "makePicVideoClickListener", "f", "videoRecommendClickListener", "g", "makeBlogClickListener", tl.h.F, "selectMediaList", "i", "Ljava/lang/String;", "mP2vRecommendId", "j", "mP2vRecommendList", "Landroid/app/Dialog;", "k", "Landroid/app/Dialog;", "viewWattingDialog", "l", "Z", "isDownLoadPhoto", "Lcom/qzone/album/base/Service/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/album/base/Service/a;", "mAlbumManager", "<init>", "(Landroid/app/Activity;Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;Ljava/util/ArrayList;)V", DomainData.DOMAIN_NAME, "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Activity activity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final CommonAlbumInfo albumInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<CommonStMedia> mediaList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private QZoneMakeVideoPopupMenu makeVideoPopupMenu;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View.OnClickListener makePicVideoClickListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View.OnClickListener videoRecommendClickListener;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private View.OnClickListener makeBlogClickListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ArrayList<CommonStMedia> selectMediaList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String mP2vRecommendId;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private ArrayList<PhotoCacheData> mP2vRecommendList;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private Dialog viewWattingDialog;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private boolean isDownLoadPhoto;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private com.qzone.album.base.Service.a mAlbumManager;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\r\u001a\u00020\u00072\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00020\nj\b\u0012\u0004\u0012\u00020\u0002`\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0002H\u0016\u00a8\u0006\u0010"}, d2 = {"com/qzone/reborn/albumx/qzonex/view/u$b", "Lcom/qzone/misc/network/downloader/i$f;", "", "url", "", "errorCode", "errorMsg", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, HippyTKDListViewAdapter.X, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "savedVideoPaths", "y", "videoPath", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements i.f {
        b() {
        }

        @Override // com.qzone.misc.network.downloader.i.f
        public void A(String url, int errorCode, String errorMsg) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            u.this.isDownLoadPhoto = false;
            com.qzone.album.env.common.a.m().W(com.qzone.util.l.a(R.string.gih), 1);
            u.this.r();
            u.this.t();
            com.qzone.album.env.common.a.m().b("QZAlbumxMakeVideoPopupWindow", "downloadVideo fail");
        }

        @Override // com.qzone.misc.network.downloader.i.f
        public void x(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            u.this.t();
        }

        @Override // com.qzone.misc.network.downloader.i.f
        public void y(ArrayList<String> savedVideoPaths) {
            Intrinsics.checkNotNullParameter(savedVideoPaths, "savedVideoPaths");
            u.this.z(savedVideoPaths, false);
            u.this.t();
        }

        @Override // com.qzone.misc.network.downloader.i.f
        public void z(String videoPath) {
            Intrinsics.checkNotNullParameter(videoPath, "videoPath");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0006j\b\u0012\u0004\u0012\u00020\u0002`\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/qzone/reborn/albumx/qzonex/view/u$c", "Lu4/f;", "", "url", "", "onDownloadFailed", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "savedPicPath", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c implements u4.f {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList<String> f53513b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ArrayList<String> f53514c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ArrayList<Integer> f53515d;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\r\u001a\u00020\u00072\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00020\nj\b\u0012\u0004\u0012\u00020\u0002`\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0002H\u0016\u00a8\u0006\u0010"}, d2 = {"com/qzone/reborn/albumx/qzonex/view/u$c$a", "Lcom/qzone/misc/network/downloader/i$f;", "", "url", "", "errorCode", "errorMsg", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, HippyTKDListViewAdapter.X, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "savedVideoPaths", "y", "videoPath", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes37.dex */
        public static final class a implements i.f {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ u f53516a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ ArrayList<Integer> f53517b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ ArrayList<String> f53518c;

            a(u uVar, ArrayList<Integer> arrayList, ArrayList<String> arrayList2) {
                this.f53516a = uVar;
                this.f53517b = arrayList;
                this.f53518c = arrayList2;
            }

            @Override // com.qzone.misc.network.downloader.i.f
            public void A(String url, int errorCode, String errorMsg) {
                Intrinsics.checkNotNullParameter(url, "url");
                Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                com.qzone.album.env.common.a.m().W(com.qzone.util.l.a(R.string.gkh), 1);
                this.f53516a.r();
                this.f53516a.t();
            }

            @Override // com.qzone.misc.network.downloader.i.f
            public void x(String url) {
                Intrinsics.checkNotNullParameter(url, "url");
                this.f53516a.t();
            }

            @Override // com.qzone.misc.network.downloader.i.f
            public void y(ArrayList<String> savedVideoPaths) {
                Intrinsics.checkNotNullParameter(savedVideoPaths, "savedVideoPaths");
                ArrayList arrayList = new ArrayList();
                if (this.f53517b.size() == 0) {
                    arrayList.addAll(this.f53518c);
                } else {
                    int size = this.f53518c.size() + savedVideoPaths.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        if (this.f53517b.contains(Integer.valueOf(i3)) && savedVideoPaths.size() > 0) {
                            arrayList.add(savedVideoPaths.get(0));
                            savedVideoPaths.remove(0);
                        } else if (this.f53518c.size() > 0) {
                            arrayList.add(this.f53518c.get(0));
                            this.f53518c.remove(0);
                        }
                    }
                }
                this.f53516a.t();
                this.f53516a.z(arrayList, false);
            }

            @Override // com.qzone.misc.network.downloader.i.f
            public void z(String videoPath) {
                Intrinsics.checkNotNullParameter(videoPath, "videoPath");
            }
        }

        c(ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<Integer> arrayList3) {
            this.f53513b = arrayList;
            this.f53514c = arrayList2;
            this.f53515d = arrayList3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(u this$0, DialogInterface dialogInterface, int i3) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.r();
            this$0.t();
        }

        @Override // com.qzone.album.base.Service.QzoneAlbumPicDownloadService.c
        public void a(String url, ArrayList<String> savedPicPath) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(savedPicPath, "savedPicPath");
            ArrayList arrayList = new ArrayList();
            int size = this.f53513b.size();
            for (int i3 = 0; i3 < size; i3++) {
                String p16 = QzoneAlbumPicDownloadService.p(this.f53513b.get(i3));
                if (p16 != null) {
                    arrayList.add(p16);
                } else {
                    com.qzone.album.env.common.a.m().b("QZAlbumxMakeVideoPopupWindow", "p2v picDownload - tempPath is null");
                }
            }
            if (this.f53514c.size() <= 0) {
                u.this.r();
                u.this.A(arrayList);
                u.this.t();
            } else {
                u uVar = u.this;
                ArrayList<String> arrayList2 = this.f53514c;
                a aVar = new a(uVar, this.f53515d, arrayList);
                final u uVar2 = u.this;
                uVar.s(arrayList2, aVar, new DialogInterface.OnClickListener() { // from class: com.qzone.reborn.albumx.qzonex.view.v
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i16) {
                        u.c.c(u.this, dialogInterface, i16);
                    }
                });
            }
        }

        @Override // com.qzone.album.base.Service.QzoneAlbumPicDownloadService.c
        public void onDownloadFailed(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            u.this.isDownLoadPhoto = false;
            com.qzone.album.env.common.a.m().W(com.qzone.util.l.a(R.string.gih), 1);
            u.this.r();
            com.qzone.album.env.common.a.m().b("QZAlbumxMakeVideoPopupWindow", "downloadImage fail");
            u.this.t();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0006j\b\u0012\u0004\u0012\u00020\u0002`\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/qzone/reborn/albumx/qzonex/view/u$e", "Lu4/f;", "", "url", "", "onDownloadFailed", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "savedPicPath", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class e implements u4.f {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList<String> f53521b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ArrayList<String> f53522c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ArrayList<Integer> f53523d;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\r\u001a\u00020\u00072\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00020\nj\b\u0012\u0004\u0012\u00020\u0002`\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0002H\u0016\u00a8\u0006\u0010"}, d2 = {"com/qzone/reborn/albumx/qzonex/view/u$e$a", "Lcom/qzone/misc/network/downloader/i$f;", "", "url", "", "errorCode", "errorMsg", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, HippyTKDListViewAdapter.X, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "savedVideoPaths", "y", "videoPath", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes37.dex */
        public static final class a implements i.f {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ u f53524a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ ArrayList<Integer> f53525b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ ArrayList<String> f53526c;

            a(u uVar, ArrayList<Integer> arrayList, ArrayList<String> arrayList2) {
                this.f53524a = uVar;
                this.f53525b = arrayList;
                this.f53526c = arrayList2;
            }

            @Override // com.qzone.misc.network.downloader.i.f
            public void A(String url, int errorCode, String errorMsg) {
                Intrinsics.checkNotNullParameter(url, "url");
                Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                com.qzone.album.env.common.a.m().W(com.qzone.util.l.a(R.string.gkh), 1);
                this.f53524a.t();
            }

            @Override // com.qzone.misc.network.downloader.i.f
            public void x(String url) {
                Intrinsics.checkNotNullParameter(url, "url");
            }

            @Override // com.qzone.misc.network.downloader.i.f
            public void y(ArrayList<String> savedVideoPaths) {
                Intrinsics.checkNotNullParameter(savedVideoPaths, "savedVideoPaths");
                ArrayList arrayList = new ArrayList();
                if (this.f53525b.size() == 0) {
                    arrayList.addAll(this.f53526c);
                } else {
                    int size = this.f53526c.size() + savedVideoPaths.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        if (this.f53525b.contains(Integer.valueOf(i3))) {
                            arrayList.add(savedVideoPaths.get(0));
                            savedVideoPaths.remove(0);
                        } else {
                            arrayList.add(this.f53526c.get(0));
                            this.f53526c.remove(0);
                        }
                    }
                }
                this.f53524a.z(arrayList, true);
                this.f53524a.t();
            }

            @Override // com.qzone.misc.network.downloader.i.f
            public void z(String videoPath) {
                Intrinsics.checkNotNullParameter(videoPath, "videoPath");
            }
        }

        e(ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<Integer> arrayList3) {
            this.f53521b = arrayList;
            this.f53522c = arrayList2;
            this.f53523d = arrayList3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(u this$0, DialogInterface dialogInterface, int i3) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.r();
            this$0.t();
        }

        @Override // com.qzone.album.base.Service.QzoneAlbumPicDownloadService.c
        public void a(String url, ArrayList<String> savedPicPath) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(savedPicPath, "savedPicPath");
            ArrayList arrayList = new ArrayList();
            int size = this.f53521b.size();
            for (int i3 = 0; i3 < size; i3++) {
                String p16 = QzoneAlbumPicDownloadService.p(this.f53521b.get(i3));
                if (p16 != null) {
                    arrayList.add(p16);
                } else {
                    com.qzone.album.env.common.a.m().b("[PhotoAlbum] BasePhotoModelController", "p2v picDownload - tempPath is null");
                }
            }
            if (this.f53522c.size() <= 0) {
                u.this.z(arrayList, true);
                u.this.t();
                return;
            }
            u uVar = u.this;
            ArrayList<String> arrayList2 = this.f53522c;
            a aVar = new a(uVar, this.f53523d, arrayList);
            final u uVar2 = u.this;
            uVar.s(arrayList2, aVar, new DialogInterface.OnClickListener() { // from class: com.qzone.reborn.albumx.qzonex.view.w
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i16) {
                    u.e.c(u.this, dialogInterface, i16);
                }
            });
        }

        @Override // com.qzone.album.base.Service.QzoneAlbumPicDownloadService.c
        public void onDownloadFailed(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            u.this.isDownLoadPhoto = false;
            com.qzone.album.env.common.a.m().W(com.qzone.util.l.a(R.string.gih), 1);
            u.this.r();
            com.qzone.album.env.common.a.m().b("[PhotoAlbum] BasePhotoModelController", "Recommend downloadImage fail");
            u.this.t();
        }
    }

    public u(Activity activity, CommonAlbumInfo albumInfo, ArrayList<CommonStMedia> mediaList) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(albumInfo, "albumInfo");
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        this.activity = activity;
        this.albumInfo = albumInfo;
        this.mediaList = mediaList;
        com.qzone.album.base.Service.a W = com.qzone.album.base.Service.a.W();
        Intrinsics.checkNotNullExpressionValue(W, "getInstance()");
        this.mAlbumManager = W;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(ArrayList<String> selectedDynamicMatterPath) {
        com.qzone.util.image.c.j(selectedDynamicMatterPath);
        qo.c.e(this.activity, com.qzone.util.image.c.p(this.activity, selectedDynamicMatterPath));
    }

    private final void B() {
        ArrayList<CommonStMedia> arrayList = this.selectMediaList;
        if (arrayList == null) {
            return;
        }
        LpReportInfo_pf00064.allReport(326, 2, 36);
        final ArrayList arrayList2 = new ArrayList();
        if (!FeedGlobalEnv.g().isNetworkAvailable(null)) {
            com.qzone.album.env.common.a.m().V(com.qzone.util.l.a(R.string.ci5));
            return;
        }
        if (arrayList.size() <= 0) {
            return;
        }
        final ArrayList arrayList3 = new ArrayList();
        final ArrayList arrayList4 = new ArrayList();
        int i3 = 0;
        for (Object obj : arrayList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            CommonStMedia commonStMedia = (CommonStMedia) obj;
            if (!commonStMedia.u()) {
                arrayList3.add(commonStMedia.l());
            } else if (commonStMedia.getVideo().getVideoTime() > PeakConstants.SHORT_VIDEO_DURATION_UPPER_BOUND) {
                com.qzone.reborn.util.o.f59556a.b("\u89c6\u9891\u4e0d\u80fd\u8d85\u8fc716\u79d2");
                return;
            } else {
                arrayList2.add(Integer.valueOf(i3));
                arrayList4.add(commonStMedia.l());
            }
            i3 = i16;
        }
        if (arrayList3.size() == 0 && arrayList4.size() == 0) {
            Q(R.string.gih);
            com.qzone.album.env.common.a.m().b("QZAlbumxMakeVideoPopupWindow", "mPiclist.size() == 0 && mVideolist.size() is null");
            return;
        }
        P(com.qzone.util.l.a(R.string.gii));
        Dialog dialog = this.viewWattingDialog;
        if (dialog != null) {
            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.qzone.reborn.albumx.qzonex.view.q
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    u.F(u.this, arrayList3, dialogInterface);
                }
            });
        }
        DownloadQueue.j().B();
        if (arrayList3.size() <= 0 && arrayList4.size() > 0) {
            com.qzone.album.env.common.a.m().J(new Runnable() { // from class: com.qzone.reborn.albumx.qzonex.view.r
                @Override // java.lang.Runnable
                public final void run() {
                    u.C(u.this, arrayList4);
                }
            });
        } else {
            com.qzone.album.env.common.a.m().J(new Runnable() { // from class: com.qzone.reborn.albumx.qzonex.view.s
                @Override // java.lang.Runnable
                public final void run() {
                    u.E(u.this, arrayList3, arrayList4, arrayList2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(final u this$0, ArrayList videoList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(videoList, "$videoList");
        this$0.isDownLoadPhoto = true;
        this$0.s(videoList, new b(), new DialogInterface.OnClickListener() { // from class: com.qzone.reborn.albumx.qzonex.view.k
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                u.D(u.this, dialogInterface, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(u this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.r();
        this$0.t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(u this$0, ArrayList picList, ArrayList videoList, ArrayList videoIndex) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(picList, "$picList");
        Intrinsics.checkNotNullParameter(videoList, "$videoList");
        Intrinsics.checkNotNullParameter(videoIndex, "$videoIndex");
        this$0.isDownLoadPhoto = true;
        u4.a z16 = u4.a.z();
        Activity activity = this$0.activity;
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(currentTimeMillis);
        z16.t(activity, sb5.toString(), picList, new c(picList, videoList, videoIndex));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(u this$0, ArrayList picList, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(picList, "$picList");
        if (this$0.isDownLoadPhoto) {
            u4.a.z().k(picList);
            this$0.isDownLoadPhoto = false;
        }
    }

    private final void G(String p2vRecommendId, ArrayList<PhotoCacheData> p2vRecommendList) {
        VideoInfo videoInfo;
        final ArrayList arrayList = new ArrayList();
        if (!FeedGlobalEnv.g().isNetworkAvailable(null)) {
            com.qzone.album.env.common.a.m().V(com.qzone.util.l.a(R.string.ci5));
            t();
            return;
        }
        if (p2vRecommendList == null || p2vRecommendList.isEmpty()) {
            t();
            return;
        }
        LpReportInfo_pf00064.allReport(326, 2, 38);
        final ArrayList arrayList2 = new ArrayList();
        final ArrayList arrayList3 = new ArrayList();
        Intrinsics.checkNotNull(p2vRecommendList);
        int size = p2vRecommendList.size();
        for (int i3 = 0; i3 < size; i3++) {
            PhotoCacheData photoCacheData = p2vRecommendList.get(i3);
            Intrinsics.checkNotNullExpressionValue(photoCacheData, "p2vRecommendList[i]");
            PhotoCacheData photoCacheData2 = photoCacheData;
            if (photoCacheData2.videoflag == 1 && (videoInfo = photoCacheData2.videodata) != null && videoInfo.videoUrl != null) {
                arrayList.add(Integer.valueOf(i3));
                arrayList3.add(photoCacheData2.videodata.videoUrl.url);
                String str = photoCacheData2.videodata.videoUrl.url;
                if (str == null || str.length() == 0) {
                    com.qzone.album.env.common.a.m().b("QZAlbumxMakeVideoPopupWindow", "Recommend cache.videodata.videoUrl.url is null");
                }
            } else {
                PictureUrl picUrlDec = photoCacheData2.picItem.getPicUrlDec();
                if (picUrlDec != null) {
                    String str2 = picUrlDec.url;
                    if (!(str2 == null || str2.length() == 0)) {
                        arrayList2.add(picUrlDec.url);
                    }
                }
                com.qzone.album.env.common.a.m().b("[PhotoAlbum] BasePhotoModelController", "Recommend cache.picItem.getPicUrlDec() is null");
            }
        }
        if (arrayList2.size() == 0 && arrayList3.size() == 0) {
            Q(R.string.gih);
            com.qzone.album.env.common.a.m().b("[PhotoAlbum] BasePhotoModelController", "Recommend mPiclist.size() == 0 && mVideolist.size() is null");
            return;
        }
        P(com.qzone.util.l.a(R.string.gii));
        Dialog dialog = this.viewWattingDialog;
        if (dialog != null) {
            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.qzone.reborn.albumx.qzonex.view.n
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    u.H(u.this, arrayList2, dialogInterface);
                }
            });
        }
        if (arrayList2.size() <= 0 && arrayList3.size() > 0) {
            com.qzone.album.env.common.a.m().J(new Runnable() { // from class: com.qzone.reborn.albumx.qzonex.view.o
                @Override // java.lang.Runnable
                public final void run() {
                    u.I(u.this, arrayList3);
                }
            });
        } else {
            com.qzone.album.env.common.a.m().J(new Runnable() { // from class: com.qzone.reborn.albumx.qzonex.view.p
                @Override // java.lang.Runnable
                public final void run() {
                    u.K(u.this, arrayList2, arrayList3, arrayList);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(u this$0, ArrayList mPiclist, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(mPiclist, "$mPiclist");
        if (this$0.isDownLoadPhoto) {
            u4.a.z().k(mPiclist);
            this$0.isDownLoadPhoto = false;
        }
        this$0.t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(final u this$0, ArrayList mVideolist) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(mVideolist, "$mVideolist");
        this$0.isDownLoadPhoto = true;
        this$0.s(mVideolist, new d(), new DialogInterface.OnClickListener() { // from class: com.qzone.reborn.albumx.qzonex.view.t
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                u.J(u.this, dialogInterface, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(u this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.r();
        this$0.t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(u this$0, ArrayList mPiclist, ArrayList mVideolist, ArrayList videoIndex) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(mPiclist, "$mPiclist");
        Intrinsics.checkNotNullParameter(mVideolist, "$mVideolist");
        Intrinsics.checkNotNullParameter(videoIndex, "$videoIndex");
        this$0.isDownLoadPhoto = true;
        u4.a z16 = u4.a.z();
        Activity activity = this$0.activity;
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(currentTimeMillis);
        z16.t(activity, sb5.toString(), mPiclist, new e(mPiclist, mVideolist, videoIndex));
    }

    private final void P(String text) {
        TextView textView;
        Dialog dialog = this.viewWattingDialog;
        if (dialog != null) {
            Intrinsics.checkNotNull(dialog);
            if (dialog.isShowing()) {
                return;
            }
        }
        if (this.viewWattingDialog == null) {
            ReportDialog reportDialog = new ReportDialog(this.activity, R.style.f174269ui);
            this.viewWattingDialog = reportDialog;
            Intrinsics.checkNotNull(reportDialog);
            reportDialog.setContentView(R.layout.bqd);
            Dialog dialog2 = this.viewWattingDialog;
            Intrinsics.checkNotNull(dialog2);
            textView = (TextView) dialog2.findViewById(R.id.f20398_);
            Dialog dialog3 = this.viewWattingDialog;
            Intrinsics.checkNotNull(dialog3);
            dialog3.findViewById(R.id.kja).setVisibility(8);
            Dialog dialog4 = this.viewWattingDialog;
            Intrinsics.checkNotNull(dialog4);
            dialog4.findViewById(R.id.cib).setVisibility(0);
        } else {
            textView = null;
        }
        if (textView != null) {
            textView.setText(text);
        }
        try {
            Dialog dialog5 = this.viewWattingDialog;
            Intrinsics.checkNotNull(dialog5);
            dialog5.show();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private final void Q(int resId) {
        u4.a.z().r0(resId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r() {
        try {
            Dialog dialog = this.viewWattingDialog;
            if (dialog == null || dialog == null) {
                return;
            }
            dialog.dismiss();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(ArrayList<String> videolist, i.f outerDownloadListener, DialogInterface.OnClickListener onNegBtnClickListener) {
        QLog.d("QZAlbumxMakeVideoPopupWindow", 1, "downloadVideo: " + com.qzone.util.f.c(videolist));
        com.qzone.misc.network.downloader.i.u().p(videolist, outerDownloadListener, onNegBtnClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t() {
        DownloadQueue.j().f();
    }

    private final void v(boolean isRecommendEnable) {
        this.makeVideoPopupMenu = new QZoneMakeVideoPopupMenu(this.activity, this.albumInfo.getQzAlbumType());
        this.makePicVideoClickListener = new View.OnClickListener() { // from class: com.qzone.reborn.albumx.qzonex.view.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                u.w(u.this, view);
            }
        };
        this.videoRecommendClickListener = new View.OnClickListener() { // from class: com.qzone.reborn.albumx.qzonex.view.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                u.x(u.this, view);
            }
        };
        this.makeBlogClickListener = new View.OnClickListener() { // from class: com.qzone.reborn.albumx.qzonex.view.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                u.y(u.this, view);
            }
        };
        QZoneMakeVideoPopupMenu qZoneMakeVideoPopupMenu = this.makeVideoPopupMenu;
        if (qZoneMakeVideoPopupMenu != null) {
            qZoneMakeVideoPopupMenu.f(isRecommendEnable);
        }
        QZoneMakeVideoPopupMenu qZoneMakeVideoPopupMenu2 = this.makeVideoPopupMenu;
        if (qZoneMakeVideoPopupMenu2 != null) {
            qZoneMakeVideoPopupMenu2.t(this.mP2vRecommendId, this.mP2vRecommendList);
        }
        QZoneMakeVideoPopupMenu qZoneMakeVideoPopupMenu3 = this.makeVideoPopupMenu;
        if (qZoneMakeVideoPopupMenu3 != null) {
            qZoneMakeVideoPopupMenu3.w();
        }
        QZoneMakeVideoPopupMenu qZoneMakeVideoPopupMenu4 = this.makeVideoPopupMenu;
        if (qZoneMakeVideoPopupMenu4 != null) {
            qZoneMakeVideoPopupMenu4.s(QZoneMakeVideoPopupMenu.f43658w, this.videoRecommendClickListener);
        }
        QZoneMakeVideoPopupMenu qZoneMakeVideoPopupMenu5 = this.makeVideoPopupMenu;
        if (qZoneMakeVideoPopupMenu5 != null) {
            qZoneMakeVideoPopupMenu5.s(QZoneMakeVideoPopupMenu.f43659x, this.makePicVideoClickListener);
        }
        QZoneMakeVideoPopupMenu qZoneMakeVideoPopupMenu6 = this.makeVideoPopupMenu;
        if (qZoneMakeVideoPopupMenu6 != null) {
            qZoneMakeVideoPopupMenu6.s(QZoneMakeVideoPopupMenu.f43660y, this.makeBlogClickListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(u this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (qo.c.c()) {
            QLog.e("[PhotoAlbum] BasePhotoModelController", 1, "makePicVideoClickListener onClick block by res not ready!");
            QZoneMakeVideoPopupMenu qZoneMakeVideoPopupMenu = this$0.makeVideoPopupMenu;
            if (qZoneMakeVideoPopupMenu != null) {
                qZoneMakeVideoPopupMenu.e();
            }
        } else {
            this$0.B();
            QZoneMakeVideoPopupMenu qZoneMakeVideoPopupMenu2 = this$0.makeVideoPopupMenu;
            if (qZoneMakeVideoPopupMenu2 != null) {
                qZoneMakeVideoPopupMenu2.e();
            }
            LpReportInfo_pf00064.allReport(326, 2, 60);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(u this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (QZonePermission.requestStoragePermission(this$0.activity, QQPermissionConstants.Business.SCENE.QQ_QZONE_VIDEO_EDIT_READ_MEDIA)) {
            QZoneMakeVideoPopupMenu qZoneMakeVideoPopupMenu = this$0.makeVideoPopupMenu;
            if (qZoneMakeVideoPopupMenu != null) {
                qZoneMakeVideoPopupMenu.e();
            }
            DownloadQueue.j().B();
            this$0.N();
            QZoneMakeVideoPopupMenu qZoneMakeVideoPopupMenu2 = this$0.makeVideoPopupMenu;
            String j3 = qZoneMakeVideoPopupMenu2 != null ? qZoneMakeVideoPopupMenu2.j() : null;
            QZoneMakeVideoPopupMenu qZoneMakeVideoPopupMenu3 = this$0.makeVideoPopupMenu;
            this$0.G(j3, qZoneMakeVideoPopupMenu3 != null ? qZoneMakeVideoPopupMenu3.i() : null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(u this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LpReportInfo_pf00064.allReport(326, 2, 47);
        this$0.L();
        QZoneMakeVideoPopupMenu qZoneMakeVideoPopupMenu = this$0.makeVideoPopupMenu;
        if (qZoneMakeVideoPopupMenu != null) {
            qZoneMakeVideoPopupMenu.e();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void M(String p2vRecommendId, ArrayList<PhotoCacheData> p2vRecommendList) {
        Intrinsics.checkNotNullParameter(p2vRecommendId, "p2vRecommendId");
        Intrinsics.checkNotNullParameter(p2vRecommendList, "p2vRecommendList");
        QZLog.d("QZP2V", 4, "onGetP2VRecommendData:" + p2vRecommendId + ";size:" + p2vRecommendList.size());
        this.mP2vRecommendId = p2vRecommendId;
        this.mP2vRecommendList = p2vRecommendList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(ArrayList<String> selectedDynamicMatterPath, boolean isFromRecommend) {
        this.isDownLoadPhoto = false;
        com.qzone.util.image.c.j(selectedDynamicMatterPath);
        ArrayList<LocalMediaInfo> p16 = com.qzone.util.image.c.p(this.activity, selectedDynamicMatterPath);
        r();
        if (p16.size() == 0) {
            com.qzone.album.env.common.a.m().U(R.string.gin);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("qzone_slide_show_matters", p16);
        bundle.putInt("edit_video_type", 10001);
        bundle.putInt("qq_sub_business_id", 3);
        bundle.putInt("qqstory_slide_show_scene", 22);
        bundle.putInt("entrance_qzone_p2v", 17);
        ((IJumpUtil) QRoute.api(IJumpUtil.class)).jumpToSlideShowEditVideoActivityForQzone(this.activity, bundle);
    }

    public final void O() {
        v(false);
        QZoneMakeVideoPopupMenu qZoneMakeVideoPopupMenu = this.makeVideoPopupMenu;
        if (qZoneMakeVideoPopupMenu != null) {
            qZoneMakeVideoPopupMenu.g();
        }
        this.selectMediaList = this.mediaList;
        if (this.activity.isFinishing()) {
            return;
        }
        QZoneMakeVideoPopupMenu qZoneMakeVideoPopupMenu2 = this.makeVideoPopupMenu;
        if (qZoneMakeVideoPopupMenu2 != null) {
            View peekDecorView = this.activity.getWindow().peekDecorView();
            qZoneMakeVideoPopupMenu2.v(peekDecorView != null ? peekDecorView.findViewById(android.R.id.content) : null);
        }
        com.qzone.album.env.common.a.m().P(326, 2, "32", true, u(this.albumInfo.getQzAlbumType()));
    }

    private final void L() {
        LpReportInfo_pf00064.allReport(326, 2, 48);
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        ArrayList<CommonStMedia> arrayList2 = this.selectMediaList;
        if (arrayList2 != null) {
            for (CommonStMedia commonStMedia : arrayList2) {
                QzonePhotoInfo qzonePhotoInfo = new QzonePhotoInfo();
                CommonStPicUrl d16 = aa.e.f25753a.d(commonStMedia.getImage().e(), CommonEnumPhotoSpec.PHOTO_SPEC_ORIGIN);
                if (d16 != null) {
                    qzonePhotoInfo.mAlbumId = this.albumInfo.getAlbumId();
                    qzonePhotoInfo.mBigUrl = d16.getUrl();
                    qzonePhotoInfo.mBigHeight = d16.getHeight();
                    qzonePhotoInfo.mBigWidth = d16.getWidth();
                    qzonePhotoInfo.mlloc = commonStMedia.k();
                    qzonePhotoInfo.mShootTime = commonStMedia.getShootTime();
                    qzonePhotoInfo.mUploadTime = commonStMedia.getUploadTime();
                    arrayList.add(qzonePhotoInfo);
                }
            }
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean(RemoteHandleConst.PARAM_DYNAMIC_IS_FROM_ALBUM, true);
        bundle.putBoolean(RemoteHandleConst.PARAM_DYNAMIC_IS_FROM_MAKE_BLOG, true);
        bundle.putString(QZoneHelper.QZonePersonalAlbumContants.KEY_ALBUM_ID, this.albumInfo.getAlbumId());
        bundle.putInt(QZoneHelper.QZoneAlbumConstants.QZ_ALBUM_THEME, this.albumInfo.getQzAlbumType());
        bundle.putInt(QZoneHelper.QZoneAlbumConstants.QZ_ALBUM_SORT_TYPE, 3);
        bundle.putParcelableArrayList(RemoteHandleConst.PARAM_DYNAMIC_CLOUD_PHOTOLIST, arrayList);
        com.qzone.reborn.util.i.b().q("get_dynamic_photo_" + RFWApplication.getAccountId(), bundle);
        yo.d.d(o7.a.f422175b, this.activity, null);
    }

    private final String u(int albumType) {
        if (albumType == 8) {
            return HippyNestedScrollComponent.PRIORITY_PARENT;
        }
        if (albumType == 9) {
            return "travel";
        }
        if (albumType != 11) {
            return "common";
        }
        return "lover";
    }

    private final void N() {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J \u0010\r\u001a\u00020\u00072\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00020\nj\b\u0012\u0004\u0012\u00020\u0002`\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0002H\u0016\u00a8\u0006\u0010"}, d2 = {"com/qzone/reborn/albumx/qzonex/view/u$d", "Lcom/qzone/misc/network/downloader/i$f;", "", "url", "", "errorCode", "errorMsg", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, HippyTKDListViewAdapter.X, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "savedVideoPaths", "y", "videoPath", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class d implements i.f {
        d() {
        }

        @Override // com.qzone.misc.network.downloader.i.f
        public void A(String url, int errorCode, String errorMsg) {
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            u.this.isDownLoadPhoto = false;
            com.qzone.album.env.common.a.m().W(com.qzone.util.l.a(R.string.gih), 1);
            u.this.r();
            com.qzone.album.env.common.a.m().b("[PhotoAlbum] BasePhotoModelController", "Recommend downloadVideo fail");
            u.this.t();
        }

        @Override // com.qzone.misc.network.downloader.i.f
        public void y(ArrayList<String> savedVideoPaths) {
            Intrinsics.checkNotNullParameter(savedVideoPaths, "savedVideoPaths");
            u.this.z(savedVideoPaths, true);
            u.this.t();
        }

        @Override // com.qzone.misc.network.downloader.i.f
        public void z(String videoPath) {
            Intrinsics.checkNotNullParameter(videoPath, "videoPath");
        }

        @Override // com.qzone.misc.network.downloader.i.f
        public void x(String url) {
        }
    }
}
